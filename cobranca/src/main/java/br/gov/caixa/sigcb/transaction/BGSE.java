package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Protesto - SUSTA - Incluir
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Fev / 2009</DD>
 * </DL>
 *
 * @author Cristian Souza - Probank/REDEASP02
 */
public class BGSE implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGSE: Servi�os - Protesto - SUSTA - Gera��o de Arquivo - Incluir

        fields.listSimpleTransaction.put("BGSE-IDA",
                new String[] {
                              "codigoCedente",
                              "nossoNumero",
                              "acoesValorRecebido",
                              "acoesDespesasCartorarias",
                              "acoesHistorico",
                              "codigoUsuario",
                              "numeroCartorio",
                              "codigoProtocolo",
                              "dataProtocolo",
                              "nomeGrupo"});
    }
}
