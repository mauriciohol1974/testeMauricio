package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a entrada de dados no
 * formato de Horário (hh:mm), impedindo a digitação de caracteres especiais.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class InputTime extends InputTypeText {
    /**
     * Construtor default.
     */
    public InputTime() {
    }

    /**
     * Método doStartTag. Renderiza o código da tag. Adiciona os scripts
     * ValidaDigitacaoNumericoInteiro, FormataHora e ValidaHora.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator()
                    .addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
            super.getScriptGenerator().addScript("FormataHora", this.getPath());
            super.getScriptGenerator().addScript("ValidaHora", this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputTime: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputTime.");
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
        return 15;
    }

    /**
     * Método getMaxlength. Retorna a capacidade máxima do campo, ou seja, o
     * tamanho, em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getMaxlength()
     * @return int
     */
    public int getMaxlength() {
        return 4;
    }

    /**
     * Método getOnBlur. Renderiza o código de controle da tag, para permitir a
     * formatação do Horário quando o controle perder o foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnBlur()
     * @return String - Chamada do script FormataHora.
     */
    public String getOnBlur() {
        return super.getScriptGenerator().getOnBlur("FormataHora",
                this.getPath())
               + ";"
               + super.getOnBlur();
    }

    /**
     * Método getOnFocus. Renderiza o código de controle da tag, para permitir a
     * retirada da máscara de formatação do horário quando o controle ganhar o
     * foco.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnFocus()
     * @return String - Chamada do script FormataHora.
     */
    public String getOnFocus() {
        return super.getScriptGenerator().getOnFocus("FormataHora",
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