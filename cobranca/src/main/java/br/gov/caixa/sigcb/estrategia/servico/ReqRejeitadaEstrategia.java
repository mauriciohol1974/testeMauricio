package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class ReqRejeitadaEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "servico.ReqRejeitadaIniciar";
    
    public static final String STRATEGY_MANTER_INICIAR_TITULO = "servico.ReqTituloIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.ReqRejeitadaManterFiltro";
    
    public static final String STRATEGY_MANTER_CONSULTAR = "servico.ReqRejeitadaManterFiltro";
    
    public static final String STRATEGY_MANTER_DETALHE= "servico.ReqRejeitadaManterDetalhe";
    
    public static final String STRATEGY_MANTER_DETALHE_TITULO= "servico.ReqTituloManterDetalhe";
    
    public static final String STRATEGY_LISTAR_REQUISICOES= "servico.ReqRejeitadaManterRequisicoes";
    
    public static final String STRATEGY_LISTAR_REQUISICOES_TITULO= "servico.ReqTituloManterRequisicoes";
    
    public static final String STRATEGY_LISTAR_MOTIVOS= "servico.ReqRejeitadaManterMotivos";
    
    public static final String STRATEGY_LISTAR_MOTIVOS_TITULO= "servico.ReqTituloManterMotivos";

    
    // beans genéricos
    public static final String MSG_BEAN = "msgBean";



    // beans
    public static final String FILTRO_BEAN = "filtro";
    
    public static final String FILTRO_BEAN_DETALHE = "filtro_detalhe";

    public static final String DATA_BEAN = "data";

    // páginas
    public static final String PAGE_ERRO = "servico/req_rejeitada_erro";

    public static final String PAGE_FILTRO = "servico/req_rejeitada_filtro";
    
    public static final String PAGE_FILTRO_TITULO = "servico/req_titulo_filtro";
    
    public static final String PAGE_LISTAR = "servico/req_rejeitada_listar";
    
    public static final String PAGE_LISTAR_MOTIVOS = "servico/req_rejeitada_listar_motivos";
    
    public static final String PAGE_LISTAR_MOTIVOS_TITULO = "servico/req_rejeitada_listar_motivos_titulo";
    
    public static final String PAGE_LISTAR_REQUISICOES = "servico/req_rejeitada_listar_requisicoes";
    
    public static final String PAGE_LISTAR_REQUISICOES_TITULO = "servico/req_titulo_listar_requisicoes";
    
    public static final String PAGE_DETALHE = "servico/req_rejeitada_detalhe";
    
    public static final String PAGE_DETALHE_TITULO = "servico/req_titulo_detalhe";
    

    // Titles
    public static final String PAGE_TITLE = "REQUISIÇÕES REJEITADAS";

    public static final String PAGE_TITLE_FILTRO = "REQUISIÇÕES REJEITADAS >> Filtro";
    
    public static final String PAGE_TITLE_TITULO_FILTRO = "REQUISIÇÕES TÍTULO >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "REQUISIÇÕES REJEITADAS >> Listar";
    
    public static final String PAGE_TITLE_DETALHE = "REQUISIÇÕES REJEITADAS >> Detalhar";
    
    public static final String PAGE_TITLE_DETALHE_TITULO = "REQUISIÇÕES TÍTULO >> Detalhar";
    
    public static final String PAGE_TITLE_LISTAR_MOTIVOS = "REQUISIÇÕES REJEITADAS >> Listar Motivos";
    
    public static final String PAGE_TITLE_LISTAR_REQUISICOES = "REQUISIÇÕES REJEITADAS >> Listar Requisições do Título";
    
    public static final String PAGE_TITLE_LISTAR_REQUISICOES_TITULO = "REQUISIÇÕES TÍTULO >> Listar Requisições do Título";
    
    public static final String PAGE_TITLE_LISTAR_MOTIVOS_TITULO = "REQUISIÇÕES TÍTULO >> Listar Motivos do Título";
    
 

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String TRANSACAO_CONSULTAR = "BGST";
    
    public static final String TRANSACAO_DETALHE = "BGSU";
    
    public static final String TRANSACAO_LISTAR_MOTIVOS = "BGSW";
    
    public static final String TRANSACAO_LISTAR_REQUISICOES = "BGSX";
    

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
