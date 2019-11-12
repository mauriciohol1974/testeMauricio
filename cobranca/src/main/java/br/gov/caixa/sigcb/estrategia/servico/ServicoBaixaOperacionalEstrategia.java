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
public abstract class ServicoBaixaOperacionalEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "servico.ServicoBaixaOperacionalIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.ServicoBaixaOperacionalFiltro";

    public static final String STRATEGY_CONSULTAR = "servico.ServicoBaixaOperacionalDetalhe";
    
    public static final String STRATEGY_EFETIVAR = "servico.ServicoBaixaOperacionalEfetivar";

    // beans genéricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "lancamentoTarifaFiltroBean";

    public static final String DATA_BEAN = "lancamentoTarifaBean";

    // páginas
    public static final String PAGE_ERRO = "servico/servico_baixa_erro";

    public static final String PAGE_FILTRO = "servico/servico_baixa_filtro";

    public static final String PAGE_CONSULTAR = "servico/servico_baixa_detalhe";
    
    public static final String PAGE_SUCESSO = "servico/servico_baixa_sucesso";

    

    // Titles
    public static final String PAGE_TITLE = "BAIXA OPERACIONAL";

    public static final String PAGE_TITLE_FILTRO = "Baixa Operacional >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "Baixa Operacional >> Consultar";
    
 

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String TRANSACAO_CONSULTAR = "BGSM";
    

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
