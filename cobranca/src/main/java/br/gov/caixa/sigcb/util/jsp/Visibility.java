package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade XXX >> Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>03/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class Visibility extends BodyTagSupport {

    private boolean visible = false;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean b) {
        visible = b;
    }

    public int doAfterBody() throws JspException {
        BodyContent t_content = getBodyContent();
        JspWriter t_out = t_content.getEnclosingWriter();

        try {
            if (!isVisible()) {
                t_out.println("<!--");
            }

            t_out.println(t_content.getString());

            if (!isVisible()) {
                t_out.println("-->");
            }
        } catch (IOException e) {
            LogUtilSigcb.error("EXCEPTION afterBody"
                               + this.getClass().getName());
        }

        return SKIP_BODY;
    }

}
