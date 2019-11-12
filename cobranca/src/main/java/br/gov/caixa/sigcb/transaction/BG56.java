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
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BG56 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG56: Solicita��o/Agendamento - Inclus�o/Alteracao

        fields.listSimpleTransaction.put("BG56-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "codigoBancoSacado",
                              "indicadorSolicitacao",
                              "dataSolicitacao",
                              "registro",
                              "especie",
                              "formaObtencaoValor",
                              "valorSolicitacao",
                              "moeda",
                              "formaObtencaoBloqueto",
                              "envioBloqueto",
                              "endosso",
                              "aceite",
                              "protestoAutomatico",
                              "prazoProtestoDevolucao",
                              "dataVencimento",
                              "tipoJuroDia",
                              "percentualJuroMes",
                              "percentualDesconto1",
                              "valorDesconto1",
                              "prazoDesconto1",
                              "dataDesconto1",
                              "percentualDesconto2",
                              "valorDesconto2",
                              "prazoDesconto2",
                              "dataDesconto2",
                              "percentualDesconto3",
                              "valorDesconto3",
                              "prazoDesconto3",
                              "dataDesconto3",
                              "percentualMulta",
                              "valorMulta",
                              "prazoMulta",
                              "dataMulta",
                              "diaVencimento",
                              "formaVencimento",
                              "diaEmissao",
                              "formaEmissao",
                              "agendamentoPermanente",
                              "meioEntrada",
                              "codigoUsuario",
                              "tipoSMS" ,
                              "tipoDesconto",
                              "dataJuros",
                              "valorJuros",
                              "prazoJuros"});
        fields.listSimpleTransaction.put("BG56-VOLTA", new String[] {});
    }
}