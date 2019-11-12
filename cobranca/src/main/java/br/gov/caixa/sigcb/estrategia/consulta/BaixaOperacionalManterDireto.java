package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedBcoSBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.BaixaOperacionalBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
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

public class BaixaOperacionalManterDireto extends BaixaOperacionalEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String pagina = "";
       

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            String nuIdentificacao = (String) request.getParameter("nuIdentificacao");
            
            BaixaOperacionalBean baixaFiltroBean = new BaixaOperacionalBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
            	baixaFiltroBean = (BaixaOperacionalBean) baixaFiltroBean.getRequestBean(request);
            } else {
            	baixaFiltroBean = (BaixaOperacionalBean) baixaFiltroBean.getSessionBean(request, FILTRO_BEAN);
            }
            
            baixaFiltroBean.setNuIdentificacao(Long.valueOf(nuIdentificacao));;
            
            request.getSession().setAttribute("NU_IDENT",     baixaFiltroBean.getNuIdentificacao());
            request.getSession().setAttribute(FILTRO_BEAN,    baixaFiltroBean);
            request.getSession().setAttribute(DATA_BEAN,     baixaFiltroBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,        cedCabBean);

            // pega informações do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_BAIXA + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList baixaList = (BeanList)handler.executeSimpleTransactionQuery(baixaFiltroBean, transUser);

            ArrayList baixaArrayListaBean = convertDataStructure(baixaList.iterator());

            // lança os beans de dados de paginação
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
