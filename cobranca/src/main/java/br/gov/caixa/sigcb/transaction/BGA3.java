package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Cedente GIROCAIXA - Listar Cedentes por unidade PV ou CPF/CNPJ
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGA3 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA3: Consulta Gerais - Cedente GIROCAIXA
        // Listar Cedentes por Unidade PV ou CPF/CNPJ

        fields.listFixDataRecordsetTransaction.put("BGA3-IDA",
                new String[] {
                              "tipoConsulta",
                              "tipoPessoa",
                              "cpfCnpj",
                              "codigoUnidadePV",
                              "usuario" });
        fields.listFixDataRecordsetTransaction.put("BGA3-VOLTA-F",
                new String[] { "nomeUnidadePV" });
        fields.listFixDataRecordsetTransaction.put("BGA3-VOLTA-R",
                new String[] {
                              "codigoCedente",
                              "tipoPessoa",
                              "cpfCnpj",
                              "nomeFantasia" });
    }
}
