package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas gerais -
 * Titulos Liquidados/ titulos Liquidados dia - lista títulos por cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGD4 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGD4 - Consultas gerais - Titulos Liquidados/ titulos Liquidados dia
        // - lista títulos por cedente

        fields.listFixDataRecordsetTransaction.put("BGD4-IDA",
        		new String[] {
                      "tipoConsulta",
                      "codigoCedente",
                      "pagina",
                      "nossoNumero",
                      "dataInicio",
                      "dataFim"});
        fields.listFixDataRecordsetTransaction.put("BGD4-VOLTA-F",
        		new String[] { 
        				"totalRegistro",
        				"tipoConsulta",
        				"pagina",
        				"nossoNumero",
                        "dataInicio",
                        "dataFim"});
        
        fields.listFixDataRecordsetTransaction.put("BGD4-VOLTA-R",
                new String[] {
                              "nossoNumero",
                              "valorPagamento",
                              "meioLiquidacao",
                              "formaLiquidacao",
                              "sequencialDia",
                              "dataPagamentoLista",
 							  "parcela"});
    }
}
