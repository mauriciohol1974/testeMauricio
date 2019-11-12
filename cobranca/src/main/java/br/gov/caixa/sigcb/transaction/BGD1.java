package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Tarifas por
 * Float e EN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGD1 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listFixDataRecordsetTransaction.put("BGD1-IDA",

        new String[] { "codigoUnidadeEn" });
        fields.listFixDataRecordsetTransaction.put("BGD1-VOLTA-F",
                new String[] {
                              "nomeUnidadeEn",
                              "totalQuantidade",
                              "totalValorMedio",
                              "totalFloatMedio",
                              "totalIndiceTarifa",
                              "totalGeralTarifa" });

        fields.listFixDataRecordsetTransaction.put("BGD1-VOLTA-R",

        new String[] {
                      "codigoUnidadePv",
                      "quantidade",
                      "valorMedio",
                      "floatMedio",
                      "indiceTarifa",
                      "totalTarifas" });
    }
}
