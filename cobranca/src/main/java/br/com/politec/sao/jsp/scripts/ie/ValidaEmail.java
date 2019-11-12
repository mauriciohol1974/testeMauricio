package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script respons�vel por validar a integridade do
 * conte�do de um valor do tipo email.
 * 
 * @author Eduardo A. Moras - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaEmail extends Script {
    /**
     * M�todo getScript. Retorna um script que valida a integridade do conte�do
     * de um valor do tipo email.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Scripts das fun��es validaEmail.
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
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String
     */
    public String getOnKeyPress() {
        return "";
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

    /**
     * M�todo setControlName. Atribui � inst�ncia o nome de seu controle. Sem
     * implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
    }
}
