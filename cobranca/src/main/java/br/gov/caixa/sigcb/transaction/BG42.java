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
public class BG42 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG42: Listar Arquivos
        fields.listFixDataRecordsetTransaction.put("BG42-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "apelidoCedente",
                              "dataInicial",
                              "dataFinal",
                              "codigoUsuario" });
        fields.listFixDataRecordsetTransaction.put("BG42-VOLTA-F",
                new String[] {
                              "codigoUnidadePV",
                              "codigoCedente",
                              "apelidoCedente",
                              "numeroProxRemessa",
                              "numeroUltRetorno",
                              "descricaoVAN",
                              "dataEnvioReenvio" });
        fields.listFixDataRecordsetTransaction.put("BG42-VOLTA-R",
                new String[] {
                              "dataArquivo",
                              "horaArquivo",
                              "tipoArquivo",
                              "padrao",
                              "numRemessaRetorno",
                              "quantidadeRegistros",
                              "observacao",
                              "situacao",
                              "descricaoVAN",
                              "cpfCnpj"});
    }
}