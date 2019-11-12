package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Movimento cedente (extrato)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGB0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGB0-IDA",

        new String[] { "codigoCedente", "dataEmissao", "pagina", "paginaFinal" });

        fields.listFixDataRecordsetTransaction.put("BGB0-VOLTA-F",

        new String[] { "totalRegistro", "totalTitulos" });

        fields.listFixDataRecordsetTransaction.put("BGB0-VOLTA-R",

        new String[] {
                      "codigoMovimento",
                      "descricaoMovimento",
                      "nomeSacado",
                      "nossoNumero",
                      "dataVencimento",
                      "valorTitulo",
                      "valorEncargos",
                      "seuNumero",
                      "dataPagamento",
                      "valorAbatimento",
                      "valorDesconto",
                      "dataMovimento",
                      "valorCredito",
                      "valorTarifa",
                      "dataCredito",
                      "valorIOF",
                      "feriadoLocal",
                      "parcela",
                      "nuIdentCIP"
                      });
    }
}
