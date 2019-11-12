package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag para mostrar Emissão de Bloqueto
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboEmissaoBloqueto extends ComboTransacao {

    public ComboEmissaoBloqueto() {
        this.setTransacao("BGN1");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

}
