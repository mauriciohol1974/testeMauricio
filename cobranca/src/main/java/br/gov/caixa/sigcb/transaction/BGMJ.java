
package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informações necessárias para o parsing dos
 * pacotes ISO8583 pela framework. O dados são mantidos e organizados por
 * transação, identificando se o layoute é relativo a subida da mensagem
 * "XXXX-IDA", ou a descida da mensagem "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class BGMJ implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGMJ-IDA",
                new String[] {
        					"tipoConsulta",
                        	"codigoCedente",
                        	"codigoClienteCOCLI",
                        	"nsuTransacao",
                        	"codigoUnidadePVVinc" });
        fields.listSimpleTransaction.put("BGMJ-VOLTA",
                new String[]  {"tipoCalculo","autorizacao","icgarantia","icboleto","icvalor","creditoOnline","clienteExterno","icFinalizacao","codigoContabil","unidadeCredito",
        						"icRateio",
        						"icCedenteGarantia",
							    "nuOperacao",
							    "nuContrato",
							    "icBaixa",
							    "icMarcado",
							    "icDesmarcado",
							    "icContaGar",
							    "agCta",
							    "opeCta",
							    "numCta",
							    "digCta",
							    "icLancamento",
        						"nuEvento",
        						"icProposta",
        						"icDebitoTarifa",
        						"icCEP",
        						"icBeneficiario",
        						"nuSITCS",
        						"codigoContabilDeb",
        						"autCCA",
        						"icIndiceEspecial",
        						"tpIndice",
        						"icAplIndiceEspecial",
        						"valorLimite"});
        
    }
}
