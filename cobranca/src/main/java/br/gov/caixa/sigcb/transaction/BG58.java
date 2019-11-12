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
public class BG58 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG58: Banco de titulos - Consulta por situacao e classificação

        fields.listFixDataRecordsetTransaction.put("BG58-IDA",
                new String[] { 
       						"codigoCedente", 
       						"situacao", 
       						"classificacao",
       						"pagina",
       						"dataInicio",
       						"dataFim",
       						"cmbEmissao",
       						"cmbCarteira",
							"controle"});
        
        fields.listFixDataRecordsetTransaction.put("BG58-VOLTA-F",
                new String[] { 
        					"quantidadeTotal", 
        					"valorTotal",
        					"totalRegistro",
        					"dePeriodo",
							"controle"});

        fields.listFixDataRecordsetTransaction.put("BG58-VOLTA-R",
                new String[] {
                              "nossoNumero",
                              "nomeSacado",
                              "valor",
                              "dataVencimento",
                              "dataUltimoComando",
                              "codigoUltimoComando",
                              "codigoUsuario",
                              "ultDescricao",
                              "cpfSacado",
                              "dtInclusao",
                              "indProtesto",
                              "prazoProtDev",
                              "dtBaixa",
                              "valorPago",
                              "parcela"});
    }
}
