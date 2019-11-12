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

public class CedentePropostasFiltro extends CedentePropostasEstrategia {
	
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	String nextPage = "";
    	  // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        CedentePropostaBean cedentePropostaBean = new CedentePropostaBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	cedentePropostaBean = (CedentePropostaBean) cedentePropostaBean.getRequestBean(request);
        } else {
        	cedentePropostaBean = (CedentePropostaBean) cedentePropostaBean.getSessionBean(request, FILTRO_BEAN);
        }
        
       
        
        String tipoConsulta = (String) request.getParameter("TipoConsulta");
        
        
        if (tipoConsulta.equalsIgnoreCase("1")) {
            nextPage = buscaPorUnidadeEN(cedentePropostaBean, request);
        } else {
            nextPage = buscaPorUnidadePV(cedentePropostaBean, request);
        	
        }
        
        return nextPage;
    	
    }

    
    private String buscaPorUnidadeEN(CedentePropostaBean filtroBean,
    	    HttpServletRequest request) throws Exception {
    	// bean utilizado na transacao listar pv
    	UnidadePVConteudoListaBean beanBuscaPorEN = (UnidadePVConteudoListaBean) (new UnidadePVConteudoListaBean()).newBean();
    	beanBuscaPorEN.setCodigoUnidadeEN(filtroBean.getUnidade());

    	// chamando transacao
    	
    	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_POR_EN + usuarioBean.getCodigoUsuario().toUpperCase();
    	List respostaList = handler.executeFixDataRecordsetTransaction(beanBuscaPorEN,  transUser);

    	// obtendo parte fixa e recordset da resposta
    	UnidadePVConteudoListaBean respostaBean = (UnidadePVConteudoListaBean) ((BeanList) respostaList.get(0)).get(0);
    	BeanList beanListaPVs = (BeanList) respostaList.get(1);

    	// setando o nome no bean que ja possui o codigo unidade
    	beanBuscaPorEN.setNomeUnidadeEN(respostaBean.getNomeUnidadeEN());

    	request.getSession().setAttribute(MANTER_FIXO_BEAN, beanBuscaPorEN);

    	// retendo a lista de resultados obtidos
    	ArrayList listaPVs = convertDataStructure(beanListaPVs.iterator());

    	request.getSession().setAttribute(PAGINACAO_LIST,
    		getPageHolder(listaPVs));
    	request.setAttribute(PAGINACAO_PAGE, "0");

    	return PAGE_MANTER_LISTAR_UNIDEN;
    	}
    
    
    private String buscaPorUnidadePV(CedentePropostaBean filtroBean,
    	    HttpServletRequest request) throws Exception {
    	// chamando transacao
    	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
    	Long codUnidade = filtroBean.getUnidade();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_POR_PV + usuarioBean.getCodigoUsuario().toUpperCase();
    	List respostaList = handler.executeFixDataRecordsetTransaction(filtroBean,  transUser);

    	// obtendo parte fixa e recordset da resposta
    	CedentePropostaBean respostaBean = (CedentePropostaBean) ((BeanList) respostaList.get(0)).get(0);
    	BeanList beanListaPVs = (BeanList) respostaList.get(1);

    	// setando o nome no bean que ja possui o codigo unidade
    	filtroBean.setNomeFantasia(respostaBean.getNomeFantasia());
    	filtroBean.setUnidade(codUnidade);
    	respostaBean.setUnidade(codUnidade);
    	request.getSession().setAttribute(MANTER_FIXO_BEAN, respostaBean);

    	// retendo a lista de resultados obtidos
    	ArrayList listaPVs = convertDataStructure(beanListaPVs.iterator());

    	request.getSession().setAttribute(PAGINACAO_LIST,	getPageHolder(listaPVs));
    	request.setAttribute(PAGINACAO_PAGE, "0");

    	return PAGE_JSP_CONSULTAR;
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
