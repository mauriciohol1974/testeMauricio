package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.GiroCaixaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consulta Gerais -
 * GiroCaixa Intantaneo
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */

public class GiroCaiManterIniciar extends GiroCaixaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        // Recupera os beans
        GiroCaixaBean giroCaixaBean = new GiroCaixaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            giroCaixaBean = (GiroCaixaBean) giroCaixaBean.newBean();
        } else {
            giroCaixaBean = (GiroCaixaBean) giroCaixaBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        giroCaixaBean.setNavegacao(NAVEGACAO_FILTRO);
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, giroCaixaBean);
        request.getSession().setAttribute(DATA_BEAN, giroCaixaBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_JSP_FILTRO;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
