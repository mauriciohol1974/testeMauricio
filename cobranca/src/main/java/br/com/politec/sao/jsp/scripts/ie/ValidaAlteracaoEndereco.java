package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o c�digo javascript respons�vel pela valida��o de altera��o de
 * endere�o, limpando o campo CEP quando o endere�o � alterado.
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaAlteracaoEndereco extends Script {
    /**
     * Vari�vel que armazena o nome do controle.
     */
    private String controlName;

    private static final String ASPAS = "\"";

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
        return "var procurarCep = false;"
               + "function validaAlteracaoEndereco(){"
               + "    if(procurarCep){"
               + "        document.frmMain.cepInput.value ="
               + ASPAS
               + ASPAS
               + ";"
               + "    }"
               + "    procurarCep = false;"
               + "}";
    }

    public String getOnKeyPress() {
        return "";
    }

    public String getOnBlur() {
        return "";
    }

    public String getOnFocus() {
        return "";
    }
}
