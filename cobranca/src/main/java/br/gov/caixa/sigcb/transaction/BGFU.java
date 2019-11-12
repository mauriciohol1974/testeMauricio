package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Listar Solicitações de
 * Bloquetos On-line
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BGFU implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {
        // BGLU - Listar Solicitações Bloqueto On-line
        fields.listSimpleTransaction.put("BGFU-IDA",
                new String[] { "codigoCedente", "dataMovimento", "tipoBloqueto" });
        fields.listSimpleTransaction.put("BGFU-VOLTA",
                new String[] {
                              "dataMovimento",
                              "dataEnvioGrafica",
                              "dataLiberImpr",
                              "tipoBloqueto",
                              "envioBloqueto",
                              "nossoNumero",
                              "quantidade",
                              "numeroPedido",
                              "grafica",
                              "situacaoSolicitacao",
                              "codigoUsuario"});
    }
}