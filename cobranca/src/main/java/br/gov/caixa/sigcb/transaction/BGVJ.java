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
public class BGVJ implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG48: Banco de Sacados - Excluir/Validar Inclus�o

        fields.listSimpleTransaction.put("BGVJ-IDA",
                new String[] {
                              "passo",
                              "nu_simulacao",
                              "icPessoa",
                              "cnpjTela",
                              "coCedente",
                              "cocli",
                              "pvVinc"
                             });
        fields.listSimpleTransaction.put("BGVJ-VOLTA", new String[] {
			        		  "nu_simulacao",
			                  "situacao",
			                  "nuSequencial",
			                  "dataValidade",
			                  "usuarioAutorizador",
			                  "nomeUsuario",
			                  "unidadeAutorizador",
			                  "nomeUnidade",
			                  "dataSolicitacao",
			                  "horaSolicitacao",
			                  "nuSeqRegistro",
			                  "nuTransAtu",
			                  "deTransmissao",
			                  "nuTransNeg",
			                  "deTransmissaoNeg",
			                  "deOcorrencia",
			                  "nsuCedente"
			                          		
        });
    }
}