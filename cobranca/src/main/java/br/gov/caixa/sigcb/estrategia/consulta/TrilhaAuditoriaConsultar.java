package br.gov.caixa.sigcb.estrategia.consulta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.TrilhaAuditoriaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;


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
public class TrilhaAuditoriaConsultar extends TrilhaAuditoriaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	
    	configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
    	
    	 String fluxo = getFluxo(request);
         
         TrilhaAuditoriaBean trilhaBean = new TrilhaAuditoriaBean();
         if (fluxo.equals(FLUXO_NORMAL)) {
         	trilhaBean = (TrilhaAuditoriaBean) trilhaBean.newBean();
        	trilhaBean = (TrilhaAuditoriaBean) trilhaBean.getRequestBean(request);
         } else {
         	trilhaBean = (TrilhaAuditoriaBean) trilhaBean.getSessionBean(request,  FILTRO_BEAN);
         }        
    	

        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
         MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        BeanList trilhaListBean = handler.executeSimpleTransactionQuery(trilhaBean, TRANSACAO_CONSULTAR);

        TrilhaAuditoriaBean trilhaBeanRetornado = (TrilhaAuditoriaBean) trilhaListBean.get(0);
        
        
        request.getSession().setAttribute(DATA_BEAN, trilhaBeanRetornado);
        
    return PAGE_MANTER_CONSULTAR;
}

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
