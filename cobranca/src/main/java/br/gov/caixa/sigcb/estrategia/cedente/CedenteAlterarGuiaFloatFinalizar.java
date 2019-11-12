package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteFloatBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;

import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente (Guia
 * Float)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaFloatFinalizar extends CedenteAlterarEstrategia {

    private HistoricoGuia historicoGuiaFloat = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_FLOAT);

    // Meios de Entrada
    public static final int CAIXA_DINHEIRO = 4;

    public static final int CAIXA_CHEQUE = 5;

    public static final int LOTERICO_DINHEIRO = 6;

    public static final int LOTERICO_CHEQUE = 7;

    public static final int COMPENSACAO = 8;

    public static final int AUTO_ATENDIMENTO = 9;

    public static final int CORRESPONDENTE_BANCARIO = 10;

    public static final int INTERNET_BANKING = 11;

    public static final int STR_TED = 12;
    
    public static final int MOBILE = 13;

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        CedenteFloatBean bean = (CedenteFloatBean) (new CedenteFloatBean()).getRequestBean(request);
        CedenteFloatBean resposta = (CedenteFloatBean) (new CedenteFloatBean()).newBean();

        // seta o que o usuario digitou caso aconteca algum erro
        request.getSession().setAttribute(FLOAT_LISTA,
                this.salvaDadosDigitados(bean));

        this.initMeioEntrada(bean);
        bean.setTipoAcao(ALTERACAO);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_FLOAT + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(bean,transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteFloatBean) blResposta.get(0);
        } else {
            // Obtendo dados da guia geral para saber tipo de Cobranca
            // CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean)
            // (new
            // CedenteGeralBean()).getSessionBean(request,CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS
            // );
            // this.historicoGuiaFloat.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);
            LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession().getAttribute(LISTA_GUIAS_ALTERADAS);
            listaGuiasAlteradas.add(this.historicoGuiaFloat);
        }

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_FLOAT,
                PAGE_ALTERAR_PRINCIPAL);
    }

    private void initMeioEntrada(CedenteFloatBean bean) {
        bean.setMeioEntradaCaixaDinheiro(new Long(CAIXA_DINHEIRO));
        bean.setMeioEntradaCaixaCheque(new Long(CAIXA_CHEQUE));
        bean.setMeioEntradaLotericoDinheiro(new Long(LOTERICO_DINHEIRO));
        bean.setMeioEntradaLotericoCheque(new Long(LOTERICO_CHEQUE));
        bean.setMeioEntradaCompensacao(new Long(COMPENSACAO));
        bean.setMeioEntradaAutoAtendimento(new Long(AUTO_ATENDIMENTO));
        bean.setMeioEntradaCorrespondenteBancario(new Long(CORRESPONDENTE_BANCARIO));
        bean.setMeioEntradaInternetBanking(new Long(INTERNET_BANKING));
        bean.setMeioEntradaStrTed(new Long(STR_TED));
        bean.setMeioEntradaMobile(new Long(MOBILE));
    }

    /**
     * Salva os dados digitados pelo usuario no formato usado no jsp para
     * inicializar os inputs
     * 
     * @param requestBean
     *            CedenteFloatBean com os dados preenchidos na tela
     * @return ArrayList com os CedenteFloatBean preenchidos
     */
    private ArrayList salvaDadosDigitados(CedenteFloatBean requestBean) {
        ArrayList alFloat = new ArrayList();

        CedenteFloatBean beanCaixaDinheiro = new CedenteFloatBean();
        beanCaixaDinheiro.setMeioEntrada(new Long(CAIXA_DINHEIRO));
        beanCaixaDinheiro.setNumeroFloat(requestBean.getFloatCaixaDinheiro());
        alFloat.add(beanCaixaDinheiro);

        CedenteFloatBean beanCaixaCheque = new CedenteFloatBean();
        beanCaixaCheque.setMeioEntrada(new Long(CAIXA_CHEQUE));
        beanCaixaCheque.setNumeroFloat(requestBean.getFloatCaixaCheque());
        alFloat.add(beanCaixaCheque);

        CedenteFloatBean beanLotericoDinheiro = new CedenteFloatBean();
        beanLotericoDinheiro.setMeioEntrada(new Long(LOTERICO_DINHEIRO));
        beanLotericoDinheiro.setNumeroFloat(requestBean.getFloatLotericoDinheiro());
        alFloat.add(beanLotericoDinheiro);

        CedenteFloatBean beanLotericoCheque = new CedenteFloatBean();
        beanLotericoCheque.setMeioEntrada(new Long(LOTERICO_CHEQUE));
        beanLotericoCheque.setNumeroFloat(requestBean.getFloatLotericoCheque());
        alFloat.add(beanLotericoCheque);

        CedenteFloatBean beanCompensacao = new CedenteFloatBean();
        beanCompensacao.setMeioEntrada(new Long(COMPENSACAO));
        beanCompensacao.setNumeroFloat(requestBean.getFloatCompensacao());
        alFloat.add(beanCompensacao);

        CedenteFloatBean beanAutoAtendimento = new CedenteFloatBean();
        beanAutoAtendimento.setMeioEntrada(new Long(AUTO_ATENDIMENTO));
        beanAutoAtendimento.setNumeroFloat(requestBean.getFloatAutoAtendimento());
        alFloat.add(beanAutoAtendimento);

        CedenteFloatBean beanCorrespondenteBancario = new CedenteFloatBean();
        beanCorrespondenteBancario.setMeioEntrada(new Long(CORRESPONDENTE_BANCARIO));
        beanCorrespondenteBancario.setNumeroFloat(requestBean.getFloatCorrespondenteBancario());
        alFloat.add(beanCorrespondenteBancario);

        CedenteFloatBean beanInternetBanking = new CedenteFloatBean();
        beanInternetBanking.setMeioEntrada(new Long(INTERNET_BANKING));
        beanInternetBanking.setNumeroFloat(requestBean.getFloatInternetBanking());
        alFloat.add(beanInternetBanking);

        CedenteFloatBean beanStrTed = new CedenteFloatBean();
        beanStrTed.setMeioEntrada(new Long(STR_TED));
        beanStrTed.setNumeroFloat(requestBean.getFloatStrTed());
        alFloat.add(beanStrTed);
        
        
        CedenteFloatBean beanMobile = new CedenteFloatBean();
        beanMobile.setMeioEntrada(new Long(MOBILE));
        beanMobile.setNumeroFloat(requestBean.getFloatMobile());
        alFloat.add(beanMobile);

        return alFloat;
    }

}
