package br.gov.caixa.sigcb.estrategia.dda;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * Projeto: SIGCB
 * Componente responsável pelo controle da funcionalidade CONSULTAS GERAIS DO DDA
 * Criada em: 01/10/2009
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public abstract class DdaGeraisEstrategia extends SigcbEstrategia {

    // Paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Beans Default
    public static final String MSG_BEAN = "msgBean";

    // Estrategias
    public static final String STRATEGY_INICIAR = "dda.DdaGeraisConsultarIniciar";

    public static final String STRATEGY_FILTRO = "dda.DdaGeraisConsultarFiltro";

    public static final String STRATEGY_LISTAR = "dda.DdaGeraisConsultarListar";

    // Beans
    public static final String BEAN_FILTRO = "ddaGeraisFiltroBean";

    public static final String BEAN_LISTAR = "ddaGeraisListarBean";

    public static final String BEAN_TITULO = "ddaGeraisTituloBean";

    public static final String BEAN_TITULO_DESCONTOS = "ddaGeraisTituloDescontosBean";

    // Título
    public static final String PAGE_TITLE = "Consultas Gerais DDA";

    public static final String PAGE_TITLE_FILTRO = "Consultas Gerais DDA >> Filtro";

    public static final String PAGE_TITLE_TITULOSENVIADOS_LISTAR = "Consultas Gerais DDA >> Listar Titulos Enviados";

    public static final String PAGE_TITLE_TITULOSPAGOS_LISTAR = "Consultas Gerais DDA >> Listar Titulos Pagos";

    public static final String PAGE_TITLE_ACEITEALEGACAO_LISTAR = "Consultas Gerais DDA >> Listar Titulos em Aceite/Alegação";

    public static final String PAGE_TITLE_TITULOSVENCIDOS_LISTAR = "Consultas Gerais DDA >> Listar Titulos Vencidos";

    public static final String PAGE_TITLE_QUARENTENA_LISTAR = "Consultas Gerais DDA >> Listar Titulos em Quarentena";

    public static final String PAGE_TITLE_TITULOSSACADOEXCLUIDO_LISTAR = "Consultas Gerais DDA >> Listar Titulos de Sacado Eletronico Excluído";

    public static final String PAGE_TITLE_TITULODDA_DETALHE = "Consultas Gerais DDA >> Dados do Titulo";

    // Páginas
    public static final String PAGE_ERRO = "dda/ddagerais_erro";

    public static final String PAGE_FILTRO = "dda/ddagerais_consultar_filtro";

    public static final String PAGE_TITULOSENVIADOS_LISTAR = "dda/ddagerais_titulosenviados_listar";

    public static final String PAGE_TITULOSPAGOS_LISTAR = "dda/ddagerais_titulospagos_listar";

    public static final String PAGE_ACEITEALEGACAO_LISTAR = "dda/ddagerais_aceitealegacao_listar";

    public static final String PAGE_TITULOSVENCIDOS_LISTAR = "dda/ddagerais_titulosvencidos_listar";

    public static final String PAGE_QUARENTENA_LISTAR = "dda/ddagerais_quarentena_listar";

    public static final String PAGE_TITULOSSACADOEXCLUIDO_LISTAR = "dda/ddagerais_titulossacadoexcluido_listar";

    public static final String PAGE_TITULODDA_DETALHE = "dda/ddagerais_consultar_detalhe";

    // Transação
    public static final String TRANSACAO_TITULOSENVIADOS_LISTAR = "BG9G";

    public static final String TRANSACAO_TITULOSPAGOS_LISTAR = "BG9G";

    public static final String TRANSACAO_ACEITEALEGACAO_LISTAR = "BG9H";

    public static final String TRANSACAO_TITULOSVENCIDOS_LISTAR = "BG9G";

    public static final String TRANSACAO_QUARENTENA_LISTAR = "BG9G";

    public static final String TRANSACAO_TITULOSSACADOEXCLUIDO_LISTAR = "BG9G";

    public static final String TRANSACAO_TITULO_DETALHE = "BG9J";

    // Mensagens
    public static final String MENSAGEM_TITULOSENVIADOS = "TITULOS ENVIADOS";

    public static final String MENSAGEM_TITULOSPAGOS = "TITULOS PAGOS";

    public static final String MENSAGEM_ACEITEALEGACAO = "ACEITE / ALEGACAO";

    public static final String MENSAGEM_TITULOSVENCIDOS = "TITULOS VENCIDOS";

    public static final String MENSAGEM_QUARENTENA = "QUARENTENA";

    public static final String MENSAGEM_TITULOSSACADOEXCLUIDO = "TITULOS DE SACADO ELETRONICO EXCLUIDO";

    /* //////////////////////////////// */

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}