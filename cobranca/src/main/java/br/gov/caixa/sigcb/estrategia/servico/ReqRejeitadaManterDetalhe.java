package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DetalheBaixaOperBean;
import br.gov.caixa.sigcb.bean.IndiceBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.ReqRejeitadaBean;
import br.gov.caixa.sigcb.bean.SacadoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Sacado >> Incluir >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>06/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class ReqRejeitadaManterDetalhe extends ReqRejeitadaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        ReqRejeitadaBean reqRejBean = new ReqRejeitadaBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	reqRejBean = (ReqRejeitadaBean) reqRejBean.getRequestBean(request);
        } else {
        	reqRejBean = (ReqRejeitadaBean) reqRejBean.getSessionBean(request,  FILTRO_BEAN_DETALHE);
        }
        
        
        request.getSession().setAttribute(FILTRO_BEAN_DETALHE,reqRejBean );
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_DETALHE + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList reqRej = handler.executeSimpleTransactionQuery(reqRejBean, transUser);
        


        reqRejBean = (ReqRejeitadaBean) reqRej.get(0);

        if (reqRejBean.getSr()==null){
        	reqRejBean.setSr(0L);
        }
        if (reqRejBean.getPv()==null){
        	reqRejBean.setPv(0L);
        }
        request.getSession().setAttribute(DATA_BEAN,reqRejBean );
       
        return PAGE_DETALHE;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
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