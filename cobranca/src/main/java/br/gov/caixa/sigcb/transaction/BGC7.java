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
 * <DD>27/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGC7 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGC7-IDA",

        new String[] { "tipoConsulta", "codigoCedente", "dataSolicitacao" });

        fields.listSimpleTransaction.put("BGC7-VOLTA",

        new String[] { "nossoNumeroInicial", "nomeSacado", "numeroDocumento", "valorTitulo", "dataVencimento", "codigoUsuario", "parcela" });
    }
}
