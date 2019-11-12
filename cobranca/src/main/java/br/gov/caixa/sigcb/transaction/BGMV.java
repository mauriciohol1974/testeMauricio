package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Historico de Cedente - Consultar detalhe
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGMV implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA6:

        fields.listFixDataRecordsetTransaction.put("BGMV-IDA",
                new String[] {
                              "codCedente",
                               });
        fields.listFixDataRecordsetTransaction.put("BGMV-VOLTA-F",
                new String[] { "codCedente" });
        fields.listFixDataRecordsetTransaction.put("BGMV-VOLTA-R",
                new String[] {
                              "data",
                              "hora",
                              "tpAlteracao",
                              "tipoAlteracao",
                              "usuario",
                              "icAnterior",
                              "sitAnterior",
                              "icAtual",
                              "sitAtual"});
    }
}
