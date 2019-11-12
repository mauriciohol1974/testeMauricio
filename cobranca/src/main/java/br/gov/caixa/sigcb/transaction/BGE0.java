package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consulta Contabeis -
 * Posi��es Cont�beis
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGE0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGE0-IDA",
                new String[] { "tipoConsulta", "codigoUnidade", "data", });
        fields.listFixDataRecordsetTransaction.put("BGE0-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalQuantidadeLiquidacao",
                              "totalValorCreditar", });
        fields.listFixDataRecordsetTransaction.put("BGE0-VOLTA-R",
                new String[] {
                              "codigoUnidade",
                              "nomeUnidade",
                              "quantidadeLiquidacao",
                              "valorCreditar", });
    }
}
