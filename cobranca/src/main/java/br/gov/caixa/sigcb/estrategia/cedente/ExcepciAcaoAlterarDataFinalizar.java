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
 * Alterar data Vigência >> Finalizar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ExcepciAcaoAlterarDataFinalizar extends ExcepciManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        ExcepcionacaoBean excepciBean = new ExcepcionacaoBean();
        DadosListaExcepciBean filtroBean = new DadosListaExcepciBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIO_LDAP);

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (DadosListaExcepciBean) filtroBean.getRequestBean(request);
            excepciBean = (ExcepcionacaoBean) excepciBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
        } else {
            filtroBean = (DadosListaExcepciBean) filtroBean.getSessionBean(request,
                    FILTRO_BEAN);
            excepciBean = (ExcepcionacaoBean) excepciBean.getSessionBean(request,
                    EXCEPCI_BEAN);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CEDENTE_CABECALHO_BEAN);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        excepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_ALT_DATA_VIGENCIA_FIM + usuarioBean.getCodigoUsuario().toUpperCase();

        handler.executeSimpleTransactionVoid(excepciBean,
        		transUser);

        return PAGE_SUCESSO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Data de Vigência alterada com Sucesso!");
        msgBean.setStrategyErrorReturn(STRATEGY_ACAO_ALT_DT_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_LISTA);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
