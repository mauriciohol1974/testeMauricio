package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade 
 * Consulta Título Liquidado com retenção de IOF
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/12/2010</DD>
 * </DL>
 * 
 * @author Adelaine Rondon
 */

public class BGEC implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGEC-IDA",

        		new String[] {
        			"tipoInformacao",
        			"informacao",
        		    "mes",
                    "ano"});
        fields.listFixDataRecordsetTransaction.put("BGEC-VOLTA-F",
        		
                new String[] { 
        			"nome",
        			"decendio1TotalQuantidade",
        			"decendio1TotalValorTitulos",
        			"decendio1TotalValorCreditado",
        			"decendio1TotalValorIOF",
        			"decendio2TotalQuantidade",
        			"decendio2TotalValorTitulos",
        			"decendio2TotalValorCreditado",
        			"decendio2TotalValorIOF",
        			"decendio3TotalQuantidade",
        			"decendio3TotalValorTitulos",
        			"decendio3TotalValorCreditado",
        			"decendio3TotalValorIOF",
        			});

        fields.listFixDataRecordsetTransaction.put("BGEC-VOLTA-R",

        		new String[] {
        			"decendio",
        			"canal", 
        			"tipoPagamento",
        			"quantidadeTitulos",
        			"valorTitulo",
        			"valorCreditado",
        			"valorIOF"});
    }
}


