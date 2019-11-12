package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe responsável pela validação de caracteres digitados em campos que
 * aceitam apenas a entrada de caracteres numéricos.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDigitacaoNumericoInteiro extends Script {
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
     * Método getScript. Retorna um script que valida caracteres digitados em
     * campos que aceitam apenas a entrada de caracteres numéricos.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaDigitacaoNumericoInteiro.
     */
    public String getScript() {
 
    	return "    function validaDigitacaoNumericoInteiro(valor) {\r\n"
               + "        numerosInteiros = '1234567890';\r\n"
               + "        if (numerosInteiros.indexOf(valor) >= 0) {\r\n"
               + "            return true;\r\n"
               + "        } else {\r\n"
               + "            return false;\r\n"
               + "        }\r\n"
               + "    }\r\n";
        }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - Chamada da função validaDigitacaoNumericoInteiro.
     */
    public String getOnKeyPress() {
        return "return validaDigitacaoNumericoInteiro(String.fromCharCode(event.charCode || event.keyCode))";
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
