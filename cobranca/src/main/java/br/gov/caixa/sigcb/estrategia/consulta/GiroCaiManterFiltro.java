package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.GiroCaixaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerais -
 * Giro Caixa
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */

public class GiroCaiManterFiltro extends GiroCaixaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String pagina = "";
        try {

            // Configura��es para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informa��o para definir se o request veio de voltar ou se o
            // fluxo � normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            GiroCaixaBean giroCaixaFiltroBean = new GiroCaixaBean();
            GiroCaixaBean giroCaixaBean = new GiroCaixaBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                giroCaixaBean = (GiroCaixaBean) giroCaixaBean.getRequestBean(request);

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
                giroCaixaFiltroBean = (GiroCaixaBean) giroCaixaFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);
                if (giroCaixaFiltroBean.getNavegacao().equals(NAVEGACAO_FILTRO)) {
                    giroCaixaFiltroBean = (GiroCaixaBean) giroCaixaFiltroBean.getRequestBean(request);
                    // Atribuindo a navega��o de acordo com os dados do filtro.
                    if (giroCaixaFiltroBean.getSelecaoRadio()
                            .equals(SELECAO_RADIO_CEDENTE)) {
                        giroCaixaFiltroBean.setNavegacao(NAVEGACAO_CONSULTA);
                        giroCaixaBean.setNavegacao(NAVEGACAO_CONSULTA);
                    } else if (giroCaixaFiltroBean.getSelecaoRadio()
                            .equals(SELECAO_RADIO_CPF_CNPJ)) {
                        giroCaixaFiltroBean.setNavegacao(NAVEGACAO_LISTA_CPF_CNPJ);
                        giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_CPF_CNPJ);
                    } else if (giroCaixaFiltroBean.getSelecaoRadio()
                            .equals(SELECAO_RADIO_UNIDADE)) {
                        if (giroCaixaFiltroBean.getSelecaoEnPV()
                                .equals(SELECAO_EN)) {
                            giroCaixaFiltroBean.setNavegacao(NAVEGACAO_LISTA_EN);
                            giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_EN);
                        } else if (giroCaixaFiltroBean.getSelecaoEnPV()
                                .equals(SELECAO_PV)) {
                            giroCaixaFiltroBean.setNavegacao(NAVEGACAO_LISTA_PV);
                            giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_PV);
                        }
                    }
                }
            } else {
                giroCaixaBean = (GiroCaixaBean) giroCaixaBean.getSessionBean(request,
                        DATA_BEAN);
                giroCaixaFiltroBean = (GiroCaixaBean) giroCaixaFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

                // !@# Fa�o a verifica��o do valor da navega��o para poder
                // identificar qual p�gina
                // deve ser exibida caso o usu�rio esteja voltando.
                if (giroCaixaFiltroBean.getSelecaoRadio()
                        .equals(SELECAO_RADIO_CPF_CNPJ)) {
                    giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_CPF_CNPJ);
                } else if (giroCaixaFiltroBean.getSelecaoRadio()
                        .equals(SELECAO_RADIO_UNIDADE)
                           && giroCaixaFiltroBean.getSelecaoEnPV()
                                   .equals(SELECAO_PV)) {
                    giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_PV);
                } else if (giroCaixaFiltroBean.getSelecaoRadio()
                        .equals(SELECAO_RADIO_UNIDADE)
                           && giroCaixaFiltroBean.getSelecaoEnPV()
                                   .equals(SELECAO_EN)) {
                    if (giroCaixaBean.getNavegacao().equals(NAVEGACAO_FINAL)) {
                        giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_PV);
                    } else {
                        giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_EN);
                    }
                }
            }
            // P/ n�o perder o ultimo cedente utilizado caso a consulta seja por
            // pv ou cpf
            if (giroCaixaFiltroBean.getCodigoCedente() != null) {
                if (!giroCaixaFiltroBean.getCodigoCedente().equals(new Long(0))) {
                    request.getSession().setAttribute(CEDENTE_ATUAL,
                            giroCaixaFiltroBean.getCodigoCedente());
                }
            }

            request.getSession().setAttribute(FILTRO_BEAN, giroCaixaFiltroBean);
            request.getSession().setAttribute(DATA_BEAN, giroCaixaFiltroBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);

            // Pega informa��es do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Ajuste para corrigir bug ao atualizar a p�gina.
            if (giroCaixaBean.getNavegacao().equals(new Long(0))) {
                giroCaixaBean.setNavegacao(giroCaixaFiltroBean.getNavegacao());
            }
            // Exibir a Tela de Consulta GiroCaixa
            if (giroCaixaBean.getNavegacao().equals(NAVEGACAO_CONSULTA)) {
                // Definindo atributos para executar a transa��o BGM0 para obter
                // o cabe�alho
                cedCabBean.setTipoConsulta(new Long(1));
                cedCabBean.setOrigemConsulta(new Long(1));
                cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
                cedCabBean.setCodigoCedente(giroCaixaBean.getCodigoCedente());

                // Chamada ao Mainframe para cabecalho cedente
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
                BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                		transUser);
                cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

                cedCabBean.setCodigoCedente(giroCaixaBean.getCodigoCedente());

                // Guarda informacoes de cabecalho
                request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                        cedCabBean);

                // faz chamada da transacao de consulta BGA4
                 transUser = TRANSACAO_CEDENTE_GIRO_CAIXA + usuarioBean.getCodigoUsuario().toUpperCase();
                BeanList giroCaixaListBean = handler.executeSimpleTransactionQuery(giroCaixaBean,
                		transUser);

                giroCaixaBean = (GiroCaixaBean) giroCaixaListBean.get(0);
                giroCaixaBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                giroCaixaBean.setNavegacao(NAVEGACAO_FINAL);

                // lan�a os beans de dados fixos e array
                request.getSession().setAttribute(DATA_BEAN, giroCaixaBean);

                pagina = PAGE_JSP_CONSULTAR;
            }

            else if (giroCaixaBean.getNavegacao()
                    .equals(NAVEGACAO_LISTA_CPF_CNPJ)) {

                giroCaixaBean.setTipoConsulta(new Long(1)); // Cpf/Cnpj
                giroCaixaBean.setTipoPessoa(giroCaixaFiltroBean.getTipoPessoa());
                giroCaixaBean.setCpfCnpj(giroCaixaFiltroBean.getCpfCnpj());
                giroCaixaBean.setUsuario(usuarioBean.getCodigoUsuario());

                // faz chamada da transacao BGA3
                String  transUser = TRANSACAO_CEDENTE_CPF_CNPJ_PV + usuarioBean.getCodigoUsuario().toUpperCase();
                List giroCaixaList = handler.executeFixDataRecordsetTransaction(giroCaixaBean,
                		transUser);

                giroCaixaBean = (GiroCaixaBean) ((BeanList) giroCaixaList.get(0)).get(0);

                giroCaixaBean.setTipoPessoa(giroCaixaFiltroBean.getTipoPessoa());
                giroCaixaBean.setCpfCnpj(giroCaixaFiltroBean.getCpfCnpj());
                giroCaixaBean.setNavegacao(NAVEGACAO_CONSULTA);
                // lan�a os beans de dados fixos
                request.getSession().setAttribute(DATA_BEAN, giroCaixaBean);

                // pega a lista de beans parte variavel
                BeanList giroCaixaListBean = (BeanList) giroCaixaList.get(1);

                // converte a lista em um array de beans
                ArrayList giroCaixaArrayListBean = convertDataStructure(giroCaixaListBean.iterator());

                // lan�a os beans de dados de pagina��o
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(giroCaixaArrayListBean));
                request.setAttribute(PAGINACAO_PAGE, "0");
                pagina = PAGE_JSP_LISTAR_CPFCNPJ;
            }

            else if (giroCaixaBean.getNavegacao().equals(NAVEGACAO_LISTA_EN)) {

                // chama a transacao BGA2 com o codigo de PV
            	String  transUser = TRANSACAO_CEDENTE_UNID_EN + usuarioBean.getCodigoUsuario().toUpperCase();
                List giroCaixaList = handler.executeFixDataRecordsetTransaction(giroCaixaFiltroBean,
                		transUser);

                giroCaixaBean = (GiroCaixaBean) ((BeanList) giroCaixaList.get(0)).get(0);
                giroCaixaBean.setNavegacao(NAVEGACAO_LISTA_PV);
                giroCaixaBean.setCodigoUnidadeEN(giroCaixaFiltroBean.getCodigoUnidadeEN());

                // lan�a os beans de dados fixos
                request.getSession().setAttribute(DATA_BEAN, giroCaixaBean);

                // pega a lista de beans parte variavel
                BeanList giroListaBean = (BeanList) giroCaixaList.get(1);

                // converte a lista em um array de beans
                ArrayList giroArrayListaBean = convertDataStructure(giroListaBean.iterator());

                // lan�a os beans de dados de pagina��o
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(giroArrayListaBean));
                request.setAttribute(PAGINACAO_PAGE, "0");
                pagina = PAGE_JSP_LISTAR_UNIDEN;

            }

            else if (giroCaixaBean.getNavegacao().equals(NAVEGACAO_LISTA_PV)) {

                giroCaixaBean.setTipoConsulta(new Long(2)); // PV
                giroCaixaBean.setTipoPessoa(new Long(0));
                giroCaixaBean.setCpfCnpj(new Long(0));
                giroCaixaBean.setCodigoUnidadePV(giroCaixaBean.getCodigoUnidadePV());
                giroCaixaBean.setUsuario(usuarioBean.getCodigoUsuario());

                // chama a transacao BGA3 com o codigo de PV
                String  transUser = TRANSACAO_CEDENTE_CPF_CNPJ_PV + usuarioBean.getCodigoUsuario().toUpperCase();
                List giroCaixaList = handler.executeFixDataRecordsetTransaction(giroCaixaBean,
                		transUser);

                GiroCaixaBean giroCBean = new GiroCaixaBean();

                giroCBean = (GiroCaixaBean) ((BeanList) giroCaixaList.get(0)).get(0);
                giroCaixaBean.setNomeUnidadePV(giroCBean.getNomeUnidadePV());

                giroCaixaBean.setNavegacao(NAVEGACAO_CONSULTA);

                // lan�a os beans de dados fixos
                request.getSession().setAttribute(DATA_BEAN, giroCaixaBean);

                // pega a lista de beans parte variavel
                BeanList giroListaBean = (BeanList) giroCaixaList.get(1);

                // converte a lista em um array de beans
                ArrayList giroArrayListaBean = convertDataStructure(giroListaBean.iterator());

                // lan�a os beans de dados de pagina��o
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(giroArrayListaBean));
                request.setAttribute(PAGINACAO_PAGE, "0");
                pagina = PAGE_JSP_LISTAR_UNIDPV;

            }

        } catch (Exception e) {
            throw e;
        }
        return pagina;

        // return callPage;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTA);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
