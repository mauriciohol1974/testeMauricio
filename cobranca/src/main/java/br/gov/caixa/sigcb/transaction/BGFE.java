package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Incluir/Alterar
 * Relacionamento de Cliente Internet
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Glauber Micheloni Gallego
 */
public class BGFE implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFE - Inserir / Alterar Relacionamento
        fields.listSimpleTransaction.put("BGFE-IDA",
                new String[] { "tipoAcao", "codigoCedente", "cpfUsuario" });
        fields.listSimpleTransaction.put("BGFE-VOLTA",
                new String[] { "usuarioExistente", "cpfUsuario" });
    }
}