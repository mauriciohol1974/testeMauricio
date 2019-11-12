package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade
 * Solicitacao/Agendamento >> Alterar >> Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SoAgTitAlterarFinalizar extends SolicitacaoAgendamentoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean que representa a funcionalidade
            SolicitacaoAgendamentoBean solicitacaoBean = new SolicitacaoAgendamentoBean();
            if (fluxo.equals(FLUXO_NORMAL)) {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getRequestBean(request);
            } else {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getSessionBean(request,
                        DATA_BEAN);
            }

            // Define manualmente atributos nao obtidos da jsp
            solicitacaoBean.setTipoAcao("A"); // Alterar
            solicitacaoBean.setMeioEntrada(new Long(1)); // Convencional -
                                                            // Intranet
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            solicitacaoBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            // Obtem dados do Usuário

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);

            // Chamada ao Mainframe
           // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                    // o
                                                                                    // EJB
                                                                                    // que
                                                                                    // acessa
                                                                                    // o
                                                                                    // mainframe
           
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_INCLUIR_ALTERAR + usuarioBean.getCodigoUsuario().toUpperCase();
            
            handler.executeSimpleTransactionVoid(solicitacaoBean,
            		transUser); // Chama a Transacao

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);
        } catch (Exception e) {
            throw e;
        }
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR);
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}