package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public abstract class CedRejeitadoSicliEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_FILTRO = "consulta.CedRejeitadoSicliFiltro";

    public static final String STRATEGY_MANTER_LISTAR = "consulta.CedRejeitadoSicliListar";

    public static final String STRATEGY_MANTER_RETORNO = "consulta.CedRejeitadoSicliRetorno";

    // beans genericos
    public static final String MSG_BEAN = "msgBean";

    // páginas comuns
    public static final String PAGE_JSP_ERRO = "consulta/ced_rejeitado_sicli_erro";

    public static final String PAGE_JSP_FILTRO = "consulta/ced_rejeitado_sicli_filtro";

    public static final String PAGE_JSP_LISTAR = "consulta/ced_rejeitado_sicli_lista";

    public static final String PAGE_JSP_RETORNO = "consulta/ced_rejeitado_sicli_retorno";

    // Titles
    public static final String PAGE_TITLE_FILTRO = "Cedentes Rejeitados SICLI >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "Cedentes Rejeitados SICLI >> Listar";

    public static final String PAGE_TITLE_RETORNO = "Cedentes Rejeitados SICLI >> Retorno";

    public static final String PAGE_TITLE_CONSULTA = "Cedentes Rejeitados SICLI";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String TRANSACAO_CEDENTE_REJEITADO_LISTAR = "BG0C";

    public static final String TRANSACAO_CEDENTE_REJEITADO_RETORNO = "BG0D";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_JSP_ERRO;
    }

}
