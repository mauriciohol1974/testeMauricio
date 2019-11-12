package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo - Tipo Bloqueto
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class ComboTipoBloqueto extends ComboFixo {
    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("PRE-IMPRESSO MATRICIAL");

        listCodigos.add("2");
        listDescricoes.add("PRE-IMPRESSO A4");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(String codigo) {
        if ("1".equals(codigo)) {
            return "PRE-IMPRESSO MATRICIAL";
        } else if ("2".equals(codigo)) {
            return "PRE-IMPRESSO A4";
        }
        return "";
    }
}
