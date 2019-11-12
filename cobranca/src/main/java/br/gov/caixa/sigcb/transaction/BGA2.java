package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Cedente GIROCAIXA - Listar unidades de PV por Unidade EN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGA2 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA2: Consulta Gerais - Cedente GIROCAIXA
        // Listar unidades de PV por Unidade EN

        fields.listFixDataRecordsetTransaction.put("BGA2-IDA",
                new String[] { "codigoUnidadeEN" });
        fields.listFixDataRecordsetTransaction.put("BGA2-VOLTA-F",
                new String[] { "nomeUnidadeEN" });
        fields.listFixDataRecordsetTransaction.put("BGA2-VOLTA-R",
                new String[] { "codigoUnidadePV", "nomeUnidadePV" });
    }
}
