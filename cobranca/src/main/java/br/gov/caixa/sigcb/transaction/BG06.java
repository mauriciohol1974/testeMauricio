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
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG06 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG06-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "codigoUnidadePVVinc",
                              "meioEntradaCaixaDinheiro",
                              "floatCaixaDinheiro",
                              "meioEntradaCaixaCheque",
                              "floatCaixaCheque",
                              "meioEntradaLotericoDinheiro",
                              "floatLotericoDinheiro",
                              "meioEntradaLotericoCheque",
                              "floatLotericoCheque",
                              "meioEntradaCompensacao",
                              "floatCompensacao",
                              "meioEntradaAutoAtendimento",
                              "floatAutoAtendimento",
                              "meioEntradaCorrespondenteBancario",
                              "floatCorrespondenteBancario",
                              "meioEntradaInternetBanking",
                              "floatInternetBanking",
                              "meioEntradaStrTed",
                              "floatStrTed",
                              "meioEntradaMobile",
                              "floatMobile"});
        fields.listSimpleTransaction.put("BG06-VOLTA",
                new String[] { "descricaoCriticas" });
    }
}