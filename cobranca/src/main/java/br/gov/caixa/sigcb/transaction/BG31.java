package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionação >>
 * transação BG31 - listar unidades PV por Unidade EN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>03/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BG31 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG31: Listar Unidades PV por EN

        fields.listFixDataRecordsetTransaction.put("BG31-IDA",
                new String[] {
                              "codigoUnidadeEN",
                              "situacaoPendencia",
                              "codigoUsuario" });

        fields.listFixDataRecordsetTransaction.put("BG31-VOLTA-F",
                new String[] { "nomeUnidadeEN", });
        fields.listFixDataRecordsetTransaction.put("BG31-VOLTA-R",
                new String[] { "codigoUnidadePV", "nomeUnidadePV" });

    }

}
