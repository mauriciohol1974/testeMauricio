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

public abstract class SacadoEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_INICIAR = "servico.SacadoIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FILTRO = "servico.SacadoIncluirFiltro";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.SacadoIncluirFinalizar";

    public static final String STRATEGY_MANTER_INICIAR = "servico.SacadoManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.SacadoManterFiltro";

    public static final String STRATEGY_ALTERAR_INICIAR = "servico.SacadoAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.SacadoAlterarFinalizar";

    public static final String STRATEGY_CONSULTAR = "servico.SacadoConsultarIniciar";

    public static final String STRATEGY_EXCLUIR = "servico.SacadoExcluirFinalizar";

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Sacado >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Sacado";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Sacado >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Sacado >> Listar";

    public static final String PAGE_TITLE_ALTERAR = "Manter Sacado >> Alterar";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Sacado >> Consultar";

    public static final String PAGE_TITLE_EXCLUIR = "Manter Sacado >> Excluir";

    public static final String SUCESSO_INCLUIR = "Sacado Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Sacado Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Sacado Excluído com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "sacadoBean";

    public static final String FILTRO_BEAN = "sacadoFiltroBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String PAGE_INCLUIR_FILTRO = "servico/sacado_incluir_filtro";

    public static final String PAGE_INCLUIR = "servico/sacado_incluir"; //

    public static final String PAGE_MANTER_FILTRO = "servico/sacado_manter_filtro";

    public static final String PAGE_MANTER_LISTAR_BCO = "servico/sacado_manter_listar_bcosac";

    public static final String PAGE_MANTER_LISTAR_SAC = "servico/sacado_manter_listar_sacado";

    public static final String PAGE_ALTERAR = "servico/sacado_alterar";

    public static final String PAGE_CONSULTAR = "servico/sacado_consultar";

    public static final String PAGE_ERRO = "servico/sacado_erro";

    public static final String PAGE_SUCESSO = "servico/sacado_sucesso";

    public static final String TRANSACAO_LISTAR_SACADO = "BG49";

    public static final String TRANSACAO_CONSULTAR_SACADO = "BG50";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG51";

    public static final String TRANSACAO_EXCLUIR_VALIDAR = "BG52";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    /*
     * SacadoBean.navegacao. normal = 0 filtro somente com o cedente preenchido =
     * 1 filtro somente com o numero do banco/cpf preenchido = 2 filtro
     * totalmente preenchido = 3
     */
    public static final Long NAVEGACAO_NORMAL = new Long(0);

    public static final Long NAVEGACAO_FILTRO_CEDENTE = new Long(1);

    public static final Long NAVEGACAO_FILTRO_NUMERO = new Long(2);

    public static final Long NAVEGACAO_FILTRO_TUDO = new Long(3);

    public static final Long NAVEGACAO_OUTRO = new Long(4);

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}