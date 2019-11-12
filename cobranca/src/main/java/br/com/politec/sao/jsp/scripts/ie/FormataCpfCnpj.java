package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script respons�vel por colocar e retirar a m�scara
 * de formata��o de um CPF ou CNPJ.
 * 
 * @author Eduardo A. Moras - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class FormataCpfCnpj extends Script {
    /**
     * M�todo getScript. Retorna um script respons�vel por colocar e retirar a
     * m�scara de formata��o de um CPF/CNPJ.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Scripts das fun��es validaEmail.
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
