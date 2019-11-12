package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida a integridade dos números de um
 * CPF.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ValidaDVCPF extends Script {
    /**
     * Variável que armazena o nome do controle.
     */
    private String controlName;

    /**
     * Método setControlName. Atribui à instância o nome de seu controle.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    /**
     * Método getScript. Retorna um script que valida a integridade dos números
     * de um CPF.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaDVCPF.
     */
    public String getScript() {
        return "function validaDVCPF(obj) {"
               + " 	valor = obj.value;"
               + "	if (valor.length != 14) {"
               + "     try {"
               + "		  obj.focus();"
               + "     }catch(erro) {};"
               + "		return false;"
               + "	}"
               + "	CPF = '';"
               + "	for (i = 0; i < (valor.length); i++) {"
               + "		if (valor.charAt(i) != '.' && valor.charAt(i) != '-') {"
               + "			CPF += valor.charAt(i);"
               + "		}"
               + "	}"
               + "	if ((CPF.length != 11) || (CPF == '00000000000') || (CPF == '11111111111')"
               + "			|| (CPF == '22222222222') || (CPF == '33333333333')"
               + "			|| (CPF == '44444444444') || (CPF == '55555555555')"
               + "			|| (CPF == '66666666666') || (CPF == '77777777777')"
               + "			|| (CPF == '88888888888') || (CPF == '99999999999')) {"
               + "     try {"
               + "		  obj.focus();"
               + "     }catch(erro) {};"
               + "		return false;"
               + "	}"
               + "	soma = 0;"
               + "	for (i = 0; i < 9; i ++) {"
               + "		soma += parseInt(CPF.charAt(i)) * (10 - i);"
               + "	}"
               + "	resto = 11 - (soma % 11);"
               + "	if ((resto == 10) || (resto == 11)) {"
               + "		resto = 0;"
               + "	}"
               + "	if (resto != parseInt(CPF.charAt(9))) {"
               + "     try {"
               + "		  obj.focus();"
               + "     }catch(erro) {};"
               + "		return false;"
               + "	}"
               + "	soma = 0;"
               + "	for (i = 0; i < 10; i ++) {"
               + "		soma += parseInt(CPF.charAt(i)) * (11 - i);"
               + "	}"
               + "	resto = 11 - (soma % 11);"
               + "	if ((resto == 10) || (resto == 11)) {"
               + "		resto = 0;"
               + "	}"
               + "	if (resto != parseInt(CPF.charAt(10))) {"
               + "     try {"
               + "		  obj.focus();"
               + "     }catch(erro) {};"
               + "		return false;"
               + "	}"
               + "	return true;"
               + "	}";
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String
     */
    public String getOnKeyPress() {
        return "";
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String
     */
    public String getOnBlur() {
        return "";
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String
     */
    public String getOnFocus() {
        return "";
    }
}