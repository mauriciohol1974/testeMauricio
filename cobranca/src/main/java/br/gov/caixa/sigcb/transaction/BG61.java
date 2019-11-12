package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BG61 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG61: Banco de titulos - Consulta Dados Liquidação

        fields.listSimpleTransaction.put("BG61-IDA",
                new String[] { "codigoCedente", "nossoNumero", "meioEntrada" });
        fields.listSimpleTransaction.put("BG61-VOLTA",
                new String[] {
                              "liquiDataLiquidacao",
                              "liquiCanalLiquidacao",
                              "liquiDataPagamento",
                              "liquiDiasFloat",
                              "liquiDataCredito",
                              "liquiValorDocumento",
                              "liquiValorJurosMulta",
                              "liquiValorDesconto",
                              "liquiAbatimento",
                              "liquiValorLiquidoRecebido",
                              "retidoValorIOF",
                              "iofAtraso61",
                              "jurosAtrasoMora",
                              "feriadoLocal",
                              "pvRecebedor",
                              "pvCobrador"});
    }
}
