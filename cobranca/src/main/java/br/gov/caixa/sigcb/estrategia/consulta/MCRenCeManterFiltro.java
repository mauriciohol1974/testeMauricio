package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas gerais -
 * Rentabilidade do cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class MCRenCeManterFiltro extends MCRenCeEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        ConGerCedenteRentabilidadeBean mcrenceBean = new ConGerCedenteRentabilidadeBean();
        ConGerCedenteRentabilidadeBean fixoBean = new ConGerCedenteRentabilidadeBean();
        ConGerCedenteRentabilidadeBean tempBean = new ConGerCedenteRentabilidadeBean(); // bean
                                                                                        // temporário
                                                                                        // de
                                                                                        // dados
                                                                                        // fixos
                                                                                        // que
                                                                                        // receberá
                                                                                        // dados
                                                                                        // de
                                                                                        // uma
                                                                                        // segunda
                                                                                        // transacao
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        if (fluxo.equals(FLUXO_NORMAL)) {
            mcrenceBean = (ConGerCedenteRentabilidadeBean) mcrenceBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
            fixoBean.newBean();
        } else {
            mcrenceBean = (ConGerCedenteRentabilidadeBean) mcrenceBean.getSessionBean(request,
                    BEAN_FILTRO);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    BEAN_CABECALHO);
        }

        // EAM2907
        request.getSession().setAttribute(CEDENTE_ATUAL,
                mcrenceBean.getCodigoCedente());
        request.getSession().setAttribute(BEAN_FILTRO, mcrenceBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        /* BGM0 */// - Obtem dados do cabeçalho do Cedente no SICLI
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(mcrenceBean.getCodigoCedente());
        cedCabBean.setOrigemConsulta(new Long(1));

        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                TRANS_CEDENTE);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(mcrenceBean.getCodigoCedente());
        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);

        /* BGB4 */// - Consultar Rentabilidade
        BeanList bgb4BeanList = handler.executeSimpleTransactionQuery(mcrenceBean,
                TRANS_RENTA);
        fixoBean = (ConGerCedenteRentabilidadeBean) bgb4BeanList.get(0);

        /* BGB5 */// - Consultar Custos por Canal
        BeanList bgb5BeanList = handler.executeSimpleTransactionQuery(mcrenceBean,
                TRANS_CANAL);
        ArrayList arrayCanal = convertDataStructure(bgb5BeanList.iterator());

        /* BGB6 */// - Consultar comandos manuais
        BeanList bgb6BeanList = handler.executeSimpleTransactionQuery(mcrenceBean,
                TRANS_COM_MAN);
        tempBean = (ConGerCedenteRentabilidadeBean) bgb6BeanList.get(0);

        // setando no Bean fixo os dados complementares

        fixoBean.setPeriodo(mcrenceBean.getPeriodo());
        fixoBean.setQtdBaixaTitulos(tempBean.getQtdBaixaTitulos());
        fixoBean.setQtdAlteracaoesTitulos(tempBean.getQtdAlteracaoesTitulos());

        request.getSession().setAttribute(BEAN_FIXO, fixoBean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(arrayCanal));
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
