package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DadosListaExcepciBean;
import br.gov.caixa.sigcb.bean.ExcepcionacaoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionação >>
 * Consulta Detalhada
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ExcepciConsultarIniciar extends ExcepciManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // configuração para mensagens e telas de erro e sucesso
        configMsgSucessoErro(request);

        // Obtem informações para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // obtem o bean da funcionalidade
        DadosListaExcepciBean filtroExcepciBean = new DadosListaExcepciBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        ExcepcionacaoBean excepciBean = new ExcepcionacaoBean();

        /* nota */
        // obtendo o codigo do usuário que efetuou o login
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroExcepciBean = (DadosListaExcepciBean) filtroExcepciBean.getRequestBean(request);
            PilhaVoltarControle.push(request, filtroExcepciBean);

            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
        } else {
            filtroExcepciBean = (DadosListaExcepciBean) filtroExcepciBean.getSessionBean(request,
                    FILTRO_BEAN);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CEDENTE_CABECALHO_BEAN);
        }

        // Colocar o bean na session antes de acessar o mainframe
        request.getSession().setAttribute(FILTRO_BEAN, filtroExcepciBean);

        excepciBean.setCodigoCedente(filtroExcepciBean.getCodigoCedente());
        excepciBean.setNumeroPendencia(filtroExcepciBean.getNumeroPendencia());
        excepciBean.setNumeroReiteracao(filtroExcepciBean.getNumeroReiteracao());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_DETALHES + usuarioBean.getCodigoUsuario().toUpperCase();
        List excepciList = handler.executeFixDataRecordsetTransaction(excepciBean,
        		transUser);

        excepciBean = (ExcepcionacaoBean) ((BeanList) excepciList.get(0)).get(0);
        BeanList excepciListaBeanList = (BeanList) excepciList.get(1);

        ArrayList excepciArrayList = convertDataStructure(excepciListaBeanList.iterator());

        excepciBean.setSituacaoPendencia(filtroExcepciBean.getSituacaoPendencia());
        excepciBean.setDataPendenciaOrig(filtroExcepciBean.getDataPendencia());
        excepciBean.setNumeroPendencia(filtroExcepciBean.getNumeroPendencia());
        excepciBean.setNumeroReiteracao(filtroExcepciBean.getNumeroReiteracao());
        excepciBean.setCodigoCedente(filtroExcepciBean.getCodigoCedente());
        excepciBean.setDataSituacao(filtroExcepciBean.getDataSituacao());
        excepciBean.setDataVigenciaAte(filtroExcepciBean.getDataVigenciaAte());
        excepciBean.setDataVigenciaDe(filtroExcepciBean.getDataVigenciaDe());
        excepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

        request.getSession().setAttribute(EXCEPCI_BEAN, excepciBean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(excepciArrayList));

        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_CONSULTAR;
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
