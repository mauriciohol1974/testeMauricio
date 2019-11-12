package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento do cedente -(EXTRATO)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public abstract class MCExtraEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_INICIAR = "consulta.MCExtraManterIniciar";

    public static final String STRATEGY_IMPRIMIR = "consulta.MCExtraManterImprimir";
    
    public static final String STRATEGY_FILTRO_ANTIGO = "consulta.MCExtraManterFiltroAntigo";
    
    public static final String STRATEGY_FILTRO = "consulta.MCExtraManterFiltro";

    // Beans
    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    public static final String BEAN_FILTRO = "mcextraBean";

    public static final String BEAN_DEBCRED = "debcredBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/mcextra_erro";

    public static final String PAGE_FILTRO = "consulta/mcextra_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/mcextra_consultar";
    
    public static final String PAGE_IMPRIMIR = "consulta/mcextra_imprimir";
    
    public static final String PAGE_CONSULTAR2 = "consulta/mcextra_consultar2";

    // Títulos
    public static final String TITLE = "Consultar Movimento do Cedente (Extrato)";

    // transações
    public static final String TRANSACAO_TITULOS = "BGB0";

    public static final String TRANSACAO_DEB_CRED = "BGB1";

    public static final String TRANSACAO_LIQUIDACOES = "BGB2";

    public static final String TRANSACAO_CEDENTE = "BGM0";

    // List
    public static final String LIQUIDACAO_LIST = "liqList";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
