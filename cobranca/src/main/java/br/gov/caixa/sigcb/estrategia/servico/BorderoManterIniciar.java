package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Manter >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BorderoManterIniciar extends BorderoEstrategia {
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
        BorderoBean borderoBean = new BorderoBean();

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            borderoBean = (BorderoBean) borderoBean.newBean();
        } else {
            borderoBean = (BorderoBean) borderoBean.getSessionBean(request,
                    FILTRO_BEAN);

            // !@# Set necessario para correta navegação
            borderoBean.setNavegacao(NAVEGACAO_FILTRO);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(FILTRO_BEAN, borderoBean);
        request.getSession().setAttribute(DATA_BEAN, borderoBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_MANTER_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
