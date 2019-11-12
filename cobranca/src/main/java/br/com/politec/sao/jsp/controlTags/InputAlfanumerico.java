package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de campos que permitam apenas a entrada de dados
 * alfanum�ricos, impedindo a digita��o de caracteres especiais.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class InputAlfanumerico extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputAlfanumerico() {
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
            super.getScriptGenerator().addScript("ValidaDigitacaoAlfanumerico",
                    this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputAlfaNumerico: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputAlfaNumerico.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getOnKeyPress. Renderiza o c�digo de controle da tag, para impedir
     * a entrada de dados indesejados durante a digita��o.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada da fun��o ValidaDigitacaoAlfanumerico.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoAlfanumerico", this.getPath());
    }
}