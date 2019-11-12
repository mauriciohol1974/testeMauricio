package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de campos que permitam apenas a entrada de dados no
 * formato de CNPJ, impedindo a digita��o de caracteres especiais.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class InputCnpj extends InputTypeText {

    /**
     * Construtor default ( sem par�metros).
     */
    public InputCnpj() {
    }

    /**
     * M�todo doStartTag. Renderiza o c�digo da tag. Adiciona os scripts
     * ValidaDigitacaoNumericoInteiro, FormataCNPJ e ValidaDVCNPJ.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator()
                    .addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
            super.getScriptGenerator().addScript("FormataCNPJ", this.getPath());
            super.getScriptGenerator()
                    .addScript("ValidaDVCNPJ", this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputCnpj: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputCnpj.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getSize. Retorna o tamanho do campo na p�gina.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getSize()
     * @return int
     */
    public int getSize() {
        return 20;
    }

    /**
     * M�todo getMaxlength. Retorna a capacidade m�xima do campo, ou seja, o
     * tamanho, em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getMaxlength()
     * @return int
     */
    public int getMaxlength() {
        return 14;
    }

    /**
     * M�todo getOnBlur. Renderiza o c�digo de controle da tag, para permitir a
     * formata��o do CNPJ quando o controle perder o foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnBlur()
     * @return String - Chamada do script FormataCNPJ.
     */
    public String getOnBlur() {
        return super.getScriptGenerator().getOnBlur("FormataCNPJ",
                this.getPath())
               + ";"
               + super.getOnBlur();
    }

    /**
     * M�todo getOnFocus. Renderiza o c�digo de controle da tag, para permitir a
     * retirada da m�scara de formata��o do CNPJ quando o controle ganhar o
     * foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnFocus()
     * @return String - Chamada do script FormataCNPJ.
     */
    public String getOnFocus() {
        return super.getScriptGenerator().getOnFocus("FormataCNPJ",
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