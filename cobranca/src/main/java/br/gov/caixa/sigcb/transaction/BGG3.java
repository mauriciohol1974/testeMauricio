package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais -
 * Movimentacao de Titulos/Tarifas/Float
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGG3 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGG3-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGG3-VOLTA-F",
                new String[] {
                              "nomeUnidade",
                              "totalQtd",
                              "totalValor",
                              "totalTarifa",
                              "totalPreco",
                              "totalResultado", });
        fields.listFixDataRecordsetTransaction.put("BGG3-VOLTA-R",
                new String[] {
                              "tipoTitulo",
                              "descricao",
                              "qtd",
                              "valor",
                              "tarifa",
                              "preco",
                              "resultado", });
    }
}
