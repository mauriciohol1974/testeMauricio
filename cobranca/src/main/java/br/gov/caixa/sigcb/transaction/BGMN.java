package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGMN implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG58: Banco de titulos - Consulta por situacao e classificação

        fields.listFixDataRecordsetTransaction.put("BGMN-IDA",
                new String[] { 
       						"codigoCedente", 
       						"nossoNumero",
       						"nossoNumeroFim",
       						"classificacao",
       						"pagina"});
        
        fields.listFixDataRecordsetTransaction.put("BGMN-VOLTA-F",
                new String[] { 
        					"quantidadeTotal", 
        					"valorTotal",
        					"totalRegistro"});

        fields.listFixDataRecordsetTransaction.put("BGMN-VOLTA-R",
                new String[] {
        		        		 "indGarantia",
                                 "nossoNumero",
                                 "nomeSacado",
                                 "cpfSacado",
                                 "nuDocto",
                                 "valor",
                                 "dataVencimento",
                });
    }
}
