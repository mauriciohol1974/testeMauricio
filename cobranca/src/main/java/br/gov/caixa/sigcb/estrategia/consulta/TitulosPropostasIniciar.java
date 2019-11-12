package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedCentBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedentePECBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.CedentePropostaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TitulosPropostaBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class TitulosPropostasIniciar extends TitulosPropostasEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        // Recupera o bean
        TitulosPropostaBean titulosPropostaBean = new TitulosPropostaBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	titulosPropostaBean = (TitulosPropostaBean) titulosPropostaBean.newBean();
        } else {
        	titulosPropostaBean = (TitulosPropostaBean) titulosPropostaBean.getSessionBean(request, FILTRO_BEAN);
        }

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(FILTRO_BEAN, titulosPropostaBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)

        return PAGE_JSP_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
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
