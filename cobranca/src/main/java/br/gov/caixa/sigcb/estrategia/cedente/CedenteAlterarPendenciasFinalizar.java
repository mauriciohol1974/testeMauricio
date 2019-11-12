package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LogCedenteGuiasBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.alteracao.guias.cedente.AlteracaoGuiasManager;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente -
 * Itens Excepcionados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarPendenciasFinalizar extends CedenteAlterarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).getRequestBean(request);
        CedenteConclusaoBean resposta = (CedenteConclusaoBean) (new CedenteConclusaoBean()).newBean();

        String strRecordset = this.montaRecordset(request);

        // executa transacao
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        conclusaoBean.setCodigoUsuario(this.getCodigoUsuario(request));
        conclusaoBean.setStrRecordset(strRecordset);

        // BGH6
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_FINALIZAR_ALTERACAO_PARTE_1 + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(conclusaoBean,
        		transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteConclusaoBean) blResposta.get(0);

            // setando grupo funcional
            conclusaoBean.setPerfilUsuarioAlcada(resposta.getPerfilUsuarioAlcada());

            // setando numero pendencia
            conclusaoBean.setNumeroPendencia(resposta.getNumeroPendencia());

            request.setAttribute(CEDENTE_CONCLUSAO_BEAN, conclusaoBean);

        }

        // BGI0
        LogCedenteGuiasBean logCedenteGuiasBean = this.executaTransacoesGuias(request,
                handler,
                conclusaoBean.getNumeroPendencia());
        // BGH8
        String ip = request.getRemoteAddr();
        this.executaTransacoesDeFinalizacao(logCedenteGuiasBean,
                conclusaoBean,
                handler,ip);

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_PENDENCIAS,
                PAGE_SUCESSO);
    }

    private String montaRecordset(HttpServletRequest request) {
        PageHolder phExc = (PageHolder) request.getSession()
                .getAttribute(PAGINACAO_LIST);
        Pageable pbExc = phExc.getPageable();

        // tamanho dos campos
        Layout concLayout = (new CedenteConclusaoBean()).getLayout();
        MainframeExtension concExtension = ((MainframeExtension) concLayout.getExtension("Mainframe"));

        int tamCodigoItem = concExtension.get("codigoItem").getLength();

        String strRecordset = "";
        for (int i = 0; i < pbExc.size(); i++) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) pbExc.get(i);
            if (bean.isAgregado()) {
                strRecordset += Util.completaEspacos(bean.getCodigoItem(),
                        tamCodigoItem);
            }
        }

        StringBuffer sb = new StringBuffer(strRecordset);
        while (sb.length() < 720) {
            sb.append(" ");
        }

        return sb.toString();
    }

    private LogCedenteGuiasBean executaTransacoesGuias(HttpServletRequest request,
            MainFrameTransactionsSigcbEjb handler,
            Long numeroPendencia) throws Exception {
        CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean) (new CedenteGeralBean()).getSessionBean(request,
                CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS);
        LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession()
                .getAttribute(LISTA_GUIAS_ALTERADAS);
        AlteracaoGuiasManager alteracaoGuiasManager = new AlteracaoGuiasManager();
        return alteracaoGuiasManager.executarLogGuiasAlteradas(listaGuiasAlteradas,
                geralBeanTransacoesGuias,
                handler,
                TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2,
                numeroPendencia);
    }

    private BeanList executaTransacoesDeFinalizacao(LogCedenteGuiasBean logCedenteGuiasBean,
            CedenteConclusaoBean conclusaoBean,
            MainFrameTransactionsSigcbEjb handler, String ip) throws Exception {
        AlteracaoGuiasManager alteracaoGuiasManager = new AlteracaoGuiasManager();
        return alteracaoGuiasManager.executaTransacoesDeFinalizacao(logCedenteGuiasBean,
                conclusaoBean,
                handler, ip);
    }

}
