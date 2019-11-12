package br.com.politec.sao.jsp.controlTags;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de forms integrados �s tags de entradas de dados que
 * estar�o inclusas no mesmo.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Form extends TagSupport {
    /**
     * Vari�vel que armazena o nome do Form HTML.
     */
    private String name;

    /**
     * Vari�vel que armazena o atributo Action do Form HTML.
     */
    private String action;

    /**
     * Vari�vel que armazena o atributo Method do Form HTML.
     */
    private String method;

    /**
     * Construtor default.
     */
    public Form() {
    }

    /**
     * M�todo doStartTag. Renderiza a por��o de c�digo inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
        	this.pageContext.getOut().println("<FORM NAME='"
                    + getName()
                    + "' ACTION='"
                    + getAction()
                    + "' METHOD='POST'>");
        	/*
        	if (getName().equalsIgnoreCase("/cobranca/SigcbLogin") || getName().contains("SigcbLogin")){
        		this.pageContext.getOut().println("<FORM NAME='"
                        + getName()
                        + "' ACTION='"
                        + getAction()
                        + "' METHOD='POST'>");

        		
        	}else{
        		this.pageContext.getOut().println("<FORM NAME='"
                        + getName()
                        + "' ACTION='"
                        + getAction()
                        + "' METHOD='POST"
                        // + getMethod()
                        + "' ONSUBMIT='"
                        + "return validaDuploSubmit()"
                        + "'>");
                        
             
getScriptGenerator().addScript("ValidaDuploSubmit", "");
        	}
        	*/
            
        } catch (Exception exc) {
            LogUtilSigcb.error("Falha na Tag Form ", exc);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo doEndTag. Renderiza a por��o de c�digo final da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        try {
            this.pageContext.getOut().println("</FORM>");
        } catch (Exception exc) {
            LogUtilSigcb.error("Form: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag Form.");
        }
        return SKIP_BODY;
    }

    /**
     * M�todo getName. Retorna o nome do form HTML sendo renderizado.
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * M�todo getAction. Retorna o atributo <i>action</i> do form HTML sendo
     * renderizado.
     * 
     * @return String
     */
    public String getAction() {
        return this.action;
    }

    /**
     * M�todo getMethod. Retorna o m�todo de envio de dados.
     * 
     * @return String
     */
    public String getMethod() {
        return this.method;
    }

    /**
     * M�todo setName. Define o nome do form HTML sendo renderizado.
     * 
     * @param name -
     *            Nome do Form HTML.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * M�todo setAction. Define o atributo <i>action</i> do form HTML sendo
     * renderizado.
     * 
     * @param action -
     *            Action do Form HTML.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * M�todo setMethod. Define o m�todo de envio de dados.
     * 
     * @param method -
     *            Method do Form HTML.
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * M�todo getScriptGenerator. Retorna a inst�ncia de
     * <code>ScriptGenerator</code> apropriada.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        Document document = (Document) this.getParent();
        return document.getScriptGenerator();
    }
}