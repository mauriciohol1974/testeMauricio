package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerenciais -
 * Titulos Inclu�dos - Detalhes
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGG6 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGG6-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data",
                              "tipoTitulo", });
        fields.listFixDataRecordsetTransaction.put("BGG6-VOLTA-F",
                new String[] { "nomeUnidade", "totalQtd", "totalValor", });
        fields.listFixDataRecordsetTransaction.put("BGG6-VOLTA-R",
                new String[] { "descricao", "qtd", "valor", });
    }
}
