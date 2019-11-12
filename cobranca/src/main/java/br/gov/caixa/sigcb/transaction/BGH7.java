package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

public class BGH7 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGH7-IDA",
                new String[] {
                              "nsuTransacao",
                              "codigoUsuario",
                              "numeroPendencia",
                              "opcao" });
        fields.listSimpleTransaction.put("BGH7-VOLTA",
                new String[] { "descricaoCriticas" });

    }
}