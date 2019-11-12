package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Solicita��o de
 * Bloquetos Online
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGFV implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGFV-IDA",
        // BGFV - Incluir Alterar Inclus�o PV Cobrador
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "dataMovimento",
                              "tipoBloqueto",
                              "envioBloqueto",
                              "nossoNumero",
                              "quantidade",
                              "meioEntrada",
                              "codigoUsuario" });
    }
}