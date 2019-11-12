package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informações necessárias para o parsing dos
 * pacotes ISO8583 pela framework. O dados são mantidos e organizados por
 * transação, identificando se o layoute é relativo a subida da mensagem
 * "XXXX-IDA", ou a descida da mensagem "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGM5 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGM5: Combo – Setor

        fields.listSimpleTransaction.put("BGM5-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGM5-VOLTA",
                new String[] { "codigo", "descricao", });
    }
}