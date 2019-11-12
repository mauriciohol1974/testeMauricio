package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade XXX FUNCIONALIDADE XXX
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGM7 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGM7: Combo � Tipo Aplicativo

        fields.listSimpleTransaction.put("BGM7-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGM7-VOLTA",
                new String[] { "codigo", "descricao", });
    }
}