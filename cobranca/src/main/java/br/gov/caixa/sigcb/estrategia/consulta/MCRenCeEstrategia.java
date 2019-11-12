package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Movimento de cobrança -
 * Rentabilidade do cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public abstract class MCRenCeEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_INICIAR = "consulta.MCRenCeManterIniciar";

    public static final String STRATEGY_FILTRO = "consulta.MCRenCeManterFiltro";

    // Beans
    public static final String BEAN_MSG = "msgBean";

    public static final String BEAN_CABECALHO = "cedCabBean";

    public static final String BEAN_FILTRO = "mcrenceBean";

    public static final String BEAN_FIXO = "mcrenceFixoBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/mcrence_erro";

    public static final String PAGE_FILTRO = "consulta/mcrence_manter_filtro";

    public static final String PAGE_CONSULTAR = "consulta/mcrence_consultar";

    // Títulos
    public static final String TITLE = "Consultar rentabilidade do Cedente";

    // transações
    public static final String TRANS_RENTA = "BGB4";

    public static final String TRANS_CANAL = "BGB5";

    public static final String TRANS_COM_MAN = "BGB6";

    public static final String TRANS_CEDENTE = "BGM0";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}
