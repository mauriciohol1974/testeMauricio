package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Borderô OnLine
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public abstract class BorderoEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FILTRO = "servico.BorderoIncluirIniciar";

    public static final String STRATEGY_INCLUIR = "servico.BorderoIncluirFiltro";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "servico.BorderoIncluirFinalizar";

    public static final String STRATEGY_MANTER_FILTRO = "servico.BorderoManterIniciar";

    public static final String STRATEGY_MANTER_LISTAR = "servico.BorderoManterFiltro";

    public static final String STRATEGY_ALTERAR = "servico.BorderoAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "servico.BorderoAlterarFinalizar";

    public static final String STRATEGY_CONSULTAR = "servico.BorderoConsultarIniciar";

    public static final String STRATEGY_EXCLUIR = "servico.BorderoExcluirFinalizar";

    public static final String STRATEGY_FINALIZAR = "servico.BorderoAcaoFinalizarFinalizar";

    public static final String STRATEGY_IMPRIMIR = "servico.BorderoAcaoImpBorderoFinalizar";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Borderô";

    public static final String PAGE_TITLE_MANTER = "Manter Borderô";

    public static final String PAGE_TITLE_IMPRIMIR = "Impressão do Borderô On Line";

    public static final String SUCESSO_INCLUIR = "Borderô Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "Borderô Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "Borderô Excluído com Sucesso";

    public static final String SUCESSO_FINALIZAR = "Borderô Finalizado com Sucesso";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "borderoBean";
    
    public static final String BORDERO_INFO_BEAN = "borderoInfoBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedCabBean";

    public static final String CEDENTE_GERAL_BEAN = "cedGeralBean";

    public static final String FILTRO_BEAN = "filtroBorderoBean";

    public static final String CEDENTE_BLOQUETO_BEAN = "cedBloqBean";

    public static final String CEDENTE_MENSAGEM_BEAN = "cedMsgBean";

    public static final String PAGE_ALTERAR = "servico/bordero_alterar";

    public static final String PAGE_CONSULTAR = "servico/bordero_consultar";

    public static final String PAGE_ERRO = "servico/bordero_erro";

    public static final String PAGE_IMPRIMIR = "servico/bordero_acao_impbordero";

    public static final String PAGE_INCLUIR = "servico/bordero_incluir";
    
    public static final String PAGE_INCLUIR_TITULO = "servico/titulo_incluir";

    public static final String PAGE_INCLUIR_FILTRO = "servico/bordero_incluir_filtro";

    public static final String PAGE_MANTER_FILTRO = "servico/bordero_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "servico/bordero_manter_listar";

    public static final String PAGE_SUCESSO = "servico/bordero_sucesso";

    public static final String PAGE_TITULO_MANTER_LISTAR = "servico/titulo_manter_listar";

    public static final String TRANSACAO_CEDENTE_CABECALHO = "BGM0";

    public static final String TRANSACAO_CEDENTE_GERAL = "BG03";

    public static final String TRANSACAO_LISTAR = "BG71";

    public static final String TRANSACAO_CONSULTAR = "BG72";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BG73";

    public static final String TRANSACAO_EXCLUIR = "BG74";
    
    //public static final String TRANSACAO_EXCLUIR = "BGWW";

    public static final String TRANSACAO_FINALIZAR_REABRIR = "BG75";

    public static final String TRANSACAO_LISTAR_TITULO = "BG76";
    
    public static final String TRANSACAO_BORDERO_INFO = "BG79";

    public static final String TRANSACAO_CEDENTE_BLOQUETOS = "BG11";

    public static final String TRANSACAO_CEDENTE_MENSAGEM = "BG13";

    public static final String LISTA_TITULO = "listaTitulo";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    /**
     * BorderoBean.navegacao. estado inicial = 0 incluir = 1 excluir = 2
     * finalizar = 3 imprimir = 4 alterar = 5 manter bordero = 6 manter titulos =
     * 7 outro = 8
     */
    public static final Long NAVEGACAO_FILTRO = new Long(0);

    public static final Long NAVEGACAO_INCLUIR = new Long(1);

    public static final Long NAVEGACAO_EXCLUIR = new Long(2);

    public static final Long NAVEGACAO_FINALIZAR = new Long(3);

    public static final Long NAVEGACAO_IMPRIMIR = new Long(4);

    public static final Long NAVEGACAO_ALTERAR = new Long(5);

    public static final Long NAVEGACAO_LISTA_BORDERO = new Long(6);

    public static final Long NAVEGACAO_LISTA_TITULO = new Long(7);

    public static final Long NAVEGACAO_OUTRO_LISTA_BORDERO = new Long(8);

    public static final Long NAVEGACAO_OUTRO_LISTA_TITULO = new Long(9);

    // Define o tipo de mensagem que será como default na tela de inclusão
    public static final Long CEDENTE_MENSAGEM_LOCAL_IMPRESSAO = new Long(3); // 3 =
                                                                                // Bloqueto
                                                                                // Padrão/Ficha
                                                                                // de
                                                                                // compensação

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

    // Recebe um texto e o separa num ArrayList de acordo com os \n
    protected ArrayList quebraLinhas(String texto) {
        ArrayList alLinhas = new ArrayList();

        String temp = "";
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != '\r' && texto.charAt(i) != '\n') {
                temp += texto.charAt(i);
            } else {
                if (texto.charAt(i) == '\r') {
                    i++; // pula o \n caso encontre o \r
                }

                alLinhas.add(temp.toUpperCase());
                temp = "";
            }
        }

        return alLinhas;
    }

}