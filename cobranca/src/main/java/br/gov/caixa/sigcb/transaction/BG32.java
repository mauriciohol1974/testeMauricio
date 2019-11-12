package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionação >>
 * transação BG32 - listar Cedentes por Unidade PV ou CPF/CNPJ
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BG32 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG32:listar Cedentes por Unidade PV ou CPF/CNPJ

        fields.listFixDataRecordsetTransaction.put("BG32-IDA",
                new String[] {
                              "tipoConsulta",
                              "tipoPessoa",
                              "cpfCnpj",
                              "codigoUnidadePV",
                              "situacaoPendencia",
                              "codigoUsuario" });

        fields.listFixDataRecordsetTransaction.put("BG32-VOLTA-F",
                new String[] { "nomeUnidadePV" });

        fields.listFixDataRecordsetTransaction.put("BG32-VOLTA-R",
                new String[] { "codigoCedente", // 9(06)
                              "tipoPessoa", // 9(01)
                              "cpfCnpj", // 9(14)
                              "nomeFantasia" // X(40)
                });

    }

}
