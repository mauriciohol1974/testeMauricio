package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento do cedente -(TOTAIS)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class MCTotaiManterIniciar extends MCTotaiEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);

        ConGerMovimentoCedenteBean mctotaiBean = new ConGerMovimentoCedenteBean();
        CedenteCabecaBean cabCedBean = new CedenteCabecaBean();

        cabCedBean = (CedenteCabecaBean) cabCedBean.newBean();

        // EAM2907
        String fluxo = getFluxo(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            mctotaiBean = (ConGerMovimentoCedenteBean) mctotaiBean.newBean();
        } else {
            mctotaiBean = (ConGerMovimentoCedenteBean) mctotaiBean.getSessionBean(request,
                    BEAN_FILTRO);
        }

        request.getSession().setAttribute(BEAN_CABECALHO, cabCedBean);
        request.getSession().setAttribute(BEAN_DATA, mctotaiBean);
        request.getSession().setAttribute(BEAN_FILTRO, mctotaiBean);

        return PAGE_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);

    }

}