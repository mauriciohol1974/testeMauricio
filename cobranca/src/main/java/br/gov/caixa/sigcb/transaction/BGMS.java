package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade consultas Gerais -
 * Titulos Liquidados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class BGMS implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGMS-IDA",

        new String[] {
                      
                      "codigoCedente",
                      "nossoNumero",
                      "situacao",
                      "pagina"});

        fields.listSimpleTransaction.put("BGMS-VOLTA",

        new String[] {
                      "codigoCedente",
                      "nossoNumero",
                      "descrSituacao",
                      "numPagina",
                      "numPaginaPagador",
                      "dataSituacao",
                      "numDocumento",
                      "valorTitulo",
                      "nomeSacado",
                      "cpfCnpj",
                      "dtVencimento"                      
                    });
    }
}
