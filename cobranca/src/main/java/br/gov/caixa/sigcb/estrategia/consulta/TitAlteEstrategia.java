package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>10/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class TitAlteEstrategia extends SigcbEstrategia {

    // Título
    public static final String TITLE = "Consulta de Títulos Alterados";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR = "consulta.TitAlteManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.TitAlteManterFiltro";

    public static final String STRATEGY_BCO_TIT = "servico.BcoTituManterIniciar";

    // beans
    public static final String BEAN_FILTRO = "filtroBean";

    public static final String BEAN_FIXO = "fixoBean";

    public static final String BEAN_MSG = "msgBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/titalte_erro";

    public static final String PAGE_FILTRO = "consulta/titalte_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/titalte_consultar";

    // transação
    public static final String TRANS_TITALTE = "BGD2";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
