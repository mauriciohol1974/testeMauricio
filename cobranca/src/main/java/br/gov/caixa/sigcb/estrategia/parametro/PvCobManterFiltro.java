package br.gov.caixa.sigcb.estrategia.parametro;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PvCobrador >> Manter >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class PvCobManterFiltro extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        PvCobradorBean pvBean = new PvCobradorBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            pvBean = (PvCobradorBean) pvBean.getRequestBean(request);
        } else {
            pvBean = (PvCobradorBean) pvBean.getSessionBean(request, DATA_BEAN);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, pvBean);
        request.getSession().setAttribute(FILTRO_BEAN, pvBean);

        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Determinar tipo de consulta
        BeanList pvCobBeanList;
        if (pvBean.getAcao().equals("UNIDADE")) {
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
            pvCobBeanList = handler.executeSimpleTransactionQuery(pvBean,
            		transUser); // Chama a Transacao BGK6
        } else {
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_CEP + usuarioBean.getCodigoUsuario().toUpperCase();
            pvCobBeanList = handler.executeSimpleTransactionQuery(pvBean,
            		transUser); // Chama a Transacao BGK7
        }
        ArrayList pvCobList = convertDataStructure(pvCobBeanList.iterator());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(pvCobList));
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_MANTER_LISTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}