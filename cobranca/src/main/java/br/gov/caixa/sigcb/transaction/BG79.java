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
 * <DD>30/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BG79 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG79: Informações do bordero p/ inclusão de titulos

        fields.listSimpleTransaction.put("BG79-IDA",
                new String[] { "codigoCedente", "codigoBordero" });

        fields.listSimpleTransaction.put("BG79-VOLTA",
                new String[] {
                              "totalTitulos",
                              "titulosIncluidos",
                              "situacao",
                              "emissaoBloqueto",
                              "envioBloqueto",
                              "endosso", 
                              "somenteProtesto" });
    }

}
