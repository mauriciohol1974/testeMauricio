package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consulta Gerais -
 * Historico de Cedente - Consultar detalhe
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGA6 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA6:

        fields.listFixDataRecordsetTransaction.put("BGA6-IDA",
                new String[] {
                              "codigoCedente",
                              "dataInicial",
                              "dataFinal",
                              "guia", });
        fields.listFixDataRecordsetTransaction.put("BGA6-VOLTA-F",
                new String[] { "codigoUnidadePv", "nomeUnidadePv", });
        fields.listFixDataRecordsetTransaction.put("BGA6-VOLTA-R",
                new String[] {
                              "informacaoAlterada",
                              "dataMovimento",
                              "hora",
                              "usuario",
                              "valorAnterior",
                              "valorAtual", });
    }
}
