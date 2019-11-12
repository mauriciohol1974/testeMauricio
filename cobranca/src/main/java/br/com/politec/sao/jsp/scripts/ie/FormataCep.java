package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script responsável por colocar e retirar a máscara
 * de formatação Cep de um número.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */

public class FormataCep extends Script {
    /**
     * Variável que armazena o nome do controle.
     */
    private String controlName;

    /**
     * Método getScript. Retorna um script responsável por colocar e retirar a
     * máscara de formatação de percentual de um número.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das funções formataPercentual e
     *         unFormataPercentual.
     */
    public String getScript() {
        return "function formataCep(obj){"
               + "	var result ='';"
               + "	for(i=obj.value.length, x=0; i>=0; i--, x++) {"
               + "    result = obj.value.charAt(i) + result;"
               + "        if((x==3)) {"
               + "           result = '-' + result;"
               + "        }"
               + " }"
               + "	obj.value = result;"
               + "}"
               + "function unFormataCep(obj) {"
               + "	var result = '';"
               + "	for(i=0; i<obj.value.length; i++) {"
               + "		if(obj.value.charAt(i)!='-') {"
               + "			result = result + obj.value.charAt(i);"
               + "		}"
               + "	}"
               + "	obj.value = result;"
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
     * <i>onBlur</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - Chamada da função formataPercentual.
     */
    public String getOnBlur() {
        return "formataCep(this)";
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - Chamada da função unFormataPercentual.
     */
    public String getOnFocus() {
        return "unFormataCep(this)";
    }

    /**
     * Método setControlName. Atribui à instância o nome de seu controle.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }
}
