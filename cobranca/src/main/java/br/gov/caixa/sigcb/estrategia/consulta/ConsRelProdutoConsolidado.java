package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedBcoSBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.RelatorioBean;
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

public class ConsRelProdutoConsolidado extends ConsRelatorioEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Recupera o bean
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
        String transUser = TRANSACAO_LISTAR_PRODUTO_CONSOLIDADO + usuarioBean.getCodigoUsuario().toUpperCase();
        
        List consRelLista = handler.executeFixDataRecordsetTransaction(relAuditBean, transUser);

        // pega parte fixa dos dados
        RelatorioBean relFixoBean = (RelatorioBean) ((BeanList) consRelLista.get(0)).get(0);

        // pega a lista de beans parte variavel
        BeanList relListaBean = (BeanList) consRelLista.get(1);

        // converte a lista em um array de beans
        ArrayList relListaArrayListaBean = convertDataStructure(relListaBean.iterator());

        // Retem os beans de dados fixos e array
        request.getSession().setAttribute(DATA_BEAN, relFixoBean);
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(relListaArrayListaBean));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_LISTAR_PRODUTO_CONSOLIDADO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_PRODUTO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_LISTAR_PRODUTO_CONSOLIDADO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
