
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
 * <DD>03/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BG03 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG03-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "codigoUnidadePVVinc", });
        fields.listSimpleTransaction.put("BG03-VOLTA",
                new String[] {
                              "tipoCobranca",
                              "protestoAutomatico",
                              "prazoProtesto",
                              "prazoDevolucao",
                              "extratoMovTit",
                              "destinoExtMov",
                              "descDestinoExtMov",
                              "extratoMovDebtCredt",
                              "destinoExtMovDebtCredt",
                              "descDestinoExtMovDebtCredt",
                              "inventarioMes",
                              "tipoJurosDia",
                              "descTipoJurosDia",
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
                              "descNatureza",
                              "ramoAtividade",
                              "descRamoAtividade",
                              "setor",
                              "descSetor",
                              "porte",
                              "descPorte",
                              "clienteExterno",
                              "bancoCorrespondente",
                              "codigoUnidadePVVinc",
                              "codigounidadeEN",
                              "codCedenteCentraliz",
                              "situacao",
                              "cobrancaSemBloqueto",
                              "codRedeTransmissao",
                              "atividade",
                              "retencaoIOF",
                              "valorDiferenciado",
                              "codigoSINCE",
                              "cedentePEC",
                              "cedenteVinculo",
                              "dataPEC",
                              "pvVincAnt",
                              "dtAltPvVinc"});
    }
}
