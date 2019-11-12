package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Excepciona��o >>
 * transa��o BG33 - listar pend�ncias por cedente ou n�mero pend�ncia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BG33 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG33: Lista Pend�ncias por Cedente ou Numero Pend�ncia

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
