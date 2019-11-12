package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de renderiza��o do c�digo javascript de valida��o se um n�mero � maior
 * que zero.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValorMaiorZero extends Script {
    /**
     * M�todo getScript. Retorna um script de renderiza��o do c�digo javascript
     * de valida��o se um n�mero � maior que zero.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o ValorMaiorZero.
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
