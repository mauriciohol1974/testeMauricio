package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;


/**
 * <B>Projeto: SIGCB</B><BR>
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abril/2013</DD>
 * </DL>
 * 
 * @author Maurício Assis de Holanda
 */
public class BGZJ implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {


        fields.listFixDataRecordsetTransaction.put("BGZJ-IDA",
        		new String[] {
        			  "dataPesq",
        			  "dataPesqFinal",
                      "cedenteOrigem",
                      "bancoOrigem",
                      "agenciaOrigem",
                      "pagina",
                      "ISPBOrigem"});
        fields.listFixDataRecordsetTransaction.put("BGZJ-VOLTA-F",
        		new String[] { 
						"dataPesq",
						"dataPesqFinal",
        				"cedenteOrigem", 
        				"bancoOrigem", 
        				"agenciaOrigem", 
        				"qtdeTitulos",
        				"ISPBOrigem"});
        
        fields.listFixDataRecordsetTransaction.put("BGZJ-VOLTA-R",
                new String[] {
        					  "dataRecebimento",
                              "banco",
                              "agencia",
                              "horaRecebimento",
                              "sequencial",
                              "cedente",
                              "nossoNumero",
                              "valorRecebido",
                              "coSituacao",
                              "deSituacao",
                              "ISPBOrigem"});
    }
}
