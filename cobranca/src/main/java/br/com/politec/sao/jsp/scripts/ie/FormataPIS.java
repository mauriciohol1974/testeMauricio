package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script respons�vel por colocar e retirar a m�scara
 * de formata��o de um valor do tipo PIS.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class FormataPIS extends Script {
    /**
     * Vari�vel que armazena o nome do controle.
     */
    private String controlName;

    /**
     * M�todo setControlName. Atribui � inst�ncia o nome de seu controle.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
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
     * M�todo getScript. Retorna um script respons�vel por colocar e retirar a
     * m�scara de formata��o de um valor do tipo PIS.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das fun��es formataPIS e unFormataPIS.
     */
    public String getScript() {
        return "function formataPIS(obj) {"
               + "	var result ='';"
               + "	for(i=obj.value.length, x=0; i>=0; i--, x++) {"
               + "    result = obj.value.charAt(i) + result;"
               + "        if(x==1) {"
               + "           result = '-' + result;"
               + "        } else if ((x==4)||(x==8)) {"
               + "    result = '.' + result;"
               + "	}"
               + "}"
               + "	obj.value = result;"
               + "}"
               + "function unFormataPIS(obj) {"
               + "	var result = '';"
               + "	for(i=0; i<obj.value.length; i++) {"
               + "		if((obj.value.charAt(i)!='.')&&(obj.value.charAt(i)!='-')) {"
               + "			result = result + obj.value.charAt(i);"
               + "		}"
               + "	}"
               + "	obj.value = result;"
               + "}";
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - Chamada da fun��o formataPIS.
     */
    public String getOnBlur() {
        return "formataPIS(this)";
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - Chamada da fun��o unFormataPIS.
     */
    public String getOnFocus() {
        return "unFormataPIS(this)";
    }
}
