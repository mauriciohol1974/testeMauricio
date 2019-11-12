package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BG64 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG64: Banco de titulos - Consulta Dados para Impressão Bloqueto
        // Expresso

        fields.listFixDataRecordsetTransaction.put("BG64-IDA",
                new String[] { "codigoCedente", "nossoNumero", "meioEntrada" });
        fields.listFixDataRecordsetTransaction.put("BG64-VOLTA-F",
                new String[] {
                              "bloqCodigoBarrasFormatado",
                              "bloqCodigoBarrasNumerico",
                              "bloqDigitoCtrlNossoNumero", 
                              "vrDesAba",
                              "vrMltJur",
                              "vrJuros",
                              "vrIof",
                           	  "vrMulta",
                           	  "vrDesconto",
                           	  "vrAbatimento",
                           	  "vrCalculado",
                           	  "vrCobrado"});
        fields.listFixDataRecordsetTransaction.put("BG64-VOLTA-R",
                new String[] { "bloqTipoMensagem", "bloqDescricaoMensagem" });
    }
}
