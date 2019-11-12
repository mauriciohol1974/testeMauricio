package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * O dados s�o mantidos e organizados por transa��o, identificando se o layoute
 * � relativo a subida da mensagem "XXXX-IDA", ou a descida da mensagem
 * "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG07 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG07-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "codigoUnidadePVVinc", });
        fields.listSimpleTransaction.put("BG07-VOLTA",
                new String[] {
                              "tipoConta",
                              "contaRateioUnidade",
                              "contaRateioOperacao",
                              "contaRateioConta",
                              "contaRateioDV",
                              "percentualRateio",
                              "valorRateio" });
    }

}
