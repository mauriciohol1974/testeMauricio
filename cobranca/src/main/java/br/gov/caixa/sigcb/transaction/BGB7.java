package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Protesto de títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGB7 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGB7:

        fields.listFixDataRecordsetTransaction.put("BGB7-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoUnidadePv",
                              "diaProtesto", });
        fields.listFixDataRecordsetTransaction.put("BGB7-VOLTA-F",
                new String[] {
                              "nomeUnidadePv",
                              "quantidadeTotalTitulo",
                              "valorTotalTitulo", });
        fields.listFixDataRecordsetTransaction.put("BGB7-VOLTA-R",
                new String[] {
                              "nossoNumero",
                              "codigoCedente",
                              "nomeDevedor",
                              "tipoPessoa",
                              "cpfCnpj",
                              "seuNumero",
                              "data",
                              "modalidade",
                              "especieTitulo",
                              "valorTitulo",
                              "numeroCartorio",
                              "protocolo",
                              "dataProtocolo",
                              "dataEnvioProtesto",
                              "parcela"});
    }
}
