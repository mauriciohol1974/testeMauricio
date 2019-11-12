package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.iso.ISOException;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.ClienteSINCEBean;
import br.gov.caixa.sigcb.bean.ContabilBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Contábil
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class ClienteSINCEFiltro extends ClienteSINCEEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        

        
        
        String tpconsulta = request.getParameter("tpconsulta");
        String codcedente = request.getParameter("codcedente");
        String codsince = request.getParameter("codsince");
        String codpv = request.getParameter("codPV");
        String codsr = request.getParameter("codSR");
        
         request.setAttribute("tpconsulta",tpconsulta);
         request.setAttribute("codcedente",codcedente);
         request.setAttribute("codsince",codsince);
         request.setAttribute("codPV",codpv);
         request.setAttribute("codSR",codsr);
        
        
        codcedente = "0"+codcedente;
        codsince = "0"+codsince;
        codpv = "0"+codpv;
        codsr = "0"+codsr;
        

	    int paginaAtual = 1;
        try {
        	paginaAtual = Integer.parseInt(request.getParameter("pagina"));
        } catch (Exception e) {
        	paginaAtual = 1;
        }
	    Long registro = (long) (paginaAtual * 20) - 19;	        
	   	Long codCedente = Long.valueOf(codcedente);
		Long codSINCE = Long.valueOf(codsince);
		Long codPV = Long.valueOf(codpv);
		Long codSR = Long.valueOf(codsr);
		
		ClienteSINCEBean clienteSince = new ClienteSINCEBean();
		    
	    clienteSince.setCodcedente(codCedente);
	    clienteSince.setCodPV(codPV);
	    clienteSince.setCodsince(codSINCE);
	    clienteSince.setCodSR(codSR);
	    clienteSince.setPaginaPesq(registro);
	    clienteSince.setTpconsulta(Long.valueOf(tpconsulta));
		
	    //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
	    List list = null;
	    
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANS_LISTAR_SINCE + usuarioBean.getCodigoUsuario().toUpperCase();
	    list = (List) handler.executeFixDataRecordsetTransaction(clienteSince, transUser);
	       	        
	    BeanList clienteSinceList = null;
        
	    

        ArrayList resultado = convertDataStructure(((BeanList) list.get(1)).iterator());
	    
	    clienteSince = (ClienteSINCEBean) ((BeanList) list.get(0)).get(0);
	    
	    
	    
	    request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(resultado));
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
        request.setAttribute(PaginacaoTag.PAGINA_TOTAL,   (int) Math.ceil(clienteSince.getTotalRegistros() / 20.0));
          
          
        return PAGE_LISTAR;
    }
    
    

    

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_FILTRO);
    }
}
