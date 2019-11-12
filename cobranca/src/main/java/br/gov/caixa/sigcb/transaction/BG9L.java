package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * Projeto: SIGCB
 * Listar Titulos DDA para reimpressao
 * Criada em: 17/01/2010
 * @author Glauber Gallego
 */
public class BG9L implements LayoutTransaction, Serializable {

	public void setLayout(FieldsByTransaction fields) {

		fields.listFixDataRecordsetTransaction.put("BG9L-IDA", new String[] {
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				"dataVencimentoDe",
				"dataVencimentoAte",
				"tipoBloquetoDda",
				 });
		fields.listFixDataRecordsetTransaction.put("BG9L-VOLTA-F",
				new String[] {
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				"dataVencimentoDe",
				"dataVencimentoAte",
				"tipoBloquetoDda",
				});
		fields.listFixDataRecordsetTransaction.put("BG9L-VOLTA-R",
				new String[] {
				"numeroControleRequisicao",
				"dataMovimento",
				"numeroIdentificacaoDda",
				"nossoNumero",
				"codigoCedente",
				"nomeCedente",
				"nomeMoeda",
				"valorTitulo",
				"dataVencimento",
				});

	}
}
