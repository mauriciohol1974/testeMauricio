package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;


/**
 * <B>Projeto: SIGCB</B><BR>
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abril/2013</DD>
 * </DL>
 * 
 * @author Maur�cio Assis de Holanda
 */
public class BGZI implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG86 - Consultar Solicita��o de Segunda via de Extrato
        fields.listSimpleTransaction.put("BGZI-IDA",
                new String[] {  "opcao",
        						"nsuSIGCB",
        						"cedenteCorrigido",
        						"nnEnvio",
        						"codDevolucaoEnvio",
        						"coUsuario"});
        fields.listSimpleTransaction.put("BGZI-VOLTA",
                new String[] {  "msgRetorno"});
    }
}
