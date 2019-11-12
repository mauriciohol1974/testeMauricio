package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Bloquetos Laser Padrão
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF3 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGF3-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGF3-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalRegistrada",
                              "totalSemRegistro", });
        fields.listFixDataRecordsetTransaction.put("BGF3-VOLTA-R",
                new String[] { "descricao", "qtdRegistrada", "qtdSemRegistro", });
    }
}
