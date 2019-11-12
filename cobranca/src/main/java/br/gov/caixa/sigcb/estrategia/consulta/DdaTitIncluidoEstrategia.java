package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public abstract class DdaTitIncluidoEstrategia extends SigcbEstrategia {

    // estrat�gias
	// DDA Titulos Incluidos
    public static final String STRATEGY_INICIAR = "consulta.DdaTitIncluidoIniciar";

    public static final String STRATEGY_FILTRO = "consulta.DdaTitIncluidoManterFiltro";

    public static final String STRATEGY_CONSULTAR = "consulta.DdaTitIncluidoConsultar";
    
    // DDA T�tulos Inclu�dos Rejeitados
    public static final String STRATEGY_INICIAR_I_REJ = "consulta.DdaTitIncluidoRejIniciar";

    public static final String STRATEGY_FILTRO_I_REJ = "consulta.DdaTitIncluidoRejManterFiltro";

    public static final String STRATEGY_CONSULTAR_I_REJ = "consulta.DdaTitIncluidoRejConsultar";
    
    // DDA T�tulos Alterados
    public static final String STRATEGY_INICIAR_A = "consulta.DdaTitAlteradoIniciar";

    public static final String STRATEGY_FILTRO_A = "consulta.DdaTitAlteradoManterFiltro";

    public static final String STRATEGY_CONSULTAR_A = "consulta.DdaTitAlteradoConsultar";
    
    //DDA T�tulos Alterados Rejeitados
    public static final String STRATEGY_INICIAR_A_REJ = "consulta.DdaTitAlteradoRejIniciar";

    public static final String STRATEGY_FILTRO_A_REJ = "consulta.DdaTitAlteradoRejManterFiltro";

    public static final String STRATEGY_CONSULTAR_A_REJ = "consulta.DdaTitAlteradoRejConsultar";
    
    //DDA T�tulos Baixados
    public static final String STRATEGY_INICIAR_B = "consulta.DdaTitBaixadoIniciar";

    public static final String STRATEGY_FILTRO_B = "consulta.DdaTitBaixadoManterFiltro";

    public static final String STRATEGY_CONSULTAR_B = "consulta.DdaTitBaixadoConsultar";
    
    //DDA T�tulos Baixados Rejeitados
    public static final String STRATEGY_INICIAR_B_REJ = "consulta.DdaTitBaixadoRejIniciar";

    public static final String STRATEGY_FILTRO_B_REJ = "consulta.DdaTitBaixadoRejManterFiltro";

    public static final String STRATEGY_CONSULTAR_B_REJ = "consulta.DdaTitBaixadoRejConsultar";

    
    // Beans

    public static final String MSG_BEAN = "msgBean";

    public static final String CABECALHO_BEAN = "cedCabBean";

    public static final String FILTRO_BEAN = "titLiqfiltroBean";

    public static final String DATA_BEAN = "titLiqDataBean";

    public static final String TITLIQ_BEAN = "titLiqBean";//"ddaTitBean";"titLiqBean"

    // P�ginas
    // DDA Titulos Incluidos
    public static final String PAGE_ERRO = "consulta/ddatitincl_erro";

    public static final String PAGE_LIQ_FILTRO = "consulta/ddatitincl_manter_filtro";

    public static final String PAGE_LIQ_LISTA_PV = "consulta/ddatitincl_manter_listar_unidpv";

    public static final String PAGE_LIQ_LISTA_CED = "consulta/ddatitincl_manter_listar_cedente";

    public static final String PAGE_LIQ_CONSULTAR = "consulta/ddatitincl_consultar";
    
    // DDA T�tulos Inclu�dos Rejeitados
    public static final String PAGE_DDA_FILTRO_I_REJ = "consulta/ddatitinclrej_manter_filtro";

    public static final String PAGE_DDA_LISTA_PV_I_REJ = "consulta/ddatitinclrej_manter_listar_unidpv";

    public static final String PAGE_DDA_LISTA_CED_I_REJ = "consulta/ddatitinclrej_manter_listar_cedente";

    public static final String PAGE_DDA_CONSULTAR_I_REJ = "consulta/ddatitinclrej_consultar";
    
    // DDA T�tulos Alterados
    public static final String PAGE_DDA_FILTRO_A = "consulta/ddatitalt_manter_filtro";

    public static final String PAGE_DDA_LISTA_PV_A = "consulta/ddatitalt_manter_listar_unidpv";

    public static final String PAGE_DDA_LISTA_CED_A = "consulta/ddatitalt_manter_listar_cedente";

    public static final String PAGE_DDA_CONSULTAR_A = "consulta/ddatitalt_consultar";
    
    //DDA T�tulos Alterados Rejeitados
    public static final String PAGE_DDA_FILTRO_A_REJ = "consulta/ddatitaltrej_manter_filtro";

    public static final String PAGE_DDA_LISTA_PV_A_REJ = "consulta/ddatitaltrej_manter_listar_unidpv";

    public static final String PAGE_DDA_LISTA_CED_A_REJ = "consulta/ddatitaltrej_manter_listar_cedente";

    public static final String PAGE_DDA_CONSULTAR_A_REJ = "consulta/ddatitaltrej_consultar";
    
    // DDA T�tulos Baixados
    public static final String PAGE_DDA_FILTRO_B = "consulta/ddatitbai_manter_filtro";

    public static final String PAGE_DDA_LISTA_PV_B = "consulta/ddatitbai_manter_listar_unidpv";

    public static final String PAGE_DDA_LISTA_CED_B = "consulta/ddatitbai_manter_listar_cedente";

    public static final String PAGE_DDA_CONSULTAR_B = "consulta/ddatitbai_consultar";
    
    //DDA T�tulos Baixados Rejeitados
    public static final String PAGE_DDA_FILTRO_B_REJ = "consulta/ddatitbairej_manter_filtro";

    public static final String PAGE_DDA_LISTA_PV_B_REJ = "consulta/ddatitbairej_manter_listar_unidpv";

    public static final String PAGE_DDA_LISTA_CED_B_REJ = "consulta/ddatitbairej_manter_listar_cedente";

    public static final String PAGE_DDA_CONSULTAR_B_REJ = "consulta/ddatitbairej_consultar";
    
    
    // T�tulos

    public static final String PAGE_TITLE = "DDA >> Consultar T�tulos Inclu�dos";
    
    public static final String PAGE_TITLE_INC_REJ = "DDA >> Consultar T�tulos Inclu�dos Rejeitados";
    
    public static final String PAGE_TITLE_ALT = "DDA >> Consultar T�tulos Alterados";
    
    public static final String PAGE_TITLE_ALT_REJ = "DDA >> Consultar T�tulos Alterados Rejeitados";
    
    public static final String PAGE_TITLE_BAI = "DDA >> Consultar T�tulos Baixados";
    
    public static final String PAGE_TITLE_BAI_REJ = "DDA >> Consultar T�tulos Baixados Rejeitados";
    

    // transa��es

    public static final String TRANS_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANS_CEDENTE_POR_PV = "BGGA";

    public static final String TRANS_LISTA_TITULOS = "BGGB";

    public static final String TRANS_CONSULTAR_DETALHES = "BGGC";

    // paginacao

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
