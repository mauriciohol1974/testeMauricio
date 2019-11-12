package br.com.politec.sao.jsp.controlTags;

import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização do código HTML correspondente a um campo do tipo texto.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br inclusao da tag
 *         "CLASS" (maiuscula para evitar problemas com "class")
 * @author Eduardo A. Morás - emoras@sao.politec.com.br inclusao da tag
 *         "ONCHANGE"
 * @version release 1.3.2
 */
public class InputTypeText extends Control {
    /**
     * Variável que armazena a capacidade máxima do campo.
     */
    private int maxlength = 0;

    /**
     * Variável que armazena o tamanho do campo na página.
     */
    private int size = 0;

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>onChange</i>.
     */
    private String onChange = "";

    /**
     * Método doStartTag. Renderiza a porção inicial do código da tag. Adiciona
     * o controle Text na página com seus atributos.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            pageContext.getOut().print("<INPUT TYPE=\"TEXT\" NAME=\""
                                       + getName()
                                       + "\" SIZE=\""
                                       + getSize()
                                       + "\" MAXLENGTH=\""
                                       + getMaxlength()
                                       + "\" VALUE=\""
                                       + getValue()
                                       + "\" STYLE=\""
                                       + getStyle()
                                       + "\" CLASS=\""
                                       + getCLASS()
                                       + "\" ONKEYPRESS=\""
                                       + getOnKeyPress()
                                       + "\" ONBLUR=\""
                                       + getOnBlur()
                                       + "\" ONFOCUS=\""
                                       + getOnFocus()
                                       + "\" ONKEYUP=\""
                                       + getOnKeyUp()
                                       + "\" ONCHANGE=\""
                                       + getOnChange()
                                       + "\" "
                                       + (getDisabled().equals("true")
                                               ? "disabled"
                                               : "")
                                       + (getReadonly().equals("true")
                                               ? " readonly "
                                               : "")
                                       + ">");
        } catch (Exception ex) {
            LogUtilSigcb.error("InputTypeText: Erro na contrucao da Tag: "
                               + ex.getMessage(), ex);
            throw new Error("Erro na contrucao da Tag InputTypeText.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método getSize. Retorna o tamanho do campo na página.
     * 
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * Método setSize. Define o tamanho do campo na página.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Método getMaxlength. Retorna a capacidade máxima do campo, ou seja, o
     * tamanho, em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @return int
     */
    public int getMaxlength() {
        return maxlength;
    }

    /**
     * Método setMaxlength. Define a capacidade máxima do campo, ou seja, o
     * tamanho em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @param maxlength
     */
    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    /**
     * Método getOnFocus. Obtém o código a ser renderizado para o evento HTML
     * <i>onChange</i>.
     * 
     * @return String
     */
    public java.lang.String getOnChange() {
        return onChange;
    }

    /**
     * Método setOnFocus. Atribui o código a ser renderizado para o evento HTML
     * <i>onChange</i>.
     * 
     * @param onFocus
     */
    public void setOnChange(java.lang.String onChange) {
        this.onChange = onChange;
    }
}