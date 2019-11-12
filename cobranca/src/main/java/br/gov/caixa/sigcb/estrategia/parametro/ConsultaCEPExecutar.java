package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.CepBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ConsultaCEPExecutar extends ConsultaCEPEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Se fluxo normal chama transacoes
        // senao nao faz nada, os beans ja devem existir no ambiente
        CepBean cepBean = new CepBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	
        	cepBean = (CepBean) request.getSession().getAttribute(FILTRO_BEAN);
        	
        	cepBean = (CepBean) cepBean.getSessionBean(request, FILTRO_BEAN);

        	String cep = (String) request.getParameter("cep");
        	
        	if (cep.trim().length()==0){
        		cep = "00000000";
        	}
        	
        	cepBean.setCep(Long.parseLong(cep));
        	
        	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        	MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        	
        	BeanList cepEnvio = handler.executeSimpleTransactionQuery(cepBean,  transUser);
            cepBean = (CepBean) cepEnvio.get(0);
            cepBean.setCep(Long.parseLong(cep));
            
            request.getSession().setAttribute(DATA_BEAN, cepBean);
            
        }
        

        return PAGE_EXIBECEP;
    }

  

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("Consulta CEP");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
