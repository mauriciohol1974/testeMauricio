package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SacadoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Sacados >> Incluir >>
 * Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SacadoIncluirFinalizar extends SacadoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        SacadoBean sacadoBean = new SacadoBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            sacadoBean = (SacadoBean) sacadoBean.getRequestBean(request);
        } else {
            sacadoBean = (SacadoBean) sacadoBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Define manualmente atributos nao obtidos da jsp
        sacadoBean.setTipoAcao("I"); // Incluir
        sacadoBean.setMeioEntrada(new Long(1)); // Convencional - Intranet
        // Obtem dados do Usuário

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, sacadoBean);

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
        String transUser = TRANSACAO_INCLUIR_ALTERAR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(sacadoBean,transUser); // Chama a Transacao

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, sacadoBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_INCLUIR);
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}