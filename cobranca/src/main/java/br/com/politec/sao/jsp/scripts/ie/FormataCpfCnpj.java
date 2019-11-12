package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script responsável por colocar e retirar a máscara
 * de formatação de um CPF ou CNPJ.
 * 
 * @author Eduardo A. Moras - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class FormataCpfCnpj extends Script {
    /**
     * Método getScript. Retorna um script responsável por colocar e retirar a
     * máscara de formatação de um CPF/CNPJ.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Scripts das funções validaEmail.
     */
    public String getScript() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("function formataCpfCnpj(objDoc,objTipoPessoa){");
        buffer.append("	if(objDoc.value != ''){");
        buffer.append("  	if (objTipoPessoa.value == 1){");
        buffer.append("  		unFormataCPF(objDoc);");
        buffer.append("  		formataCPF(objDoc);");
        buffer.append("  	}");
        buffer.append("		else if (objTipoPessoa.value == 2){");
        buffer.append("			unFormataCNPJ(objDoc);");
        buffer.append("			formataCNPJ(objDoc);");
        buffer.append("		}");
        buffer.append("	}");
        buffer.append("}");
        buffer.append("function unFormataCpfCnpj(objDoc,objTipoPessoa){");
        buffer.append("	if(objDoc.value != ''){");
        buffer.append("  	if (objTipoPessoa.value == 1){");
        buffer.append("  		unFormataCPF(objDoc);");
        buffer.append("  	}");
        buffer.append("		else if (objTipoPessoa.value == 2){");
        buffer.append("			unFormataCNPJ(objDoc);");
        buffer.append("		}");
        buffer.append("	}");
        buffer.append("}");
        buffer.append("");
        buffer.append("function limpaCpfCnpj(objDoc){");
        buffer.append("	objDoc.value = '';");
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
