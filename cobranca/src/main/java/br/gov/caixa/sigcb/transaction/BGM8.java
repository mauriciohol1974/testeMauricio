package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Tipo Transmissao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGM8 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGM8: Combo – Tipo Transmissao

        fields.listSimpleTransaction.put("BGM8-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGM8-VOLTA",
                new String[] { "codigoTam3", "descricao", });
    }
}