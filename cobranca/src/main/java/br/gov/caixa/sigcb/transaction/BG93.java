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
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BG93 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG93: Tarifa Manual - Excluir / Validar Inclusão Tarifa

        fields.listSimpleTransaction.put("BG93-IDA",
                new String[] {
                              "codigoCedente",
                              "tipoTarifa",
                              "dataSolicitacao",
                              "horaSolicitacao" });
        fields.listSimpleTransaction.put("BG93-VOLTA", new String[] {});
    }
}