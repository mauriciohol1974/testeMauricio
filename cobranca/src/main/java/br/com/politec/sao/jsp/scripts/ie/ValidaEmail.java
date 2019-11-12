package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script responsável por validar a integridade do
 * conteúdo de um valor do tipo email.
 * 
 * @author Eduardo A. Moras - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaEmail extends Script {
    /**
     * Método getScript. Retorna um script que valida a integridade do conteúdo
     * de um valor do tipo email.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Scripts das funções validaEmail.
     */
    public String getScript() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("function validaEmail(email){");
        buffer.append("    strRet = email.indexOf('@');");
        buffer.append("    if (strRet =='-1'){");
        buffer.append("       return true;");
        buffer.append("    }");
        buffer.append("    else{");
        buffer.append("       return false;");
        buffer.append("    } ");
        buffer.append("}");
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
