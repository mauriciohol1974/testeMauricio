package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Cedentes por Meio de Entrada
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF7 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGF7-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGF7-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalQtdRegComMovto",
                              "totalQtdRegSemMovto",
                              "totalQtdSRegComMovto",
                              "totalQtdSRegSemMovto", });
        fields.listFixDataRecordsetTransaction.put("BGF7-VOLTA-R",
                new String[] {
                              "descricao",
                              "qtdRegComMovto",
                              "qtdRegSemMovto",
                              "qtdSRegComMovto",
                              "qtdSRegSemMovto", });
    }
}
