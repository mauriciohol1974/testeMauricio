package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade
 * Solicitação/Agendamento >> Manter >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SoAgTitManterIniciar extends SolicitacaoAgendamentoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        // Para funcionalidade Iniciar , deve-ser inicializar os atributos do
        // bean que aparecem na tela
        SolicitacaoAgendamentoBean solicitacaoBean = new SolicitacaoAgendamentoBean();

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.newBean();
        } else {
            solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getSessionBean(request,
                    FILTRO_BEAN);

            // !@# Set necessario para correta navegação
            solicitacaoBean.setNavegacao(NAVEGACAO_FILTRO);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, solicitacaoBean);
        request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_MANTER_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}