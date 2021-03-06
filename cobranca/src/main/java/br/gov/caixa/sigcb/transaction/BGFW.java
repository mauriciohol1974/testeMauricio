package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Solicitação de
 * Bloquetos Online
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGFW implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGFW-IDA",
        // BGFW - Excluir/validar Inclusão PV Cobrador
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "dataMovimento",
                              "tipoBloqueto" });
    }
}