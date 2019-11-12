package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Rentabilidade do Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGB4 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGB4-IDA",

        new String[] { "codigoCedente", "periodo" });

        fields.listSimpleTransaction.put("BGB4-VOLTA",

        new String[] {
                      "valorBrutoTarifas",
                      "outrosCustos",
                      "precoTransferencia",
                      "sinalValorLiquido",
                      "valorLiquido",
                      "qtdBloquetos",
                      "sinalRentabilidadeMedia",
                      "rentabilidadeMedia" });
    }
}
