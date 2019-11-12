package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGJ3 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGJ3-IDA",
                new String[] {
                              "codigoCedente",
                              "nsu"
                               });
        fields.listSimpleTransaction.put("BGJ3-VOLTA",
                new String[] {
                              "codigoCedente",
                              "cpfCnpjCed",
                              "dataAuditoria",
                              "horaAuditoria",
                              "transacao",
                              "cpfCnpj",
                              "nsu",
                              "ipEquipamento",
                              "origem"});
    }
}
