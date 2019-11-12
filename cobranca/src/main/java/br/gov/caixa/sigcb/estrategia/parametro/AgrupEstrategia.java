package br.gov.caixa.sigcb.estrategia.parametro;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Agrupamento de
 * Servicos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public abstract class AgrupEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FILTRO = "parametro.AgrupIncluirIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "parametro.AgrupManterIniciar";

    public static final String STRATEGY_MANTER_LISTAR = "parametro.AgrupManterFiltro";

    public static final String STRATEGY_INCLUIR = "parametro.AgrupIncluirFiltro";

    public static final String STRATEGY_ALTERAR = "parametro.AgrupAlterarIniciar";

    public static final String STRATEGY_EXCLUIR = "parametro.AgrupExcluirFinalizar";

    public static final String STRATEGY_INCLUIR_SUCESSO = "parametro.AgrupIncluirFinalizar";

    public static final String STRATEGY_ALTERAR_SUCESSO = "parametro.AgrupAlterarFinalizar";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Agrupamento de Serviços";

    public static final String PAGE_TITLE_MANTER = "Manter Agrupamento de Serviços";

    public static final String SUCESSO_INCLUIR = "Agrupamento de Serviços Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Agrupamento de Serviços Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Agrupamento de Serviços Excluído com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "agrupBean";

    public static final String FILTRO_BEAN = "filtroAgrupBean";

    public static final String PAGE_INCLUIR_FILTRO = "parametro/agrup_incluir_filtro";

    public static final String PAGE_MANTER_FILTRO = "parametro/agrup_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "parametro/agrup_manter_listar";

    public static final String PAGE_ALTERAR = "parametro/agrup_alterar";

    public static final String PAGE_INCLUIR = "parametro/agrup_incluir";

    public static final String PAGE_SUCESSO = "parametro/agrup_sucesso";

    public static final String PAGE_ERRO = "parametro/agrup_erro";

    public static final String TRANSACAO_LISTAR = "BGK0";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BGK1";

    public static final String TRANSACAO_VALIDAR_EXCLUIR = "BGK2";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
