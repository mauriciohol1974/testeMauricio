package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedCentBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
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

public class CedCentManterFiltro extends CedCentEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Recupera o bean
        CedCentBean cedCentBean = new CedCentBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            cedCentBean = (CedCentBean) cedCentBean.getRequestBean(request);
        } else {
            cedCentBean = (CedCentBean) cedCentBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        request.getSession().setAttribute(CEDENTE_ATUAL,
                cedCentBean.getCodigoCedente());

        // Cria e Define cabecalho cedente
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                CEDENTE_CABECALHO_BEAN);

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, cedCentBean);

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(cedCentBean.getCodigoCedente());

        // Chamada ao Mainframe para cabecalho cedente
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(cedCentBean.getCodigoCedente());
        cedCentBean.setUsuario(usuarioBean.getCodigoUsuario());

        // Guarda informacoes de cabecalho
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Chamada ao Mainframe
         transUser = TRANSACAO_CEDENTE_CENTRALIZADOR + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedCentListBean = handler.executeSimpleTransactionQuery(cedCentBean,
        		transUser);

        // converte a lista em um array de beans
        ArrayList cedCentArrayList = convertDataStructure(cedCentListBean.iterator());

        // Retem beans de dados fixos e array
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(cedCentArrayList));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_JSP_CONSULTAR;
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
