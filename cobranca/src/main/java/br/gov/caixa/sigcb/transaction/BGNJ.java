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
public class BGNJ implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG86 - Consultar Solicitação de Segunda via de Extrato
        fields.listSimpleTransaction.put("BGNJ-IDA",
                new String[] {  "codigoCedente",
        						"nossoNumero",
        						"linhaDigitavel",
        						"dataVencimento",
        						"dataImpressao",
        						"horaImpressao",
        						"valorDocumento",
        						"ipMaquina",
        						"sistema",
        						"codUsuario"});
        fields.listSimpleTransaction.put("BGNJ-VOLTA",
                new String[] { "codRetorno","msgRetorno" });
    }
}
