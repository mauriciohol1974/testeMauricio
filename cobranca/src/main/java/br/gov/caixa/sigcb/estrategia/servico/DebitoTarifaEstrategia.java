package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class DebitoTarifaEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "servico.DebitoTarifaConsultarDetIniciar_Incluir";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.DebitoTarifaManterFiltro";
    
    public static final String STRATEGY_CONSULTAR_DETALHE_INCLUIR = "servico.DebitoTarifaConsultarDetalheDetIniciar_Incluir";
    
    public static final String STRATEGY_CONSULTAR_INCLUIR = "servico.DebitoTarifaConsultarDetIniciar_Incluir";
    
    public static final String STRATEGY_CONSULTAR_DETALHE_MANTER = "servico.DebitoTarifaConsultarDetalheDetIniciar_Manter";
    
    public static final String STRATEGY_CONSULTAR_MANTER = "servico.DebitoTarifaConsultarDetIniciar_Manter";


    // beans genéricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "lancamentoTarifaFiltroBean";

    public static final String DATA_BEAN = "lancamentoTarifaBean";

    // páginas
    public static final String PAGE_ERRO = "consulta/debitotari_erro";

    public static final String PAGE_FILTRO = "consulta/debitotari_manter_filtro";

    public static final String PAGE_CONSULTAR = "servico/debitotari_consultar";

    public static final String PAGE_LISTAR = "consulta/debitotari_manter_listar";
    
    public static final String PAGE_LISTAR_DETALHE = "servico/debitotari_manter_listar_detalhe";

    // Titles
    public static final String PAGE_TITLE = "Consultar Lançamento de Tarifa";

    public static final String PAGE_TITLE_FILTRO = "Consultar Comandos de Débito de Tarifas >> Filtro";

    public static final String PAGE_TITLE_LISTA = "Consultar Comandos de Débito de Tarifas >> Listar";
    
    public static final String PAGE_TITLE_LISTA_DETALHE = "Consultar Comandos de Débito de Tarifas >> Listar Tarifas por Data do Débito";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transação que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_LISTAR = "BGNO";

    public static final String TRANSACAO_CONSULTAR = "BGA7";
    
    public static final String TRANSACAO_CONSULTAR_DETALHE = "BGA8";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
