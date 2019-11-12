package br.gov.caixa.sigcb.estrategia.servico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ClienteSINCEBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacaoOnlineBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Tarifa Manual >>
 * Manter >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloOnLineListar extends TituloOnLineEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
        String fluxo = getFluxo(request);
        
        LiquidacaoOnlineBean liquidacaoBean = new LiquidacaoOnlineBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	liquidacaoBean = (LiquidacaoOnlineBean) liquidacaoBean.newBean();
        	liquidacaoBean = (LiquidacaoOnlineBean) liquidacaoBean.getRequestBean(request);
        	request.getSession().setAttribute(FILTRO_BEAN, liquidacaoBean);
        } else {
            // eh preciso forcar os zeros.
        	liquidacaoBean = (LiquidacaoOnlineBean) liquidacaoBean.getSessionBean(request,  FILTRO_BEAN);
        }

        // Obtem informação para definir se o request veio de voltar ou se o
        
        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();

        BeanList liquidacaoBeanList = handler.executeSimpleTransactionQuery(liquidacaoBean,   transUser);
        
        ArrayList liquidacaoArray = convertDataStructure(liquidacaoBeanList.iterator());
       
        request.getSession().setAttribute(DATA_BEAN, liquidacaoBean);
        request.getSession().setAttribute(PAGINACAO_LIST,   getPageHolder(liquidacaoArray));
        request.setAttribute(PAGINACAO_PAGE, "0");
        
        return PAGE_MANTER_LISTAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    //
    // Metodo sobrescrito para setar atributo registro e o codigo do cedente
    //
    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }
}