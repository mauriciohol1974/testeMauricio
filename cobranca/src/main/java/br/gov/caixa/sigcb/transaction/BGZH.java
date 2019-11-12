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
 * @author Maurício Assis de Holanda
 */
public class BGZH implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG86 - Consultar Solicitação de Segunda via de Extrato
        fields.listSimpleTransaction.put("BGZH-IDA",
                new String[] {  "opcao",
        						"banco",
        						"dataRecebimento",
        						"horaRecebimento",
        						"sequencial" });
        fields.listSimpleTransaction.put("BGZH-VOLTA",
                new String[] {
                              "opcao",
                              "descOpcao",
                              "bancoOrigem",
                              "dataRecebimento",
                              "agenciaOrigem",
                              "horaRecebimento",
                              "sequencial",
                              "cedente",
                              "nomeCedente",
                              "tipoPessoaCedente",
                              "cpfCnpjCedente",
                              "tipoPessoaSacado",
                              "cpfCnpjSacado",
                              "nossoNumero",
                              "codCanal",
                              "descCanal",
                              "banco",
                              "agencia",
                              "valorDocumento",
                              "dataMovimento",
                              "valorDescAbatimento",
                              "codFormaRecebimento",
                              "valorJuros",
                              "nsuSIGCB",
                              "valorMulta",
                              "nsuSITRC",
                              "valorAcrescimo",
                              "nsuBACEN",
                              "dthrBACEN",
                              "valorRecebido",
                              "codBarras",
                              "tpBarras",
                              "codMensagem",
                              "codErro",
                              "icTransfere",
                              "descricaoErro",
                              "cdSituacaoAnterior",
                              "deSituacaoAnterior",
                              "dthrSituacaoAnterior",
                              "cdSituacaoAtual",
                              "deSituacaoAtual",
                              "dthrSituacaoAtual",
                              "codDevolucao" ,
                              "cedenteCorrigido",
                              "nossoNumeroCorrigido",
                              "descCodDevolucao",
                              "dataVencimento",
                              "usuarioAnterior",
                              "usuarioAtual",
                              "ISPBOrigem"});
    }
}
