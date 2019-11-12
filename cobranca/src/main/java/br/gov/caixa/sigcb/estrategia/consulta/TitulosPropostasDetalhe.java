package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.bean.CedCentBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedentePECBean;
import br.gov.caixa.sigcb.bean.CedentePropostaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesSTRBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TitulosPropostaBean;
import br.gov.caixa.sigcb.bean.TitulosPropostaDetalheBean;
import br.gov.caixa.sigcb.bean.UnidadePVConteudoListaBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class TitulosPropostasDetalhe extends TitulosPropostasEstrategia {
	
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	String nextPage = "";
    	  // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        TitulosPropostaDetalheBean titulosPropostaDetalheBean = new TitulosPropostaDetalheBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	titulosPropostaDetalheBean = (TitulosPropostaDetalheBean) titulosPropostaDetalheBean.getRequestBean(request);
        } else {
        	titulosPropostaDetalheBean = (TitulosPropostaDetalheBean) titulosPropostaDetalheBean.getSessionBean(request, FILTRO_BEAN);
        }
      
        
        String situacao = (String) request.getParameter("situacao");
        
        String paginaDetalhe = (String) request.getParameter("pagDetalhe");
        
        //Chamada da BGMS
      
    	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
    	BeanList titBeanList = handler.executeSimpleTransactionQuery(titulosPropostaDetalheBean,   TRANSACAO_DETALHAR);
    	TitulosPropostaDetalheBean bean = (TitulosPropostaDetalheBean) titBeanList.get(0);
    	
    	request.getSession().setAttribute(DATA_BEAN, bean);


    	  // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
    	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
    	 
    	CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
    	
    	cedCabBean.setCodigoUsuario(Formatacao.formataNumerico(usuarioBean.getCodigoUsuario(),6));
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        cedCabBean.setCodigoCedente(titulosPropostaDetalheBean.getCodigoCedente());

        // Chamada ao Mainframe para cabecalho cedente
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean, TRANSACAO_CEDENTE_CABECALHO);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(titulosPropostaDetalheBean.getCodigoCedente());

        // Guarda informacoes de cabecalho
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        
        request.setAttribute("situacao", situacao);
        
        request.setAttribute("paginaDetalhe",  paginaDetalhe);
    
    	return PAGE_DETALHAR;
    	
    }

    
   
   

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTA);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
