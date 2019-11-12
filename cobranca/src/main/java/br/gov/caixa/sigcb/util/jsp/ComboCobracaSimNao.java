package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

public class ComboCobracaSimNao extends ComboFixo {

    private static final long serialVersionUID = -6499638584017350300L;

    public int doStartTag() throws JspException {

        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("2");
        listDescricoes.add("SIM - Pec interno");

        listCodigos.add("3");
        listDescricoes.add("SIM - Pec externo");

        listCodigos.add("1");
        listDescricoes.add("NAO");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(String codigo) {
        if ("2".equals(codigo)) {
            return "SIM - Pec Interno";
        } else if ("3".equals(codigo)) {
            return "SIM - Pec Externo";
        } else if ("1".equals(codigo)) {
            return "NAO";
        }
        return "";
    }
}