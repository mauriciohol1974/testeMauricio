package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Valida entrada de duplo submit (clickar varias vezes no botao de submit) para
 * Browsers Internet Explorer.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class ValidaDuploSubmit extends Script {
    /**
     * Método getScript. Retorna um script que renderiza o javascript para
     * captura da tecla <i>Enter</i> para Browsers Internet Explorer.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaEnter.
     */
 
    public String getScript() {
        return "var jaClicou = false;\n"
               + "var submeter = document.frmMain.submit;\n"
               + "document.frmMain.submit = validaDuploSubmit;\n"
               + "function validaDuploSubmit() {\n"
               + "  if (jaClicou) { \n"
               + "    alert('Aguarde... sua requisição já está sendo processada.'); \n"
               + "    setTimeout('jaClicou=false',1000*10);\n" // 10 segundos
                                                                // para timeout
               + "    return false; \n"
               + "  } else {\n"
               + "    jaClicou = true; \n"
               + "    submeter();\n"
               + "  } \n"
               + "}\n";
    }
    
    
    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
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
