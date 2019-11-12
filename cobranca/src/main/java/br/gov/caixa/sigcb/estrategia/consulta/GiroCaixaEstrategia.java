package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public abstract class GiroCaixaEstrategia extends SigcbEstrategia {

    // estrat�gias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.GiroCaiManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.GiroCaiManterFiltro";

    // beans gen�ricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "giroCaixaFiltroBean";

    public static final String DATA_BEAN = "giroCaixaBean";

    // p�ginas
    public static final String PAGE_JSP_ERRO = "consulta/girocai_erro";

    public static final String PAGE_JSP_FILTRO = "consulta/girocai_manter_filtro";

    public static final String PAGE_JSP_CONSULTAR = "consulta/girocai_consultar";

    public static final String PAGE_JSP_LISTAR_CPFCNPJ = "consulta/girocai_manter_listar_cpfcnpj";

    public static final String PAGE_JSP_LISTAR_UNIDEN = "consulta/girocai_manter_listar_uniden";

    public static final String PAGE_JSP_LISTAR_UNIDPV = "consulta/girocai_manter_listar_unidpv";

    // Titles
    public static final String PAGE_TITLE = "Consultar Cadastro do GiroCaixa Instant�neo";

    public static final String PAGE_TITLE_FILTRO = "Consultar Cadastro do GiroCaixa Instant�neo >> Filtro";

    public static final String PAGE_TITLE_CONSULTA = "Consultar Cadastro do GiroCaixa Instant�neo (Cedente)";

    public static final String PAGE_TITLE_LISTAR_CPFCNPJ = "Consultar Cadastro do GiroCaixa Instant�neo (CNPJ) >> Listar";

    public static final String PAGE_TITLE_LISTAR_EN = "Consultar Cadastro do GiroCaixa Instant�neo (EN) >> Listar";

    public static final String PAGE_TITLE_LISTAR_PV = "Consultar Cadastro do GiroCaixa Instant�neo (PV) >> Listar";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transa��o que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_CEDENTE_GIRO_CAIXA = "BGA4";

    public static final String TRANSACAO_CEDENTE_CPF_CNPJ_PV = "BGA3";

    public static final String TRANSACAO_CEDENTE_UNID_EN = "BGA2";

    // Valores dos Radios do Filtro
    public static final Long SELECAO_RADIO_CEDENTE = new Long(0);

    public static final Long SELECAO_RADIO_CPF_CNPJ = new Long(1);

    public static final Long SELECAO_RADIO_UNIDADE = new Long(2);

    public static final Long NAVEGACAO_FILTRO = new Long(0);

    public static final Long NAVEGACAO_CONSULTA = new Long(1);

    public static final Long NAVEGACAO_LISTA_CPF_CNPJ = new Long(2);

    public static final Long NAVEGACAO_LISTA_EN = new Long(3);

    public static final Long NAVEGACAO_LISTA_PV = new Long(4);

    public static final Long NAVEGACAO_FINAL = new Long(5);

    public static final Long SELECAO_EN = new Long(1);

    public static final Long SELECAO_PV = new Long(2);

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_JSP_ERRO;
    }

}
