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
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BGK9 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGK9: PV CObrador – Incluir / Alterar PV CObrador

        fields.listSimpleTransaction.put("BGK9-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoUnidadePV",
                              "codigoUnidadeCentral",
                              "codigoVAN",
                              "automacaoCartoraria",
                              "apelido",
                              "padraoCNAB",
                              "usuario",
                              "situacao",
                              "numeroCEPde0",
                              "numeroCEPate0",
                              "numeroCEPde1",
                              "numeroCEPate1",
                              "numeroCEPde2",
                              "numeroCEPate2",
                              "numeroCEPde3",
                              "numeroCEPate3",
                              "numeroCEPde4",
                              "numeroCEPate4",
                              "numeroCEPde5",
                              "numeroCEPate5",
                              "numeroCEPde6",
                              "numeroCEPate6",
                              "numeroCEPde7",
                              "numeroCEPate7",
                              "numeroCEPde8",
                              "numeroCEPate8",
                              "numeroCEPde9",
                              "numeroCEPate9",
                              "numeroCEPde10",
                              "numeroCEPate10",
                              "numeroCEPde11",
                              "numeroCEPate11",
                              "numeroCEPde12",
                              "numeroCEPate12",
                              "numeroCEPde13",
                              "numeroCEPate13",
                              "numeroCEPde14",
                              "numeroCEPate14",
                              "numeroCEPde15",
                              "numeroCEPate15",
                              "numeroCEPde16",
                              "numeroCEPate16",
                              "numeroCEPde17",
                              "numeroCEPate17",
                              "numeroCEPde18",
                              "numeroCEPate18",
                              "numeroCEPde19",
                              "numeroCEPate19" });
    }
}
