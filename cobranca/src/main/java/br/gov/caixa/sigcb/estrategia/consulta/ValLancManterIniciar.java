package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerValLancadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ValLancManterIniciar extends ValLancManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);

        ConGerValLancadosBean vallancBean = new ConGerValLancadosBean();
        CedenteCabecaBean cabCedBean = new CedenteCabecaBean();

        vallancBean = (ConGerValLancadosBean) vallancBean.newBean();
        cabCedBean = (CedenteCabecaBean) cabCedBean.newBean();

        request.getSession().setAttribute(CABECALHO_BEAN, cabCedBean);
        request.getSession().setAttribute(DATA_BEAN, vallancBean);
        request.getSession().setAttribute(FILTRO_BEAN, vallancBean);

        return PAGE_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }
}
