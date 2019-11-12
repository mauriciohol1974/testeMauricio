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
public class ComboTipoExtrato extends ComboFixo {
    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("5");
        listDescricoes.add("Movimentação de Títulos");

        listCodigos.add("9");
        listDescricoes.add("Movimentação de Débitos e Créditos");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(String codigo) {
        if ("5".equals(codigo)) {
            return "Movimentação de Títulos";
        } else if ("9".equals(codigo)) {
            return "Movimentação de Débitos e Créditos";
        }
        return "";
    }
}
