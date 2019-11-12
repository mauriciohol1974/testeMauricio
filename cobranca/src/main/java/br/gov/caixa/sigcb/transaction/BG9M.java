package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * Projeto: SIGCB
 * Obter instrucoes de um titulo informado
 * Criada em: 17/01/2010
 * @author Glauber Gallego
 */
public class BG9M implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG9M-IDA",
                new String[] { 
				"numeroControleRequisicao",
				});
        fields.listSimpleTransaction.put("BG9M-VOLTA",
                new String[] {
                "instrucao",
              	});
    }
}