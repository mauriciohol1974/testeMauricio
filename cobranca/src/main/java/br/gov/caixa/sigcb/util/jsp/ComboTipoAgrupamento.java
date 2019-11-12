package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Tipo Agrupamento
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>29/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboTipoAgrupamento extends ComboTransacao {

    public ComboTipoAgrupamento() {
        this.setTransacao("BGN0");
    }

    public int doStartTag() throws JspException {
        try {
            return super.doStartTag();
        } catch (Exception ex) {
            LogUtilSigcb.error("ComboTipoAgrupamento: Erro na contrucao da Tag: "
                               + ex.getMessage(),
                    ex);
            throw new JspException(ex.getMessage());
        }
    }

}
