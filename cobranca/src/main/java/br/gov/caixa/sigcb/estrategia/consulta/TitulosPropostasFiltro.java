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

public class TitulosPropostasFiltro extends TitulosPropostasEstrategia {
	
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	String nextPage = "";
    	  // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        TitulosPropostaBean titulosPropostaBean = new TitulosPropostaBean();
        titulosPropostaBean = (TitulosPropostaBean) titulosPropostaBean.getRequestBean(request);
        /*if (fluxo.equals(FLUXO_NORMAL)) {
        	titulosPropostaBean = (TitulosPropostaBean) titulosPropostaBean.getRequestBean(request);
        } else {
        	titulosPropostaBean = (TitulosPropostaBean) titulosPropostaBean.getSessionBean(request, FILTRO_BEAN);
        }
        */
      
        int pagDetalhe = 0;
        try {
        	pagDetalhe = Integer.parseInt(  (String) request.getParameter("paginaDetalhe"));
        } catch (Exception e) {
        }
        
        int paginaAtual = 0;
        try {
	        paginaAtual = Integer.parseInt(request.getParameter("pagina"));
        } catch (Exception e) {
        	paginaAtual = 1;
        }
        
        if (pagDetalhe > 0){
        	paginaAtual = pagDetalhe;
        }
        
        String situacao = titulosPropostaBean.getSituacao();
        
        titulosPropostaBean.setPagina((long) paginaAtual);
    	// chamando transacao
    	
    	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        List respostaList = handler.executeFixDataRecordsetTransaction(titulosPropostaBean,  TRANSACAO_LISTAR);

    	// obtendo parte fixa e recordset da resposta
    	TitulosPropostaBean respostaBean = (TitulosPropostaBean) ((BeanList) respostaList.get(0)).get(0);
    	BeanList beanListaTitulos = (BeanList) respostaList.get(1);

    	  // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
    	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
    	 
    	CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
    	
    	cedCabBean.setCodigoUsuario(Formatacao.formataNumerico(usuarioBean.getCodigoUsuario(),6));
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        cedCabBean.setCodigoCedente(titulosPropostaBean.getCodigoCedente());

        // Chamada ao Mainframe para cabecalho cedente
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean, TRANSACAO_CEDENTE_CABECALHO);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(titulosPropostaBean.getCodigoCedente());

        // Guarda informacoes de cabecalho
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        respostaBean.setSituacao(situacao);
    	request.getSession().setAttribute(MANTER_FIXO_BEAN, respostaBean);

    	// retendo a lista de resultados obtidos
    	ArrayList listaTitulos = convertDataStructure(beanListaTitulos.iterator());

    	request.getSession().setAttribute(PAGINACAO_LIST,	getPageHolder(listaTitulos));
    	request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(respostaBean.getTotalRegistros() / 20.0));
    	request.setAttribute(PAGINACAO_PAGE,  "0");
    	
    	request.setAttribute("pagDetalhe",  String.valueOf(paginaAtual));
    	request.setAttribute("situacao", situacao);
    	
    	return PAGE_LISTAR;
    	
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
