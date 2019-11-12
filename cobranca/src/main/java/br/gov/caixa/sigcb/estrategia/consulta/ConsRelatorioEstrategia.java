package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade CONSULTAS GERENCIAS
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public abstract class ConsRelatorioEstrategia extends SigcbEstrategia {

    // Título

    public static final String PAGE_TITLE_FILTRO_PRODUTO = "Consulta Relatório por Produto>> Filtro";
    
    public static final String PAGE_TITLE_LISTAR_PRODUTO_CONSOLIDADO = "Consulta Relatório por Produto >> CONSOLIDADO";
    
    public static final String PAGE_TITLE_LISTAR_UNIDADE_CONSOLIDADO = "Consulta Relatório por Agência >> CONSOLIDADO";
    
    public static final String PAGE_TITLE_FILTRO_AGENCIA = "Consulta Relatório por Agência>> Filtro";
    
    public static final String PAGE_TITLE_FILTRO_CEDENTE = "Consulta Relatório por Beneficiário>> Filtro";

    public static final String PAGE_TITLE_LISTAR_PRODUTO = "Consulta Relatório por Produto >> Lista";
    
    public static final String PAGE_TITLE_LISTAR_AGENCIA = "Consulta Relatório por Agencia >> Lista";
    
    public static final String PAGE_TITLE_LISTAR_CEDENTE = "Consulta Relatório por Beneficiário >> Lista";

    // paginacao
    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // estrategias
    public static final String STRATEGY_INICIAR_PRODUTO = "consulta.ConsProdIniciar";
    
    public static final String STRATEGY_INICIAR_AGENCIA = "consulta.ConsAgenciaIniciar";
    
    public static final String STRATEGY_ARQUIVO_AGENCIA_CONSOLIDADO = "consulta.ConsRelArquivoAgenciaConsolidado";
    
    public static final String STRATEGY_ARQUIVO_AGENCIA = "consulta.ConsRelGeraArqAgencia";
    
    public static final String STRATEGY_ARQUIVO_AGENCIA_DETALHE = "consulta.ConsRelGeraArqAgenciaDetalhe";
    
    public static final String STRATEGY_ARQUIVO_PRODUTO_CONSOLIDADO = "consulta.ConsRelArquivoProdutoConsolidado";
    
    public static final String STRATEGY_ARQUIVO_PRODUTO = "consulta.ConsRelGeraArqProduto";
    
    public static final String STRATEGY_ARQUIVO_PRODUTO_DETALHE = "consulta.ConsRelGeraArqProdutoDetalhe";
    
    public static final String STRATEGY_INICIAR_CEDENTE = "consulta.ConsCedenteIniciar";

    public static final String STRATEGY_FILTRO_LISTAR = "consulta.ConsProdListar";
    
    public static final String STRATEGY_FILTRO_AGENCIA_LISTAR = "consulta.ConsAgenciaListar";
    
    public static final String STRATEGY_FILTRO_CEDENTE_LISTAR = "consulta.ConsCedenteListar";
    
    public static final String STRATEGY_ARQUIVO_CEDENTE = "consulta.ConsRelGeraArqCedente";
    
    public static final String STRATEGY_ARQUIVO_CEDENTE_DETALHE = "consulta.ConsRelGeraArqCedenteDetalhe";
    
    public static final String STRATEGY_FILTRO_CONSOLIDADO = "consulta.ConsRelProdutoConsolidado";
    
    public static final String STRATEGY_FILTRO_AGENCIA_CONSOLIDADO = "consulta.ConsRelAgenciaConsolidado";
    
    public static final String STRATEGY_FILTRO_CEDENTE_CONSOLIDADO = "consulta.ConsCedenteConsolidado";
    
    public static final String STRATEGY_DETALHE_PRODUTO = "consulta.ConsProdListarDetalhe";
    
    public static final String STRATEGY_DETALHE_AGENCIA = "consulta.ConsAgenciaListarDetalhe";
    
    public static final String STRATEGY_DETALHE_CEDENTE = "consulta.ConsCedenteListarDetalhe";

    // beans
    public static final String FILTRO_BEAN = "relatorioBean";
    
    public static final String BEAN_FILTRO = "relatorioBean";
    
    public static final String DATA_BEAN = "relatorioBeanData";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";
    
    public static final String MSG_BEAN = "msgBean";

    // Páginas
    public static final String PAGE_ERRO = "consulta/rel_auditoria_erro";

    public static final String PAGE_FILTRO_PRODUTO = "consulta/rel_produto_filtro";

    public static final String PAGE_LISTAR_PRODUTO = "consulta/rel_produto_listar";
    
    public static final String PAGE_LISTAR_PRODUTO_DETALHE = "consulta/rel_produto_detalhe";
    
    public static final String PAGE_LISTAR_PRODUTO_CONSOLIDADO = "consulta/rel_produto_consolidado";
    
    public static final String PAGE_LISTAR_AGENCIA_CONSOLIDADO = "consulta/rel_agencia_consolidado";
    
    public static final String PAGE_LISTAR_AGENCIA = "consulta/rel_agencia_listar";
    
    public static final String PAGE_LISTAR_AGENCIA_DETALHE = "consulta/rel_agencia_detalhe";
    
    public static final String PAGE_LISTAR_CEDENTE = "consulta/rel_cedente_listar";
    
    public static final String PAGE_LISTAR_CEDENTE_DETALHE = "consulta/rel_cedente_detalhe";
    
    public static final String PAGE_PRODUTO_DETALHE = "consulta/rel_produto_detalhe";
    
    public static final String PAGE_FILTRO_AGENCIA = "consulta/rel_agencia_filtro";
    
    public static final String PAGE_FILTRO_CEDENTE = "consulta/rel_cedente_filtro";

  
    // transação
    public static final String TRANSACAO_LISTAR_PRODUTO = "BGWJ";
    
    public static final String TRANSACAO_LISTAR_PRODUTO_DETALHE = "BGWK";
    
    public static final String TRANSACAO_LISTAR_CEDENTE = "BGWP";
    
    public static final String TRANSACAO_LISTAR_CEDENTE_DETALHE = "BGWQ";
    
    public static final String TRANSACAO_LISTAR_AGENCIA = "BGWM";
    
    public static final String TRANSACAO_LISTAR_AGENCIA_DETALHE = "BGWN";
    
    public static final String TRANSACAO_LISTAR_AGENCIA_CONSOLIDADO = "BGWO";
    
    public static final String TRANSACAO_LISTAR_PRODUTO_CONSOLIDADO = "BGWL";




    // Navegacao
   

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}