package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class ServDiaEstrategia extends SigcbEstrategia {

    // Títulos
    public static final String TITLE = "Consultar Serviços Solicitados Dia";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estratégias
    public static final String STRATEGY_INICIAR = "consulta.ServDiaManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.ServDiaManterFiltro";

    public static final String STRATEGY_AGE_EMI = "consulta.ServDiaAgeEmiConsultarDetIniciar";

    public static final String STRATEGY_TIT_EMI = "consulta.ServDiaEmiTitConsultarDetIniciar";

    // Beans
    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    public static final String BEAN_DATA = "dataBean";

    public static final String BEAN_FILTRO = "filtroBean";

    public static final String BEAN_AGE_EMI_DET = "ageemiDetBean";

    public static final String BEAN_TIT_EMI_DET = "titEmiDetBean";

    public static final String BEAN_LAN_TAR_MAN = "lantarmanBean";

    public static final String BEAN_REI_TIT_BAI = "reiTitLiqBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/servdia_erro";

    public static final String PAGE_FILTRO = "consulta/servdia_manter_filtro";

    public static final String PAGE_AGE_EMI = "consulta/servdia_manter_listar_ageemi";

    public static final String PAGE_AGE_EMI_DET = "consulta/servdia_consultar_ageemi";

    public static final String PAGE_BLOQ_PRE = "consulta/servdia_consultar_blopreimp";

    public static final String PAGE_TIT_EMI = "consulta/servdia_manter_listar_emitit";

    public static final String PAGE_TIT_EMI_DET = "consulta/servdia_consultar_emitit";

    public static final String PAGE_EXT_MOV_TIT = "consulta/servdia_consultar_extmovtit";

    public static final String PAGE_EXT_CRE_DEB = "consulta/servdia_consultar_extdiscrdb";

    public static final String PAGE_LAN_TAR_MAN = "consulta/servdia_consultar_lantarman";

    public static final String PAGE_REI_TIT_BAI = "consulta/servdia_consultar_reititbai";

    public static final String PAGE_RED_ARQ_RET = "consulta/servdia_consultar_redarqret";

    public static final String PAGE_REE_BLO = "consulta/servdia_consultar_reeblo";

    public static final String PAGE_TODOS_CEDENTE = "consulta/servdia_consultar_todos";

    // transações
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

    public static final String TRANS_TODOS_CEDENTE = "BGDA";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
