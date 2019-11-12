package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PV Cobrador >> Alterar >>
 * Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class PvCobAlterarFinalizar extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        PvCobradorBean pvBean = new PvCobradorBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            pvBean = (PvCobradorBean) pvBean.getRequestBean(request);
        } else {
            pvBean = (PvCobradorBean) pvBean.getSessionBean(request, DATA_BEAN);
        }

        // Define manualmente atributos nao obtidos da jsp
        pvBean.setTipoAcao("A");
        // Dados fixos: Código Van = 1 EMBRATEL
        pvBean.setCodigoVAN(new Long(1));
        // Se situação somente pode ser ativa para alterar.
        pvBean.setSituacao("A");
        // Obtem dados do Usuário
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        pvBean.setUsuario(usuarioBean.getCodigoUsuario());

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, pvBean);

        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(pvBean, transUser); // Chama
                                                                                    // a
                                                                                    // Transacao

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, pvBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR);
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
