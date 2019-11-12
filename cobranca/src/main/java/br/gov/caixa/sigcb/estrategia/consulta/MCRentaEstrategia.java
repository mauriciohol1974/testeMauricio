package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas gerais -
 * Movimento de Cobrança - Consultar cedentes por Rentabilidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public abstract class MCRentaEstrategia extends SigcbEstrategia {
    // estratégias
    public static final String STRATEGY_INICIAR = "consulta.MCRentaManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.MCRentaManterFiltro";

    // Beans
    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    public static final String BEAN_FILTRO = "mcrentaBean";

    public static final String BEAN_DATA = "dataBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/mcrenta_erro";

    public static final String PAGE_FILTRO = "consulta/mcrenta_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/mcrenta_consultar";

    // Títulos
    public static final String TITLE = "Consultar Cedentes por rentabilidade";

    // transações
    public static final String TRANSACAO_MCRENTA = "BGA9";

    public static final String TRANSACAO_CEDENTE = "BGM0";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
