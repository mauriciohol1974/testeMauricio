package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 09/02/2007
 */
public class BGH6 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGH6-IDA",
                new String[] {
                              "nsuTransacao",
                              "codigoUsuario",
                              "numeroPendenciaVigente",
                              "cpfCnpj",
                              "justificativa",
                              "strRecordset" });
        fields.listSimpleTransaction.put("BGH6-VOLTA",
                new String[] {
                              "descricaoCriticas",
                              "numeroPendencia",
                              "codigoCedente",
                              "perfilUsuarioAlcada" });
    }
}
