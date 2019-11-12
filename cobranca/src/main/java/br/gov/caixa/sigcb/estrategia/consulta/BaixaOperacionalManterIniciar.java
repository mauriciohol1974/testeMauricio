package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.BaixaOperacionalBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Historico de Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class BaixaOperacionalManterIniciar extends BaixaOperacionalEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        // Recupera os beans
        BaixaOperacionalBean baixaBean = new BaixaOperacionalBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        PilhaVoltarControle.init(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
        	baixaBean = (BaixaOperacionalBean) baixaBean.newBean();
        } else {
        	baixaBean = (BaixaOperacionalBean) baixaBean.getSessionBean(request,  FILTRO_BEAN);
        }

        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, baixaBean);
        request.getSession().setAttribute(DATA_BEAN, baixaBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_FILTRO;
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
