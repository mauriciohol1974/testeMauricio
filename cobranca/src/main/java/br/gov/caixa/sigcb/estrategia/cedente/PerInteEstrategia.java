package br.gov.caixa.sigcb.estrategia.cedente;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public abstract class PerInteEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FILTRO = "cedente.PerInteIncluirFiltro";

    public static final String STRATEGY_INCLUIR_INICIAR = "cedente.PerInteIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "cedente.PerInteIncluirFinalizar";

    public static final String STRATEGY_MANTER_LISTAR = "cedente.PerInteManterListar";

    public static final String STRATEGY_ALTERAR_INICIAR = "cedente.PerInteAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "cedente.PerInteAlterarFinalizar";

    public static final String STRATEGY_EXCLUIR = "cedente.PerInteExcluirFinalizar";

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Perfil Internet >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Perfil Internet";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Perfil Internet";

    public static final String PAGE_TITLE_ALTERAR = "Manter Perfil Internet >> Alterar";

    public static final String SUCESSO_INCLUIR = "Perfil Internet Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Perfil Internet Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Perfil Internet Excluído com Sucesso";

    public static final String PAGE_INCLUIR_FILTRO = "/cedente/perinte_incluir_filtro";

    public static final String PAGE_INCLUIR = "/cedente/perinte_incluir";

    public static final String PAGE_MANTER_LISTAR = "/cedente/perinte_manter_listar";

    public static final String PAGE_ALTERAR = "/cedente/perinte_alterar";

    public static final String PAGE_SUCESSO = "/cedente/perinte_sucesso";

    public static final String PAGE_ERRO = "/cedente/perinte_erro";

    public static final String TRANSACAO_LISTAR = "BGFG";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BGFH";

    public static final String TRANSACAO_EXCLUIR_VALIDAR = "BGFI";

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public static final String FILTRO_BEAN = "filtroPerInteBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "dataPerInteBean";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
