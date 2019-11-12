package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel por obter o Valor da Tarifa na funcionalidade Servi�os -
 * Tarifa Comandada
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>24/04/2009</DD>
 * </DL>
 * 
 * @author Cristian Souza - Probank/REDEASP02
 */
public class BG94 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG94: Servi�os >> Tarifa Comandada
        // Obter Valor da Tarifa

        fields.listSimpleTransaction.put("BG94-IDA",
                new String[] { "codigoCedente",
        					   "tipoTarifa" });
        fields.listSimpleTransaction.put("BG94-VOLTA",
                new String[] {
        					   "valorTarifa" });
    }
}
