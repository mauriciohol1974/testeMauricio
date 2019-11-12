package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pela transacao Liquidacoes Rejeitadas – Executar Acao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>06/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG82 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG82: Liquidacoes Rejeitadas – Executar Acao

        fields.listSimpleTransaction.put("BG82-IDA",
                new String[] {
                              "tipoSolicitacao",
                              "tipoAcao",
                              "dataReferencia",
                              "numeroSequencia",
                              "codigoCedenteOriginal",
                              "codigoCedenteCorrigido",
                              "nossoNumeroOriginal",
                              "nossoNumeroCorrigido",
                              "valorCorrigido",
                              "numeroLoteCorreto",
                              "usuario" });
    }

}
