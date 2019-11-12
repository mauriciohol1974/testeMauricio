package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
  * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas - T�tulos
 * liquidados com reten��o IOF
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/12/2010</DD>
 * </DL>
 * 
 * @author Adelaine Rondon - adelaine.rondon@probank.com.br
 */
public abstract class TitLiqIOFManterEstrategia extends SigcbEstrategia {

    // estrat�gias

    public static final String STRATEGY_INICIAR = "consulta.TitLiqIOFManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.TitLiqIOFManterFiltro";

    // Beans

    public static final String MSG_BEAN = "msgBean";

    public static final String FILTRO_BEAN = "filtroTitIOFBean"; 

    public static final String TITLIQD_BEAN = "titLiqIOFBean";
    
    public static final String LISTA_DECENDIOS = "listaDecendios";

    // P�ginas

    public static final String PAGE_ERRO = "consulta/titliqiof_erro";

    public static final String PAGE_LIQIOF_FILTRO = "consulta/titliqiof_manter_filtro";

    public static final String PAGE_LIQIOF_CONSULTAR = "consulta/titliqiof_manter_consultar";

    // T�tulos

    public static final String PAGE_TITLE = "Consulta T�tulos Liquidados com Reten��o IOF";

    // transa��o

    public static final String TRANS_LISTA_TITULOS = "BGEC";
    
    // Valores dos Radios do Filtro
    
    public static final Long SELECAO_RADIO_CEDENTE = new Long(0);

    public static final Long SELECAO_RADIO_UNIDADE = new Long(1);

    public static final Long SELECAO_RADIO_CAIXA = new Long(2);

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
