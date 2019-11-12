package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB - DDA </B><BR>
 * Componente responsável pelo controle da funcionalidade DDA >> Sacado Eletrônico >> Incluir Agregado >>
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */

public class BG8I implements LayoutTransaction, Serializable {
	public void setLayout(FieldsByTransaction fields) {
		fields.listSimpleTransaction.put("BG8I-IDA",
				new String[] {
							  "tipoAcao",
							  "tipoPessoa",
							  "cpfCnpj",
							  "tipoPessoaAgreg",
							  "cpfCnpjAgreg",
							  "tipoAutoriza",
							  "usuario",
							  "codMaquina",
							  "codCanal",});
		fields.listSimpleTransaction.put("BG8I-VOLTA",
				new String[] {
							  "codRetorno",
							  "codDb2",
							  "codCics",
							  "msgRetorno",}); 
		
	}
}