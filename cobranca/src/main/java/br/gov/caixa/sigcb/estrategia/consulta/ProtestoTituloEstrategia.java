package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class ProtestoTituloEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.ProtestManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.ProtestManterFiltro";

    // beans genéricos
    public static final String MSG_BEAN = "msgBean";

    // beans
    public static final String FILTRO_BEAN = "protestoTituloFiltroBean";

    public static final String DATA_BEAN = "protestoTituloBean";

    // páginas
    public static final String PAGE_ERRO = "consulta/protest_erro";

    public static final String PAGE_FILTRO = "consulta/protest_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/protest_consultar";

    // Titles
    public static final String PAGE_TITLE = "Consultar Protesto de Títulos";

    public static final String PAGE_TITLE_FILTRO = "Consultar Protesto de Títulos >> Filtro";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String TRANSACAO_CONSULTAR = "BGB7";

    public static final Long SELECAO_RADIO_TIT_A_SEREM_ENVIADOS = new Long(0);

    public static final Long SELECAO_RADIO_TIT_ENVIADOS = new Long(1);

    public static final Long SELECAO_RADIO_TIT_ENVIO_SUSPENSO = new Long(2);

    public static final Long SELECAO_RADIO_TIT_ENVIADOS_DIA = new Long(3);

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
