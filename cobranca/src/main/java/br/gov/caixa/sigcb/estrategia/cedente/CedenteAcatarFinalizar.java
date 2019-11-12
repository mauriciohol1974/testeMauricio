package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Geral
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAcatarFinalizar extends CedenteAlterarEstrategia {

    
	private HistoricoGuia historicoGuiaPermissao = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_PERMISSAO);
	
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
    			
        
        this.configMsgSucessoErro(request);
        InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);


        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        
        
        
        HttpSession session = request.getSession(false);
		CedenteCabecaBean cedenteCabecalhoBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
		          ? new CedenteCabecaBean()
		          : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
		
		  CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean) (new CedenteGeralBean()).getSessionBean(request, CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS);

		  
			SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
			MontaTransacao isoMsg = new MontaTransacao();
			
			String subida = "A"+ 
					Util.zerosEsquerda(cedenteCabecalhoBean.getCodigoCedente(),7) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCodigoClienteCOCLI(), 13) +
					Util.completaEspacos(geralBeanTransacoesGuias.getNsuTransacao().toUpperCase(), 48) +
					Util.zerosEsquerda(geralBeanTransacoesGuias.getCodigoUnidadePVVinc(), 4) +
					Util.completaEspacos(cedenteCabecalhoBean.getTipoPessoaTexto().toUpperCase(), 1) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCpfCnpj(), 14) + 
					Util.completaEspacos(usuarioLDAP.getCodigoUsuario(), 8);
		
			InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
			ISOMsg mensagem = isoMsg.BGMT(subida, usuarioBean.getCodigoUsuario().toUpperCase());		
			ISOMsg[] retorno = acao.executaSirot(mensagem);
			
			boolean erroSirot = false;
			///Tratamento do retorno da mensagem ISO
			// Verifica se deu erro no RETORNO
			if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
				{
				erroSirot = true;
				Exception campo = new Exception((String) retorno[1].getValue(120));
				throw new MainframeException(campo);
				
			}
			
			
			CedConsultaPermissaoBean beanReter = this.desmontaBGMT((String)retorno[1].getValue(62), (String)retorno[2].getValue(62));
			
			String acatarInterna = request.getParameter("acatarInterna");
			String situacaoINT= (String) request.getParameter("situacaoINT");
			String descr1Int= (String) request.getParameter("descr1Int");
			String descr2Int= (String) request.getParameter("descr2Int");
			String situacaoAcatar= (String) request.getParameter("situacaoAcatar");
			String descricao = Util.completaEspacos(descr1Int,100) + Util.completaEspacos(descr2Int,100);
			
			if (situacaoINT.equalsIgnoreCase("I")){
				beanReter.setDE_STCO_INTERNA("INAPTO");	
			}else if (situacaoINT.equalsIgnoreCase("A")){
				beanReter.setDE_STCO_INTERNA("APTO");
			}else if (situacaoINT.equalsIgnoreCase("E")){
				beanReter.setDE_STCO_INTERNA("EM ANALISE");
			}
			
			if (situacaoAcatar.equalsIgnoreCase("S")){
				beanReter.setDE_ACAT_CIP("SIM");
			}else{
				beanReter.setDE_ACAT_CIP("NAO");
			}
			beanReter.setDE_HIST_INTERNA(descricao);
			
			
			
			request.setAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN,beanReter);			
	        
			
			String subidaAcatar = "A"+ 
				Util.completaEspacos(geralBeanTransacoesGuias.getNsuTransacao().toUpperCase(), 48) +
				Util.completaEspacos(usuarioLDAP.getCodigoUsuario().toUpperCase(), 8) +
				situacaoINT +
				Util.completaEspacos(descricao.toUpperCase(),200) +
				acatarInterna +
				situacaoAcatar;
		 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
		 mensagem = isoMsg.BGMU(subidaAcatar, usuarioBean.getCodigoUsuario().toUpperCase());		
		 retorno = acao.executaSirot(mensagem);
		 CedenteParametrosBean resposta = (CedenteParametrosBean) (new CedenteParametrosBean()).newBean();
		
		String msg="";
	
		
		erroSirot = false;
		if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
			 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
			 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
				{
				erroSirot = true;
				msg = ((String) retorno[1].getValue(120) );
				Exception e = new Exception(msg);
				throw new MainframeException(e);
		}
		
		LogUtilSigcb.debug("Retorno:" + (String) retorno[1].getValue(62));
		
		String erro = (String) retorno[1].getValue(62);
		
		CedenteParametrosBean retBean = this.desmontaBGMU((String)retorno[1].getValue(62));
    
        // Verifica criticas
        if (retBean.getDescricaoCriticas().length() > 0) {

         request.setAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN, beanReter);		
        	
	 	 return CedenteAlterarGuiaControle.proximaGuia(request,
	 			retBean.getDescricaoCriticas(),
                 PAGE_ALTERAR_PERMISSAO,
                 PAGE_ALTERAR_PERMISSAO);
        	
        } 
        
        LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession().getAttribute(LISTA_GUIAS_ALTERADAS);
        listaGuiasAlteradas.add(this.historicoGuiaPermissao);

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_PERMISSAO,
                PAGE_ALTERAR_PRINCIPAL);

		
		
		/*
		 *
        LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession().getAttribute(LISTA_GUIAS_ALTERADAS);
        listaGuiasAlteradas.add(this.historicoGuiaPermissao);

        return CedenteAlterarGuiaControle.proximaGuia(request,
                msg,
                PAGE_ALTERAR_PERMISSAO,
                PAGE_ALTERAR_PRINCIPAL);
                
                
                */
    }
    
    public CedenteParametrosBean desmontaBGMU(String retorno){
    	CedenteParametrosBean ret = new CedenteParametrosBean();
    	ret.setDescricaoCriticas(retorno);
    	return ret;
    	
    }
    
 public CedConsultaPermissaoBean desmontaBGMT(String rajada, String historico){
    	
    	CedConsultaPermissaoBean retorno = new CedConsultaPermissaoBean();
    	
    	retorno.setDE_STCO_INTERNA(rajada.substring(0, 10));
    	retorno.setDT_STCO_INTERNA(rajada.substring(10, 20));
    	retorno.setHH_STCO_INTERNA(rajada.substring(20, 28));
    	retorno.setCO_USRO_INTERNA(rajada.substring(28, 36));
    	retorno.setDE_HIST_INTERNA(rajada.substring(36, 256));
    	retorno.setDE_STCO_CIP(rajada.substring(256, 266));
    	retorno.setDT_STCO_CIP(rajada.substring(266, 276));
    	retorno.setHH_STCO_CIP(rajada.substring(276, 284));
    	retorno.setDE_STCO_FINAL(rajada.substring(284, 294));
    	retorno.setDT_STCO_FINAL(rajada.substring(294, 304));
    	retorno.setHH_STCO_FINAL(rajada.substring(304, 312));
    	retorno.setCO_USRO_FINAL(rajada.substring(312,320));
    	retorno.setDE_HIST_FINAL(rajada.substring(320, 370));
    	retorno.setDE_ACAT_CIP(rajada.substring(370, 373));
    	retorno.setDT_ACAT_CIP(rajada.substring(373, 383));
    	retorno.setHH_ACAT_CIP(rajada.substring(383, 391));
    	retorno.setCO_USRO_CIP(rajada.substring(391, 399));
    	retorno.setDE_HIST_CIP(historico);
    	
    	return retorno;
    	
    }

}
