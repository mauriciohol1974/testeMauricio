package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGA0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA0: Consultas Gerais - Cedente por cedente centralizador
        fields.listSimpleTransaction.put("BGA0-IDA",
                new String[] { "codigoCedente", "usuario" });
        fields.listSimpleTransaction.put("BGA0-VOLTA",
                new String[] {
                              "codigoCedenteCentral",
                              "nomeFantasia",
                              "tipoPessoa",
                              "cpfCnpjPessoa" });
    }
}
