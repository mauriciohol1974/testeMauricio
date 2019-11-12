package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Listar Solicitações de
 * Segunda Via Extrato
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BG88 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG88 - Incluir, Alterar Solicitação de Segunda Via de Extrato
        fields.listSimpleTransaction.put("BG88-IDA",
                new String[] { "codigoCedente", "tipoExtrato" });
    }
}