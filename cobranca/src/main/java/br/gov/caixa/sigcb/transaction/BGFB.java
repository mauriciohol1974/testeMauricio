package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Listar Cedentes por
 * PCF Usuario de Cliente Internet
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Glauber Micheloni Gallego
 */
public class BGFB implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFB - Listar Cedentes por CPF Usuário
        fields.listFixDataRecordsetTransaction.put("BGFB-IDA",
                new String[] { "cpfUsuario", "codigoUsuario" });
        fields.listFixDataRecordsetTransaction.put("BGFB-VOLTA-F",
                new String[] { "nomeUsuario" });
        fields.listFixDataRecordsetTransaction.put("BGFB-VOLTA-R",
                new String[] { "codigoCedente", "nome" });
    }
}