package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Liquidacoes Rejeitadas >>
 * Consultar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */

public class LiqRejeConsultarIniciar extends LiqRejeManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
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

        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(LiqRejeManterEstrategia.PAGINACAO_LIST);
        Pageable registroList = paginacao.getPageable();
        LiquidacoesRejeitadaBean registroBean = (LiquidacoesRejeitadaBean) registroList.get(liqRejeBean.getRegistro()
                .intValue());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(DATA_BEAN, registroBean);

        return PAGE_CONSULTAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_LISTA);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
