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
public class BGZL implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BG86 - Consultar Solicitação de Segunda via de Extrato
        fields.listSimpleTransaction.put("BGZL-IDA",
                new String[] {  "dataRecebimento",
        						"banco",
        						"horaRecebimento",
        						"sequencial",
        						"codErro",
        						"codDevolucao"
        						});
        fields.listSimpleTransaction.put("BGZL-VOLTA",
                new String[] {
        						"dataRecebimento",
        						"banco",
        						"horaRecebimento",
        						"agenciaOrigem",
        						"sequencial",
                              "cedenteOrigem",
                              "nossoNumero",
                              "valorRecebido",
                              "dataMovimento",
                              "codDevolucao",
                              "descCodDevolucao",
                              "codErro",
                              "descricaoErro",
                              "codBarras",
                              "tpBarras",
                              "dataVencimento",
                              "nsuSIGCB",
                              "nsuSIGCBRecebimento",
                              "nsuSITRC",
                              "nsuBACEN",
                              "situacaoSPB",
                              "codMensagem", // cd mensagem
                              "dthrSituacaoSPB",
                              "formaRetornoDev",
                              "deSituacaoAnterior",
                              "dthrSituacaoAnterior",
                              "deSituacaoAtual",
                              "dthrSituacaoAtual",
                              "usuarioAnterior",
                              "usuarioAtual", 
                              "nsuSITRCRecebimento",
                              "codRetSITRC",
                              "ISPBOrigem"});
    }
}
