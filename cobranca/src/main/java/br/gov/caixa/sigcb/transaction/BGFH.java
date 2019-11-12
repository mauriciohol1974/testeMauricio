package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGFH implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGFH-IDA",
        // BGFV - Incluir Alterar Perfil Internet
                new String[] {
                              "tipoAcao",
                              "codigoPerfil",
                              "descricaoPerfil",
                              "servicoPerfil",
                              "meioEntrada",
                              "codigoUsuario" });
    }
}
