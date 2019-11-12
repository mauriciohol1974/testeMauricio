package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.ProtestoTituloBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Protesto de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>10/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class ProtestManterIniciar extends ProtestoTituloEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        // Recupera os beans
        ProtestoTituloBean protestoTituloBean = new ProtestoTituloBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            protestoTituloBean = (ProtestoTituloBean) protestoTituloBean.newBean();
        } else {
            protestoTituloBean = (ProtestoTituloBean) protestoTituloBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, protestoTituloBean);
        request.getSession().setAttribute(DATA_BEAN, protestoTituloBean);
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
