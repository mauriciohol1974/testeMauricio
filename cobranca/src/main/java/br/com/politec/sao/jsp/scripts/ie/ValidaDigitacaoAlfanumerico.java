package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o c�digo javascript respons�vel pela valida��o de campos
 * alfanum�ricos, impedindo que caracteres inv�lidos sejam digitados.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDigitacaoAlfanumerico extends Script {
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
     * respons�vel pela valida��o de campos alfanum�ricos, impedindo que
     * caracteres inv�lidos sejam digitados.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o validaDigitacaoAlfanumerico.
     */
    public String getScript() {
         return "    function validaDigitacaoAlfanumerico(valor) { \r\n"
               + "        numerosInteiros = '1234567890';\r\n"
               + "        alfa = \"abcdefghijklmnopqrstuvxzkwy ABCDEFGHIJLMNOPQRSTUVXZKWY'.,-\";\r\n"
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
     * @return String - Chamada da fun��o validaDigitacaoAlfanumerico.
     */
    public String getOnKeyPress() {
    	/* w3c - event.charCode || event.keyCode para funcionar no firefox */
        return "return validaDigitacaoAlfanumerico(String.fromCharCode(event.charCode || event.keyCode))";
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
/*
 * <HTML> <head> <meta http-equiv='Content-Type' content="text/html;
 * charset=iso-8859-1"/> </head> <BODY> <form name="frmain" action = ""> <INPUT
 * TYPE="TEXT" NAME="nomeBancoSacado" SIZE="300 MAXLENGTH="20"
 * ONKEYPRESS="return validaDigitacaoAlfanumerico(event.keyCode,this)"> </form>
 * </BODY> <SCRIPT language='JavaScript'> Esta vers�o substitui os caracteres
 * acentuados pelos correpondentes n�o acentuados, por exemplo � por c function
 * validaDigitacaoAlfanumerico(evento, obj) { valor =
 * String.fromCharCode(evento); numerosInteiros = '1234567890'; alfa =
 * "abcdefghijklmnopqrstuvxzkwy ABCDEFGHIJLMNOPQRSTUVXZKWY'.,-"; especiais
 * ="����������������������������������������������"; especiaisCorrigidos
 * ="AAAAACEEEEIIIIOOOOOUUUUaaaaaceeeeiiiiooooouuuu"; if
 * ((numerosInteiros.indexOf(valor) >= 0) || (alfa.indexOf(valor) >= 0)) {
 * return true; } else { if (especiais.indexOf(valor) >= 0){ var posicao =
 * especiais.indexOf(valor); obj.value += especiaisCorrigidos.substr(posicao,1);
 * return false; } else { return false; } } } </SCRIPT> </html>
 */