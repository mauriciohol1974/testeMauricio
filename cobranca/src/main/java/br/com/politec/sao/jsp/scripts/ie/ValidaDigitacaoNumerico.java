package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * Classe responsável pela validação de caracteres digitados em campos que
 * aceitam apenas a entrada de caracteres numéricos e o dígito de separação de
 * inteiro e mantissa.
 */
public class ValidaDigitacaoNumerico extends Script {
    private String controlName;

    /**
     * @see br.com.politec.sao.jsp.scripts.Script
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    /**
     * @see br.com.politec.sao.jsp.scripts.Script
     */
    public String getScript() {
        return "function cancelaAcao(evento){\n"
               + "if (evento.ctrlKey && (evento.keyCode == 86)){\n"
               + "   return false;\n"
               + "}\n"
               + "return true;\n"
               + "}\n"
               + "\tfunction validaDigitacaoNumerico(valor){\n"
               + "\t\t        numeros = '1234567890,';\n"
               + "\t\t        charCode = valor.charCodeAt(0);\n"
               + "\t\t        if ((numeros.indexOf(valor) >= 0) || (charCode < 32)) {\n"
               + "\t\t\t            return true;\n"
               + "\t\t        } else {\n"
               + "\t\t\t         return false;\n"
               + "\t\t        }\n"
               + "\t    }\n\n"

               + "\n\t    function formataValorDouble(obj , tamanho , precisao){"
               + "\n\t\t		var nonZero = false;"
               + "\n\t\t		var hasDecimalPart = false;"
               + "\n\t\t		var decimalSize = 0;"
               + "\n\t\t		if(obj.value==''){"
               + "\n\t\t		}"
               + "\n\t\t		var result = '';"
               + "\n\t\t		for(i=0;i<obj.value.length;i++){"
               + "\n\t\t\t			if(obj.value.charAt(i)=='0'){"
               + "\n\t\t\t\t				if(nonZero){"
               + "\n\t\t\t\t\t				if(!hasDecimalPart && (result.length<(tamanho-(precisao+1)))){"
               + "\n\t\t\t\t\t\t					result = result + obj.value.charAt(i);"
               + "\n\t\t\t\t\t				}else if(hasDecimalPart && (decimalSize < precisao)){"
               + "\n\t\t\t\t\t\t					result = result + obj.value.charAt(i);"
               + "\n\t\t\t\t\t\t					decimalSize++;"
               + "\n\t\t\t\t\t				}"
               + "\n\t\t\t\t				}"
               + "\n\t\t\t			}else{"
               + "\n\t\t\t\t				nonZero = true;"
               + "\n\t\t\t\t				if(obj.value.charAt(i)==','){"
               + "\n\t\t\t\t\t				if(!hasDecimalPart){"
               + "\n\t\t\t\t\t\t					if(result.length==0)"
               + "\n\t\t\t\t\t\t\t					result = result + '0';"
               + "\n\t\t\t\t\t\t					result = result + ',';"
               + "\n\t\t\t\t\t\t					hasDecimalPart = true;"
               + "\n\t\t\t\t\t				}"
               + "\n\t\t\t\t				}else{"
               + "\n\t\t\t\t\t				if(!hasDecimalPart && (result.length<(tamanho-(precisao+1)))){"
               + "\n\t\t\t\t\t\t					result = result + obj.value.charAt(i);"
               + "\n\t\t\t\t\t				}else if(hasDecimalPart && (decimalSize < precisao)){"
               + "\n\t\t\t\t\t\t					result = result + obj.value.charAt(i);"
               + "\n\t\t\t\t\t\t					decimalSize++;"
               + "\n\t\t\t\t\t				}"
               + "\n\t\t\t\t				}"
               + "\n\t\t\t			}"
               + "\n\t\t		}"
               + "\n\t\t		if(result==''){"
               + "\n\t\t\t		result='0';"
               + "\n\t\t		}"
               + "\n\t\t		if(!hasDecimalPart){"
               + "\n\t\t\t		result = result + ',';"
               + "\n\t\t\t		hasDecimalPart = true;"
               + "\n\t\t		}"
               + "\n\t\t		while(decimalSize<precisao){"
               + "\n\t\t\t			result = result + '0';"
               + "\n\t\t\t			decimalSize++;"
               + "\n\t\t		}"
               + "\n\t\t		obj.value = result;"
               +

               "\n\t    }\n\n";
    }

    /**
     * @see br.com.politec.sao.jsp.scripts.Script
     */
    public String getOnKeyPress() {
        return "";
    }

    /**
     * @see br.com.politec.sao.jsp.scripts.Script
     */
    public String getOnBlur() {
        return "";
    }

    /**
     * @see br.com.politec.sao.jsp.scripts.Script
     */
    public String getOnFocus() {
        return "";
    }
}
