package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.IndiceBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
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
public class ConsultarIndicePeriodoIniciar extends IndiceEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	
    	  // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        // Para funcionalidade Iniciar , deve-ser inicializar os atributos do
        // bean que aparecem na tela
        IndiceBean indiceBean = new IndiceBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	indiceBean = (IndiceBean) indiceBean.newBean();
        } else {
        	indiceBean = (IndiceBean) indiceBean.getSessionBean(request,    FILTRO_BEAN);
        }
        
        
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList indiceList = (BeanList)handler.executeSimpleTransactionQuery(indiceBean, transUser);

        ArrayList indiceListaBean = convertDataStructure(indiceList.iterator());
        
        
        request.getSession().setAttribute("cmbIndice", indiceListaBean);

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, indiceBean);
        request.getSession().setAttribute(DATA_BEAN, indiceBean);
    
    	
    	

        return PAGE_CONSULTAR_PERIODO;
    }

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
    	
    	  MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
          msgBean.setMsgError("");
          msgBean.setMsgSucess("");
          msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
          msgBean.setStrategySucessReturn("");
          msgBean.setTitlePage(PAGE_TITLE_INCLUIR_FILTRO);
          request.getSession().setAttribute(MSG_BEAN, msgBean);
    	
    }
}