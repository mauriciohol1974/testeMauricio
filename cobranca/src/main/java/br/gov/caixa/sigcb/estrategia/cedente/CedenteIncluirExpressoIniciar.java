package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
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
public class CedenteIncluirExpressoIniciar extends CedenteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Se fluxo normal chama transacoes
        // senao nao faz nada, os beans ja devem existir no ambiente
        CedenteGeralBean beanFiltro = new CedenteGeralBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	
        	beanFiltro = (CedenteGeralBean) request.getSession().getAttribute(INCLUIR_FILTRO_BEAN);
        	
        	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        	
        	beanFiltro.setTipoConsulta("F");
        	
        	CedenteGeralBean cedBean = new CedenteGeralBean();
        	 
        	BeanList blExpresso = handler.executeSimpleTransactionQuery(beanFiltro,  TRANSACAO_EXPRESSO);
            cedBean = (CedenteGeralBean) blExpresso.get(0);
             
            beanFiltro.setCodigoClienteCOCLI(cedBean.getCodigoClienteCOCLI());
            // seta o bean do filtro no ambiente
            request.getSession().setAttribute(INCLUIR_FILTRO_BEAN, beanFiltro);
            
            
            
        }
        

        return PAGE_INCLUIR_EXPRESSO;
    }

  

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_INCLUIR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
