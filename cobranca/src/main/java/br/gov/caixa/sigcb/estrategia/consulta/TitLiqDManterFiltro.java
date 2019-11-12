package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta - Titulos
 * Liquidados Dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitLiqDManterFiltro extends TitLiqDManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String retorno = "";

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        ConGerTitulosLiquidadosDiaBean filtroBean = new ConGerTitulosLiquidadosDiaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (ConGerTitulosLiquidadosDiaBean) filtroBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);

        } else {
            filtroBean = (ConGerTitulosLiquidadosDiaBean) filtroBean.getSessionBean(request,
                    FILTRO_BEAN);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CABECALHO_BEAN);
        }

        // EAM 15/09 ini
        if (!filtroBean.getCodigoCedente().equals(new Long(0))
            && filtroBean.getCodigoCedente() != null) {
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    filtroBean.getCodigoCedente());
        }
        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);
        // EAM 15/09 fim
        switch (filtroBean.getTpConsulta().intValue()) {

        case 0: /* consulta por cedente */

            /* BGM0 */// - Obtem dados do Cedente
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));

            BeanList cedCabBeanList = (BeanList) handler.executeSimpleTransactionQuery(cedCabBean,
                    TRANS_CEDENTE_CABECALHO);

            CedenteCabecaBean cabecalhoBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cabecalhoBean.setCodigoCedente(filtroBean.getCodigoCedente());

            request.getSession().setAttribute(CABECALHO_BEAN, cabecalhoBean);

            /* BGD4 */// - Listar Títulos
            int paginaAtual = 1;
            try {
                paginaAtual = Integer.parseInt(request.getParameter("pagina"));
            } catch (Exception e) {
            }

            filtroBean.setPagina((long) paginaAtual);
            
            filtroBean.setTipoConsulta(new Long(2));
            filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            List titulosList = (List) handler.executeFixDataRecordsetTransaction(filtroBean, TRANS_LISTA_TITULOS);

            ConGerTitulosLiquidadosDiaBean fixoBean = (ConGerTitulosLiquidadosDiaBean) ((BeanList) titulosList.get(0)).get(0);

            BeanList titLiqBeanList = (BeanList) titulosList.get(1);
            ArrayList titPagArray = convertDataStructure(titLiqBeanList.iterator());

            filtroBean.setDataCredito(fixoBean.getDataCredito());

            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(titPagArray));
            request.setAttribute(PAGINACAO_PAGE, "0");

            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL,
                    (int) Math.ceil(fixoBean.getTotalRegistro() / 20.0));
            retorno = PAGE_LIQD_LISTA_CED;
            break;

        case 1: /* consulta por Unidade de Vinculacao */

            /* BGD3 */// - Lista cedentes por Unidade Vinculacao
            filtroBean.setTipoConsulta(new Long(2));
            filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            List listaCedente = (List) handler.executeFixDataRecordsetTransaction(filtroBean,
                    TRANS_CEDENTE_POR_PV);

            ConGerTitulosLiquidadosDiaBean fixoCedBean = (ConGerTitulosLiquidadosDiaBean) ((BeanList) listaCedente.get(0)).get(0);
            ArrayList cedenteArray = convertDataStructure(((BeanList) listaCedente.get(1)).iterator());

            filtroBean.setNomeUnidade(fixoCedBean.getNomeUnidade());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(cedenteArray));

            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_LIQD_LISTA_PV;
            break;
        }
        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);

        return retorno;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
