package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento do cedente -(EXTRATO)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class MCExtraManterIniciar extends MCExtraEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);

        ConGerMovimentoCedenteBean mcextraBean = new ConGerMovimentoCedenteBean();
        CedenteCabecaBean cabCedBean = new CedenteCabecaBean();

        cabCedBean = (CedenteCabecaBean) cabCedBean.newBean();

        // EAM2907
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            mcextraBean = (ConGerMovimentoCedenteBean) mcextraBean.newBean();
        } else {
            mcextraBean = (ConGerMovimentoCedenteBean) mcextraBean.getSessionBean(request,
                    BEAN_FILTRO);
        }
        // EAM

        request.getSession().setAttribute(BEAN_CABECALHO, cabCedBean);
        request.getSession().setAttribute(BEAN_DEBCRED, mcextraBean);
        request.getSession().setAttribute(BEAN_FILTRO, mcextraBean);

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
