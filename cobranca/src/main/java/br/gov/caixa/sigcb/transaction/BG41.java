package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informa��es necess�rias para o parsing dos
 * pacotes ISO8583 pela framework. O dados s�o mantidos e organizados por
 * transa��o, identificando se o layoute � relativo a subida da mensagem
 * "XXXX-IDA", ou a descida da mensagem "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>27/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BG41 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG41: Lista Cedentes por Unidade PV

        fields.listSimpleTransaction.put("BG41-IDA",
                new String[] {
                              "codigoUnidadePV",
                              "dataInicial",
                              "dataFinal",
                              "codigoUsuario" });
        fields.listSimpleTransaction.put("BG41-VOLTA",
                new String[] {
                              "codigoCedente",
                              "apelidoCedente",
                              "nomeCedente",
                              "numeroProxRemessa",
                              "numeroUltRetorno" });
    }
}