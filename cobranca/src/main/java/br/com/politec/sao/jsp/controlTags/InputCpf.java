package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a entrada de dados no
 * formato de CPF, impedindo a digitação de caracteres especiais.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class InputCpf extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputCpf() {
    }

    /**
     * Método doStartTag. Renderiza o código da tag. Adiciona os scripts
     * ValidaDigitacaoNumericoInteiro, FormataCPF e ValidaDVCPF.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator()
                    .addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
            super.getScriptGenerator().addScript("FormataCPF", this.getPath());
            super.getScriptGenerator().addScript("ValidaDVCPF", this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputCpf: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputCpf.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método getSize. Retorna o tamanho do campo na página.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getSize()
     * @return int
     */
    public int getSize() {
        return 19;
    }

    /**
     * Método getMaxlength. Retorna a capacidade máxima do campo, ou seja, o
     * tamanho, em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getMaxlength()
     * @return int
     */
    public int getMaxlength() {
        return 11;
    }

    /**
     * Método getOnBlur. Renderiza o código de controle da tag, para permitir a
     * formatação do CPF quando o controle perder o foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnBlur()
     * @return String - Chamada do script FormataCPF.
     */
    public String getOnBlur() {
        return super.getScriptGenerator().getOnBlur("FormataCPF",
                this.getPath())
               + ";"
               + super.getOnBlur();
    }

    /**
     * Método getOnFocus. Renderiza o código de controle da tag, para permitir a
     * retirada da máscara de formatação do CPF quando o controle ganhar o foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnFocus()
     * @return String - Chamada do script FormataCPF.
     */
    public String getOnFocus() {
        return super.getScriptGenerator().getOnFocus("FormataCPF",
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