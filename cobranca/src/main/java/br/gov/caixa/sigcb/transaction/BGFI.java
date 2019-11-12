package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGFI implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGFI-IDA",
        // BGFW - Excluir/validar Perfil Internet
                new String[] { "tipoAcao", "codigoPerfil" });
    }
}