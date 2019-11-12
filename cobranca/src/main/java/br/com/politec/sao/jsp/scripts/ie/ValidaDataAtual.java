package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida o campo Data passado por
 * parâmetro com a Data atual do Sistema.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDataAtual extends Script {
    /**
     * Método getScript. Retorna um script que valida o campo Data passado por
     * parâmetro com a Data atual do Sistema.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaDataAtual.
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
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
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
