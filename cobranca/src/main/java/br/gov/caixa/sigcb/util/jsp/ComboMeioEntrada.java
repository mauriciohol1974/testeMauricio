package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Combo Connect
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2011</DD>
 * </DL>
 * 
 * @author Maur�cio Holanda
 */
public class ComboMeioEntrada extends ComboTransacao {

    public ComboMeioEntrada() {
        this.setTransacao("BGN5");
    }

    public int doStartTag() throws JspException {
        try {
            return super.doStartTag();
        } catch (Exception ex) {
            LogUtilSigcb.error("ComboConnect: Erro na contrucao da Tag: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }
    }

}
