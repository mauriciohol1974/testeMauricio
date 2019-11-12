package br.gov.caixa.sigcb.estrategia.cedente;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionacao >>
 * estratégia principal
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public abstract class ExcepciManterEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_FILTRO = "cedente.ExcepciManterIniciar";

    public static final String STRATEGY_LISTA = "cedente.ExcepciManterFiltro";

    public static final String STRATEGY_ACAO_RESP_INICIAR = "cedente.ExcepciAcaoResponderIniciar";

    public static final String STRATEGY_ACAO_RESP_LIBERAR = "cedente.ExcepciAcaoResponderLiberar";

    public static final String STRATEGY_ACAO_RESP_FINALIZAR = "cedente.ExcepciAcaoResponderFinalizar";

    public static final String STRATEGY_ACAO_ALT_DT_INICIAR = "cedente.ExcepciAcaoAlterarDataIniciar";

    public static final String STRATEGY_ACAO_ALT_DT_FINALIZAR = "cedente.ExcepciAcaoAlterarDataFinalizar";

    public static final String STRATEGY_RETORNO_SUCESSO = "cedente.ExcepciManterIniciar";

    // Erros
    public static final String ERROR_TITLE = "Excepcionação de alçada";

    public static final String ERROR_FILTRO_TITLE = "Erro ao filtrar informações";

    public static final String ERROR_ACAO_ALT_DT_TITLE = "";

    public static final String USUARIO_LDAP = "usuarioLdap";

    // Beans
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String FIXO_BEAN = "fixoBean";

    public static final String EXCEPCI_BEAN = "excepcionacaoBean";

    public static final String FILTRO_BEAN = "FiltroBean";

    public static final String DATA_BEAN = "excepciBean";

    public static final String PAGE_TITLE = "Excepcionação de Pendencia de Alçada";

    // Paginas
    public static final String PAGE_FILTRO = "cedente/excepci_manter_filtro";

    public static final String PAGE_LISTAR_CEDENTE_NUMPED = "cedente/excepci_manter_listar_cedente";

    public static final String PAGE_LISTAR_PV = "cedente/excepci_manter_listar_unidpv";

    public static final String PAGE_LISTAR_EN = "cedente/excepci_manter_listar_uniden";

    public static final String PAGE_LISTAR_CPFCNPJ = "cedente/excepci_manter_listar_cpfcnpj";

    public static final String PAGE_SUCESSO = "cedente/excepci_sucesso";

    public static final String PAGE_ACAO_ALTERAR_DATA = "cedente/excepci_acao_alterar_data";

    public static final String PAGE_ACAO_RESPONDER = "cedente/excepci_acao_responder";

    public static final String PAGE_ACAO_RESPONDER_LIB = "cedente/excepci_acao_responder_lib";

    public static final String PAGE_CONSULTAR = "cedente/excepci_consultar";

    public static final String PAGE_ERRO = "cedente/excepci_erro";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_LIST_SPLIT = "paginacaoSplit";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    // Funcoes
    public static final String TIPO_CONSULTA_VOLTAR = "tpConsultaVoltar";

    public static final String VOLTAR = "voltar";

    public static final String DATA_SERVIDOR = "dataServidor";

    public static final String NAVEGACAO_CONSULTAR = "consultar";

    public static final String NAVEGACAO_CEDENTE = "cedente";

    // transacoes
    public static final String TRANSACAO_CABECALHO_CEDENTE = "BGM0";

    public static final String TRANSACAO_LISTAR_EN = "BG31";

    public static final String TRANSACAO_LISTAR_CPFCNPJ_PV = "BG32";

    public static final String TRANSACAO_LISTAR_CEDENTE_NUMPED = "BG33";

    public static final String TRANSACAO_CONSULTAR_DETALHES = "BG34";

    public static final String TRANSACAO_RESP_PEND_FIM = "BG35";

    public static final String TRANSACAO_ALT_DATA_VIGENCIA_FIM = "BG36";

    public static final String TRANSACAO_EXCLUIR_AGENDAMENTO = "BG37";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
