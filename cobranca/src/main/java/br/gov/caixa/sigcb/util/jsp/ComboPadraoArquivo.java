package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Padrao Arquivo -
 * Utilizado em Cedente na Guia Cedente Eletronico
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboPadraoArquivo extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("CNAB 240");
        
        listCodigos.add("2");
        listDescricoes.add("CNAB 400");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(Long codigo) {
        if (new Long(1).equals(codigo)) {
            return "CNAB 240";
        }else if (new Long(2).equals(codigo)) {
            return "CNAB 400";
        }
        return "";
    }

}
