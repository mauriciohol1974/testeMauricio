
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
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGVP implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG48: Banco de Sacados - Excluir/Validar Inclus�o

        fields.listSimpleTransaction.put("BGVP-IDA",
                new String[] {

        			"passo",
        			"tpAcao",
        			"cocli",
        			"nsuCedente",
        			"pvVinc",
        			"icPessoa",
        			"cnpjTela",
        			"nu_simulacao",
        			"coCedente",
        			"codUsuario",
        			"ip"
                              });
        fields.listSimpleTransaction.put("BGVP-VOLTA", new String[] {"nuPendencia"});
    }
}