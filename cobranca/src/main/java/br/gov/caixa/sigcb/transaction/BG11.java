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
 * <DD>25/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG11 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG11-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "codigoUnidadePVVinc", });
        fields.listSimpleTransaction.put("BG11-VOLTA",
                new String[] {
                              "emissaoBloquetos",
                              "descEmissaoBloquetos",
                              "envioBloqueto",
                              "descEnvioBloqueto",
                              "envioAvisoSacado",
                              "descEnvioAvisoSacado",
                              "formasAvisoVencido",
                              "formasAvisoProtesto",
                              "valorMinimoAviso",
                              "qtdeDiasProtesto",
                              "avisoDisponibPrimeira",
                              "avisoDisponibSegunda",
                              "avisoDisponibTerceira",
                              "avisoVencidoPrimeira",
                              "avisoVencidoSegunda",
                              "avisoVencidoTerceira",
                              "impBloqDDA",
                              "envioSMS",
                              "prazoSMS1",
                              "prazoSMS2",
                              "prazoSMS3",
                              "qtdeBolMes",
                              "valorMinULCCA",
                              "valorMaxULCCA"});
    }
}
