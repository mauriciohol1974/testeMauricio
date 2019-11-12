package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Geral
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaGeralFinalizar extends CedenteAlterarEstrategia {

    private HistoricoGuia historicoGuiaGeral = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_GERAL);
    
    private HistoricoGuia historicoGuiaCedenteEletronicoAgrup2 = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_CEDENTE_ELETRONICO_AGRUP);
    
    
    
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        CedenteGeralBean resposta = (CedenteGeralBean) (new CedenteGeralBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, geralBean);

        // setando atributos que nao vem da tela
        geralBean.setCodigoUsuario(this.getCodigoUsuario(request));
        geralBean.setTipoAcao(CedenteEstrategia.ALTERACAO);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList blResposta = handler.executeSimpleTransactionQuery(geralBean,
        		transUser);

        // seta no bean o tipo cobranca para controle da guia de Cedente
        // Eletronico
        // CedenteAlterarGuiaControle.setTipoCobranca(request,
        // geralBean.getTipoCobranca());

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteGeralBean) blResposta.get(0);
        } else {
            // CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean)
            // (new
            // CedenteGeralBean()).getSessionBean(request,CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS
            // );
            // historicoGuiaGeral.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);

            LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession()
                    .getAttribute(LISTA_GUIAS_ALTERADAS);
            listaGuiasAlteradas.add(historicoGuiaGeral);
            listaGuiasAlteradas.add(this.historicoGuiaCedenteEletronicoAgrup2);
        }

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_GERAL,
                PAGE_ALTERAR_PRINCIPAL);
    }

}
