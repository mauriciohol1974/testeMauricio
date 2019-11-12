package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public abstract class CedenteConsultarEstrategia extends CedenteEstrategia {

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_CONSULTAR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
