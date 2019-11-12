package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class BGGC implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGGC-IDA",

        new String[] {                      
                      "codigoCedente",
                      "nossoNumero" });

        fields.listSimpleTransaction.put("BGGC-VOLTA",

        new String[] {
                      "valorTitulo",
//                      "nossoNumero",
                      "situacaoTitulo",
                      "dataSituacao",
                      "dataVencimento",
                      "modalidade",
//                      "dataCredito",
                      "meioEntrada",
                      "moeda",
//                      "PvRecebedor",
                      "PvCobrador",
                      "especieTitulo",
//                      "aceite",
//                      "quantidadeMoeda",
                      "valorAbatimento",
                      "valorJuros",
                      "percentualJurosDia",
                      "valorMulta",
                      "PercentualMulta",
                      "dataMulta",
                      "prazoMulta",
                      "valorDesconto1",
                      "percentualDesconto1",
                      "dataDesconto1",
                      "prazoDesconto1",
                      "valorDesconto2",
                      "percentualDesconto2",
                      "dataDesconto2",
                      "prazoDesconto2",
                      "valorDesconto3",
                      "percentualDesconto3",
                      "dataDesconto3",
                      "prazoDesconto3",
                      "dataEntrada",
//                      "valorCobrado",
                      "dataEmissao",
                      "dataProtesto",
                      "prazoProtesto",
//                      "numeroLote",
//                      "numeroDocumento",
//                      "nomeSacado",
//                      "descricaoModalidade",
                      //"numeroDDA",
                      "nuCIP",
                      "nuRefCIP",
                      "cpfCnpj"});
    }
}
