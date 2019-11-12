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
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
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
public class SimuladorNegocialApropriarFinalizar extends ServicoEstrategia {

    public String processRequest(HttpServletRequest request,   HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        SimulacaoBean simulacaoBean = (SimulacaoBean) request.getSession().getAttribute("SimulacaoBean");
        
        SimulacaoBean simulacaoRetBean = (SimulacaoBean) request.getSession().getAttribute("SimulacaoRetBean");
       
        
        String fluxo = getFluxo(request);
        
        String cpfCnpj = (String) request.getParameter("cpfCnpj");
        
        String icPessoa = (String) request.getParameter("icPessoa");
        
        String nuSimulacao = (String) request.getParameter("nuSimulacao");
        
        String codCedente = (String) request.getParameter("codCedente");
        
      //  MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
       InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
         
       String ip = request.getRemoteAddr();
        
    	//Chamar Transação do SIGCB de Apropriação
    	String transUser = "BGVP" + usuarioBean.getCodigoUsuario().toUpperCase();
    	simulacaoBean.setPasso("2");
    	simulacaoBean.setNsuCedente("");
    	simulacaoBean.setCoCedente(Long.valueOf(codCedente));
    	simulacaoBean.setIcPessoa(icPessoa);
    	simulacaoBean.setCnpjTela(Long.valueOf(cpfCnpj));
    	//simulacaoBean.setUnidadeAutorizador(0L);
    	simulacaoBean.setCocli(0L);
    	simulacaoBean.setCodUsuario(usuarioBean.getCodigoUsuario());
    	simulacaoBean.setIp(ip);
    	    	
    	BeanList beanList = handler.executeSimpleTransactionQuery(simulacaoBean,     transUser);
         
        SimulacaoBean simulacaoRetSIGCBBean = (SimulacaoBean) beanList.get(0);
        
        simulacaoBean.setNuPendencia(simulacaoRetSIGCBBean.getNuPendencia());
      
        String tokenStr = this.obterToken();
        int codRetorno = this.apropriarSimulacao(tokenStr, simulacaoBean, usuarioBean.getCodigoUsuario());
        if (codRetorno!=204){
        	throw new Exception("Não foi possivel apropriar simulação. Erro:" + codRetorno);
        }
        request.setAttribute("SimulacaoBean",simulacaoBean);
        
        return  PAGE_SUCESSO;
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
    
    public int apropriarSimulacao(String tokenStr, SimulacaoBean simulacaoBean, String user) throws IOException{
    	
    	JSONObject jsonPOST = new JSONObject();
    	
    	int nuSimulacao = Integer.parseInt(simulacaoBean.getNu_simulacao().toString());
        int cgc = Integer.parseInt(simulacaoBean.getUnidadeAutorizador().toString());
        jsonPOST.put("nu_simulacao", nuSimulacao);
        jsonPOST.put("situacao", simulacaoBean.getSituacao());
        jsonPOST.put("cliente", simulacaoBean.getCnpjTela().toString());
        jsonPOST.put("numeroPendencia", simulacaoBean.getNuPendencia());
        jsonPOST.put("codigoCedente", simulacaoBean.getCoCedente());
        jsonPOST.put("matricula", user);
        jsonPOST.put("cgc", cgc);
        jsonPOST.put("dataSolicitacao", simulacaoBean.getDataSolicitacaoInteira());
        
		//CONFIRMACAO DE APROPRIACAO
        LogUtilSigcb.debug("CONFIRMAR APROPRIACAO NO SISNG" + jsonPOST.toString());
        URL urlPOST = new URL("http://api.sisng.caixa/_apis/confirmarApropriacao?api-version=1.0");
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

	@Override
	protected void configMsgSucessoErro(HttpServletRequest request) {
		 	MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
	        msgBean.setMsgError("");
	        msgBean.setMsgSucess("APROPRIACAO EFETUADA COM SUCESSO");
	        msgBean.setStrategyErrorReturn("SimuladorNegocialManterIniciar");
	        msgBean.setStrategySucessReturn("SimuladorNegocialManterIniciar");
	        msgBean.setTitlePage("SERVIÇO >> SIMULAR TARIFA");
	        request.getSession().setAttribute(MSG_BEAN, msgBean);
		
	}

	@Override
	public String getCustomizedHTMLMessagePageName() {
		return PAGE_ERRO;
	}
    
    

}
