package br.com.politec.sao.jsp;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.controlTags.Form;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Base para todas as tags da framework web Politec, provendo os métodos comuns,
 * e interfaces comuns a todas as tags da framework.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Glauber M. Gallego- ggallego@sao.politec.com.br inclusao da tag
 *         "klass", inclusao da tag disabled
 * @version release 1.3.1
 */
public class Control extends TagSupport {
    /**
     * Armazena o valor do atributo value do elemento sendo renderizado.
     */
    private String value = "";

    /**
     * Armazena o valor do atributo name do elemento sendo renderizado.
     */
    private String name = "";

    /**
     * Armazena o valor do atributo class do elemento sendo renderizado. o nome
     * CLASS esta sendo utilizado devido a impossibilidade de uso de "class"
     */
    private String CLASS = "";

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>disabled</i>.
     */
    private String disabled = "false";

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>readonly</i>.
     */
    private String readonly = "false";

    /**
     * Armazena o estilo CSS associado ao elemento sendo renderizado.
     */
    private String style = "";

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>onKeyPress</i>.
     */
    private String onKeyPress = "";

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>onBlur</i>.
     */
    private String onBlur = "";

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>onFocus</i>.
     */
    private String onFocus = "";

    /**
     * Armazena o código a ser renderizado para o evento HTML <i>onKeyUp</i>.
     */
    private String onKeyUp = "";

    /**
     * Método getValue. Retorna o valor ( atributo <i>value</i> ) do elemento
     * sendo renderizado.
     * 
     * @return String
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Método setValue. Atribui o atributo <i>value</i> do elemento sendo
     * renderizado.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Método getName. Retorna o atributo <i>name<i> do elemento sendo
     * renderizado.
     * 
     * @return String
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Método setName. Atribui um nome ( atributo <i>name</i> ) ao elemento
     * sendo renderizado.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Método getStyle. Retorna o estilo CSS associado ao elemento sendo
     * renderizado.
     * 
     * @return String
     */
    public String getStyle() {
        return style;
    }

    /**
     * Método setStyle. Associa um estilo CSS ao elemento sendo renderizado.
     * 
     * @param style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Método getKlass. Retorna o class CSS associado ao elemento sendo
     * renderizado.
     * 
     * @return String
     */
    public String getCLASS() {
        return CLASS;
    }

    /**
     * Método setStyle. Associa o class CSS ao elemento sendo renderizado.
     * 
     * @param klass
     */
    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @return String
     */
    public java.lang.String getOnKeyPress() {
        return onKeyPress;
    }

    /**
     * Método setOnKeyPress. Atribui o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @param onKeyPress
     */
    public void setOnKeyPress(java.lang.String onKeyPress) {
        this.onKeyPress = onKeyPress;
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @return String
     */
    public java.lang.String getOnBlur() {
        return onBlur;
    }

    /**
     * Método setOnBlur. Atribui o código a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @param onBlur
     */
    public void setOnBlur(java.lang.String onBlur) {
        this.onBlur = onBlur;
    }

    /**
     * Método getOnFocus. Obtém o código a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @return String
     */
    public java.lang.String getOnFocus() {
        return onFocus;
    }

    /**
     * Método setOnFocus. Atribui o código a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @param onFocus
     */
    public void setOnFocus(java.lang.String onFocus) {
        this.onFocus = onFocus;
    }

    /**
     * Método getOnKeyUp. Obtém o código a ser renderizado para o evento HTML
     * <i>onKeyUp</i>.
     * 
     * @return String
     */
    public java.lang.String getOnKeyUp() {
        return onKeyUp;
    }

    /**
     * Método setOnKeyUp. Atribui o código a ser renderizado para o evento HTML
     * <i>onKeyUp</i>.
     * 
     * @param onKeyUp
     */
    public void setOnKeyUp(java.lang.String onKeyUp) {
        this.onKeyUp = onKeyUp;
    }

    /**
     * Método getDisabled. Obtém o código a ser renderizado para o evento HTML
     * <i>disabled</i>.
     * 
     * @return String
     */
    public java.lang.String getDisabled() {
        return disabled;
    }

    /**
     * Método setOnKeyUp. Atribui o código a ser renderizado para o evento HTML
     * <i>onKeyUp</i>.
     * 
     * @param onKeyUp
     */
    public void setDisabled(java.lang.String disabled) {
        this.disabled = disabled;
    }

    /**
     * Método getReadonly Obtém o código a ser renderizado para o evento HTML
     * <i>readonly</i>.
     * 
     * @return String
     */
    public String getReadonly() {
        return readonly;
    }

    /**
     * Método setReadonly. Atribui o código a ser renderizado para o evento HTML
     * <i>readonly</i>.
     * 
     * @param string
     */
    public void setReadonly(String string) {
        readonly = string;
    }

    /**
     * Método getScriptGenerator. Obtém a instância correta do
     * <code>ScriptGenerator</code>.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        return getTagForm(this).getScriptGenerator();
    }

    /**
     * Método getPath. Retorna o "path" javascript relativo ao documento
     * raiz.ex: em "document.form.input", retornaria "form.input".
     * 
     * @return String
     */
    public String getPath() {
        return "document." + getTagForm(this).getName() + "." + this.getName();
    }

    /**
     * Método auxiliar de getScriptGenerator e getPath para obter uma instancia
     * da do tipo
     * 
     * @see br.com.politec.sao.jsp.controlTags.Form
     * @return Form
     */
    private Form getTagForm(Tag tag) {
        Tag parent = (Tag) tag.getParent();
        if (!(parent instanceof Form))
            parent = getTagForm(parent);
        return (Form) parent;
    }

}