package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.com.politec.sao.jsp.controlTags.Document;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Paths;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do TituloBean da Pagina.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class Titulo extends TagSupport {
    /**
     * Variável que armazena o titulo da pagina.
     */
    public String name = "";

    /**
     * Construtor default.
     */
    public Titulo() {
    }

    /**
     * Método doStartTag. Renderiza a porção de código inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            StringBuffer titulo = new StringBuffer();
            titulo.append("<table width='777' border='0' cellpadding='0' cellspacing='0'>\n");
            titulo.append("  <tr height='65'>\n");
            titulo.append("    <td valign='bottom' align='center'>\n");
            titulo.append("      <table CELLSPACING='0' CELLPADDING='0' width='98%' border='0' align='center' valign='middle'>\n");
            titulo.append("        <tr>\n");
            titulo.append("          <td valign='top' align='left' style='background-repeat:no-repeat'\n");
            titulo.append("              background='"
                          + Paths.getRootForStaticContent()
                          + "/imagens/diversos/baseTitulo.gif'>\n");
            titulo.append("              <h3>&nbsp;"
                          + this.name
                          + "&nbsp;</h3>\n");
            titulo.append("		  </td>\n");
            titulo.append("        </tr>\n");
            titulo.append("      </table>\n");
            titulo.append("    </td>\n");
            titulo.append("  </tr>\n");
            titulo.append("</table>\n");
            this.pageContext.getOut().println(titulo.toString());
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("Titulo doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("Titulo doStartTag() Exception capturada:"
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

    /**
     * Método getName. Obtem o atributo <i>name</i> do form HTML sendo
     * renderizado.
     * 
     * @return String - titulo do Form HTML
     */
    public String getName() {
        return name;
    }

    /**
     * Método setName. Define o atributo <i>name</i> do form HTML sendo
     * renderizado.
     * 
     * @param name -
     *            titulo do Form HTML.
     */
    public void setName(String string) {
        name = string;
    }
}