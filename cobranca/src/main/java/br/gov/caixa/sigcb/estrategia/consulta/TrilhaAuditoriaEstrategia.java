package br.gov.caixa.sigcb.estrategia.consulta;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade ArquivoRemessa
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public abstract class TrilhaAuditoriaEstrategia extends SigcbEstrategia {

    
    public static final String STRATEGY_MANTER= "consulta.TrilhaAuditoriaManter";
    
    public static final String STRATEGY_CONSULTAR= "consulta.TrilhaAuditoriaConsultar";
    
    public static final String STRATEGY_LISTAR = "consulta.TrilhaAuditoriaListar";
    
    public static final String PAGE_TITLE_MANTER_FILTRO = "Trilha de Auditoria >> Filtro";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Trilha de Auditoria >> Lista";

    public static final String PAGE_TITLE_MANTER_DETALHE = "Trilha de Auditoria>> Detalhe";

    public static final String PAGE_MANTER_FILTRO = "/consulta/trilha_Auditoria_filtro";

    public static final String PAGE_MANTER_LISTAR = "/consulta/trilha_auditoria_listar";

    public static final String PAGE_MANTER_CONSULTAR = "/consulta/trilha_auditoria_consultar";
    
    public static final String PAGE_ERRO = "/consulta/trilhaAuditoria_erro";

    public static final String TRANSACAO_LISTAR = "BGJ2";

    public static final String TRANSACAO_CONSULTAR = "BGJ3";

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public static final String FILTRO_BEAN = "trilhaAuditoriaBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "trilhaBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabBean";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
