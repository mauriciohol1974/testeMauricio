package br.com.politec.sao.jsp.controlTags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização do corpo principal de um documento, sendo responsável
 * pela renderização de scripts gerais da página, assim como corpos de código
 * HTML de alto nível (ie: <i>Body</i> )
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Document extends TagSupport {
    /**
     * Variável que armazena uma Fábrica de Scripts.
     */
    private ScriptGenerator scriptFactory;

    /**
     * Construtor default.
     */
    public Document() {
    }

    /**
     * Método doStartTag. Renderiza a porção inicial do corpo da tag.
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
     * Método doEndTag. Renderiza a porção final do corpo da tag.
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
     * Método getScriptGenerator. Retorna a instância de
     * <code>ScriptGenerator</code> apropriada.
     * 
     * @return ScriptGenerator
     */
    public ScriptGenerator getScriptGenerator() {
        return this.scriptFactory;
    }
}