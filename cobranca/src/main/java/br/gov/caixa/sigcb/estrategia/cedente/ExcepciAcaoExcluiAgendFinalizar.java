package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DadosListaExcepciBean;
import br.gov.caixa.sigcb.bean.ExcepcionacaoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionação >>
 * Excluir Agendamento
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ExcepciAcaoExcluiAgendFinalizar extends ExcepciManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        DadosListaExcepciBean filtroBean = new DadosListaExcepciBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        ExcepcionacaoBean excepciBean = new ExcepcionacaoBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIO_LDAP);

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (DadosListaExcepciBean) filtroBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
        } else {
            filtroBean = (DadosListaExcepciBean) filtroBean.getSessionBean(request,
                    FILTRO_BEAN);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CEDENTE_CABECALHO_BEAN);
        }

        excepciBean = (ExcepcionacaoBean) excepciBean.getRequestBean(request);
        if (excepciBean == null) {
            excepciBean = (ExcepcionacaoBean) excepciBean.getSessionBean(request,
                    EXCEPCI_BEAN);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        excepciBean.setCodigoCedente(filtroBean.getCodigoCedente());
        excepciBean.setNumeroPendencia(filtroBean.getNumeroPendencia());
        excepciBean.setNumeroReiteracao(filtroBean.getNumeroReiteracao());
        excepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        excepciBean.setMeioEntrada(new Long(1));

        request.getSession().setAttribute(EXCEPCI_BEAN, excepciBean);
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_EXCLUIR_AGENDAMENTO + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(excepciBean,
        		transUser);

        return PAGE_SUCESSO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Agendamento Excluído com Sucesso!");
        msgBean.setStrategyErrorReturn(STRATEGY_LISTA);
        msgBean.setStrategySucessReturn(STRATEGY_LISTA);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
