package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo VAN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2011</DD>
 * </DL>
 * 
 * @author Maurício Holanda
 */
public class BGVL implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGMI: Combo Connect

        fields.listSimpleTransaction.put("BGVL-IDA", new String[] {
        		 "passo",
                 "nu_simulacao",
                 "icPessoa",
                 "cnpj",
                 "coCedente",
                 "cocli",
                 "unidadeAutorizador"
        });
        fields.listSimpleTransaction.put("BGVL-VOLTA",
        new String[] { 
        		"nuServico",
        		"percPad",
        		"valorPad",
        		"percAtu",
        		"valorAtu",
        		"percNeg",
        		"valorNeg",
        		"deServico"
        });
    }
}