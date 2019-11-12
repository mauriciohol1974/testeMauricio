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
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG09 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG09-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "codigoUnidadePVVinc", });
        fields.listSimpleTransaction.put("BG09-VOLTA",
                new String[] {
                              "aplicativo",
                              "aplicativoDesc",
                              "versao",
                              "tipoTransmissao",
                              "tipoTransmissaoDesc",
                              "padraoArquivo",
                              "situacao",
                              "atribuicaoVan",
                              "van",
                              "vanDesc",
                              "juncaoArquivoRetorno",
                              "cedenteJuncao",
                              "perfilRejeicao",
                              "preCritica",
                              "apelido",
                              "arquivoRetorno",
                              "copiaArquivoRetorno",
                              "caixaPostal",
                              "apelidoCopia",
                              "arquivoRetornoCopia",
                              "numeroProximaRemessa",
                              "agrupamento",
                              "agrupamentoDesc",
                              "numeroUltimoRetorno",
                              "dataEnvioReenvio",
                              "codConnect",
                              "descConnect",
                              "situacaoVAN",
                              "codInternet",
                              "descInternet",
                              "retOnline",
                              "numUltRetOnline",
                              "remOnline",
                              "webservice"});
    }
}
