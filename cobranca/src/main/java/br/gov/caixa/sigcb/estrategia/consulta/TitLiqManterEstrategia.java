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
public abstract class TitLiqManterEstrategia extends SigcbEstrategia {

    // estratégias

    public static final String STRATEGY_INICIAR = "consulta.TitLiqManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.TitLiqManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.TitLiqConsultarDetIniciar";

    // Beans

    public static final String MSG_BEAN = "msgBean";

    public static final String CABECALHO_BEAN = "cedCabBean";

    public static final String FILTRO_BEAN = "titLiqfiltroBean";

    public static final String DATA_BEAN = "titLiqDataBean";

    public static final String TITLIQ_BEAN = "titLiqBean";

    // Páginas

    public static final String PAGE_ERRO = "consulta/titliq_erro";

    public static final String PAGE_LIQ_FILTRO = "consulta/titliq_manter_filtro";

    public static final String PAGE_LIQ_LISTA_PV = "consulta/titliq_manter_listar_unidpv";

    public static final String PAGE_LIQ_LISTA_CED = "consulta/titliq_manter_listar_cedente";

    public static final String PAGE_LIQ_CONSULTAR = "consulta/titliq_consultar";

    // Títulos

    public static final String PAGE_TITLE = "Consulta por Títulos Liquidados";

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
