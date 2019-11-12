package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Contábil
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class ContabEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.ContabManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.ContabManterFiltro";

    // beans genéricos
    public static final String MSG_BEAN = "msgBean";

    // beans
    public static final String FILTRO_BEAN = "contabilFiltroBean";

    public static final String DATA_BEAN = "contabilBean";

    // páginas
    public static final String PAGE_ERRO = "consulta/contab_erro";

    public static final String PAGE_FILTRO = "consulta/contab_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/contab_consultar_opera";

    public static final String PAGE_CONSULTAR_SALDO = "consulta/contab_consultar_saldo";

    public static final String PAGE_CONSULTAR_POSICAO = "consulta/contab_consultar_posic";

    // Titles
    public static final String PAGE_TITLE = "Consultas Operacionais";

    public static final String PAGE_TITLE_FILTRO = "Consultas Operacionais >> Filtro";

    // Operacional -> Valores a Creditar
    public static final String PAGE_TITLE_PV = "Consultar Valores a Creditar (Unidade PV)";

    public static final String PAGE_TITLE_REC = "Consultar Valores a Creditar (Unidade RSRET)";

    public static final String PAGE_TITLE_CAIXA_PV = "Consultar Valores a Creditar (CAIXA - PV)";

    public static final String PAGE_TITLE_CAIXA_REC = "Consultar Valores a Creditar (CAIXA - RSRET)";

    // Saldo -> Renomeado na tela para Saldos Operacionais.
    public static final String PAGE_TITLE_SALDO_PV = "Consultar Saldos Operacionais (Unidade PV)";

    public static final String PAGE_TITLE_SALDO_REC = "Consultar Saldos Operacionais (Unidade RSRET)";

    public static final String PAGE_TITLE_SALDO_CAIXA_PV = "Consultar Saldos Operacionais (CAIXA - PV)";

    public static final String PAGE_TITLE_SALDO_CAIXA_REC = "Consultar Saldos Operacionais (CAIXA - RSRET)";

    // Posicao -> Renomeado na tela para Liquidações.
    public static final String PAGE_TITLE_POSICAO_PV = "Consultar Liquidações (Unidade PV)";

    public static final String PAGE_TITLE_POSICAO_REC = "Consultar Liquidações (Unidade RSRET)";

    public static final String PAGE_TITLE_POSICAO_CAIXA_PV = "Consultar Liquidações (CAIXA - PV)";

    public static final String PAGE_TITLE_POSICAO_CAIXA_REC = "Consultar Liquidações (CAIXA - RSRET)";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String TRANSACAO_CONSULTAR = "BGD8";

    public static final String TRANSACAO_CONSULTAR_SALDO = "BGD9";

    public static final String TRANSACAO_CONSULTAR_POSICAO = "BGE0";

    public static final Long SELECAO_RADIO_UNIDADE = new Long(0);

    public static final Long SELECAO_RADIO_CAIXA = new Long(1);

    public static final Long TIPO_CONSULTA_PV = new Long(1);

    public static final Long TIPO_CONSULTA_REC = new Long(2);

    public static final Long TIPO_CONSULTA_CAIXA_REC = new Long(3);

    public static final Long TIPO_CONSULTA_CAIXA_PV = new Long(4);

    public static final Long NAVEGACAO_PV = new Long(1);

    public static final Long NAVEGACAO_REC = new Long(2);

    public static final Long NAVEGACAO_CAIXA_REC = new Long(3);

    public static final Long NAVEGACAO_CAIXA_PV = new Long(4);

    public static final Long VALORES_A_CREDITAR = new Long(1);

    public static final Long SALDOS_OPERACIONAIS = new Long(2);

    public static final Long LIQUIDACOES = new Long(3);

    /***************************************************************************
     * public static final Long SELECAO_CONSULTA_OPERACIONAL = new Long(1);
     * public static final Long SELECAO_CONSULTA_SALDO = new Long(2); public
     * static final Long SELECAO_CONSULTA_POSICAO = new Long(3);
     */

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
