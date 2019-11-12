package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerValLancadosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ValLancManterFiltro extends ValLancManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String fluxo = getFluxo(request);

        configMsgSucessoErro(request);

        ConGerValLancadosBean valLancBean = new ConGerValLancadosBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            valLancBean = (ConGerValLancadosBean) valLancBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);

        } else {
            valLancBean = (ConGerValLancadosBean) valLancBean.getSessionBean(request,
                    FILTRO_BEAN);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CABECALHO_BEAN);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // BGM0 - Obtendo os dados do cabeçalho do cedeente

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");

        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(valLancBean.getCodigoCedente());

        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                TRANSACAO_CEDENTE_CABECALHO);

        // setando o codigo de cedente no bean de cabeçalho
        CedenteCabecaBean cabecalhoBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        cabecalhoBean.setCodigoCedente(valLancBean.getCodigoCedente());

        request.getSession().setAttribute(CABECALHO_BEAN, cabecalhoBean);

        // BGD6 - Obtendo os dados de unidades por cedente

        // enviando o bean para session antes de chamar a transac. e enviando o
        // cedente padrao para a session
        request.getSession().setAttribute(CEDENTE_ATUAL,
                valLancBean.getCodigoCedente());
        request.getSession().setAttribute(FILTRO_BEAN, valLancBean);

        BeanList valLancBeanList = handler.executeSimpleTransactionQuery(valLancBean,
                TRANSACAO_UNIDADES_POR_CEDENTE);
        ArrayList unidadesArrayList = convertDataStructure(valLancBeanList.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(unidadesArrayList));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_LISTA;

    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
