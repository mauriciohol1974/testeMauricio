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
public class BGGA implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        

        fields.listFixDataRecordsetTransaction.put("BGGA-IDA",

        new String[] {                      
                      "unidadeVinculacao",
                      "dataPagamento",
                      "tipoConsulta" });
        fields.listFixDataRecordsetTransaction.put("BGGA-VOLTA-F",

        new String[] { "nomeUnidade" });
        fields.listFixDataRecordsetTransaction.put("BGGA-VOLTA-R",

                new String[] {
                              "codigoCedente",
                              "nomeFantasia",
                              "tipoPessoa",
                              "cpfCnpj" });
    }
}
