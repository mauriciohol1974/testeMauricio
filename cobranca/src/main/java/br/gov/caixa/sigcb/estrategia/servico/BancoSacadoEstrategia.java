package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Sacados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public abstract class BancoSacadoEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_INICIAR = "servico.BcoSacaIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FILTRO = "servico.BcoSacaIncluirFiltro";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.BcoSacaIncluirFinalizar";

    public static final String STRATEGY_MANTER_INICIAR = "servico.BcoSacaManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.BcoSacaManterFiltro";

    public static final String STRATEGY_ALTERAR_INICIAR = "servico.BcoSacaAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.BcoSacaAlterarFinalizar";

    public static final String STRATEGY_CONSULTAR = "servico.BcoSacaConsultarIniciar";

    public static final String STRATEGY_EXCLUIR = "servico.BcoSacaExcluirFinalizar";

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Banco de Sacados >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Banco de Sacados";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Banco de Sacados >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Banco de Sacados >> Listar";

    public static final String PAGE_TITLE_ALTERAR = "Manter Banco de Sacados >> Alterar";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Banco de Sacados >> Consultar";

    public static final String PAGE_TITLE_EXCLUIR = "Manter Banco de Sacados >> Excluir";

    public static final String SUCESSO_INCLUIR = "Banco de Sacados Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Banco de Sacados Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Banco de Sacados Excluído com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "bancoSacadoBean";

    public static final String FILTRO_BEAN = "bancoSacadoFiltroBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String PAGE_INCLUIR_FILTRO = "servico/bcosaca_incluir_filtro";

    public static final String PAGE_INCLUIR = "servico/bcosaca_incluir";

    public static final String PAGE_MANTER_FILTRO = "servico/bcosaca_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "servico/bcosaca_manter_listar";

    public static final String PAGE_ALTERAR = "servico/bcosaca_alterar";

    public static final String PAGE_CONSULTAR = "servico/bcosaca_consultar";

    public static final String PAGE_ERRO = "servico/bcosaca_erro";

    public static final String PAGE_SUCESSO = "servico/bcosaca_sucesso";

    public static final String TRANSACAO_LISTAR_BANCO_SACADO = "BG46";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG47";

    public static final String TRANSACAO_EXCLUIR_VALIDAR = "BG48";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    /*
     * BancoSacadoBean.navegacao. normal = 0 filtro = 1 filtro numero banco = 2
     */
    public static final Long NAVEGACAO_NORMAL = new Long(0);

    public static final Long NAVEGACAO_FILTRO = new Long(1);

    public static final Long NAVEGACAO_FILTRO_BANCO = new Long(2);

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}