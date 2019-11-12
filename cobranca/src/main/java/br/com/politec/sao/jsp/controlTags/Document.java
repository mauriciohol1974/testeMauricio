package br.com.politec.sao.jsp.controlTags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o do corpo principal de um documento, sendo respons�vel
 * pela renderiza��o de scripts gerais da p�gina, assim como corpos de c�digo
 * HTML de alto n�vel (ie: <i>Body</i> )
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Document extends TagSupport {
    /**
     * Vari�vel que armazena uma F�brica de Scripts.
     */
    private ScriptGenerator scriptFactory;

    /**
     * Construtor default.
     */
    public Document() {
    }

    /**
     * M�todo doStartTag. Renderiza a por��o inicial do corpo da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            this.scriptFactory = new ScriptGenerator(this.pageContext);
            // GMG: retirada funcao de teclaenter
            // this.pageContext.getOut().println(
            // "<BODY onKeyPress='validaEnter(window.event.keyCode);'
            // TOPMARGIN='0' LEFTMARGIN='0' MARGINHEIGHT='0' MARGINWIDTH='0'
            // onload='inicia();'>");
            this.pageContext.getOut()
                    .println("<BODY TOPMARGIN='0' LEFTMARGIN='0' MARGINHEIGHT='0' MARGINWIDTH='0' onload='inicia();'>");
            this.scriptFactory.addScript("TeclaEnter", "");
        } catch (IOException exc) {
            LogUtilSigcb.error("Document: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag Document.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo doEndTag. Renderiza a por��o final do corpo da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        try {
            this.pageContext.getOut().println("</BODY>");
            scriptFactory.printScripts();
        } catch (Exception ex) {
            LogUtilSigcb.error("Document: Erro na contrucao da Tag: "
                               + ex.getMessage(), ex);
            throw new Error("Erro na contrucao da Tag Document.");
        }
        return SKIP_BODY;
    }

    /**
     * M�todo getScriptGenerator. Retorna a inst�ncia de
     * <code>ScriptGenerator</code> apropriada.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        return this.scriptFactory;
    }
}