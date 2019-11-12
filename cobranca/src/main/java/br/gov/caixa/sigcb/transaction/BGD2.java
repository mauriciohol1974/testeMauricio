package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Titulos
 * Alterados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGD2 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listFixDataRecordsetTransaction.put("BGD2-IDA",

        new String[] { "codigoUnidadePv", "dataComando", "codigoUsuario" });
        fields.listFixDataRecordsetTransaction.put("BGD2-VOLTA-F",
                new String[] { "nomeUnidadePv" });

        fields.listFixDataRecordsetTransaction.put("BGD2-VOLTA-R",

        new String[] {
                      "comando",
                      "dataAlteracao",
                      "nossoNumero",
                      "codigoCedente",
                      "nomeFantasia",
                      "parcela"});
    }
}
