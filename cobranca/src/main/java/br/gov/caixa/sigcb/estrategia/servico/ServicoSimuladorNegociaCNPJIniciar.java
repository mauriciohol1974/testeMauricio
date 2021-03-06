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

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class ServicoSimuladorNegociaCNPJIniciar extends ServicoEstrategia {

    public String processRequest(HttpServletRequest request,   HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        String fluxo = getFluxo(request);
         
       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        
    	CedenteCabecaBean cedenteCabecaBean = (request.getSession().getAttribute(ServicoEstrategia.CEDENTE_CABECA_BEAN)==null
                ? new CedenteCabecaBean()
                : (CedenteCabecaBean) request.getSession().getAttribute(ServicoEstrategia.CEDENTE_CABECA_BEAN));
      
        String tokenStr = this.obterToken();
        
        String cnpj =(String) request.getParameter("cnpj");
        String nuSimulacao = (String) request.getParameter("nu_simulacao");
        
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

		JsonReader readerToken = Json.createReader(new StringReader(bearer));
    
		JsonObject tokenObject = readerToken.readObject();
     
		readerToken.close();
		
		String tokenStr = tokenObject.getString("access_token");
		
		System.out.println("Token: " + tokenStr);
		
		return tokenStr;
    }
    
    public String obterSimulacaoCNPJ(String tokenStr, String CNPJ, String user, String unidade) throws IOException{
    	
    	
    			//URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorCNPJ/"+CNPJ+"?api-version=1.0&matricula="+user+"&cgc="+unidade);
    			URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorCNPJ/9617942000198?api-version=1.0&matricula=p592428&cgc=5200");
    			//URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorNumero/2126387?api-version=1.0&matricula=c102103&cgc=5200");
    			
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	        conn.setRequestMethod("GET");
    	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8/json");
    	        conn.setRequestProperty("Authorization", "Bearer " + tokenStr);
    	        
    	        if (conn.getResponseCode() != 200) {
    	             throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
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
    	
    	
		//URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorNumero/"+nuSimulacao+"?api-version=1.0&matricula="+user+"&cgc="+unidade);
    	URL url = new URL("http://api.sisng.caixa/_apis/simulacaoPorNumero/2126387?api-version=1.0&matricula=c102103&cgc=5200");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8/json");
        conn.setRequestProperty("Authorization", "Bearer " + tokenStr);
        
        if (conn.getResponseCode() != 200) {
             throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
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
    msgBean.setTitlePage("Simulador Negocial >> Filtro");
    request.getSession().setAttribute(MSG_BEAN, msgBean);
 }

@Override
public String getCustomizedHTMLMessagePageName() {
	// TODO Auto-generated method stub
	return null;
}

}
