package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Bordero >> Excluir >>
 * Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BorderoExcluirFinalizar extends BorderoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        BorderoBean borderoBean = new BorderoBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            borderoBean = (BorderoBean) borderoBean.getRequestBean(request);
        } else {
            borderoBean = (BorderoBean) borderoBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Define manualmente atributos nao obtidos da jsp
        borderoBean.setNavegacao(NAVEGACAO_EXCLUIR);

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, borderoBean);

        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_EXCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
        
        handler.executeSimpleTransactionVoid(borderoBean, transUser); // Chama
                                                                                // a
                                                                                // Transacao

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, borderoBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_EXCLUIR);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
