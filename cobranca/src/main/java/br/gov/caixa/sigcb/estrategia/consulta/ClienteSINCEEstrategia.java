package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade CONSULTAS GERENCIAS
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public abstract class ClienteSINCEEstrategia extends SigcbEstrategia {

    // T�tulo

    public static final String PAGE_TITLE_FILTRO = "Consulta SINCE >> Filtro";

    public static final String PAGE_TITLE_LISTAR = "Consulta SINCE >> Lista";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR = "consulta.ClienteSINCEIniciar";

    public static final String STRATEGY_FILTRO = "consulta.ClienteSINCEFiltro";
    
    public static final String STRATEGY_LISTA = "consulta.ClienteSINCELista";

    // beans
    public static final String BEAN_FILTRO = "clienteSINCE";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // P�ginas
    public static final String PAGE_ERRO = "consulta/consulta_erro_SINCE";

    public static final String PAGE_FILTRO = "consulta/clienteSINCE_filtro";

    public static final String PAGE_LISTAR = "consulta/clienteSINCE_listar";

  
    // transa��o
    public static final String TRANS_LISTAR_SINCE = "BGUL";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";


    // Navegacao
   

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}