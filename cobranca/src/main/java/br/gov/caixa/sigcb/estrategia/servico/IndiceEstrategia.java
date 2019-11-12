package br.gov.caixa.sigcb.estrategia.servico;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Sacados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public abstract class IndiceEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_INICIAR = "servico.ServIndiceIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.ServIndiceIncluirFinalizar";
    
    public static final String STRATEGY_ATUALIZAR_INICIAR = "servico.ServIndiceAlterarIniciar";
    
    public static final String STRATEGY_ATUALIZAR_FINALIZAR = "servico.ServIndiceAlterarFinalizar";

    public static final String STRATEGY_MANTER_INICIAR = "servico.ServIndiceManterIniciar";
    
    public static final String STRATEGY_PERIODO_INICIAR = "servico.ServIndicePeriodoIniciar";
    
    public static final String STRATEGY_PERIODO_FINALIZAR = "servico.ServIndicePeriodoFinalizar";
    
    public static final String STRATEGY_PERIODO_CONSULTAR = "servico.ConsultarIndicePeriodoIniciar";

    public static final String STRATEGY_ALTERAR_INICIAR = "servico.ServIndiceAlterarIniciar";

    public static final String STRATEGY_CONSULTAR_PERIODO = "servico.ServIndicePeriodoListar";

    public static final String STRATEGY_CONSULTAR = "servico.ServIndiceConsultar";



    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Índices Econômicos";
    
    public static final String PAGE_TITLE_INCLUIR_PERIODO = "Incluir Período Índices Econômicos";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Índices Econômicos";
    
    public static final String PAGE_TITLE_CONSULTAR = "Consultar Índices Econômicos";

    public static final String PAGE_TITLE_MANTER_FILTRO = "";

    public static final String PAGE_TITLE_MANTER_LISTAR = "Listar Séries de Indíces Econômicos";

    public static final String PAGE_TITLE_ALTERAR = "Alterar Índices Econômicos";

    


    public static final String SUCESSO_INCLUIR = "";

    public static final String SUCESSO_ALTERAR = "";


    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "indiceBean";

    public static final String FILTRO_BEAN = "indiceFiltroBean";


    public static final String PAGE_INCLUIR = "servico/indice_incluir"; //
    
    public static final String PAGE_CONSULTAR_PERIODO = "servico/consultar_indice_periodo"; //
    
    public static final String PAGE_INCLUIR_PERIODO = "servico/indice_inc_periodo";

    public static final String PAGE_LISTAR = "servico/indice_listar";
    
    public static final String PAGE_LISTAR_PERIODO = "servico/indice_listar_periodo";

    public static final String PAGE_ALTERAR = "servico/indice_alterar";

    public static final String PAGE_CONSULTAR = "servico/indice_consultar";
    
    public static final String PAGE_ATUALIZAR = "servico/indice_atualizar";
    
    public static final String PAGE_LISTAR_VALORES = "servico/indice_listar_valores";
    
    public static final String PAGE_ERRO = "servico/indice_erro";

    public static final String PAGE_SUCESSO = "servico/indice_sucesso";

    public static final String TRANSACAO_LISTAR = "BGSQ";

    public static final String TRANSACAO_CONSULTAR = "BGSP";

    public static final String TRANSACAO_INCLUIR = "BGSP";
    
    public static final String TRANSACAO_INCLUIR_PERIODO = "BGSR";
    
    public static final String TRANSACAO_LISTAR_PERIODO = "BGSS";
    
    public static final String TRANSACAO_ALTERAR = "BGSP";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}