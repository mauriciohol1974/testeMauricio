package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de servicos Gerais
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class LancamentoTarifaEstrategia extends SigcbEstrategia {

    // estratégias
    public static final String STRATEGY_MANTER_INICIAR = "servico.TarifaIncluirComandoDebito";
    
    public static final String STRATEGY_MANTER_COMANDO_INICIAR = "servico.TarifaManterComandoDebito";

    public static final String STRATEGY_MANTER_FILTRO = "servico.LanTariManterFiltro";
    
    public static final String STRATEGY_MANTER_FILTRO_MANTER = "servico.LanTariManterFiltroManter";
    
    public static final String STRATEGY_MANTER_EXECUTAR= "servico.LanTariManterExecutar";
    
    public static final String STRATEGY_MANTER_EXECUTAR_MANTER= "servico.LanTariManterExecutarManter";

    public static final String STRATEGY_CONSULTAR = "servico.LanTariservicorDetIniciar";
    																				
    public static final String STRATEGY_CONSULTAR_DETALHE_MANTER_INCLUIR = "servico.DebitoTarifaConsultarDetalheDetIniciar_Incluir";
    																	   
    public static final String STRATEGY_CONSULTAR_DETALHE_MANTER = "servico.DebitoTarifaConsultarDetalheDetIniciar_Manter";
    
    public static final String STRATEGY_CONSULTAR_MANTER = "servico.DebitoTarifaConsultarDetIniciar_Manter";
    
    public static final String STRATEGY_CONSULTAR_MANTER_INCLUIR = "servico.DebitoTarifaConsultarDetIniciar_Incluir";

    // beans genéricos
    public static final String MSG_BEAN = "msgBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    // beans
    public static final String FILTRO_BEAN = "lancamentoTarifaFiltroBean";

    public static final String DATA_BEAN = "lancamentoTarifaBean";

    // páginas
    public static final String PAGE_ERRO = "servico/lantari_erro";

    public static final String PAGE_FILTRO = "servico/lantari_manter_filtro";
    
    public static final String PAGE_FILTRO_MANTER = "servico/lantari_manter_filtroManter";

    public static final String PAGE_servicoR = "servico/lantari_servicor";

    public static final String PAGE_EXECUTAR= "servico/lantari_manter_incluir";
    
    public static final String PAGE_EXECUTAR_MANTER= "servico/lantari_manter_incluir_manter";
    
    public static final String PAGE_LISTAR_DETALHE = "servico/debitotari_manter_listar_detalhe";
    
    public static final String PAGE_SUCESSO_INCLUIR = "servico/incluir_tarifa_sucesso";
    
    public static final String PAGE_SUCESSO_EXCLUIR = "servico/excluir_tarifa_sucesso";
    
    
    public static final String PAGE_LISTAR_DETALHE_INCLUIR = "servico/incluir_debitotarifa_manter_listar_detalhe";
    
    public static final String PAGE_CONSULTAR_DETALHE = "servico/debitotari_consultar";
    
    public static final String PAGE_CONSULTAR_DETALHE_INCLUIR = "servico/debitotari_consultar_incluir";

    // Titles
    public static final String PAGE_TITLE = "Incluir Comando de Débito de Tarifas";
    
    public static final String PAGE_TITLE_MANTER = "Manter Comando de Débito de Tarifas";

    public static final String PAGE_TITLE_FILTRO = "Incluir Comando de Débito de Tarifas >> Filtro";

    public static final String PAGE_TITLE_LISTA = "Incluir Comando de Débito de Tarifas >> Listar";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // utilizada para chamar a transação que preenche
    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_EXECUTAR = "BGA7";
    
    public static final String TRANSACAO_EXECUTAR_MANTER = "BGNL";
    
    public static final String TRANSACAO_EXECUTAR_2 = "BGNM";
    
    public static final String TRANSACAO_EXCLUIR = "BGNN";

    public static final String TRANSACAO_CONSULTAR = "BGA7";
    
    public static final String TRANSACAO_CONSULTAR_DETALHE = "BGA8";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
