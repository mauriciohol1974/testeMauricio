package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida o campo Data passado por
 * par�metro com a Data atual do Sistema.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDataAtual extends Script {
    /**
     * M�todo getScript. Retorna um script que valida o campo Data passado por
     * par�metro com a Data atual do Sistema.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o validaDataAtual.
     */
    public String getScript() {
        return "function validaDataAtual(campoData){"
               + "var dataAtual = new Date();"
               + "var diaAtual = new Number(dataAtual.getDate()).valueOf();"
               + "var mesAtual = new Number(dataAtual.getMonth()).valueOf();"
               + "var anoAtual = new Number(dataAtual.getYear()).valueOf();"
               + "var diaCampoData = new Number(campoData.substring(0, 2));"
               + "var mesCampoData = new Number(campoData.substring(3, 5));"
               + "var anoCampoData = new Number(campoData.substring(6, 10));"
               + "if ((diaAtual == diaCampoData) && ((mesAtual + 1) == mesCampoData) && (anoAtual == anoCampoData)) {"
               + "return true;"
               + "} else {"
               + "return false;"
               + "}"
               + "}";
    }

    /**
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
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
