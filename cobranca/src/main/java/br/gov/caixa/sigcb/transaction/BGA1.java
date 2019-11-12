package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Cedente com Banco Sacado
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGA1 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA1: Consultas Gerais - Cedente com Banco de Sacados por Unidade PV
        fields.listFixDataRecordsetTransaction.put("BGA1-IDA",
                new String[] { "codigoUnidadePV", "usuario" });
        fields.listFixDataRecordsetTransaction.put("BGA1-VOLTA-F",
                new String[] { "nomeUnidadePV" });
        fields.listFixDataRecordsetTransaction.put("BGA1-VOLTA-R",
                new String[] { "codigoCedente", "nomeFantasia", "dataInclusao" });
    }

}
