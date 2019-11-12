package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Liquidacoes Rejeitadas >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>27/08/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class LiqRejeManterIniciar extends LiqRejeManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // System.out.println("#$% comeco " + this.getClass().getName());

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean da funcionalidade
        LiquidacoesRejeitadaBean filtroBean = new LiquidacoesRejeitadaBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (LiquidacoesRejeitadaBean) filtroBean.newBean();
        } else {
            filtroBean = (LiquidacoesRejeitadaBean) filtroBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);

        // limpa DATA_BEAN para uma nova busca
        request.getSession().setAttribute(DATA_BEAN,
                new LiquidacoesRejeitadaBean());

        // System.out.println("#$% fim " + this.getClass().getName());

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
