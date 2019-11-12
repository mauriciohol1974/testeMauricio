package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Incluir >>
 * Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BorderoIncluirFinalizar extends BorderoEstrategia {
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
            if (fluxo.equals(FLUXO_NORMAL)) {
                borderoBean = (BorderoBean) borderoBean.getRequestBean(request);
            } else {
                borderoBean = (BorderoBean) borderoBean.getSessionBean(request,
                        DATA_BEAN);
            }

            // Define manualmente atributos nao obtidos da jsp
            borderoBean.setTipoAcao("I");
            borderoBean.setNavegacao(NAVEGACAO_INCLUIR);

            // Separando a mensagem do text area
            borderoBean.setMsgFichaCompensacao(request.getParameter("msgFichaCompensacao"));
            ArrayList msgArrayList = quebraLinhas(borderoBean.getMsgFichaCompensacao());
            borderoBean.setMsgFichaCompensacaoL1(msgArrayList.get(0).toString());
            borderoBean.setMsgFichaCompensacaoL2(msgArrayList.get(1).toString());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(DATA_BEAN, borderoBean);

            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                    // o
                                                                                    // EJB
                                                                                    // que
                                                                                    // acessa
                                                                                    // o
                                                                                    // mainframe
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            if (borderoBean.getEnvioBloqueto()==0){
            	borderoBean.setEnvioBloqueto(1L);
            }
            BeanList borderoBeanList = handler.executeSimpleTransactionQuery(borderoBean,  TRANSACAO_INCLUIR_ALTERAR); // Chama a Transacao
            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            BorderoBean bean = (BorderoBean) borderoBeanList.get(0);
            borderoBean.setCodigoBordero(bean.getCodigoBordero());

            request.getSession().setAttribute(DATA_BEAN, borderoBean);

        } catch (Exception e) {
            throw e;
        }
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_INCLUIR);
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR);
        msgBean.setStrategySucessReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}