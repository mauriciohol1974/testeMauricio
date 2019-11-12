package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo VAN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGMM implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGMM: Combo Internet

        fields.listSimpleTransaction.put("BGMM-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGMM-VOLTA",
                new String[] { "codigo", "descricao", });
    }
}