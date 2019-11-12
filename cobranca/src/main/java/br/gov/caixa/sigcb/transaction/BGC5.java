package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGC5 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGC5-IDA",

        new String[] { "tipoConsulta", "codigoCedente", "dataSolicitacao" });

        fields.listSimpleTransaction.put("BGC5-VOLTA",

        new String[] {
                      "tipoEntrega",
                      "dataProcessamento",
                      "dataInicial",
                      "dataFinal",
                      "meioEntrada",
                      "codigoUsuario"});
    }
}
