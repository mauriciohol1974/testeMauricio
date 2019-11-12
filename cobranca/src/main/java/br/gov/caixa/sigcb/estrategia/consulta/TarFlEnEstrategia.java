package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Tarifas por
 * Float e EN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class TarFlEnEstrategia extends SigcbEstrategia {

    // Título
    public static final String TITLE = "Consultar Tarifas Por Float e SR";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR = "consulta.TarFlEnManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.TarFlEnManterFiltro";

    // beans
    public static final String BEAN_FILTRO = "filtroBean";

    public static final String BEAN_FIXO = "fixoBean";

    public static final String BEAN_DATA = "dataBean";

    public static final String BEAN_MSG = "msgBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/tarflen_erro";

    public static final String PAGE_FILTRO = "consulta/tarflen_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/tarflen_consultar";

    // transação
    public static final String TRANS_TARFLEN = "BGD1";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
