package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.sirot.*;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteContasBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteFloatBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteMensagensBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedentePermissaoBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente -
 * Controle de Guias
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaControle extends CedenteGuiaControle {

    /**
     * Quando uma inclusao de guia eh completada com sucesso, eh chamada esse
     * metodo para avanco da guia em cadastramento
     */
    public static void avancaGuiaEmCadastramento(HttpServletRequest request)
            throws Exception {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN);
        CedenteGeralBean beanFiltro = (CedenteGeralBean) request.getSession()
                .getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN);

        if (principalBean != null) {
            if (principalBean.getGuiaEmCadastramento() == principalBean.getUltimaGuiaCadastrada()
                    .intValue() + 1) {
                principalBean.setUltimaGuiaCadastrada(new Integer(principalBean.getUltimaGuiaCadastrada()
                        .intValue() + 1));
            }
        } else {
            principalBean = new CedentePrincipalBean();

            // verificando guia em cadastramento pela transacao
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_SITUACAO_CADASTRO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList respostaList = handler.executeSimpleTransactionQuery(beanFiltro, transUser);
            CedenteGeralBean respostaBean = (CedenteGeralBean) respostaList.get(0);

            // criando bean de controle de guias
            principalBean.setUltimaGuiaCadastrada(respostaBean.getUltimaGuiaCadastrada());
        }

        // Verifica se pode cadastrar Cedente Eletronico
        // se nao puder, avanca a guia mais uma vez
        int guiaEmCadastramento = principalBean.getUltimaGuiaCadastrada().intValue() + 1;

        // LogUtilSigcb.debug("#$% guiaEmCadastramento ==
        // CedenteEstrategia.GUIA_CEDENTE_ELETRONICO :::: " +
        // (guiaEmCadastramento == CedenteEstrategia.GUIA_CEDENTE_ELETRONICO));
        // LogUtilSigcb.debug("#$%
        // CedenteEstrategia.COBRANCA_CONVENCIONAL.equals(principalBean.getTipoCobranca()
        // ::: " +
        // CedenteEstrategia.COBRANCA_CONVENCIONAL.equals(principalBean.getTipoCobranca()));
        // LogUtilSigcb.debug("#$% tipoCobranca ::::::::: " +
        // principalBean.getTipoCobranca());

        if (guiaEmCadastramento == CedenteEstrategia.GUIA_CEDENTE_ELETRONICO
            && CedenteEstrategia.COBRANCA_CONVENCIONAL.equals(principalBean.getTipoCobranca())) {
            principalBean.setUltimaGuiaCadastrada(new Integer(principalBean.getUltimaGuiaCadastrada()
                    .intValue() + 1));
        }
       

        // LogUtilSigcb.debug("#$% principalBean.getUltimaGuiaCadastrada :::: "
        // + principalBean.getUltimaGuiaCadastrada());

        request.getSession()
                .setAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN, beanFiltro);
        request.getSession()
                .setAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN,
                        principalBean);

        // limpa descricoes criticas
        request.setAttribute(CedenteEstrategia.DESC_CRITICAS, null);
    }

    /**
     * Seta o tipo cobranca no Bean de controle de guias para verificacao se o
     * usuario pode alterar guia Cedente Eletronico
     */
    public static void setTipoCobranca(HttpServletRequest request,
            Long tipoCobranca) {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN);
        principalBean.setTipoCobranca(tipoCobranca);
        request.getSession()
                .setAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN,
                        principalBean);
    }

    /**
     * Seta o tipo cobranca no Bean de controle de guias para verificacao se o
     * usuario pode alterar guia Cedente Eletronico
     */
    public static void setCedenteCentralizador(HttpServletRequest request,
            Long cedenteCentralizador) {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN);
        principalBean.setCedenteCentralizador(cedenteCentralizador);
        request.getSession()
                .setAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN,
                        principalBean);
    }

    /**
     * Seta se existe cedente eletronico cadastrado para controle da guia de
     * cedente eletronico
     */
    public static void setCedenteEletronicoCadastrado(HttpServletRequest request,
            boolean cadastrado) {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN);
        if (cadastrado) {
            principalBean.setCedenteEletronicoCadastrado(new Integer(1));
        } else {
            principalBean.setCedenteEletronicoCadastrado(new Integer(0));
        }
        request.getSession()
                .setAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN,
                        principalBean);
    }

    public static boolean getCedenteEletronicoCadastrado(HttpServletRequest request) {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN);
        if (new Integer(1).equals(principalBean.getCedenteEletronicoCadastrado())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a proxima guia baseado nas descCriticas passadas Se houver
     * criticas seta no request a critica e retorna a guia atual Senao retorna a
     * proximaGuia
     */
    public static String proximaGuia(HttpServletRequest request,
            String descCriticas,
            String guiaAtual,
            String proximaGuia) throws Exception {
        if (!descCriticas.trim().equals("")) {
            request.setAttribute(CedenteEstrategia.DESC_CRITICAS, descCriticas);
            return guiaAtual;
        }
        request.setAttribute(CedenteEstrategia.DESC_CRITICAS, "");
        return proximaGuia;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setTitlePage(PAGE_INCLUIR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        // seta o bean do filtro
        CedenteGeralBean beanFiltro = (CedenteGeralBean) (new CedenteGeralBean()).getSessionBean(request,
                INCLUIR_FILTRO_BEAN);
        request.getSession().setAttribute(INCLUIR_FILTRO_BEAN, beanFiltro);

        CedentePrincipalBean principalBean = new CedentePrincipalBean();
        principalBean = (CedentePrincipalBean) principalBean.getRequestBean(request);

        int guia = CedenteIncluirGuiaControle.mudaGuiaAberta(principalBean,
                request);
        String situacaoCadastro = principalBean.getSituacaoGuia();
        String returnPage = PAGE_INCLUIR_PRINCIPAL;

        switch (guia) {
        case GUIA_GERAL:
            this.guiaGeralIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_GERAL;
            break;
        case GUIA_FLOAT:
            this.guiaFloatIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_FLOAT;
            break;
        case GUIA_CONTAS:
            this.guiaContasIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_CONTAS;
            break;
        case GUIA_CEDENTE_ELETRONICO:
            this.guiaCedenteEletronicoIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_CEDENTE_ELETRONICO;
            break;
        case GUIA_BLOQUETOS:
            this.guiaBloquetosIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_BLOQUETOS;
            break;
        case GUIA_MENSAGENS:
            this.guiaMensagensIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_MENSAGENS;
            break;
        case GUIA_TARIFAS:
            this.guiaTarifasIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_TARIFAS;
            break;
        case GUIA_PARAMETROS:
        	this.guiaParametroIniciar(situacaoCadastro, request);
        	returnPage = PAGE_INCLUIR_PARAMETRO;
        	break;
        case GUIA_PERMISSAO:
        	this.guiaPermissaoIniciar(situacaoCadastro, request);
        	returnPage = PAGE_INCLUIR_PERMISSAO;
        	break;        	
        case GUIA_CONCLUSAO:
            this.guiaConclusaoIniciar(situacaoCadastro, request);
            returnPage = PAGE_INCLUIR_CONCLUSAO;
            break;
        }

        // LogUtilSigcb.debug("#$% returnPage :::::: " + returnPage);

        return returnPage;

    }

    /**
     * @param situacaoCadastro
     * @param request
     */
    private void guiaConclusaoIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Consulta a guia geral se nao estiver no ambiente as informacoes
        // Usado para saber o EN
        
        CedenteGeralBean geralBean = (CedenteGeralBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN);

        // Usado so para pegar o COCLI e PV da tela
        CedenteConclusaoBean concBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).getRequestBean(request);

        // se codigo EN diferente de 0 e o cocli e pv da tela eh o mesmo do bean
        // do ambiente
        // pega o bean do ambiente
        // senao faz uma consulta a BG03 para pegar o EN
        if (geralBean != null
            && geralBean.getCodigounidadeEN() != null
            && !geralBean.getCodigounidadeEN().equals(new Long(0))
            && concBean.getCodigoClienteCOCLI()
                    .equals(geralBean.getCodigoClienteCOCLI())
            && concBean.getCodigoUnidadePVVinc()
                    .equals(geralBean.getCodigoUnidadePVVinc())) {

            request.getSession()
                    .setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
                            geralBean);

        } else {
            geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);

            // Codigo COCLI e Codigo Unidade PV vem da transacao
            geralBean.setTipoConsulta("I"); // I - dados temporarios p/ inclusao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,   transUser);

            geralBean = (CedenteGeralBean) beanListGeral.get(0);

            request.getSession()
                    .setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
                            geralBean);
        }
    }

    /**
     * @param situacaoCadastro
     * @param request
     */
    private void guiaTarifasIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        // Se alteracao da guia, carregar campos
        if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO)) {
            CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).newBean();

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            
            

            tarifasBean = (CedenteTarifasBean) tarifasBean.getRequestBean(request);

            tarifasBean.setTipoConsulta("I"); // I - dados temporarios p/
            // inclusao
            
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();

            BeanList beanListTarifas = handler.executeSimpleTransactionQuery(tarifasBean, transUser);

            tarifasBean = (CedenteTarifasBean) beanListTarifas.get(0);

            request.setAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN,
                    tarifasBean);
        }
    }
    
    
    private void guiaParametroIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        // Se alteracao da guia, carregar campos
        if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO)) {
        	
        	CedenteParametrosBean parametroBean = (CedenteParametrosBean) (new CedenteParametrosBean()).newBean();
        	
        	CedenteCabecaBean cabecaBean =  (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        	
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            parametroBean = (CedenteParametrosBean) parametroBean.getRequestBean(request);

            parametroBean.setTipoConsulta("I"); // I - dados temporarios p/
            
            parametroBean.setCodigoUnidadePVVinc(cabecaBean.getCodigoUnidadePVVinc());
            // inclusao

            
        	SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
			MontaTransacao isoMsg = new MontaTransacao();
			
			String subida = "I"+ Util.zerosEsquerda(parametroBean.getCodigoCedente(), 7) + 
					Util.zerosEsquerda(parametroBean.getCodigoClienteCOCLI(),13)+
					Util.completaEspacos(" ", 48) +
					Util.zerosEsquerda(parametroBean.getCodigoUnidadePVVinc(), 4) +
					Util.completaEspacos(parametroBean.getIcCedenteGarantia(), 1) + 
					Util.zerosEsquerda(parametroBean.getNuOperacao(), 4) + 
					Util.completaEspacos(parametroBean.getNuContrato(), 40) +
					Util.completaEspacos(parametroBean.getIcBaixa(), 1) +
					Util.completaEspacos(parametroBean.getIcMarcado(), 1) +
					Util.completaEspacos(parametroBean.getIcDesmarcado(), 1) +
					Util.completaEspacos(parametroBean.getIcContaGar(), 1) +
					Util.zerosEsquerda(parametroBean.getAgCta(), 4) +
					Util.zerosEsquerda(parametroBean.getOpeCta(), 4) +
					Util.zerosEsquerda(parametroBean.getNumCta(), 12) +
					Util.zerosEsquerda(parametroBean.getDigCta(), 1) +
					Util.completaEspacos(parametroBean.getIcLancamento(), 1) +
					Util.zerosEsquerda(parametroBean.getNuEvento(), 6) + Util.completaEspacos(parametroBean.getIcProposta(), 1) +
					Util.completaEspacos(parametroBean.getIcDebitoTarifa(), 1) +
					Util.completaEspacos(parametroBean.getIcCEP(), 1);
			
			InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
			ISOMsg mensagem = isoMsg.BGMJ(subida, usuarioBean.getCodigoUsuario().toUpperCase());		
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
				throw new Exception(campo);
				
			}
			
			LogUtilSigcb.debug("Retorno:" + (String) retorno[1].getValue(62));
			
            			
			CedenteParametrosBean retBean = this.desmontaBGMJ((String)retorno[1].getValue(62));
            
            LogUtilSigcb.debug("Recebeu parametro");
            retBean.setCodigoClienteCOCLI(parametroBean.getCodigoClienteCOCLI());
            retBean.setCodigoUnidadePVVinc(parametroBean.getCodigoUnidadePVVinc());
            retBean.setNsuTransacao("");
            Money valorLimite = new Money(0,Currency.real());
            retBean.setValorLimite(valorLimite);

            
            
            request.setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN,retBean);
            //request.getSession().setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN, retBean);
            
            
        }
    }
    
    
    private void guiaPermissaoIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        // Se alteracao da guia, carregar campos
        
        	
        	CedentePermissaoBean permissaoBean = (CedentePermissaoBean) (new CedentePermissaoBean()).newBean();
        	
        	CedenteCabecaBean cabecaBean =  (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        	
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            permissaoBean = (CedentePermissaoBean) permissaoBean.getRequestBean(request);

            permissaoBean.setTipoConsulta("I"); // I - dados temporarios p/
            
            permissaoBean.setCodigoUnidadePVVinc(cabecaBean.getCodigoUnidadePVVinc());
            // inclusao
            
            InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession()
	                 .getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
            
            HttpSession session = request.getSession(false);
            CedenteCabecaBean cedenteCabecalhoBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
            
            
        	SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
			MontaTransacao isoMsg = new MontaTransacao();

			
			
			String subida = "D"+ 
					Util.zerosEsquerda(0L,7) +
					Util.zerosEsquerda(0L, 13) +
					Util.completaEspacos("", 48) +
					Util.zerosEsquerda(0L, 4) +
					Util.completaEspacos(cedenteCabecalhoBean.getTipoPessoaTexto(), 1) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCpfCnpj(), 14) +
					Util.completaEspacos(usuarioLDAP.getCodigoUsuario(), 8);
			
		
			InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
			ISOMsg mensagem = isoMsg.BGMT(subida,usuarioBean.getCodigoUsuario().toUpperCase());		
			ISOMsg[] retorno = acao.executaSirot(mensagem);
			
			boolean erroSirot = false;
			///Tratamento do retorno da mensagem ISO
			// Verifica se deu erro no RETORNO
			if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
					 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
					 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
				{
				erroSirot = true;
				Exception erro = new Exception((String) retorno[1].getValue(120));
				throw new MainframeException(erro);
				
			}
			
			LogUtilSigcb.debug("Retorno:" + (String) retorno[1].getValue(62));
			
			
			CedConsultaPermissaoBean retBean = this.desmontaBGMT((String)retorno[1].getValue(62), (String)retorno[2].getValue(62) );
            
            LogUtilSigcb.debug("Recebeu parametro");
         
            request.setAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN,retBean);
            //request.getSession().setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN, retBean);
            
            
        
    }
    

    /**
     * @param situacaoCadastro
     * @param request
     */
    private void guiaMensagensIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        // Se alteracao da guia, carregar campos
        if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO)) {
            Long[] locaisImpressao = {
                                      new Long(BLOQ_PADRAO_RECIBO_SACADO),
                                      new Long(BLOQ_PADRAO_VERSO_BLOQUETO),
                                      new Long(BLOQ_PADRAO_FICHA_COMP),
                                      new Long(BLOQ_PERSONALIZADO_RECIBO_SACADO),
                                      new Long(BLOQ_PERSONALIZADO_VERSO_BLOQUETO),
                                      new Long(BLOQ_PERSONALIZADO_FICHA_COMP),
                                      new Long(BLOQ_PERSONALIZADO_RECIBO_SACADO_A),
                                      new Long(BLOQ_PERSONALIZADO_RECIBO_SACADO_B),
                                      new Long(BLOQ_PRE_IMPRESSO_RECIBO_SACADO_LASER),
                                      new Long(BLOQ_PRE_IMPRESSO_FICHA_COMP_MATRIC),
                                      new Long(BLOQ_BANCO_CORRESPONDENTE),
                                      new Long(BLOQ_DDA_IMPRESSO)};

            CedenteMensagensBean mensagensBean = (CedenteMensagensBean) (new CedenteMensagensBean()).newBean();
            mensagensBean = (CedenteMensagensBean) mensagensBean.getRequestBean(request);
            mensagensBean.setTipoConsulta("I"); // I - dados temporarios p/
            // inclusao

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // Chama transacao para cada local de impressao
            for (int i = 0; i < locaisImpressao.length; i++) {
                mensagensBean.setLocalImpressao(locaisImpressao[i]);
                
                InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_CONSULTAR_MENSAGENS + usuarioBean.getCodigoUsuario().toUpperCase();

                BeanList beanListMensagens = handler.executeSimpleTransactionQuery(mensagensBean,
                		transUser);

                // Obtendo as linhas da mensagem do beanList
                String[] linhasTextArea = new String[beanListMensagens.size()];
                for (int j = 0; j < beanListMensagens.size(); j++) {
                    CedenteMensagensBean tempBean = (CedenteMensagensBean) beanListMensagens.get(j);
                    linhasTextArea[tempBean.getNumeroLinhaMensagem().intValue() - 1] = tempBean.getMensagem();
                }

                // Junta as linhas numa string colocando \n
                String textArea = "";
                for (int j = 0; j < linhasTextArea.length; j++) {
                    textArea += linhasTextArea[j] + "\\n";
                }

                // LogUtilSigcb.debug("#$% :::: Local Impressao => " +
                // locaisImpressao[i] + ", TextArea => " + textArea);

                // seta no atributo correto dependendo do local de impressao
                switch (locaisImpressao[i].intValue()) {
                case BLOQ_PADRAO_RECIBO_SACADO:
                    mensagensBean.setTextAreaReciboSacadoBlqPadrao(textArea);
                    break;
                case BLOQ_PADRAO_VERSO_BLOQUETO:
                    mensagensBean.setTextAreaVersoBloquetoBlqPadrao(textArea);
                    break;
                case BLOQ_PADRAO_FICHA_COMP:
                    mensagensBean.setTextAreaFichaCompensacaoBlqPadrao(textArea);
                    break;
                case BLOQ_PERSONALIZADO_RECIBO_SACADO:
                    mensagensBean.setTextAreaReciboSacadoBlqPersonalizado(textArea);
                    break;
                case BLOQ_PERSONALIZADO_VERSO_BLOQUETO:
                    mensagensBean.setTextAreaVersoBloquetoBlqPersonalizado(textArea);
                    break;
                case BLOQ_PERSONALIZADO_FICHA_COMP:
                    mensagensBean.setTextAreaFichaCompensacaoBlqPersonalizado(textArea);
                    break;
                case BLOQ_PERSONALIZADO_RECIBO_SACADO_A:
                    mensagensBean.setTextAreaReciboSacadoABlqPersonalizado(textArea);
                    break;
                case BLOQ_PERSONALIZADO_RECIBO_SACADO_B:
                    mensagensBean.setTextAreaReciboSacadoBBlqPersonalizado(textArea);
                    break;
                case BLOQ_PRE_IMPRESSO_RECIBO_SACADO_LASER:
                    mensagensBean.setTextAreaReciboSacadoBlqPreImpresso(textArea);
                    break;
                case BLOQ_PRE_IMPRESSO_FICHA_COMP_MATRIC:
                    mensagensBean.setTextAreaFichaCompensacaoBlqPreImpresso(textArea);
                    break;
                case BLOQ_BANCO_CORRESPONDENTE:
                    mensagensBean.setTextAreaReciboSacadoBancoCorresp(textArea);
                    break;
                case BLOQ_DDA_IMPRESSO:
                	mensagensBean.setTextAreaReciboDDAImpresso(textArea);
                	break;
                }

            }

            request.setAttribute(CedenteEstrategia.CEDENTE_MENSAGENS_BEAN,
                    mensagensBean);
        }
    }

    /**
     * @param situacaoCadastro
     * @param request
     */
    private void guiaBloquetosIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        // Se alteracao da guia, carregar campos
        
            CedenteBloquetosBean bloqBean = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            bloqBean = (CedenteBloquetosBean) bloqBean.getRequestBean(request);

            bloqBean.setTipoConsulta("I"); // I - dados temporarios p/ inclusao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListBloq = handler.executeSimpleTransactionQuery(bloqBean,
            		transUser);

            bloqBean = (CedenteBloquetosBean) beanListBloq.get(0);

            // se foi escolhido Envio do Aviso Sacado, entao Aviso Sacado eh Sim
            if (!new Long(99).equals(bloqBean.getEnvioAvisoSacado())) {
                bloqBean.setAvisoSacado("S");
            }

            request.setAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN,  bloqBean);
        
    }

    /**
     * @param situacaoCadastro
     * @param request
     */
    private void guiaCedenteEletronicoIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        // Se alteracao da guia, carregar campos
        // if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO))
        // {
        if (CedenteIncluirGuiaControle.getCedenteEletronicoCadastrado(request) == true) {
            CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            eletronBean = (CedenteEletronicoBean) eletronBean.getRequestBean(request);

            eletronBean.setTipoConsulta("I"); // I - dados temporarios p/
            // inclusao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListEletron = handler.executeSimpleTransactionQuery(eletronBean,
            		transUser);

            eletronBean = (CedenteEletronicoBean) beanListEletron.get(0);

            request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN,
                    eletronBean);
        }
    }

    /**
     * @param situacaoCadastro
     * @param request
     */
    private void guiaContasIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Consulta a guia geral se nao estiver no ambiente as informacoes
        // Usado para saber a modalidade titulo
        CedenteGeralBean geralBean = (CedenteGeralBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN);
        if (geralBean == null) {
            geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
            geralBean.setTipoConsulta("I"); // I - dados temporarios p/ inclusao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,
            		transUser);
            geralBean = (CedenteGeralBean) beanListGeral.get(0);
            request.getSession()
                    .setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
                            geralBean);
        }

        // Se alteracao da guia, carregar campos
        if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO)) {

            // Consulta as contas ja cadastradas
            CedenteContasBean contasBean = (CedenteContasBean) (new CedenteContasBean()).newBean();

            contasBean = (CedenteContasBean) contasBean.getRequestBean(request);

            contasBean.setTipoConsulta("I"); // I - dados temporarios p/
            // inclusao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_CONTAS + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListContas = handler.executeSimpleTransactionQuery(contasBean,
            		transUser);

            ArrayList alContaRateioUnidade = new ArrayList();
            ArrayList alContaRateioOperacao = new ArrayList();
            ArrayList alContaRateioConta = new ArrayList();
            ArrayList alContaRateioDV = new ArrayList();
            ArrayList alTxtPercCredito = new ArrayList();
            ArrayList alTxtPercDebito = new ArrayList();
            ArrayList alValorRateio = new ArrayList();
            ArrayList alContaCpfCnpj = new ArrayList();
            ArrayList alContaTitular = new ArrayList();

            // Guarda os indice do ArrayList da conta da chave
            // A chave eh a unidade, operacao, conta e dv concatenados como
            // String
            // Usado porque uma conta rateio que eh de credito e debito eh salva
            // em 2 registros,
            // mas mostrada em apenas uma linha na tela
            HashMap hmIndiceConta = new HashMap();

            // Inicializando os ArrayLists
            // Conta Principal Credito, Debito e Caucionada
            for (int j = 0; j < 3; j++) {
                alContaRateioUnidade.add("");
                alContaRateioOperacao.add("");
                alContaRateioConta.add("");
                alContaRateioDV.add("");
                alTxtPercCredito.add("");
                alTxtPercDebito.add("");
                alValorRateio.add("");
            }

            for (int i = 0; i < beanListContas.size(); i++) {
                CedenteContasBean bean = (CedenteContasBean) beanListContas.get(i);

                String contaUnidade = "" + bean.getContaRateioUnidade();
                String contaOperacao = "" + bean.getContaRateioOperacao();
                String conta = "" + bean.getContaRateioConta();
                String contaDV = "" + bean.getContaRateioDV();
                String percentual = Util.toStr(bean.getPercentualRateio());
                String valorRateio = Util.toStr(bean.getValorRateio());

                String chaveHs = contaUnidade + contaOperacao + conta + contaDV;

                // Guardam somente as contas rateio
                // As contas principais e de caucao ficam nos 3 primeiros
                // indices do array
                switch (bean.getTipoConta().intValue()) {
                case 1: // Conta Principal Credito
                    alContaRateioUnidade.remove(0);
                    alContaRateioOperacao.remove(0);
                    alContaRateioConta.remove(0);
                    alContaRateioDV.remove(0);
                    alTxtPercCredito.remove(0);
                    alTxtPercDebito.remove(0);
                    alValorRateio.remove(0);

                    alContaRateioUnidade.add(0, contaUnidade);
                    alContaRateioOperacao.add(0, contaOperacao);
                    alContaRateioConta.add(0, conta);
                    alContaRateioDV.add(0, contaDV);
                    alTxtPercCredito.add(0, percentual);
                    alTxtPercDebito.add(0, "");
                    alValorRateio.add(0, valorRateio);
                    break;

                case 2: // Conta Principal Debito
                    alContaRateioUnidade.remove(1);
                    alContaRateioOperacao.remove(1);
                    alContaRateioConta.remove(1);
                    alContaRateioDV.remove(1);
                    alTxtPercCredito.remove(1);
                    alTxtPercDebito.remove(1);
                    alValorRateio.remove(1);

                    alContaRateioUnidade.add(1, contaUnidade);
                    alContaRateioOperacao.add(1, contaOperacao);
                    alContaRateioConta.add(1, conta);
                    alContaRateioDV.add(1, contaDV);
                    alTxtPercCredito.add(1, "");
                    alTxtPercDebito.add(1, percentual);
                    alValorRateio.add(1, valorRateio);
                    break;

                case 4: // Conta Caucao
                    alContaRateioUnidade.remove(2);
                    alContaRateioOperacao.remove(2);
                    alContaRateioConta.remove(2);
                    alContaRateioDV.remove(2);
                    alTxtPercCredito.remove(2);
                    alTxtPercDebito.remove(2);
                    alValorRateio.remove(2);

                    alContaRateioUnidade.add(2, contaUnidade);
                    alContaRateioOperacao.add(2, contaOperacao);
                    alContaRateioConta.add(2, conta);
                    alContaRateioDV.add(2, contaDV);
                    alTxtPercCredito.add(2, "");
                    alTxtPercDebito.add(2, "");
                    alValorRateio.add(2, valorRateio);
                    break;

                case 5: // Conta Rateio Credito
                    // se conta nao foi criada ainda
                    if (hmIndiceConta.get(chaveHs) == null) {
                        alContaRateioUnidade.add(contaUnidade);
                        alContaRateioOperacao.add(contaOperacao);
                        alContaRateioConta.add(conta);
                        alContaRateioDV.add(contaDV);
                        alTxtPercCredito.add(percentual);
                        alTxtPercDebito.add("");
                        alValorRateio.add(valorRateio);

                        String[] cpfTitular = this.descobreCpf(bean.getContaRateioUnidade(),
                                bean.getContaRateioOperacao(),
                                bean.getContaRateioConta(),
                                bean.getContaRateioDV(),
                                this.getCodigoUsuario(request));

                        alContaCpfCnpj.add(cpfTitular[0]);
                        alContaTitular.add(cpfTitular[1]);

                        hmIndiceConta.put(chaveHs,
                                new Integer(alContaRateioUnidade.size() - 1));
                    } else {
                        // somente modifica a parte de credito
                        int indice = ((Integer) hmIndiceConta.get(chaveHs)).intValue();
                        alTxtPercCredito.remove(indice);
                        alValorRateio.remove(indice);
                        alTxtPercCredito.add(indice, percentual);
                        alValorRateio.add(valorRateio);
                    }
                    break;

                case 6: // Conta Rateio Debito
                    // se conta nao foi criada ainda
                    if (hmIndiceConta.get(chaveHs) == null) {
                        alContaRateioUnidade.add(contaUnidade);
                        alContaRateioOperacao.add(contaOperacao);
                        alContaRateioConta.add(conta);
                        alContaRateioDV.add(contaDV);
                        alTxtPercCredito.add("");
                        alTxtPercDebito.add(percentual);
                        alValorRateio.add(valorRateio);

                        String[] cpfTitular = this.descobreCpf(bean.getContaRateioUnidade(),
                                bean.getContaRateioOperacao(),
                                bean.getContaRateioConta(),
                                bean.getContaRateioDV(),
                                this.getCodigoUsuario(request));

                        alContaCpfCnpj.add(cpfTitular[0]);
                        alContaTitular.add(cpfTitular[1]);

                        hmIndiceConta.put(chaveHs,
                                new Integer(alContaRateioUnidade.size() - 1));
                    } else {
                        // somente modifica a parte de debito
                        int indice = ((Integer) hmIndiceConta.get(chaveHs)).intValue();
                        alTxtPercDebito.remove(indice);
                        alTxtPercDebito.add(indice, percentual);
                    }
                    break;
                }
            }

            request.setAttribute("contaRateioUnidade",
                    this.montaStrArray(alContaRateioUnidade));
            request.setAttribute("contaRateioOperacao",
                    this.montaStrArray(alContaRateioOperacao));
            request.setAttribute("contaRateioConta",
                    this.montaStrArray(alContaRateioConta));
            request.setAttribute("contaRateioDV",
                    this.montaStrArray(alContaRateioDV));
            request.setAttribute("txtPercCredito",
                    this.montaStrArray(alTxtPercCredito));
            request.setAttribute("txtPercDebito",
                    this.montaStrArray(alTxtPercDebito));
            request.setAttribute("valorRateio",
                    this.montaStrArray(alValorRateio));
            request.setAttribute("contaCpfCnpj",
                    this.montaStrArray(alContaCpfCnpj));
            request.setAttribute("contaTitular",
                    this.montaStrArray(alContaTitular));

            if (alContaRateioUnidade.size() > 3) {
                request.setAttribute("selectNumeroContas",
                        "" + (alContaRateioUnidade.size() - 3));
                request.setAttribute("selectContasRateio", "S");
            }
        }

    }

    private String[] descobreCpf(Long contaRateioUnidade,
            Long contaRateioOperacao,
            Long contaRateioConta,
            Long contaRateioDV,
            String codigoUsuario) throws Exception {
        // 0 - Cpf
        // 1 - Titular
        String[] cpfTitular = new String[2];

        if (contaRateioUnidade == null
            || contaRateioUnidade.equals(new Long(0))) {
            cpfTitular[0] = "";
            cpfTitular[1] = "";
            return cpfTitular;
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        CedenteContasBean contasBean = new CedenteContasBean();
        contasBean.setContaRateioUnidade(contaRateioUnidade);
        contasBean.setContaRateioOperacao(contaRateioOperacao);
        contasBean.setContaRateioConta(contaRateioConta);
        contasBean.setContaRateioDV(contaRateioDV);
        contasBean.setCodigoUsuario(codigoUsuario);
      
        String transUser = TRANSACAO_CONSULTAR_CONTA_SICLI + codigoUsuario.toUpperCase();
        BeanList respostaBean = handler.executeSimpleTransactionQuery(contasBean,  transUser);
        contasBean = (CedenteContasBean) respostaBean.get(0);

        if (new Long(1).equals(contasBean.getTipoPessoa())) { // 1 - FISICA
            cpfTitular[0] = Formatacao.formataCPF(contasBean.getCpfCnpj().toString());
        } else {
            cpfTitular[0] = Formatacao.formataCNPJ(contasBean.getCpfCnpj().toString());
        }
        cpfTitular[1] = contasBean.getTitular();

        return cpfTitular;
    }

    //
    // Usado no CedenteIncluirFiltro para carregar no bean de Controle de Guias
    // (CedentePrincipalBean)
    // o tipo cobranca. Isso soh para saber se pode abrir a guia de Cedente
    // Eletronico ou nao...
    //
    public CedenteGeralBean guiaGeralIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        CedenteGeralBean geralBean = new CedenteGeralBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Se alteracao da guia, carregar campos
        if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO)) {
            geralBean = (CedenteGeralBean) geralBean.getRequestBean(request);

            // Codigo COCLI e Codigo Unidade PV vem da transacao
            geralBean.setTipoConsulta("I"); // I - dados temporarios p/ inclusao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);

            geralBean = (CedenteGeralBean) beanListGeral.get(0);

        }

        request.getSession().setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,  geralBean);

        return geralBean;
    }

    private void guiaFloatIniciar(String situacaoCadastro,
            HttpServletRequest request) throws Exception {
        CedenteFloatBean floatBean = (CedenteFloatBean) (new CedenteFloatBean()).newBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Lista Padrao
        floatBean.setTipoConsulta("D"); // D - dados default
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_FLOAT + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListFloatDefault = handler.executeSimpleTransactionQuery(floatBean,
        		transUser);
        ArrayList listFloatDefault = convertDataStructure(beanListFloatDefault.iterator());
        request.getSession()
                .setAttribute(FLOAT_LISTA_DEFAULT, listFloatDefault);

        // Se alteracao da guia, carregar campos
        if (situacaoCadastro.equals(CedenteEstrategia.ALTERACAO_EM_INCLUSAO)) {
            floatBean = (CedenteFloatBean) floatBean.getRequestBean(request);

            // Codigo COCLI e Codigo Unidade PV vem da transacao
            floatBean.setTipoConsulta("I"); // I - dados temporarios p/ inclusao

            BeanList beanListFloat = handler.executeSimpleTransactionQuery(floatBean,
                    TRANSACAO_CONSULTAR_FLOAT);
            ArrayList listFloat = convertDataStructure(beanListFloat.iterator());
            request.getSession().setAttribute(FLOAT_LISTA, listFloat);
        }
    }
    
    public CedenteParametrosBean desmontaBGMJ(String rajada){
    	CedenteParametrosBean retorno = new CedenteParametrosBean();
    	retorno.setAutorizacao(rajada.substring(0,2));
    	retorno.setTipoCalculo(rajada.substring(2,3));
    	retorno.setIcgarantia(rajada.substring(3,4));
    	retorno.setIcboleto(rajada.substring(4,5));
    	retorno.setIcvalor(rajada.substring(5,6));
    	retorno.setCreditoOnline(rajada.substring(6, 7));
    	retorno.setClienteExterno(rajada.substring(7, 8));
    	retorno.setIcFinalizacao(rajada.substring(8, 9));
    	retorno.setCodigoContabil(rajada.substring(9, 15));
    	retorno.setUnidadeCredito(rajada.substring(15, 16));
    	retorno.setIcRateio(rajada.substring(16, 17));
    	retorno.setIcCedenteGarantia(rajada.substring(17, 18));
    	retorno.setNuOperacao(Long.parseLong(rajada.substring(18, 22)));
    	retorno.setNuContrato(rajada.substring(22, 62));
    	retorno.setIcBaixa(rajada.substring(62, 63));
    	retorno.setIcMarcado(rajada.substring(63, 64));
    	retorno.setIcDesmarcado(rajada.substring(64, 65));
    	retorno.setIcContaGar(rajada.substring(65, 66));
    	retorno.setAgCta(Long.parseLong(rajada.substring(66, 70)));
    	retorno.setOpeCta(Long.parseLong(rajada.substring(70, 74)));
    	retorno.setNumCta(Long.parseLong(rajada.substring(74, 86)));
    	retorno.setDigCta(Long.parseLong(rajada.substring(86, 87)));
    	retorno.setIcLancamento(rajada.substring(87, 88));
    	retorno.setNuEvento(Long.parseLong(rajada.substring(88, 89)));
    	retorno.setIcProposta(rajada.substring(94, 95));
    	retorno.setIcDebitoTarifa(rajada.substring(95, 96));
    	retorno.setIcCEP(rajada.substring(96, 97));
    	retorno.setIcBeneficiario(rajada.substring(97, 99));
    	retorno.setNuSITCS(Long.valueOf(rajada.substring(99, 105)));
    	retorno.setCodigoContabilDeb(rajada.substring(105, 111));
    	retorno.setAutCCA(rajada.substring(111, 112));
    	retorno.setIcIndiceEspecial(rajada.substring(112, 113));
    	retorno.setTpIndice(rajada.substring(113, 128));
    	retorno.setIcAplIndiceEspecial(rajada.substring(128, 130));
    	
    	
    	return retorno;
    	
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
