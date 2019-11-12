package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerais -
 * Servi�os solicitados - Solicita��es rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class ServRejEstrategia extends SigcbEstrategia {

    // T�tulo
    public static final String TITLE = "Consultar Servi�os Solicita��es Rejeitadas";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR = "consulta.ServRejManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.ServRejManterFiltro";

    // beans
    public static final String BEAN_FILTRO = "filtroBean";

    public static final String BEAN_DATA = "dataBean";

    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    // P�ginas
    public static final String PAGE_ERRO = "consulta/servrej_erro";

    public static final String PAGE_FILTRO = "consulta/servrej_manter_filtro";

    public static final String PAGE_LISTA_PVVINC = "consulta/servrej_manter_listar_pvvinc";

    public static final String PAGE_CONSULTAR = "consulta/servrej_consultar";

    // transa��o
    public static final String TRANS_CABECALHO = "BGM0";

    public static final String TRANS_LISTA_PV = "BGE1";

    public static final String TRANS_SOL_REJ = "BGD0";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}
