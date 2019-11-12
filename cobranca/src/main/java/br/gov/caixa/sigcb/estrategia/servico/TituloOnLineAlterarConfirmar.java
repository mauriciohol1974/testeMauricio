package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Incluir >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloOnLineAlterarConfirmar extends TituloOnLineEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	
    	configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            // Obtem dados do request:
            TituloBean reqTituloBean = new TituloBean();
            reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);
            

            // Obtem dados:
            tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);

            // Recupera informacoes do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
            tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
        }
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ACAO1 + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList tituloListBean = handler.executeSimpleTransactionQuery(tituloBean, transUser);
       
        
    return PAGE_ALTERAR_SUCESSO;
}

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_ACAO_ALTERAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
