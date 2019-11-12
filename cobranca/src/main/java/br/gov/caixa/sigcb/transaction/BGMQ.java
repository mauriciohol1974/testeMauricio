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
 * <DD>16/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGMQ implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG24: Cedente - Listar Cedentes por Unidade PV ou CPF/CNPJ

        fields.listFixDataRecordsetTransaction.put("BGMQ-IDA",

        new String[] {"unidade" });

        fields.listFixDataRecordsetTransaction.put("BGMQ-VOLTA-F",

        new String[] { "nomeUnidadePV" });

        fields.listFixDataRecordsetTransaction.put("BGMQ-VOLTA-R",

        new String[] {
                      "codigoCedente",
                      "nomeFantasia",
                      "cpfCnpj"
                      }

        );
    }
}
