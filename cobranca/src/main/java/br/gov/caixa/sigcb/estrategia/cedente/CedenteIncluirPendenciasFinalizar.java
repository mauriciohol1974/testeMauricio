package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente -
 * Itens Excepcionados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirPendenciasFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).getRequestBean(request);
        CedenteConclusaoBean resposta = (CedenteConclusaoBean) (new CedenteConclusaoBean()).newBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        conclusaoBean.setCodigoUsuario(this.getCodigoUsuario(request));
        conclusaoBean.setExcepcionacao("S"); // finaliza com excepcionacao
        String ip = request.getRemoteAddr();
        conclusaoBean.setIp(ip);
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_FINALIZAR_INCLUSAO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(conclusaoBean,
        		transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteConclusaoBean) blResposta.get(0);

            // se houver criticas volta para pagina de pendencias
            if (resposta.getDescricaoCriticas() != null
                && !resposta.getDescricaoCriticas().trim().equals("")) {
                return CedenteIncluirGuiaControle.proximaGuia(request,
                        resposta.getDescricaoCriticas(),
                        PAGE_INCLUIR_PENDENCIAS,
                        PAGE_SUCESSO);
            }

            // setando o codigo cedente no bean
            conclusaoBean.setCodigoCedente(resposta.getCodigoCedente());

            // seta o Cedente Padrao
            this.setCedentePadrao(request, resposta.getCodigoCedente());

            // setando numero pendencia
            conclusaoBean.setNumeroPendencia(resposta.getNumeroPendencia());

            // perfil alcada
            conclusaoBean.setPerfilUsuarioAlcada(resposta.getPerfilUsuarioAlcada());

            request.setAttribute(CEDENTE_CONCLUSAO_BEAN, conclusaoBean);
        }

        // Chama inclusao do SICLI
        handler.executeSimpleTransactionVoid(conclusaoBean,
                TRANSACAO_INCLUSAO_ALTERACAO_SICLI);

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_PENDENCIAS,
                PAGE_SUCESSO);
    }

}
