package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida a integridade dos números de um
 * CPF ou CNPJ.
 * 
 * @author Eduardo A. Moras - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaDVCpfCnpj extends Script {
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
     * de um CPF/CNPJ.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaDVCPF.
     */
    public String getScript() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("function validaDvCpfCnpj(objDoc,objTipoPessoa){");
        buffer.append("  try{");
        buffer.append("		obj = new Object('value');");
        buffer.append("		obj.value= objDoc.value;");
        buffer.append("		unFormataCpfCnpj(obj,objTipoPessoa);");
        buffer.append("	 	formataCpfCnpj(obj,objTipoPessoa);");
        buffer.append("		if(obj.value != ''){");
        buffer.append("    	if (objTipoPessoa.value == 1){");
        buffer.append("    		return validaDVCPF(obj);");
        buffer.append("	  	}");
        buffer.append("			else if (objTipoPessoa.value == 2){");
        buffer.append("				return validaDVCNPJ(obj);");
        buffer.append("			}");
        buffer.append("		}");
        buffer.append("  	objDoc.focus();");
        buffer.append("  }catch(erro){}");
        buffer.append("}");

        return buffer.toString();
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