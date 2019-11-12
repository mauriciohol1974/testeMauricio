package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade CONSULTAS GERENCIAS
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class GerencEstrategia extends SigcbEstrategia {

    // Título
    public static final String PAGE_TITLE = "Consultas Gerenciais";

    public static final String PAGE_TITLE_FILTRO = "Consultas Gerenciais >> Filtro";

    public static final String PAGE_TITLE_PV = "Consultas Gerenciais (PV) >> Listar";

    public static final String PAGE_TITLE_EN = "Consultas Gerenciais (EN) >> Listar";

    public static final String PAGE_TITLE_CAIXA = "Consultas Gerenciais (Geral) >> Listar";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR = "consulta.GerencManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.GerencManterFiltro";

    // beans
    public static final String BEAN_FILTRO = "filtroBean";

    public static final String BEAN_FIXO = "fixoBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/gerenc_erro";

    public static final String PAGE_CONSULTAR = "consulta/gerenc_consultar";

    public static final String PAGE_FILTRO = "consulta/gerenc_manter_filtro";

    public static final String PAGE_LISTAR = "consulta/gerenc_manter_listar";

    public static final String PAGE_BLOQUETOS_LASER_PADRAO = "consulta/gerenc_consultar_blolascai";

    public static final String PAGE_BLOQUETOS_PRE_IMPRESSOS = "consulta/gerenc_consultar_blopreimp";

    public static final String PAGE_BLOQUETOS_CARNES_LASER = "consulta/gerenc_consultar_blocarlascai";

    public static final String PAGE_BLOQUETOS_PERSONALIZADOS = "consulta/gerenc_consultar_blopers";

    public static final String PAGE_CEDENTES_PADRAO_CNAB = "consulta/gerenc_consultar_cedpadcna";

    public static final String PAGE_CEDENTES_MEIO_ENTRADA = "consulta/gerenc_consultar_cedmeient";

    public static final String PAGE_CEDENTES_SIT_TESTE_PROD = "consulta/gerenc_consultar_cedsitmov";

    public static final String PAGE_MOVIMENTO_TP_VAN = "consulta/gerenc_consultar_cedmovtipvan";

    public static final String PAGE_POSICAO_PV_EN_RECEBEDOR = "consulta/gerenc_consultar_prcposunirec";

    public static final String PAGE_POSICAO_PV_EN_VINCULACAO = "consulta/gerenc_consultar_prcposunivin";

    public static final String PAGE_MOV_TITULOS = "consulta/gerenc_consultar_qtmovtit";

    public static final String PAGE_MOV_TITULOS_TARIFA_FLOAT = "consulta/gerenc_consultar_qtmovtittar";

    public static final String PAGE_POSICAO_TIT_CART_SERVICO = "consulta/gerenc_consultar_qtpostitcar";

    public static final String PAGE_TITULOS_INCLUIDOS = "consulta/gerenc_consultar_qttitinc";

    public static final String PAGE_TITULOS_INCLUIDOS_DET = "consulta/gerenc_consultar_qttitinc_det";

    public static final String PAGE_TITULOS_INCLUIDOS_LIQ = "consulta/gerenc_consultar_qttitincliq";

    public static final String PAGE_TITULOS_LIQ_FLOAT_ZERO = "consulta/gerenc_consultar_qttitflozer";

    public static final String PAGE_TITULOS_LIQ_SERVICOS_MEIO_LIQ = "consulta/gerenc_consultar_qttitliqser";
    
    public static final String PAGE_TITULOS_LIQ_IOF = "consulta/gerenc_consultar_qttitliqiof";

    public static final String PAGE_EMISSAO_POST_BLOQ_EXTRATO = "consulta/gerenc_consultar_taremipos";

    public static final String PAGE_LIQ_SERVICOS_MEIO_LIQ = "consulta/gerenc_consultar_tarliqser";

    public static final String PAGE_PROTESTO_TITULOS = "consulta/gerenc_consultar_tarprotit";

    public static final String PAGE_SERVICOS_DIVERSOS = "consulta/gerenc_consultar_tarserdiv";

    public static final String PAGE_TOTAL_TARIFAS = "consulta/gerenc_consultar_tartottar";

    // transação
    public static final String TRANS_LISTAR_EN = "BGF0";

    public static final String TRANS_LISTAR_PV = "BGF1";

    public static final String TRANS_LISTAR_CED = "BGF2";

    public static final String TRANS_BLOQ_LASER = "BGF3";

    public static final String TRANS_BLOQ_PRE_IMP = "BGF4";

    public static final String TRANS_BLOQ_CARNE = "BGF5";

    public static final String TRANS_BLOQ_PERSONALIZADOS = "BGH5";

    public static final String TRANS_CED_CNAB = "BGF6";

    public static final String TRANS_CED_MEIO_ENT = "BGF7";

    public static final String TRANS_CED_SIT_TESTE = "BGF8";

    public static final String TRANS_MOV_COB_TP_VAN = "BGF9";

    public static final String TRANS_PRCOTAR_RECEB = "BGG0";

    public static final String TRANS_PRCOTAR_VINC = "BGG1";

    public static final String TRANS_MOVTIT = "BGG2";

    public static final String TRANS_MOVTIT_TAR_FLT = "BGG3";

    public static final String TRANS_POSTIT_SERVICOS = "BGG4";

    public static final String TRANS_TITINC = "BGG5";

    public static final String TRANS_TITINC_DET = "BGG6";

    public static final String TRANS_TITINC_TP_COBR = "BGG7";

    public static final String TRANS_TITLIQ_FLT_ZERO = "BGG8";

    public static final String TRANS_TITLIQ_SERVICO = "BGG9";
    
    public static final String TRANS_TITLIQ_IOF = "BGH9";

    public static final String TRANS_EMIPOS_EXTRATO = "BGH0";

    public static final String TRANS_TARLIQ_SERVICO = "BGH1";

    public static final String TRANS_PROT_TIT = "BGH2";

    public static final String TRANS_SERVICOS_DIV = "BGH3";

    public static final String TRANS_TOTAL_TARIFAS = "BGH4";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    // Tipos de consulta
    public static final Long TIPO_CONSULTA_CEDENTE = new Long(1);

    public static final Long TIPO_CONSULTA_PV = new Long(2);

    public static final Long TIPO_CONSULTA_EN = new Long(3);

    public static final Long TIPO_CONSULTA_CAIXA = new Long(4);

    // Navegacao
    public static final Long NAVEGACAO_CEDENTE = new Long(1);

    public static final Long NAVEGACAO_PV = new Long(2);

    public static final Long NAVEGACAO_EN = new Long(3);

    public static final Long NAVEGACAO_CAIXA = new Long(4);

    public static final Long CONSOLIDADO_NAO = new Long(0);

    public static final Long CONSOLIDADO_SIM = new Long(1);

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}