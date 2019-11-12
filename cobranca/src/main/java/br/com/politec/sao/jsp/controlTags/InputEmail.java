package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de campos que permitam apenas a entrada de dados do tipo
 * email, impedindo a digita��o de caracteres especiais.
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class InputEmail extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputEmail() {
    }

    /**
     * M�todo doStartTag. Renderiza o c�digo da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator().addScript("ValidaDigitacaoEmail",
                    this.getPath());
            super.getScriptGenerator().addScript("ValidaEmail", this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputEmail: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputEmail.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getOnKeyPress. Renderiza o c�digo de controle da tag, para impedir
     * a entrada de dados indesejados durante a digita��o.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada da fun��o ValidaDigitacaoEmail.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator().getOnKeyPress("ValidaDigitacaoEmail",
                this.getPath());
    }
}