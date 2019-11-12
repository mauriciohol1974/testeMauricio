package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Listar Cedentes por Unidade PV
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGF2 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGF2-IDA",
                new String[] {
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data",
                              "codigoUsuario",
                              "tipoRelatorio"

                });
        fields.listFixDataRecordsetTransaction.put("BGF2-VOLTA-F",
                new String[] { "nomeUnidade", });
        fields.listFixDataRecordsetTransaction.put("BGF2-VOLTA-R",
                new String[] {
                              "codigoCedente",
                              "nomeCedente",
                              "tipoPessoa",
                              "cpfCnpj", });
    }
}
