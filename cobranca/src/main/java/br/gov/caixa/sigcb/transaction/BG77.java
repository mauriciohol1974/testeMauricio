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
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BG77 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG77: Border� On-line - Incluir T�tulo

        fields.listSimpleTransaction.put("BG77-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "codigoBordero",
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
                              "codigoUsuario", 
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
        fields.listSimpleTransaction.put("BG77-VOLTA",
                new String[] { "nossoNumero", });

    }
}
