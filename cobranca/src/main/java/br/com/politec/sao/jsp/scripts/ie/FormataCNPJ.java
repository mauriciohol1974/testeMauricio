package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script respons�vel por colocar e retirar a m�scara
 * de formata��o de um CNPJ.
 * 
 * @author M.F.Luchesi - mluchesi@sao.politec.com.br
 * @version release 1.3
 */

public class FormataCNPJ extends Script {
    private String controlName;

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
     * M�todo getScript. Retorna um script respons�vel por colocar e retirar a
     * m�scara de formata��o de um CNPJ.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script das fun��es
     */

    public String getScript() {
        return "function formataCNPJ(obj) {\n"
               + "\t	var result ='';\n"
               + "\t	fillCNPJWithZeros(obj);\n"
               + "\t	for(i=obj.value.length, x=0; i>=0; i--, x++) {\n"
               + "\t\t    result = obj.value.charAt(i) + result;\n"
               + "\t\t    if(x==2) {\n"
               + "\t\t\t       result = '-' + result;\n"
               + "\t\t		}else if (x==6) {\n"
               + "\t\t\t   	result = '/' + result;\n"
               + "\t\t		}else if ((x==9)||(x==12)) {\n"
               + "\t\t\t    	result = '.' + result;\n"
               + "\t\t		}\n"
               + "\t}\n"
               + "\t	obj.value = result;\n"
               + "}\n\n"
               + "function unFormataCNPJ(obj) {\n"
               + "\t	var result = '';\n"
               + "\t	for(i=0; i<obj.value.length; i++) {\n"
               + "\t\t		if((obj.value.charAt(i)!='.')&&(obj.value.charAt(i)!='-')&&(obj.value.charAt(i)!='/')) {\n"
               + "\t\t\t			result = result + obj.value.charAt(i);\n"
               + "\t\t		}\n"
               + "\t	}\n"
               + "\t	obj.value = result;\n"
               + "\t	fillCNPJWithZeros(obj);\n"
               + "}\n"
               + "\n"
               + "function fillCNPJWithZeros(obj) {\n"
               + "\t	if(obj.value!=''){\n"
               + "\t\t		while(obj.value.length<14){\n"
               + "\t\t\t			obj.value = '0'+obj.value;\n"
               + "\t\t		}\n"
               + "\t	}\n"
               + "}\n";

    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - Chamada da fun��o formataCNPJ.
     */
    public String getOnBlur() {
        return "formataCNPJ(this)";
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - Chamada da fun��o unFormataCNPJ.
     */
    public String getOnFocus() {
        return "unFormataCNPJ(this)";
    }
}
