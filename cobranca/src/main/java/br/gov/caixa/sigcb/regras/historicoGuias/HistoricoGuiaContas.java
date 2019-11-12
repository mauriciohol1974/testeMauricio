package br.gov.caixa.sigcb.regras.historicoGuias;

import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.LogCedenteGuiasBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 12/02/2007 Classe que representa a Guia de Contas.
 */
public class HistoricoGuiaContas extends HistoricoGuia {

    /*
     * (non-Javadoc)
     * 
     * @see br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia#montarBean(br.gov.caixa.sigcb.bean.SigcbBean)
     */
    @Override
    protected LogCedenteGuiasBean montarBean(SigcbBean bean) throws Exception {
        LogUtilSigcb.info("Guia Contas ==> INICIAR HISTORICO DE ALTERACAO");
        LogCedenteGuiasBean logCedenteGuiasBean = (LogCedenteGuiasBean) (new LogCedenteGuiasBean()).newBean();
        logCedenteGuiasBean.setOpcao(GUIA_CONTAS);
        logCedenteGuiasBean.setCodigoCedente(((CedenteGeralBean) bean).getCodigoCedente());
        logCedenteGuiasBean.setCodigoUsuario(((CedenteGeralBean) bean).getCodigoUsuario());
        logCedenteGuiasBean.setNsuTransacao(((CedenteGeralBean) bean).getNsuTransacao());
        return logCedenteGuiasBean;
    }

}
