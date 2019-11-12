package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BloquetoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BloquetConsultarIniciar extends BloquetEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        // String fluxo = getFluxo(request);
        BloquetoBean bloquetoBean = new BloquetoBean();
        bloquetoBean = (BloquetoBean) bloquetoBean.getRequestBean(request);
        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        // Determinar tipo de consulta
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        BeanList bloquetoBeanList;
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        bloquetoBeanList = handler.executeSimpleTransactionQuery(bloquetoBean,
        		transUser); // Chama a Transacao BGK6
        bloquetoBean = (BloquetoBean) bloquetoBeanList.get(0);
        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, bloquetoBean);
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}