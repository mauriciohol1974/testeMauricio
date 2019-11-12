package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto - Consultar - Listar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Fev / 2009</DD>
 * </DL>
 *
 * @author Cristian Souza - Probank/REDEASP02
 */
public class BGSC implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listFixDataRecordsetTransaction.put("BGSC-IDA",
                new String[] { 
				  			  "opcao",
				  			  "codigoUnidadePv", 
				  			  "filtroSelecao",
				  			  "dataSolicitacao",
				  			  "codigoUsuario" });
                fields.listFixDataRecordsetTransaction.put("BGSC-VOLTA-F",
                new String[] { 
        		              "totalRegistros",
        					  "quantidadeTotalTitulo",
        					  "valorTotalTitulo",
        					  "nomeUnidadePv" });
        fields.listFixDataRecordsetTransaction.put("BGSC-VOLTA-R",
                new String[] {
        					  "nossoNumero",
        					  "codigoCedente",
                              "nomeDevedor",
                              "valorTitulo",
                              "dataEnvioProtesto",
                              "valorCusta",
                              "numeroCartorio",
                              "protocolo",
                              "dataProtocolo",
                              "parcela"});
    }

}
