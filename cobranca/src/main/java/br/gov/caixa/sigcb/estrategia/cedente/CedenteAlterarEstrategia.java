package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public abstract class CedenteAlterarEstrategia extends CedenteEstrategia {

    protected void configMsgSucessoErro(HttpServletRequest request) {
        this.configMsgSucessoErro(request, "Cedente Alterado com Sucesso");
    }

    protected void configMsgSucessoErro(HttpServletRequest request,
            String msgSucesso) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(msgSucesso);
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_MANTER_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
