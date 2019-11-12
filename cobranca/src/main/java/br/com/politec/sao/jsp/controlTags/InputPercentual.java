package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a entrada de dados no
 * formato Percentual, impedindo a digitação de caracteres especiais.
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class InputPercentual extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputPercentual() {
    }

    /**
     * Método doStartTag. Renderiza o código da tag. Adiciona os scripts
     * ValidaDigitacaoNumericoInteiro e FormataPercentual.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator()
                    .addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
            super.getScriptGenerator().addScript("FormataPercentual",
                    this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputPercentual: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputPercentual.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método getOnBlur. Renderiza o código de controle da tag, para permitir a
     * formatação do valor percentual quando o controle perder o foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnBlur()
     * @return String - Chamada do script FormataPercentual.
     */
    public String getOnBlur() {
        return super.getScriptGenerator().getOnBlur("FormataPercentual",
                this.getPath())
               + ";"
               + super.getOnBlur();
    }

    /**
     * Método getOnFocus. Renderiza o código de controle da tag, para permitir a
     * retirada da máscara de formatação do valor percentual quando o controle
     * ganhar o foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnFocus()
     * @return String - Chamada do script FormataPercentual.
     */
    public String getOnFocus() {
        return super.getScriptGenerator().getOnFocus("FormataPercentual",
                this.getPath())
               + ";"
               + super.getOnFocus();
    }

    /**
     * Método getOnKeyPress. Renderiza o código de controle da tag, para
     * permitir somente digitação de números inteiros.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada do script ValidaDigitacaoNumericoInteiro.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoNumericoInteiro", this.getPath());
    }
}