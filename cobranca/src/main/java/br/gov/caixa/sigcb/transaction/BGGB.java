package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class BGGB implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        
        fields.listFixDataRecordsetTransaction.put("BGGB-IDA",

        new String[] {                      
                      "codigoCedente",
                      "dataPagamento",
                      "tipoConsulta",
                      "pagina" });
        fields.listFixDataRecordsetTransaction.put("BGGB-VOLTA-F",

        new String[] { "dataCredito", "totalRegistro" });
        fields.listFixDataRecordsetTransaction.put("BGGB-VOLTA-R",
                new String[] {
                              "nossoNumero",
                              "valorPagamento",                              
                              "dataPagamento",
                              "nomeFantasia" });
    }
}
