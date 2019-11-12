package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Tarifa Manual >>
 * Incluir >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class TarifaIncluirIniciar extends TarifaEstrategia {
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
        TarifaManualBean tarifaBean = new TarifaManualBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            tarifaBean = (TarifaManualBean) tarifaBean.newBean();
        } else {
            tarifaBean = (TarifaManualBean) tarifaBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, tarifaBean);
        request.getSession().setAttribute(DATA_BEAN, tarifaBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_INCLUIR_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("Incluir Lançamento de Tarifas Comandadas");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}