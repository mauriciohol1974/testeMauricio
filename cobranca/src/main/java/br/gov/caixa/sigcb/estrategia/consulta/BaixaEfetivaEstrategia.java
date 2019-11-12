package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class BaixaEfetivaEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.BaixaEfetivaManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.BaixaEfetivaManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.BaixaEfetivaDetalhe";

    // beans genéricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "baixaEfetivalBean";

    public static final String DATA_BEAN = "dadosBaixaBean";

    // páginas
    public static final String PAGE_ERRO = "consulta/baixa_efetiva_erro";

    public static final String PAGE_FILTRO = "consulta/baixa_efetiva_filtro";

    public static final String PAGE_CONSULTAR = "consulta/baixa_efetiva_detalhe";

    public static final String PAGE_LISTAR = "consulta/baixa_efetiva_listar";

    // Titles
    public static final String PAGE_TITLE = "Consultar Baixa Efetiva";

    public static final String PAGE_TITLE_FILTRO = "Consultar Baixa Efetiva >> Filtro";

    public static final String PAGE_TITLE_LISTA = "Consultar Baixa Efetiva >> Listar";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transação que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_LISTAR_BAIXA = "BGSK";

    public static final String TRANSACAO_CONSULTAR_BAIXA = "BGSL";

    // Valores dos Radios do Filtro
    public static final Long SELECAO_RADIO_CEDENTE = new Long(0);

    public static final Long SELECAO_RADIO_UNIDADE = new Long(1);

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
