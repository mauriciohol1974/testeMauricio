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
 * Componente responsável pelo controle da funcionalidade
 * Solicitacao/Agendamento >> Manter >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SoAgTitManterFiltro extends SolicitacaoAgendamentoEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String strRetorno = "";
        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean que representa a funcionalidade
            SolicitacaoAgendamentoBean solicitacaoBean = new SolicitacaoAgendamentoBean();
            SolicitacaoAgendamentoBean solicitacaoFiltroBean = new SolicitacaoAgendamentoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getRequestBean(request);

                /*
                 * Inicio da implementação para a navegação. Para um correto
                 * funcionamento, é necessário que: Na estratégia *ManterIniciar
                 * o atributo navegacao seja atribuido com NAVEGACAO_FILTRO ou
                 * seja 0; Na página que possui botões que executam outra
                 * estratégia e que se deseje voltar depois, é necessário
                 * colocar na ação dos botões que chamem outra estratégia o
                 * atributo navegacao com valor NAVEGACAO_OUTRO ou seja 3.
                 * Exemplo: Na página listagem, na ação do Botão Alterar,
                 * atribui-se o valor 3 na navegação, para que ao voltar a
                 * página a ser exibida seja a lista de origem. Procurar nesta
                 * estratégia pela sequência de caracteres !@# nos comentários
                 * para saber se existe alguma implementação de navegação fora
                 * deste bloco de comentário. Obtenho o bean de filtro para
                 * saber o valor da navegação, e se for NAVEGACAO_FILTRO,
                 * obtenho o bean do request, e de acordo com os valores do
                 * filtro atribuio à navegação o valor de acordo a a lista a ser
                 * exibida e direciono para a página correta. Atentar para o
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

                // !@# Faço a verificação do valor da navegação para poder
                // identificar qual página
                // deve ser exibida caso o usuário esteja voltando.
                if (solicitacaoBean.getNavegacao().equals(NAVEGACAO_LISTA_2)) {
                    solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_1);
                } else {
                    solicitacaoBean.setNavegacao(NAVEGACAO_LISTA_2);
                }

            }
            // Fim da implementação da navegação.

            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
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

            // Chama as Transacões
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);

            // condição para quando é preenchido apenas o codigo do cedente no
            // filtro
            // Ira exibir nesta condição a lista com os bancos de sacados.
            if (solicitacaoBean.getNavegacao().equals(NAVEGACAO_LISTA_1)) {
                try {
                    solicitacaoFiltroBean.setCodigoBancoSacado(new Long(0));
                     transUser = TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                    /* BG53 */BeanList solicitacaoBeanList = handler.executeSimpleTransactionQuery(solicitacaoFiltroBean,
                    		transUser);
                    ArrayList sacadoArrayList = convertDataStructure(solicitacaoBeanList.iterator());
                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(sacadoArrayList));

                    // !@# Atribuindo a navegação para possibilitar a correta
                    // navegação
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

            // condição para quando todos os dados foram preenchidos no filtro
            // ou
            // o usuário selecionaou um bco sacado na lista 1
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

                    // Atribuindo ao bean os valores não obtidos na transação
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

    // Configurações para Mensagens e Telas de Erro e Sucesso
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