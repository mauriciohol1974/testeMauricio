package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Tarifa Liquidação por Serviços / Meio Liquidação
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGH1 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGH1-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGH1-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalQtd",
                              "totalValorEsperado",
                              "totalValorCusto",
                              "totalValorEfetivado", });
        fields.listFixDataRecordsetTransaction.put("BGH1-VOLTA-R",
                new String[] {
                              "descricao",
                              "qtd",
                              "valorEsperado",
                              "valorCusto",
                              "valorEfetivado", });
    }
}
