package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de consultas Gerais -
 * Valores a serem Lancados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class ValLancManterEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_INICIAR = "consulta.ValLancManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.ValLancManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.ValLancConsultarDetIniciar";

    // Beans
    public static final String MSG_BEAN = "msgBean";

    public static final String CABECALHO_BEAN = "cedCabBean";

    public static final String FILTRO_BEAN = "valLancfiltroBean";

    public static final String DATA_BEAN = "valLancDataBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/vallanc_erro";

    public static final String PAGE_FILTRO = "consulta/vallanc_manter_filtro";

    public static final String PAGE_LISTA = "consulta/vallanc_manter_listar";

    public static final String PAGE_CONSULTAR = "consulta/vallanc_consultar";

    // Títulos
    public static final String PAGE_TITLE = "Consultar Lançamentos em Conta Corrente";

    // transações
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_UNIDADES_POR_CEDENTE = "BGD6";

    public static final String TRANSACAO_VALLANC_DETALHES = "BGD7";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_LIST_SPLIT = "paginacaoSplit";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
