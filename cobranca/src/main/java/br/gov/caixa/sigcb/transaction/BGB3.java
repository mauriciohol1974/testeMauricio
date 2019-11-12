package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento de Cedente (total)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGB3 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGB3-IDA",

        new String[] { "codigoCedente", "periodo" });

        fields.listFixDataRecordsetTransaction.put("BGB3-VOLTA-F",

        new String[] {
                      "valorTarUniAcumulado",
                      "qtdBloquetosAcumulado",
                      "valorRecAcumulado",
                      "valorTarifaAcumulado" });

        fields.listFixDataRecordsetTransaction.put("BGB3-VOLTA-R",

        new String[] {
                      "codigoCanal",
                      "tarifaUnitaria",
                      "quantidadeBloqueto",
                      "valorTotalRecebido",
                      "valorTotalTarifa" });
    }
}
