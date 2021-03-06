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
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerais -
 * Historico de Cedentes
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */

public class BaixaEfetivaManterFiltro extends BaixaEfetivaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        	String pagina = "";

        	String paginaOrigem = (String) request.getParameter("paginaOrigem");
        	String codigoCedente = (String) request.getParameter("codigoCedente");
        	String nossoNumero = (String) request.getParameter("nossoNumero");
        	String filtroSelecao = (String) request.getParameter("filtroSelecao");
        	
        	request.setAttribute("paginaOrigem", paginaOrigem);
        	
        	request.setAttribute("codigoCedente", codigoCedente);
        	request.setAttribute("nossoNumero", nossoNumero);
        	request.setAttribute("filtroSelecao", filtroSelecao);
        	
            // Configura��es para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informa��o para definir se o request veio de voltar ou se o
            // fluxo � normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            BaixaEfetivaBean baixaFiltroBean = new BaixaEfetivaBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                baixaFiltroBean = (BaixaEfetivaBean) baixaFiltroBean.getRequestBean(request);
            } else {
            	baixaFiltroBean = (BaixaEfetivaBean) baixaFiltroBean.getSessionBean(request, FILTRO_BEAN);
            }
            request.getSession().setAttribute("NU_IDENT",     baixaFiltroBean.getNuIdentificacao());
            request.getSession().setAttribute(FILTRO_BEAN,    baixaFiltroBean);
            request.getSession().setAttribute(DATA_BEAN,     baixaFiltroBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,        cedCabBean);

            // pega informa��es do usuario
            
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_BAIXA + usuarioBean.getCodigoUsuario().toUpperCase();
            
            BeanList baixaList = (BeanList)handler.executeSimpleTransactionQuery(baixaFiltroBean, transUser);

            ArrayList baixaArrayListaBean = convertDataStructure(baixaList.iterator());

            // lan�a os beans de dados de pagina��o
            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(baixaArrayListaBean));
            request.setAttribute(PAGINACAO_PAGE, "0");
            pagina = PAGE_LISTAR;


      
        return pagina;

        // return callPage;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
