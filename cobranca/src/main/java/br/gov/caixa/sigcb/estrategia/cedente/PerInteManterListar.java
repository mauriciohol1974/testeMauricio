package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PerfilInternetBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/11/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class PerInteManterListar extends PerInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        PerfilInternetBean perfilInternetBean = new PerfilInternetBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            perfilInternetBean = (PerfilInternetBean) perfilInternetBean.getRequestBean(request);
        } else {
            perfilInternetBean = (PerfilInternetBean) perfilInternetBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, perfilInternetBean);
        request.getSession().setAttribute(FILTRO_BEAN, perfilInternetBean);

        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Determinar tipo de consulta
        BeanList perfilInternetBeanList;
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        
        perfilInternetBeanList = handler.executeSimpleTransactionQuery(perfilInternetBean,
        		transUser); // Chama a Transacao BGFG
        ArrayList perfilInternetList = convertDataStructure(perfilInternetBeanList.iterator());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(perfilInternetList));
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_MANTER_LISTAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}