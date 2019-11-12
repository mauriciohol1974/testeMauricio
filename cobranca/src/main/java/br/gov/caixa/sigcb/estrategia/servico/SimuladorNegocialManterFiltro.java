package br.gov.caixa.sigcb.estrategia.servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CanalSimulacaoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.CnpjBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SegundaViaExtratoBean;
import br.gov.caixa.sigcb.bean.SimulacaoBean;
import br.gov.caixa.sigcb.bean.TarifaSimulaBean;
import br.gov.caixa.sigcb.bean.TarifaSimulacaoEnvio;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Tarifas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class SimuladorNegocialManterFiltro extends ServicoEstrategia {

    public String processRequest(HttpServletRequest request,   HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        String fluxo = getFluxo(request);
        
      
        
      //  MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        
    	CedenteCabecaBean cedenteCabecaBean = (request.getSession().getAttribute(ServicoEstrategia.CEDENTE_CABECA_BEAN)==null
                ? new CedenteCabecaBean()
                : (CedenteCabecaBean) request.getSession().getAttribute(ServicoEstrategia.CEDENTE_CABECA_BEAN));
      
        String tokenStr = this.obterToken();
        
        String cnpj =(String) request.getParameter("cnpj");
        String nuSimulacao = (String) request.getParameter("nu_simulacao");
        String JSONSimulacao = "";
        if (cnpj.trim().length()>0){ 
        	// pesquisa CPNPJ
        	  JSONSimulacao = this.obterSimulacaoCNPJ(tokenStr, cnpj, usuarioBean.getCodigoUsuario(),usuarioBean.getCodigoUnidade() );
        }else{
        	// pesquisa simulacao
        	  JSONSimulacao = this.obterSimulacaoNuSimulacao(tokenStr, nuSimulacao, usuarioBean.getCodigoUsuario(),usuarioBean.getCodigoUnidade() );
        }
        
        LogUtilSigcb.debug("Retorno JSON:"+ JSONSimulacao);
        
        //Tratar o retorno do JSON aqui
        
        JSONObject simulacaoObject = JSONObject.fromObject( JSONSimulacao ); 
         
        SimulacaoBean simulacaoBean = new SimulacaoBean();
        
        if (simulacaoObject.getInt("nu_simulacao")>0){
        
	        simulacaoBean.setNu_simulacao((long)simulacaoObject.getInt("nu_simulacao"));
	        simulacaoBean.setSituacao(simulacaoObject.getString("situacao"));
	        simulacaoBean.setCnpj(String.valueOf(simulacaoObject.get("cnpj")));
	        simulacaoBean.setDataValidade(simulacaoObject.getString("dataValidade"));
	        simulacaoBean.setTipoTransmissao((long)simulacaoObject.getInt("tipoTransmissao"));
	        simulacaoBean.setUsuarioAutorizador(simulacaoObject.getString("usuarioAutorizador"));
	        simulacaoBean.setUnidadeAutorizador((long)simulacaoObject.getInt("unidadeAutorizador"));
	        simulacaoBean.setNSU((long)simulacaoObject.getInt("NSU"));
	        simulacaoBean.setDataSolicitacao(simulacaoObject.getString("dataSolicitacao"));
	 
	        ArrayList<TarifaSimulaBean> tarifaSimulacao = new ArrayList<TarifaSimulaBean>();
	        
	        JSONArray jsonArray = simulacaoObject.getJSONArray("Tarifas");
	        
	        for (int i=0;i<jsonArray.size();i++) {
	          
	        	JSONObject tarifaObject = JSONObject.fromObject( jsonArray.get(i).toString() ); 
	            TarifaSimulaBean tarifa = new TarifaSimulaBean();
	            tarifa.setCoTarifa(String.valueOf(tarifaObject.getInt("co_tarifa")));
	            tarifa.setVrTarifa(String.valueOf(tarifaObject.get("vr_tarifa")));
	            tarifa.setPercTarifa(String.valueOf(tarifaObject.get("perc_tarifa")));
	            tarifaSimulacao.add(tarifa);
	           
	        }
	        
	        simulacaoBean.setTarifaSimulacao(tarifaSimulacao);
	        
	        JSONArray jsonArrayCanais = simulacaoObject.getJSONArray("Canais");
	        
	        ArrayList<CanalSimulacaoBean> canalSimulacao = new ArrayList<CanalSimulacaoBean>();
	        for (int i=0;i<jsonArrayCanais.size();i++) {
		          
	        	JSONObject canaisObject = JSONObject.fromObject( jsonArrayCanais.get(i).toString() ); 
	          
	         
	            CanalSimulacaoBean canalSimulacaoBean = new CanalSimulacaoBean();
	            canalSimulacaoBean.setCoCanal(Long.valueOf(String.valueOf(canaisObject.getInt("co_canal"))));
	            canalSimulacaoBean.setPrazoNeg(Long.valueOf(String.valueOf(canaisObject.getInt("prazo"))));

	            canalSimulacao.add(canalSimulacaoBean);
	            
	        }
	        simulacaoBean.setCanalSimulacao(canalSimulacao);
	        
	        ArrayList<CnpjBean> listaCNPJBean = new ArrayList<CnpjBean>();
		      
	        JSONArray jsonArrayCnpj = simulacaoObject.getJSONArray("Cnpjs");
	        
	        for (int i=0;i<jsonArrayCnpj.size();i++) {
		          
	        	JSONObject canaisObject = JSONObject.fromObject( jsonArrayCnpj.get(i).toString() ); 
	            
	            CnpjBean cnpjBean = new CnpjBean();
	            cnpjBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
	           
	            String cnpjStr =  String.valueOf(canaisObject.get("cnpj"));
		        cnpjBean.setCpfCnpj(Long.valueOf(cnpjStr));
		        cnpjBean.setIcPessoa("J");
		        listaCNPJBean.add(cnpjBean);	            
	        }
	        simulacaoBean.setListaCNPJ(listaCNPJBean);
	        
	        String transUser = "";
	        
	        transUser = "BGVF" + usuarioBean.getCodigoUsuario().toUpperCase();
	        
	        simulacaoBean.setNuSequencial(0L);
	       
	        handler.executeSimpleTransactionVoid(simulacaoBean, transUser);
	        
	        if (simulacaoBean.getListaCNPJ().size()>0){
	        	for (int i=0;i<simulacaoBean.getListaCNPJ().size();i++){ 
		        	CnpjBean cnpjBean = (CnpjBean) simulacaoBean.getListaCNPJ().get(i);
		        	cnpjBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
		        	transUser = "BGVG" + usuarioBean.getCodigoUsuario().toUpperCase();
		            handler.executeSimpleTransactionVoid(cnpjBean, transUser);
		        }
	        }else{
	        	 CnpjBean cnpjBean = new CnpjBean();
	        	 
			     cnpjBean.setCpfCnpj(Long.valueOf(cnpj));
			     cnpjBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
			     cnpjBean.setIcPessoa("J");
	        	 transUser = "BGVG" + usuarioBean.getCodigoUsuario().toUpperCase();
	             handler.executeSimpleTransactionVoid(cnpjBean, transUser);
	             
	        }
	        
	        
	        
	        for (int i=0;i<simulacaoBean.getTarifaSimulacao().size();i++){ 
				 TarifaSimulaBean tarifa = (TarifaSimulaBean) simulacaoBean.getTarifaSimulacao().get(i);
				 
				 TarifaSimulacaoEnvio tarifaEnvio = new TarifaSimulacaoEnvio();
				 
				 tarifaEnvio.setNuSimulacao(simulacaoBean.getNu_simulacao());
				 tarifaEnvio.setCoTarifa(Long.valueOf(tarifa.getCoTarifa()));
				 tarifaEnvio.setVrTarifa(tarifa.getVrTarifaFormatado());
				 tarifaEnvio.setPercTarifa(tarifa.getPercTarifaFormatado());
				 
				 transUser = "BGVH" + usuarioBean.getCodigoUsuario().toUpperCase();
			     handler.executeSimpleTransactionVoid(tarifaEnvio, transUser);
				
	        }
	        
	        for (int i=0;i<simulacaoBean.getCanalSimulacao().size();i++){ 
	        	 CanalSimulacaoBean canalBean = (CanalSimulacaoBean) simulacaoBean.getCanalSimulacao().get(i);
				 canalBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
				 transUser = "BGVI" + usuarioBean.getCodigoUsuario().toUpperCase();
			     handler.executeSimpleTransactionVoid(canalBean, transUser);
	        }
	        
	        
	        CnpjBean cnpjBean = new CnpjBean();
            cnpjBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
            
	        transUser = "BGVK" + usuarioBean.getCodigoUsuario().toUpperCase();
	        
	        BeanList listaCnpj = (BeanList) handler.executeSimpleTransactionQuery(cnpjBean, transUser);
	        
	        listaCNPJBean = convertDataStructure(listaCnpj.iterator());
	        
	       
	        simulacaoBean.setListaCNPJ(listaCNPJBean);
        	
        }else{
        		String descCriticas = "Não existe simulação ativa para o Beneficiário!";
        		request.setAttribute(ServicoEstrategia.DESC_CRITICAS, descCriticas);
        		return PAGE_SIMULAR_FILTRO;
        }
        
     String transUser = "";
        
        transUser = "BGVF" + usuarioBean.getCodigoUsuario().toUpperCase();
        
        simulacaoBean.setNuSequencial(0L);
       
        handler.executeSimpleTransactionVoid(simulacaoBean, transUser);
        
        for (int i=0;i<simulacaoBean.getListaCNPJ().size();i++){ 
        	CnpjBean cnpjBean = (CnpjBean) simulacaoBean.getListaCNPJ().get(i);
        	cnpjBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
        	transUser = "BGVG" + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(cnpjBean, transUser);
        }
        
        
        for (int i=0;i<simulacaoBean.getTarifaSimulacao().size();i++){ 
			 TarifaSimulaBean tarifa = (TarifaSimulaBean) simulacaoBean.getTarifaSimulacao().get(i);
			 
			 TarifaSimulacaoEnvio tarifaEnvio = new TarifaSimulacaoEnvio();
			 
			 tarifaEnvio.setNuSimulacao(simulacaoBean.getNu_simulacao());
			 tarifaEnvio.setCoTarifa(Long.valueOf(tarifa.getCoTarifa()));
			 tarifaEnvio.setVrTarifa(tarifa.getVrTarifaFormatado());
			 tarifaEnvio.setPercTarifa(tarifa.getPercTarifaFormatado());
			 
			 transUser = "BGVH" + usuarioBean.getCodigoUsuario().toUpperCase();
		     handler.executeSimpleTransactionVoid(tarifaEnvio, transUser);
			
        }
        
        for (int i=0;i<simulacaoBean.getCanalSimulacao().size();i++){ 
        	 CanalSimulacaoBean canalBean = (CanalSimulacaoBean) simulacaoBean.getCanalSimulacao().get(i);
			 canalBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
			 transUser = "BGVI" + usuarioBean.getCodigoUsuario().toUpperCase();
		     handler.executeSimpleTransactionVoid(canalBean, transUser);
        }
       
        simulacaoBean.setPasso("1");
        simulacaoBean.setNu_simulacao(simulacaoBean.getNu_simulacao());
        simulacaoBean.setCocli(0L);
        simulacaoBean.setIcPessoa("");
        simulacaoBean.setCnpjTela(0L);
        simulacaoBean.setCoCedente(0L);
        simulacaoBean.setPvVinc(0L);
        
        transUser = "BGVJ" + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList beanList = handler.executeSimpleTransactionQuery(simulacaoBean,     transUser);
        
        SimulacaoBean simulacaoRetSIGCBBean = (SimulacaoBean) beanList.get(0);
        
        simulacaoRetSIGCBBean.setCocli(cedenteCabecaBean.getCodigoClienteCOCLI());
        
        TarifaSimulaBean tarifaRetSIGCBGBean = new TarifaSimulaBean();
        
        tarifaRetSIGCBGBean.setNu_simulacao(simulacaoBean.getNu_simulacao());
        tarifaRetSIGCBGBean.setPasso("1");
        tarifaRetSIGCBGBean.setCocli(0L);
        tarifaRetSIGCBGBean.setIcPessoa("");
        tarifaRetSIGCBGBean.setCnpj(0L);
        tarifaRetSIGCBGBean.setCoCedente(0L);
        tarifaRetSIGCBGBean.setUnidadeAutorizador(0L);
  
        transUser = "BGVL" + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList listaServico = (BeanList) handler.executeSimpleTransactionQuery(tarifaRetSIGCBGBean, transUser);
        
        ArrayList listaServicoArray = convertDataStructure(listaServico.iterator());
        
        transUser = "BGVM" + usuarioBean.getCodigoUsuario().toUpperCase();
        
        CanalSimulacaoBean canalBean = new CanalSimulacaoBean();
        canalBean.setNuSimulacao(simulacaoBean.getNu_simulacao());
        canalBean.setPasso("1");
        canalBean.setCocli(0L);
        canalBean.setIcPessoa("");
        canalBean.setCnpj(0L);
        canalBean.setCoCedente(0L);
        canalBean.setUnidadeAutorizador(0L);
        
        BeanList listaFloat = (BeanList) handler.executeSimpleTransactionQuery(canalBean, transUser);
        
        ArrayList listaFloatArray = convertDataStructure(listaFloat.iterator());
         
        simulacaoBean.setTpAcao("");
        simulacaoRetSIGCBBean.setTpAcao("");
        simulacaoBean.setPasso("2");
        simulacaoRetSIGCBBean.setPasso("2");
        
        
        request.setAttribute("ListaServico",listaServicoArray);
        request.setAttribute("ListaFloat",listaFloatArray);
        request.setAttribute("SimulacaoBean",simulacaoBean);
        request.setAttribute("SimulacaoRetBean",simulacaoRetSIGCBBean);
        request.getSession().setAttribute("SimulacaoBean",simulacaoBean);
        request.getSession().setAttribute("SimulacaoRetBean",simulacaoRetSIGCBBean);
       
        request.setAttribute("ListaCNPJ", simulacaoBean.getListaCNPJ());
       
        
        return  PAGE_SIMULAR_DETALHE;
    }
    
    public String obterToken () throws IOException{
    	URL urlToken = new URL("http://api.sisng.caixa/token");
		HttpURLConnection connection = (HttpURLConnection) urlToken.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestMethod("POST");
			
		OutputStream outToken = connection.getOutputStream();
		outToken.write("grant_type=password&username=usrr_sigcb&password=sigcb".getBytes());
		
		outToken.flush();
		outToken.close();
       
        System.out.println("Return Server:"+connection.getResponseCode());
        BufferedReader brToken = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        String bearer = null;
        String outputToken;
        System.out.println("Output from Server .... \n");
        while ((outputToken = brToken.readLine()) != null) {
        	bearer = outputToken;
        }
        
		connection.disconnect();
		
		JSONObject readerToken = JSONObject.fromObject(bearer);

		String tokenStr = (String) readerToken.get("access_token");
		
		return tokenStr;
    }
    
    public String obterSimulacaoCNPJ(String tokenStr, String CNPJ, String user, String unidade) throws IOException{
    	
    	
    			URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorCNPJ/"+CNPJ+"?api-version=1.0&matricula="+user+"&cgc="+unidade);
    			//URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorCNPJ/9617942000198?api-version=1.0&matricula=p592428&cgc=5200");
    			//URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorNumero/2126387?api-version=1.0&matricula=c102103&cgc=5200");
    			
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	        conn.setRequestMethod("GET");
    	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8/json");
    	        conn.setRequestProperty("Authorization", "Bearer " + tokenStr);
    	        LogUtilSigcb.info("Acessando URL:" + "http://api.sisng.caixa/_apis/simulacaoPorCNPJ/"+CNPJ+"?api-version=1.0&matricula="+user+"&cgc="+unidade);
    	        if (conn.getResponseCode() != 200) {
    	             throw new RuntimeException("Não foi possível obter simulação, erro:" + conn.getResponseCode());
    	        }

    	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
    	        String JSONSimulacao = null;
    	        String output;
    	        System.out.println("Output from Server .... \n");
    	        while ((output = br.readLine()) != null) {
    	        	JSONSimulacao = output;
    	        }

    	        conn.disconnect();
    	        
    	        return JSONSimulacao;
    	        
    	        
    	
    }
    
    public String obterSimulacaoNuSimulacao(String tokenStr, String nuSimulacao, String user, String unidade) throws IOException{
    	
    	
		URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorNumero/"+nuSimulacao+"?api-version=1.0&matricula="+user+"&cgc="+unidade);
    	//URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorNumero/2126387?api-version=1.0&matricula=c102103&cgc=5200");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8/json");
        conn.setRequestProperty("Authorization", "Bearer " + tokenStr);
        LogUtilSigcb.debug("Acessando URL:"+ "http://api.sisng.caixa/_apis/simulacaoPorNumero/"+nuSimulacao+"?api-version=1.0&matricula="+user+"&cgc="+unidade);
        if (conn.getResponseCode() != 200) {
             throw new RuntimeException("Não foi possível obter simulação, erro:" + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String JSONSimulacao = null;
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
        	JSONSimulacao = output;
        }

        conn.disconnect();
        
        return JSONSimulacao;
    
}
    
    protected void configMsgSucessoErro(HttpServletRequest request) {
	    this.configMsgSucessoErro(request, "Apropriação efetuada com sucesso");
 }

 protected void configMsgSucessoErro(HttpServletRequest request,  String msgSucesso) {
    MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
    msgBean.setMsgError("");
    msgBean.setMsgSucess(msgSucesso);
    msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
    msgBean.setStrategySucessReturn(STRATEGY_MANTER_FILTRO);
    msgBean.setTitlePage("Serviço >> Simulador Negocial");
    request.getSession().setAttribute(MSG_BEAN, msgBean);
 }

public String getCustomizedHTMLMessagePageName() {
	return PAGE_ERRO_FILTRO;
}

}
