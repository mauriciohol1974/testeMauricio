package br.gov.caixa.sigcb.estrategia.servico;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteMensagensBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Incluir >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BorderoIncluirFiltro extends BorderoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean que representa a funcionalidade
            BorderoBean borderoBean = new BorderoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            CedenteGeralBean cedGeralBean = new CedenteGeralBean();
            cedGeralBean = (CedenteGeralBean) cedGeralBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                borderoBean = (BorderoBean) borderoBean.getRequestBean(request);
                borderoBean.setTipoJurosDia(new Long(-999)); // Set
                                                                // necessário
                                                                // pois a
                                                                // transação
                                                                // retorna
                                                                // registro com
                                                                // codigo 0
            } else {
                borderoBean = (BorderoBean) borderoBean.getSessionBean(request,
                        DATA_BEAN);
            }

            // Define manualmente atributos nao obtidos da jsp
            borderoBean.setDataMovimento(Calendar.getInstance().getTime());

            // Inicializando o textarea com apenas 2 linhas
            borderoBean.setMsgFichaCompensacao(inicializaTextArea(request,
                    borderoBean));

            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(borderoBean.getCodigoCedente());

            // Definindo atributos para executar a transação BG03 para obter
            // informações do cedente para setar campos
            cedGeralBean.setTipoConsulta("C");
            cedGeralBean.setCodigoCedente(borderoBean.getCodigoCedente());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    borderoBean.getCodigoCedente());
            request.getSession().setAttribute(FILTRO_BEAN, borderoBean);
            request.getSession().setAttribute(DATA_BEAN, borderoBean);

            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // Chama aS Transacões
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,  transUser);
             transUser = TRANSACAO_CEDENTE_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList cedGeralBeanList = handler.executeSimpleTransactionQuery(cedGeralBean,   transUser);

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            CedenteGeralBean bean = (CedenteGeralBean) cedGeralBeanList.get(0);
            borderoBean.setVinculacaoPV(bean.getCodigoUnidadePVVinc());

            // Obtendo os dados da guia bloquetos
            getDadosGuiaBloqueto(request, borderoBean);

            request.getSession().setAttribute(DATA_BEAN, borderoBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    (CedenteCabecaBean) cedCabBeanList.get(0));
            request.getSession().setAttribute(CEDENTE_GERAL_BEAN, bean);

        } catch (Exception e) {
            throw e;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_INCLUIR;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    private void getDadosGuiaBloqueto(HttpServletRequest request,
            BorderoBean borderoBean) throws Exception {
        CedenteBloquetosBean cedBloqBean = new CedenteBloquetosBean();
        cedBloqBean.newBean();
        cedBloqBean.setTipoConsulta("C");
        cedBloqBean.setCodigoCedente(borderoBean.getCodigoCedente());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // BG11
        BeanList cedBloqBeanList = handler.executeSimpleTransactionQuery(cedBloqBean,
                TRANSACAO_CEDENTE_BLOQUETOS);

        cedBloqBean = (CedenteBloquetosBean) cedBloqBeanList.get(0);

        request.getSession().setAttribute(CEDENTE_BLOQUETO_BEAN, cedBloqBean);
    }

    private String[] getDadosGuiaMensagem(HttpServletRequest request,
            BorderoBean borderoBean) throws Exception {
        CedenteMensagensBean cedMsgBean = new CedenteMensagensBean();
        cedMsgBean.newBean();
        cedMsgBean.setTipoConsulta("C");
        cedMsgBean.setLocalImpressao(CEDENTE_MENSAGEM_LOCAL_IMPRESSAO);
        cedMsgBean.setCodigoCedente(borderoBean.getCodigoCedente());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // BG13

        BeanList cedMsgBeanList = handler.executeSimpleTransactionQuery(cedMsgBean,
                TRANSACAO_CEDENTE_MENSAGEM);

        String[] mensagem = new String[cedMsgBeanList.size()];
        for (int i = 0; i < cedMsgBeanList.size(); i++) {
            cedMsgBean = (CedenteMensagensBean) cedMsgBeanList.get(i);
            mensagem[cedMsgBean.getNumeroLinhaMensagem().intValue() - 1] = cedMsgBean.getMensagem();
        }
        return mensagem;
    }

    private String inicializaTextArea(HttpServletRequest request,
            BorderoBean borderoBean) throws Exception {
        String[] mensagem = getDadosGuiaMensagem(request, borderoBean);
        String barraEne = "\n";
        String barraEne2 = "\n\n";
        String retorno = "";

        // apenas irá utilizar o valor cadastrado no cedente quando entra na
        // tela
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            if (mensagem[0].trim().equals("")) {
                retorno = mensagem[0] + barraEne2 + mensagem[1] + barraEne;
            } else {
                retorno = mensagem[0] + barraEne + mensagem[1] + barraEne;
            }
        } else {
            if (borderoBean.getMsgFichaCompensacaoL1().trim().equals("")) {
                retorno = borderoBean.getMsgFichaCompensacaoL1()
                          + barraEne2
                          + borderoBean.getMsgFichaCompensacaoL2()
                          + barraEne;
            } else if (!borderoBean.getMsgFichaCompensacaoL1()
                    .trim()
                    .equals("")) {
                retorno = borderoBean.getMsgFichaCompensacaoL1()
                          + barraEne
                          + borderoBean.getMsgFichaCompensacaoL2()
                          + barraEne;
            }
        }
        return retorno;
    }
}