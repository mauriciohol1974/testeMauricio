package br.com.politec.sao.jsp.controlTags;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de c�digos javascript necess�rios para a p�gina,
 * trabalhando em conjunto com outras tags.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class AddScript extends TagSupport {
    /**
     * Vari�vel que armazena o nome do script a ser renderizado.
     */
    private String scriptName;

    /**
     * M�todo getScriptGenerator. Retorna a inst�ncia de
     * <code>ScriptGenerator</code> apropriada.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        return ((Document) this.getParent()).getScriptGenerator();
    }

    /**
     * M�todo doStartTag. Renderiza a por��o inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            this.getScriptGenerator().addScript(scriptName, "");
        } catch (Exception exc) {
            LogUtilSigcb.error("Falha na adic�o do script " + scriptName, exc);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getScriptName. Retorna o nome do script sendo renderizado.
     * 
     * @return String - Nome do script.
     */
    public String getScriptName() {
        return scriptName;
    }

    /**
     * M�todo setScriptName. Define o nome do script a ser renderizado pela tag.
     * 
     * @param scriptName -
     *            Nome do script.
     */
    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }
}