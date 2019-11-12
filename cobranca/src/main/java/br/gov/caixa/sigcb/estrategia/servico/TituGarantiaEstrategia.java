package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.bean.TituloListarBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>25/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public abstract class TituGarantiaEstrategia extends SigcbEstrategia {

    // constantes padrões da funcionalidades
    

	
	public static final String STRATEGY_MANTER_INICIAR = "servico.TituGarantiaManterIniciar";
	
    public static final String STRATEGY_MANTER_FILTRO = "servico.TituGarantiaManterFiltro";
    
    public static final String STRATEGY_MANTER_LISTAR = "servico.TituGarantiaManterFiltro";
    
    public static final String STRATEGY_MANTER_FINALIZAR = "servico.TituGarantiaManterFinalizar";

    public static final String STRATEGY_ACAO = "servico.BcoTituAcaoFinalizar";

    
    // titulos de pagina
    public static final String PAGE_TITLE = "Títulos Garantia de Crédito";

    public static final String PAGE_TITLE_FILTRO = "Títulos Garantia de Crédito >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "Títulos Garantia de Crédito >> Marca/Desmarca";

    

    // jsps para forward
    public static final String PAGE_FILTRO_MANTER = "servico/garantia_manter_filtro";

    public static final String PAGE_FILTRO_LISTAR_TITULO = "servico/garantia_manter_listar_titulo";

    public static final String PAGE_ERRO = "servico/tituGarantia_erro";

    // transacoes
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_LISTAR_TITULO = "BGMN";

    public static final String TRANSACAO_CONFIRMAR = "BGMO";

    public static final String TRANSACAO_CEDENTE_GERAL = "BG03";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabecaBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "bcoTitBean";

    public static final String DATA_FIXO_LIST = "bcoTitListFixo";

    public static final String DATA_MSG_BLQ_LIST = "bcoTitListMsgBlq";

    // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho da lista
    // de títulos
    public static final String CEDENTE_GERAL_BEAN = "cedGeralBeanBcoTitu";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

    /*
     * Este metodo retorna o cabeçalho do cedente conforme a solicitação do
     * filtro.
     */
    protected static void setCedenteCabecaBean(TituloBean tituloBean,
            HttpServletRequest request) throws Exception {

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        // Testa necessidade de acessar mainframe para obter cabecalho do
        // cedente

        // Existe informacao do ultimo cedente
        if (request.getSession().getAttribute(SigcbEstrategia.CEDENTE_ATUAL) != null) {

            // Obtem ultimo cedente e verifica se eh igual ao "novo" cedente
            // obtido do titulo
            Long cedente = (Long) request.getSession()
                    .getAttribute(SigcbEstrategia.CEDENTE_ATUAL);
            if (cedente.equals(tituloBean.getCodigoCedente())) {

                // Verifica se a informacao do cabecalho do cedente ja existe
                cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                        CEDENTE_CABECALHO_BEAN);
                if (cedCabBean != null)
                    if (cedCabBean.getCodigoCedente() != null)
                        if (!cedCabBean.getCodigoCedente().equals(new Long(0)))
                            return;
            }
        }

        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Guarda informacoes de cabecalho antes da chamada ao mainframe
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Chamada ao Mainframe para cabecalho cedente
        //MainFrameTransactionsSigcb handler = TituGarantiaEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);

        // Reseta informacoes perdidas na chamada ao mainframe
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        cedCabBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Guarda informacoes de cabecalho depois da chamada ao mainframe
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(SigcbEstrategia.CEDENTE_ATUAL,
                tituloBean.getCodigoCedente());
    }



   
   

    // Acessa o Mainframe para obter dados "Lista titulos consolidado BG58"
    protected List getTituloListarTitulo(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

    	// Instancia o EJB que acessa o mainframe
    	
    	tituloBean = (TituloBean) tituloBean.getRequestBean(request);
    	
        //MainFrameTransactionsSigcb handler = TituGarantiaEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Prepara o bean para subida de informacao ao mainframe
        TituloListarBean tituloFixoBean = new TituloListarBean();
        tituloFixoBean = (TituloListarBean) tituloFixoBean.newBean();
        tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());
        tituloFixoBean.setClassificacao(tituloBean.getClassificacao());
        tituloFixoBean.setNossoNumero(tituloBean.getNossoNumero());
        tituloFixoBean.setNossoNumeroFim(tituloBean.getNossoNumeroFim());
        
        
        
        // página que será mostrada, começa com 1
        int paginaAtual;
        try {
        	// ou se já tiver selecionado na tela pega a página do request
            paginaAtual = Integer.parseInt(request.getParameter("pagina"));
        } catch (Exception e) {
        	paginaAtual = 1;
        }
        // coloca no bean passado como argumento também
        tituloBean.setPagina(Long.valueOf(paginaAtual));
        tituloFixoBean.setPagina(Long.valueOf(paginaAtual));

        try {
            // Chama o Mainframe
        	  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
              String transUser = TRANSACAO_LISTAR_TITULO + usuarioBean.getCodigoUsuario().toUpperCase();
            List tituloList = (List) handler.executeFixDataRecordsetTransaction(tituloFixoBean,transUser);

            // Obtem Parte Fixa
            tituloFixoBean = (TituloListarBean) ((BeanList) tituloList.get(0)).get(0);
            tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());
            tituloFixoBean.setSituacao(tituloBean.getSituacao());
            tituloFixoBean.setClassificacao(tituloBean.getClassificacao());
            tituloFixoBean.setPagina(tituloBean.getPagina());
            tituloFixoBean.setNossoNumero(tituloBean.getNossoNumero());
            tituloFixoBean.setNossoNumeroFim(tituloBean.getNossoNumeroFim());

            // Obtem Parte Variavel (recordset)
            ArrayList tituloArrayList = convertDataStructure(((BeanList) tituloList.get(1)).iterator());

            List tituloRetornoList = new ArrayList();
            tituloRetornoList.add(tituloFixoBean);
            tituloRetornoList.add(tituloArrayList);

            // for(int i = 0 ; i < tituloArrayList.size() ; i++){
            // LogUtilSigcb.debug("==== Titulo " + i + " : Classe -> " +
            // tituloArrayList.get(i).getClass() + " " +
            // tituloArrayList.get(i));
            // }
           
            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(tituloList));
            request.setAttribute(PAGINACAO_PAGE, paginaAtual);

            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(tituloFixoBean.getTotalRegistro() / 20.0));
           
            
            return tituloRetornoList;
            
        } catch (Exception e) {
            setCedenteCabecaBean(tituloBean, request);

            throw e;
        }
    }

    
    protected void copyTituloDadosFiltroToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        // filtro
        tituloTo.setCodigoCedente(tituloFrom.getCodigoCedente());
        tituloTo.setNossoNumero(tituloFrom.getNossoNumero());
        tituloTo.setSituacao(tituloFrom.getSituacao());
        tituloTo.setClassificacao(tituloFrom.getClassificacao());
        tituloTo.setMeioEntrada(tituloFrom.getMeioEntrada());
        //tituloTo.setPagina(tituloFrom.getPagina());
        // Controle
        tituloTo.setFiltroSelecao(tituloFrom.getFiltroSelecao());
        tituloTo.setFiltroDescricaoSituacao(tituloFrom.getFiltroDescricaoSituacao());
        tituloTo.setFiltroDescricaoClassificacao(tituloFrom.getFiltroDescricaoClassificacao());
        tituloTo.setFiltroVoltarListarConsolidado(tituloFrom.getFiltroVoltarListarConsolidado());
        tituloTo.setFiltroVoltarListarTitulo(tituloFrom.getFiltroVoltarListarTitulo());
        tituloTo.setFiltroVoltarAcao(tituloFrom.getFiltroVoltarAcao());
        // acoes
        tituloTo.setAcoesServicoTitulo(tituloFrom.getAcoesServicoTitulo());
        tituloTo.setAcoesDespesasCartorarias(tituloFrom.getAcoesDespesasCartorarias());
        tituloTo.setAcoesValorRecebido(tituloFrom.getAcoesValorRecebido());
        tituloTo.setAcoesHistorico(tituloFrom.getAcoesHistorico());
        // outros
        tituloTo.setCodigoUsuario(tituloFrom.getCodigoUsuario());
        tituloTo.setComunicacaoSacado(tituloFrom.getComunicacaoSacado());
        tituloTo.setCobrarTarifa(tituloFrom.getCobrarTarifa());

        //Grupo Acesso
        tituloTo.setNomeGrupo(tituloFrom.getNomeGrupo());

    }

    private void copyTituloDadosPrincipaisToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        tituloTo.setPrinciMeioEntrada(tituloFrom.getPrinciMeioEntrada());
        tituloTo.setPrinciValorTitulo(tituloFrom.getPrinciValorTitulo());
        tituloTo.setPrinciSituacao(tituloFrom.getPrinciSituacao());
        tituloTo.setPrinciDescricaoSituacao(tituloFrom.getPrinciDescricaoSituacao());
        tituloTo.setPrinciNumeroDocumento(tituloFrom.getPrinciNumeroDocumento());
        tituloTo.setPrinciDataVencimento(tituloFrom.getPrinciDataVencimento());
        tituloTo.setPrinciMoeda(tituloFrom.getPrinciMoeda());
        tituloTo.setPrinciAceite(tituloFrom.getPrinciAceite());
        tituloTo.setPrinciDescricaoAceite(tituloFrom.getPrinciDescricaoAceite());
        tituloTo.setPrinciIndicadorProt(tituloFrom.getPrinciIndicadorProt());
        tituloTo.setPrinciPrazoProtDev(tituloFrom.getPrinciPrazoProtDev());
        tituloTo.setPrinciEndosso(tituloFrom.getPrinciEndosso());
        tituloTo.setPrinciSiglaEspecie(tituloFrom.getPrinciSiglaEspecie());
        tituloTo.setPrinciEspecie(tituloFrom.getPrinciEspecie());
        tituloTo.setPrinciDescricaoEspecie(tituloFrom.getPrinciDescricaoEspecie());
        tituloTo.setPrinciSacadoNome(tituloFrom.getPrinciSacadoNome());
        tituloTo.setPrinciSacadoTipoPessoa(tituloFrom.getPrinciSacadoTipoPessoa());
        tituloTo.setPrinciSacadoCpfCnpj(tituloFrom.getPrinciSacadoCpfCnpj());
        tituloTo.setPrinciSacadoCep(tituloFrom.getPrinciSacadoCep());
        tituloTo.setPrinciSacadoUf(tituloFrom.getPrinciSacadoUf());
        tituloTo.setPrinciSacadoLogradouro(tituloFrom.getPrinciSacadoLogradouro());
        tituloTo.setPrinciSacadoNumero(tituloFrom.getPrinciSacadoNumero());
        tituloTo.setPrinciSacadoComplemento(tituloFrom.getPrinciSacadoComplemento());
        tituloTo.setPrinciSacadoBairro(tituloFrom.getPrinciSacadoBairro());
        tituloTo.setPrinciSacadoMunicipio(tituloFrom.getPrinciSacadoMunicipio());
        tituloTo.setPrinciSacadoEmail(tituloFrom.getPrinciSacadoEmail());
        tituloTo.setPrinciPvCobrador(tituloFrom.getPrinciPvCobrador());
        tituloTo.setPrinciSacadoNumero(tituloFrom.getPrinciSacadoNumero());
        tituloTo.setPrinciDescricaoPvCobrador(tituloFrom.getPrinciDescricaoPvCobrador());
        tituloTo.setPrinciDataDocumento(tituloFrom.getPrinciDataDocumento());
        tituloTo.setPrinciPvVinculacao(tituloFrom.getPrinciPvVinculacao());
        tituloTo.setPrinciModalidade(tituloFrom.getPrinciModalidade());
        tituloTo.setOrdProtDataMovimento(tituloFrom.getOrdProtDataMovimento());

        tituloTo.setEmissaoBloqueto(tituloFrom.getEmissaoBloqueto());
        tituloTo.setEnvioBloqueto(tituloFrom.getEnvioBloqueto());
         
        tituloTo.setSituacaoBloqSE(tituloFrom.getSituacaoBloqSE());
        tituloTo.setNumIdDDA(tituloFrom.getNumIdDDA());
        tituloTo.setAceiteSE(tituloFrom.getAceiteSE());
        tituloTo.setAlegacaoSE(tituloFrom.getAlegacaoSE());
        
        tituloTo.setCelularSMS(tituloFrom.getCelularSMS());
        tituloTo.setDddSMS(tituloFrom.getDddSMS());
        tituloTo.setTipoSMS(tituloFrom.getTipoSMS());
        tituloTo.setDescrEntrega(tituloFrom.getDescrEntrega());
        
        LogUtilSigcb.debug(">>>>>>>>>>>>>>>>>   Tipo CALC:" + tituloFrom.getTipoCalculo() + " autorizaca:" + tituloFrom.getAutorizacao() );
        
        tituloTo.setAutorizacao(tituloFrom.getAutorizacao());
        tituloTo.setTipoCalculo(tituloFrom.getTipoCalculo());
        tituloTo.setIcRateio(tituloFrom.getIcRateio());
        
       
    }

    private void copyTituloDadosLiquidacaoToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        tituloTo.setLiquiDataLiquidacao(tituloFrom.getLiquiDataLiquidacao());
        tituloTo.setLiquiCanalLiquidacao(tituloFrom.getLiquiCanalLiquidacao());
        tituloTo.setLiquiDataPagamento(tituloFrom.getLiquiDataPagamento());
        tituloTo.setLiquiDiasFloat(tituloFrom.getLiquiDiasFloat());
        tituloTo.setLiquiDataCredito(tituloFrom.getLiquiDataCredito());
        tituloTo.setLiquiValorDocumento(tituloFrom.getLiquiValorDocumento());
        tituloTo.setLiquiValorJurosMulta(tituloFrom.getLiquiValorJurosMulta());
        tituloTo.setLiquiValorDesconto(tituloFrom.getLiquiValorDesconto());
        tituloTo.setLiquiAbatimento(tituloFrom.getLiquiAbatimento());
        tituloTo.setLiquiValorLiquidoRecebido(tituloFrom.getLiquiValorLiquidoRecebido());
    }

    private void copyTituloDadosComplementaresToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        tituloTo.setCompleTipoJurosMes(tituloFrom.getCompleTipoJurosMes());
        tituloTo.setComplePercenJurosMes(tituloFrom.getComplePercenJurosMes());
        tituloTo.setCompleAbatimento(tituloFrom.getCompleAbatimento());
        tituloTo.setCompleSacadorNome(tituloFrom.getCompleSacadorNome());
        tituloTo.setCompleSacadorTipoPessoa(tituloFrom.getCompleSacadorTipoPessoa());
        tituloTo.setCompleSacadorCpfCnpj(tituloFrom.getCompleSacadorCpfCnpj());
        tituloTo.setCompleDescontoUmPercen(tituloFrom.getCompleDescontoUmPercen());
        tituloTo.setCompleDescontoUmValor(tituloFrom.getCompleDescontoUmValor());
        tituloTo.setCompleDescontoUmPrazo(tituloFrom.getCompleDescontoUmPrazo());
        tituloTo.setCompleDescontoUmData(tituloFrom.getCompleDescontoUmData());
        tituloTo.setCompleDescontoDoisPercen(tituloFrom.getCompleDescontoDoisPercen());
        tituloTo.setCompleDescontoDoisValor(tituloFrom.getCompleDescontoDoisValor());
        tituloTo.setCompleDescontoDoisPrazo(tituloFrom.getCompleDescontoDoisPrazo());
        tituloTo.setCompleDescontoDoisData(tituloFrom.getCompleDescontoDoisData());
        tituloTo.setCompleDescontoTresPercen(tituloFrom.getCompleDescontoTresPercen());
        tituloTo.setCompleDescontoTresValor(tituloFrom.getCompleDescontoTresValor());
        tituloTo.setCompleDescontoTresPrazo(tituloFrom.getCompleDescontoTresPrazo());
        tituloTo.setCompleDescontoTresData(tituloFrom.getCompleDescontoTresData());
        tituloTo.setCompleMultaPercen(tituloFrom.getCompleMultaPercen());
        tituloTo.setCompleMultaValor(tituloFrom.getCompleMultaValor());
        tituloTo.setCompleMultaPrazo(tituloFrom.getCompleMultaPrazo());
        tituloTo.setCompleMultaData(tituloFrom.getCompleMultaData());
        tituloTo.setCompleRetidoValorIOF(tituloFrom.getCompleRetidoValorIOF());
    }

    private void copyTituloDadosEncargosAbatimentosToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        tituloTo.setAbatiDataEmissao(tituloFrom.getAbatiDataEmissao());
        tituloTo.setAbatiDataEntrada(tituloFrom.getAbatiDataEntrada());
        tituloTo.setAbatiDataPrevisaoProtDev(tituloFrom.getAbatiDataPrevisaoProtDev());
        tituloTo.setAbatiModalidade(tituloFrom.getAbatiModalidade());
        tituloTo.setAbatiAbatimento(tituloFrom.getAbatiAbatimento());
        tituloTo.setAbatiCustasCartorarias(tituloFrom.getAbatiCustasCartorarias());
        tituloTo.setAbatiJurosPercen(tituloFrom.getAbatiJurosPercen());
        tituloTo.setAbatiJurosData(tituloFrom.getAbatiJurosData());
        tituloTo.setAbatiJurosValor(tituloFrom.getAbatiJurosValor());
        tituloTo.setAbatiMultaPercen(tituloFrom.getAbatiMultaPercen());
        tituloTo.setAbatiMultaValor(tituloFrom.getAbatiMultaValor());
        tituloTo.setAbatiMultaPrazo(tituloFrom.getAbatiMultaPrazo());
        tituloTo.setAbatiMultaData(tituloFrom.getAbatiMultaData());
        tituloTo.setAbatiDescontoDoisPercen(tituloFrom.getAbatiDescontoDoisPercen());
        tituloTo.setAbatiDescontoDoisValor(tituloFrom.getAbatiDescontoDoisValor());
        tituloTo.setAbatiDescontoDoisPrazo(tituloFrom.getAbatiDescontoDoisPrazo());
        tituloTo.setAbatiDescontoDoisData(tituloFrom.getAbatiDescontoDoisData());
        tituloTo.setAbatiDescontoTresPercen(tituloFrom.getAbatiDescontoTresPercen());
        tituloTo.setAbatiDescontoTresData(tituloFrom.getAbatiDescontoTresData());
        tituloTo.setAbatiDescontoTresPrazo(tituloFrom.getAbatiDescontoTresPrazo());
        tituloTo.setAbatiDescontoTresValor(tituloFrom.getAbatiDescontoTresValor());
        tituloTo.setAbatiDescontoUmPercen(tituloFrom.getAbatiDescontoUmPercen());
        tituloTo.setAbatiDescontoUmValor(tituloFrom.getAbatiDescontoUmValor());
        tituloTo.setAbatiDescontoUmPrazo(tituloFrom.getAbatiDescontoUmPrazo());
        tituloTo.setAbatiDescontoUmData(tituloFrom.getAbatiDescontoUmData());
        tituloTo.setAbatiRetidoValorIOF(tituloFrom.getAbatiRetidoValorIOF());
    }

    private void copyTituloDadosImpressaoBloquetoToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        tituloTo.setBloqCodigoBarrasFormatado(tituloFrom.getBloqCodigoBarrasFormatado());
        tituloTo.setBloqCodigoBarrasNumerico(tituloFrom.getBloqCodigoBarrasNumerico());
        tituloTo.setBloqDigitoCtrlNossoNumero(tituloFrom.getBloqDigitoCtrlNossoNumero());
    }
}
