package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Títulos Liquidados com Retenção IOF
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/01/2011</DD>
 * </DL>
 * 
 * @author Adelaine Rondon - adelaine.rondon@probank.com.br
 */
public class BGH9 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGH9-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGH9-VOLTA-R",
                new String[] {
                              "descricao",
                              "qtd",
                              "valorRecebido",
                              "valorLiquido",
                              "valorIOFRetido", });
        fields.listFixDataRecordsetTransaction.put("BGH9-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalQtd",
                              "totalValorRecebido",
                              "totalValorLiquido",
                              "totalValorIOFRetido", });
    }
}
