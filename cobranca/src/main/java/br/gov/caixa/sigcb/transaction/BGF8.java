package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Cedentes por Situação Teste/Produção e Movimento
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF8 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGF8-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGF8-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalSemMovto",
                              "totalComMovto",
                              "totalGeral", });
        fields.listFixDataRecordsetTransaction.put("BGF8-VOLTA-R",
                new String[] {
                              "tipoAssunto",
                              "descricao",
                              "qtdSemMovto",
                              "qtdComMovto",
                              "qtdTotal", });
    }
}