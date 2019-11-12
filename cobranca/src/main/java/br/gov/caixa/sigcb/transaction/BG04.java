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
 * <DD>21/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG04 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG04-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoUsuario",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "tipoCobranca",
                              "protestoAutomatico",
                              "prazoProtesto",
                              "prazoDevolucao",
                              "extratoMovTit",
                              "destinoExtMov",
                              "extratoMovDebtCredt",
                              "destinoExtMovDebtCredt",
                              "inventarioMes",
                              "tipoJurosDia",
                              "percentualJurosDia",
                              "multa",
                              "prazoMulta",
                              "recebimentoCheque",
                              "bancoSacados",
                              "modalidadeTitulo",
                              "clienteSINCE",
                              "clienteGiroCaixa",
                              "exclusaoAutomatica",
                              "natureza",
                              "ramoAtividade",
                              "setor",
                              "porte",
                              "clienteExterno",
                              "bancoCorrespondente",
                              "codigoUnidadePVVinc",
                              "codCedenteCentraliz",
                              "cobrancaSemBloqueto",
                              "codRedeTransmissao",
                              "atividade",
                              "retencaoIOF",
                              "valorDiferenciado",
                              "codigoSINCE",
                              "cedentePEC",
                              "cedenteVinculo",
                              "dataPEC"});
        fields.listSimpleTransaction.put("BG04-VOLTA",
                new String[] { "descricaoCriticas" });
    }
}
