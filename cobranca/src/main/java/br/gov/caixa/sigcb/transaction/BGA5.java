package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Historico de Cedente - Listar Cedentes por PV
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGA5 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA5:

        fields.listFixDataRecordsetTransaction.put("BGA5-IDA",
                new String[] {
                              "codigoUnidadePv",
                              "dataMovimento",
                              "guia",
                              "usuario", });
        fields.listFixDataRecordsetTransaction.put("BGA5-VOLTA-F",
                new String[] { "nomeUnidadePv" });
        fields.listFixDataRecordsetTransaction.put("BGA5-VOLTA-R",
                new String[] {
                              "codigoCedente",
                              "nomeCedente",
                              "tipoPessoa",
                              "cpfCnpj", });
    }
}
