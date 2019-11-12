package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informa��es necess�rias para o parsing dos
 * pacotes ISO8583 pela framework. O dados s�o mantidos e organizados por
 * transa��o, identificando se o layoute � relativo a subida da mensagem
 * "XXXX-IDA", ou a descida da mensagem "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGN3 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGN3: Combo � Esp�cie de T�tulo

        fields.listSimpleTransaction.put("BGN3-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGN3-VOLTA",
                new String[] { "codigo", "minemonico", "descricao", });
    }
}
