package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo VAN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2011</DD>
 * </DL>
 * 
 * @author Maurício Holanda
 */
public class BGVE implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGMI: Combo Connect

        fields.listSimpleTransaction.put("BGVE-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGVE-VOLTA",
        new String[] { "codigo", "descricao" });
    }
}