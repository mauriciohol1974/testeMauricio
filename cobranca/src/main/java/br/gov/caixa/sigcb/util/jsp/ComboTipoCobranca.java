package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo Combo (Tipo Cobranca) usado em Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboTipoCobranca extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("ELETRONICA");

        listCodigos.add("2");
        listDescricoes.add("CONVENCIONAL");

        listCodigos.add("3");
        listDescricoes.add("ELETRONICA SINCO");
        
        listCodigos.add("4");
        listDescricoes.add("ELEITORAL CONVENCIONAL");
        
        listCodigos.add("5");
        listDescricoes.add("ELEITORAL ELETRONICA");

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
            return "ELETRONICA SINCO";
        } else if (new Long(4).equals(codigo)) {
            return "ELEITORAL CONVENCIONAL";
        } else if (new Long(5).equals(codigo)) {
            return "ELEITORAL ELETRONICA";
        }
        return "";
    }

}
