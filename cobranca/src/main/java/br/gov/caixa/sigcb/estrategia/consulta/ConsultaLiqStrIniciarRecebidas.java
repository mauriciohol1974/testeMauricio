package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.LiquidacoesSTRBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;


/**
 * <B>Projeto: SIGCB</B><BR>
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abril/2013</DD>
 * </DL>
 * 
 * @author Maurício Assis de Holanda
 */
public class ConsultaLiqStrIniciarRecebidas extends ConsultaLiqStrManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // System.out.println("#$% comeco " + this.getClass().getName());

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean da funcionalidade
        LiquidacoesSTRBean filtroBean = new LiquidacoesSTRBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (LiquidacoesSTRBean) filtroBean.newBean();
        } else {
            filtroBean = (LiquidacoesSTRBean) filtroBean.getSessionBean(request, FILTRO_BEAN);
        }

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);

        // limpa DATA_BEAN para uma nova busca
        request.getSession().setAttribute(DATA_BEAN, new LiquidacoesSTRBean());

        // System.out.println("#$% fim " + this.getClass().getName());

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_RECEBIDAS);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
