package br.gov.caixa.sigcb.estrategia.consulta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean;
import br.gov.caixa.sigcb.bean.ExtratoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento do cedente -(EXTRATO)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class MCExtraManterImprimir extends MCExtraEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

      
        
        request.setAttribute("codigoCedente", request.getParameter("codigoCedente"));
        request.setAttribute("dataEmissao", request.getParameter("dataEmissao"));
        
        String codigoCedente = (String) request.getAttribute("codigoCedente");
        String dataEmissao = (String) request.getAttribute("dataEmissao");
        
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formataHora = new SimpleDateFormat("hh");
    	String data = formata.format(new Date());
    	String hora = formataHora.format(new Date());
       
        String fluxo = getFluxo(request);
        String arquivo = "";
   	 	File [] listFiles = new File(File.separator+"apl"+File.separator+"sigcb").listFiles();
		
	    // Filtrar arquivo
	    boolean encontrou = false;
	    for(int i=0; i < listFiles.length; i++){
		    	  if (listFiles[i].getName().contains("CD" + Formatacao.formataNumerico(codigoCedente,6))){
					  arquivo = File.separator+"apl"+File.separator+"sigcb" + File.separator + listFiles[i].getName();
					  encontrou = true;
			      }
	    }
	    int numeroRegistros = 0;
	    if (encontrou){
	    	FileInputStream stream = new FileInputStream(arquivo); 
	    	InputStreamReader streamReader = new InputStreamReader(stream); 
	    	BufferedReader reader = new BufferedReader(streamReader);  
	    	String line = null; 
	    	ArrayList arrayPaginacao = new ArrayList<ConGerMovimentoCedenteBean>();
	    	ArrayList arrayLiquidacao = new ArrayList<ConGerMovimentoCedenteBean>();
	    	ConGerMovimentoCedenteBean debCredBean = new ConGerMovimentoCedenteBean();
	    	CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
	    	
	    	while( (line=reader.readLine() ) != null ) { 
	    		if (line.substring(0, 1).equalsIgnoreCase("1")){
	    			String registro = line.substring(0, line.length());
	    			String nuCedente = registro.substring(1, 7);
	    			String noCedente = registro.substring(7, 47);
	    			String tpPessoa = registro.substring(47, 48);
	    			String deCpfCnpj = registro.substring(48, 62);
	    			String coCli = registro.substring(62, 77);
	    			String dataInclusao = registro.substring(62, 70);
	    			
	    			DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	      	        Date dtInclusao = (java.util.Date)formatter.parse(dataInclusao);	
	    			
	    			cedCabBean.setCodigoCedente(new Long(nuCedente));
	    			cedCabBean.setNomeFantasia(noCedente);
	    			cedCabBean.setTipoPessoa(new Long(tpPessoa));
	    			cedCabBean.setCpfCnpj(new Long(deCpfCnpj));
	    			cedCabBean.setCodigoClienteCOCLI(new Long(coCli));
	    						
				
	    		}else if (line.substring(0, 1).equalsIgnoreCase("2") && numeroRegistros<150000 ){
	    			String registro = line.substring(0, line.length());
	    			ConGerMovimentoCedenteBean occ = new ConGerMovimentoCedenteBean();
	    			
	    			String tpMovimento = registro.substring(1,4);
	    			String descrMovimento = registro.substring(4, 44);
	    			String nomeSacado = registro.substring(44, 84);
	    			String dataVencimento= registro.substring(84, 92);
	    			String dataMovimento=registro.substring(92, 100);
	    			String dataPagamento=registro.substring(100, 108);
	    			String nossoNumero=registro.substring(108, 125);
	    			String seuNumero=registro.substring(125, 140);
	    			String valorTitulo=registro.substring(140, 150);
	    			String valorEncargos=registro.substring(150, 159);
	    			String valorAbatimento=registro.substring(159,168);
	    			String valorDesconto=registro.substring(168,177);
	    			String valorCredito=registro.substring(177, 187);
	    			String valorIOF=registro.substring(187, 196);
	    			String dataCredito=registro.substring(196, 204);
	    			String valorTarifa=registro.substring(204, 211);
	    			String feriadoLocal=registro.substring(211, 241);
	    			
	    			DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	      	        Date dtVencimento = (java.util.Date)formatter.parse(dataVencimento);	    
	      	        Date dtMovimento = (java.util.Date)formatter.parse(dataMovimento);
	      	        Date dtPagamento = (java.util.Date)formatter.parse(dataPagamento);
	      	      	Date dtCredito = (java.util.Date)formatter.parse(dataCredito);
	    			
	                Money mnvalorTitulo = new Money(Util.zerosEsquerda(new Long(valorTitulo), 15), 2, Currency.real());
	                Money mnvalorEncargos = new Money(Util.zerosEsquerda(new Long(valorEncargos), 15), 2, Currency.real());
	                Money mnvalorAbatimento = new Money(Util.zerosEsquerda(new Long(valorAbatimento), 15), 2, Currency.real());
	                Money mnvalorDesconto = new Money(Util.zerosEsquerda(new Long(valorDesconto), 15), 2, Currency.real());
	                Money mnvalorCredito = new Money(Util.zerosEsquerda(new Long(valorCredito), 15), 2, Currency.real());
	                Money mnvalorIOF = new Money(Util.zerosEsquerda(new Long(valorIOF), 15), 2, Currency.real());
	                Money mnvalorTarifa = new Money(Util.zerosEsquerda(new Long(valorTarifa), 15), 2, Currency.real());
	                
	                occ.setCodigoMovimento(new Long(tpMovimento));
	                occ.setDescricaoMovimento(descrMovimento);
	    			occ.setNomeSacado(nomeSacado);
	    			occ.setDataVencimento(dtVencimento);
	    			occ.setDataMovimento(dtMovimento);
	    			occ.setDataPagamento(dtPagamento);
	    			occ.setNossoNumero(new Long(nossoNumero));
	    			occ.setSeuNumero(seuNumero);
	    			occ.setValorTitulo(mnvalorTitulo);
	    			occ.setValorEncargos(mnvalorEncargos);
	    			occ.setValorAbatimento(mnvalorAbatimento);
	    			occ.setValorDesconto(mnvalorDesconto);
	    			occ.setValorCredito(mnvalorCredito);
	    			occ.setValorIOF(mnvalorIOF);
	    			occ.setDataCredito(dtCredito);
	    			occ.setValorTarifa(mnvalorTarifa);
	    			occ.setFeriadoLocal(feriadoLocal);
	    			
		        	arrayPaginacao.add(occ);
		        	
		        	numeroRegistros++;
		        	
		        	
	    		}else if(line.substring(0, 1).equalsIgnoreCase("3")){
	    			String registro = line.substring(0, line.length());
	    			
	    			String quantidadeApurada = registro.substring(2, 11);
	    			String valorPeriodo = registro.substring(11, 23);
	    			
	    			Money mnvalorPeriodo = new Money(Util.zerosEsquerda(new Long(valorPeriodo), 15), 2, Currency.real());
	    			
	    			if (registro.substring(1, 2).equalsIgnoreCase("1")) { // Credito

		    			debCredBean.setQtdCreditoPeriodo(new Long(quantidadeApurada));
		    			debCredBean.setValorCreditoPeriodo(mnvalorPeriodo);
	    				
	    			} else {
		    			debCredBean.setQtdDebitoPeriodo(new Long(quantidadeApurada));
		    			debCredBean.setValorDebitoPeriodo(mnvalorPeriodo);
	    			}
	    			
	    			
	    			
	    		}else if(line.substring(0, 1).equalsIgnoreCase("4")){
	    			String registro = line.substring(0, line.length());
	    			ConGerMovimentoCedenteBean liq = new ConGerMovimentoCedenteBean();
	    			
	    			String cdDescricao = registro.substring(1, 4);
	    			String qtde = registro.substring(4, 12);
	    			String valor = registro.substring(12, 24);
	    			
	    			Money mnvalor = new Money(Util.zerosEsquerda(new Long(valor), 15), 2, Currency.real());
	    			
	    			liq.setCodigoCanal(new Long(cdDescricao));
	    			liq.setQuantidade(new Long(qtde));
	    			liq.setValorRecebido(mnvalor);
	    			
	    			arrayLiquidacao.add(liq);
	    					
	    		}
	    	}

	    	reader.close();
	    	streamReader.close();
	    	stream.close();
	    	
	    	//File excluirArq = new File(arquivo);
	    	//excluirArq.delete();	
	    	
	        int paginaAtual = 1;
	        try {
	            paginaAtual = Integer.parseInt(request.getParameter("pagina"));
	        } catch (Exception e) {
	        }
	        request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
	        request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(numeroRegistros / 20.0));

	        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);
	        request.getSession().setAttribute("listaExtrato", arrayPaginacao);
	        request.getSession().setAttribute("ORIGEM", "A");
	        request.getSession().setAttribute(BEAN_DEBCRED, debCredBean);
	        request.getSession().setAttribute(LIQUIDACAO_LIST, getPageHolder(arrayLiquidacao));
	        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(arrayPaginacao));
           
	        request.setAttribute(PAGINACAO_PAGE, "0");
	        	
	        return PAGE_IMPRIMIR;
		   
	    }else{
	    	

	    	String pagina = "";
	    	
	    	MCExtraManterFiltroAntigo strPag = new MCExtraManterFiltroAntigo();
	    	pagina = strPag.processRequest(request, response);
	    	return PAGE_IMPRIMIR;
        
	    }
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);

    }

    

}
