package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento do cedente -(EXTRATO)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class MCExtraManterFiltroAntigo extends MCExtraEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        int paginaAtual = 1;
        try {
            paginaAtual = Integer.parseInt(request.getParameter("pagina"));
        } catch (Exception e) {
        }
        int paginaFinal = 1;
        try {
        	paginaFinal = Integer.parseInt(request.getParameter("paginaFinal"));
        } catch (Exception e) {
        }

        request.setAttribute("codigoCedente", request.getParameter("codigoCedente"));
        request.setAttribute("dataEmissao", request.getParameter("dataEmissao"));
        request.setAttribute("pagTroca", String.valueOf(paginaAtual));

        String fluxo = getFluxo(request);

        ConGerMovimentoCedenteBean mcextraBean = new ConGerMovimentoCedenteBean();
        ConGerMovimentoCedenteBean debCredBean = new ConGerMovimentoCedenteBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            mcextraBean = (ConGerMovimentoCedenteBean) mcextraBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
        } else {
            mcextraBean = (ConGerMovimentoCedenteBean) mcextraBean.getSessionBean(request,
                    BEAN_FILTRO);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    BEAN_CABECALHO);
        }

        // EAM2907
        request.getSession().setAttribute(CEDENTE_ATUAL,
                mcextraBean.getCodigoCedente());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        LogUtilSigcb.info("ANTES DA BGB0");
        /* BGM0 */// - Obtem dados do cabeçalho do Cedente no SICLI
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(mcextraBean.getCodigoCedente());
        cedCabBean.setOrigemConsulta(new Long(1));

        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,  TRANSACAO_CEDENTE);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(mcextraBean.getCodigoCedente());
        request.getSession().setAttribute(BEAN_FILTRO, mcextraBean);
        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);

        /* BGB0 */// - obtem dados dos titulos do cedente
        mcextraBean.setPagina((long) paginaAtual);

       
        List bgb0List = handler.executeFixDataRecordsetTransaction(mcextraBean, TRANSACAO_TITULOS);
        LogUtilSigcb.info("DEPOIS DA  BGB0");
        ConGerMovimentoCedenteBean numeroRegistros = (ConGerMovimentoCedenteBean) ((BeanList) bgb0List.get(0)).get(0);
        BeanList bgb0BeanList = (BeanList) bgb0List.get(1);
        LogUtilSigcb.info("BGB0 1");
        ArrayList arrayPaginacao = convertDataStructure(bgb0BeanList.iterator());
        LogUtilSigcb.info("BGB0 2" + paginaAtual);
        request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
        LogUtilSigcb.info("BGB0 3" +numeroRegistros.getTotalRegistro() );
        request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(numeroRegistros.getTotalRegistro() / 20.0));
        LogUtilSigcb.info("BGB0 4");

        /* BGB1 */// - Consultar Débito e Crédito
        BeanList bgb1BeanList = handler.executeSimpleTransactionQuery(mcextraBean,  TRANSACAO_DEB_CRED);
        debCredBean = (ConGerMovimentoCedenteBean) bgb1BeanList.get(0);

        /* BGB2 */// - consultar Liquidações
        BeanList bgb2BeanList = handler.executeSimpleTransactionQuery(mcextraBean,  TRANSACAO_LIQUIDACOES);
        ArrayList arrayLiquidacao = convertDataStructure(bgb2BeanList.iterator());
        request.getSession().setAttribute("listaExtrato", arrayPaginacao);
        request.getSession().setAttribute(BEAN_DEBCRED, debCredBean);
        request.getSession().setAttribute(LIQUIDACAO_LIST, getPageHolder(arrayLiquidacao));
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(arrayPaginacao));
        request.getSession().setAttribute("ORIGEM", "T");
        request.getSession().setAttribute("pagTroca", String.valueOf(paginaAtual));
        request.getSession().setAttribute("totPagina", String.valueOf((int)Math.ceil(numeroRegistros.getTotalTitulos() / 20.0)));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);

    }

}
