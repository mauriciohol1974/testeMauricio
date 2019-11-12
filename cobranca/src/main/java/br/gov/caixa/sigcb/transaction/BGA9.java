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
 * <DD>19/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGA9 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGA9-IDA",
                new String[] {
                              "periodo",
                              "rentabilidade",
                              "numeroResultado",
                              "faixaRentabilidade",
                              "valorReferencia",
                              "codigoUsuario" });
        fields.listSimpleTransaction.put("BGA9-VOLTA",
                new String[] {
                              "classificacao",
                              "codigoCedente",
                              "nomeFantasia",
                              "valorBrutoTarifas",
                              "precoTransferencia",
                              "outrosCustos",
                              "sinalValorLiquido",
                              "valorLiquido",
                              "sinalRentabilidadeMedia",
                              "rentabilidadeMedia" });
    }

}
