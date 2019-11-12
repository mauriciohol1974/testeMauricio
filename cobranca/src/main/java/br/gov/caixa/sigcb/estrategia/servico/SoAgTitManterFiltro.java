package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade
 * Solicitacao/Agendamento >> Manter >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class SoAgTitManterFiltro extends SolicitacaoAgendamentoEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String strRetorno = "";
        try {

            // Configura��es para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informa��o para definir se o request veio de voltar ou se o
            // fluxo � normal
            String fluxo = getFluxo(request);
            // Obtem o bean que representa a funcionalidade
            SolicitacaoAgendamentoBean solicitacaoBean = new SolicitacaoAgendamentoBean();
            SolicitacaoAgendamentoBean solicitacaoFiltroBean = new SolicitacaoAgendamentoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getRequestBean(request);

                /*
                 * Inicio da implementa��o para a navega��o. Para um correto
                 * funcionamento, � necess�rio que: Na estrat�gia *ManterIniciar
                 * o atributo navegacao seja atribuido com NAVEGACAO_FILTRO ou
                 * seja 0; Na p�gina que possui bot�es que executam outra
                 * estrat�gia e que se deseje voltar depois, � necess�rio
                 * colocar na a��o dos bot�es que chamem outra estrat�gia o
                 * atributo navegacao com valor NAVEGACAO_OUTRO ou seja 3.
                 * Exemplo: Na p�gina listagem, na a��o do Bot�o Alterar,
                 * atribui-se o valor 3 na navega��o, para que ao voltar a
                 * p�gina a ser exibida seja a lista de origem. Procurar nesta
                 * estrat�gia pela sequ�ncia de caracteres !@# nos coment�rios
                 * para saber se existe alguma implementa��o de navega��o fora
                 * deste bloco de coment�rio. Obtenho o bean de filtro para
                 * saber o valor da navega��o, e se for NAVEGACAO_FILTRO,
                 * obtenho o bean do request, e de acordo com os valores do
                 * filtro atribuio � navega��o o valor de acordo a a lista a ser
                 * exibida e direciono para a p�gina correta. Atentar para o
                 * detalhe de que existem dois beans, o filtroBean e o bean.
                 */
                solicitacaoFiltroBean = (SolicitacaoAgendamentoBean) solicitacaoFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);
                if (solicitacaoFiltroBean.getNavegacao()
                        .equals(NAVEGACAO_FILTRO)) {
                    solicitacaoFiltroBean = (SolicitacaoAgendamentoBean) solicitacaoFiltroBean.getRequestBean(request);
                    if (solicitacaoFiltroBean.getCodigoBancoSacado()
                            .equals(new Long(0))) {
                        solicitacaoFiltroBean.setNavegacao(NAVEGACAO_LISTA_1);
                        solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_1);
                    } else {
                        solicitacaoFiltroBean.setNavegacao(NAVEGACAO_LISTA_2);
                        solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_2);
                    }
                }
            } else {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getSessionBean(request,
                        DATA_BEAN);
                solicitacaoFiltroBean = (SolicitacaoAgendamentoBean) solicitacaoFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

                // !@# Fa�o a verifica��o do valor da navega��o para poder
                // identificar qual p�gina
                // deve ser exibida caso o usu�rio esteja voltando.
                if (solicitacaoBean.getNavegacao().equals(NAVEGACAO_LISTA_2)) {
                    solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_1);
                } else {
                    solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_2);
                }

            }
            // Fim da implementa��o da navega��o.

            // Definindo atributos para executar a transa��o BGM0 para obter o
            // cabe�alho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(solicitacaoBean.getCodigoCedente());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    solicitacaoBean.getCodigoCedente());
            request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);
            request.getSession().setAttribute(FILTRO_BEAN,
                    solicitacaoFiltroBean);

            CedenteCabecaBean cedBean = new CedenteCabecaBean();

            // Chamada ao Mainframe
           // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // Chama as Transac�es
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);

            // condi��o para quando � preenchido apenas o codigo do cedente no
            // filtro
            // Ira exibir nesta condi��o a lista com os bancos de sacados.
            if (solicitacaoBean.getNavegacao().equals(NAVEGACAO_LISTA_1)) {
                try {
                    solicitacaoFiltroBean.setCodigoBancoSacado(new Long(0));
                     transUser = TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                    /* BG53 */BeanList solicitacaoBeanList = handler.executeSimpleTransactionQuery(solicitacaoFiltroBean,
                    		transUser);
                    ArrayList sacadoArrayList = convertDataStructure(solicitacaoBeanList.iterator());
                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(sacadoArrayList));

                    // !@# Atribuindo a navega��o para possibilitar a correta
                    // navega��o
                    solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_2);

                    request.getSession().setAttribute(DATA_BEAN,
                            solicitacaoBean);
                    strRetorno = PAGE_MANTER_LISTAR_BCO;
                } catch (Exception e) {
                    cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                    cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                    request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                            cedBean);

                    throw e;
                }
            }

            // condi��o para quando todos os dados foram preenchidos no filtro
            // ou
            // o usu�rio selecionaou um bco sacado na lista 1
            else if (solicitacaoBean.getNavegacao().equals(NAVEGACAO_LISTA_2)) {

                // !@# Set para passar corretamente da lista de bco saca para a
                // lista de solicitacoes.
                SolicitacaoAgendamentoBean solicitacao = new SolicitacaoAgendamentoBean();
                if (solicitacaoFiltroBean.getNavegacao()
                        .equals(NAVEGACAO_LISTA_1)
                    && fluxo.equals(FLUXO_NORMAL)) {
                    solicitacao = (SolicitacaoAgendamentoBean) solicitacaoBean.clone();
                } else if (solicitacaoFiltroBean.getNavegacao()
                        .equals(NAVEGACAO_LISTA_1)
                           && fluxo.equals(FLUXO_VOLTAR)) {
                    solicitacao = (SolicitacaoAgendamentoBean) solicitacaoFiltroBean.clone();
                    solicitacao.setCodigoBancoSacado(solicitacaoBean.getCodigoBancoSacado());
                } else {
                    solicitacao = (SolicitacaoAgendamentoBean) solicitacaoFiltroBean.clone();
                }

                try {
                    // Obtendo a descricao do banco de sacados
                	
                    /* BG46 */
                	 transUser = BancoSacadoEstrategia.TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                	BeanList bancoSacadoBeanList = handler.executeSimpleTransactionQuery(solicitacaoBean,
                			transUser);
                    SolicitacaoAgendamentoBean bancoSacado = new SolicitacaoAgendamentoBean();
                    bancoSacado = (SolicitacaoAgendamentoBean) bancoSacadoBeanList.get(0);

                    // Obtendo as solicitacaoes
                    transUser = TRANSACAO_LISTAR_SOLICITACAO_AGENDAMENTO+ usuarioBean.getCodigoUsuario().toUpperCase();
                    /* BG54 */BeanList solicitacaoBeanList = handler.executeSimpleTransactionQuery(solicitacao,
                    		transUser);
                    ArrayList solicitacaoArrayList = convertDataStructure(solicitacaoBeanList.iterator());
                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(solicitacaoArrayList));

                    // Atribuindo ao bean os valores n�o obtidos na transa��o
                    // solicitacaoBean.setCodigoCedente(solicitacaoFiltroBean.getCodigoCedente());
                    // solicitacaoBean.setCodigoBancoSacado(solicitacaoFiltroBean.getCodigoBancoSacado());
                    solicitacaoBean.setNomeBancoSacado(bancoSacado.getNomeBancoSacado());

                    request.getSession().setAttribute(DATA_BEAN,
                            solicitacaoBean);
                    strRetorno = PAGE_MANTER_LISTAR;
                } catch (Exception e) {
                    cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                    cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                    request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                            cedBean);

                    throw e;
                }
            }

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso

            cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedBean);
            request.setAttribute(PAGINACAO_PAGE, "0");

        } catch (Exception e) {
            throw e;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)

        return strRetorno;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}