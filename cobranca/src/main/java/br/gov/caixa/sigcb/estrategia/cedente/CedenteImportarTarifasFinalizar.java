package br.gov.caixa.sigcb.estrategia.cedente;

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

import net.sf.json.JSONObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CanalSimulacaoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.CnpjBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
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
public class CedenteImportarTarifasFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,   HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        SimulacaoBean simulacaoBean = (SimulacaoBean) request.getSession().getAttribute("SimulacaoBean");
        
        SimulacaoBean simulacaoRetBean = (SimulacaoBean) request.getSession().getAttribute("SimulacaoRetBean");
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
         
    	CedenteCabecaBean cedenteCabecaBean = (request.getSession().getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
                ? new CedenteCabecaBean()
                : (CedenteCabecaBean) request.getSession().getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
    	
        String ip = request.getRemoteAddr();
        
        
    	//Chamar Transação do SIGCB de Apropriação
    	String transUser = "BGVP" + usuarioBean.getCodigoUsuario().toUpperCase();
    	simulacaoBean.setPasso("1");
    	simulacaoBean.setCoCedente(0L);
    	simulacaoBean.setIcPessoa(cedenteCabecaBean.getTipoPessoa().equals(2L)? "J":"F");
    	simulacaoBean.setCnpjTela(cedenteCabecaBean.getCpfCnpj());
    	simulacaoBean.setUnidadeAutorizador(simulacaoRetBean.getUnidadeAutorizador());
    	simulacaoBean.setCocli(simulacaoRetBean.getCocli());
    	simulacaoBean.setCodUsuario("");
    	simulacaoBean.setIp(ip);
    	BeanList beanList = handler.executeSimpleTransactionQuery(simulacaoBean,     transUser);
        
        SimulacaoBean simulacaoRetSIGCBBean = (SimulacaoBean) beanList.get(0);
        
        simulacaoBean.setNuPendencia(simulacaoRetSIGCBBean.getNuPendencia());
        simulacaoBean.setCoCedente(cedenteCabecaBean.getCodigoCedente());
        
        String tokenStr = this.obterToken();
        int codRetorno = this.apropriarSimulacao(tokenStr, simulacaoBean, usuarioBean.getCodigoUsuario());
        if (codRetorno!=204){
        	throw new Exception("Não foi possivel apropriar simulação. Erro:" + codRetorno);
        }
        request.setAttribute("SimulacaoBean",simulacaoBean);
        
        return  PAGE_SIMULAR_TARIFAS_SUCESSO;
    }
    
    public String obterToken () throws IOException{
    	URL urlToken = new URL("http://10.116.82.228:8089/token");
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
    
    public int apropriarSimulacao(String tokenStr, SimulacaoBean simulacaoBean, String user) throws IOException{
    	
    	JSONObject jsonPOST = new JSONObject();
    	
    	int nuSimulacao = Integer.parseInt(simulacaoBean.getNu_simulacao().toString());
        int cgc = Integer.parseInt(simulacaoBean.getUnidadeAutorizador().toString());
        jsonPOST.put("nu_simulacao", nuSimulacao);
        jsonPOST.put("situacao", simulacaoBean.getSituacao());
        jsonPOST.put("cliente", simulacaoBean.getCnpj());
        jsonPOST.put("numeroPendencia", "0000");
        jsonPOST.put("codigoCedente", simulacaoBean.getCoCedente().toString());
        jsonPOST.put("matricula", user);
        jsonPOST.put("cgc", cgc);
        jsonPOST.put("dataSolicitacao", simulacaoBean.getDataSolicitacaoInteira());
        
		//CONFIRMACAO DE APROPRIACAO
        LogUtilSigcb.debug("CONFIRMAR APROPRIACAO NO SISNG" + jsonPOST.toString());
        URL urlPOST = new URL("http://10.116.82.228:8089/_apis/confirmarApropriacao?api-version=1.0");
        HttpURLConnection connPOST = (HttpURLConnection) urlPOST.openConnection();
        connPOST.setRequestMethod("POST");
        connPOST.setRequestProperty("Content-Type","application/json"); 
        connPOST.setRequestProperty("Authorization", "Bearer " + tokenStr);
        connPOST.setDoOutput(true);
        
      
        OutputStream out = connPOST.getOutputStream();
        out.write(jsonPOST.toString().getBytes("UTF-8"));
        out.flush();
        out.close();
       
        int codRet = connPOST.getResponseCode();
        
        connPOST.disconnect();
    	        
    	return  codRet;
    	
    }
    
	public String getCustomizedHTMLMessagePageName() {
		return PAGE_ERRO_TARIFA;
	}

}
