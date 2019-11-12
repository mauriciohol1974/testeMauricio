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
public class ServIndiceManterIniciar extends IndiceEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        IndiceBean indiceBean = new IndiceBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	indiceBean = (IndiceBean) indiceBean.newBean();
        } else {
        	indiceBean = (IndiceBean) indiceBean.getSessionBean(request,  FILTRO_BEAN);
        }
        
      //  MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList indiceList = (BeanList)handler.executeSimpleTransactionQuery(indiceBean, transUser);

        ArrayList indiceListaBean = convertDataStructure(indiceList.iterator());

        // lança os beans de dados de paginação
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(indiceListaBean));
        request.setAttribute(PAGINACAO_PAGE, "0");
       


        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_LISTAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn("login.PaginaPrincipal");
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }
}