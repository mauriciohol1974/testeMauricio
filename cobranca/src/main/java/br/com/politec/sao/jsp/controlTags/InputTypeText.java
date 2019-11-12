package br.com.politec.sao.jsp.controlTags;

import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o do c�digo HTML correspondente a um campo do tipo texto.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br inclusao da tag
 *         "CLASS" (maiuscula para evitar problemas com "class")
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br inclusao da tag
 *         "ONCHANGE"
 * @version release 1.3.2
 */
public class InputTypeText extends Control {
    /**
     * Vari�vel que armazena a capacidade m�xima do campo.
     */
    private int maxlength = 0;

    /**
     * Vari�vel que armazena o tamanho do campo na p�gina.
     */
    private int size = 0;

    /**
     * Armazena o c�digo a ser renderizado para o evento HTML <i>onChange</i>.
     */
    private String onChange = "";

    /**
     * M�todo doStartTag. Renderiza a por��o inicial do c�digo da tag. Adiciona
     * o controle Text na p�gina com seus atributos.
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
     * M�todo getSize. Retorna o tamanho do campo na p�gina.
     * 
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * M�todo setSize. Define o tamanho do campo na p�gina.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * M�todo getMaxlength. Retorna a capacidade m�xima do campo, ou seja, o
     * tamanho, em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @return int
     */
    public int getMaxlength() {
        return maxlength;
    }

    /**
     * M�todo setMaxlength. Define a capacidade m�xima do campo, ou seja, o
     * tamanho em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @param maxlength
     */
    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    /**
     * M�todo getOnFocus. Obt�m o c�digo a ser renderizado para o evento HTML
     * <i>onChange</i>.
     * 
     * @return String
     */
    public java.lang.String getOnChange() {
        return onChange;
    }

    /**
     * M�todo setOnFocus. Atribui o c�digo a ser renderizado para o evento HTML
     * <i>onChange</i>.
     * 
     * @param onFocus
     */
    public void setOnChange(java.lang.String onChange) {
        this.onChange = onChange;
    }
}