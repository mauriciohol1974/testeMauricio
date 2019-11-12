package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Valores a serem Lançados - Transacao BGD6
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGZP implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGD6: Consultas Gerais - Valores a serem lancados - listar unidades
        // por cedente

        fields.listSimpleTransaction.put("BGZP-IDA",

        new String[] { "cedente", "nossoNumero"  });

        fields.listSimpleTransaction.put("BGZP-VOLTA",

        new String[] { "banco", "conta", "percPrevisto", "percEfetivo", "valorPrevisto", "valorEfetivo", "cpfCnpj", "titular"});
    }
}
