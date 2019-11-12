package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade
 * Solicita��o/Agendamento de Emiss�o de Titulo
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
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

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Solicita��o/Agendamento de Emiss�o de T�tulo >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Solicita��o/Agendamento de Emiss�o de T�tulo";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Solicita��o/Agendamento de Emiss�o de T�tulo >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Solicita��o/Agendamento de Emiss�o de T�tulo >> Listar";

    public static final String PAGE_TITLE_ALTERAR = "Manter Solicita��o/Agendamento de Emiss�o de T�tulo >> Alterar";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Solicita��o/Agendamento de Emiss�o de T�tulo >> Consultar";

    public static final String PAGE_TITLE_EXCLUIR = "Manter Solicita��o/Agendamento de Emiss�o de T�tulo >> Excluir";

    public static final String SUCESSO_INCLUIR = "Solicita��o/Agendamento Inclu�do com Sucesso";

    public static final String SUCESSO_ALTERAR = "Solicita��o/Agendamento Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Solicita��o/Agendamento Exclu�do com Sucesso";

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
     * Solicita��oAgendamentoBean.navegacao. P�gina de filtro = 0 P�gina com a
     * lista de Banco de Sacados = 1 P�gina com a lista de
     * Solicita��es/Agendamentos = 2 Qualquer outra p�gina = 3
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