package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;

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
public class PvCobAlterarIniciar extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
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

        // EAM 13/10/2005 - Retirado todo o código para obtenção de dados,
        // devido
        // a criação de página de consulta e colocado no método
        // PvCobEstrategia.getDadosPvCob(PvCobradorBean pvBean,
        // HttpServletRequest request);
        getDadosPvCob(pvBean, request);

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