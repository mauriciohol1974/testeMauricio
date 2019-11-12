package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;


public abstract class ConsultaLiqStrManterEstrategia extends SigcbEstrategia {

  
   // Estrategias
   public static final String STRATEGY_INICIAR_RECEBIDAS = "consulta.ConsultaLiqStrIniciarRecebidas";
   
   public static final String STRATEGY_INICIAR_DEVOLVIDAS = "consulta.ConsultaLiqStrIniciarDevolvidas";

   public static final String STRATEGY_LISTA = "consulta.LiqStrManterFiltro";
   
   public static final String STRATEGY_LISTA_RECEBIDAS = "consulta.ConsultaLiqStrManterFiltroRecebidas";
   
   public static final String STRATEGY_LISTA_DEVOLVIDAS = "consulta.ConsultaLiqStrManterFiltroDevolvidas";

   public static final String STRATEGY_CONSULTAR_RECEBIDA = "consulta.ConsultaLiqSTRRecebida";
   
   public static final String STRATEGY_CONSULTAR_DEVOLVIDA = "consulta.ConsultaLiqSTRDevolvida";

   // Titulos de Paginas
   public static final String PAGE_TITLE = "Consultar Liquidações via STR Recebidas ";

  
   // Nomes de beans
   public static final String MSG_BEAN = "msgBean";

   public static final String DATA_BEAN = "liqSTReBean";

   public static final String FILTRO_BEAN = "filtroLiqSTRBean";

   // Nomes de paginas
   public static final String PAGE_FILTRO = "consulta/liquidacao_STRFiltro";
   
   public static final String PAGE_FILTRO_DEVOL = "consulta/liquidacao_STRFiltroDevolvida";

   public static final String PAGE_LISTAR_RECEBIDAS = "consulta/liquidacao_STRmanter_listar_recebidas";
   
   public static final String PAGE_LISTAR_DEVOLVIDAS = "consulta/liquidacao_STRmanter_listar_devolvidas";
   
   public static final String PAGE_CONSULTAR_RECEBIDAS = "consulta/liqSTR_consultar_recebidas";
   
   public static final String PAGE_CONSULTAR_DEVOLVIDAS = "consulta/liqSTR_consultar_devolvidas";

   
   public static final String PAGE_ERRO = "consulta/liqSTR_erro";

   // Transacoes
   public static final String TRANSACAO_LISTAR_RECEBIDAS = "BGZJ";

   public static final String TRANSACAO_LISTAR_DEVOLVIDAS = "BGZK";
   
   public static final String TRANSACAO_CONSULTAR_RECEBIDAS = "BGZH";
   
   public static final String TRANSACAO_CONSULTAR_DEVOLVIDAS = "BGZL";

  
   // Utilizadas na paginacao
   public static final String PAGINACAO_LIST = "paginacao";

   public static final String PAGINACAO_PAGE = "paginaAtual";

   // Define tela customizada de erro
   public String getCustomizedHTMLMessagePageName() {
       return PAGE_ERRO;
   }
}
