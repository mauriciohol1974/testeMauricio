package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGD0 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        fields.listSimpleTransaction.put("BGD0-IDA",

        new String[] { "codigoCedente", "dataSolicitacao" });

        fields.listSimpleTransaction.put("BGD0-VOLTA",

        new String[] { "descServicos", "codigoUsuario", "motivoRejeicao" });
    }
}
