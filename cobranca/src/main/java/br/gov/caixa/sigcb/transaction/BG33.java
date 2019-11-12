package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionação >>
 * transação BG33 - listar pendências por cedente ou número pendência
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BG33 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG33: Lista Pendências por Cedente ou Numero Pendência

        fields.listFixDataRecordsetTransaction.put("BG33-IDA",

        new String[] {
                      "tipoConsulta",
                      "codigoCedente",
                      "numeroPendencia",
                      "situacaoPendencia",
                      "codigoUsuario"

        });
        fields.listFixDataRecordsetTransaction.put("BG33-VOLTA-F",
                new String[] { "codigoCedente" });

        fields.listFixDataRecordsetTransaction.put("BG33-VOLTA-R",

        new String[] {
                      "numeroPendencia",
                      "dataPendencia",
                      "situacaoPendencia",
                      "dataSituacao",
                      "dataVigenciaDe",
                      "dataVigenciaAte",
                      // EAM 18/10/2005"numeroReiteracao"
                      "autorizado",
                      "cargoAutorizador" });
    }
}
