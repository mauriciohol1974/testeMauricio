package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BG62 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG62: Banco de titulos - Alteração - pagina Ações

        fields.listSimpleTransaction.put("BG62-IDA",
                new String[] {
                              "codigoCedente",
                              "nossoNumero",
                              "acoesServicoTitulo",
                              "acoesValorRecebido",
                              "acoesDespesasCartorarias",
                              "acoesHistorico",
                              "codigoUsuario",
                              "nomeGrupo" });
    }
}
