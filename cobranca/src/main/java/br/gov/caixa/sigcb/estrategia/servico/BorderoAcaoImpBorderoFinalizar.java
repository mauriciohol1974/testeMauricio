package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.BorderoTituloBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Consultar >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BorderoAcaoImpBorderoFinalizar extends BorderoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean da funcionalidade
            BorderoBean borderoBean = new BorderoBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                borderoBean = (BorderoBean) borderoBean.getRequestBean(request);
            } else {
                borderoBean = (BorderoBean) borderoBean.getSessionBean(request,
                        DATA_BEAN);
            }

            // Define manualmente atributos nao obtidos da jsp

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(DATA_BEAN, borderoBean);

            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Chama aS Transacões

            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
            
            BeanList borderoBeanList = handler.executeSimpleTransactionQuery(borderoBean,
            		transUser);

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso

            BorderoTituloBean borderoTituloBean = new BorderoTituloBean();
            borderoTituloBean.setCodigoCedente(borderoBean.getCodigoCedente());
            borderoTituloBean.setCodigoBordero(borderoBean.getCodigoBordero());
            
             transUser = TRANSACAO_LISTAR_TITULO + usuarioBean.getCodigoUsuario().toUpperCase();
            
            List tituloList = (List) handler.executeFixDataRecordsetTransaction(borderoTituloBean,
            		transUser);

            borderoTituloBean = (BorderoTituloBean) ((BeanList) tituloList.get(0)).get(0);
            BeanList borderoTituloBeanList = (BeanList) tituloList.get(1);

            ArrayList tituloArrayList = convertDataStructure(borderoTituloBeanList.iterator());

            request.getSession().setAttribute(TituloEstrategia.FIXO_BEAN,
                    borderoTituloBean);
            request.getSession().setAttribute(LISTA_TITULO, tituloArrayList);

            BorderoBean bean = (BorderoBean) borderoBeanList.get(0);
            bean.setCodigoCedente(borderoBean.getCodigoCedente());
            bean.setCodigoBordero(borderoBean.getCodigoBordero());
            bean.setNavegacao(borderoBean.getNavegacao());

            request.getSession().setAttribute(DATA_BEAN, bean);

        } catch (Exception e) {
            throw e;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)

        return PAGE_IMPRIMIR;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_IMPRIMIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}