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
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BG76 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG76: Listar Títulos

        fields.listFixDataRecordsetTransaction.put("BG76-IDA",
                new String[] { "codigoCedente", "codigoBordero" });

        fields.listFixDataRecordsetTransaction.put("BG76-VOLTA-F",
                new String[] {
                              "totalTitulos",
                              "valorTotalBordero",
                              "titulosIncluidos",
                              "valorTitulosIncluidos",
                              "situacao",
                              "emissaoBloqueto",
                              "envioBloqueto",
                              // "modalidadeTitulo",
                              "endosso" });
        fields.listFixDataRecordsetTransaction.put("BG76-VOLTA-R",
                new String[] {
                              "numeroSequencial",
                              "numeroDocumento",
                              "nossoNumero",
                              "dataVencimento",
                              "dataDocumento",
                              "abatimento",
                              "valorTitulo",
                              "nomeSacado",
                              "emailSacado",
                              "tipoPessoaSacado",
                              "cpfCnpjSacado",
                              "cepSacado",
                              "ufSacado",
                              "enderecoSacado",
                              "numeroSacado",
                              "complSacado",
                              "bairroSacado",
                              "municipioSacado",
                              "nomeSacadorAvalista",
                              "tipoPessoaSacador",
                              "cpfCnpjSacador",
                              "retidoValorIOF",
                              "dddSMS",
                              "celularSMS",
                              "tipoSMS",
                              "indRegCip",
                              "tipoPgto",
                              "valorMaxPgto",
                              "valorMinPgto",
                              "icParcial",
                              "qtdePossivel"});

    }

}
