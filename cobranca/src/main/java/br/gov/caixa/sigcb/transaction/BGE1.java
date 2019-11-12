package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Servicos solicitados - solicitaçoes Processadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGE1 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGE1-IDA",

        new String[] {
                      "codigoUnidadePv",
                      "dataSolicitacao",
                      "tpConsulta",
                      "codigoUsuario" });
        fields.listFixDataRecordsetTransaction.put("BGE1-VOLTA-F",
                new String[] { "nomePvVinculacao" });

        fields.listFixDataRecordsetTransaction.put("BGE1-VOLTA-R",

        new String[] { "codigoCedente", "nomeFantasia" });
    }
}