package br.gov.caixa.sigcb.estrategia.consulta;

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
import br.gov.caixa.sigcb.bean.TrilhaAuditoriaBean;
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
public class TrilhaAuditoriaListar extends TrilhaAuditoriaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
        String fluxo = getFluxo(request);
        
        TrilhaAuditoriaBean trilhaBean = new TrilhaAuditoriaBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	trilhaBean = (TrilhaAuditoriaBean) trilhaBean.newBean();
        	trilhaBean = (TrilhaAuditoriaBean) trilhaBean.getRequestBean(request);
        	request.getSession().setAttribute(FILTRO_BEAN, trilhaBean);
        } else {
            // eh preciso forcar os zeros.
        	trilhaBean = (TrilhaAuditoriaBean) trilhaBean.getSessionBean(request,  FILTRO_BEAN);
        }

        // Obtem informação para definir se o request veio de voltar ou se o
        
        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        List trilhaList = (List) handler.executeFixDataRecordsetTransaction(trilhaBean,   TRANSACAO_LISTAR);
        
        TrilhaAuditoriaBean trilhaBeanFixo = new TrilhaAuditoriaBean();
        trilhaBeanFixo = (TrilhaAuditoriaBean) ((BeanList) trilhaList.get(0)).get(0);
        trilhaBeanFixo.setCodigoCedente(trilhaBean.getCodigoCedente());
        

        // pega a lista de beans parte variavel
        BeanList ListaBean = (BeanList) trilhaList.get(1);

        // converte a lista em um array de beans
        ArrayList ArrayListaBean = convertDataStructure(ListaBean.iterator());
        
        request.getSession().setAttribute(DATA_BEAN,trilhaBeanFixo );
        request.getSession().setAttribute(PAGINACAO_LIST,   getPageHolder(ArrayListaBean));
        request.setAttribute(PAGINACAO_PAGE, "0");
        
        return PAGE_MANTER_LISTAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER);
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