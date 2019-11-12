package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente -
 * Cancelar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarCancelar extends CedenteAlterarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            this.configMsgSucessoErro(request, SUCESSO_ALTERAR_CANCELAMENTO);

            CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).getRequestBean(request);
            conclusaoBean.setTipoAcao(ALTERACAO);

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CANCELAR_INCLUSAO + usuarioBean.getCodigoUsuario().toUpperCase();
            
            handler.executeSimpleTransactionVoid(conclusaoBean, transUser);

        } catch (Exception ex) {
            LogUtilSigcb.debug("Excecao CedenteAlterarCancelar", ex);
            throw ex;
        }

        return PAGE_SUCESSO;
    }

}
