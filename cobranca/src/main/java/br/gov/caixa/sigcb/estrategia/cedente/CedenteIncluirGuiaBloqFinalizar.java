package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Bloquetos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaBloqFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteBloquetosBean bloqBean = (CedenteBloquetosBean) (new CedenteBloquetosBean()).getRequestBean(request);
        CedenteBloquetosBean resposta = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.setAttribute(CEDENTE_BLOQUETOS_BEAN, bloqBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        if (bloqBean.getFormasAvisoProtesto() == null
            || bloqBean.getFormasAvisoProtesto().trim().equals("")) {
            bloqBean.setFormasAvisoProtesto("N");
        }
        if (bloqBean.getFormasAvisoVencido() == null
            || bloqBean.getFormasAvisoVencido().trim().equals("")) {
            bloqBean.setFormasAvisoVencido("N");
        }
        //bloqBean.setEnvioSMS("N"); // envio de SMS ainda não disponivel
        
        
        if (bloqBean.getQtdeBolMes()==null){
        	bloqBean.setQtdeBolMes(1L);
        	Money valormin = new Money(Util.zerosEsquerda(new Long(99999), 15), 2, Currency.real());
        	Money valormax = new Money(Util.zerosEsquerda(new Long(99999999), 15), 2, Currency.real());
        	bloqBean.setValorMinULCCA(valormin);
        	bloqBean.setValorMaxULCCA(valormax);
        } 
        
        
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        
        if (!usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
        	bloqBean.setQtdeBolMes(30L);
        	Money valormin = new Money(Util.zerosEsquerda(new Long(99999), 15), 2, Currency.real());
        	Money valormax = new Money(Util.zerosEsquerda(new Long(99999999), 15), 2, Currency.real());
        	bloqBean.setValorMinULCCA(valormin);
        	bloqBean.setValorMaxULCCA(valormax);
        }
        String transUser = TRANSACAO_INCLUIR_ALTERAR_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(bloqBean,transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteBloquetosBean) blResposta.get(0);
        }

        // se inclusao com sucesso avanca a guia em cadastramento
        // e nao houver criticas
        if (bloqBean.getTipoAcao().equals("I")
            && resposta.getDescricaoCriticas().trim().equals("")) {
            CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
        }

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_BLOQUETOS,
                PAGE_INCLUIR_PRINCIPAL);
    }

}
