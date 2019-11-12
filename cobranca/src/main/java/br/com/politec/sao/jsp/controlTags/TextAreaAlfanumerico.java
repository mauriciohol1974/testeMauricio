package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a entrada de dados
 * alfanuméricos, impedindo a digitação de caracteres especiais.
 * 
 * @author Eduardo A.Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class TextAreaAlfanumerico extends TextArea {
    /**
     * Construtor default.
     */
    public TextAreaAlfanumerico() {
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
            super.getScriptGenerator().addScript("ValidaDigitacaoAlfanumerico",
                    this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("TextAreaAlfaNumerico: Erro na contrucao da Tag: "
                               + exc.getMessage(),
                    exc);
            throw new Error("Erro na contrucao da Tag TextAreaAlfaNumerico.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método getOnKeyPress. Renderiza o código de controle da tag, para impedir
     * a entrada de dados indesejados durante a digitação.
     * 
     * @return String - Chamada da função limitaLinha.
     */
    public String getOnKeyPress() {
        return super.getOnKeyPress();
    }
}