package br.gov.caixa.sigcb.regras.historicoGuias;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 21/02/2007 Simple Factory responsável pela instanciacao dos classes
 *          que representam cada Guia na alteracao dos dados do Cedente.
 */
public class HistoricoGuiaSimpleFactory {

    /**
     * Metodo estatico resonsavel pela criacao das classes das Guias.
     * 
     * @param guia -
     *            A guia a ser instanciada.
     * @see br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia
     * @return Um <code>HistoricoGuia</code>
     */
    public static HistoricoGuia createHistoricoGuiaLogger(long guia) {
        HistoricoGuia historicoGuia = null;

        if (guia == HistoricoGuia.GUIA_GERAL) {
            historicoGuia = new HistoricoGuiaGeral();
        } else if (guia == HistoricoGuia.GUIA_CONTAS) {
            historicoGuia = new HistoricoGuiaContas();
        } else if (guia == HistoricoGuia.GUIA_CEDENTE_ELETRONICO) {
            historicoGuia = new HistoricoGuiaCedenteEletronico();
        } else if (guia == HistoricoGuia.GUIA_CEDENTE_ELETRONICO_AGRUP) {
            historicoGuia = new HistoricoGuiaCedenteEletronicoAgrup();
        } else if (guia == HistoricoGuia.GUIA_BLOQUETOS) {
            historicoGuia = new HistoricoGuiaBloquetos();
        } else if (guia == HistoricoGuia.GUIA_TARIFA) {
            historicoGuia = new HistoricoGuiaTarifa();
        } else if (guia == HistoricoGuia.GUIA_FLOAT) {
            historicoGuia = new HistoricoGuiaFloat();
        } else if (guia == HistoricoGuia.GUIA_MSG_BLOQUETOS) {
            historicoGuia = new HistoricoGuiaMensagemBloquetos();
        } else if (guia == HistoricoGuia.GUIA_PARAMETRO){
        	historicoGuia = new HistoricoGuiaParametros(); 
        }else if (guia == HistoricoGuia.GUIA_PERMISSAO){
        	historicoGuia = new HistoricoGuiaPermissao(); 
        }
        historicoGuia.setOpcao(guia);
        return historicoGuia;
    }
}