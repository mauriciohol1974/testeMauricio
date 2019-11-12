package br.com.politec.sao.jsp.simpleTags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag Lib que mant�m o c�digo html com os includes da p�gina.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Includes extends TagSupport {
    /**
     * Base Root dos includes relativos ao menu e a folha de estilos.
     */
    private String baseRoot = "";

    /**
     * Nome do projeto para compor o nome do include Java Script.
     */
    private String applicationName = "";

    /**
     * M�todo doStartTag. Imprime o html correspondente aos includes na p�gina.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return Controle para o web container.
     */
    public int doStartTag() {
        try {
            this.pageContext.getOut().println(getHtml());
        } catch (IOException exc) {
            LogUtilSigcb.error("Includes: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag Includes.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getHtml. Gera o html a ser impresso pela tag.
     * 
     * @return String com o c�digo relativo ao includes .js e .css
     */
    private String getHtml() {
        StringBuffer result = new StringBuffer();
        result.append("<LINK REL='STYLESHEET' HREF='"
                      + getBaseRoot()
                      + "/folhaEstilo/estilo.css'>");
        result.append("<script language='JavaScript' src='"
                      + getBaseRoot()
                      + "/javaScript/menu"
                      + getApplicationName()
                      + ".js'></script>");
        return result.toString();
    }

    /**
     * M�todo getBaseRoot. Retorna a base root dos includes relativos ao menu e
     * a folha de estilos.
     * 
     * @return String
     */
    public String getBaseRoot() {
        return baseRoot;
    }

    /**
     * M�todo getApplicationName. Retorna o nome do projeto para compor o nome
     * do include Java Script.
     * 
     * @return String
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * M�todo setBaseRoot. Define a base root dos includes relativos ao menu e a
     * folha de estilos.
     * 
     * @param baseRoot
     */
    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }

    /**
     * M�todo setApplicationName. Define o nome do projeto para compor o nome do
     * include Java Script.
     * 
     * @param projectName
     */
    public void setApplicationName(String projectName) {
        this.applicationName = projectName;
    }
}