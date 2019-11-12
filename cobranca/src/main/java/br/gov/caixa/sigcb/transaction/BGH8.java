package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 13/02/2007
 */
public class BGH8 implements LayoutTransaction, Serializable {

    /*
     * (non-Javadoc)
     * 
     * @see br.gov.caixa.sigcb.util.LayoutTransaction#setLayout(br.gov.caixa.sigcb.util.FieldsByTransaction)
     */
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGH8-IDA",
                new String[] {
                              "nsuTransacao",
                              "codigoUsuario",
                              "cpfCnpj",
                              "nomeCedente",
                              "idEndereco",
                              "numeroPendencia",
                              "apelido",
                              "ip"});
        fields.listSimpleTransaction.put("BGH8-VOLTA",
                new String[] { "descricaoCriticas", });
    }
}