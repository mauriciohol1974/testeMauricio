package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BaixaEfetivaBean;
import br.gov.caixa.sigcb.bean.BaixaOperacionalBean;
import br.gov.caixa.sigcb.bean.CedBcoSBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DetalheBaixaOperBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class BaixaEfetivaDetalhe extends BaixaEfetivaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        
        String paginaOrigem = (String) request.getParameter("paginaOrigem");
    	String codigoCedente = (String) request.getParameter("codigoCedente");
    	String nossoNumero = (String) request.getParameter("nossoNumero");
    	String filtroSelecao = (String) request.getParameter("filtroSelecao");
    	
    	request.setAttribute("paginaOrigem", paginaOrigem);
    	request.setAttribute("codigoCedente", codigoCedente);
    	request.setAttribute("nossoNumero", nossoNumero);
    	request.setAttribute("filtroSelecao", filtroSelecao);

        // Recupera o bean
        BaixaEfetivaBean baixaBean = new BaixaEfetivaBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	baixaBean = (BaixaEfetivaBean) baixaBean.getRequestBean(request);
        } else {
        	baixaBean = (BaixaEfetivaBean) baixaBean.getSessionBean(request,   DATA_BEAN);
        }

        // Obtem informações do usuario
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);

      
        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();

        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        DetalheBaixaOperBean detalheBean = new DetalheBaixaOperBean();
        
        detalheBean.setNuIdentificacao(baixaBean.getNuIdentificacao());
        detalheBean.setNuIdentBaixa(baixaBean.getNuIdentiBaixaOper());
        detalheBean.setDthrbxoper(baixaBean.getDtHoraBaixaOper());

       
        // Chamada ao Mainframe]
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_BAIXA + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList detalheRetBean = handler.executeSimpleTransactionQuery(detalheBean,   transUser);
        
        detalheBean = (DetalheBaixaOperBean) detalheRetBean.get(0);
        detalheBean.setNuIdentificacao(baixaBean.getNuIdentificacao());
        detalheBean.setNuIdentBaixa(baixaBean.getNuIdentiBaixaOper());
        request.getSession().setAttribute(DATA_BEAN,detalheBean );

        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_LISTA);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
