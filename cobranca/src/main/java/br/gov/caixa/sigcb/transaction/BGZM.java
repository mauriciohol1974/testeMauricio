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
public class BGZM implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG86 - Consultar Solicitação de Segunda via de Extrato
        fields.listSimpleTransaction.put("BGZM-IDA",
                new String[] {  "opcao",
        						"banco",
        						"dataRecebimento",
        						"horaRecebimento",
        						"sequencial" });
        fields.listSimpleTransaction.put("BGZM-VOLTA",
                new String[] {
                              
                              "cedenteOrigem",
                              "nomeCedente",
                              "tipoPessoaCedente",
                              "cpfCnpjCedente",
                              "tipoPessoaSacado",
                              "cpfCnpjSacado",
                              "nossoNumero",
                              "codCanal",
                              "descCanal",
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
                              "dthrSituacaoAnterior",
                              "cdSituacaoAtual",
                              "dthrSituacaoAtual",
                              "codDevolucao" ,
                              "cedenteCorrigido",
                              "nossoNumeroCorrigido",
                              "descCodDevolucao",
                              "dataVencimento"});
    }
}
