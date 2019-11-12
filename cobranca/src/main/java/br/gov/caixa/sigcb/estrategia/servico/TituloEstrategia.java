package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Borderô OnLine >>
 * Titulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public abstract class TituloEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR = "servico.TituloIncluirIniciar";

    public static final String STRATEGY_INCLUIR_EFETIVAR = "servico.TituloIncluirFinalizar";

    public static final String STRATEGY_ALTERAR = "servico.TituloAlterarIniciar";

    public static final String STRATEGY_ALTERAR_EFETIVAR = "servico.TituloAlterarFinalizar";

    public static final String STRATEGY_EXCLUIR = "servico.TituloExcluirFinalizar";

    public static final String STRATEGY_MANTER_LISTAR = "servico.BorderoManterFiltro";

    public static final String STRATEGY_CONSULTAR = "servico.TituloConsultarIniciar";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter Borderô";

    public static final String PAGE_TITLE_INCLUIR = "Manter Borderô >> Incluir Título";

    public static final String PAGE_TITLE_ALTERAR = "Manter Borderô >> Alterar Título";

    public static final String PAGE_TITLE_CONSULTAR = "Manter Borderô >> Consultar Título";

    public static final String SUCESSO_INCLUIR = "Título Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Título Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Título Excluído com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "tituloBean";

    public static final String FIXO_BEAN = "tituloFixoBean";

    public static final String BORDERO_BEAN = "borderoBean";

    public static final String BORDERO_INFO_BEAN = "borderoInfoBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String PAGE_TITULO_MANTER_LISTAR = "servico/titulo_manter_listar";

    public static final String PAGE_INCLUIR = "servico/titulo_incluir";

    public static final String PAGE_ALTERAR = "servico/titulo_alterar";

    public static final String PAGE_CONSULTAR = "servico/titulo_consultar";

    public static final String PAGE_ERRO = "servico/titulo_erro";

    public static final String PAGE_SUCESSO = "servico/titulo_sucesso";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG77";

    public static final String TRANSACAO_EXCLUIR = "BG78";

    public static final String TRANSACAO_BORDERO_INFO = "BG79";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    /***************************************************************************
     * BorderoBean.navegacao. normal = 0 incluir = 1 excluir = 2 alterar = 3
     **************************************************************************/
    public static final Long NAVEGACAO_NORMAL = new Long(0);

    public static final Long NAVEGACAO_INCLUIR = new Long(1);

    public static final Long NAVEGACAO_EXCLUIR = new Long(2);

    public static final Long NAVEGACAO_ALTERAR = new Long(3);

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}