package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Tarifa Manual
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */

public abstract class TarifaManterEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_MANTER_FILTRO = "servico.TarifaManterIniciar";

    public static final String STRATEGY_MANTER_LISTAR = "servico.TarifaManterFiltro";

    public static final String STRATEGY_EXCLUIR = "servico.TarifaExcluirFinalizar";

    public static final String PAGE_TITLE_MANTER = "Manter Lan�amento de Tarifa Manual";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Lan�amento de Tarifa Comandada >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Lan�amento de Tarifa Comandada >> Listar";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Lan�amento de Tarifa Comandada >> Consultar";

    public static final String PAGE_TITLE_EXCLUIR = "Manter Lan�amento de Tarifa Comandada >> Excluir";

    public static final String SUCESSO_INCLUIR = "Tarifa Comandada Inclu�da com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Tarifa Comandada Exclu�da com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "tarifaBean";

    public static final String FILTRO_BEAN = "filtroTarifaBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String PAGE_INCLUIR_FILTRO = "servico/tarifa_incluir_filtro";

    public static final String PAGE_MANTER_FILTRO = "servico/tarifa_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "servico/tarifa_manter_listar";

    public static final String PAGE_CONSULTAR = "servico/tarifa_consultar";

    public static final String PAGE_INCLUIR = "servico/tarifa_incluir";

    public static final String PAGE_SUCESSO = "servico/tarifa_sucesso";

    public static final String PAGE_ERRO = "servico/tarifaManter_erro";

    public static final String TRANSACAO_LISTAR = "BG91";

    public static final String TRANSACAO_INCLUIR = "BG92";

    public static final String TRANSACAO_EXCLUIR = "BG93";
    
    public static final String TRANSACAO_CONSULTAR = "BG94";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
