package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade XXX FUNCIONALIDADE XXX
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG30 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BG30-IDA",
                new String[] {
                              "tipoAcao",
                              "codigoCedente",
                              "codigoClienteCOCLI",
                              "nsuTransacao",
                              "codigoUnidadePVVinc",
                              "situacao" });
        fields.listSimpleTransaction.put("BG30-VOLTA",
                new String[] { "cadastrado" });
    }
}
