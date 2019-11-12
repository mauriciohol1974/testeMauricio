package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bloqueto On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public abstract class BloquetEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_INICIAR = "servico.BloquetIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FILTRO = "servico.BloquetIncluirFiltro";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.BloquetIncluirFinalizar";

    public static final String STRATEGY_MANTER_INICIAR = "servico.BloquetManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.BloquetManterFiltro";

    public static final String STRATEGY_ALTERAR_INICIAR = "servico.BloquetAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.BloquetAlterarFinalizar";

    public static final String STRATEGY_EXCLUIR = "servico.BloquetExcluirFinalizar";

    public static final String STRATEGY_CONSULTAR_INICIAR = "servico.BloquetConsultarIniciar";

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Solicitação de Bloquetos On-Line >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Solicitação de Bloquetos On-Line";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Solicitação de Bloquetos On-Line >> Filtro";

    public static final String PAGE_TITLE_MANTER = "Manter Solicitação de Bloquetos On-Line";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Solicitação de Bloquetos On-Line >> Consultar";

    public static final String PAGE_TITLE_ALTERAR = "Manter Solicitação de Bloquetos On-Line >> Alterar";

    public static final String SUCESSO_INCLUIR = "Bloqueto On-Line Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Bloqueto On-Line Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Bloqueto On-Line Excluído com Sucesso";

    public static final String PAGE_INCLUIR_FILTRO = "/servico/bloquet_incluir_filtro";

    public static final String PAGE_INCLUIR = "/servico/bloquet_incluir";

    public static final String PAGE_MANTER_FILTRO = "/servico/bloquet_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "/servico/bloquet_manter_listar";

    public static final String PAGE_CONSULTAR = "/servico/bloquet_consultar";

    public static final String PAGE_ALTERAR = "/servico/bloquet_alterar";

    public static final String PAGE_SUCESSO = "/servico/bloquet_sucesso";

    public static final String PAGE_ERRO = "/servico/bloquet_erro";

    public static final String TRANSACAO_VALIDAR_CEDENTE = "BGM0";

    public static final String TRANSACAO_LISTAR = "BGFU";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BGFV";

    public static final String TRANSACAO_VALIDAR_EXCLUIR = "BGFW";

    public static final String FILTRO_BEAN = "filtroBloqBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "bloqBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabBean";

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
