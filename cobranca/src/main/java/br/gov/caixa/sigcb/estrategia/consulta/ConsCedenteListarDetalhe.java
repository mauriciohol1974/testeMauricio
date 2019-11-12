package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BaixaEfetivaBean;
import br.gov.caixa.sigcb.bean.CedBcoSBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.BaixaOperacionalBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.RelatorioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Historico de Cedentes
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class ConsCedenteListarDetalhe extends ConsRelatorioEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        	
            configMsgSucessoErro(request);

            String fluxo = getFluxo(request);
            
            RelatorioBean relAuditBean = new RelatorioBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
            	relAuditBean = (RelatorioBean) relAuditBean.getRequestBean(request);
            } else {
            	relAuditBean = (RelatorioBean) relAuditBean.getSessionBean(request, FILTRO_BEAN);
            }
            
            request.getSession().setAttribute(FILTRO_BEAN,    relAuditBean);
                       
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_CEDENTE_DETALHE + usuarioBean.getCodigoUsuario().toUpperCase();
            
            BeanList relAuditList = (BeanList)handler.executeSimpleTransactionQuery(relAuditBean, transUser);

            ArrayList relAuditListArray = convertDataStructure(relAuditList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(relAuditListArray));
            request.setAttribute(PAGINACAO_PAGE, "0");
           
        return PAGE_LISTAR_CEDENTE_DETALHE;


    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_CEDENTE);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_LISTAR_CEDENTE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
