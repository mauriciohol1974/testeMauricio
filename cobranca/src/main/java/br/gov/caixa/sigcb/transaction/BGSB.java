package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto - Envio ao Cartório (Lista) - Incluir
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Fev / 2009</DD>
 * </DL>
 *
 * @author Cristian Souza - Probank/REDEASP02
 */
public class BGSB implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        /* BGSB: Serviços - Protesto - Envio ao Cartório (Lista) - Incluir
         * strRecordSet conteém os seguintes campos:
         * Cedente..................9(06)
         * Nosso Número.............9(17)
         * Despesas Cartorárias.....9(05)V99
         */ 

        fields.listSimpleTransaction.put("BGSB-IDA",
                new String[] {
                              "codigoUsuario",
                              "nomeGrupo",
                              "strRecordset" });
    }
}
