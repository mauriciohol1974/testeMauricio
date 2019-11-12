package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirIniciar extends CedenteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            this.configMsgSucessoErro(request);

            this.limpaBeans(request);

            PrivilegioUsuarioBean privilegio = (PrivilegioUsuarioBean) (new PrivilegioUsuarioBean()).newBean();

            // descobre cargo e pv que o usuario eh vinculado
            privilegio.setCodigoUsuario(this.getCodigoUsuario(request));
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_USUARIO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList privilegioList = handler.executeSimpleTransactionQuery(privilegio,
            		transUser);
            privilegio = (PrivilegioUsuarioBean) privilegioList.get(0);

            request.getSession().setAttribute(PRIVILEGIO_BEAN, privilegio);

        } catch (Exception e) {
            LogUtilSigcb.debug("Excecao CedenteIncluirIniciar", e);
            throw e;
        }

        return PAGE_INCLUIR_FILTRO;
    }

    private void limpaBeans(HttpServletRequest request) {
        request.getSession().setAttribute(CEDENTE_CABECA_BEAN, null);
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn("login.PaginaPrincipal");
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
