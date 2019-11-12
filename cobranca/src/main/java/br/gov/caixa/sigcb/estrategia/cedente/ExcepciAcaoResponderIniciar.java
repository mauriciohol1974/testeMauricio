package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DadosListaExcepciBean;
import br.gov.caixa.sigcb.bean.ExcepcionacaoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionacao >>
 * responder Pendencia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ExcepciAcaoResponderIniciar extends ExcepciManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // configuração para mensagens e telas de erro e sucesso
        configMsgSucessoErro(request);

        // Obtem informações para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        DadosListaExcepciBean filtroExcepciBean = new DadosListaExcepciBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        ExcepcionacaoBean excepciBean = new ExcepcionacaoBean();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        ArrayList excepciArrayList = new ArrayList();

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroExcepciBean = (DadosListaExcepciBean) filtroExcepciBean.getRequestBean(request);
            PilhaVoltarControle.push(request, filtroExcepciBean);

            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);

            excepciBean.setCodigoCedente(filtroExcepciBean.getCodigoCedente());
            excepciBean.setNumeroPendencia(filtroExcepciBean.getNumeroPendencia());
            excepciBean.setNumeroReiteracao(filtroExcepciBean.getNumeroReiteracao());

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_DETALHES + usuarioBean.getCodigoUsuario().toUpperCase();

            // BG34
            List excepciList = handler.executeFixDataRecordsetTransaction(excepciBean,
            		transUser);

            excepciBean = (ExcepcionacaoBean) ((BeanList) excepciList.get(0)).get(0);
            BeanList excepciListaBeanList = (BeanList) excepciList.get(1);

            if (excepciListaBeanList.size() == 0) {
                LogUtilSigcb.warn("Lista de excepcionacoes vazia");
            }

            excepciArrayList = convertDataStructure(excepciListaBeanList.iterator());

            excepciBean.setSituacaoPendencia(filtroExcepciBean.getSituacaoPendencia());
            excepciBean.setDataPendenciaOrig(filtroExcepciBean.getDataPendencia());
            excepciBean.setNumeroPendencia(filtroExcepciBean.getNumeroPendencia());
            excepciBean.setNumeroReiteracao(filtroExcepciBean.getNumeroReiteracao());
            excepciBean.setCodigoCedente(filtroExcepciBean.getCodigoCedente());
            excepciBean.setDataSituacao(filtroExcepciBean.getDataSituacao());
            excepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(excepciArrayList));

        } else {
            excepciBean = (ExcepcionacaoBean) excepciBean.getSessionBean(request,
                    EXCEPCI_BEAN);
            PageHolder ph = (PageHolder) request.getSession()
                    .getAttribute(PAGINACAO_LIST);

            request.getSession().setAttribute(PAGINACAO_LIST, ph);

        }

        request.getSession().setAttribute(EXCEPCI_BEAN, excepciBean);
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        return PAGE_ACAO_RESPONDER;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_LISTA);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
