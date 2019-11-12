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
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGNQ implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGNQ-IDA",
                new String[] {  "tipoAcao",
        						"codBarras1",
        						"codBarras2",
        						"codBarras3",
        						"codBarras4",
        						"codBarras5",
        						"codigoCedente",
        						"nossoNumeroLiq",
        						"princiDataVencimento",
        						"fatorVencimento",
        						"liquiValorDocumento",
        						"meio",
        						"formaPagamento",
        						"liquiDataPagamento",
        						"nsu",
        						"liquiValorLiquidoRecebido",
        						"motivo",
        						"observacoes"
        						
        					});
        fields.listSimpleTransaction.put("BGNQ-VOLTA",
                new String[] {  "codBarras1",
								"codBarras2",
								"codBarras3",
								"codBarras4",
								"codBarras5",
								"codigoCedente",
								"nossoNumeroLiq",
        						"princiDataVencimento",
        						"fatorVencimento",
        						"liquiValorDocumento"
        					});
    }

}
