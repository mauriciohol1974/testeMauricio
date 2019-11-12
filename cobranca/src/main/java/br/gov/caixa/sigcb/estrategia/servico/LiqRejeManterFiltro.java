package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.ComboTipoMeioLiquidacao;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Liquidacoes Rejeitadas >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>27/08/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class LiqRejeManterFiltro extends LiqRejeManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            // System.out.println("#$% comeco " + this.getClass().getName());

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean da funcionalidade
            LiquidacoesRejeitadaBean filtroBean = new LiquidacoesRejeitadaBean();
            if (fluxo.equals(FLUXO_NORMAL)) {
                filtroBean = (LiquidacoesRejeitadaBean) filtroBean.getRequestBean(request);
            } else {
                filtroBean = (LiquidacoesRejeitadaBean) filtroBean.getSessionBean(request,
                        FILTRO_BEAN);
            }

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(FILTRO_BEAN, filtroBean);

            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                    // o
                                                                                    // EJB
                                                                                    // que
                                                                                    // acessa
                                                                                    // o
                                                                                    // mainframe
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList liqRejeBeanList = handler.executeSimpleTransactionQuery(filtroBean,    transUser); // Chama a Transacao

            ArrayList liqRejeList = this.convertDataStructure(liqRejeBeanList.iterator());

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(liqRejeList));
            request.setAttribute(PAGINACAO_PAGE, "0");

            // System.out.println("#$% fim " + this.getClass().getName());
        } catch (Exception ex) {
            // ex.printStackTrace();
            throw ex;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_LISTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    //
    // Metodo sobrescrito para setar atributo registro
    //
    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        int i = 0;
        while (iterator.hasNext()) {
            LiquidacoesRejeitadaBean bean = (LiquidacoesRejeitadaBean) iterator.next();
            bean.setRegistro(new Long(i));
            try {
                bean.setMeioLiquidacaoDescricao(new ComboTipoMeioLiquidacao().getDescricao(bean.getMeioLiquidacao()));
            } catch (JspException e) {
                LogUtilSigcb.error(e.getMessage());
            }
            list.add(bean);
            i++;
        }
        return list;
    }
}
