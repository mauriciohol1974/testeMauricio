package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida a integridade dos números de um
 * PIS.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDVPIS extends Script {
    /**
     * Variável que armazena o nome do controle.
     */
    private String controlName;

    /**
     * Método setControlName. Atribui à instância o nome de seu controle.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    /**
     * Método getScript. Retorna um script que valida a integridade dos números
     * de um PIS.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaDVPIS.
     */
    public String getScript() {
        return "function validaDVPIS(obj) {"
               + "	var pis = '';"
               + "	for(i=0; i < obj.value.length; i++) {"
               + "		if((obj.value.charAt(i)!='.') && (obj.value.charAt(i)!='-')) {"
               + "			pis = pis + obj.value.charAt(i);"
               + "		}"
               + "	}"
               + "	if(pis.length != 11) {"
               + "		obj.focus();"
               + "		return false;"
               + "	}"
               + "	var soma = 0;"
               + "	for(i=9, x=2; i==0; i--, x++) {"
               + "		if (x>9) {"
               + "			x=2;"
               + "		}"
               + "		soma += parseInt(pis.charAt(i)) * x;"
               + "	}"
               + "	var digito = 11 - (soma % 11);"
               + "	if (digito>9) {"
               + "		digito = 0;"
               + "	}"
               + "	if (digito==parseInt(pis.charAt(10))) {"
               + "		return true;"
               + "	} else {"
               + "		obj.focus();"
               + "		return false;"
               + "	}"
               + "}";
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String
     */
    public String getOnKeyPress() {
        return "";
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String
     */
    public String getOnBlur() {
        return "";
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String
     */
    public String getOnFocus() {
        return "";
    }
}