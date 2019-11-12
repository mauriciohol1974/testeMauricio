/*
 * Data de Cria��o: 13/10/2005 
 */
package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;

/**
 * @author Eduardo Mor�s
 */
public class PvCobConsultarIniciar extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        PvCobradorBean pvBean = new PvCobradorBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            pvBean = (PvCobradorBean) pvBean.getRequestBean(request);
        } else {
            pvBean = (PvCobradorBean) pvBean.getSessionBean(request, DATA_BEAN);
        }
        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, pvBean);

        // EAM 13/10/2005 - Retirado todo o c�digo para obten��o de dados,
        // devido
        // a cria��o de p�gina de consulta e colocado no m�todo
        // PvCobEstrategia.getDadosPvCob(PvCobradorBean pvBean,
        // HttpServletRequest request);
        getDadosPvCob(pvBean, request);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
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
