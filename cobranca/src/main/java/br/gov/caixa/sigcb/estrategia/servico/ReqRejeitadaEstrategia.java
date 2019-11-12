package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade de Consultas Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public abstract class ReqRejeitadaEstrategia extends SigcbEstrategia {

    // estrat�gias
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

    
    // beans gen�ricos
    public static final String MSG_BEAN = "msgBean";



    // beans
    public static final String FILTRO_BEAN = "filtro";
    
    public static final String FILTRO_BEAN_DETALHE = "filtro_detalhe";

    public static final String DATA_BEAN = "data";

    // p�ginas
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
    public static final String PAGE_TITLE = "REQUISI��ES REJEITADAS";

    public static final String PAGE_TITLE_FILTRO = "REQUISI��ES REJEITADAS >> Filtro";
    
    public static final String PAGE_TITLE_TITULO_FILTRO = "REQUISI��ES T�TULO >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "REQUISI��ES REJEITADAS >> Listar";
    
    public static final String PAGE_TITLE_DETALHE = "REQUISI��ES REJEITADAS >> Detalhar";
    
    public static final String PAGE_TITLE_DETALHE_TITULO = "REQUISI��ES T�TULO >> Detalhar";
    
    public static final String PAGE_TITLE_LISTAR_MOTIVOS = "REQUISI��ES REJEITADAS >> Listar Motivos";
    
    public static final String PAGE_TITLE_LISTAR_REQUISICOES = "REQUISI��ES REJEITADAS >> Listar Requisi��es do T�tulo";
    
    public static final String PAGE_TITLE_LISTAR_REQUISICOES_TITULO = "REQUISI��ES T�TULO >> Listar Requisi��es do T�tulo";
    
    public static final String PAGE_TITLE_LISTAR_MOTIVOS_TITULO = "REQUISI��ES T�TULO >> Listar Motivos do T�tulo";
    
 

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
