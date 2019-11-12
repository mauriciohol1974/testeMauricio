package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Função recebe o campo atual, o tamanho máximo de digitação desse campo e o
 * campo que deverá receber o foco após o preenchimento do campo atual.
 * 
 * @author Ana Paula S. Ramos - apramos@sao.politec.com.br
 * @version release 1.3
 */
public class NavigateFocus extends Script {
    /**
     * Método getScript. Retorna um script que recebe o campo atual, o tamanho
     * máximo de digitação desse campo e o campo que deverá receber o foco após
     * o preenchimento do campo atual.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função navigateFocus.
     */
    public String getScript() {
        return "function navigateFocus(present, maxsize, next){"
               + "if(present.value.length==maxsize){"
               + "next.focus();"
               + "}"
               + "}";
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
    }

    /**
     * Método setControlName. Atribui à instância o nome de seu controle. Sem
     * implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
    }
}
