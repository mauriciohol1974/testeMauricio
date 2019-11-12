package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Alterar Senha de
 * Cliente Internet
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Glauber Micheloni Gallego
 */
public class BGSW implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFF - Alterar Senha
        fields.listSimpleTransaction.put("BGSW-IDA",
                new String[] {"nuCtrlReq"});
        
        fields.listSimpleTransaction.put("BGSW-VOLTA",
                new String[] {"nuSqErro","tagErro","coErro","descErro"});
    }
}