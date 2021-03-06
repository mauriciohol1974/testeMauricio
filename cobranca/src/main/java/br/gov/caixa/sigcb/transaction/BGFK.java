package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Validar Usuario de
 * Cliente Internet
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>13/12/2004</DD>
 * </DL>
 * 
 * @author Glauber Micheloni Gallego
 */
public class BGFK implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFK - Validar Usuario Internet
        fields.listSimpleTransaction.put("BGFK-IDA",
                new String[] { "cpfUsuario" });
        fields.listSimpleTransaction.put("BGFK-VOLTA",
                new String[] { "usuarioExistente", });
    }
}