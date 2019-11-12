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
 * <DD>23/10/2006</DD>
 * </DL>
 * 
 * @author Alexandre Lima
 */
public class BG39 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG39-IDA",
                new String[] { "codigoCedente" });
        fields.listSimpleTransaction.put("BG39-VOLTA",
                new String[] {
                              "nome",
                              "endereco",
                              "numero",
                              "complemento",
                              "bairro",
                              "municipio",
                              "cep",
                              "uf",
                              "tpPessoa",
                              "nuPessoa"});
    }
}
