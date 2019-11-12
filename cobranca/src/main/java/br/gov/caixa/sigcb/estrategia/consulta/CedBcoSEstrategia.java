package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class CedBcoSEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.CedBcoSManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.CedBcoSManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.CedBcoSConsultarDetIniciar";

    // beans genericos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "cedBcoFiltroBean";

    public static final String DATA_BEAN = "cedBcoBean";

    // páginas comuns
    public static final String PAGE_JSP_ERRO = "consulta/cedbcos_erro";

    public static final String PAGE_JSP_FILTRO = "consulta/cedbcos_manter_filtro";

    public static final String PAGE_JSP_LISTAR = "consulta/cedbcos_manter_listar";

    public static final String PAGE_JSP_CONSULTAR = "consulta/cedbcos_consultar";

    // Titles
    public static final String PAGE_TITLE_FILTRO = "Consultar Cedentes com Banco de Sacados >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "Consultar Cedentes com Banco de Sacados >> Listar";

    public static final String PAGE_TITLE_CONSULTA = "Consultar Cedentes com Banco de Sacados";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transação que preenche
    // o cabeçalho do cedente
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    // utilizada para chamar a transação de consulta
    // por cedente centralizador
    public static final String TRANSACAO_CEDENTE_PV = "BGA1";

    public static final String TRANSACAO_CEDENTE_BANCOSACADO = "BG46";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_JSP_ERRO;
    }
}
