package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Cristian Souza - Probank/REDEASP02
 */

public abstract class ProtestEstrategia extends SigcbEstrategia {

    // constantes padrões da funcionalidades
    public static final String STRATEGY_MANTER_INICIAR = "servico.ProtestAcaoIniciar";
    
    public static final String STRATEGY_MANTER_SUSTA_GER_ARQUIVO_INICIAR = "servico.ProtestSustaGeracaoArquivoIniciar";
    
    public static final String STRATEGY_MANTER_ENVIO_AO_CARTORIO_INICIAR = "servico.ProtestEnvioAoCartorioIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.ProtestAcaoFiltro";
    
    public static final String STRATEGY_MANTER_SUSTA_GER_ARQUIVO_FILTRO = "servico.ProtestSustaGeracaoArquivoAcaoFiltro";
    
    public static final String STRATEGY_ENVIO_AO_CARTORIO_FILTRO = "servico.ProtestEnvioAoCartorioAcaoFiltro"; 
    
    public static final String STRATEGY_CONSULTAR_INICIAR = "servico.ProtestConsultarIniciar";

    public static final String STRATEGY_ACAO = "servico.ProtestAcaoFinalizar";
    
    public static final String STRATEGY_ACAO_SUSTA_GER_ARQUIVO = "servico.ProtestSustaGeracaoArquivoAcaoFinalizar";
    
    public static final String STRATEGY_ACAO_ENVIO_AO_CARTORIO_INCLUIR = "servico.ProtestEnvioAoCartorioIncluirAcaoFinalizar";
    
    public static final String STRATEGY_ACAO_ENVIO_AO_CARTORIO_ALTERAR = "servico.ProtestEnvioAoCartorioAlterarAcaoFinalizar";

    public static final String STRATEGY_IMPRIME_PROTESTO = "servico.BcoTituAcaoImpOrdemProtFinalizar";

    //  Título de página Comandos por Título
    public static final String PAGE_TITLE = "Protesto";
    
    public static final String PAGE_TITLE_CONSULTAR_LISTAR = "Protesto >> Listar";
    
    public static final String PAGE_ENVIO_AO_CARTORIO_INICIAR_TITLE = "Protesto >> Envio Ao Cartório >> Filtro";
    
    //  Título de página SUSTA - Geração de Arquivo
    public static final String PAGE_SUSTA_GER_ARQUIVO_INICIAR_TITLE = "Protesto >> SUSTA - Geração de Arquivo >> Filtro";
    

    public static final String PAGE_TITLE_ACAO = "Protesto >> Ação";
    
    public static final String PAGE_TITLE_ACAO_SUSTA_GER_ARQUIVO = "Protesto >> SUSTA - Geração de Arquivo >> Ação";
    
    public static final String PAGE_TITLE_ACAO_PROTESTO_ENVIO_AO_CARTORIO = "Protesto >> Envio ao Cartório >> Ação";
    
    // jsps para forward
    public static final String PAGE_FILTRO_MANTER = "servico/protest_acao_filtro";
    
    public static final String PAGE_SUSTA_GER_ARQUIVO_FILTRO_MANTER = "servico/protest_acao_susta_ger_arquivo_filtro";
    
    public static final String PAGE_ENVIO_AO_CARTORIO_FILTRO_MANTER = "servico/protest_acao_envio_ao_cartorio_filtro";

    public static final String PAGE_FILTRO_ACAO = "servico/protest_acao";
    
    public static final String PAGE_SUSTA_GER_ARQUIVO_FILTRO_ACAO = "servico/protest_acao_susta_ger_arquivo";
    
    public static final String PAGE_SUSTA_ENVIO_AO_CARTORIO_ACAO = "servico/protest_acao_envio_ao_cartorio";

    public static final String PAGE_SUCESSO = "servico/protest_sucesso";
    
    public static final String PAGE_ENVIO_AO_CARTORIO_INCLUIR_SUCESSO = "servico/protest_consultar_envio_incluir_sucesso";

    public static final String PAGE_ERRO = "servico/protest_erro";

    public static final String PAGE_IMPRESSAO_PROTESTO = "servico/bcotitu_acao_impordemprot";
    
    public static final String PAGE_CONSULTAR = "consulta/protest_consultar_envio";
    
    public static final String PAGE_CONSULTAR_SUSTA = "consulta/protest_consultar_susta";
    
    public static final String PAGE_CONSULTAR_INCLUIR = "consulta/protest_consultar_envio_incluir";
    
    // beans
    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabecaBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "bcoTitBean";
    
    public static final String PROTESTO_TITULO_DATA_BEAN = "protestoTituloBean";
    
    public static final String PROTESTO_TITULO_FILTRO_BEAN = "protestoTituloFiltroBean";

    public static final String DATA_FIXO_LIST = "bcoTitListFixo";

    public static final String DATA_MSG_BLQ_LIST = "bcoTitListMsgBlq";

    // acoes de sucesso
    public static final String SUCESSO_ACAO = " Realizada com sucesso";

    // transacoes
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_DADOS_PRINCIPAIS = "BG60";

