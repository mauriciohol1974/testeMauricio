package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Protesto - Envio ao Cart�rio (Lista) - Incluir
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Fev / 2009</DD>
 * </DL>
 *
 * @author Cristian Souza - Probank/REDEASP02
 */
public class BGSB implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        /* BGSB: Servi�os - Protesto - Envio ao Cart�rio (Lista) - Incluir
         * strRecordSet conte�m os seguintes campos:
         * Cedente..................9(06)
         * Nosso N�mero.............9(17)
         * Despesas Cartor�rias.....9(05)V99
         */ 

        fields.listSimpleTransaction.put("BGSB-IDA",
                new String[] {
                              "codigoUsuario",
                              "nomeGrupo",
                              "strRecordset" });
    }
}
