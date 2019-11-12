package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteExpressoBean;
import br.gov.caixa.sigcb.bean.CedenteFloatBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedentePermissaoBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.ComboAtribuicaoVan;
import br.gov.caixa.sigcb.util.jsp.ComboCobracaSimNao;
import br.gov.caixa.sigcb.util.jsp.ComboFormaCalculo;
import br.gov.caixa.sigcb.util.jsp.ComboGiroCaixa;
import br.gov.caixa.sigcb.util.jsp.ComboModalidadeTitulo;
import br.gov.caixa.sigcb.util.jsp.ComboPadraoArquivo;
import br.gov.caixa.sigcb.util.jsp.ComboPerfilRejeicao;
import br.gov.caixa.sigcb.util.jsp.ComboSimNao;
import br.gov.caixa.sigcb.util.jsp.ComboTipoCobranca;

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
public class CedenteIncluirExpressoExecutar extends CedenteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute("usuarioLdap");

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        
        String ip = request.getRemoteAddr();

        CedenteExpressoBean cedenteExpresso = new CedenteExpressoBean();
        
        cedenteExpresso = (CedenteExpressoBean) cedenteExpresso.getRequestBean(request);
        
        cedenteExpresso.setIpConexao(ip);
        
        CedenteGeralBean beanFiltro = new CedenteGeralBean();
        
        beanFiltro = (CedenteGeralBean) request.getSession().getAttribute(INCLUIR_FILTRO_BEAN);
        
        cedenteExpresso.setTpPessoa(beanFiltro.getTipoInscricao());
        
        cedenteExpresso.setCpfCnpj(beanFiltro.getCpfCnpj());
        
        request.setAttribute(CedenteEstrategia.INCLUIR_EXPRESSO_BEAN, cedenteExpresso);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        // Obtendo dados de cabecalho
        CedenteCabecaBean cedenteCabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).newBean();
        cedenteCabecaBean.setTipoConsulta(new Long(2)); // POR COCLI
        cedenteCabecaBean.setCodigoClienteCOCLI(cedenteExpresso.getNuCOCLI());
        cedenteCabecaBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedenteCabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet

        BeanList respostaList = handler.executeSimpleTransactionQuery(cedenteCabecaBean,TRANSACAO_CABECALHO);
        cedenteCabecaBean = (CedenteCabecaBean) respostaList.get(0);

        request.getSession().setAttribute(CEDENTE_CABECA_BEAN,  cedenteCabecaBean);
        
        cedenteExpresso.setTipoAcao("V");
        
        request.getSession().setAttribute("INCLUIR_EXPRESSO_CONFIRMA",  cedenteExpresso);
        
        BeanList blExpresso = handler.executeSimpleTransactionQuery(cedenteExpresso,  TRANSACAO_EXPRESSO_VALIDAR);
        
        CedenteExpressoBean cedenteExpressoRet = new CedenteExpressoBean();
        
        cedenteExpressoRet = (CedenteExpressoBean) blExpresso.get(0);
       
        cedenteExpressoRet.setPcRateio(cedenteExpressoRet.getPcRateio().substring(0, 3) + "," + cedenteExpressoRet.getPcRateio().substring(3, 5) + "%");
        cedenteExpressoRet.setPcRateiodeb(cedenteExpressoRet.getPcRateiodeb().substring(0, 3) + "," + cedenteExpressoRet.getPcRateiodeb().substring(3, 5) + "%");
        
        request.setAttribute(CedenteEstrategia.INCLUIR_EXPRESSO_BEAN_CONFIRMA, cedenteExpressoRet);
        
        //Guia Geral
        
        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).newBean();
        geralBean.setAtividade(Long.parseLong(cedenteExpressoRet.getTpAtividade()));
        geralBean.setBancoCorrespondente(cedenteExpressoRet.getBcoCor()=="S"?"SIM":"NÃO");
        geralBean.setBancoSacados(cedenteExpressoRet.getBcoSac());
        geralBean.setCedentePEC(cedenteExpressoRet.getCedMasterPec());
        geralBean.setCedenteVinculo(Long.parseLong(cedenteExpressoRet.getCedVincPec()));
        //geralBean.setCedSemRegistro();
        //geralBean.setClienteExterno(clienteExterno);
        geralBean.setPrazoProtesto(Long.parseLong(cedenteExpressoRet.getPzProt()));
        geralBean.setClienteGiroCaixa(Long.parseLong(cedenteExpressoRet.getGirCaixa()));
        geralBean.setClienteSINCE(cedenteExpressoRet.getCliSin());
        geralBean.setCobrancaSemBloqueto(cedenteExpressoRet.getIcCobSemBlq());
        geralBean.setCodCedenteCentraliz(Long.parseLong(cedenteExpressoRet.getCedCent()));
        geralBean.setCodigoCedente(cedenteExpresso.getCodCedente());
        geralBean.setCodigoClienteCOCLI(cedenteExpresso.getNuCOCLI());
        geralBean.setCodigoSINCE(Long.parseLong(cedenteExpressoRet.getCocliSince()));
        geralBean.setCodigoUnidadePVVinc(cedenteExpresso.getNuPv());
        geralBean.setCodRedeTransmissao(Long.parseLong(cedenteExpressoRet.getNuRede()));
        geralBean.setDataPEC(cedenteExpressoRet.getDataVincPec());
       
        geralBean.setDescNatureza(cedenteExpressoRet.getDeNatureza());
        geralBean.setDescPorte(cedenteExpressoRet.getDePorte());
        geralBean.setDescRamoAtividade(cedenteExpressoRet.getDeRamo());
        geralBean.setDescSetor(cedenteExpressoRet.getDeSetor());
        //geralBean.setDescTipoCobranca();
        geralBean.setDescTipoJurosDia(cedenteExpressoRet.getDescrTipJur());
        geralBean.setDtAltPvVinc(cedenteExpressoRet.getDtAltPvVinc());
        
        //geralBean.setDestinoExtMov(cedenteExpressoRet.getDescrExt();
       // geralBean.setDestinoExtMovDebtCredt(Long.parseLong(cedenteExpressoRet.getExtDebCred()));
        
        geralBean.setDescDestinoExtMov(cedenteExpressoRet.getDescrExt());
        geralBean.setDescDestinoExtMovDebtCredt(cedenteExpressoRet.getDescrExtDeb());
        
        
        geralBean.setExtratoMovDebtCredt(cedenteExpressoRet.getExtDebCred());
        geralBean.setExtratoMovTit(cedenteExpressoRet.getExtTit());
        
        geralBean.setInventarioMes(cedenteExpressoRet.getInvMen());
        geralBean.setNatureza(Long.parseLong(cedenteExpressoRet.getNatureza()));
        geralBean.setPorte(Long.parseLong(cedenteExpressoRet.getPorte()));
        geralBean.setPrazoDevolucao(Long.parseLong(cedenteExpressoRet.getPzDev()));
        geralBean.setProtestoAutomatico(cedenteExpressoRet.getProAut());
        geralBean.setPvVincAnt(cedenteExpressoRet.getPvVincAnt());
        geralBean.setRamoAtividade(Long.parseLong(cedenteExpressoRet.getRamo()));
        geralBean.setRecebimentoCheque(cedenteExpressoRet.getRecCheque());
        geralBean.setRetencaoIOF(cedenteExpressoRet.getIof());
        geralBean.setSetor(Long.parseLong(cedenteExpressoRet.getSetor()));
        
        geralBean.setExclusaoAutomatica(cedenteExpressoRet.getExcAut());
        geralBean.setModalidadeTitulo(Long.parseLong(cedenteExpressoRet.getModTit()));
        
        
        geralBean.setTipoCobranca(cedenteExpressoRet.getTpCobranca());
        //geralBean.setTipoInscricao();
        geralBean.setTipoJurosDia(Long.parseLong(cedenteExpressoRet.getTipJur()));
        geralBean.setValorDiferenciado(cedenteExpressoRet.getValorDif());
        
        double valJuros = Double.valueOf(cedenteExpressoRet.getPerJur());
        valJuros = valJuros /100;
        String vrJuros = String.valueOf(valJuros);
        
        Percentual jurosDia = new Percentual(vrJuros);
        Percentual multa = new Percentual(cedenteExpressoRet.getPerMulta());
        
        geralBean.setPercentualJurosDia(jurosDia);
        geralBean.setMulta(multa);
        geralBean.setPrazoMulta(Long.parseLong(cedenteExpressoRet.getPzMulta()));
        
       
        
        formataGeral(geralBean);
        request.setAttribute(CEDENTE_GERAL_BEAN, geralBean);	
        
        //Guia Eletronico
        CedenteEletronicoBean producaoBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();
        CedenteEletronicoBean testeBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();
        if (cedenteExpressoRet.getIcAmbienteEle().equalsIgnoreCase("T")){
        	testeBean.setAplicativoDesc(cedenteExpressoRet.getDscAplicativo());
        	testeBean.setVersao(cedenteExpressoRet.getCoVrsApl());
        	testeBean.setTipoTransmissao(Long.parseLong(cedenteExpressoRet.getTpTran()));
        	testeBean.setTipoTransmissaoDesc(cedenteExpressoRet.getDscTran());
        	testeBean.setPadraoArquivo(Long.parseLong(cedenteExpressoRet.getIcPadraoEle()));
        	testeBean.setAgrupamento(Long.parseLong(cedenteExpressoRet.getSit()));
        	testeBean.setAtribuicaoVan(Long.parseLong(cedenteExpressoRet.getIcAtrVan()));
        	testeBean.setVanDesc(cedenteExpressoRet.getDscVan());
        	testeBean.setNumeroProximaRemessa(Long.parseLong(cedenteExpressoRet.getNuUltRem()));
        	testeBean.setCodConnect(cedenteExpressoRet.getConnect());
        	testeBean.setDescConnect(cedenteExpressoRet.getDeConnect());
        	testeBean.setCodInternet(cedenteExpressoRet.getInternet());
        	testeBean.setDescInternet(cedenteExpressoRet.getDeInternet());
        	testeBean.setJuncaoArquivoRetorno(cedenteExpressoRet.getIcJunRet());
        	testeBean.setCedenteJuncao(Long.parseLong(cedenteExpressoRet.getCedJunc()));
        	testeBean.setPerfilRejeicao(Long.parseLong(cedenteExpressoRet.getIcRej()));
        	testeBean.setPreCritica(cedenteExpressoRet.getIcNot());
        	testeBean.setApelido(cedenteExpressoRet.getCoApe());
        	testeBean.setArquivoRetorno(cedenteExpressoRet.getCoDsn());
        	testeBean.setNumeroProximaRemessa(Long.parseLong(cedenteExpressoRet.getNuUltRem()));
        	testeBean.setNumeroUltimoRetorno(Long.parseLong(cedenteExpressoRet.getNuUltRet()));
        	testeBean.setDataEnvioReenvio(cedenteExpressoRet.getDtCargaIni());
        	testeBean.setSituacaoVAN(cedenteExpressoRet.getSituacao());
        	testeBean.setRetOnline(cedenteExpressoRet.getNuUltReto());
        	testeBean.setCadastrado("S");
        	testeBean.setCopiaArquivoRetorno(cedenteExpressoRet.getIcArqDup());
        	testeBean.setRemOnline(cedenteExpressoRet.getIcRemOnline());
        	testeBean.setWebservice(cedenteExpressoRet.getIcServicoWeb());
        	formataCedenteEletronico(testeBean);
        }else if (cedenteExpressoRet.getIcAmbienteEle().equalsIgnoreCase("P")){
        	producaoBean.setAplicativoDesc(cedenteExpressoRet.getDscAplicativo());
        	producaoBean.setVersao(cedenteExpressoRet.getCoVrsApl());
        	producaoBean.setTipoTransmissao(Long.parseLong(cedenteExpressoRet.getTpTran()));
        	producaoBean.setTipoTransmissaoDesc(cedenteExpressoRet.getDscTran());
        	producaoBean.setPadraoArquivo(Long.parseLong(cedenteExpressoRet.getIcPadraoEle()));
        	producaoBean.setAgrupamento(Long.parseLong(cedenteExpressoRet.getSit()));
        	producaoBean.setAtribuicaoVan(Long.parseLong(cedenteExpressoRet.getIcAtrVan()));
        	producaoBean.setVanDesc(cedenteExpressoRet.getDscVan());
        	producaoBean.setNumeroProximaRemessa(Long.parseLong(cedenteExpressoRet.getNuUltRem()));
        	producaoBean.setCodConnect(cedenteExpressoRet.getConnect());
        	producaoBean.setDescConnect(cedenteExpressoRet.getDeConnect());
        	producaoBean.setCodInternet(cedenteExpressoRet.getInternet());
        	producaoBean.setDescInternet(cedenteExpressoRet.getDeInternet());
        	producaoBean.setJuncaoArquivoRetorno(cedenteExpressoRet.getIcJunRet());
        	producaoBean.setCedenteJuncao(Long.parseLong(cedenteExpressoRet.getCedJunc()));
        	producaoBean.setPerfilRejeicao(Long.parseLong(cedenteExpressoRet.getIcRej()));
        	producaoBean.setPreCritica(cedenteExpressoRet.getIcNot());
        	producaoBean.setApelido(cedenteExpressoRet.getCoApe());
        	producaoBean.setArquivoRetorno(cedenteExpressoRet.getCoDsn());
        	producaoBean.setNumeroProximaRemessa(Long.parseLong(cedenteExpressoRet.getNuUltRem()));
        	producaoBean.setNumeroUltimoRetorno(Long.parseLong(cedenteExpressoRet.getNuUltRet()));
        	producaoBean.setDataEnvioReenvio(cedenteExpressoRet.getDtCargaIni());
        	producaoBean.setSituacaoVAN(cedenteExpressoRet.getSituacao());
        	producaoBean.setRetOnline(cedenteExpressoRet.getNuUltReto());
        	producaoBean.setCadastrado("S");
        	producaoBean.setCopiaArquivoRetorno(cedenteExpressoRet.getIcArqDup());
        	producaoBean.setRemOnline(cedenteExpressoRet.getIcRemOnline());
        	producaoBean.setWebservice(cedenteExpressoRet.getIcServicoWeb());
        	formataCedenteEletronico(producaoBean);
        }
        request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN,  testeBean);
        request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN,producaoBean);
        
        
        
        // Tarifas
        
        CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).newBean();
        
        tarifasBean = (CedenteTarifasBean) tarifasBean.getRequestBean(request);
        tarifasBean.setTipoConsulta("D"); 
        tarifasBean.setCodigoUnidadePVVinc(cedenteExpresso.getNuPv());
        tarifasBean.setCodigoClienteCOCLI(cedenteExpresso.getNuCOCLI());
        tarifasBean.setCodigoAgrupamentoServico("A01");
        tarifasBean.setTipoConsulta("D");


	    
        BeanList beanListTarifas = handler.executeSimpleTransactionQuery(tarifasBean, TRANSACAO_CONSULTAR_INFORME_TARIFAS);
        tarifasBean = (CedenteTarifasBean) beanListTarifas.get(0);
        tarifasBean.setFormaCalculo(Long.parseLong(cedenteExpressoRet.getIcFormaCalculo()));
        formataTarifas(tarifasBean);
        tarifasBean.setPeriodicidadeTarifaDesc(cedenteExpressoRet.getDePeriodo());
	    tarifasBean.setFormaCalculo(Long.parseLong(cedenteExpressoRet.getIcFormaCalculo()));
	    tarifasBean.setDiaDebito(Long.parseLong(cedenteExpressoRet.getDdDebito()));
        request.setAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN, tarifasBean);
        
        //Float
        // Lista Padrao
        CedenteFloatBean floatBean = (CedenteFloatBean) (new CedenteFloatBean()).newBean();
        floatBean.setTipoConsulta("D"); // D - dados default
        floatBean.setCodigoUnidadePVVinc(cedenteExpresso.getNuPv());
        floatBean.setCodigoClienteCOCLI(cedenteExpresso.getNuCOCLI());
        BeanList beanListFloatDefault = handler.executeSimpleTransactionQuery(floatBean, TRANSACAO_CONSULTAR_FLOAT);
        ArrayList listFloatDefault = convertDataStructure(beanListFloatDefault.iterator());
        request.setAttribute(FLOAT_LISTA_DEFAULT, listFloatDefault);
        request.setAttribute(FLOAT_LISTA, listFloatDefault);
        
        //Boletos
        CedenteBloquetosBean bloqBean = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();
        
        bloqBean.setDescEmissaoBloquetos(cedenteExpressoRet.getDeEmisBloq());
        bloqBean.setEnvioBloqueto(Long.parseLong(cedenteExpressoRet.getTpEntregaBloq()));
        bloqBean.setDescEnvioBloqueto(cedenteExpressoRet.getDeEntregaBloq());
        bloqBean.setAvisoSacado(cedenteExpressoRet.getIcAvisoProt());
        bloqBean.setImpBloqDDA(cedenteExpressoRet.getImprimeDDA());
        bloqBean.setEnvioSMS(cedenteExpressoRet.getIcEnvioSms());
        //bloqBean.setDescEnvioBloqueto(cedenteExpressoRet.getDeEmisBloq());
        bloqBean.setDescEnvioAvisoSacado(cedenteExpressoRet.getDeEntregaSac());
        bloqBean.setFormasAvisoVencido(cedenteExpressoRet.getIcAvisoVenc());
        bloqBean.setQtdeDiasProtesto(Long.parseLong(cedenteExpressoRet.getQtdDiasProt()));
        bloqBean.setAvisoDisponibPrimeira(Long.parseLong(cedenteExpressoRet.getAvisDisBloq1()));
        bloqBean.setAvisoDisponibSegunda(Long.parseLong(cedenteExpressoRet.getAvisDisBloq2()));
        bloqBean.setAvisoDisponibTerceira(Long.parseLong(cedenteExpressoRet.getAvisDisBloq3()));
        bloqBean.setAvisoVencidoPrimeira(Long.parseLong(cedenteExpressoRet.getAvisVenc1()));
        bloqBean.setAvisoVencidoSegunda(Long.parseLong(cedenteExpressoRet.getAvisVenc2()));
        bloqBean.setAvisoVencidoTerceira(Long.parseLong(cedenteExpressoRet.getAvisVenc3()));
        bloqBean.setPrazoSMS1(Long.parseLong(cedenteExpressoRet.getPrazoSms1()));
        bloqBean.setPrazoSMS2(Long.parseLong(cedenteExpressoRet.getPrazoSms2()));
        bloqBean.setPrazoSMS3(Long.parseLong(cedenteExpressoRet.getPrazoSms3()));
        
        bloqBean.setQtdeBolMes(Long.parseLong(cedenteExpressoRet.getQtdeBoleto()));
        
        Long vrMinimo = Long.parseLong(cedenteExpressoRet.getVrMinimo());
        Long vrMaximo = Long.parseLong(cedenteExpressoRet.getVrMaximo());
        
        
        Money valormin = new Money(Util.zerosEsquerda(new Long(vrMinimo), 15), 2, Currency.real());
    	Money valormax = new Money(Util.zerosEsquerda(new Long(vrMaximo), 15), 2, Currency.real());
        
        bloqBean.setValorMinULCCA(valormin);
        bloqBean.setValorMaxULCCA(valormax);
        
        
        
        
        
        this.formataBloquetos(bloqBean);
        request.setAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN, bloqBean);
        
        
        //Guia Parametros
        CedenteParametrosBean parametrosBean = (CedenteParametrosBean) (new CedenteParametrosBean()).newBean();
        
        parametrosBean.setTipoCalculo(cedenteExpressoRet.getTpCalc());
        parametrosBean.setAutorizacao(cedenteExpressoRet.getAutVrCob());
        parametrosBean.setIcgarantia(cedenteExpressoRet.getGarOpcrd());
        parametrosBean.setIcboleto(cedenteExpressoRet.getBolExpresso());
        parametrosBean.setIcvalor(cedenteExpressoRet.getLimValor());
        parametrosBean.setCreditoOnline(cedenteExpressoRet.getCreOnline());
        parametrosBean.setClienteExterno(cedenteExpressoRet.getIcClienteExterno());
        parametrosBean.setIcFinalizacao(cedenteExpressoRet.getIcFimDfrd());
        parametrosBean.setCodigoContabil(cedenteExpressoRet.getNuEvtContabil());
        parametrosBean.setUnidadeCredito(cedenteExpressoRet.getIcUndCrdo());
        parametrosBean.setIcRateio(cedenteExpressoRet.getIcrateioTit());
        parametrosBean.setIcCedenteGarantia(cedenteExpressoRet.getIcCedGarantia());
        parametrosBean.setNuOperacao(Long.parseLong(cedenteExpressoRet.getNuOpGarantia()));
        parametrosBean.setNuContrato(cedenteExpressoRet.getNuContratoGarantia());
        parametrosBean.setIcBaixa(cedenteExpressoRet.getIcBaixaGar());
        parametrosBean.setIcMarcado(cedenteExpressoRet.getIcMrcGar());
        parametrosBean.setIcDesmarcado(cedenteExpressoRet.getIcDsmGar());
        parametrosBean.setIcContaGar(cedenteExpressoRet.getIcContaGar());
        parametrosBean.setAgCta(Long.parseLong(cedenteExpressoRet.getNuUnidadeGar()));
        parametrosBean.setOpeCta(Long.parseLong(cedenteExpressoRet.getNuOpGar()));
        parametrosBean.setNumCta(Long.parseLong(cedenteExpressoRet.getNuContagar()));
        parametrosBean.setDigCta(Long.parseLong(cedenteExpressoRet.getNuDvGar()));
        parametrosBean.setIcLancamento(cedenteExpressoRet.getIcLncContabil());
        parametrosBean.setNuEvento(Long.parseLong(cedenteExpressoRet.getNuEventoContabil()));
        parametrosBean.setIcProposta(cedenteExpressoRet.getIcBolProposta());
        parametrosBean.setIcDebitoTarifa(cedenteExpressoRet.getIcCmdDebito());
        parametrosBean.setIcCEP(cedenteExpressoRet.getIcCriticaCep());
        
       
        parametrosBean.setIcBeneficiario(cedenteExpressoRet.getTpBeneficiario());
        parametrosBean.setNuSITCS(Long.parseLong(cedenteExpressoRet.getCdEntidadeSindical()));
        parametrosBean.setNuEvento(Long.parseLong(cedenteExpressoRet.getNuEventoContabilDebito()));
        parametrosBean.setAutCCA(cedenteExpressoRet.getIcAutorizaPgto());
        parametrosBean.setIcIndiceEspecial(cedenteExpressoRet.getIcCalcIndice());
        parametrosBean.setTpIndice(cedenteExpressoRet.getSgIndiceEspecial());
        parametrosBean.setIcAplIndiceEspecial(cedenteExpressoRet.getIcAplIndiceEspecial());
        
       
        
        
        request.setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN,parametrosBean);
        
        //Guia permissao final
        
    	CedentePermissaoBean permissaoBean = (CedentePermissaoBean) (new CedentePermissaoBean()).newBean();
    	
    	CedenteCabecaBean cabecaBean =  (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        handler = new MainFrameTransactionsSigcbEjb();
       // handler = SigcbEstrategia.lookUpMFHandler();

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
		
	
		usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
		
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
        
		//CedConsultaPermissaoBean retBean = this.desmontaBGMTTeste();
        LogUtilSigcb.debug("Recebeu parametro");
     
        request.setAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN,retBean);
        //request.getSession().setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN, retBean);
        
        
        
        return PAGE_INCLUIR_EXPRESSO_CONFIRMAR;
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
    
    private void formataTarifas(CedenteTarifasBean tarifasBean)
            throws JspException {
        tarifasBean.setDescFormaCalculo(ComboFormaCalculo.getDescricao(tarifasBean.getFormaCalculo()));
    }
    
    private void formataBloquetos(CedenteBloquetosBean bloqBean)
            throws JspException {
        if (bloqBean.getDescEnvioAvisoSacado().equals("")) {
            bloqBean.setAvisoSacado("NAO");
        } else {
            bloqBean.setAvisoSacado("SIM");
        }
        
        if (bloqBean.getImpBloqDDA().equals("N")) {
        	bloqBean.setImpBloqDDA("NAO");
        } else {
        	bloqBean.setImpBloqDDA("SIM");
        }
    }
    
    private void formataGeral(CedenteGeralBean geralBean) throws JspException {
        geralBean.setDescTipoCobranca(ComboTipoCobranca.getDescricao(geralBean.getTipoCobranca()));
        geralBean.setProtestoAutomatico(ComboSimNao.getDescricao(geralBean.getProtestoAutomatico()));
        geralBean.setExtratoMovTit(ComboSimNao.getDescricao(geralBean.getExtratoMovTit()));
        geralBean.setExtratoMovDebtCredt(ComboSimNao.getDescricao(geralBean.getExtratoMovDebtCredt()));
        geralBean.setInventarioMes(ComboSimNao.getDescricao(geralBean.getInventarioMes()));
        geralBean.setRecebimentoCheque(ComboSimNao.getDescricao(geralBean.getRecebimentoCheque()));
        geralBean.setClienteExterno(ComboSimNao.getDescricao(geralBean.getClienteExterno()));
        geralBean.setExclusaoAutomatica(ComboSimNao.getDescricao(geralBean.getExclusaoAutomatica()));
        geralBean.setDescModalidadeTitulo(ComboModalidadeTitulo.getDescricao(geralBean.getModalidadeTitulo()));
        geralBean.setCobrancaSemBloqueto(ComboCobracaSimNao.getDescricao(geralBean.getCobrancaSemBloqueto()));
        geralBean.setDescClienteGiroCaixa(ComboGiroCaixa.getDescricao(geralBean.getClienteGiroCaixa()));
        geralBean.setRetencaoIOF(ComboSimNao.getDescricao(geralBean.getRetencaoIOF()));
        geralBean.setEnvioSMS(ComboSimNao.getDescricao(geralBean.getEnvioSMS()));

    }
    
    private void formataCedenteEletronico(CedenteEletronicoBean eletronBean)
            throws JspException {
        eletronBean.setPadraoArquivoDesc(ComboPadraoArquivo.getDescricao(eletronBean.getPadraoArquivo()));
        eletronBean.setAtribuicaoVanDesc(ComboAtribuicaoVan.getDescricao(eletronBean.getAtribuicaoVan()));
        eletronBean.setJuncaoArquivoRetorno(ComboSimNao.getDescricao(eletronBean.getJuncaoArquivoRetorno()));
        eletronBean.setPerfilRejeicaoDesc(ComboPerfilRejeicao.getDescricao(eletronBean.getPerfilRejeicao()));
        eletronBean.setPreCritica(ComboSimNao.getDescricao(eletronBean.getPreCritica()));
        eletronBean.setCopiaArquivoRetorno(ComboSimNao.getDescricao(eletronBean.getCopiaArquivoRetorno()));
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
    
    public CedConsultaPermissaoBean desmontaBGMTTeste(){
    	
    	CedConsultaPermissaoBean retorno = new CedConsultaPermissaoBean();
    	
    	retorno.setDE_STCO_INTERNA("FIXO");
    	retorno.setDT_STCO_INTERNA("FIXO");
    	retorno.setHH_STCO_INTERNA("FIXO");
    	retorno.setCO_USRO_INTERNA("FIXO");
    	retorno.setDE_HIST_INTERNA(String.format("%-1000s", "FIXO"));
    	retorno.setDE_STCO_CIP(String.format("%-1000s", "FIXO"));
    	retorno.setDT_STCO_CIP("FIXO");
    	retorno.setHH_STCO_CIP("FIXO");
    	retorno.setDE_STCO_FINAL(String.format("%-1000s", "FIXO"));
    	retorno.setDT_STCO_FINAL("FIXO");
    	retorno.setHH_STCO_FINAL("FIXO");
    	retorno.setCO_USRO_FINAL("FIXO");
    	retorno.setDE_HIST_FINAL(String.format("%-1000s", "FIXO"));
    	retorno.setDE_ACAT_CIP(String.format("%-1000s", "FIXO"));
    	retorno.setDT_ACAT_CIP("FIXO");
    	retorno.setHH_ACAT_CIP("FIXO");
    	retorno.setCO_USRO_CIP("FIXO");
    	retorno.setDE_HIST_CIP(String.format("%-1000s", "FIXO"));
    	
    	
    	return retorno;
    	
    }

}
