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
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego ggallego@sao.politec.com.br
 */
public class BGK7 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGK7: Listar PV Cobrador por Faixa de CEP

        fields.listSimpleTransaction.put("BGK7-IDA",
                new String[] { "numeroCEPde", "numeroCEPate" });
        fields.listSimpleTransaction.put("BGK7-VOLTA",
                new String[] {
                              "numeroCEPde",
                              "numeroCEPate",
                              "codigoUnidadePV",
                              "nomeUnidadePV",
                              "situacao",
                              "uf",
                              "codigoUnidadeCentral", });
    }
}
