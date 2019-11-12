package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <b>Projeto: SIGCB-Intranet-sunone7</b><br>
 * 
 * @author David L. M. Torneiros - p561913 Criado em : 22/05/2007 - 09:06:34
 * @version 1.0.0
 */
public class BGDB implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGDB-IDA",

        new String[] { "codigoUnidadePv", "dataSolicitacao", "codigoUsuario" });

        fields.listFixDataRecordsetTransaction.put("BGDB-VOLTA-F",
                new String[] { "nomePvVinculacao" });

        fields.listFixDataRecordsetTransaction.put("BGDB-VOLTA-R",
                new String[] { "codigoCedente", "nomeCedente" });

    }
}