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
 * <DD>06/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BGSJ implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGSJ

        fields.listSimpleTransaction.put("BGSJ-IDA",
                new String[] {
	      		  "nuIdentificacao",
	      		  "nuIdentBaixa",
	      		  "dthrbxoper"
                              });

        fields.listSimpleTransaction.put("BGSJ-VOLTA",
                new String[] {"cobeneficiario",
        		  "nossonumero",
        		  "dthrbxoper",
        		  "ispbparticpt",
        		  "coparticipt",
        		  "tppessoa",
        		  "cpfcnpjportdr",
        		  "dtprocbxoper",
        		  "vlbxoper",
        		  "cobarras",
        		  "canalpgto",
        		  "meiopgto",
        		  "iccontigencia",
        		  "tpbxoper",
        		  "nureferatual",
        		  "nuidentbxoper",
        		  "nuseqbxoper",
        		  "nucontroledda",
        		  "dthrdda",
        		  "dtmovimento",
        		  "sitbxoper",
        		  "dthrsitbxoper",
        		  "qtpgtoparcial",
        		  "vlsaldottl",
        		  "sittitpagto",
        		  "sitcancbxoper",
        		  "dthrcancbxoper" });
    }
}
