package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script respons�vel por colocar e retirar a m�scara
 * de formata��o Cep de um n�mero.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */

public class FormataCep extends Script {
    /**
     * Vari�vel que armazena o nome do controle.
     */
    private String controlName;

    /**
     * M�todo getScript. Retorna um script respons�vel por colocar e retirar a
     * m�scara de formata��o de percentual de um n�mero.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das fun��es formataPercentual e
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
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String
     */
    public String getOnKeyPress() {
        return "";
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - Chamada da fun��o formataPercentual.
     */
    public String getOnBlur() {
        return "formataCep(this)";
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - Chamada da fun��o unFormataPercentual.
     */
    public String getOnFocus() {
        return "unFormataCep(this)";
    }

    /**
     * M�todo setControlName. Atribui � inst�ncia o nome de seu controle.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }
}
