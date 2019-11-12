package br.gov.caixa.sigcb.estrategia.dda;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Sacado Eletronico
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */

public abstract class SacEletronicoEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FILTRO = "dda.SacEletronicoIncluirIniciar";
    
    public static final String STRATEGY_EXCLUIR_FILTRO = "dda.SacEletronicoExcluirIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "dda.SacEletronicoConsultarIniciar";

    //public static final String STRATEGY_MANTER_LISTAR = "parametro.AgrupManterFiltro";

    public static final String STRATEGY_INCLUIR = "dda.SacEletronicoIncluirFiltro";

    //public static final String STRATEGY_ALTERAR = "parametro.AgrupAlterarIniciar";

    public static final String STRATEGY_EXCLUIR_SUCESSO = "dda.SacEletronicoExcluirFinalizar";

    public static final String STRATEGY_INCLUIR_SUCESSO = "dda.SacEletronicoIncluirFinalizar";
    
    public static final String STRATEGY_CONSULTAR_LISTAR = "dda.SacEletronicoConsultarListar";

    //public static final String STRATEGY_ALTERAR_SUCESSO = "parametro.AgrupAlterarFinalizar";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Agregado";

    public static final String PAGE_TITLE_EXCLUIR = "Excluir Agregado";
    
    public static final String PAGE_TITLE_CONSULTAR = "Consultar Sacado Eletrônico Caixa";

    public static final String SUCESSO_INCLUIR = "Agregado Incluído com Sucesso";
    
    public static final String SUCESSO_EXCLUIR = "Agregado Excluído com Sucesso";

    //public static final String SUCESSO_ALTERAR = "Agrupamento de Serviços Alterado com Sucesso";

    //public static final String SUCESSO_EXCLUIR = "Agrupamento de Serviços Excluído com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "sacBean";

    public static final String FILTRO_BEAN = "filtroSacBean";

    public static final String PAGE_INCLUIR_FILTRO = "dda/sac_eletron_incluir";
    
    public static final String PAGE_EXCLUIR_FILTRO = "dda/sac_eletron_excluir";
    
    public static final String PAGE_CONSULTAR_FILTRO = "dda/sac_eletron_consultar";//"dda/sac_eletron_listar";

    //public static final String PAGE_MANTER_FILTRO = "parametro/agrup_manter_filtro";

    //public static final String PAGE_MANTER_LISTAR = "parametro/agrup_manter_listar";

    //public static final String PAGE_ALTERAR = "parametro/agrup_alterar";

    public static final String PAGE_INCLUIR = "dda/sac_eletron_incluir";
    
    public static final String PAGE_LISTAR = "dda/sac_eletron_listar";

    public static final String PAGE_SUCESSO = "dda/sac_eletron_sucesso";

    public static final String PAGE_ERRO = "dda/sac_eletron_erro";

    //public static final String TRANSACAO_LISTAR = "BGK0";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG8I";
    
    public static final String TRANSACAO_EXCLUIR_ALTERAR = "BG8I";
    
    public static final String TRANSACAO_CONSULTAR_LISTAR = "BG8J";

    public static final String TRANSACAO_VALIDAR_EXCLUIR = "BG8I";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
