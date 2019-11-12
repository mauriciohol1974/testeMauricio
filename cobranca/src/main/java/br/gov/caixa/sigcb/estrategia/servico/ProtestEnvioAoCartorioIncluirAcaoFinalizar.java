package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.util.PageableList;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.ProtestoTituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;




/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto >> Envio ao Cartório - Lista - Incluir
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abr/2009</DD>
 * </DL>
 * 
 * @author Cristian Souza - Probank/REDEASP02
 */
public class ProtestEnvioAoCartorioIncluirAcaoFinalizar extends ProtestEstrategia {

    private String custom_SUCESSO_ACAO = "";

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
        
        int paginaAtual = 0;
    	PageHolder paginacao = (PageHolder) request.getSession().getAttribute(ProtestEstrategia.PAGINACAO_LIST);
    	if(request.getParameter(ProtestEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ProtestEstrategia.PAGINACAO_PAGE).equals("")){
    		paginaAtual = Integer.parseInt((String)request.getParameter(ProtestEstrategia.PAGINACAO_PAGE));
    	} else {
    		paginaAtual = Integer.parseInt((String)request.getAttribute(ProtestEstrategia.PAGINACAO_PAGE));
    	}
    	
    	String controleAlteracao = "";

    	if(request.getParameter("controleAlteracao") != null && !request.getParameter("controleAlteracao").equals("")){
    		controleAlteracao  = (String)request.getParameter("controleAlteracao");
    	} else {
    		controleAlteracao =  (String)request.getAttribute("controleAlteracao");
    	}
    	
    	//  A String com o controle de alteração possui o formato:
    	//  #0#|[0]R$ 1.750,00|[1]R$ 630,95|[7]R$ 815,92
    	//	#0# --> Nùmero da página
    	//  [0]R$ 1.750,00 --> Índice selecionado e seu respectivo valor


    	
    	if ((controleAlteracao != null) && (controleAlteracao.length() > 0)) {
    		   String pagina = controleAlteracao.substring(controleAlteracao.indexOf("#")+1,controleAlteracao.lastIndexOf("#"));
    		   int lastCerquilha = controleAlteracao.lastIndexOf("#");
    		   String dados = controleAlteracao.substring(lastCerquilha+1);
    		   StringTokenizer strTokenizer = new StringTokenizer(dados,"|");
    		   ArrayList<String> valores = new ArrayList<String>();
    		   while(strTokenizer.hasMoreElements()) {
    			   valores.add((String)strTokenizer.nextElement());
    			   
    		   }
    		   
    		   Iterator i = valores.iterator();
    		   HashMap<Integer, Money> map = new HashMap<Integer, Money>();
    		   
    		   while (i.hasNext()){
    			   
    			   String texto = (String)i.next();
    			   int pos = Integer.valueOf(texto.substring(texto.indexOf("[")+1,texto.lastIndexOf("]")));
    			   int lastChave = texto.lastIndexOf("]");
    			   String vlrCust = texto.substring(lastChave+1);
    			   
    			   if (vlrCust.trim().equals("")) {
    				   vlrCust = "R$ 0,00";
    			   }
    			   
    			   //Cria a partir da String com símbolo de R$ 
    			   Money m = (Money) MoneyType.create().newInstance(vlrCust);
    			   map.put(new Integer(pos), m);
    		   }
    		   

    		   List listaAnterior = paginacao.getPage(Integer.valueOf(pagina));
    		   

    		   //Desmarca na lista os checks que foram marcados e posteriormente desmarcados
    		   Set keys = map.keySet();
    		   for (int j= 0 ; j < listaAnterior.size(); j++) {
    			if (!keys.contains(Integer.valueOf(j))) {
    			   ProtestoTituloBean protest= (ProtestoTituloBean)listaAnterior.get(Integer.valueOf(j));
    		           if ((Boolean.TRUE).equals(protest.getSelecaoCheck())){
    				Money valor = (Money) MoneyType.create().newInstance("R$ 0,00");
    				protest.setValorCusta(valor);
    			   	protest.setSelecaoCheck(Boolean.FALSE);       	

    			   }		

    			}
    		
    		   }


    		   Iterator iterat = keys.iterator(); 		
    		   while (iterat.hasNext()){
    			   Integer chave  = (Integer)iterat.next();
    			   Money valor  = map.get(chave);
    			 
    			   ProtestoTituloBean protest= (ProtestoTituloBean)listaAnterior.get(chave.intValue());
    			   protest.setValorCusta(valor);	
    	           	   protest.setSelecaoCheck(Boolean.TRUE);	
    			   
    		   }	
    	  
    	}


    	
    	int quantidadeItensLista = paginacao.getPageableSize();
    	PageableList pageableLista =  (PageableList)paginacao.getPageable();
    	ArrayList listaOriginal = new ArrayList();
    	
