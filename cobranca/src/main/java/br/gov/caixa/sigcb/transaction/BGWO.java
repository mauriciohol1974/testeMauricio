package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;


public class BGWO implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA1: Consultas Gerais - Cedente com Banco de Sacados por Unidade PV
        fields.listFixDataRecordsetTransaction.put("BGWO-IDA",
                new String[] { 
        						"data",
        						"unidade" });
        
        
        fields.listFixDataRecordsetTransaction.put("BGWO-VOLTA-F",
                new String[] { 
        						"qtdeLiq",
        						"valorLiq" });
        
        
        
        fields.listFixDataRecordsetTransaction.put("BGWO-VOLTA-R",
                new String[] {
        						"data",
        						"valorLiq" });
    }

}
