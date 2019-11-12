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
 * <DD>28/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGUL implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG42: Listar Arquivos
        fields.listFixDataRecordsetTransaction.put("BGUL-IDA",
                new String[] {
                              "tpconsulta",
                              "codcedente",
                              "codsince",
                              "codPV",
                              "codSR",
                              "paginaPesq"});
        fields.listFixDataRecordsetTransaction.put("BGUL-VOLTA-F",
                new String[] {"totalRegistros" });
        fields.listFixDataRecordsetTransaction.put("BGUL-VOLTA-R",
                new String[] {
                              "codcedente",
                              "codsince",
                              "codPV",
                              "codSR",
                              "tpPessoa",
                              "cpfCnpj",
                              "nome" });
    }
}