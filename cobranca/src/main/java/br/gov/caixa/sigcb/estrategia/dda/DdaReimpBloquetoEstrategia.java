package br.gov.caixa.sigcb.estrategia.dda;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * REIMPRESSAO DE BLOQUETOS DDA Criada em: 15/01/2010
 * 
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public abstract class DdaReimpBloquetoEstrategia extends SigcbEstrategia {

	// Paginacao
	public static final String PAGINACAO_LIST = "paginacao";

	public static final String PAGINACAO_PAGE = "paginaAtual";

	// Beans Default
	public static final String MSG_BEAN = "msgBean";

	// Estrategias
	public static final String STRATEGY_INICIAR = "dda.DdaReimpBloquetoConsultarIniciar";

	public static final String STRATEGY_FILTRO = "dda.DdaReimpBloquetoConsultarFiltro";

	public static final String STRATEGY_LISTAR = "dda.DdaReimpBloquetoConsultarListar";

	// Beans
	public static final String BEAN_FILTRO = "ddaReimpBloquetoFiltroBean";

	public static final String BEAN_LISTAR = "ddaReimpBloquetoListarBean";

	public static final String BEAN_TITULO = "ddaReimpBloquetoTituloBean";

	public static final String BEAN_TITULO_DESCONTOS = "ddaReimpBloquetoTituloDescontosBean";

	public static final String BEAN_TITULO_INSTRUCOES = "ddaReimpBloquetoTituloInstrucoesBean";

	// Título
	public static final String PAGE_TITLE = "Reimpressao de Bloquetos DDA";

	public static final String PAGE_TITLE_FILTRO = "Reimpressão de Bloquetos DDA >> Filtro";

	public static final String PAGE_TITLE_LISTAR = "Reimpressão de Bloquetos DDA >> Listar";

	public static final String PAGE_TITLE_TITULO = "Reimpressão de Bloquetos DDA >> Titulo";

	// Páginas
	public static final String PAGE_ERRO = "dda/ddareimpbloqueto_erro";

	public static final String PAGE_FILTRO = "dda/ddareimpbloqueto_consultar_filtro";

	public static final String PAGE_LISTAR = "dda/ddareimpbloqueto_consultar_listar";

	public static final String PAGE_TITULO = "dda/ddareimpbloqueto_consultar_titulo";

	public static final String PAGE_SUCESSO = "dda/ddareimpbloqueto_consultar_sucesso";
	
	// Transação
	public static final String TRANSACAO_LISTAR = "BG9L";

	public static final String TRANSACAO_TITULO = "BG9J";

	public static final String TRANSACAO_TITULO_INSTRUCOES = "BG9M";

    // Mensagens
    public static final String MENSAGEM_TODOS = "Todos";

    public static final String MENSAGEM_CAIXACOBREGISTRADO = "Caixa – COB – registrado";

    public static final String MENSAGEM_CAIXAGCBREGISTRADO = "Caixa – GCB – registrado";

    public static final String MENSAGEM_CAIXACOBSEMREGISTRO = "Caixa – COB – sem registro";

    public static final String MENSAGEM_CAIXAGCBSEMREGISTRO = "Caixa – GCB – sem registro";

    public static final String MENSAGEM_OUTROS = "Outros Bancos";

	/* //////////////////////////////// */

	public String getCustomizedHTMLMessagePageName() {
		return PAGE_ERRO;
	}

}