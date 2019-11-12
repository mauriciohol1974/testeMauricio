package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;


public class BGZG implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {


        fields.listFixDataRecordsetTransaction.put("BGZG-IDA",
        		new String[] {
                      "opcao",
                      "cedenteOrigem",
                      "bancoOrigem",
                      "agenciaOrigem",
                      "pagina",
                      "ISPBOrigem"});
        fields.listFixDataRecordsetTransaction.put("BGZG-VOLTA-F",
        		new String[] { 
        				"opcao", 
        				"descOpcao",
        				"cedenteOrigem", 
        				"bancoOrigem", 
        				"agenciaOrigem", 
        				"qtdeTitulos",
        				"ISPBOrigem"});
        
        fields.listFixDataRecordsetTransaction.put("BGZG-VOLTA-R",
                new String[] {
                              "dataRecebimento",
                              "banco",
                              "agencia",
                              "horaRecebimento",
                              "sequencial",
                              "cedente",
                              "nossoNumero",
                              "valorRecebido",
                              "codErro",
                              "descErro",
                              "ISPBOrigem"});
    }
}
