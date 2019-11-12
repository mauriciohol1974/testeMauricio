package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Liquidacoes Rejeitadas >>
 * Listar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */

public class LiqRejeAcaoIniciar extends LiqRejeManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // System.out.println("#$% comeco " + this.getClass().getName());

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean da funcionalidade
        LiquidacoesRejeitadaBean liqRejeBean = new LiquidacoesRejeitadaBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            liqRejeBean = (LiquidacoesRejeitadaBean) liqRejeBean.getRequestBean(request);
        } else {
            liqRejeBean = (LiquidacoesRejeitadaBean) liqRejeBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Pega o registro selecionado pelo usuario da lista de registros
        // obtidos na busca
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(LiqRejeManterEstrategia.PAGINACAO_LIST);
        Pageable registroList = paginacao.getPageable();
        LiquidacoesRejeitadaBean registroBean = (LiquidacoesRejeitadaBean) registroList.get(liqRejeBean.getRegistro()
                .intValue());

        // setando valores para nao perder
        registroBean.setRadioAcao(liqRejeBean.getRadioAcao());

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, registroBean);

        String radioAcao = liqRejeBean.getRadioAcao();
        String nextPage = PAGE_ERRO;
        if (radioAcao.equalsIgnoreCase(ACAO_RECOMANDO)) {
            // LogUtilSigcb.debug("#$% Acao Recomando :::: ");

            nextPage = PAGE_RECOMANDO;
        } else if (radioAcao.equalsIgnoreCase(ACAO_RECOMANDO_ESPECIAL)) {
            // LogUtilSigcb.debug("#$% Acao Recomando Especial :::: ");

            nextPage = PAGE_RECOMANDO_ESPECIAL;
        } else if (radioAcao.equalsIgnoreCase(ACAO_ESTORNO)) {
            // LogUtilSigcb.debug("#$% Acao Estorno :::: ");

            configMsgSucessoErro(request, SUCESSO_ESTORNO);

            // Obtem dados do Usuário
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            registroBean.setUsuario(usuarioBean.getCodigoUsuario());

            // Define manualmente atributos nao obtidos da jsp
            registroBean.setTipoAcao("A"); // A - Solicitacao de Acao
            registroBean.setTipoSolicitacao(new Long(3)); // 3 - Estorno

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
            String transUser = TRANSACAO_EXECUTAR_ACAO + usuarioBean.getCodigoUsuario().toUpperCase();
            
            handler.executeSimpleTransactionVoid(registroBean,
            		transUser); // Chama a Transacao

            nextPage = PAGE_SUCESSO;
        } else if (radioAcao.equalsIgnoreCase(ACAO_EXCLUIR)) {
            // LogUtilSigcb.debug("#$% Acao Excluir :::: ");

            configMsgSucessoErro(request, SUCESSO_EXCLUIR);

            // Obtem dados do Usuário
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            registroBean.setUsuario(usuarioBean.getCodigoUsuario());

            // Define manualmente atributos nao obtidos da jsp
            registroBean.setTipoAcao("A"); // A - Solicitacao de Acao
            registroBean.setTipoSolicitacao(new Long(4)); // 4 - Excluir

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
            String transUser = TRANSACAO_EXECUTAR_ACAO + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(registroBean,
            		transUser); // Chama a Transacao

            nextPage = PAGE_SUCESSO;
        } else if (radioAcao.equalsIgnoreCase(ACAO_CANCELAR)) {
            // LogUtilSigcb.debug("#$% Acao Cancelar :::: ");

            configMsgSucessoErro(request, SUCESSO_CANCELAMENTO);

            // Obtem dados do Usuário
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            registroBean.setUsuario(usuarioBean.getCodigoUsuario());

            // Define manualmente atributos nao obtidos da jsp
            registroBean.setTipoAcao("C"); // C - Cancelamento de Acao
            registroBean.setTipoSolicitacao(new Long(0)); // 0 para nao
                                                            // acontecer null
                                                            // pointer exception

            // Chamada ao Mainframe
            usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_EXECUTAR_ACAO + usuarioBean.getCodigoUsuario().toUpperCase();
            
           // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Instancia o EJB que acessa o mainframe
            handler.executeSimpleTransactionVoid(registroBean,
            		transUser);
            // Chama a Transacao

            nextPage = PAGE_SUCESSO;
        }

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, registroBean);

        // System.out.println("#$% fim " + this.getClass().getName());

        return nextPage;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        // usado o metodo abaixo
    }

    protected void configMsgSucessoErro(HttpServletRequest request,
            String mensagemSucesso) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(mensagemSucesso);
        msgBean.setStrategyErrorReturn(STRATEGY_LISTA);
        msgBean.setStrategySucessReturn(STRATEGY_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
