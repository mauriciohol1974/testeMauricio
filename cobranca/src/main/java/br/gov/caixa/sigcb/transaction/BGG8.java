package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerenciais -
 * T�tulos Liquidados com Float = 0
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGG8 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGG8-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoUnidade",
                              "tipoData",
                              "mesAno",
                              "data", });
        fields.listFixDataRecordsetTransaction.put("BGG8-VOLTA-F",
                new String[] { "nomeUnidade", "totalQtd", "totalValor", });
        fields.listFixDataRecordsetTransaction.put("BGG8-VOLTA-R",
                new String[] { "descricao", "qtd", "valor", });
    }
}
