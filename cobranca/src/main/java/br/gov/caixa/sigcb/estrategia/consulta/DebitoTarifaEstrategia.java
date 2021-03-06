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
public abstract class DebitoTarifaEstrategia extends SigcbEstrategia {

    // estrat�gias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.DebitoTarifaManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.DebitoTarifaManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.DebitoTarifaConsultarDetIniciar";
    
    public static final String STRATEGY_CONSULTAR_DETALHE = "consulta.DebitoTarifaConsultarDetalheDetIniciar";

    // beans gen�ricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "lancamentoTarifaFiltroBean";

    public static final String DATA_BEAN = "lancamentoTarifaBean";

    // p�ginas
    public static final String PAGE_ERRO = "consulta/manterdebitotari_erro";

    public static final String PAGE_FILTRO = "consulta/debitotari_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/debitotari_consultar";

    public static final String PAGE_LISTAR = "consulta/debitotari_manter_listar";
    
    public static final String PAGE_LISTAR_DETALHE = "consulta/debitotari_manter_listar_detalhe";

    // Titles
    public static final String PAGE_TITLE = "Consultar Comandos de D�bito de Tarifas";

    public static final String PAGE_TITLE_FILTRO = "Consultar Comandos de D�bito de Tarifas >> Filtro";

    public static final String PAGE_TITLE_LISTA = "Consultar Comandos de D�bito de Tarifas >> Listar";
    
    public static final String PAGE_TITLE_LISTA_DETALHE = "Consultar Comandos de D�bito de Tarifas >> Listar Tarifas por Data do D�bito";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transa��o que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_LISTAR = "BGNO";

    public static final String TRANSACAO_CONSULTAR = "BGA7";
    
    public static final String TRANSACAO_CONSULTAR_DETALHE = "BGA8";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
