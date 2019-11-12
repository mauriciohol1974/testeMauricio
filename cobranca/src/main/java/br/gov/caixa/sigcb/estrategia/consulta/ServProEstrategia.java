package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Servicos solicitados - solicitaçoes Processadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class ServProEstrategia extends SigcbEstrategia {

    // Título
    public static final String TITLE = "Consultar Serviços Solicitações Processadas";

    public static final String PAGE_TITLE_CEDENTE_TODOS = "Consultar Serviços Solicitações Processadas >> LISTA CONSOLIDADO";

    public static final String PAGE_TITLE_PV_TODOS = "Consultar Serviços Solicitações Processadas(PV) >> LISTAR";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR = "consulta.ServProManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.ServProManterFiltro";

    public static final String STRATEGY_AGE_EMI = "consulta.ServProAgeEmiConsultarDetIniciar";

    public static final String STRATEGY_TIT_EMI = "consulta.ServProEmiTitConsultarDetIniciar";

    // Titles
    public static final String PAGE_TITLE = "Consultar Serviços Solicitações processadas";

    public static final String PAGE_TITLE_FILTRO = "Consultar Serviços Solicitações Processadas >> Filtro";

    public static final String PAGE_TITLE_LISTAR_CEDENTE = "Consultar Serviços Solicitações processadas (Cedente)>> Listar";

    public static final String PAGE_TITLE_LISTAR_PV = "Consultar Serviços Solicitações processadas (PV)>> Listar";

    // bean
    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    public static final String BEAN_DATA = "dataBean";

    public static final String BEAN_FILTRO = "filtroBean";

    public static final String BEAN_FIXO = "fixoBean";

    public static final String BEAN_AGE_EMI_DET = "ageemiDetBean";

    public static final String BEAN_TIT_EMI_DET = "titEmiDetBean";

    public static final String BEAN_LAN_TAR_MAN = "lantarmanBean";

    public static final String BEAN_REI_TIT_BAI = "reiTitLiqBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/servpro_erro";

    public static final String PAGE_FILTRO = "consulta/servpro_manter_filtro";

    public static final String PAGE_LISTA_PVVINC = "consulta/servpro_manter_listar_pvvinc";

    public static final String PAGE_AGE_EMI = "consulta/servpro_manter_listar_ageemi";

    public static final String PAGE_TIT_EMI = "consulta/servpro_manter_listar_emitit";

    public static final String PAGE_BLOQ_PRE = "consulta/servpro_consultar_blopreimp";

    public static final String PAGE_REE_BLO = "consulta/servpro_consultar_reeblo";

    public static final String PAGE_AGE_EMI_DET = "consulta/servpro_consultar_ageemi";

    public static final String PAGE_TIT_EMI_DET = "consulta/servpro_consultar_emitit";

    public static final String PAGE_EXT_MOV_TIT = "consulta/servpro_consultar_extmovtit";

    public static final String PAGE_EXT_CRE_DEB = "consulta/servpro_consultar_extdiscrdb";

    public static final String PAGE_LAN_TAR_MAN = "consulta/servpro_consultar_lantarman";

    public static final String PAGE_REI_TIT_BAI = "consulta/servpro_consultar_reititbai";

    public static final String PAGE_RED_ARQ_RET = "consulta/servpro_consultar_redarqret";

    public static final String PAGE_TODOS_CEDENTE = "consulta/servpro_consultar_todos";

    public static final String PAGE_TODOS_PV = "consulta/servpro_consultar_todos_pv";

    // transação
    public static final String TRANS_CABECALHO = "BGM0";

    public static final String TRANS_AGE_EMI = "BGB9";

    public static final String TRANS_AGE_EMI_DET = "BGC0";

    public static final String TRANS_BLOQ_PRE = "BGC1";
    
    public static final String TRANS_TIT_EMI = "BGC2";

    public static final String TRANS_TIT_EMI_DET = "BGC3";

    public static final String TRANS_EXT_MOV_TIT = "BGC4";

    public static final String TRANS_EXT_CRE_DEB = "BGC5";

    public static final String TRANS_LAN_TAR_MAN = "BGC6";

    public static final String TRANS_REI_TIT_BAI = "BGC7";

    public static final String TRANS_RED_ARQ_RET = "BGC8";

    public static final String TRANS_REE_BLO = "BGC9";

    public static final String TRANS_LISTA_PV = "BGE1";

    public static final String TRANS_TODOS_CEDENTE = "BGDA";

    public static final String TRANS_TODOS_PV = "BGDB";

    // Valores dos Radios do Filtro
    public static final Long SELECAO_RADIO_CEDENTE = new Long(0);

    public static final Long SELECAO_RADIO_UNIDADE = new Long(1);

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}
