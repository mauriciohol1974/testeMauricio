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
 * Recomando Especial
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */

public class LiqRejeAcaoRecAltValorFinalizar extends LiqRejeManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // System.out.println("#$% comeco " + this.getClass().getName());

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
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

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, registroBean);

        // Obtem dados do Usuário
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        registroBean.setUsuario(usuarioBean.getCodigoUsuario());

        // Define manualmente atributos nao obtidos da jsp
        registroBean.setTipoAcao("A"); // A - Solicitacao de Acao
        registroBean.setTipoSolicitacao(new Long(2)); // 2 - Recomando
                                                        // Especial

        // Dados da tela (pegos pelo liqRejeBean) setados no bean do registro
        // selecionado
        registroBean.setCodigoCedenteCorrigido(liqRejeBean.getCodigoCedenteCorrigido());
        registroBean.setNossoNumeroCorrigido(liqRejeBean.getNossoNumeroCorrigido());
        registroBean.setNumeroLoteCorreto(liqRejeBean.getNumeroLoteCorreto());
        registroBean.setValorCorrigido(liqRejeBean.getValorCorrigido());

        // EAM - INI
        registroBean.setRadioAcao(liqRejeBean.getRadioAcao());

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

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, registroBean);

        // System.out.println("#$% fim " + this.getClass().getName());

        return PAGE_SUCESSO;

    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_RECOMANDO_ESPECIAL);
        msgBean.setStrategyErrorReturn(STRATEGY_ACAO);
        msgBean.setStrategySucessReturn(STRATEGY_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
