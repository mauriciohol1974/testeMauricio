package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Emissão e Postagem de Bloquetos / Extratos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGH0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGH0-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGH0-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalQtd",
                              "totalValorEsperado",
                              "totalValorCusto",
                              "totalValorEfetivado", });
        fields.listFixDataRecordsetTransaction.put("BGH0-VOLTA-R",
                new String[] {
                              "tipoEmissao",
                              "descricao",
                              "qtd",
                              "valorEsperado",
                              "valorCusto",
                              "valorEfetivado", });
    }
}
