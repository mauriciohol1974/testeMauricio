package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB - DDA </B><BR>
 * Componente responsável pelo controle da funcionalidade DDA >> Sacado Eletrônico >> Incluir Agregado >>
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class BG8J implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG8J: Consultas Gerais - Cedente por cedente centralizador
    	fields.listFixDataRecordsetTransaction.put("BG8J-IDA",
                new String[] { "tipoPessoa", "cpfCnpj" });
        fields.listFixDataRecordsetTransaction.put("BG8J-VOLTA-F",
                new String[] { "codRetorno", "codDb2", "codCics", "tipoPessoa", "cpfCnpj", "msgRetorno", "qtdAgregado" });
        fields.listFixDataRecordsetTransaction.put("BG8J-VOLTA-R",
                new String[] { "tipoPessoaAgreg", "cpfCnpjAgreg" });    	
    	
        
    }
}
