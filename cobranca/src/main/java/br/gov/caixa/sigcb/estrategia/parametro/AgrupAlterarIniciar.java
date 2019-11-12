package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.AgrupamentoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Agrupamento >> Alterar >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class AgrupAlterarIniciar extends AgrupEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        AgrupamentoBean agrupBean = new AgrupamentoBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            agrupBean = (AgrupamentoBean) agrupBean.getRequestBean(request);

            // Obtem o titulo selecionado em "Listar",
            // a partir da lista de titulos obtidos anteriormente na chamada ao
            // mainframe
            // A tela "Listar" deve enviar o atributo "Registro" com o numero do
            // registro na lista
            PageHolder paginacao = (PageHolder) request.getSession()
                    .getAttribute(PAGINACAO_LIST);

            Pageable registroList = paginacao.getPageable();
            agrupBean = (AgrupamentoBean) registroList.get(agrupBean.getRegistro()
                    .intValue());

        } else {
            agrupBean = (AgrupamentoBean) agrupBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, agrupBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_ALTERAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}