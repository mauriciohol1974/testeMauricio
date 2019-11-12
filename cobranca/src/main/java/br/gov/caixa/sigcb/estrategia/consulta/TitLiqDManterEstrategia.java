package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Estratégia de consulta
 * de titulos liquidados e titulos liquidados no dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class TitLiqDManterEstrategia extends SigcbEstrategia {

    // estratégias

    public static final String STRATEGY_INICIAR = "consulta.TitLiqDManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.TitLiqDManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.TitLiqDConsultarDetIniciar";

    // Beans

    public static final String MSG_BEAN = "msgBean";

    public static final String CABECALHO_BEAN = "cedCabBean";

    public static final String FILTRO_BEAN = "titLiqDfiltroBean";

    public static final String TITLIQD_BEAN = "titLiqDBean";

    // Páginas

    public static final String PAGE_ERRO = "consulta/titliqd_erro";

    public static final String PAGE_LIQD_FILTRO = "consulta/titliqd_manter_filtro";

    public static final String PAGE_LIQD_LISTA_PV = "consulta/titliqd_manter_listar_unidpv";

    public static final String PAGE_LIQD_LISTA_CED = "consulta/titliqd_manter_listar_cedente";

    public static final String PAGE_LIQD_CONSULTAR = "consulta/titliqd_consultar";

    // Títulos

    public static final String PAGE_TITLE = "Consulta Títulos Liquidados Dia";

    // transações

    public static final String TRANS_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANS_CEDENTE_POR_PV = "BGD3";

    public static final String TRANS_LISTA_TITULOS = "BGD4";

    public static final String TRANS_CONSULTAR_DETALHES = "BGD5";

    // paginacao

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
