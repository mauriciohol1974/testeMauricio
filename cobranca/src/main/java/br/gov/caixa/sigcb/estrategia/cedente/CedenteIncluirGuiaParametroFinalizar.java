package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
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
 * Tarifas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaParametroFinalizar extends CedenteIncluirEstrategia {

    private HistoricoGuia historicoGuiaParametro = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_PARAMETRO);

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        CedenteCabecaBean testeBean = (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        String autorizacao = request.getParameter("autorizacao");
        String tipoCalculo = request.getParameter("tipoCalculo");
        String cocli = request.getParameter("codigoClienteCOCLI");
        String codPVVinculado = request.getParameter("PVVinculado");
        String icgarantia = request.getParameter("icgarantia");
        String boleto = request.getParameter("icboleto");
        String valor = request.getParameter("icvalor");
        String creditoOnline = request.getParameter("creditoOnline");
        
        String clienteExterno = request.getParameter("clienteExterno");
        String icFinalizacao = request.getParameter("icFinalizacao");
        String codigoContabil = request.getParameter("cc");
        String codigoContabilDeb = request.getParameter("ccDeb");
        String unidadeCredito = request.getParameter("unidadeCredito");
        String icRateio = request.getParameter("icRateio");

        String icDebitoTarifa = request.getParameter("icDebitoTarifa");
        String icCEP = request.getParameter("icCEP");
        String icBeneficiario  = request.getParameter("icBeneficiario");
        String nuSITCS  = request.getParameter("nuSITCS");
        String autCCA  = request.getParameter("autCCA");
        String icIndiceEspecial = request.getParameter("icIndiceEspecial");
        String tpIndice = request.getParameter("tpIndice");
        String icAplIndiceEspecial = request.getParameter("icAplIndiceEspecial");
        String icCedenteGarantia = request.getParameter("icCedenteGarantia");
        String icProposta = request.getParameter("icProposta");
        
        if (icProposta==null){
        	icProposta="N";
        }
        
        if (icCedenteGarantia==null){
        	icCedenteGarantia="N";
        }
        
        if (nuSITCS==null){
        	nuSITCS="000000";
        }
        if (icBeneficiario==null){
        	icBeneficiario="00";
        }
       
        if (autCCA==null){
        	autCCA="N";
        }
        
        if (autCCA.trim().length()==0 ){
        	autCCA="N";
        }
        
        if (icIndiceEspecial==null){
        	icIndiceEspecial="N";
        }
        if (tpIndice==null){
        	tpIndice="";
        }
        if (icAplIndiceEspecial==null){
        	icAplIndiceEspecial="00";
        }
       
        CedenteParametrosBean parametroBean = (CedenteParametrosBean) (new CedenteParametrosBean()).getRequestBean(request);
        CedenteParametrosBean resposta = (CedenteParametrosBean) (new CedenteParametrosBean()).newBean();

        parametroBean.setTipoConsulta("I");
        parametroBean.setCodigoCedente(0l);
        parametroBean.setCodigoClienteCOCLI(Long.parseLong(cocli));
        parametroBean.setNsuTransacao("");
        parametroBean.setCodigoUnidadePVVinc(Long.parseLong(codPVVinculado));
        parametroBean.setAutorizacao(autorizacao);
        parametroBean.setTipoCalculo(tipoCalculo);
        parametroBean.setIcgarantia(icgarantia);
        parametroBean.setIcboleto(boleto);
        parametroBean.setIcvalor(valor);
        parametroBean.setCreditoOnline(creditoOnline);
        parametroBean.setClienteExterno(clienteExterno);
        parametroBean.setIcFinalizacao(icFinalizacao);
        parametroBean.setCodigoContabil(codigoContabil);
        parametroBean.setUnidadeCredito(unidadeCredito);
        parametroBean.setIcRateio(icRateio);
        parametroBean.setIcDebitoTarifa(icDebitoTarifa);
        parametroBean.setIcCEP(icCEP);
        parametroBean.setIcBeneficiario(icBeneficiario);
        parametroBean.setNuSITCS(Long.valueOf(nuSITCS));
        parametroBean.setCodigoContabilDeb(codigoContabilDeb);
        parametroBean.setAutCCA(autCCA);
        parametroBean.setIcIndiceEspecial(icIndiceEspecial);
        parametroBean.setTpIndice(tpIndice);
        parametroBean.setIcAplIndiceEspecial(icAplIndiceEspecial);
        parametroBean.setIcCedenteGarantia(icCedenteGarantia);
        parametroBean.setIcProposta(icProposta);
        
        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        
        request.setAttribute(CEDENTE_PARAMETROS_BEAN, parametroBean);
        
    	SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
		MontaTransacao isoMsg = new MontaTransacao();

		if (parametroBean.getCodigoContabil()==null){
			parametroBean.setCodigoContabil("0");
		}
		if (parametroBean.getCodigoContabil().equalsIgnoreCase("")){
			parametroBean.setCodigoContabil("0");
		}
		
		if (parametroBean.getCodigoContabilDeb()==null){
			parametroBean.setCodigoContabilDeb("0");
		}
		if (parametroBean.getCodigoContabilDeb().equalsIgnoreCase("")){
			parametroBean.setCodigoContabilDeb("0");
		}
		if (parametroBean.getIcAplIndiceEspecial().equalsIgnoreCase("")){
			parametroBean.setIcAplIndiceEspecial("0");
		}


		
		String valorLimite = request.getParameter("valorLimite");
		
		if (valorLimite==null){
			valorLimite="0";
		}
		
		if (valorLimite.equalsIgnoreCase("null")){
		valorLimite="0";
		}
		
		if (valorLimite.trim().length()==0){
			valorLimite="0";
		}
	        
        valorLimite = valorLimite.replace("R", "");
        valorLimite = valorLimite.replace("$", "");
        valorLimite = valorLimite.replace(" ", "");
        valorLimite = valorLimite.replace(",", "");
        valorLimite = valorLimite.replace(".", "");
	        
		String subida = "I" + Util.zerosEsquerda(parametroBean.getCodigoClienteCOCLI(),13)+ Util.completaEspacos(parametroBean.getNsuTransacao(),48) + Util.zerosEsquerda(parametroBean.getCodigoUnidadePVVinc(), 4)+
				parametroBean.getTipoCalculo() + parametroBean.getAutorizacao()+parametroBean.getIcgarantia()+parametroBean.getIcboleto()+parametroBean.getIcvalor() + parametroBean.getCreditoOnline()+
				parametroBean.getClienteExterno()+parametroBean.getIcFinalizacao()+Util.zerosEsquerda(Long.valueOf(parametroBean.getCodigoContabil()), 6)+parametroBean.getUnidadeCredito() + parametroBean.getIcRateio() +
				Util.completaEspacos(parametroBean.getIcCedenteGarantia(),1) +
				Util.zerosEsquerda(parametroBean.getNuOperacao(), 4) +	Util.completaEspacos(parametroBean.getNuContrato(), 40) +	Util.completaEspacos(parametroBean.getIcBaixa(), 1) +
				Util.completaEspacos("N", 1) +	Util.completaEspacos("N", 1) +	Util.completaEspacos(parametroBean.getIcContaGar(), 1) +
				Util.zerosEsquerda(parametroBean.getAgCta(), 4) + Util.zerosEsquerda(parametroBean.getOpeCta(), 4) + Util.zerosEsquerda(parametroBean.getNumCta(), 12) + Util.zerosEsquerda(parametroBean.getDigCta(), 1) +
				Util.completaEspacos(parametroBean.getIcLancamento(), 1) +	Util.zerosEsquerda(parametroBean.getNuEvento(), 6) + Util.completaEspacos(parametroBean.getIcProposta(), 1)+
				parametroBean.getIcDebitoTarifa() + parametroBean.getIcCEP() +  parametroBean.getIcBeneficiario() + Util.zerosEsquerda(parametroBean.getNuSITCS(), 6) + Util.zerosEsquerda(Long.valueOf(parametroBean.getCodigoContabilDeb()), 6) 
				+ parametroBean.getAutCCA() + parametroBean.getIcIndiceEspecial() + Util.completaEspacos(parametroBean.getTpIndice(),	15) +Util.zerosEsquerda(Long.valueOf(parametroBean.getIcAplIndiceEspecial()), 2) + Util.zerosEsquerda(Long.valueOf(valorLimite),19) ;

		InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
		ISOMsg mensagem = isoMsg.BGMK(subida, usuarioBean.getCodigoUsuario().toUpperCase());		
		ISOMsg[] retorno = acao.executaSirot(mensagem);
		
		boolean erroSirot = false;
		///Tratamento do retorno da mensagem ISO
		// Verifica se deu erro no RETORNO
		if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
			{
			erroSirot = true;
			String campo = ((String) retorno[1].getValue(120) );
			Exception exc = new Exception(campo);
			throw new MainframeException(exc);
			
		}
		
		//LogUtilSigcb.debug("Retorno:" + (String) retorno[1].getValue(62));
		
		
		CedenteParametrosBean retBean = this.desmontaBGMK((String)retorno[1].getValue(62));
        

        // Finaliza guia tarifas
      
        //BeanList blResposta = handler.executeSimpleTransactionQuery(parametroBean, TRANSACAO_ALTERAR_PARAMETROS);

        // Verifica criticas
       // if (retBean.getDescricaoCriticas().length() > 0) {
        //    resposta = retBean;
       // } else {
       // 	 CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
       // }
        
        
        // Verifica criticas
        if (retBean.getDescricaoCriticas().length() > 0) {
            
        	 resposta = retBean;
        	 request.setAttribute( "msgError", retBean.getDescricaoCriticas());
        	 
        	 return CedenteAlterarGuiaControle.proximaGuia(request,
                     resposta.getDescricaoCriticas(),
                     PAGE_INCLUIR_PARAMETRO,
                     PAGE_INCLUIR_PARAMETRO);
            
        } else {
        	
        	CedenteAlterarGuiaControle.avancaGuiaEmCadastramento(request);
        	 
        }

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_PARAMETRO,
                PAGE_INCLUIR_PRINCIPAL);

    }
    
    public CedenteParametrosBean desmontaBGMK(String retorno){
    	CedenteParametrosBean ret = new CedenteParametrosBean();
    	ret.setDescricaoCriticas(retorno);
    	return ret;
    	
    }
    
    

}
