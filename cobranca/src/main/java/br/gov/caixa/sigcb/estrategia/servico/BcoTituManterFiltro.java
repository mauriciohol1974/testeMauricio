package br.gov.caixa.sigcb.estrategia.servico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.ClienteSINCEBean;
import br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean;
import br.gov.caixa.sigcb.bean.ContaCreditoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.bean.TituloListarBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class BcoTituManterFiltro extends BcoTituEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Define informacoes de acesso a proxima pagina.
        String pagina = PAGE_ERRO;

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            tituloBean = (TituloBean) tituloBean.getRequestBean(request);
            tituloBean.setMeioEntrada(new Long(1));

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

            // Define pagina de destino
            LogUtilSigcb.debug("::::>>>>VARIAVEIS<<<<<:::::");
            LogUtilSigcb.debug("::::>>>>Filtro::::>>>" + tituloBean.getFiltroSelecao());
            
            if (tituloBean.getFiltroSelecao().equals(new Long(1)) || tituloBean.getFiltroSelecao().equals(new Long(4)) || 
            		tituloBean.getFiltroSelecao().equals(new Long(5)) || tituloBean.getFiltroSelecao().equals(new Long(6))) {
                pagina = paginaPorNossoNumero(request, response, tituloBean);
            } else if (tituloBean.getFiltroSelecao().equals(new Long(2))) {
                if (tituloBean.getSituacao().intValue() == 99)
                    pagina = paginaPorConsolidado(request, response, tituloBean);
                else
                    pagina = paginaPorSituacao(request, response, tituloBean);
            } else if (tituloBean.getFiltroSelecao().equals(new Long(3))){
            	// Saida de arquivo

            	Vector<TituloListarBean> tituloExportarBean = (Vector) request.getSession().getAttribute("tituloExportarBean");

            	LogUtilSigcb.debug("::::>>>>tituloExportarBean::::>>>" + tituloExportarBean.size());
            	
            	ServletOutputStream out = response.getOutputStream();
            	
            	response.setHeader("Content-Disposition","attachment;filename=ConsultaTitulo.csv");
            	response.setContentType("application/x-download");		
            	response.setHeader ("Pragma", "public");
            	response.setHeader("Cache-control", "must-revalidate");
     			
            	String linhas[] = new String[tituloExportarBean.size()];
            	
            	String cabecalho[] = new String[5];
            	
            	
            	for (int x=0;x<tituloExportarBean.size();x++){
            		TituloListarBean titulo = (TituloListarBean) tituloExportarBean.get(x);
            		linhas[x] = "'"+ titulo.getNossoNumeroFormatado()+"'" + ";" + titulo.getNomeSacado() + ";" + titulo.getCpfSacado() + ";" + titulo.getValor().toString() + ";" + titulo.getDtInclusaoFormatada() + ";" +
            				    titulo.getDataVencimentoFormatada() + ";" + titulo.getIndProtesto() + ";" + titulo.getPrazoProtDev() + ";" + titulo.getDtBaixaFormatada() + ";" +  titulo.getValorPago() + ";" +
            				    titulo.getCodigoUsuario() + ";" + titulo.getDataUltimoComandoFormatada() + ";" + titulo.getCodigoUltimoComando();
            	}
            	
            	cabecalho[0] = "Cedente: " +  tituloBean.getCodigoCedenteFormatado() + "\r\n"; 
                cabecalho[1] = "Filtro por: " + tituloBean.getFiltroDescricaoSituacao() + "Classificado por: " +tituloBean.getFiltroDescricaoClassificacao() + "\r\n";
	  	        cabecalho[2] = "Banco de Títulos" + "\r\n";;
	  	        cabecalho[3] = "========================================================================================================================================" + "\r\n";
	  	        cabecalho[4] = "Nosso Numero;Nome Sacado;CPF/CNPJ do sacado;Valor;Inclusao;Vencimento;Protesto;Prazo;Dt. Baixa;Valor Pago;Usuario;Ultimo Comando;Cod. Ult. Comando" + "\r\n";
            	
	  	        out.write(cabecalho[0].getBytes());
	  	        out.write(cabecalho[1].getBytes());
	  	        out.write(cabecalho[2].getBytes());
	  	        out.write(cabecalho[3].getBytes());
	  	        out.write(cabecalho[4].getBytes());
            	
     			for (int i=0;i < linhas.length  ;i++){
     				String linha = linhas[i] + "\r\n";
     				out.write(linha.getBytes());
     			}
     			
     			out.write(cabecalho[3].getBytes());
     			 
     			TituloListarBean total = (TituloListarBean) request.getSession().getAttribute(DATA_FIXO_LIST);
     			
     			int totRegistrosLista = tituloExportarBean.size();
     			TituloListarBean contar = new TituloListarBean();
     			double valorTotal = 0;
     			for (int i=0;i<tituloExportarBean.size();i++){
     				contar = (TituloListarBean) tituloExportarBean.get(i);
     				valorTotal = valorTotal + contar.getValor().toDouble() * 100;
     				
     			}
     			
     			long totalLng = (long) valorTotal;
     			
     			Money mnValorTotal = new Money(Util.zerosEsquerda(totalLng, 15), 2, Currency.real());
     			 
     			String totalStr = "Quantidade Total: " + totRegistrosLista + "                Valor Total:" + mnValorTotal;
     			out.write(totalStr.getBytes());
     			out.flush();
     			out.close();
            }

        } else {
            // Obtem dados do request:

            TituloBean reqTituloBean = new TituloBean();
            reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);

            // Obtem dados:
            if (getFluxo(request).equals("voltar")) {
            	//tituloBean = (TituloBean) tituloBean.getSessionBean(request, FILTRO_BEAN);
            	TituloBean tituloTemp = (TituloBean) tituloBean.getSessionBean(request, FILTRO_BEAN);
            	if (tituloTemp==null){
            		tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
            	}else{
            		tituloBean = (TituloBean) tituloBean.getSessionBean(request, FILTRO_BEAN);
            	}
            }else{
            	tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
            }
           
            Long nossoNumero = tituloBean.getNossoNumero();
            Date dtIni = tituloBean.getDataInicio();
            Date dtFim = tituloBean.getDataFim();
            String cmbEmissao = tituloBean.getCmbEmissao();
            String cmbCarteira = tituloBean.getCmbCarteira();
            copyTituloDadosFiltroToTitulo(reqTituloBean, tituloBean);
            
            tituloBean.setNossoNumero(nossoNumero);
            tituloBean.setDataFim(dtFim);
            tituloBean.setDataInicio(dtIni);
            tituloBean.setCmbCarteira(cmbCarteira);
            tituloBean.setCmbEmissao(cmbEmissao);
            // Define pagina de destino 
            if ( tituloBean.getFiltroVoltarAcao().equals(new Long(1)) || tituloBean.getFiltroVoltarAcao().equals(new Long(4)) || tituloBean.getFiltroVoltarAcao().equals(new Long(5)) || tituloBean.getFiltroVoltarAcao().equals(new Long(6))){
            	tituloBean.setMeioEntrada((long)1);
                pagina = paginaPorNossoNumero(request, response, tituloBean);
            }else if (tituloBean.getFiltroVoltarListarTitulo().equals(new Long(1)))
                pagina = paginaPorSituacao(request, response, tituloBean);
            else if (tituloBean.getFiltroVoltarListarConsolidado().equals(new Long(1)))
                pagina = paginaPorConsolidado(request, response, tituloBean);
        }

        // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
        setDadosPvVinculacao(request, tituloBean);

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        return pagina;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    private String paginaPorNossoNumero(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Obtem bean com informacoes da guia "Dados Principais (BG60)"
        tituloBean = getTituloDadosPrincipais(request, response, tituloBean);
        // Obtem bean com informacoes da guia "Dados Encargos Abatimentos
        // (BG66)"
        String parcela = tituloBean.getParcela();
        String coErroCIP = tituloBean.getCoErroCIP();
        String dtCompetencia = tituloBean.getDtCompetencia();
        String tpPessoaPrt = tituloBean.getTpPessoaPrt();
        String cpfCnpjPrt = tituloBean.getCpfCnpjPrt();
        String snBaixa = tituloBean.getSnBaixa();
        tituloBean = getTituloDadosEncargosAbatimentos(request,  response,  tituloBean);
        tituloBean.setParcela(parcela);
        tituloBean.setCoErroCIP(coErroCIP);
        tituloBean.setDtCompetencia(dtCompetencia);
        tituloBean.setTpPessoaPrt(tpPessoaPrt);
        tituloBean.setCpfCnpjPrt(cpfCnpjPrt);
        tituloBean.setSnBaixa(snBaixa);
        
        
        if (tituloBean.getIcRateio().equalsIgnoreCase("S")){
        	// Carregar os dados de rateio
        	
            //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            ContaCreditoBean contaCredito = new ContaCreditoBean();
            contaCredito.setCedente(tituloBean.getCodigoCedente());
            contaCredito.setNossoNumero(tituloBean.getNossoNumero());
            List list = null;
		    
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = "BGZP" + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList contaCreditoList = handler.executeSimpleTransactionQuery(contaCredito,transUser);
            ArrayList contaCreditoArrayList = convertDataStructure(contaCreditoList.iterator());
            
		    
	        request.getSession().setAttribute("listaContaCredito", contaCreditoArrayList);
           
        } else {
        	request.getSession().removeAttribute("listaContaCredito");
        }
        

        // Retem informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, tituloBean);
              
        return PAGE_FILTRO_ACAO;
    }

    private String paginaPorSituacao(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {
        
    	//Verificar se existe arquivo de consulta disponivel na pasta
     	ArrayList tituloList;
    	String arquivo = "";
     	File [] listFiles = new File(File.separator+"apl"+File.separator+"sigcb").listFiles();
     	
  	    // Filtrar arquivo
  	    boolean encontrou = false;
  	    for(int i=0; i < listFiles.length; i++){
  		    	  if (listFiles[i].getName().contains("BT" + Formatacao.formataNumerico(String.valueOf(tituloBean.getCodigoCedente()),6))){
  					  arquivo = File.separator+"apl"+File.separator+"sigcb" + File.separator + listFiles[i].getName();
  					  LogUtilSigcb.debug("ENCONTROU");
  					  encontrou = true;
  			      }
  	    }
  	    
    	
 
  	    if (encontrou){
  	    	File dadosArq = new File(arquivo);
  	    	LogUtilSigcb.debug("NOME DO ARQUIVO:" + arquivo);
  	    	
  	    	FileInputStream streamTemp = new FileInputStream(arquivo); 
  	    	InputStreamReader streamReaderTemp = new InputStreamReader(streamTemp); 
  	    	BufferedReader readerTemp = new BufferedReader(streamReaderTemp);  
  	    	String lineTemp = null;
  	    	String regTemp = "";
  	    	while( (lineTemp=readerTemp.readLine() ) != null ) { 
  	    		regTemp = lineTemp.substring(0, lineTemp.length());
  	    	}
  	    	
  	    	readerTemp.close();
  	    	streamReaderTemp.close();
  	    	streamTemp.close();
  	    	
  	    	if (!regTemp.trim().equalsIgnoreCase("EOF")){
  	    		throw new Exception("ARQUIVO AINDA NÃO TRANSFERIDO TOTALMENTE FAVOR AGUARDAR!!!");
  	    	}
  	    	
  	    	FileInputStream stream = new FileInputStream(arquivo); 
  	    	InputStreamReader streamReader = new InputStreamReader(stream); 
  	    	BufferedReader reader = new BufferedReader(streamReader);  
  	    	String line = null;
  	    	tituloList = new ArrayList<TituloListarBean>();
  	    	TituloListarBean tituloFixo = new TituloListarBean();
  	    	int numeroRegistros = 0;
  	    	while( (line=reader.readLine() ) != null ) { 
  	    		TituloListarBean titulo = new TituloListarBean();
  	    		String registro = line.substring(1, line.length());
  	    		numeroRegistros++;
  	    		if (line.substring(0, 1).equalsIgnoreCase("1")){
  	    		    String nuCedente = registro.substring(0,6);
  	    		    String noCedente = registro.substring(6, 46);                       
  	    		    String nuTpPessoa = registro.substring(46,47);      
  	    		    String dePessoa= registro.substring(47,55);      
  	    		    String cocli= registro.substring(55,70);               
  	    		    //String dtInclusao  = registro.substring(70,78);             
  	    		    tituloFixo.setCodigoCedente(new Long(nuCedente));
  	    		}else if (line.substring(0, 1).equals("2") && numeroRegistros<450000){
  	  	    		String nossoNumero = registro.substring(0,18);
  	  	    		String nomeSacado = registro.substring(18,58);
  	  	    		String valorTitulo = registro.substring(58, 73);
  	  	    		String dataVcto = registro.substring(73,81);
  	  	    		String dtSolicita = registro.substring(81,89 );
  	  	    		String nuUltComando = registro.substring(89,92);
  	  	    		String coUsuario = registro.substring(92,100 );  
  	  	    	    String deUltComando = registro.substring(100,150 );
  	  	    		String cpfSacado = registro.substring(150,168 );
  	  	    		String dtInclusaoStr =  registro.substring(168,176 );
  	  	    		String indProtesto = registro.substring(176,180 );
  	  	    		String prazoProtDev = registro.substring(180,183 );
  	  	    		String dtBaixaStr = registro.substring(183,191 );
  	  	    		String valorPago = registro.substring(191,206 );
  	  	    		String parcela = "";
  	  	    		if (registro.length()>206){
  	  	    			 parcela = registro.substring(206,213);
  	  	    		}
  	  	    		Money mnvalorTitulo = new Money(Util.zerosEsquerda(new Long(valorTitulo), 15), 2, Currency.real());
  	  	    		Money mnvalorPago = new Money(Util.zerosEsquerda(new Long(valorPago), 15), 2, Currency.real());
  	    			DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
  	      	        Date dtVencimento = (java.util.Date)formatter.parse(dataVcto);	
  	      	        Date dtInclusao = (java.util.Date)formatter.parse(dtInclusaoStr);
  	      	        Date dtBaixa = (java.util.Date)formatter.parse(dtBaixaStr);	
  	  	    		titulo.setNossoNumero(new Long(nossoNumero));
  	  	    		titulo.setNomeSacado(nomeSacado);
  	  	    		titulo.setCpfSacado(cpfSacado);
  	  	    		titulo.setValor(mnvalorTitulo);
  	  	    		titulo.setDtInclusao(dtInclusao);
  	  	    		titulo.setDataVencimento(dtVencimento);
  	  	    		titulo.setIndProtesto(indProtesto);
  	  	    		titulo.setPrazoProtDev(prazoProtDev);
  	  	    		titulo.setDtBaixa(dtBaixa);
  	  	    		titulo.setValorPago(mnvalorPago);
  	  	    		titulo.setCodigoUsuario(coUsuario);
  	  	    		titulo.setUltDescricao(deUltComando);
  	  	    		titulo.setCodigoUltimoComando(Long.valueOf(nuUltComando));
  	  	    		titulo.setParcela(parcela);
  	  	    		
  	  	    		tituloList.add(titulo);
  	    		}else  if (line.substring(0, 1).equalsIgnoreCase("9") || line.substring(0, 1).equalsIgnoreCase("0")){
  	    			String qtdeTotal = registro.substring(0,8);
  	    		    String valorTotal = registro.substring(8, 26);
  	    		    String totalRegistros = registro.substring(26, 34);
  	    		    Money mnvalorTotal = new Money(Util.zerosEsquerda(new Long(valorTotal), 15), 2, Currency.real());
  	    		    if (registro.length()>34){
  	    		    	String periodo = registro.substring(34, registro.length());
  	    		    	tituloFixo.setDePeriodo(periodo);
  	    		    }else{
  	    		    	tituloFixo.setDePeriodo("");
  	    		    }
  	    		    tituloFixo.setQuantidadeTotal(new Long(qtdeTotal));
  	    		    tituloFixo.setValorTotal(mnvalorTotal);
  	    		    tituloFixo.setQuantidade(new Long(totalRegistros));
  	    		    
  	    		}

  	    	}
  	    	
  	    	
  	    	
  	    	reader.close();
  	    	stream.close();
		
	    	if (tituloList.size()==0){
	    		throw new Exception("ARQUIVO TRANSFERIDO NAO POSSUI TÍTULOS!!!");
	    	}
	    	
  	    	LogUtilSigcb.debug("LEU ARQUIVO ATE O FIM");

    		dadosArq.delete();
  	    	request.getSession().setAttribute("ORIGEM", "A");
  	    	request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(tituloList));
  	    	request.getSession().setAttribute(DATA_FIXO_LIST, tituloFixo);
  	    	request.getSession().setAttribute("TotalRegistros", String.valueOf(tituloFixo.getQuantidade()));
  	    	
  	    	Vector<TituloListarBean> tituloExportarBean = new Vector<TituloListarBean>();
  	    	
  	    	for (int i = 0; i < tituloList.size(); i++) {
  	    		tituloExportarBean.add((TituloListarBean) tituloList.get(i));
            }
  	    	
  	    	request.getSession().setAttribute("tituloExportarBean", tituloExportarBean);
        	
        	
        	
  	    	
  	    }else{

  	    	request.getSession().setAttribute("ORIGEM", "T");
  	    	// Obtem bean com informacoes para lista consolidada.
  	    	tituloList = (ArrayList) getTituloListarTitulo(request,response, tituloBean);
  	    	request.getSession().setAttribute(FILTRO_BEAN,tituloBean );
  	        request.getSession().setAttribute(DATA_FIXO_LIST, tituloList.get(0));
  	        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder((List) tituloList.get(1)));
  	        
  	        TituloListarBean qtdeTotal = ((TituloListarBean) tituloList.get(0));
  	        
  	        request.getSession().setAttribute("TotalRegistros", String.valueOf(qtdeTotal.getQuantidadeTotal()));
  	        
	  	    Vector<TituloListarBean> tituloExportarBean = new Vector<TituloListarBean>();
	  	    
			ArrayList titulos = (ArrayList) tituloList.get(1);
			for (int i = 0; i < titulos.size(); i++) {
				TituloListarBean titIndividual = (TituloListarBean)titulos.get(i);
				tituloExportarBean.add(titIndividual);
		    }
			
		    request.getSession().setAttribute("tituloExportarBean", tituloExportarBean);
		    
		    
		    
  	    	
  	    }

        // Retem informacoes do bean depois do acesso ao mainframe
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_FILTRO_LISTAR_TITULO;
    }

    private String paginaPorConsolidado(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Obtem bean com informacoes para lista consolidada.
        ArrayList tituloList = (ArrayList) getTituloListarConsolidado(request,
                response,
                tituloBean);

        // Retem informacoes do bean depois do acesso ao mainframe
        PageHolder paginacao = getPageHolder((List) tituloList.get(1));
        paginacao.setPageSize(((List) tituloList.get(1)).size());

        request.getSession().setAttribute(DATA_FIXO_LIST, tituloList.get(0));
        request.getSession().setAttribute(PAGINACAO_LIST, paginacao);
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_FILTRO_LISTAR_CONSOLIDADO;
    }

    // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
    private void setDadosPvVinculacao(HttpServletRequest request,
            TituloBean tituloBean) throws Exception {
        CedenteGeralBean cedGeralBean = new CedenteGeralBean();
        cedGeralBean = (CedenteGeralBean) cedGeralBean.newBean();
        // Definindo atributos para executar a transação BG03 para obter
        // informações do cedente para setar campos
        cedGeralBean.setTipoConsulta("C");
        cedGeralBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Chama aS Transacões
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedGeralBeanList = handler.executeSimpleTransactionQuery(cedGeralBean, transUser);
        CedenteGeralBean ceGeralBean = (CedenteGeralBean) cedGeralBeanList.get(0);
        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, ceGeralBean);
    }

}