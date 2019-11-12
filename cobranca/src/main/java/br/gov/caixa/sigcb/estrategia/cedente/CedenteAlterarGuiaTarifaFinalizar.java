package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Tarifas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaTarifaFinalizar extends CedenteAlterarEstrategia {

    private HistoricoGuia historicoGuiaTarifa = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_TARIFA);

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

        tarifasBean.setTipoAcao(ALTERACAO);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(tarifasBean,transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteTarifasBean) blResposta.get(0);
        } else {
            // Obtendo dados da guia geral para saber tipo de Cobranca
            // CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean)
            // (new
            // CedenteGeralBean()).getSessionBean(request,CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS
            // );
            // this.historicoGuiaTarifa.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);
            LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession()
                    .getAttribute(LISTA_GUIAS_ALTERADAS);
            listaGuiasAlteradas.add(this.historicoGuiaTarifa);
        }

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_TARIFAS,
                PAGE_ALTERAR_PRINCIPAL);
    }

}
