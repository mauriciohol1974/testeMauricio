package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade da transação BG34
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BG34 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG33: Lista Pendências por Cedente ou Numero Pendência

        fields.listFixDataRecordsetTransaction.put("BG34-IDA",

        new String[] { "codigoCedente", "numeroPendencia", "numeroReiteracao" });

        fields.listFixDataRecordsetTransaction.put("BG34-VOLTA-F",

        new String[] {
                      "perfilUsuarioAlcada",
                      "usuarioGerador",
                      "horaGeracao",
                      "justificativa",
                      "usuarioAutorizador",
                      "perfilUsuarioAut",
                      "dataPendenciaOrig",
                      "dataAutorizacao",
                      "resposta",
                      "usuarioAlterador",
                      "dataAlterador",
                      "datavigenciaINI",
                      "datavigenciaFIM"});

        fields.listFixDataRecordsetTransaction.put("BG34-VOLTA-R",

        new String[] {
                      "ident",
                      "codigoItemExcep",
                      "descrItemExcep",
                      "conteudoAnterior",
                      "conteudoNegociado",
                      "codigoParecer" }

        );

    }

}
