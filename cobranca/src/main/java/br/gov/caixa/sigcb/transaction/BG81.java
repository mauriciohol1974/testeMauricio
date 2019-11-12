package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Liquidacoes Rejeitadas >>
 * Filtro >> Listar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BG81 implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BG81: Liquidacoes Rejeitadas – Listar Liquidacoes Rejeitadas

        fields.listSimpleTransaction.put("BG81-IDA",
                new String[] {
                              "tipoOpcao",
                              "meioLiquidacao",
                              "codigoUnidadePV",
                              "dataInicial" });
        fields.listSimpleTransaction.put("BG81-VOLTA",
                new String[] {
                              "dataReferencia",
                              "numeroSequencia",
                              "codigoCedenteOriginal",
                              "nossoNumeroOriginal",
                              "valorOriginal",
                              "codigoCedenteCorrigido",
                              "nossoNumeroCorrigido",
                              "valorRecebido",
                              "situacaoAnterior",
                              "dataSituacaoAnterior",
                              "codigoErro",
                              "mensagemErro",
                              "numeroBanco",
                              "numeroLote",
                              "numeroLoteCorreto",
                              "numeroLoterico",
                              "sequenciaLote",
                              "dataMovimento",
                              "meioLiquidacao",
                              "tipoCarteira",
                              "descricaoTipoCarteira",
                              "valorCorrigido",
                              "usuario",
                              "parcela"});
    }

}
