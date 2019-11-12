package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Listar Solicitações de
 * Perfil Internet
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGFG implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFG - Listar Perfis Internet
        fields.listSimpleTransaction.put("BGFG-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGFG-VOLTA",
                new String[] {
                              "codigoPerfil",
                              "descricaoPerfil",
                              "servicoPerfil" });
    }
}