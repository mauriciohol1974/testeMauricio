package br.gov.caixa.sigcb.estrategia.cedente;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public abstract class CedenteAlterarEnderecoSicliEstrategia extends
        SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_ALTERAR_INICIAR = "cedente.CedenteAlterarEnderecoSicliIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "cedente.CedenteAlterarEnderecoSicliFinalizar";

    public static final String STRATEGY_REDIRECT_ERROR = "cedente.CedenteManterIniciar";

    // beans genericos
    public static final String MSG_BEAN = "msgBean";

    // páginas comuns
    public static final String PAGE_JSP_ERRO = "cedente/ced_alterar_endereco_sicli_erro";

    public static final String PAGE_JSP_ALTERAR = "cedente/ced_alterar_endereco_sicli";

    // Titles
    public static final String PAGE_TITLE_ALTERAR = "Manter Cedente >> Alterar Dados";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String TRANSACAO_CEDENTE_CONSULTA_CEDENTE = "BG39";

    public static final String TRANSACAO_CEDENTE_ALTERAR_CEDENTE = "BG40";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_JSP_ERRO;
    }
}
