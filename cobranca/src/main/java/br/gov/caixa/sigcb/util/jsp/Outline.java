package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.com.politec.sao.jsp.controlTags.Document;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização de recurso de outline.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class Outline extends TagSupport {
    /**
     * Variável que armazena o nome do Outline.
     */
    private String name = "";

    /**
     * Variável que armazena o titulo do Outline.
     */
    private String title = "";

    /**
     * Variável que armazena o subtitulo do Outline.
     */
    private String subTitle = "";

    /**
     * Variável que armazena o caminho para imagens do Outline.
     */
    private String imagePath = "";

    /**
     * Variável que armazena o tipo do Outline. pode ser outline ou twist
     */
    private String type = "outline";

    /**
     * Variavel que armazena o style css do titulo do Outline.
     */
    private String classTitle = "textoTitulo";

    /**
     * Variavel que armazena o style css do subtitulo do Outline.
     */
    private String classSubTitle = "textoValor";

    /**
     * Variavel identifica o outline como habilitado ou desabilitado.
     */
    private String disabled = "false";

    /**
     * Construtor default.
     */
    public Outline() {
    }

    /**
     * Método doStartTag. Renderiza a porção de código inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            setTitle(getTitle().equals("") ? getName() : getTitle());

            int colspanTd1 = getSubTitle().equals("") ? 3 : 1;
            int colspanTd2 = getSubTitle().equals("") ? 1 : 3;

            StringBuffer outline = new StringBuffer();

            String jsOnClick = "javascript:void(0);";
            if (getDisabled().equals("false")) {
                jsOnClick = "javascript:switchJust(\"" + getName() + "\");";
                if (getType().equals("twist")) {
                    jsOnClick = "olType=\"twist\";switchIt(\""
                                + getName()
                                + "\");olType=\"outline\";";
                }
            }

            outline.append("<tr>\n");
            outline.append("  <td colspan='"
                           + colspanTd1
                           + "' class='"
                           + getClassTitle()
                           + "'>\n");
            outline.append("    <a href='#"
                           + getName()
                           + "Parent' onclick='"
                           + jsOnClick
                           + "'>");
            outline.append("<img src='"
                           + getImagePath()
                           + "/outlineplus.gif' width='11' height='11' name='"
                           + getType()
                           + "' id='"
                           + getName()
                           + "i'>");
            outline.append("</a>\n");
            outline.append("    <a name='"
                           + getName()
                           + "Parent'>"
                           + getTitle()
                           + "</a>\n");
            outline.append("  </td>\n");
            outline.append("  <td colspan='"
                           + colspanTd2
                           + "' class='"
                           + getClassSubTitle()
                           + "'>\n");
            outline.append("    " + getSubTitle() + "&nbsp; \n");
            outline.append("  </td>\n");
            outline.append("</tr>\n");
            outline.append("<tr>\n");
            outline.append("  <td colspan='4'>\n");
            outline.append("    <div id='"
                           + getName()
                           + "Child' style='display:none;background-color: #E9F2F9;border: 1px solid #005baa;'>\n");
            this.pageContext.getOut().println(outline.toString());

            getScriptGenerator().addScript("ExecutarOutline",
                    getType() + ";" + getImagePath());
        } catch (Exception exc) {
            LogUtilSigcb.error("Falha na Tag Outline ", exc);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método doEndTag. Renderiza a porção de código final da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     * @throws JspException
     */
    public int doEndTag() throws JspException {
        try {
            StringBuffer outline = new StringBuffer();
            outline.append("    </div>");
            outline.append("  </td>");
            outline.append("</tr>");
            this.pageContext.getOut().println(outline.toString());
        } catch (Exception exc) {
            LogUtilSigcb.error("Outline: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new JspException(exc.getMessage());
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
        return getTagDocument(this).getScriptGenerator();
    }

    /**
     * Método auxiliar de getScriptGenerator para obter uma instancia da do tipo
     * 
     * @see br.com.politec.sao.jsp.controlTags.Document
     * @return Document
     */
    private Document getTagDocument(Tag tag) {
        Tag parent = (Tag) tag.getParent();
        if (!(parent instanceof Document))
            parent = getTagDocument(parent);
        return (Document) parent;
    }

    /**
     * Método getName. Retorna o nome do Outline sendo renderizado.
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método setName. Define o nome do Outline sendo renderizado.
     * 
     * @param name -
     *            Nome do Form HTML.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param string
     */
    public void setImagePath(String string) {
        imagePath = string;
    }

    /**
     * @param string
     */
    public void setTitle(String string) {
        title = string;
    }

    /**
     * @param string
     */
    public void setType(String string) {
        if (!string.equals("outline"))
            if (!string.equals("twist")) {
                LogUtilSigcb.warn("Tag Outline Atributo type deve ser = 'outline' ou 'twist'. Assumindo outline.");
                string = "outline";
            }
        type = string;
    }

    /**
     * @return classSubTitle
     */
    public String getClassSubTitle() {
        return classSubTitle;
    }

    /**
     * @return classTitle
     */
    public String getClassTitle() {
        return classTitle;
    }

    /**
     * @param string
     */
    public void setClassSubTitle(String string) {
        classSubTitle = string;
    }

    /**
     * @param string
     */
    public void setClassTitle(String string) {
        classTitle = string;
    }

    /**
     * @return subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param string
     */
    public void setSubTitle(String string) {
        subTitle = string;
    }

    /**
     * @return disabled
     */
    public String getDisabled() {
        return disabled;
    }

    /**
     * @param string
     */
    public void setDisabled(String string) {
        disabled = string;
    }

}