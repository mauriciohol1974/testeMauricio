package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script que valida a integridade dos n�meros de um
 * CPF ou CNPJ.
 * 
 * @author Eduardo A. Moras - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaDVCpfCnpj extends Script {
    /**
     * Vari�vel que armazena o nome do controle.
     */
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
     * M�todo getScript. Retorna um script que valida a integridade dos n�meros
     * de um CPF/CNPJ.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o validaDVCPF.
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
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String
     */
    public String getOnBlur() {
        return "";
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String
     */
    public String getOnFocus() {
        return "";
    }
}