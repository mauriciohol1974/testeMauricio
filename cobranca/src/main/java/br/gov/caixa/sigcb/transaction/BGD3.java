package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas gerais -
 * Titulos Liquidados/ titulos Liquidados dia - lista cedentes por unidade
 * vinculacao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class BGD3 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGD3 - Consultas gerais - Titulos Liquidados/ titulos Liquidados dia
        // - lista cedentes por unidade vinculacao

        fields.listFixDataRecordsetTransaction.put("BGD3-IDA",

        new String[] {
                      "tipoConsulta",
                      "unidadeVinculacao",
                      "codigoUsuario",
                      "nossoNumero",
                      "dataInicio",
                      "dataFim"});
        fields.listFixDataRecordsetTransaction.put("BGD3-VOLTA-F",

        new String[] { "nomeUnidade",
        			   "nossoNumero",
        			   "tipoConsulta",
        			   "dataInicio",
                       "dataFim"});
        
        fields.listFixDataRecordsetTransaction.put("BGD3-VOLTA-R",
                new String[] {
                              "codigoCedente",
                              "nomeFantasia",
                              "tipoPessoa",
                              "cpfCnpj" });
    }
}
