package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public abstract class LancamentoTarifaEstrategia extends SigcbEstrategia {

    // estrat�gias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.LanTariManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.LanTariManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.LanTariConsultarDetIniciar";

    // beans gen�ricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "lancamentoTarifaFiltroBean";

    public static final String DATA_BEAN = "lancamentoTarifaBean";

    // p�ginas
    public static final String PAGE_ERRO = "consulta/lantari_erro";

    public static final String PAGE_FILTRO = "consulta/lantari_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/lantari_consultar";

    public static final String PAGE_LISTAR = "consulta/lantari_manter_listar";

    // Titles
    public static final String PAGE_TITLE = "Consultar Lan�amento de Tarifa";

    public static final String PAGE_TITLE_FILTRO = "Consultar Lan�amento de Tarifa >> Filtro";

    public static final String PAGE_TITLE_LISTA = "Consultar Lan�amento de Tarifa >> Listar";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transa��o que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_LISTAR = "BGA7";

    public static final String TRANSACAO_CONSULTAR = "BGA8";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
