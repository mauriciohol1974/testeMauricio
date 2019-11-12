package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedBcoSBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;


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

public class CedBcoSManterFiltro extends CedBcoSEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Recupera o bean
        CedBcoSBean cedBcoBean = new CedBcoSBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            cedBcoBean = (CedBcoSBean) cedBcoBean.getRequestBean(request);
        } else {
            cedBcoBean = (CedBcoSBean) cedBcoBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, cedBcoBean);

        // REtem informações do usuario
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        // Instancia o EJB que acessa o mainframe
        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = CedBcoSEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Atribui dados não obtidos
        cedBcoBean.setUsuario(usuarioBean.getCodigoUsuario());

        // Executa a trasação
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_PV + usuarioBean.getCodigoUsuario().toUpperCase();
        List conGerLista = handler.executeFixDataRecordsetTransaction(cedBcoBean, 		transUser);

        // pega parte fixa dos dados
        CedBcoSBean conGerFixoBean = (CedBcoSBean) ((BeanList) conGerLista.get(0)).get(0);
        conGerFixoBean.setCodigoUnidadePV(cedBcoBean.getCodigoUnidadePV());

        // pega a lista de beans parte variavel
        BeanList conGerListaBean = (BeanList) conGerLista.get(1);

        // converte a lista em um array de beans
        ArrayList conGerArrayListaBean = convertDataStructure(conGerListaBean.iterator());

        // Retem os beans de dados fixos e array
        cedBcoBean.setNomeUnidadePV(conGerFixoBean.getNomeUnidadePV());
        request.getSession().setAttribute(FILTRO_BEAN, cedBcoBean);
        request.getSession().setAttribute(DATA_BEAN, conGerFixoBean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(conGerArrayListaBean));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_JSP_LISTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTA);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
