package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.IndiceBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.ReqRejeitadaBean;
import br.gov.caixa.sigcb.bean.SacadoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Sacado >> Incluir >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>06/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ReqRejeitadaManterMotivos extends ReqRejeitadaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        ReqRejeitadaBean reqRejBean = new ReqRejeitadaBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	reqRejBean = (ReqRejeitadaBean) reqRejBean.getRequestBean(request);
        } else {
        	reqRejBean = (ReqRejeitadaBean) reqRejBean.getSessionBean(request,  FILTRO_BEAN);
        }
        

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_MOTIVOS + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList reqRejList = (BeanList)handler.executeSimpleTransactionQuery(reqRejBean, transUser);

        ArrayList reqRejListBean = convertDataStructure(reqRejList.iterator());

        // lança os beans de dados de paginação
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(reqRejListBean));
        request.setAttribute(PAGINACAO_PAGE, "0");
        
       


        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_LISTAR_MOTIVOS;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("ERRO NA CONSULTA");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_CONSULTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }
}