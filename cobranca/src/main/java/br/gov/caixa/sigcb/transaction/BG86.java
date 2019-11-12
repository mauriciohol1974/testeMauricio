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
public class BG86 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG86 - Consultar Solicitação de Segunda via de Extrato
        fields.listSimpleTransaction.put("BG86-IDA",
                new String[] { "codigoCedente", "tipoExtrato" });
        fields.listSimpleTransaction.put("BG86-VOLTA",
                new String[] {
                              "dataInicioDisponivel",
                              "dataFimDisponivel",
                              "dataInicio",
                              "dataFim",
                              "dataSolicitacao",
                              "entrega",
                              "usuario" });
    }
}
