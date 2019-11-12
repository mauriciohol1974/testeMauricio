package br.com.politec.sao.jsp.controlTags;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de forms integrados às tags de entradas de dados que
 * estarão inclusas no mesmo.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Form extends TagSupport {
    /**
     * Variável que armazena o nome do Form HTML.
     */
    private String name;

    /**
     * Variável que armazena o atributo Action do Form HTML.
     */
    private String action;

    /**
     * Variável que armazena o atributo Method do Form HTML.
     */
    private String method;

    /**
     * Construtor default.
     */
    public Form() {
    }

    /**
     * Método doStartTag. Renderiza a porção de código inicial da tag.
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
     * Método doEndTag. Renderiza a porção de código final da tag.
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
     * Método getName. Retorna o nome do form HTML sendo renderizado.
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método getAction. Retorna o atributo <i>action</i> do form HTML sendo
     * renderizado.
     * 
     * @return String
     */
    public String getAction() {
        return this.action;
    }

    /**
     * Método getMethod. Retorna o método de envio de dados.
     * 
     * @return String
     */
    public String getMethod() {
        return this.method;
    }

    /**
     * Método setName. Define o nome do form HTML sendo renderizado.
     * 
     * @param name -
     *            Nome do Form HTML.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método setAction. Define o atributo <i>action</i> do form HTML sendo
     * renderizado.
     * 
     * @param action -
     *            Action do Form HTML.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Método setMethod. Define o método de envio de dados.
     * 
     * @param method -
     *            Method do Form HTML.
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Método getScriptGenerator. Retorna a instância de
     * <code>ScriptGenerator</code> apropriada.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        Document document = (Document) this.getParent();
        return document.getScriptGenerator();
    }
}