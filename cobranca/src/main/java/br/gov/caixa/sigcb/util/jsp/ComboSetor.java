package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo Combo (Setor) usado em Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboSetor extends ComboTransacao {

    public ComboSetor() {
        this.setTransacao("BGM5");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

}
