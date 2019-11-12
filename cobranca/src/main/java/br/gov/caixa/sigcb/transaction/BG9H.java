package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * Projeto: SIGCB
 * Listar Titulos em Aceite / Alegacao de um CPF/CNPJ Informado
 * Criada em: 02/10/2009
 * @author Glauber Gallego
 */
public class BG9H implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

		fields.listFixDataRecordsetTransaction.put("BG9H-IDA", new String[] {
				"tipoDataFiltro",
				"mesAnoFiltro",
				"dataFiltro",
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				 });
		fields.listFixDataRecordsetTransaction.put("BG9H-VOLTA-F",
				new String[] {
				"tipoDataFiltro",
				"mesAnoFiltro",
				"dataFiltro",
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				"quantidadePorCpfCnpj",
				"valorPorCpfCnpj" });
		fields.listFixDataRecordsetTransaction.put("BG9H-VOLTA-R",
				new String[] {
				"numeroControleRequisicao",
				"numeroIdentificacaoDda",
				"dataMovimento",
				//"quantidadeAceite",
				"aceite",
				"valorAceite",
				//"quantidadeNaoAceite",
				//"valorNaoAceite"
				});

    }
}
