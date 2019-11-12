package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de campos que permitam apenas a digita��o de campos
 * num�ricos.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class InputNumerico extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputNumerico() {
    }

    /**
     * M�todo doStartTag. Renderiza o c�digo da tag. Adiciona o script
     * ValidaDigitacaoNumericoInteiro.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator()
                    .addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputNumerico: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputNumerico.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getOnKeyPress. Renderiza o c�digo de controle da tag, para impedir
     * a entrada de dados indesejados durante a digita��o.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada da fun��o ValidaDigitacaoNumericoInteiro.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoNumericoInteiro", this.getPath());
    }
}