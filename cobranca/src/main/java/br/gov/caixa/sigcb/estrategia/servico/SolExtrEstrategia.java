package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bloqueto On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public abstract class SolExtrEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.SolExtrIncluirFinalizar";

    public static final String STRATEGY_MANTER_INICIAR = "servico.SolExtrManterIniciar";//

    public static final String STRATEGY_MANTER_FILTRO = "servico.SolExtrManterFiltro";//

    public static final String STRATEGY_ALTERAR_INICIAR = "servico.SolExtrAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.SolExtrAlterarFinalizar";

    public static final String STRATEGY_EXCLUIR = "servico.SolExtrExcluirFinalizar";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Solicitar 2a. via de Extrato >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Solicitar 2a. via de Extrato >> Incluir";

    public static final String PAGE_TITLE_CONSULTAR = "Solicitar 2a. via de Extrato >> Consultar";

    public static final String PAGE_TITLE_ALTERAR = "Solicitar 2a. via de Extrato >> Alterar";

    public static final String PAGE_TITLE_EXCLUIR = "Solicitar 2a. via de Extrato >> Excluir";

    public static final String SUCESSO_INCLUIR = "Solicitação de Segunda Via de Extrato Incluída com Sucesso";

    public static final String SUCESSO_ALTERAR = "Solicitação de Segunda Via de Extrato Alterada com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Solicitação de Segunda Via de Extrato Excluída com Sucesso";

    public static final String PAGE_INCLUIR = "/servico/solextr_incluir";

    public static final String PAGE_MANTER_FILTRO = "/servico/solextr_manter_filtro";

    public static final String PAGE_CONSULTAR = "/servico/solextr_consultar";

    public static final String PAGE_ALTERAR = "/servico/solextr_alterar";

    public static final String PAGE_SUCESSO = "/servico/solextr_sucesso";

    public static final String PAGE_ERRO = "/servico/solextr_erro";

    public static final String TRANSACAO_CONSULTAR = "BG86";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG87";

    public static final String TRANSACAO_EXCLUIR = "BG88";

    public static final String TRANSACAO_VALIDAR_CEDENTE = "BGM0";

    public static final String FILTRO_BEAN = "filtroSoltExtrBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "soltExtrBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabBean";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
