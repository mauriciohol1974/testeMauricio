package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Contabeis -
 * Saldo Operacional
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGD8 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGD8-IDA",
                new String[] { "tipoConsulta", "codigoUnidade", "data", });
        fields.listFixDataRecordsetTransaction.put("BGD8-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalSaldoAnterior",
                              "totalLiquidacao",
                              "totalRepasse",
                              "totalEstorno",
                              "totalSaldoAtual", });
        fields.listFixDataRecordsetTransaction.put("BGD8-VOLTA-R",
                new String[] {
                              "codigoUnidade",
                              "saldoAnterior",
                              "liquidacao",
                              "repasse",
                              "estorno",
                              "saldoAtual", });
    }
}
