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
 * <DD>06/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGWM implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGSK

        fields.listSimpleTransaction.put("BGWM-IDA",
                new String[] {
                              "data",
                              "unidade"
                              });

        fields.listSimpleTransaction.put("BGWM-VOLTA",
                new String[] {
                              "cedente",
                              "tpPessoa",
                              "nuCpfCnpj",
                              "qtdeLiq",
                              "valorLiq",
                              "produto1",
                              "produto2",
                              "produto3",
                              "produto4"});
    }
}