    	for (int i=0 ; i < quantidadeItensLista; i++) {
    		listaOriginal.add(pageableLista.get(i));
    	}	
    	
    	ArrayList listaItensInclusao = new ArrayList();
    	
    	for (int i= 0 ; i < listaOriginal.size(); i++) {
 			   ProtestoTituloBean protest= (ProtestoTituloBean)listaOriginal.get(i);
 		       if ((Boolean.TRUE).equals(protest.getSelecaoCheck())){
 		    	  listaItensInclusao.add(protest);     	
 		       }	
 		}
    	
    	
    	ArrayList listaRecordsets  = montaRecordsets(listaItensInclusao);
    	
    	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
    	ProtestoTituloBean protestoBean= new ProtestoTituloBean();
    	//  Recupera informacoes do usuario
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
        protestoBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());        
        protestoBean.setNomeGrupo(usuarioBean.getNomeGrupo());
        
    	for (int i= 0 ; i < listaRecordsets.size(); i++) {
    		   String strRecordset = (String) listaRecordsets.get(i);
    		   protestoBean.setStrRecordset(strRecordset);
    		    usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
               String transUser = TRANSACAO_PROTESTO_ENVIO_CARTORIO_INCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
		       handler.executeSimpleTransactionVoid(protestoBean,
		    		   transUser);

		}
    	
    	return PAGE_ENVIO_AO_CARTORIO_INCLUIR_SUCESSO;

    }
    
    private ArrayList montaRecordsets(List listaItensInclusao) throws Exception {
    	ArrayList listaRecordsets = new ArrayList();
    	
    	//Quantidade de registros por rajada
    	int registrosPorRajada = 25; 

    	// Número rajada
        int registros = 0;
        
        StringBuffer strRecordsetBuffer  = new StringBuffer();
        
        for (int i= 0 ; i < listaItensInclusao.size(); i++) {
        	   registros++;	
			   ProtestoTituloBean protest= (ProtestoTituloBean)listaItensInclusao.get(i);
		       strRecordsetBuffer.append(protest.getCodigoCedenteFormatado());
		       strRecordsetBuffer.append(protest.getNossoNumeroFormatado());
		       Money vlrCusta = protest.getValorCusta();
		       String vlrCustaStr = vlrCusta.toBigDecimal().toString();
			   String result = "";
			   for (int n = 0; n < vlrCustaStr.length(); n++) {
			         if (vlrCustaStr.charAt(n) != '.') {
			             result = result + vlrCustaStr.charAt(n);
			         }    
				   
			   }
			   String valorCustaFormatado = (Util.zerosEsquerda(Long.valueOf(result),7));
		       strRecordsetBuffer.append(valorCustaFormatado);
		       
		       if (registros == registrosPorRajada) {
	                listaRecordsets.add(strRecordsetBuffer.toString());
	                strRecordsetBuffer = new StringBuffer();
	                registros = 0;
	           }

		}
        
        //  Se houver ainda registros adiciona no ArrayList
        if (registros > 0) {
            listaRecordsets.add(strRecordsetBuffer.toString());
        }

        return listaRecordsets;
    
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Ação " + this.custom_SUCESSO_ACAO + SUCESSO_ACAO);
        msgBean.setStrategyErrorReturn(STRATEGY_ENVIO_AO_CARTORIO_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_ENVIO_AO_CARTORIO_INICIAR);
        msgBean.setTitlePage(PAGE_ENVIO_AO_CARTORIO_INICIAR_TITLE );
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}