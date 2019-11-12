package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * Projeto: SIGCB
 * Listar Titulos de um CPF/CNPJ Informado
 * Criada em: 02/10/2009
 * @author Glauber Gallego
 */
public class BG9G implements LayoutTransaction, Serializable {

	public void setLayout(FieldsByTransaction fields) {

		fields.listFixDataRecordsetTransaction.put("BG9G-IDA", new String[] {
				"tipoConsulta",
				"tipoDataFiltro",
				"mesAnoFiltro",
				"dataFiltro",
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				 });
		fields.listFixDataRecordsetTransaction.put("BG9G-VOLTA-F",
				new String[] {
				"tipoConsulta",
				"tipoDataFiltro",
				"mesAnoFiltro",
				"dataFiltro",
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				"quantidadePorCpfCnpj",
				"valorPorCpfCnpj" });
		fields.listFixDataRecordsetTransaction.put("BG9G-VOLTA-R",
				new String[] {
				"numeroControleRequisicao",
				"numeroIdentificacaoDda",
				"dataMovimento",
				"dataVencimento",
				"dataPagamento",
				"valorTitulo" });

	}
}
