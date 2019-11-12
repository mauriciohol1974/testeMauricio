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
 * @author Glauber M. Gallego ggallego@sao.politec.com.br
 */
public class BGK8 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGK8: Consultar Detalhes PV Cobrador

        fields.listFixDataRecordsetTransaction.put("BGK8-IDA",
                new String[] { "codigoUnidadePV", });
        fields.listFixDataRecordsetTransaction.put("BGK8-VOLTA-F",
                new String[] {
                              "codigoVAN",
                              "automacaoCartoraria",
                              "apelido",
                              "padraoCNAB",
                              "numeroUltimaRemessa",
                              "qntdRegistrosUltRemessa",
                              "dataUltimaRemessa",
                              "dataInclusaoAutomacao",
                              "usuario",
                              "dataUltimaAlteracao",
                              "situacao" });
        fields.listFixDataRecordsetTransaction.put("BGK8-VOLTA-R",
                new String[] { "numeroCEPde", "numeroCEPate" });
    }
}
