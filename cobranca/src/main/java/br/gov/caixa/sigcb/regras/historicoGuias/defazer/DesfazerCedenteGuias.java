package br.gov.caixa.sigcb.regras.historicoGuias.defazer;

import br.gov.caixa.sigcb.bean.CedenteDesfazerAleracaoGuiasBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 13/02/2007 Classe responsavel pela operacao de desfazer (transacao
 *          BGH7) durante o processo de alteracao dos dados das Guias (Transacao
 *          BGI0) e de conclusao das aleracoes (Transacao BGH8).
 */
public class DesfazerCedenteGuias {

    public static final String OPCAO_DESFAZER_BGI0 = "A";

    public static final String OPCAO_DESFAZER_BGH8 = "B";

    private CedenteDesfazerAleracaoGuiasBean cedenteDesfazerAleracaoGuiasBean;

    public DesfazerCedenteGuias(String nsuTransacao,
            String codigoUsuario,
            Long numeroPendencia,
            String opcao) throws Exception {
        this.cedenteDesfazerAleracaoGuiasBean = (CedenteDesfazerAleracaoGuiasBean) (new CedenteDesfazerAleracaoGuiasBean()).newBean();
        this.cedenteDesfazerAleracaoGuiasBean.setNsuTransacao(nsuTransacao);
        this.cedenteDesfazerAleracaoGuiasBean.setCodigoUsuario(codigoUsuario);
        this.cedenteDesfazerAleracaoGuiasBean.setNumeroPendencia(numeroPendencia);
        this.cedenteDesfazerAleracaoGuiasBean.setOpcao(opcao);
    }

    /**
     * Realiza a operacao "desfazer" em uma das Guias (transacao BGI0) ou na
     * ccnclusao (transacao BGH8)
     * 
     * @param handler -
     *            Handler para executar a transacao de desfazer (BGH7)
     * @throws Exception
     */
    public void desfazer(MainFrameTransactionsSigcbEjb handler) throws Exception {
        handler.executeSimpleTransactionVoid(this.cedenteDesfazerAleracaoGuiasBean,
                br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia.TRANSACAO_DESFAZER_ALTERACAO_GUIAS_CEDENTE);
    }
}