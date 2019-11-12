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
public abstract class TituloOnLineEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_MANTER_INICIAR = "servico.TituloOnLineIncluir";

    public static final String STRATEGY_MANTER_FILTRO = "servico.TituloOnLineManter";
    
    public static final String STRATEGY_MANTER_LISTAR = "servico.TituloOnLineListar";

    public static final String STRATEGY_MANTER_ACAO_ALTERAR = "servico.TituloOnLineAlterar";
    
    public static final String STRATEGY_MANTER_ACAO_INCLUIR_EXECUTAR = "servico.TituloOnLineIncluirExecutar";
    
    public static final String STRATEGY_MANTER_ACAO_ALTERAR_EXECUTAR = "servico.TituloOnLineAlterarExecutar";
    
    public static final String STRATEGY_MANTER_ACAO_EXCLUIR_EXECUTAR = "servico.TituloOnLineExcluirExecutar";
    
    public static final String STRATEGY_MANTER_ACAO_EXCLUIR= "servico.TituloOnLineExcluir";
    
    public static final String STRATEGY_MANTER_ACAO_CONSULTAR= "servico.TituloOnLineConsultar";
    
    public static final String STRATEGY_CONFIRMAR = "servico.TituloOnLineConfirmar";
    
    public static final String STRATEGY_ALTERAR_CONFIRMAR = "servico.TituloOnLineAlterarConfirmar";
    
    
    public static final String STRATEGY_INCLUIR_FILTRO = "servico.TituloOnLineIncluirExecutarAcao1";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter LOG/Liquidação On-Line >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Manter LOG/Liquidação On-Line >> Lista";

    public static final String PAGE_TITLE_MANTER_DETALHE = "Consultar LOG/Liquidação On-Line";

    public static final String PAGE_TITLE_MANTER_ALTERAR = "Alterar LOG/Liquidação On-Line";
    
    public static final String PAGE_TITLE_INCLUIR = "Incluir LOG/Liquidação On-Line";
    
    public static final String PAGE_TITLE_MANTER_EXCLUIR = "Excluir LOG/Liquidação On-Line";

    public static final String PAGE_INCLUIR_FILTRO = "/servico/tituloOnline_incluir";
    
    public static final String PAGE_INCLUIR_CONFIRMA = "/servico/tituloOnline_confirmar";
    
    public static final String PAGE_INCLUIR_SUCESSO = "/servico/tituloOnLine_incluir_sucesso";
    
    public static final String PAGE_ALTERAR_SUCESSO = "/servico/tituloOnLine_alterar_sucesso";
    
    public static final String PAGE_EXCLUIR_SUCESSO = "/servico/tituloOnLine_excluir_sucesso";
    
    public static final String PAGE_ALTERAR_CONFIRMA = "/servico/tituloOnline_alterar_confirmar";
    
    public static final String PAGE_MANTER_FILTRO = "/servico/tituloOnline_manter_Filtro";

    public static final String PAGE_MANTER_LISTAR = "/servico/tituloOnline_manter_listar";

    public static final String PAGE_MANTER_CONSULTAR = "/servico/tituloOnline_consultar";
    
    public static final String PAGE_MANTER_ALTERAR = "/servico/tituloOnline_alterar";
    
    public static final String PAGE_MANTER_EXCLUIR = "/servico/tituloOnline_excluir";

    public static final String PAGE_ERRO = "/servico/tituloOnLine_erro";

    public static final String TRANSACAO_LISTAR = "BGNS";

    public static final String TRANSACAO_CONSULTAR = "BGNT";

    public static final String TRANSACAO_INCLUIR_ACAO1 = "BGNQ";
    
    public static final String TRANSACAO_EXECUTAR_EXCLUIR = "BGNR";

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public static final String FILTRO_BEAN = "LiquidacaoOnlineBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabBean";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
