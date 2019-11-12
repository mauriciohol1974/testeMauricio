package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de campos que permitam apenas a entrada de dados no
 * formato Percentual, impedindo a digita��o de caracteres especiais.
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class InputPercentual extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputPercentual() {
    }

    /**
     * M�todo doStartTag. Renderiza o c�digo da tag. Adiciona os scripts
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
     * M�todo getOnBlur. Renderiza o c�digo de controle da tag, para permitir a
     * formata��o do valor percentual quando o controle perder o foco.
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
     * M�todo getOnFocus. Renderiza o c�digo de controle da tag, para permitir a
     * retirada da m�scara de formata��o do valor percentual quando o controle
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
     * M�todo getOnKeyPress. Renderiza o c�digo de controle da tag, para
     * permitir somente digita��o de n�meros inteiros.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada do script ValidaDigitacaoNumericoInteiro.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoNumericoInteiro", this.getPath());
    }
}