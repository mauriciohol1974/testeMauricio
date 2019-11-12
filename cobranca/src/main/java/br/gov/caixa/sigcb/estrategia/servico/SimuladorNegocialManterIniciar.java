package br.gov.caixa.sigcb.estrategia.servico;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
public class SimuladorNegocialManterIniciar extends ServicoEstrategia {

    public String processRequest(HttpServletRequest request,   HttpServletResponse response) throws Exception {
    	 // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        return  PAGE_SIMULAR_FILTRO;
    }
    
   

	@Override
	protected void configMsgSucessoErro(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}


	public String getCustomizedHTMLMessagePageName() {
		return PAGE_ERRO;
	}
    
    

}
