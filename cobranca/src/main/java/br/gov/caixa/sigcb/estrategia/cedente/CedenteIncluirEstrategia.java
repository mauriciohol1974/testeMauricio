package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public abstract class CedenteIncluirEstrategia extends CedenteEstrategia {

    protected void configMsgSucessoErro(HttpServletRequest request) {
        this.configMsgSucessoErro(request, "Cedente Incluído com Sucesso");
    }

    protected void configMsgSucessoErro(HttpServletRequest request,
            String msgSucesso) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(msgSucesso);
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setTitlePage(PAGE_INCLUIR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
