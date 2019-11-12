package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Tarifa Manual >>
 * Excluir >> Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TarifaExcluirFinalizar extends TarifaManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Obtem o bean que representa a funcionalidade
            TarifaManualBean tarifaBean = new TarifaManualBean();
            if (fluxo.equals(FLUXO_NORMAL)) {
                tarifaBean = (TarifaManualBean) tarifaBean.getRequestBean(request);
            } else {
                tarifaBean = (TarifaManualBean) tarifaBean.getSessionBean(request,
                        DATA_BEAN);
            }

            PageHolder paginacao = (PageHolder) request.getSession()
                    .getAttribute(PAGINACAO_LIST);
            Pageable registroList = paginacao.getPageable();
            tarifaBean = (TarifaManualBean) registroList.get(tarifaBean.getRegistro()
                    .intValue());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(DATA_BEAN, tarifaBean);

            // Chamada ao Mainframe
          //  MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_EXCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(tarifaBean, transUser);

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            request.getSession().setAttribute(DATA_BEAN, tarifaBean);

            // Nome da JSP a ser chamada (nao possui o .jsp)

        } catch (Exception e) {

            throw e;
        }

        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_EXCLUIR);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setTitlePage(PAGE_TITLE_EXCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
