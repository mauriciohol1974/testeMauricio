package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento de Cedente (extrato)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGB1 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGB1-IDA",

        new String[] { "codigoCedente", "dataEmissao" });

        fields.listSimpleTransaction.put("BGB1-VOLTA",

        new String[] {
                      "qtdCreditoPeriodo",
                      "valorCreditoPeriodo",
                      "qtdDebitoPeriodo",
                      "valorDebitoPeriodo" });
    }
}
