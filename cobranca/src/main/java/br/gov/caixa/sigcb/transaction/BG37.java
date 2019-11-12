package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informações necessárias para o parsing dos
 * pacotes ISO8583 pela framework. O dados são mantidos e organizados por
 * transação, o layoute é relativo a subida da mensagem "XXXX-IDA"
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>23/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BG37 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BG37-IDA",
                new String[] {
                              "codigoCedente",
                              "numeroPendencia",
                              "numeroReiteracao",
                              "codigoUsuario" });
    }
}
