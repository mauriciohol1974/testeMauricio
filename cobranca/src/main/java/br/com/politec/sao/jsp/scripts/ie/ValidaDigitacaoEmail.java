package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o c�digo javascript respons�vel pela valida��o de campos de email,
 * impedindo que caracteres inv�lidos sejam digitados.
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDigitacaoEmail extends Script {
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
     * M�todo getScript. Retorna um script que renderiza o c�digo javascript
     * respons�vel pela valida��o de campos de email, impedindo que caracteres
     * inv�lidos sejam digitados.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o validaDigitacaoEmail.
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
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - Chamada da fun��o validaDigitacaoEmail.
     */
    public String getOnKeyPress() {
        return "return validaDigitacaoEmail(String.fromCharCode(event.charCode || event.keyCode))";
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String
     */
    public String getOnBlur() {
        return "";
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String
     */
    public String getOnFocus() {
        return "";
    }
}
