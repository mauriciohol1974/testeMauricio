package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Contabeis -
 * Saldo Contabil
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGD9 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGD9-IDA",
                new String[] { "tipoConsulta", "codigoUnidade", "data", });
        fields.listFixDataRecordsetTransaction.put("BGD9-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalTarifaReceber",
                              "totalCredito",
                              "totalDebito",
                              "totalBloquetoRejeitadoCompensacao",
                              "totalBloquetoRejeitadoOutrosMeios", });
        fields.listFixDataRecordsetTransaction.put("BGD9-VOLTA-R",
                new String[] {
                              "codigoUnidade",
                              "nomeUnidade",
                              "tarifaReceber",
                              "credito",
                              "debito",
                              "compensacao",
                              "outroMeio", });
    }
}
