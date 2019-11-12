package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a entrada de dados do tipo
 * email, impedindo a digitação de caracteres especiais.
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class InputEmail extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputEmail() {
    }

    /**
     * Método doStartTag. Renderiza o código da tag.
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
     * Método getOnKeyPress. Renderiza o código de controle da tag, para impedir
     * a entrada de dados indesejados durante a digitação.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada da função ValidaDigitacaoEmail.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator().getOnKeyPress("ValidaDigitacaoEmail",
                this.getPath());
    }
}