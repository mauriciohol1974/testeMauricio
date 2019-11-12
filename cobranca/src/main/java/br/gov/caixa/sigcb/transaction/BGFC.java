package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB </B> <BR>
 * Componente responsável pelo controle da funcionalidade Consultar Detalhes
 * Usuario de Cliente Internet
 * <DL>
 * <DT><B>Criada em: </B>
 * <DD>20/11/2004</DD>
 * </DL>
 * 
 * @author Glauber Micheloni Gallego
 */
public class BGFC implements LayoutTransaction, Serializable {
    public void setLayout(FieldsByTransaction fields) {

        // BGFC - Consulta Detalhes
        fields.listSimpleTransaction.put("BGFC-IDA",
                new String[] { "cpfUsuario" });
        fields.listSimpleTransaction.put("BGFC-VOLTA",
                new String[] {
                              "nome",
                              "cep",
                              "uf",
                              "endereco",
                              "numero",
                              "complemento",
                              "bairro",
                              "municipio",
                              "email",
                              "departamento",
                              "dddTelefone",
                              "numeroTelefone",
                              "ramalTelefone",
                              "dddFax",
                              "numeroFax",
                              "ramalFax",
                              "dddCelular",
                              "numeroCelular" });
    }
}