package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o código javascript responsável pela validação de alteração de
 * endereço, limpando o campo CEP quando o endereço é alterado.
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaAlteracaoEndereco extends Script {
    /**
     * Variável que armazena o nome do controle.
     */
    private String controlName;

    private static final String ASPAS = "\"";

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
