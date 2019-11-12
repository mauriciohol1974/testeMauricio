package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável por chamar transacao do DGT - Comuns BGN5 - Combo –
 * Tipo meio
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGN5 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGN5: Combo – Tipo meio

        fields.listSimpleTransaction.put("BGN5-IDA", new String[0]);
        fields.listSimpleTransaction.put("BGN5-VOLTA",
                new String[] { "codigo", "descricao" });
    }

}
