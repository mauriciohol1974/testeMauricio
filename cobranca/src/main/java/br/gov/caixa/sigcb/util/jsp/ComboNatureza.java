package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade XXX FUNCIONALIDADE XXX
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboNatureza extends ComboTransacao {

    public ComboNatureza() {
        this.setTransacao("BGM4");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

}
