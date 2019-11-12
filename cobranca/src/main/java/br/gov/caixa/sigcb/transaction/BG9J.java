package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * Projeto: SIGCB
 * Detalhes do Titulo DDA
 * Criada em: 02/10/2009
 * @author Glauber Gallego
 */
public class BG9J implements LayoutTransaction, Serializable {

	public void setLayout(FieldsByTransaction fields) {

		fields.listFixDataRecordsetTransaction.put("BG9J-IDA",
				new String[] {
				"numeroControleRequisicao"
				});
		fields.listFixDataRecordsetTransaction.put("BG9J-VOLTA-F",
				new String[] {
				"numeroControleRequisicao",
				"dataMovimento",
				"tipoBloquetoDda",
				"numeroIdentificacaoDda",
				"codigoBancoCedente",
				"nomeBancoCedente",
				"agenciaCedente",
				"tipoPessoaCedente",
				"cpfCnpjCedente",
				"codigoCedente",
				"nomeCedente",
				"enderecoCedente",
				"municipioCedente",
				"ufCedente",
				"cepCedente",
				"tipoPessoaSacado",
				"cpfCnpjSacado",
				"nomeSacado",
				"enderecoSacado",
				"municipioSacado",
				"ufSacado",
				"cepSacado",
				"tipoPessoaSacador",
				"cpfCnpjSacador",
				"nomeSacador",
				"tipoPessoaTerceiro",
				"cpfCnpjTerceiro",
				"dataVencimento",
				"dataDocumento",
				"dataProcessamento",
				"nossoNumero",
				"numeroDocumento",
				"codigoTipoEspecie",
				"descricaoTipoEspecie",
				"codigoTipoCarteira",
				"descricaoTipoCarteira",
				"descricaoTipoAceite",
				"valorAbatimento",
				"dataJuros",
				"tipoJuros",
				"valorJuros",
				"percentualJuros",
				"dataMulta",
				"valorMulta",
				"percentualMulta",
				"codigoMoeda",
				"nomeMoeda",
				"descricaoMoeda",
				"valorTitulo",
				"indicadorTituloNegociado",
				"indicadorInformacaoAdicional",
				"codigoBarrasFormatado",
				"codigoBarrasNumerico"
				});

		fields.listFixDataRecordsetTransaction.put("BG9J-VOLTA-R",
				new String[] {
				"descricaoGrupoDesconto",
				"dataDesconto",
				"tipoDesconto",
				"valorDesconto",
				"percentualDesconto",
				});

	}
}
