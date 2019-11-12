package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public abstract class SaldoCobrancaEstrategia extends SigcbEstrategia {

    // estrat�gias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.SalCobManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.SalCobManterFiltro";

    // beans gen�ricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "saldoCobrancaFiltroBean";

    public static final String DATA_BEAN = "saldoCobrancaBean";

    // p�ginas
    public static final String PAGE_ERRO = "consulta/salcob_erro";

    public static final String PAGE_FILTRO = "consulta/salcob_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/salcob_consultar";

    // Titles
    public static final String PAGE_TITLE = "Consultar Saldo de Cobran�a";

    public static final String PAGE_TITLE_FILTRO = "Consultar Saldo de Cobran�a >> Filtro";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transa��o que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_CONSULTAR = "BGB8";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
