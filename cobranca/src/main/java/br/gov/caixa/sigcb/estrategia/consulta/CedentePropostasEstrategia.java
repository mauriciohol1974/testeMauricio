package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Cedente por Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class CedentePropostasEstrategia extends SigcbEstrategia {
    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "consulta.CedentePropostasIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "consulta.CedentePropostasFiltro";
    
    public static final String STRATEGY_MANTER_CONSULTAR = "cedente.CedenteManterFiltroPEC";

    // beans genericos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";
    
    public static final String MANTER_FIXO_BEAN = "cedenteManterBuscaEnBean";

    // beans
    public static final String FILTRO_BEAN = "cedentePropostaFiltroBean";
    
    public static final String FIXO_BEAN = "cedentePropostaFixoBean";

    public static final String DATA_BEAN = "cedentePropostaBean";

    // páginas comuns
    public static final String PAGE_JSP_ERRO = "consulta/cedenteProposta_erro";

    public static final String PAGE_JSP_FILTRO = "consulta/cedenteProposta_filtro";

    public static final String PAGE_JSP_CONSULTAR = "consulta/cedenteProposta_manter_listar_PV";
    
    public static final String PAGE_MANTER_LISTAR_UNIDEN = "consulta/cedenteProposta_manter_listar_uniden";

    // Titles
    public static final String PAGE_TITLE_FILTRO = "Consultar Cedentes Propostas >> Filtro";

    public static final String PAGE_TITLE_CONSULTA = "Consultar Cedentes Propostas >> Listar";
    
    public static final String PAGE_TITLE_CONSULTA_VINCULADA = "Consultar Cedentes PEC Vinculados ao Master PEC >> Lista";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transação que preenche
    // o cabeçalho do cedente
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    // utilizada para chamar a transação de consulta
    // por cedente centralizador
    
    public static final String TRANSACAO_LISTAR_POR_EN = "BG25";
    
    public static final String TRANSACAO_LISTAR_POR_PV = "BGMQ";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_JSP_ERRO;
    }
    
    public String getCodigoUsuario(HttpServletRequest request) {
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        return usuarioBean.getCodigoUsuario();
    }
}
