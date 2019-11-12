package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações Processadas e solicitados dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGC9 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGC9-IDA",

        new String[] { "tipoConsulta", "codigoCedente", "dataSolicitacao" });

        fields.listSimpleTransaction.put("BGC9-VOLTA",

        new String[] {
                      "nossoNumeroInicial",
                      "nomeSacado",
                      "numeroDocumento",
                      "dataVencimento",
                      "situacao",
                      "valorTitulo",
                      "codigoUsuario",
                      "parcela"});
    }
}
