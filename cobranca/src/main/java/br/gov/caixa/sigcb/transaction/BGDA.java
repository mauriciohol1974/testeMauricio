package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <b>Projeto: SIGCB-Intranet-sunone7</b><br>
 * 
 * @author David L. M. Torneiros - p561913 Criado em : 15/05/2007 - 14:38:15
 * @version 1.0.0
 */
public class BGDA implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGDA-IDA",

        new String[] { "tpConsulta", "codigoCedente", "dataSolicitacao" });

        fields.listSimpleTransaction.put("BGDA-VOLTA",

        new String[] { "descricaoItem", "quantidadeItens" }

        );
    }
}
