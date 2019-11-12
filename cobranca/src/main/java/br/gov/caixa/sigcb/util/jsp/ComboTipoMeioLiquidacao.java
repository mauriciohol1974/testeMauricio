package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag para mostrar Combo de Meio Liquidacao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboTipoMeioLiquidacao extends ComboTransacao {

    public ComboTipoMeioLiquidacao() {
        this.setTransacao("BGN5");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

}
