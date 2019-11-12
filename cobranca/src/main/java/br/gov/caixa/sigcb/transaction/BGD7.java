package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Valores a serem Lançados - Transacao BGD7
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGD7 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGD7: Consultas Gerais - Valores a serem lancados - Detalhe
        fields.listSimpleTransaction.put("BGD7-IDA",

        new String[] {
                      "codigoCedente",
                      "unidadeVinculacao",
                      "operacao",
                      "conta" });

        fields.listSimpleTransaction.put("BGD7-VOLTA",

        new String[] { "dataLancamento", "valorCredito", "valorDebito" }

        );

    }

}
