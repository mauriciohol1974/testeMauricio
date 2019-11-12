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
public class BGL0 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGL0-IDA",
        // BGL0 - Excluir/validar Inclusão PV Cobrador
                new String[] { "tipoAcao", "codigoUnidadePV", "usuario" });
    }
}
