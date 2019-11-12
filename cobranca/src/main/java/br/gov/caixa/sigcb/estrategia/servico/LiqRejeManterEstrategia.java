package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Liquidacoes Rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */

public abstract class LiqRejeManterEstrategia extends SigcbEstrategia {

    // Codigos Tipo Opcao
    public static final Long OPCAO_ABERTO = new Long(1);

    public static final Long OPCAO_RECOMANDADAS = new Long(2);

    public static final Long OPCAO_RECOMANDADAS_ESPECIAL = new Long(9);

    public static final Long OPCAO_ESTORNADAS = new Long(7);

    public static final Long OPCAO_EXCLUIDAS = new Long(3);

    public static final Long OPCAO_RECOMANDOS_PROCESSADOS = new Long(4);

    public static final Long OPCAO_RECOMANDADAS_ESPECIAIS_PROCESSADAS = new Long(10);

    public static final Long OPCAO_ESTORNOS_PROCESSADOS = new Long(8);

    public static final Long OPCAO_EXCLUIDAS_PROCESSADAS = new Long(5);

    // Codigos de Meio Liquidacao
    public static final Long MEIO_AUTOMACAO = new Long(1);

    public static final Long MEIO_LOTERICAS = new Long(2);

    public static final Long MEIO_DIGITACAO = new Long(3);

    public static final Long MEIO_COMPENSACAO = new Long(4);

    public static final Long MEIO_CARTORIO = new Long(5);

    public static final Long MEIO_TODOS = new Long(99);

    // Codigos de Tipo de Carteira
    public static final Long CARTEIRA_REGISTRO_SINCE = new Long(4);

    public static final Long CARTEIRA_SEM_REGISTRO_SINCE = new Long(5);

    // Estrategias
    public static final String STRATEGY_INICIAR = "servico.LiqRejeManterIniciar";

    public static final String STRATEGY_LISTA = "servico.LiqRejeManterFiltro";

    public static final String STRATEGY_ACAO = "servico.LiqRejeAcaoIniciar";

    public static final String STRATEGY_CONSULTAR = "servico.LiqRejeConsultarIniciar";

    // Titulos de Paginas
    public static final String PAGE_TITLE = "Liquidações Rejeitadas";

    public static final String SUCESSO_RECOMANDO_ESPECIAL = "Recomando Especial Executado com Sucesso";

    public static final String SUCESSO_RECOMANDO = "Recomando Executado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Exclusão Executada com Sucesso";

    public static final String SUCESSO_ESTORNO = "Estorno Executado com Sucesso";

    public static final String SUCESSO_CANCELAMENTO = "Ação Cancelada com Sucesso";

    // Nomes de beans
    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "liqRejeBean";

    public static final String FILTRO_BEAN = "filtroLiqRejeBean";

    // Nomes de paginas
    public static final String PAGE_FILTRO = "servico/liqreje_manter_filtro";

    public static final String PAGE_LISTAR = "servico/liqreje_manter_listar";

    public static final String PAGE_RECOMANDO = "servico/liqreje_acao_recomando";

    public static final String PAGE_RECOMANDO_ESPECIAL = "servico/liqreje_acao_rec_altvalor";

    public static final String PAGE_CONSULTAR = "servico/liqreje_consultar";

    public static final String PAGE_SUCESSO = "servico/liqreje_sucesso";

    public static final String PAGE_ERRO = "servico/liqreje_erro";

    // Transacoes
    public static final String TRANSACAO_LISTAR = "BG81";

    public static final String TRANSACAO_EXECUTAR_ACAO = "BG82";

    // Acoes
    public static final String ACAO_RECOMANDO = "recomando";

    public static final String ACAO_RECOMANDO_ESPECIAL = "recomando_especial";

    public static final String ACAO_ESTORNO = "estorno";

    public static final String ACAO_EXCLUIR = "excluir";

    public static final String ACAO_CANCELAR = "cancelar";

    // Utilizadas na paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}
