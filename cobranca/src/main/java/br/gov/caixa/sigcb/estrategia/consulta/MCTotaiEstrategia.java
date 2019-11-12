package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento do cedente -(EXTRATO)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class MCTotaiEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_INICIAR = "consulta.MCTotaiManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.MCTotaiManterFiltro";

    // Beans
    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    public static final String BEAN_FILTRO = "mctotaiBean";

    public static final String BEAN_DATA = "dataBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/mctotai_erro";

    public static final String PAGE_FILTRO = "consulta/mctotai_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/mctotai_consultar";

    // Títulos
    public static final String TITLE = "Consultar Movimento do Cedente (Totais)";

    // transações
    public static final String TRANSACAO_MOVTOTAIS = "BGB3";

    public static final String TRANSACAO_CEDENTE = "BGM0";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
