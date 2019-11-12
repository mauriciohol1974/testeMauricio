package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para buscar informações da situação do titulo junto ao
 * mainframe e carregar o combo com as informações para disponibilizar pagina
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGN4 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BGN4: Combo – Situação de titulo

        fields.listSimpleTransaction.put("BGN4-IDA", new String[] {});
        fields.listSimpleTransaction.put("BGN4-VOLTA",
                new String[] { "codigo", "descricao" });
    }
}
