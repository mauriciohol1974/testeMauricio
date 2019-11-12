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
 * <DD>08/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BG73 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG73: Border� On-line - Incluir/Alterar Border�

        fields.listSimpleTransaction.put("BG73-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "codigoBordero",
                              "somenteProtesto",
                              "modalidadeTitulo",
                              "dataMovimento",
                              "vinculacaoPV",
                              "quantidade",
                              "valor",
                              "endosso",
                              "especieTitulo",
                              "aceite",
                              "moeda",
                              "protestoAutomatico",
                              "prazoProtDevol",
                              "emissaoBloqueto",
                              "envioBloqueto",
                              "registrarSR",
                              "tipoJurosDia",
                              "percentualJurosDia",
                              "percentualDesconto1",
                              // "valorDesconto1",
                              "prazoLimite1Dia",
                              // "prazoLimite1Data",
                              "percentualDesconto2",
                              // "valorDesconto2",
                              "prazoLimite2Dia",
                              // "prazoLimite2Data",
                              "percentualDesconto3",
                              // "valorDesconto3",
                              "prazoLimite3Dia",
                              // "prazoLimite3Data",
                              "multaPercentual",
                              // "multaValor",
                              "prazoMultaDias",
                              // "prazoMultaData",
                              "msgFichaCompensacaoL1",
                              "msgFichaCompensacaoL2"});
        fields.listSimpleTransaction.put("BG73-VOLTA",
                new String[] { "codigoBordero", });
    }
}
