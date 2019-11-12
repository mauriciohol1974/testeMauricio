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
public class BGSP implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFF - Alterar Senha
        fields.listSimpleTransaction.put("BGSP-IDA",
                new String[] {  "passo",
        						"sigla","nuIndice","noIndice","noUnidade","coPrdce","icStco","coUserInc","tsInc","coUserAlt","tsAlt", });
        
        fields.listSimpleTransaction.put("BGSP-VOLTA",
                new String[] {  "passo",
        						"sigla","nuIndice","noIndice","noUnidade","coPrdce","icStco","coUserInc","tsInc","coUserAlt","tsAlt", });
    }
}