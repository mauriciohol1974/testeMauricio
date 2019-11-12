package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o código javascript responsável pela validação de campos de email,
 * impedindo que caracteres inválidos sejam digitados.
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDigitacaoEmail extends Script {
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
     * Método getScript. Retorna um script que renderiza o código javascript
     * responsável pela validação de campos de email, impedindo que caracteres
     * inválidos sejam digitados.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaDigitacaoEmail.
     */
    public String getScript() {
        return "    function validaDigitacaoEmail(valor) { \r\n"
               + "        numerosInteiros = '1234567890';\r\n"
               + "        alfa = 'abcdefghijklmnopqrstuvxzkwyABCDEFGHIJLMNOPQRSTUVXZKWY.-_@'\r\n"
               + "        if ((numerosInteiros.indexOf(valor) >= 0) || (alfa.indexOf(valor) >= 0)) {\r\n"
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
     * @return String - Chamada da função validaDigitacaoEmail.
     */
    public String getOnKeyPress() {
        return "return validaDigitacaoEmail(String.fromCharCode(event.charCode || event.keyCode))";
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
