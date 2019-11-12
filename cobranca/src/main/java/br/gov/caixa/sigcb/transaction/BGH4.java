package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Total de Tarifas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGH4 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGH4-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGH4-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "resValExterno",
                              "resValInterno",
                              "resValTotal", });
        fields.listFixDataRecordsetTransaction.put("BGH4-VOLTA-R",
                new String[] {
                              "descricao",
                              "valorExterno",
                              "valorInterno",
                              "valorTotal", });
    }
}
