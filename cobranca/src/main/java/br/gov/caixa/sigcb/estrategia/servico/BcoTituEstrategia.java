package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Money;
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

public abstract class BcoTituEstrategia extends SigcbEstrategia {

    // constantes padrões da funcionalidades
    public static final String STRATEGY_MANTER_INICIAR = "servico.BcoTituManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.BcoTituManterFiltro";

    public static final String STRATEGY_ACAO = "servico.BcoTituAcaoFinalizar";

    public static final String STRATEGY_CONSULTAR = "servico.BcoTituConsultarIniciar";

    public static final String STRATEGY_ALTERAR = "servico.BcoTituAlterarIniciar";
    
    public static final String STRATEGY_ALTERAR_VALOR = "servico.BcoTituAlteraValorIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.BcoTituAlterarFinalizar";
    
    public static final String STRATEGY_ALTERAR_VALOR_FINALIZAR = "servico.BcoTituAlterarValorFinalizar";

    // titulos de pagina
    public static final String PAGE_TITLE = "Banco de Titulos";

    public static final String PAGE_TITLE_FILTRO = "Banco de Titulos >> Filtro";

    public static final String PAGE_TITLE_ALTERAR = "Banco de Titulos >> Alterar";

    public static final String PAGE_TITLE_ACAO = "Banco de Titulos >> Ações";

    public static final String PAGE_TITLE_CONSULTAR = "Banco de Titulos >> Consultar";

    public static final String PAGE_TITLE_LISTAR = "Banco de Titulos >> Listar";

    public static final String PAGE_TITLE_CONSOLIDADO = "Banco de Titulos >> Consolidado";

    // jsps para forward
    public static final String PAGE_FILTRO_MANTER = "servico/bcotitu_manter_filtro";

    public static final String PAGE_FILTRO_ACAO = "servico/bcotitu_acao";

    public static final String PAGE_FILTRO_LISTAR_CONSOLIDADO = "servico/bcotitu_manter_listar_consol";

    public static final String PAGE_FILTRO_LISTAR_TITULO = "servico/bcotitu_manter_listar_titulo";

    public static final String PAGE_CONSULTAR = "servico/bcotitu_consultar";
    
    public static final String PAGE_ALTERAR_VALOR = "servico/bcotitu_alterar_valor";

    public static final String PAGE_ALTERAR = "servico/bcotitu_alterar";
    
    public static final String PAGE_DOWNLOAD = "servico/bcotitu_download";    

    public static final String PAGE_SUCESSO = "servico/bcotitu_sucesso";

    public static final String PAGE_ERRO = "servico/bcotitu_erro";

    public static final String PAGE_IMPRESSAO_BLOQUETO = "servico/bcotitu_acao_impbloqueto";

    public static final String PAGE_IMPRESSAO_PROTESTO = "servico/bcotitu_acao_impordemprot";

    // acoes de sucesso
    public static final String SUCESSO_ACAO = " Realizada com sucesso";

    public static final String SUCESSO_ALTERAR = "Alteração Realizada com sucesso";

    // transacoes
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_LISTAR_TITULO = "BG58";

    public static final String TRANSACAO_LISTAR_CONSOLIDADO = "BG59";

    public static final String TRANSACAO_DADOS_PRINCIPAIS = "BG60";

    public static final String TRANSACAO_DADOS_COMPLEMENTARES = "BG65";

    public static final String TRANSACAO_DADOS_LIQUIDACAO = "BG61";

    public static final String TRANSACAO_DADOS_ENCARGOS_ABATIMENTOS = "BG66";

    public static final String TRANSACAO_ALTERAR = "BG63";

    public static final String TRANSACAO_ACOES_PROTESTO_OUTROS = "BG62";

    public static final String TRANSACAO_IMPRESSAO_BLOQUETO = "BG64";
    
    public static final String TRANSACAO_SALVA_IMPRESSAO_BLOQUETO = "BGNJ";

    // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho da lista
    // de títulos
    public static final String TRANSACAO_CEDENTE_GERAL = "BG03";

    // beans
    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabecaBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "bcoTitBean";
    
    public static final String FILTRO_BEAN = "tituloFiltroBean";

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
        
        if (tituloBean.getCmbCarteira()==null){
        	tituloBean.setCmbCarteira("");
        }
        
        if (tituloBean.getCmbEmissao()==null){
        	tituloBean.setCmbEmissao("");
        }
        
        if (tituloBean.getNuBaixa()==null){
        	tituloBean.setNuBaixa(0L);
        }
        if (tituloBean.getNuRefereciaCIP()==null){
        	tituloBean.setNuRefereciaCIP(0L);
        }
        if (tituloBean.getNuIdentificaCIP()==null){
        	tituloBean.setNuIdentificaCIP(0L);
        }

        try {
            // Chama o mainframe
        	  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
              String transUser = TRANSACAO_DADOS_PRINCIPAIS + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BG60 */BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean, transUser);
            TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);
            
            String dt = newTituloBean.getDtGarantia();
            String coUser = newTituloBean.getCoUsuario();
            String icGar = newTituloBean.getIcGarantia();
            String parcela = newTituloBean.getParcela();
            Long NN = newTituloBean.getNossoNumero();
            
            String icRegistroCIP  = newTituloBean.getIcRegistroCIP();
            Long nuIdentificaCIP = newTituloBean.getNuIdentificaCIP();
            Long nuRefereciaCIP= newTituloBean.getNuRefereciaCIP();
            String sgIndexador= newTituloBean.getSgIndexador();
            String icTipoPagamento= newTituloBean.getIcTipoPagamento();
            Money vrMaximoPgto= newTituloBean.getVrMaximoPgto();
            Money vrMinPgto= newTituloBean.getVrMinPgto();
            String icAutPagto= newTituloBean.getIcAutPagto();
            Long qtPgtoPossivel= newTituloBean.getQtPgtoPossivel();
            Long qtPgtoEfetuado= newTituloBean.getQtPgtoEfetuado();
			Money vrSaldoTitulo= newTituloBean.getVrSaldoTitulo();
			String coErroCIP = newTituloBean.getCoErroCIP();
			String dtCompetencia = newTituloBean.getDtCompetencia();
			String tpPessoaPrt = newTituloBean.getTpPessoaPrt();
		    String cpfCnpjPrt = newTituloBean.getCpfCnpjPrt();

            // Reseta informacoes do titulo
            copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
            copyTituloDadosComplementaresToTitulo(tituloBean, newTituloBean);
            copyTituloDadosLiquidacaoToTitulo(tituloBean, newTituloBean);
            copyTituloDadosEncargosAbatimentosToTitulo(tituloBean,newTituloBean);
            copyTituloDadosImpressaoBloquetoToTitulo(tituloBean, newTituloBean);
            newTituloBean.setDtGarantia(dt);
            newTituloBean.setCoUsuario(coUser);
            if (icGar.equals("S")){
            	icGar="SIM";
            }else{
            	icGar="NÃO";
            }
            newTituloBean.setIcGarantia(icGar);
            newTituloBean.setParcela(parcela);
            
            newTituloBean.setIcRegistroCIP(icRegistroCIP);
            newTituloBean.setNuIdentificaCIP(nuIdentificaCIP);
            newTituloBean.setNuRefereciaCIP(nuRefereciaCIP);
            newTituloBean.setSgIndexador(sgIndexador);
            newTituloBean.setIcTipoPagamento(icTipoPagamento);
            newTituloBean.setVrMaximoPgto(vrMaximoPgto);
            newTituloBean.setVrMinPgto(vrMinPgto);
            newTituloBean.setIcAutPagto(icAutPagto);
            newTituloBean.setQtPgtoPossivel(qtPgtoPossivel);
            newTituloBean.setQtPgtoEfetuado(qtPgtoEfetuado);
			newTituloBean.setVrSaldoTitulo(vrSaldoTitulo);
			newTituloBean.setNossoNumero(NN);
			newTituloBean.setCoErroCIP(coErroCIP);
			newTituloBean.setDtCompetencia(dtCompetencia);
			newTituloBean.setTpPessoaPrt(tpPessoaPrt);
			newTituloBean.setCpfCnpjPrt(cpfCnpjPrt);
            
            return newTituloBean;
        } catch (Exception e) {
            setCedenteCabecaBean(tituloBean, request);

            throw e;
        }
    }

    // Acessa o Mainframe para obter dados "Guia Dados Complementares BG65"
    protected TituloBean getTituloDadosComplementares(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        try {

            // Chama o mainframe
        	  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
              String transUser = TRANSACAO_DADOS_COMPLEMENTARES + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BG65 */BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,
            		transUser);
            TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);

            // Reseta informacoes do titulo
            copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
            copyTituloDadosPrincipaisToTitulo(tituloBean, newTituloBean);
            copyTituloDadosLiquidacaoToTitulo(tituloBean, newTituloBean);
            copyTituloDadosEncargosAbatimentosToTitulo(tituloBean, newTituloBean);
            copyTituloDadosImpressaoBloquetoToTitulo(tituloBean, newTituloBean);

            return newTituloBean;
        } catch (Exception e) {
            setCedenteCabecaBean(tituloBean, request);

            throw e;
        }
    }

    // Acessa o Mainframe para obter dados "Guia Dados Liquidacao
    // BG61"
    protected TituloBean getTituloDadosLiquidacao(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        try {
            // Chama o mainframe
        	  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
              String transUser = TRANSACAO_DADOS_LIQUIDACAO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BG61 */BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,  transUser);
            TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);

            // Reseta informacoes do titulo
            copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
            copyTituloDadosPrincipaisToTitulo(tituloBean, newTituloBean);
            copyTituloDadosComplementaresToTitulo(tituloBean, newTituloBean);
            copyTituloDadosEncargosAbatimentosToTitulo(tituloBean, newTituloBean);
            copyTituloDadosImpressaoBloquetoToTitulo(tituloBean, newTituloBean);
            newTituloBean.setIofAtraso(tituloBean.getIofAtraso());
            newTituloBean.setJurosAtraso(tituloBean.getJurosAtraso());

            return newTituloBean;
        } catch (Exception e) {
            setCedenteCabecaBean(tituloBean, request);

            throw e;
        }
    }

    // Acessa o Mainframe para obter dados "Guia Dados Encargos Abatimentos
    // BG66"
    protected TituloBean getTituloDadosEncargosAbatimentos(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        String dt = tituloBean.getDtGarantia();
        String coUser = tituloBean.getCoUsuario();
        String icGar = tituloBean.getIcGarantia();
        
        String icRegistroCIP  = tituloBean.getIcRegistroCIP();
        Long nuIdentificaCIP = tituloBean.getNuIdentificaCIP();
        Long nuRefereciaCIP= tituloBean.getNuRefereciaCIP();
        String sgIndexador= tituloBean.getSgIndexador();
        String icTipoPagamento= tituloBean.getIcTipoPagamento();
        Money vrMaximoPgto= tituloBean.getVrMaximoPgto();
        Money vrMinPgto= tituloBean.getVrMinPgto();
        String icAutPagto= tituloBean.getIcAutPagto();
        Long qtPgtoPossivel= tituloBean.getQtPgtoPossivel();
        Long qtPgtoEfetuado= tituloBean.getQtPgtoEfetuado();
		Money vrSaldoTitulo= tituloBean.getVrSaldoTitulo();
        
        // Chama o mainframe
		  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
          String transUser = TRANSACAO_DADOS_ENCARGOS_ABATIMENTOS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,  transUser);
        TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);

        // Reseta informacoes do titulo
        copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
        copyTituloDadosPrincipaisToTitulo(tituloBean, newTituloBean);
        copyTituloDadosComplementaresToTitulo(tituloBean, newTituloBean);
        copyTituloDadosLiquidacaoToTitulo(tituloBean, newTituloBean);
        copyTituloDadosImpressaoBloquetoToTitulo(tituloBean, newTituloBean);

        
        newTituloBean.setDtGarantia(dt);
        newTituloBean.setCoUsuario(coUser);
        if (icGar.equals("S") || icGar.equals("SIM")){
        	icGar="SIM";
        }else{
        	icGar="NÃO";
        }
        newTituloBean.setIcGarantia(icGar);
        
        newTituloBean.setIcRegistroCIP(icRegistroCIP);
        newTituloBean.setNuIdentificaCIP(nuIdentificaCIP);
        newTituloBean.setNuRefereciaCIP(nuRefereciaCIP);
        newTituloBean.setSgIndexador(sgIndexador);
        newTituloBean.setIcTipoPagamento(icTipoPagamento);
        newTituloBean.setVrMaximoPgto(vrMaximoPgto);
        newTituloBean.setVrMinPgto(vrMinPgto);
        newTituloBean.setIcAutPagto(icAutPagto);
        newTituloBean.setQtPgtoPossivel(qtPgtoPossivel);
        newTituloBean.setQtPgtoEfetuado(qtPgtoEfetuado);
		newTituloBean.setVrSaldoTitulo(vrSaldoTitulo);
        
        
        return newTituloBean;
    }

    // Acessa o Mainframe para obter dados "Guia Dados Impressao do Bloqueto
    // BG64"
    protected List getTituloDadosImpressaoBloqueto(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {
        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Chama o Mainframe
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_IMPRESSAO_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
        List tituloList = (List) handler.executeFixDataRecordsetTransaction(tituloBean,
        		transUser);

        // Obtem Parte Fixa
        TituloBean tituloFixoBean = new TituloBean();
        tituloFixoBean = (TituloBean) ((BeanList) tituloList.get(0)).get(0);

        // Reseta informacoes do titulo
        copyTituloDadosFiltroToTitulo(tituloBean, tituloFixoBean);
        copyTituloDadosPrincipaisToTitulo(tituloBean, tituloFixoBean);
        copyTituloDadosComplementaresToTitulo(tituloBean, tituloFixoBean);
        copyTituloDadosLiquidacaoToTitulo(tituloBean, tituloFixoBean);
        copyTituloDadosEncargosAbatimentosToTitulo(tituloBean, tituloFixoBean);
        // copyTituloDadosImpressaoBloquetoToTitulo(tituloBean, tituloFixoBean);

        // Obtem Parte Variavel (recordset)
        ArrayList tituloArrayList = convertDataStructure(((BeanList) tituloList.get(1)).iterator());

        List tituloRetornoList = new ArrayList();
        tituloRetornoList.add(tituloFixoBean);
        tituloRetornoList.add(tituloArrayList);

        return tituloRetornoList;
    }

    // Acessa o Mainframe para obter dados "Lista titulos consolidado BG58"
    protected List getTituloListarTitulo(HttpServletRequest request, HttpServletResponse response,  TituloBean tituloBean) throws Exception {

    	// Instancia o EJB que acessa o mainframe
    	if (tituloBean.getPagina()>1){
    		tituloBean = (TituloBean) tituloBean.getSessionBean(request, FILTRO_BEAN);	
    	}
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        if (tituloBean.getCmbEmissao()==null){
        	tituloBean.setCmbEmissao("");
        }
        if (tituloBean.getCmbCarteira()==null){
        	tituloBean.setCmbCarteira("");
        }
        
        // Prepara o bean para subida de informacao ao mainframe
        TituloListarBean tituloFixoBean = new TituloListarBean();
        tituloFixoBean = (TituloListarBean) tituloFixoBean.newBean();
        tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());
        tituloFixoBean.setSituacao(tituloBean.getSituacao());
        tituloFixoBean.setClassificacao(tituloBean.getClassificacao());
        tituloFixoBean.setDataInicio(tituloBean.getDataInicio());
        tituloFixoBean.setDataFim(tituloBean.getDataFim());
        tituloFixoBean.setCmbCarteira(tituloBean.getCmbCarteira());
        tituloFixoBean.setCmbEmissao(tituloBean.getCmbEmissao());
        
        String tipoAvanco = (String)  request.getParameter("tipoAvanco");
        String controle = (String)  request.getParameter("controle");
       
        if (controle==null){
        	tituloFixoBean.setControle("");
        }else{
        	controle = controle.substring(0, controle.length()-2) + tipoAvanco + controle.substring(controle.length()-1, controle.length());
        	tituloFixoBean.setControle(controle);
        }
        if (tituloFixoBean.getControle()==null){
        	tituloFixoBean.setControle("");
        }

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
            tituloFixoBean.setDataInicio(tituloBean.getDataInicio());
            tituloFixoBean.setDataFim(tituloBean.getDataFim());

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
			request.setAttribute("pagAtual", paginaAtual);
            request.getSession().setAttribute("pagAtual", paginaAtual);
            request.getSession().setAttribute("controle", tituloFixoBean.getControle());
            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(tituloFixoBean.getTotalRegistro() / 20.0));
			request.getSession().setAttribute("totPagina", (int) Math.ceil(tituloFixoBean.getTotalRegistro() / 20.0));

            
            return tituloRetornoList;
            
        } catch (Exception e) {
            setCedenteCabecaBean(tituloBean, request);

            throw e;
        }
    }

    
    
    protected List getTituloListarTituloPagina(HttpServletRequest request, HttpServletResponse response,  TituloBean tituloBean, Long paginaAtual) throws Exception {

    	// Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        if (tituloBean.getCmbEmissao()==null){
        	tituloBean.setCmbEmissao("");
        }
        if (tituloBean.getCmbCarteira()==null){
        	tituloBean.setCmbCarteira("");
        }
        
        // Prepara o bean para subida de informacao ao mainframe
        TituloListarBean tituloFixoBean = new TituloListarBean();
        tituloFixoBean = (TituloListarBean) tituloFixoBean.newBean();
        tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());
        tituloFixoBean.setSituacao(tituloBean.getSituacao());
        tituloFixoBean.setClassificacao(tituloBean.getClassificacao());
        tituloFixoBean.setDataInicio(tituloBean.getDataInicio());
        tituloFixoBean.setDataFim(tituloBean.getDataFim());
        tituloFixoBean.setCmbCarteira(tituloBean.getCmbCarteira());
        tituloFixoBean.setCmbEmissao(tituloBean.getCmbEmissao());
        
        tituloBean.setPagina(Long.valueOf(paginaAtual));
        tituloFixoBean.setPagina(Long.valueOf(paginaAtual));
        
        
        if (tituloBean.getControle()==null){
        	tituloFixoBean.setControle("");
        }else{
        	tituloFixoBean.setControle(tituloBean.getControle());
        }

        try {
            // Chama o Mainframe
        	  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
              String transUser = TRANSACAO_LISTAR_TITULO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BG58 */List tituloList = (List) handler.executeFixDataRecordsetTransaction(tituloFixoBean,transUser);

            // Obtem Parte Fixa
            tituloFixoBean = (TituloListarBean) ((BeanList) tituloList.get(0)).get(0);
            tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());
            tituloFixoBean.setSituacao(tituloBean.getSituacao());
            tituloFixoBean.setClassificacao(tituloBean.getClassificacao());
            tituloFixoBean.setPagina(tituloBean.getPagina());
            tituloFixoBean.setDataInicio(tituloBean.getDataInicio());
            tituloFixoBean.setDataFim(tituloBean.getDataFim());

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
    
    // Acessa o Mainframe para obter dados "Lista titulos consolidado BG59"
    protected List getTituloListarConsolidado(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Prepara o bean para subida de informacao ao mainframe
        TituloListarBean tituloFixoBean = new TituloListarBean();
        tituloFixoBean = (TituloListarBean) tituloFixoBean.newBean();
        tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Chama o Mainframe
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_CONSOLIDADO + usuarioBean.getCodigoUsuario().toUpperCase();
        List tituloList = (List) handler.executeFixDataRecordsetTransaction(tituloFixoBean,
        		transUser);

        // Obtem Parte Fixa
        tituloFixoBean = (TituloListarBean) ((BeanList) tituloList.get(0)).get(0);
        tituloFixoBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Obtem Parte Variavel (recordset)
        ArrayList tituloArrayList = convertDataStructure(((BeanList) tituloList.get(1)).iterator());

        List tituloRetornoList = new ArrayList();
        tituloRetornoList.add(tituloFixoBean);
        tituloRetornoList.add(tituloArrayList);

        return tituloRetornoList;
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
        
        
        tituloTo.setDtGarantia(tituloFrom.getDtGarantia());
        tituloTo.setCoUsuario(tituloFrom.getCoUsuario());
        String icGar = tituloFrom.getIcGarantia();
        if (icGar.equals("S") || icGar.equals("SIM")){
        	icGar="SIM";
        }else{
        	icGar="NÃO";
        }
        tituloTo.setIcGarantia(icGar);
        
        tituloTo.setIcRegistroCIP(tituloFrom.getIcRegistroCIP());
        tituloTo.setNuIdentificaCIP(tituloFrom.getNuIdentificaCIP());
        tituloTo.setNuRefereciaCIP(tituloFrom.getNuRefereciaCIP());
        tituloTo.setSgIndexador(tituloFrom.getSgIndexador());
        tituloTo.setIcTipoPagamento(tituloFrom.getIcTipoPagamento());
        tituloTo.setVrMaximoPgto(tituloFrom.getVrMaximoPgto());
        tituloTo.setVrMinPgto(tituloFrom.getVrMinPgto());
        tituloTo.setIcAutPagto(tituloFrom.getIcAutPagto());
        tituloTo.setQtPgtoPossivel(tituloFrom.getQtPgtoPossivel());
        tituloTo.setQtPgtoEfetuado(tituloFrom.getQtPgtoEfetuado());
        tituloTo.setVrSaldoTitulo(tituloFrom.getVrSaldoTitulo());
        tituloTo.setDataInicio(tituloFrom.getDataInicio());
        tituloTo.setDataFim(tituloFrom.getDataFim());
        
        
        
      

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

    protected void copyTituloDadosLiquidacaoToTitulo(TituloBean tituloFrom,
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

    protected void copyTituloDadosComplementaresToTitulo(TituloBean tituloFrom,
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
        //tituloTo.setIofAtraso(tituloFrom.getIofAtraso());
        //tituloTo.setIofAtraso61(tituloFrom.getIofAtraso61());
        //tituloTo.setJurosAtraso(tituloFrom.getJurosAtraso());
       
      
    }

    protected void copyTituloDadosEncargosAbatimentosToTitulo(TituloBean tituloFrom,
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
        tituloTo.setTipoDesconto(tituloFrom.getTipoDesconto());
        tituloTo.setTipoJuros(tituloFrom.getTipoJuros());
       
        
    }

    protected void copyTituloDadosImpressaoBloquetoToTitulo(TituloBean tituloFrom,
            TituloBean tituloTo) {
        tituloTo.setBloqCodigoBarrasFormatado(tituloFrom.getBloqCodigoBarrasFormatado());
        tituloTo.setBloqCodigoBarrasNumerico(tituloFrom.getBloqCodigoBarrasNumerico());
        tituloTo.setBloqDigitoCtrlNossoNumero(tituloFrom.getBloqDigitoCtrlNossoNumero());
    }
}
