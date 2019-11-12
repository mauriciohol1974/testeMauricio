package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Tipo Agrupamento
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGN0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGN0: Combo Tipo Agrupamento

        fields.listSimpleTransaction.put("BGN0-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGN0-VOLTA",
                new String[] { "codigo", "descricao", });
    }
}