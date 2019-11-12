package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Gerais -
 * Cedente GIROCAIXA - Consultar Detalhe
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGA4 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGA4: Consulta Gerais - Cedente GIROCAIXA
        // Consultar detalhes

        fields.listSimpleTransaction.put("BGA4-IDA",
                new String[] { "codigoCedente" });
        fields.listSimpleTransaction.put("BGA4-VOLTA",
                new String[] {
                              "nomeAtividade",
                              "dataInclusao",
                              "giroCaixaEstrutural",
                              "dataAlteracao",
                              "matriculaConcessorUsuario",
                              "dataExclusao",
                              "codigoUnidadePV",
                              "nomeUnidadePV",
                              "codigoUnidadeEN",
                              "nomeUnidadeEN" });
    }
}