    public static final String TRANSACAO_DADOS_COMPLEMENTARES = "BG65";

    public static final String TRANSACAO_DADOS_LIQUIDACAO = "BG61";

    public static final String TRANSACAO_DADOS_ENCARGOS_ABATIMENTOS = "BG66";

    public static final String TRANSACAO_ACOES_PROTESTO_OUTROS = "BG62";

    public static final String TRANSACAO_IMPRESSAO_BLOQUETO = "BG64";
    
    public static final String TRANSACAO_PROTESTO_SUSTA_INCLUIR = "BGSE";
    
    public static final String TRANSACAO_PROTESTO_ENVIO_CARTORIO_INCLUIR = "BGSB";
    
    public static final String TRANSACAO_PROTESTO_CONSULTAR_TITULOS = "BGSC";
    
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";
    
    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

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

                // Verifica se a informacao do cabecalho do cedente esta
                // realmente no ambiente
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
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
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

    // Acessa o Mainframe para obter dados "Guia Dados Principais BG60"
    protected TituloBean getTituloDadosPrincipais(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Faz o tratamento para evitar que não seja carregado o cabecalho.
        try {
            // Chama o mainframe
        	  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
              String transUser = TRANSACAO_DADOS_PRINCIPAIS + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BG60 */BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,
            		transUser);
            TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);
            String parcela = newTituloBean.getParcela();
            // Reseta informacoes do titulo
            copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
            // copyTituloDadosPrincipaisToTitulo(tituloBean, newTituloBean);
            copyTituloDadosComplementaresToTitulo(tituloBean, newTituloBean);
            copyTituloDadosEncargosAbatimentosToTitulo(tituloBean,
                    newTituloBean);
            newTituloBean.setParcela(parcela);
            return newTituloBean;
        } catch (Exception e) {
            BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

            throw e;
        }
    }

    // Acessa o Mainframe para obter dados "Guia Dados Principais BG65"
    protected TituloBean getTituloDadosComplementares(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        

        // Chama o mainframe
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_DADOS_COMPLEMENTARES + usuarioBean.getCodigoUsuario().toUpperCase();
        tituloBean.setMeioEntrada(1L);
        BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,	transUser);
        TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);

        // Reseta informacoes do titulo
        copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
        copyTituloDadosPrincipaisToTitulo(tituloBean, newTituloBean);
        //copyTituloDadosComplementaresToTitulo(tituloBean, newTituloBean);
        copyTituloDadosEncargosAbatimentosToTitulo(tituloBean, newTituloBean);

        return newTituloBean;
    }

    // Acessa o Mainframe para obter dados "Guia Dados Encargos Abatimentos
    // BG66"
    protected TituloBean getTituloDadosEncargosAbatimentos(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Chama o mainframe
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_DADOS_ENCARGOS_ABATIMENTOS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,
        		transUser);
        TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);

        // Reseta informacoes do titulo
        copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
        copyTituloDadosPrincipaisToTitulo(tituloBean, newTituloBean);
        copyTituloDadosComplementaresToTitulo(tituloBean, newTituloBean);
        // copyTituloDadosEncargosAbatimentosToTitulo(tituloBean,
        // newTituloBean);

        return newTituloBean;
    }

    protected void copyTituloDadosFiltroToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        // filtro
        tituloTo.setCodigoCedente(tituloFrom.getCodigoCedente());
        tituloTo.setNossoNumero(tituloFrom.getNossoNumero());
        tituloTo.setSituacao(tituloFrom.getSituacao());
        tituloTo.setClassificacao(tituloFrom.getClassificacao());
        tituloTo.setMeioEntrada(tituloFrom.getMeioEntrada());
        // Controle
        tituloTo.setFiltroSelecao(tituloFrom.getFiltroSelecao());
        tituloTo.setFiltroDescricaoSituacao(tituloFrom.getFiltroDescricaoSituacao());
        tituloTo.setFiltroDescricaoClassificacao(tituloFrom.getFiltroDescricaoClassificacao());
        tituloTo.setFiltroVoltarListarConsolidado(tituloFrom.getFiltroVoltarListarConsolidado());
        tituloTo.setFiltroVoltarListarTitulo(tituloFrom.getFiltroVoltarListarTitulo());
        tituloTo.setFiltroVoltarAcao(tituloFrom.getFiltroVoltarAcao());
        // acoes
        tituloTo.setAcoesValorRecebido(tituloFrom.getAcoesValorRecebido());
        tituloTo.setAcoesDespesasCartorarias(tituloFrom.getAcoesDespesasCartorarias());
        tituloTo.setNumeroCartorio(tituloFrom.getNumeroCartorio());
        tituloTo.setCodigoProtocolo(tituloFrom.getCodigoProtocolo());
        tituloTo.setDataProtocolo(tituloFrom.getDataProtocolo());
        tituloTo.setAcoesServicoTitulo(tituloFrom.getAcoesServicoTitulo());
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
        // EAM - 22/04
        tituloTo.setOrdProtDataMovimento(tituloFrom.getOrdProtDataMovimento());
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

}
