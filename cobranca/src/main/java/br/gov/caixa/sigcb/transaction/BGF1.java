package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Listar Unidades PV por Unidade EN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF1 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGF1-IDA",
                new String[] {
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data",
                              "tipoRelatorio" });
        fields.listFixDataRecordsetTransaction.put("BGF1-VOLTA-F",
                new String[] { "nomeUnidade", });
        fields.listFixDataRecordsetTransaction.put("BGF1-VOLTA-R",
                new String[] { "codigoUnidade", "nomeUnidade", });
    }
}
