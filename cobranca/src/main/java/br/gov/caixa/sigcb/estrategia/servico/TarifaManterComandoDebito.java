package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.LancamentoTarifaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consulta Gerais -
 * Lancamento de Tarifa
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */

public class TarifaManterComandoDebito extends LancamentoTarifaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        // Recupera os beans
        LancamentoTarifaBean lancamentoTarifaBean = new LancamentoTarifaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            lancamentoTarifaBean = (LancamentoTarifaBean) lancamentoTarifaBean.newBean();
        } else {
            lancamentoTarifaBean = (LancamentoTarifaBean) lancamentoTarifaBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, lancamentoTarifaBean);
        request.getSession().setAttribute(DATA_BEAN, lancamentoTarifaBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_FILTRO_MANTER;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_COMANDO_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
