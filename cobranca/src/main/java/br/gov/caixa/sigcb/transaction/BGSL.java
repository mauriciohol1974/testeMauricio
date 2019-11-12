package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informações necessárias para o parsing dos
 * pacotes ISO8583 pela framework. O dados são mantidos e organizados por
 * transação, identificando se o layoute é relativo a subida da mensagem
 * "XXXX-IDA", ou a descida da mensagem "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>06/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BGSL implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGSL

        fields.listSimpleTransaction.put("BGSL-IDA",
                new String[] {
	      		  "nuIdentificacao",
	      		  "nuIdentBaixa",
	      		  "dthrbxoper"
                              });

        fields.listSimpleTransaction.put("BGSL-VOLTA",
                new String[] {"cobeneficiario",
        		  "nossonumero",
        		  "dthrbxoper",
        		  "ispbparticpt",
        		  "coparticipt",
        		  "dtprocbxoper",
        		  "vlbxoper",
        		  "cobarras",
        		  "canalpgto",
        		  "meiopgto",
        		  "tpbxoper",
        		  "nureferatual",
        		  "nuidentbxoper",
        		  "nuseqbxoper",
        		  "nucontroledda",
        		  "dthrdda",
        		  "dtmovimento",
        		  "dthrsitbxoper",
        		  "qtpgtoparcial",
        		  "vlsaldottl",
        		  "sittitpagto",
        		  "sittitulo",
        		  "tpPessoaPort",
           	      "cpfCnpjPortador",
           	      "coPagtoTitulo" });
    }
}
