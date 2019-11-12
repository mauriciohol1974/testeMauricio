package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.com.politec.sao.jsp.controlTags.Document;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Paths;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Head extra exclusivas para janelas Popup. inclui css,
 * scripts comuns e menu.
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 * @version release 1.2
 */
public class HeaderPopup extends TagSupport {
    /**
     * Construtor default.
     */
    public HeaderPopup() {
    }

    /**
     * Método doStartTag. Renderiza a porção de código inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            StringBuffer head = new StringBuffer();
            head.append("<head>\n");
            head.append("<title>SIGCB - Sistema Gest&atilde;o de Cobran&ccedil;a Banc&aacute;ria - Pop up</title>\n");
            head.append("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'>\n");
            head.append("<link rel='stylesheet' type='text/css' href='"
                        + Paths.getRootForStaticContent()
                        + "/css/main.css'>\n");
            head.append("<script language='javascript' type='text/javascript' src='"
                        + Paths.getRootForStaticContent()
                        + "/js/foco.js'></script>\n");
            head.append("<script language='javascript' type='text/javascript' src='"
                        + Paths.getRootForStaticContent()
                        + "/js/valida.js'></script>\n");
            head.append("<script language='javascript' type='text/javascript' src='"
                        + Paths.getRootForStaticContent()
                        + "/js/mensagem.js'></script>\n");
            head.append("<script language='javascript' type='text/javascript' src='"
                        + Paths.getRootForStaticContent()
                        + "/js/funcoes.js'></script>\n");
            this.pageContext.getOut().println(head.toString());
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("HeaderPopUp doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("HeaderPopUp doStartTag() Exception capturada:"
                               + e.toString(), e);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método doEndTag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        try {
            this.pageContext.getOut().println("</head>");
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("HeaderPopUp doEndTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("HeaderPopUp doEndTag() Exception capturada:"
                               + e.toString(), e);
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
        Document document = (Document) this.getParent();
        return document.getScriptGenerator();
    }
}