package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * TagLib que valida o CNPJ através do cálculo do número do DV
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>03/07/2003</DD>
 * </DL>
 * 
 * @author Maria Stela Cobra - mscobra@sao.politec.com.br
 */

public class ValidaDVCNPJ extends Script {
    private String controlName;

    /**
     * Atribui à instância o nome de seu controle.
     * 
     * @param String
     */

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    /**
     * Retorna o código do script após a validação do CNPJ, calculando o número
     * do DV a partir dos 12 primeiros dígitos do número informado e verificando
     * se o DV calculado confere com o DV informado.
     * 
     * @return String
     */

    public String getScript() {
        return "function validaDVCNPJ(obj) {"
               + "\t	if(obj.value!=''){\n"
               + "\t\t		while(obj.value.length<14){\n"
               + "\t\t\t			obj.value = '0'+obj.value;\n"
               + "\t\t		}\n"
               + "\t	}else{\n"
               + "\t\t		return false;\n"
               + "\t	}\n"
               + "\tvalor = obj.value;\n"
               + "\tif (valor.length != 14 && valor.length != 18) {\n"
               + "\t\ttry {\n"
               + "\t\t\tobj.focus();\n"
               + "\t\t}catch(erro){};\n"
               + "\t\treturn false;\n"
               + "\t}\n"
               + "\tCNPJ = '';\n"
               + "\tfor (i = 0; i < (valor.length); i++) {\n"
               + "\t\tif (valor.charAt(i) != '.' && valor.charAt(i) != '-' && valor.charAt(i) != '/') {\n"
               + "\t\t\tCNPJ += valor.charAt(i);\n"
               + "\t\t}\n"
               + "\t}\n\n"
               + "\tif ((CNPJ.length != 14) || (CNPJ == '00000000000000') || (CNPJ == '11111111111111')\n"
               + "\t\t			|| (CNPJ == '22222222222222') || (CNPJ == '33333333333333')\n"
               + "\t\t			|| (CNPJ == '44444444444444') || (CNPJ == '55555555555555')\n"
               + "\t\t			|| (CNPJ == '66666666666666') || (CNPJ == '77777777777777')\n"
               + "\t\t			|| (CNPJ == '88888888888888') || (CNPJ == '99999999999999')) {\n"
               + "\t\t\t		obj.focus();\n"
               + "\t\t\t		return false;\n"
               + "\t}\n\n"
               + "\t	multiplicador1 = '543298765432';\n"
               + "\t	multiplicador2 = '654329876543';\n"
               + "\t	soma = 0;\n"
               + "\t	for (i = 0; i < 12; i ++) {\n"
               + "\t\t		soma += parseInt(CNPJ.charAt(i)) * multiplicador1.charAt(i);\n"
               + "\t	}\n\n"
               + "\t	digito1 = ((soma * 10) % 11);\n"
               + "\t	if (digito1 == 10) {\n"
               + "\t\t		digito1 = 0;\n"
               + "\t	}\n"
               + "\t	if (digito1 != parseInt(CNPJ.charAt(12))) {\n"
               + "\t\t		obj.focus();\n"
               + "\t\t		return false;\n"
               + "\t	}\n"
               + "\t	soma = 0;\n"
               + "\t	for (i = 0; i < 12; i ++) {\n"
               + "\t\t		soma += parseInt(CNPJ.charAt(i)) * multiplicador2.charAt(i);\n"
               + "\t	}\n"
               + "\t	soma = soma + (2 * digito1);\n"
               + "\t	digito2 = ((soma * 10) % 11);\n"
               + "\t	if (digito2 == 10) {\n"
               + "\t\t		digito2 = 0;\n"
               + "\t	}\n\n"
               + "\t	if (digito2 != parseInt(CNPJ.charAt(13))) {\n"
               + "\t\t		obj.focus();\n"
               + "\t\t		return false;\n"
               + "\t	}\n"
               + "\t	return true;\n"
               + "}\n";
    }

    /**
     * Retorna o código a ser renderizado para o evento HTML <i>onKeyPress</i>.
     * 
     * @return String
     * @param String
     * @param String
     */

    public String getOnKeyPress() {
        return "";
    }

    /**
     * Retorna o código a ser renderizado para o evento HTML <i>onBlur</i>.
     * 
     * @return String
     * @param String
     * @param String
     */

    public String getOnBlur() {
        return "";
    }

    /**
     * Retorna o código a ser renderizado para o evento HTML <i>onFocus</i>.
     * 
     * @return String
     * @param String
     * @param String
     */

    public String getOnFocus() {
        return "";
    }
}