package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 12/02/2007
 */
public class BGI0 implements LayoutTransaction, Serializable {

    /*
     * (non-Javadoc)
     * 
     * @see br.gov.caixa.sigcb.util.LayoutTransaction#setLayout(br.gov.caixa.sigcb.util.FieldsByTransaction)
     */
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGI0-IDA",
                new String[] {
                              "opcao",
                              "nsuTransacao",
                              "codigoUsuario",
                              "codigoCedente" });
        fields.listSimpleTransaction.put("BGI0-VOLTA",
                new String[] { "apelido" });
    }
}
