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
public class BGD5 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGD5-IDA",

        new String[] {
                      "tipoConsulta",
                      "codigoCedente",
                      "nossoNumero",
                      "dataPagamento",
                      "sequencialDia",
                      "pagina"});

        fields.listSimpleTransaction.put("BGD5-VOLTA",

        new String[] {
                      "valorTitulo",
                      "nossoNumero",
                      "situacaoTitulo",
                      "dataSituacao",
                      "dataVencimento",
                      "modalidade",
                      "dataCredito",
                      "meioEntrada",
                      "moeda",
                      "PvRecebedor",
                      "PvCobrador",
                      "especieTitulo",
                      "aceite",
                      "quantidadeMoeda",
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
                      "valorCobrado",
                      "dataEmissao",
                      "dataProtesto",
                      "prazoProtesto",
                      "numeroLote",
                      "numeroDocumento",
                      "nomeSacado",
                      "descricaoModalidade",
                      "retidoValorIOF",
                      "tipoConsulta",
                      "nossoNumeroLista",
                      "dataPagamentoLista",
                      "pagina",
                      "feriadoLocal",
                      "icRateio",
                      "parcela"});
    }
}
