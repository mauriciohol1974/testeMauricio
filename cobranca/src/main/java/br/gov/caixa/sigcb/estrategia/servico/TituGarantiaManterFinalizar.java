package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.ClienteSINCEBean;
import br.gov.caixa.sigcb.bean.ContaCreditoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.bean.TituloListarBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class TituGarantiaManterFinalizar extends TituGarantiaEstrategia {

    public String processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

               // Define informacoes de acesso a proxima pagina.
    	
    	configMsgSucessoErro(request);
    	
        String pagina = PAGE_ERRO;
        
        String[] ident = new String[20];
        String[] identValue = new String[20];
        String codUsuario = (String) request.getParameter("codUsuario");
        String codigoCedente = (String) request.getParameter("codigoCedente");
        String nossoNumero = (String) request.getParameter("nossoNumero");
        String nossoNumeroFim = (String) request.getParameter("nossoNumeroFim");
        
        for (int i=0;i<20;i++){
            ident[i] = (String) request.getParameter("identNN"+i);
            identValue[i] = (String) request.getParameter("id"+i);
        }
    
        String subida = Util.zerosEsquerda(Long.parseLong(codigoCedente), 7) + Util.completaEspacos(codUsuario, 8);
        
        for (int z=0;z<20;z++){
        	if (identValue[z].length()>0){
        		subida = subida + ident[z] + Util.zerosEsquerda(Long.parseLong(identValue[z]),18); 
        	}else{
        		subida = subida + " " + "00000000000000000";
        	}
        }
		
        
    	SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
		MontaTransacao isoMsg = new MontaTransacao();
		InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
		ISOMsg mensagem = isoMsg.BGNO(subida,usuarioBean.getCodigoUsuario().toUpperCase());		
		ISOMsg[] retorno = acao.executaSirot(mensagem);
		
		boolean erroSirot = false;
		///Tratamento do retorno da mensagem ISO
		// Verifica se deu erro no RETORNO
		if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
			{
			erroSirot = true;
			String campo = ((String) retorno[1].getValue(120));
			Exception exc = new Exception(campo);
			throw new MainframeException(exc);
			
		}
        
		String classificacao = request.getParameter("classificacao");
		//Efetuar consulta do Filtro
		//MainFrameTransactionsSigcb handler = TituGarantiaEstrategia.lookUpMFHandler();
		 MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Prepara o bean para subida de informacao ao mainframe
        TituloListarBean tituloFixoBean = new TituloListarBean();
        tituloFixoBean = (TituloListarBean) tituloFixoBean.newBean();
        tituloFixoBean.setCodigoCedente(Long.parseLong(codigoCedente));
        tituloFixoBean.setClassificacao(Long.parseLong(classificacao));
        tituloFixoBean.setNossoNumero(Long.parseLong(nossoNumero));
        tituloFixoBean.setNossoNumeroFim(Long.parseLong(nossoNumeroFim));
        
        
        TituloListarBean tituloFixoBeanRetido = new TituloListarBean();
        tituloFixoBeanRetido = (TituloListarBean) tituloFixoBean.newBean();
        tituloFixoBeanRetido.setCodigoCedente(Long.parseLong(codigoCedente));
        tituloFixoBeanRetido.setClassificacao(Long.parseLong(classificacao));
        tituloFixoBeanRetido.setNossoNumero(Long.parseLong(nossoNumero));
        tituloFixoBeanRetido.setNossoNumeroFim(Long.parseLong(nossoNumeroFim));
        //tituloFixoBeanRetido.setValorTotal();
        //tituloFixoBeanRetido.setQuantidadeTotal();
        
        
        // página que será mostrada, começa com 1
        int paginaAtual;
        try {
        	// ou se já tiver selecionado na tela pega a página do request
            paginaAtual = Integer.parseInt(request.getParameter("pagina"));
        } catch (Exception e) {
        	paginaAtual = 1;
        }
        // coloca no bean passado como argumento também
        
        
        tituloFixoBean.setPagina(Long.valueOf(paginaAtual));
        tituloFixoBean.setPagina(Long.valueOf(paginaAtual));

            // Chama o Mainframe
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_TITULO + usuarioBean.getCodigoUsuario().toUpperCase();
            List tituloList = (List) handler.executeFixDataRecordsetTransaction(tituloFixoBean,transUser);

            // Obtem Parte Fixa
            tituloFixoBean = (TituloListarBean) ((BeanList) tituloList.get(0)).get(0);
            tituloFixoBean.setCodigoCedente(tituloFixoBean.getCodigoCedente());
            tituloFixoBean.setSituacao(tituloFixoBean.getSituacao());
            tituloFixoBean.setClassificacao(tituloFixoBean.getClassificacao());
            tituloFixoBean.setPagina(tituloFixoBean.getPagina());
            tituloFixoBeanRetido.setValorTotal(tituloFixoBean.getValorTotal());
            tituloFixoBeanRetido.setQuantidadeTotal(tituloFixoBean.getQuantidadeTotal());
            
            // Obtem Parte Variavel (recordset)
            ArrayList tituloArrayList = convertDataStructure(((BeanList) tituloList.get(1)).iterator());

            List tituloRetornoList = new ArrayList();
            tituloRetornoList.add(tituloFixoBeanRetido);
            tituloRetornoList.add(tituloArrayList);

            // for(int i = 0 ; i < tituloArrayList.size() ; i++){
            // LogUtilSigcb.debug("==== Titulo " + i + " : Classe -> " +
            // tituloArrayList.get(i).getClass() + " " +
            // tituloArrayList.get(i));
            // }
           
            //request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(tituloList));
            request.setAttribute(PAGINACAO_PAGE, paginaAtual);

            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(tituloFixoBean.getTotalRegistro() / 20.0));
            
            request.getSession().setAttribute(DATA_FIXO_LIST, tituloRetornoList.get(0));
            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder((List) tituloRetornoList.get(1)));
            request.setAttribute(PAGINACAO_PAGE, "0");

            return PAGE_FILTRO_LISTAR_TITULO;
        
      

      
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

   

    private String paginaPorSituacao(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {
        // Obtem bean com informacoes para lista consolidada.
        ArrayList tituloList = (ArrayList) getTituloListarTitulo(request, response, tituloBean);

        // Retem informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_FIXO_LIST, tituloList.get(0));
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder((List) tituloList.get(1)));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_FILTRO_LISTAR_TITULO;
    }

   

    // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
    private void setDadosPvVinculacao(HttpServletRequest request,
            TituloBean tituloBean) throws Exception {
        CedenteGeralBean cedGeralBean = new CedenteGeralBean();
        cedGeralBean = (CedenteGeralBean) cedGeralBean.newBean();
        // Definindo atributos para executar a transação BG03 para obter
        // informações do cedente para setar campos
        cedGeralBean.setTipoConsulta("C");
        cedGeralBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Chama aS Transacões
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedGeralBeanList = handler.executeSimpleTransactionQuery(cedGeralBean, transUser);
        CedenteGeralBean ceGeralBean = (CedenteGeralBean) cedGeralBeanList.get(0);
        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, ceGeralBean);
    }

}