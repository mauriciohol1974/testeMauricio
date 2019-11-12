package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Faixa de
 * Rentabilidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ComboFaixaRentabilidade extends ComboFixo {
    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("0");
        listDescricoes.add("NAO CONSIDERAR");

        listCodigos.add("1");
        listDescricoes.add("ABAIXO DE");

        listCodigos.add("2");
        listDescricoes.add("ACIMA DE");

        listCodigos.add("3");
        listDescricoes.add("IGUAL A");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(String codigo) {
        if ("0".equals(codigo)) {
            return "NAO CONSIDERAR";
        } else if ("1".equals(codigo)) {
            return "ABAIXO DE";
        } else if ("2".equals(codigo)) {
            return "ACIMA DE";
        } else if ("3".equals(codigo)) {
            return "IGUAL A";
        }

        return "";
    }
}
