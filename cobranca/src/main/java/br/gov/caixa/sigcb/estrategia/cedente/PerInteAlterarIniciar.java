package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PerfilInternetBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class PerInteAlterarIniciar extends PerInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(PerInteEstrategia.PAGINACAO_LIST);
        String page = request.getParameter(PerInteEstrategia.PAGINACAO_PAGEANTERIOR);
        String escolha = request.getParameter("pos");
        List list = (List) paginacao.getPage(Integer.parseInt(page));
        PerfilInternetBean perfilInternetBean = (PerfilInternetBean) list.get(Integer.parseInt(escolha));
        request.getSession().setAttribute(DATA_BEAN, perfilInternetBean);
        return PAGE_ALTERAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}