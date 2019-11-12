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
public class BG87 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG87 - Incluir, Alterar Solicitação de Segunda Via de Extrato
        fields.listSimpleTransaction.put("BG87-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "tipoExtrato",
                              "dataInicio",
                              "dataFim",
                              "entrega",
                              "meioEntrada",
                              "usuario" });
    }
}