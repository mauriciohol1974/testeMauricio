package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script responsável por colocar e retirar a máscara
 * de formatação de um CPF.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class FormataCPF extends Script {
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
     * Método getScript. Retorna um script responsável por colocar e retirar a
     * máscara de formatação de um CPF.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das funções formataCPF e unFormataCPF.
     */
    public String getScript() {
        return "function formataCPF(obj) {\n"
               + "  var result ='';\n"
               + "  fillCPFWithZeros(obj);\n"
               + "  for(i=obj.value.length, x=0; i>=0; i--, x++) {\n"
               + "    result = obj.value.charAt(i) + result;\n"
               + "    if(x==2) {\n"
               + "      result = '-' + result;\n"
               + "    } else if ((x==5)||(x==8)) {\n"
               + "      result = '.' + result;\n"
               + "	}\n"
               + "  }\n"
               + "  obj.value = result;\n"
               + "}\n"
               + "\n"
               + "function unFormataCPF(obj) {\n"
               + "  var result = '';\n"
               + "  for(i=0; i<obj.value.length; i++) {\n"
               + "    if((obj.value.charAt(i)!='.')&&(obj.value.charAt(i)!='-')) {\n"
               + "	  result = result + obj.value.charAt(i);\n"
               + "    }\n"
               + "  }\n"
               + "  obj.value = result;\n"
               + "  fillCPFWithZeros(obj);\n"
               + "}\n"
               + "\n"
               + "function fillCPFWithZeros(obj) {\n"
               + "  if(obj.value!=''){\n"
               + "    while(obj.value.length<11){\n"
               + "      obj.value = '0'+obj.value;\n"
               + "    }\n"
               + "  }\n"
               + "}\n";

    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - Chamada da função formataCPF.
     */
    public String getOnBlur() {
        return "formataCPF(this)";
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - Chamada da função unFormataCPF.
     */
    public String getOnFocus() {
        return "unFormataCPF(this)";
    }
}
