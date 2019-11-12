package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;


/**
 * <B>Projeto: SIGCB</B><BR>
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abril/2013</DD>
 * </DL>
 * 
 * @author Maurício Assis de Holanda
 */

public abstract class LiqStrManterEstrategia extends SigcbEstrategia {

   
    // Estrategias
    public static final String STRATEGY_INICIAR = "servico.LiqStrIniciar";

    public static final String STRATEGY_LISTA = "servico.LiqStrManterFiltro";

    public static final String STRATEGY_RECOMANDO = "servico.LiqStrRecomando";

    public static final String STRATEGY_CONSULTAR = "servico.LiqStrConsultar";
    
    public static final String STRATEGY_RECOMANDO_EFETIVAR = "servico.LiqStrRecomandoEfetivar";

    // Titulos de Paginas
    public static final String PAGE_TITLE = "Liquidações via STR ";

   
    // Nomes de beans
    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "liqSTReBean";

    public static final String FILTRO_BEAN = "filtroLiqSTRBean";

    // Nomes de paginas
    public static final String PAGE_FILTRO = "servico/liqSTRFiltro";

    public static final String PAGE_LISTAR = "servico/liqSTRmanter_listar";

    public static final String PAGE_RECOMANDO = "servico/liqSTR_recomando";
  
    public static final String PAGE_CONSULTAR = "servico/liqSTR_consultar";

    public static final String PAGE_SUCESSO = "servico/liqSTRsucesso";
    
    public static final String PAGE_ERRO = "servico/liqSTR_erro";

    // Transacoes
    public static final String TRANSACAO_LISTAR = "BGZG";

    public static final String TRANSACAO_EXECUTAR_ACAO = "BGZI";
    
    public static final String TRANSACAO_CONSULTAR = "BGZH";

   
    // Utilizadas na paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}
