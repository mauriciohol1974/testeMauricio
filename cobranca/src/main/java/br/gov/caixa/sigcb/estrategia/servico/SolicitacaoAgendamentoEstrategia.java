package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade
 * Solicitação/Agendamento de Emissão de Titulo
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public abstract class SolicitacaoAgendamentoEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_INICIAR = "servico.SoAgTitIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FILTRO = "servico.SoAgTitIncluirFiltro";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.SoAgTitIncluirFinalizar";

    public static final String STRATEGY_MANTER_INICIAR = "servico.SoAgTitManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.SoAgTitManterFiltro";

    public static final String STRATEGY_ALTERAR_INICIAR = "servico.SoAgTitAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.SoAgTitAlterarFinalizar";

    public static final String STRATEGY_CONSULTAR = "servico.SoAgTitConsultarIniciar";

    public static final String STRATEGY_EXCLUIR = "servico.SoAgTitExcluirFinalizar";

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Solicitação/Agendamento de Emissão de Título >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Solicitação/Agendamento de Emissão de Título";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Solicitação/Agendamento de Emissão de Título >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Solicitação/Agendamento de Emissão de Título >> Listar";

    public static final String PAGE_TITLE_ALTERAR = "Manter Solicitação/Agendamento de Emissão de Título >> Alterar";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Solicitação/Agendamento de Emissão de Título >> Consultar";

    public static final String PAGE_TITLE_EXCLUIR = "Manter Solicitação/Agendamento de Emissão de Título >> Excluir";

    public static final String SUCESSO_INCLUIR = "Solicitação/Agendamento Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Solicitação/Agendamento Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Solicitação/Agendamento Excluído com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "solicitacaoBean";

    public static final String FILTRO_BEAN = "solicitacaoFiltroBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String CEDENTE_GERAL_BEAN = "cedGeralBean";

    public static final String CEDENTE_BLOQUETO_BEAN = "cedBloqBean";

    public static final String PAGE_INCLUIR_FILTRO = "servico/soagtit_incluir_filtro";//

    public static final String PAGE_INCLUIR = "servico/soagtit_incluir"; //

    public static final String PAGE_MANTER_FILTRO = "servico/soagtit_manter_filtro";

    public static final String PAGE_MANTER_LISTAR_BCO = "servico/soagtit_manter_listar_bcosac";

    public static final String PAGE_MANTER_LISTAR = "servico/soagtit_manter_listar";

    public static final String PAGE_ALTERAR = "servico/soagtit_alterar";

    public static final String PAGE_CONSULTAR = "servico/soagtit_consultar";

    public static final String PAGE_ERRO = "servico/soagtit_erro";

    public static final String PAGE_SUCESSO = "servico/soagtit_sucesso";

    public static final String TRANSACAO_LISTAR_BANCO_SACADO = "BG53";

    public static final String TRANSACAO_LISTAR_SOLICITACAO_AGENDAMENTO = "BG54";

    public static final String TRANSACAO_CONSULTAR_SOLICITACAO_AGENDAMENTO = "BG55";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG56";

    public static final String TRANSACAO_EXCLUIR_VALIDAR = "BG57";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_CEDENTE_GERAL = "BG03";

    public static final String TRANSACAO_CEDENTE_BLOQUETOS = "BG11";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    /*
     * SolicitaçãoAgendamentoBean.navegacao. Página de filtro = 0 Página com a
     * lista de Banco de Sacados = 1 Página com a lista de
     * Solicitações/Agendamentos = 2 Qualquer outra página = 3
     */
    public static final Long NAVEGACAO_FILTRO = new Long(0);

    public static final Long NAVEGACAO_LISTA_1 = new Long(1);

    public static final Long NAVEGACAO_LISTA_2 = new Long(2);

    public static final Long NAVEGACAO_OUTRO = new Long(3);

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}