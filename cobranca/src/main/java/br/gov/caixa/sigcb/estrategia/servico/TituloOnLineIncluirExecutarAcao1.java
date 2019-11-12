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
public class TituloOnLineIncluirExecutarAcao1 extends TituloOnLineEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	
    	configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            // Obtem dados do request:
        	tituloBean = (TituloBean) tituloBean.getSessionBean(request,  DATA_BEAN);
        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
        }
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        tituloBean.setTipoAcao("N");
        String observStr = tituloBean.getObservacoes().replace("\r\n", " ");
        observStr = observStr.replace("\n", " ");
        observStr = observStr.replace("\r", " ");
        tituloBean.setObservacoes(observStr);
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ACAO1 + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList tituloListBean = handler.executeSimpleTransactionQuery(tituloBean, transUser);

        TituloBean tituloBeanRetornado = (TituloBean) tituloListBean.get(0);
        tituloBeanRetornado.setTipoAcao("N");
        
        tituloBean.setNossoNumeroLiq(tituloBeanRetornado.getNossoNumeroLiq());
        tituloBean.setCodBarras1(tituloBeanRetornado.getCodBarras1());
        tituloBean.setCodBarras2(tituloBeanRetornado.getCodBarras2());
        tituloBean.setCodBarras3(tituloBeanRetornado.getCodBarras3());
        tituloBean.setCodBarras4(tituloBeanRetornado.getCodBarras4());
        tituloBean.setCodBarras5(tituloBeanRetornado.getCodBarras5());
        tituloBean.setCodigoCedente(tituloBeanRetornado.getCodigoCedente());
        tituloBean.setPrinciDataVencimento(tituloBeanRetornado.getPrinciDataVencimento());
        tituloBean.setFatorVencimento(tituloBeanRetornado.getFatorVencimento());
        tituloBean.setLiquiValorDocumento(tituloBeanRetornado.getLiquiValorDocumento());
        
        
        
        request.getSession().setAttribute(DATA_BEAN, tituloBean);
       
        
    return PAGE_INCLUIR_CONFIRMA;
}

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
