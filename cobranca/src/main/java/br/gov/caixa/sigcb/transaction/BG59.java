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
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BG59 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG59: Banco de titulos - Consulta por consolidado

        fields.listFixDataRecordsetTransaction.put("BG59-IDA",
                new String[] { "codigoCedente" });

        fields.listFixDataRecordsetTransaction.put("BG59-VOLTA-F",
                new String[] { "quantidadeTotal", "valorTotal" });
        fields.listFixDataRecordsetTransaction.put("BG59-VOLTA-R",
                new String[] {
                              "situacao",
                              "descricaoSituacao",
                              "quantidade",
                              "valor" });
    }
}
