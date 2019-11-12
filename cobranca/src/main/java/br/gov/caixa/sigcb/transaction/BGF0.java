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
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGF0: Consultas Gerenciais - Cedentes padrões CNAB 240 e 400
        fields.listSimpleTransaction.put("BGF0-IDA",
                new String[] { "tipoData", "mesAno", "data", "tipoRelatorio" });
        fields.listSimpleTransaction.put("BGF0-VOLTA",
                new String[] { "codigoUnidade", "nomeUnidade", });
    }
}