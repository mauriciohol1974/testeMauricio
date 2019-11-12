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
 * <DD>16/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGMP implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG24: Cedente - Listar Cedentes por Unidade PV ou CPF/CNPJ

        fields.listFixDataRecordsetTransaction.put("BGMP-IDA",

        new String[] {
                      "tipoConsulta",
                      "codigoCedente",
                      "usuario" });

        fields.listFixDataRecordsetTransaction.put("BGMP-VOLTA-F",
        		new String[] {"codigoCedente","nomeFantasia","situacao"});
        
        fields.listFixDataRecordsetTransaction.put("BGMP-VOLTA-R",

        new String[] {
                      "codigoCedente",
                      "nomeFantasia",
                      "situacao",
                      "data"}

        );
    }
}
