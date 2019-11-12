package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade
 * Solicitacao/Agendamento >> Alterar >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class SoAgTitAlterarIniciar extends SolicitacaoAgendamentoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {

            // Configura��es para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informa��o para definir se o request veio de voltar ou se o
            // fluxo � normal
            String fluxo = getFluxo(request);
            // Obtem o bean da funcionalidade
            SolicitacaoAgendamentoBean solicitacaoBean = new SolicitacaoAgendamentoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getRequestBean(request);
                cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
            } else {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getSessionBean(request,
                        DATA_BEAN);
                cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                        CEDENTE_CABECALHO_BEAN);
            }

            // Define manualmente atributos nao obtidos da jsp

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);

            // Chamada ao Mainframe
           // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // Chama aS Transac�es

            // Obtendo os dados do sacado
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_SOLICITACAO_AGENDAMENTO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList solicitacaoBeanList = handler.executeSimpleTransactionQuery(solicitacaoBean,
            		transUser);
            SolicitacaoAgendamentoBean solicitacao = new SolicitacaoAgendamentoBean();
            solicitacao = (SolicitacaoAgendamentoBean) solicitacaoBeanList.get(0);

            // Atribuindo ao bean os valores n�o obtidos na transa��o
            solicitacao.setCodigoCedente(solicitacaoBean.getCodigoCedente());
            solicitacao.setCodigoBancoSacado(solicitacaoBean.getCodigoBancoSacado());
            solicitacao.setNomeBancoSacado(solicitacaoBean.getNomeBancoSacado());
            solicitacao.setIndicadorSolicitacao(solicitacaoBean.getIndicadorSolicitacao());
            solicitacao.setNavegacao(solicitacaoBean.getNavegacao());
            solicitacao.setDataSolicitacao(solicitacaoBean.getDataSolicitacao());

            request.getSession().setAttribute(DATA_BEAN, solicitacao);

        } catch (Exception e) {
            throw e;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_ALTERAR;

    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}