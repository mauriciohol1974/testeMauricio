package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o script de compara��o de dois n�meros para browsers Internet
 * Explorer.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ComparaNumero extends Script {
    /**
     * M�todo getScript. Retorna um script de compara��o de dois n�meros, sendo
     * que o primeiro n�mero n�o pode ser maior que o segundo.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o comparaNumero.
     */
    public String getScript() {
        return "function comparaNumero(obj1, obj2) {"
               + "numerosInteiros = '1234567890';"
               + "primeiroNumero = '';"
               + "segundoNumero = '';"
               + "for(i=0; i<obj1.value.length; i++) {"
               + "	if (numerosInteiros.indexOf(obj1.value.charAt(i)) >= 0) {"
               + "        		primeiroNumero = primeiroNumero + obj1.value.charAt(i);"
               + "       }"
               + "    }"
               + "for(i=0; i<obj2.value.length; i++) {"
               + "	if (numerosInteiros.indexOf(obj2.value.charAt(i)) >= 0) {"
               + "        		segundoNumero = segundoNumero + obj2.value.charAt(i);"
               + "        }"
               + "    }"
               + "primeiroNumero = new Number(primeiroNumero);"
               + "segundoNumero = new Number(segundoNumero);"
               + "primeiroNumero = primeiroNumero.valueOf();"
               + "segundoNumero = segundoNumero.valueOf();"
               + "if (primeiroNumero > segundoNumero) {"
               + "	return false;"
               + "} else {"
               + "	return true;"
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
