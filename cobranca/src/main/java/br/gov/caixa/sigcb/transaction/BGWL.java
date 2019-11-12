package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;


public class BGWL implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA1: Consultas Gerais - Cedente com Banco de Sacados por Unidade PV
        fields.listFixDataRecordsetTransaction.put("BGWL-IDA",
                new String[] { 
        						"data",
        						"produto" });
        
        
        fields.listFixDataRecordsetTransaction.put("BGWL-VOLTA-F",
                new String[] { 
        						"qtdeLiq",
        						"valorLiq" });
        
        
        
        fields.listFixDataRecordsetTransaction.put("BGWL-VOLTA-R",
                new String[] {
        						"data",
        						"valorLiq" });
    }

}
