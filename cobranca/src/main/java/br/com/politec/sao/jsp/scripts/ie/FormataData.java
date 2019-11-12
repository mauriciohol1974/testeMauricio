package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script responsável por colocar e retirar a máscara
 * de formatação de um valor do tipo data(dd/mm/yyyy).
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - tratamento para
 *         datas menores que 8 digitos
 * @version release 1.3
 */
public class FormataData extends Script {
    /**
     * Variável que armazena o nome do controle.
     */
    private String controlName;

    /**
     * Método getScript. Retorna um script responsável por colocar e retirar a
     * máscara de formatação de um valor do tipo data(dd/mm/yyyy).
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das funções formataData e unFormataData.
     */
    public String getScript() {
        return "function formataData(obj) {"
               + "	var result ='';"
               + " if (obj.value.length < 6)"
               + "   return;"
               + " if (obj.value.length == 6) {"
               + "   result = obj.value.substring(0,4);"
               + "   if (obj.value.substring(4,6) > '70') {"
               + "     result = result + '19' + obj.value.substring(4,6);"
               + "   } else {"
               + "     result = result + '20' + obj.value.substring(4,6);"
               + "   }"
               + "	  obj.value = result;"
               + "	  result ='';"
               + " }"
               + "	for(i=obj.value.length, x=0; i>=0; i--, x++) {"
               + "    result = obj.value.charAt(i) + result;"
               + "    if((x==4)||(x==6)) {"
               + "      result = '/' + result;"
               + "    }"
               + " }"
               + "	obj.value = result;"
               + "}"
               + "function unFormataData(obj) {"
               + "	var result = '';"
               + "	for(i=0; i<obj.value.length; i++) {"
               + "		if(obj.value.charAt(i)!='/') {"
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
     * @return String - Chamada da função formataData.
     */
    public String getOnBlur() {
        return "formataData(this)";
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - Chamada da função unFormataData.
     */
    public String getOnFocus() {
        return "unFormataData(this)";
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
