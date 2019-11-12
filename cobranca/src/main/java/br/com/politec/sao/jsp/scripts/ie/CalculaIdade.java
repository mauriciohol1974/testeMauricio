package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe tem por objetivo implementar para as tags um script respons�vel
 * por calcular a idade atual a partir do objeto passado por par�metro com a
 * data atual do sistema.
 * 
 * @author Samuel Dantas - smendonca@sao.politec.com.br
 * @version release 1.3
 */
public class CalculaIdade extends Script {
    /**
     * M�todo getScript. Retorna um script que calcula a idade atrav�s do
     * par�metro objeto tipo date com a data atual do sistema.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o calculaIdade.
     */
    public String getScript() {
        return "function calculaIdade(data1)	{"
               + "	sDatInv1=new Date(data1.substring(6,10),data1.substring(3,5)-1,data1.substring(0,2));"
               + "	sDatInv2=new Date();"
               + "	nIdade=parseInt((sDatInv2-sDatInv1)/31536000000);"
               + "	return nIdade;"
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
