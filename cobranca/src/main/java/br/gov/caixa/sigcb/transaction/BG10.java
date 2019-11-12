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
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG10 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG10-IDA",
                new String[] { "tipoAcao", // X(01)
                              "codigoClienteCOCLI", // 9(13)
                              "nsuTransacao", // X(48)
                              "codigoUnidadePVVinc", // 9(04)
                              "solicitacaoEnvio", // X(01)
                              "tipoUsuario", // X(01)
                              "strRecordset" });
        fields.listSimpleTransaction.put("BG10-VOLTA",
                new String[] { "descricaoCriticas" });
    }
}
