package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Cedente por Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class CedCentEstrategia extends SigcbEstrategia {
    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.CedCentManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.CedCentManterFiltro";

    // beans genericos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "cedCentFiltroBean";

    public static final String DATA_BEAN = "cedCentBean";

    // páginas comuns
    public static final String PAGE_JSP_ERRO = "consulta/cedcent_erro";

    public static final String PAGE_JSP_FILTRO = "consulta/cedcent_manter_filtro";

    public static final String PAGE_JSP_CONSULTAR = "consulta/cedcent_consultar";

    // Titles
    public static final String PAGE_TITLE_FILTRO = "Consultar Cedentes por Cedente Centralizador >> Filtro";

    public static final String PAGE_TITLE_CONSULTA = "Consultar Cedentes por Cedente Centralizador";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transação que preenche
    // o cabeçalho do cedente
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    // utilizada para chamar a transação de consulta
    // por cedente centralizador
    public static final String TRANSACAO_CEDENTE_CENTRALIZADOR = "BGA0";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_JSP_ERRO;
    }
}
