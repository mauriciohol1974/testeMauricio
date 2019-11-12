package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo Combo (Giro Caixa) usado em Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboGiroCaixa extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("ELETRONICA");

        listCodigos.add("2");
        listDescricoes.add("CONVENCIONAL");

        listCodigos.add("3");
        listDescricoes.add("NAO UTILIZA GIROCAIXA");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(Long codigo) {
        if (new Long(1).equals(codigo)) {
            return "ELETRONICA";
        } else if (new Long(2).equals(codigo)) {
            return "CONVENCIONAL";
        } else if (new Long(3).equals(codigo)) {
            return "NAO UTILIZA GIROCAIXA";
        }
        return "";
    }
}
