package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de renderização do código javascript de validação se um número é maior
 * que zero.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValorMaiorZero extends Script {
    /**
     * Método getScript. Retorna um script de renderização do código javascript
     * de validação se um número é maior que zero.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função ValorMaiorZero.
     */
    public String getScript() {
        return "function ValorMaiorZero(obj){"
               + "numerosInteiros = '1234567890';"
               + "primeiroNumero = '';"
               + "for(i=0; i<obj.value.length; i++) {"
               + "	if (numerosInteiros.indexOf(obj.value.charAt(i)) >= 0) {"
               + "        		primeiroNumero = primeiroNumero + obj.value.charAt(i);"
               + "       }"
               + "    }"
               + "primeiroNumero = new Number(primeiroNumero);"
               + "primeiroNumero = primeiroNumero.valueOf();"
               + "if (primeiroNumero > 0) {"
               + "	return true;"
               + "} else {"
               + "	return false;"
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
