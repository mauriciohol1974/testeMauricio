package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo com valores fixos de periodo
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 * @version release 1.0
 */
public class ComboPeriodo extends ComboFixo {
    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("30 DIAS");

        listCodigos.add("2");
        listDescricoes.add("60 DIAS");

        listCodigos.add("3");
        listDescricoes.add("90 DIAS");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(String codigo) {
        if ("1".equals(codigo)) {
            return "30 DIAS";
        } else if ("2".equals(codigo)) {
            return "60 DIAS";
        } else if ("3".equals(codigo)) {
            return "90 DIAS";
        }
        return "";
    }
}
