package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public abstract class CedenteEstrategia extends SigcbEstrategia {
	private static final long serialVersionUID = -7420915036218966789L;

	// INCLUIR CEDENTE
    // Estrategias
    public static final String STRATEGY_INCLUIR_INICIAR = "cedente.CedenteIncluirIniciar";

    public static final String STRATEGY_INCLUIR_FILTRO = "cedente.CedenteIncluirFiltro";
    
    public static final String STRATEGY_MANTER_LISTAR_HISTORICO = "cedente.CedenteHistoricoSituacao";
    
    public static final String STRATEGY_MANTER_DETALHAR_HISTORICO = "cedente.CedenteDetalharHistorico";

    // Titulos de Paginas
    public static final String PAGE_INCLUIR_TITLE = "Incluir Cedente";

    // Nomes de paginas
    public static final String PAGE_INCLUIR_ESCOLHA = "cedente/cedente_incluir_escolha";
    
    public static final String PAGE_INCLUIR_EXPRESSO = "cedente/cedente_incluir_expresso";
    
    public static final String PAGE_INCLUIR_EXPRESSO_CONFIRMAR = "cedente/cedente_incluir_expresso_confirmar";
    
    public static final String PAGE_INCLUIR_EXPRESSO_SUCESSO = "cedente/cedente_expresso_sucesso";
    
    public static final String PAGE_INCLUIR_FILTRO = "cedente/cedente_incluir_filtro";

    public static final String PAGE_INCLUIR_PRINCIPAL = "cedente/cedente_incluir_principal";

    public static final String PAGE_INCLUIR_GERAL = "cedente/cedente_incluir_guiageral";

    public static final String PAGE_INCLUIR_FLOAT = "cedente/cedente_incluir_guiafloat";

    public static final String PAGE_INCLUIR_CONTAS = "cedente/cedente_incluir_guiacontas";

    public static final String PAGE_INCLUIR_CEDENTE_ELETRONICO = "cedente/cedente_incluir_guiaeletron";

    public static final String PAGE_INCLUIR_BLOQUETOS = "cedente/cedente_incluir_guiabloq";

    public static final String PAGE_INCLUIR_MENSAGENS = "cedente/cedente_incluir_guiamsgbloq";

    public static final String PAGE_INCLUIR_TARIFAS = "cedente/cedente_incluir_guiatarifa";
    
    public static final String PAGE_INCLUIR_PARAMETRO = "cedente/cedente_incluir_guiaparametro";
    
    public static final String PAGE_INCLUIR_PERMISSAO = "cedente/cedente_incluir_guiapermissao";

    public static final String PAGE_INCLUIR_TARIFAS_INFORME = "cedente/cedente_incluir_tarifas";
    
    public static final String PAGE_INCLUIR_TARIFAS_INFORME_EXPRESSO = "cedente/cedente_incluir_tarifas_expresso";

    public static final String PAGE_INCLUIR_CONCLUSAO = "cedente/cedente_incluir_guiaconc";

    public static final String PAGE_INCLUIR_PENDENCIAS = "cedente/cedente_incluir_pendencias";
    
    public static final String PAGE_LISTAR_HISTORICO = "cedente/cedente_listar_historico";
    
    public static final String PAGE_DETALHAR_HISTORICO = "cedente/cedente_detalhar_historico";

    public static final String PAGE_SUCESSO = "cedente/cedente_sucesso";

    public static final String PAGE_ERRO= "cedente/cedente_erro";
    
    public static final String PAGE_ERRO_PARAMETRO = "cedente/cedente_erro_parametro";

    public static final String PAGE_ERRO_SEM_MENU = "cedente/cedente_erro_sem_menu";
    
    public static final String PAGE_ERRO_TARIFA = "cedente/cedente_erro_tarifa";


    // Nomes de beans
    public static final String MSG_BEAN = "msgBean";

    public static final String PRIVILEGIO_BEAN = "privilegioBean";

    public static final String CEDENTE_CABECA_BEAN = "cedenteCabecaBean";

    public static final String CEDENTE_PRINCIPAL_BEAN = "cedentePrincipalBean";

    public static final String CEDENTE_GERAL_BEAN = "cedenteGeralBean";

    public static final String CEDENTE_BLOQUETOS_BEAN = "cedenteBloquetoBean";

    public static final String CEDENTE_ELETRONICO_TESTE_BEAN = "cedenteEletronicoTesteBean";

    public static final String CEDENTE_ELETRONICO_PRODUCAO_BEAN = "cedenteEletronicoProducaoBean";

    public static final String CEDENTE_TARIFAS_BEAN = "cedenteTarifasBean";
    
    public static final String CEDENTE_PARAMETROS_BEAN = "cedenteParametroBean";
    
    public static final String CEDENTE_PERMISSAO_BEAN = "cedentePermissaoBean";

    public static final String CEDENTE_TARIFAS_INFORME_BEAN = "cedenteTarifasInformeBean";

    public static final String CEDENTE_CONCLUSAO_BEAN = "cedenteConclusaoBean";

    public static final String CEDENTE_MENSAGENS_BEAN = "cedenteMensagensBean";

    public static final String INCLUIR_FILTRO_BEAN = "cedenteIncluirFiltroBean";

    public static final String ALTERAR_FILTRO_BEAN = "cedenteAlterarFiltroBean";

    public static final String FLOAT_LISTA_DEFAULT = "cedenteFloatListaDefault";

    public static final String FLOAT_LISTA = "cedenteFloatLista";

    public static final String INDICA_ITEM_SEM_ALCADA = "indicaItemSemAlcada";

    public static final String DESC_CRITICAS = "cedenteDescCriticas";

    /*
     * Usado após a transação BGI0 com a opção 3 (Guia Cedente Eletrônico) afim
     * de se obter no retorno o campo "apelido" a ser usado na transacao BGH8
     */
    // public static final String LOG_CEDENTE_GUIAS_BEAN =
    // "logCedenteGuiasBean";
    public static final String CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS = "CedenteGeralBeanTransacoesGuias";

    public static final String SITUACAO_ELETRONICO = "situacaoEletronico";

    public static final String LISTA_GUIAS_ALTERADAS = "listaGuiaAlteradas";

    // Transacoes
    
    public static final String TRANSACAO_EXPRESSO = "BGJ0";
    
    public static final String TRANSACAO_EXPRESSO_VALIDAR = "BGJ1";
    
    public static final String TRANSACAO_USUARIO = "BGN9";

    public static final String TRANSACAO_SITUACAO_CADASTRO = "BG01";

    public static final String TRANSACAO_CONTROLE_ALTERACAO = "BG02";

    public static final String TRANSACAO_CABECALHO = "BGM0";

    public static final String TRANSACAO_CONSULTAR_CONTA_SICLI = "BGM2";

    public static final String TRANSACAO_CONSULTAR_GERAL = "BG03";

    public static final String TRANSACAO_INCLUIR_ALTERAR_GERAL = "BG04";

    public static final String TRANSACAO_CONSULTAR_FLOAT = "BG05";

    public static final String TRANSACAO_INCLUIR_ALTERAR_FLOAT = "BG06";

    public static final String TRANSACAO_CONSULTAR_CONTAS = "BG07";

    public static final String TRANSACAO_INCLUIR_ALTERAR_CONTAS = "BG08";

    public static final String TRANSACAO_CONSULTAR_CEDENTE_ELETRONICO = "BG09";

    public static final String TRANSACAO_INCLUIR_ALTERAR_CEDENTE_ELETRONICO = "BG10";

    public static final String TRANSACAO_CONSULTAR_BLOQUETO = "BG11";

    public static final String TRANSACAO_INCLUIR_ALTERAR_BLOQUETO = "BG12";

    public static final String TRANSACAO_CONSULTAR_MENSAGENS = "BG13";

    public static final String TRANSACAO_INCLUIR_ALTERAR_MENSAGENS = "BG14";

    public static final String TRANSACAO_CONSULTAR_TARIFAS = "BG15";
    
    public static final String TRANSACAO_CONSULTAR_PARAMETROS = "BGMJ";
    
    public static final String TRANSACAO_ALTERAR_PARAMETROS = "BGMK";

    public static final String TRANSACAO_INCLUIR_ALTERAR_TARIFAS = "BG16";

    public static final String TRANSACAO_CONSULTAR_INFORME_TARIFAS = "BG17";

    public static final String TRANSACAO_INCLUIR_ALTERAR_INFORME_TARIFAS = "BG18";

    public static final String TRANSACAO_CONSULTAR_CONCLUSAO = "BG19";

    public static final String TRANSACAO_CONSULTAR_ITENS_EXCEPCIONADOS = "BG22";

    public static final String TRANSACAO_CONSULTAR_EXCEPCIONACAO_VIGENTE = "BG28";

    public static final String TRANSACAO_FINALIZAR_INCLUSAO = "BG23";

    public static final String TRANSACAO_FINALIZAR_ALTERACAO = "BG20";

    public static final String TRANSACAO_CANCELAR_INCLUSAO = "BG21";

    public static final String TRANSACAO_CONCLUSAO_RAJADA = "BG29";

    public static final String TRANSACAO_SITUACAO_CEDENTE_ELETRONICO = "BG30";

    public static final String TRANSACAO_INCLUSAO_ALTERACAO_SICLI = "BG38";

    public static final String TRANSACAO_COMBO_RAMO = "BGNA";

    public static final String TRANSACAO_FINALIZAR_ALTERACAO_PARTE_1 = "BGH6";

    public static final String TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2 = "BGI0";

    public static final String TRANSACAO_FINALIZAR_ALTERACAO_PARTE_3 = "BGH8";

    public static final String TRANSACAO_DESFAZER_ALTERACAO_GUIAS_CEDENTE = "BGH7";

    // Mensagens sucesso
    public static final String SUCESSO_INCLUSAO = "Cedente Incluído com Sucesso";

    public static final String SUCESSO_INCLUIR_CANCELAMENTO = "Cadastramento Cancelado!";

    public static final String SUCESSO_ALTERACAO = "Cedente Alterado com Sucesso";

    public static final String SUCESSO_ALTERAR_CANCELAMENTO = "Alteração Cancelada!";

    // MANTER CEDENTE
    // Estrategias
    public static final String STRATEGY_MANTER_INICIAR = "cedente.CedenteManterIniciar";

    public static final String STRATEGY_MANTER_FILTRO = "cedente.CedenteManterFiltro";

    public static final String STRATEGY_ALTERAR_INICIAR = "cedente.CedenteAlterarIniciar";

    // Nomes de paginas
    public static final String PAGE_MANTER_FILTRO = "cedente/cedente_manter_filtro";

    public static final String PAGE_ACAO = "cedente/cedente_acao";
    
    public static final String PAGE_ACAO_PEC = "cedente/cedente_acaoPEC";

    public static final String PAGE_MANTER_LISTAR_CPFCNPJ = "cedente/cedente_manter_listar_cpfcnpj";

    public static final String PAGE_MANTER_LISTAR_UNIDPV = "cedente/cedente_manter_listar_unidpv";

    public static final String PAGE_MANTER_LISTAR_UNIDEN = "cedente/cedente_manter_listar_uniden";

    public static final String PAGE_ALTERAR_PRINCIPAL = "cedente/cedente_alterar_principal";

    public static final String PAGE_ALTERAR_PRINCIPAL_CIATI = "cedente/cedente_alterar_principal_ciati";

    public static final String PAGE_ALTERAR_GERAL = "cedente/cedente_alterar_guiageral";

    public static final String PAGE_ALTERAR_FLOAT = "cedente/cedente_alterar_guiafloat";

    public static final String PAGE_ALTERAR_CONTAS = "cedente/cedente_alterar_guiacontas";

    public static final String PAGE_ALTERAR_CEDENTE_ELETRONICO = "cedente/cedente_alterar_guiaeletron";

    public static final String PAGE_ALTERAR_CEDENTE_ELETRONICO_CIATI = "cedente/cedente_alterar_guiaeletronciati";

    public static final String PAGE_ALTERAR_BLOQUETOS = "cedente/cedente_alterar_guiabloq";

    public static final String PAGE_ALTERAR_MENSAGENS = "cedente/cedente_alterar_guiamsgbloq";

    public static final String PAGE_ALTERAR_TARIFAS = "cedente/cedente_alterar_guiatarifa";
    
    public static final String PAGE_ALTERAR_PARAMETROS = "cedente/cedente_alterar_guiaparametro";
    
    public static final String PAGE_ALTERAR_PERMISSAO = "cedente/cedente_alterar_permissao";

    public static final String PAGE_ALTERAR_TARIFAS_INFORME = "cedente/cedente_alterar_tarifas";

    public static final String PAGE_ALTERAR_CONCLUSAO = "cedente/cedente_alterar_guiaconc";

    public static final String PAGE_ALTERAR_PENDENCIAS = "cedente/cedente_alterar_pendencias";

    public static final String PAGE_ALTERAR_EXCEPANTERIOR = "cedente/cedente_alterar_excepanterior";
    
    public static final String PAGE_SIMULAR_TARIFAS="cedente/cedente_importarSISNG_tarifas";
    
    public static final String PAGE_SIMULAR_TARIFAS_SUCESSO="cedente/cedente_importarSISNG_sucesso";

    // Titulos de Paginas
    public static final String PAGE_MANTER_TITLE = "Manter Cedente";

    // Nomes de beans
    
    public static final String INCLUIR_EXPRESSO_BEAN = "cedenteIncluirExpressoBean";
    
    public static final String INCLUIR_EXPRESSO_BEAN_CONFIRMA = "cedenteIncluirExpressoBeanConfirma";
    
    public static final String MANTER_FILTRO_BEAN = "cedenteManterFiltroBean";

    public static final String MANTER_FIXO_BEAN = "cedenteManterBuscaEnBean";

    public static final String MANTER_LISTA_TITULOS_BEAN = "cedenteManterListaTotaisBean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public static final String PAGINACAO_EXCVIG_LIST = "paginacaoExcVig";

    public static final String FECHAR_JANELA_EXCVIG = "fecharJanelaExcVig";

    // Transacoes
    public static final String TRANSACAO_LISTAR_POR_PV_CPFCNPJ = "BG24";

    public static final String TRANSACAO_LISTAR_POR_EN = "BG25";

    public static final String TRANSACAO_CARTEIRA_CEDENTE = "BG26";

    public static final String TRANSACAO_EXCLUIR_REATIVAR = "BG27";

    // Opcoes da tela de busca
    public static final int OPCAO_BUSCA_CEDENTE = 1;

    public static final int OPCAO_BUSCA_CPFCNPJ = 2;

    public static final int OPCAO_BUSCA_UNIDADE = 3;

    // Mensagens sucesso
    public static final String SUCESSO_EXCLUSAO = "Cedente Excluído com Sucesso";

    // Outras constantes
    // Unidades
    public static final int UNIDADE_EN = 1;

    public static final int UNIDADE_PV = 2;

    // Guias
    public static final int GUIA_NENHUMA = 0;

    public static final int GUIA_GERAL = 1;

    public static final int GUIA_FLOAT = 2;

    public static final int GUIA_CONTAS = 3;

    public static final int GUIA_CEDENTE_ELETRONICO = 4;

    public static final int GUIA_BLOQUETOS = 5;

    public static final int GUIA_MENSAGENS = 6;

    public static final int GUIA_TARIFAS = 7;
    
    public static final int GUIA_PARAMETROS = 10;
    
    public static final int GUIA_PERMISSAO = 11;

    public static final int GUIA_CONCLUSAO = 8;

    public static final int GUIA_CEDENTE_ELETRONICO_CIATI = 9;

    // OPERACOES
    public static final String INCLUSAO = "I";

    public static final String ALTERACAO_EM_INCLUSAO = "S";

    public static final String ALTERACAO = "A";

    public static final String CONSULTA = "C";

    // TIPOS MENSAGEM BLOQUETO
    public static final int BLOQ_PADRAO_RECIBO_SACADO = 1;

    public static final int BLOQ_PADRAO_VERSO_BLOQUETO = 2;

    public static final int BLOQ_PADRAO_FICHA_COMP = 3;

    public static final int BLOQ_PERSONALIZADO_RECIBO_SACADO = 4;

    public static final int BLOQ_PERSONALIZADO_VERSO_BLOQUETO = 5;

    public static final int BLOQ_PERSONALIZADO_FICHA_COMP = 6;

    public static final int BLOQ_PERSONALIZADO_RECIBO_SACADO_A = 7;

    public static final int BLOQ_PERSONALIZADO_RECIBO_SACADO_B = 8;

    public static final int BLOQ_PRE_IMPRESSO_RECIBO_SACADO_LASER = 9;

    public static final int BLOQ_PRE_IMPRESSO_FICHA_COMP_MATRIC = 10;

    public static final int BLOQ_BANCO_CORRESPONDENTE = 11;
    
    public static final int BLOQ_DDA_IMPRESSO = 12;

    // TIPO COBRANCA
    public static final Long COBRANCA_ELETRONICA = new Long(1);

    public static final Long COBRANCA_CONVENCIONAL = new Long(2);
    
    public static final Long COBRANCA_ELEITORAL_CONVENCIONAL = new Long(4);
    
    public static final Long COBRANCA_ELEITORAL_ELETRONICA = new Long(5);

    // TAMANHO PAGINA TARIFAS
    public static final int TAMANHO_PAGINA_TARIFAS = 5;

    // CONSULTAR

    // Titulos de Paginas
    public static final String PAGE_CONSULTAR_TITLE = "Manter Cedente >> Consulta Detalhada";

    public static final String PAGE_EXCLUIR_TITLE = "Manter Cedente >> Excluir";

    // Nomes de paginas
    public static final String PAGE_CONSULTAR_PRINCIPAL = "cedente/cedente_consultar_principal";

    public static final String PAGE_CONSULTAR_INFORME_TARIFAS = "cedente/cedente_consultar_tarifas";

    // EAM - Configuração da mensagem de aviso de conclusão quando o cedente
    // sofreu alteração.
    public static final String ALTERACAO_GUIA_CAMPO = "lembreteConclusao";

    public static final String ALTERACAO_GUIA_MENSAGEM_INICIAL = "";

    public static final String ALTERACAO_GUIA_MENSAGEM = "Para que as alterações realizadas sejam efetivadas, é necessário <br> clicar no botão \"Confirmar\" da Guia Conclusão.";
    


    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

    public String getCodigoUsuario(HttpServletRequest request) {
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        return usuarioBean.getCodigoUsuario();
    }

    protected String[] montaStrArray(ArrayList al) {
        String[] array = new String[al.size()];

        for (int i = 0; i < al.size(); i++) {
            array[i] = (String) al.get(i);
        }

        return array;
    }

    protected String formataConta(String conta) {
        String contaFormatada = conta.substring(0, 4) + " ";
        contaFormatada += conta.substring(4, 7) + " ";
        contaFormatada += conta.substring(7, 15) + " ";
        contaFormatada += conta.substring(15, 16);
        return contaFormatada;
    }

    protected void setCedentePadrao(HttpServletRequest request,
            Long cedentePadrao) {
        request.getSession().setAttribute(CEDENTE_ATUAL, cedentePadrao);
    }

    // EAM - Método que atribui a mensagem de alerta de alteração.
    protected static void setMensagemAlteracao(HttpServletRequest request,
            String mensagem) {
        request.getSession().setAttribute(ALTERACAO_GUIA_CAMPO, mensagem);
    }

}
