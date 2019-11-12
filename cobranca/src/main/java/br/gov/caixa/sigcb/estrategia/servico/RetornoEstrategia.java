package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade ArquivoRemessa
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public abstract class RetornoEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_MANTER_INICIAR = "servico.RetornoParcialManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.RetornoManterFiltro";

    public static final String STRATEGY_MANTER_DETALHE = "servico.RetornoManterDetalhe";

    public static final String STRATEGY_MANTER_ACAO = "servico.ArqRemeManterAcao";

    public static final String PAGE_TITLE_MANTER_FILTRO = " Retorno Parcial >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Retorno Parcial >> Listar";

    public static final String PAGE_TITLE_MANTER_LISTAR_CED = "Retorno Parcial (Arquivo) >> Listar";

    public static final String PAGE_TITLE_MANTER_DETALHE = "Retorno Parcial >> Consulta Detalhada";

    public static final String PAGE_TITLE_MANTER_ACAO = "Retorno Parcial";

    public static final String SUCESSO_SOLICITAR = "Ação Executada com Sucesso";

    public static final String PAGE_MANTER_FILTRO = "/servico/retorno_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "/servico/retorno_manter_listar_cedente";

    public static final String PAGE_ERRO = "/servico/retorno_erro";

    public static final String TRANSACAO_LISTAR = "BG41";

    public static final String TRANSACAO_LISTAR_CED = "BG42";

    public static final String TRANSACAO_CONSULTAR_DETALHE = "BG43";

    public static final String TRANSACAO_ACAO_REMESSA = "BG44";

    public static final String TRANSACAO_VALIDAR_CEDENTE = "BGM0";

    public static final String TRANSACAO_CONS_UNIDADE = "BGM1";

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public static final String FILTRO_BEAN = "filtroArqRemBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "filtroArqBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabBean";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
