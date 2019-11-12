package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class BGM0 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        fields.listSimpleTransaction.put("BGM0-IDA",
                new String[] {
                              "tipoConsulta",
                              "codigoCedente",
                              "codigoClienteCOCLI",
                              "codigoUsuario",
                              "origemConsulta" });
        fields.listSimpleTransaction.put("BGM0-VOLTA",
                new String[] {
                              "codigoClienteCOCLI",
                              "tipoPessoa",
                              "cpfCnpj",
                              "nomeFantasia",
                              "razaoSocial",
                              "email",
                              "logradouro",
                              "numero",
                              "complemento",
                              "bairro",
                              "municipio",
                              "uf",
                              "cep",
                              "carteira",
                              "idEndereco",
                              "situacao" });
    }
}
