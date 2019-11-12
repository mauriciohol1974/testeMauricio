package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class BcoTituAlterarFinalizar extends BcoTituEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            tituloBean = (TituloBean) tituloBean.getRequestBean(request);
            tituloBean.setMeioEntrada(new Long(1));

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Recupera informacoes do usuario
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
        tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

        // Retem informacoes do bean antes do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, tituloBean);

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        // Executa transacao
        if (tituloBean.getIcAutPagto().trim().length()==0){
        	tituloBean.setIcAutPagto("S");
        }
        
        if (tituloBean.getIcTipoPagamento()==null || tituloBean.getIcTipoPagamento().trim().length()==0 ){
        	tituloBean.setIcTipoPagamento("3");
        }

        
        
        
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        
        if (tituloBean.getCompleTipoJurosMes()==5L){
        	tituloBean.setFixo("0000000000");
        	String transUser = "XX63" + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(tituloBean, transUser);
        }else{
        	String transUser = TRANSACAO_ALTERAR + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(tituloBean, transUser);
        }

        return PAGE_SUCESSO;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR);
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}