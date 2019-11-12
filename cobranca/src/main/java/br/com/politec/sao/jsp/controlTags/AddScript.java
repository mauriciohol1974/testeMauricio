package br.com.politec.sao.jsp.controlTags;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de códigos javascript necessários para a página,
 * trabalhando em conjunto com outras tags.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class AddScript extends TagSupport {
    /**
     * Variável que armazena o nome do script a ser renderizado.
     */
    private String scriptName;

    /**
     * Método getScriptGenerator. Retorna a instância de
     * <code>ScriptGenerator</code> apropriada.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        return ((Document) this.getParent()).getScriptGenerator();
    }

    /**
     * Método doStartTag. Renderiza a porção inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            this.getScriptGenerator().addScript(scriptName, "");
        } catch (Exception exc) {
            LogUtilSigcb.error("Falha na adicão do script " + scriptName, exc);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método getScriptName. Retorna o nome do script sendo renderizado.
     * 
     * @return String - Nome do script.
     */
    public String getScriptName() {
        return scriptName;
    }

    /**
     * Método setScriptName. Define o nome do script a ser renderizado pela tag.
     * 
     * @param scriptName -
     *            Nome do script.
     */
    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }
}