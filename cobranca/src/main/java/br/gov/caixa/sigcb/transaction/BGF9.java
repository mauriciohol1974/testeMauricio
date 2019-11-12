package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Movimento Cobrança Eletronica por Tipo de Van
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF9 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGF9-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGF9-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalRemessa",
                              "totalRetorno",
                              "totalRemessaRetorno", });
        fields.listFixDataRecordsetTransaction.put("BGF9-VOLTA-R",
                new String[] {
                              "descricao",
                              "qtdRemessa",
                              "qtdRetorno",
                              "qtdRemessaRetorno", });
    }
}
