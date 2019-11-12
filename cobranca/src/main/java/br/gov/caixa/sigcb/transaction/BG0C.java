package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

public class BG0C implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BG0C-IDA",
                new String[] { "codigoPv" });
        fields.listFixDataRecordsetTransaction.put("BG0C-VOLTA-F",
                new String[] { "nomePv" });
        fields.listFixDataRecordsetTransaction.put("BG0C-VOLTA-R",
                new String[] {
                              "numeroCedente",
                              "numeroCocli",
                              "nomeCedente",
                              "dataInclusao" });
    }

}
