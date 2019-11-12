package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida a integridade de um valor do
 * tipo Time(hh:mm).
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaHora extends Script {
    /**
     * Método getScript. Retorna um script que valida a integridade de um valor
     * do tipo Time(hh:mm).
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das funções isValidHoraChar e validaHora.
     */
    public String getScript() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("function isValidHoraChar (c) {\n");
        buffer.append("return ((c >= '0') && (c <= '9') || c == ':')\n");
        buffer.append("}\n");
        buffer.append("function validaHora(obj) {\n");
        buffer.append("var s1 = obj.value;\n");
        buffer.append("if (s1.length!=5) {\n");
        buffer.append("obj.focus();\n");
        buffer.append("return false;\n");
        buffer.append("} else if(s1.charAt(2)!=':') {\n");
        buffer.append("obj.focus();\n");
        buffer.append("return false;\n");
        buffer.append("}\n");
        buffer.append("for (i = 0; i < s1.length; i++) {\n");
        buffer.append("if (!isValidHoraChar(s1.charAt(i))) {\n");
        buffer.append("obj.focus();\n");
        buffer.append("return false;\n");
        buffer.append("}\n");
        buffer.append("}\n");
        buffer.append("var shora = s1.substring(0,2);\n");
        buffer.append("var sminuto = s1.substring(3,5);\n");
        buffer.append("var ihora = parseFloat(shora);\n");
        buffer.append("var iminuto = parseFloat(sminuto);\n");
        buffer.append("if (ihora>23) {\n");
        buffer.append("obj.focus();\n");
        buffer.append("return false;\n");
        buffer.append("} else if (iminuto > 59) {\n");
        buffer.append("obj.focus();\n");
        buffer.append("return false;\n");
        buffer.append("}\n");
        buffer.append("return true;\n");
        buffer.append("}\n");
        return buffer.toString();
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
