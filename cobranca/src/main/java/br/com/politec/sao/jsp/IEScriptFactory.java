package br.com.politec.sao.jsp;

import br.com.politec.sao.jsp.scripts.Script;
import br.com.politec.sao.util.ClassMap;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de implementa��o respons�vel pela localiza��o e instanciamento atrav�s
 * de um <code>ClassLoader</code> especializado da framework, das classes
 * respons�veis pela composi��o de Javascripts para o browser Internet Explorer,
 * e para as diferentes tags dispon�veis.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class IEScriptFactory extends ScriptFactory {
    /**
     * Armazena o script a ser renderizado.
     */
    private Script script;

    /**
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @see br.com.politec.sao.jsp.ScriptFactory#getOnKeyPress(java.lang.String,
     *      java.lang.String)
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getOnKeyPress(String functionName, String controlName) {
        this.getClassScript(functionName, controlName);
        return this.script.getOnKeyPress();
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @see br.com.politec.sao.jsp.ScriptFactory#getOnBlur(java.lang.String,
     *      java.lang.String)
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getOnBlur(String functionName, String controlName) {
        this.getClassScript(functionName, controlName);
        return this.script.getOnBlur();
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @see br.com.politec.sao.jsp.ScriptFactory#getOnFocus(java.lang.String,
     *      java.lang.String)
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getOnFocus(String functionName, String controlName) {
        this.getClassScript(functionName, controlName);
        return this.script.getOnFocus();
    }

    /**
     * M�todo getClassScript. Carrega a classe de controle de scripts
     * apropriada.
     * 
     * @param functionName
     * @param controlName
     */
    private void getClassScript(String functionName, String controlName) {
        try {
            ClassMap classLoader = new ClassMap();
            this.script = (Script) classLoader.newInstance("br.com.politec.sao.jsp.scripts.ie."
                                                           + functionName);
            script.setControlName(controlName);
        } catch (Exception exc) {
            LogUtilSigcb.error("IEScriptFactory - Erro ao carregar a classe referente ao script ",
                    exc);
        }
    }

    /**
     * M�todo getScript. Retorna o c�digo a ser renderizado.
     * 
     * @see br.com.politec.sao.jsp.ScriptFactory#getScript(java.lang.String,
     *      java.lang.String)
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getScript(String functionName, String controlName) {
        this.getClassScript(functionName, controlName);
        return this.script.getScript();
    }
}