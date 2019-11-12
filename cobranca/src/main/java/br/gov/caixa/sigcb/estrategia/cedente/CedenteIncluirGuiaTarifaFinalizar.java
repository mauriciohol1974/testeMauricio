package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Tarifas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaTarifaFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).getRequestBean(request);
        CedenteTarifasBean resposta = (CedenteTarifasBean) (new CedenteTarifasBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.setAttribute(CEDENTE_TARIFAS_BEAN, tarifasBean);

        // Finaliza guia tarifas
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(tarifasBean,
        		transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteTarifasBean) blResposta.get(0);
        }

        // se inclusao com sucesso avanca a guia em cadastramento
        // e nao houver criticas
        if (tarifasBean.getTipoAcao().equals("I")
            && resposta.getDescricaoCriticas().trim().equals("")) {
            CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
        }

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_TARIFAS,
                PAGE_INCLUIR_PRINCIPAL);
    }

}
