package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.com.politec.sao.jsp.controlTags.Form;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Paths;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag Lib utilizada para a criação dos botões de navegação SIGCB
 * 
 * @author Glauber Micheloni Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class ButtonPaginarProtesto extends TagSupport {
    /**
     * Numero da Pagina atual
     */
    private int pageNumber;

    /**
     * Numero total de Paginas
     */
    private int numberOfPages;

    /**
     * Nome da Pagina Atual
     */
    private String pageName;

    /**
     * Numero maximo de ocorrencias de pagina para rolagem de proximo/anterior
     */
    private int maxOccPages = 5;

    /**
     * Variável que armazena uma Fábrica de Scripts.
     */
    private ScriptGenerator scriptFactory;

    /**
     * Método doStartTag. Imprime o código html correspondente aos botões de
     * paginacao.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return Controle para o web container.
     */
    public int doStartTag() {
        try {
            StringBuffer buttons = new StringBuffer();

            if (!this.getPageName()
                    .startsWith(Paths.getRootForDynamicContent()))
                this.setPageName(Paths.getRootForDynamicContent()
                                 + "/"
                                 + this.getPageName());

            // Cascading Style Sheets
            buttons.append(getCSS());

            // Table navegacao
            buttons.append("<table border='0' cellspacing='3' cellpadding='0' align='center' valign='middle'>\n");
            buttons.append("  <tr class='pagina' >\n");

            // Primeira Página
            buttons.append("    <td nowrap>\n");
            if (this.getPageNumber() > 0)
                buttons.append("<a class='pagina' title='Primeira Página' href=\"javascript:executarPaginacaoProtesto('0','"
                               + this.getPageName()
                               + "')\">");
            else
                buttons.append("<div title='Primeira Página'>");
            buttons.append("&lt;&lt;");
            if (this.getPageNumber() > 0)
                buttons.append("</a>");
            buttons.append("&nbsp;&nbsp;");
            if (this.getPageNumber() == 0)
                buttons.append("</div>");
            buttons.append("	</td>\n");

            // Página Anterior
            buttons.append("    <td nowrap>\n");
            if (this.getPageNumber() > 0)
                buttons.append("<a class='pagina' title='Página Anterior' href=\"javascript:executarPaginacaoProtesto('"
                               + (this.getPageNumber() - 1)
                               + "','"
                               + this.getPageName()
                               + "')\">");
            else
                buttons.append("<div title='Página Anterior'>");
            buttons.append("Anterior");
            if (this.getPageNumber() > 0)
                buttons.append("</a>");
            buttons.append("&nbsp;-&nbsp;");
            if (this.getPageNumber() == 0)
                buttons.append("</div>");
            buttons.append("	</td>\n");

            int iniShowPage;
            int endShowPage;
            if (this.getMaxOccPages() >= this.getNumberOfPages()) {
                iniShowPage = 0;
                endShowPage = this.getNumberOfPages();
            } else if (this.getPageNumber() <= 1) {
                iniShowPage = 0;
                endShowPage = this.getMaxOccPages();
            } else if (this.getPageNumber() >= (this.getNumberOfPages() - 2)) {
                iniShowPage = this.getNumberOfPages() - this.getMaxOccPages();
                endShowPage = this.getNumberOfPages();
            } else {
                iniShowPage = this.getPageNumber() - 2;
                endShowPage = this.getPageNumber() + 3;
            }

            // Numeros de Pagina
            for (int i = iniShowPage; i < (endShowPage); i++) {
                buttons.append("<td nowrap>\n");
                if (this.getPageNumber() != i)
                    buttons.append("<a class='pagina' title='Página "
                                   + (i + 1)
                                   + "' href=\"javascript:executarPaginacaoProtesto('"
                                   + (i)
                                   + "','"
                                   + this.getPageName()
                                   + "')\">");
                else
                    buttons.append("<div title='Página " + (i + 1) + "'>");
                buttons.append((i + 1));
                if (this.getPageNumber() != i)
                    buttons.append("</a>");
                buttons.append("&nbsp;-&nbsp;");
                if (this.getPageNumber() == i)
                    buttons.append("</div>");
                buttons.append("</td>\n");
            }

            // Próxima Página
            buttons.append("    <td nowrap>\n");
            if (this.getPageNumber() < (this.getNumberOfPages() - 1))
                buttons.append("<a class='pagina' title='Próxima Página' href=\"javascript:executarPaginacaoProtesto('"
                               + (this.getPageNumber() + 1)
                               + "','"
                               + this.getPageName()
                               + "')\">");
            else
                buttons.append("<div title='Próxima Página'>");
            buttons.append("Próxima");
            if (this.getPageNumber() < (this.getNumberOfPages() - 1))
                buttons.append("</a>");
            buttons.append("&nbsp;&nbsp;");
            if (this.getPageNumber() == (this.getNumberOfPages() - 1))
                buttons.append("</div>");
            buttons.append("	</td>\n");

            // Última Página
            buttons.append("    <td nowrap>\n");
            if (this.getPageNumber() < (this.getNumberOfPages() - 1))
                buttons.append("<a class='pagina' title='Última Página' href=\"javascript:executarPaginacaoProtesto('"
                               + (this.getNumberOfPages() - 1)
                               + "','"
                               + this.getPageName()
                               + "')\">");
            else
                buttons.append("<div title='Última Página'>");
            buttons.append("&gt;&gt;");
            if (this.getPageNumber() < (this.getNumberOfPages() - 1))
                buttons.append("</a>");
            else
                buttons.append("</div>");
            buttons.append("</td>\n");

            buttons.append("  </tr>\n");
            buttons.append("</table>\n");
            this.pageContext.getOut().println(buttons.toString());
            getScriptGenerator().addScript("ExecutarPaginacaoProtesto",
                    this.getFormName() + ";" + "paginaAtual");
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("ButtonPaginar doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("ButtonPaginar doStartTag() Exception capturada:"
                               + e.toString(),
                    e);
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
        return ((Form) this.getParent()).getScriptGenerator();
    }

    /**
     * Método getFormName. Retorna o nome do formulario em que a tag esta
     * inserida.
     * 
     * @return String: nome do Form
     */
    public String getFormName() {
        return ((Form) this.getParent()).getName();
    }

    /**
     * Método doEndTag. Sem implementação.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        return SKIP_BODY;
    }

    /**
     * @return maxOccPages
     */
    public int getMaxOccPages() {
        return maxOccPages;
    }

    /**
     * @return numberOfPages
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * @return pageName
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @return pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param int
     */
    public void setMaxOccPages(int i) {
        maxOccPages = i;
    }

    /**
     * @param i
     */
    public void setNumberOfPages(int i) {
        numberOfPages = i;
    }

    /**
     * @param string
     */
    public void setPageName(String string) {
        pageName = string;
    }

    /**
     * @param i
     */
    public void setPageNumber(int i) {
        pageNumber = i;
    }

    /**
     * Definicao de css para botoes de navegacao
     * 
     * @return String
     */
    private String getCSS() {
        StringBuffer css = new StringBuffer();
        css.append("<style type='text/css'>");
        css.append("<!--");
        css.append("	A.pagina:link, A.pagina:visited, A.pagina:active, A.pagina:hover {");
        css.append("		FONT-SIZE: 10pt;");
        css.append("		FONT-FAMILY: verdana;");
        css.append("		FONT-STYLE: normal;");
        css.append("		FONT-WEIGHT: bold;");
        css.append("		TEXT-DECORATION: none ;");
        css.append("	}");
        css.append("	A.pagina:link {");
        css.append("		COLOR: #0039ba;");
        css.append("	}");
        css.append("	A.pagina:visited {");
        css.append("		COLOR: #6c8bc3;");
        css.append("	}");
        css.append("	A.pagina:active {");
        css.append("		COLOR: #ff6d00;");
        css.append("	}");
        css.append("	A.pagina:hover {");
        css.append("		COLOR: #ff6d00;");
        css.append("	}");
        css.append("	TR.pagina{");
        css.append("		FONT-FAMILY: verdana;");
        css.append("		FONT-SIZE: 10pt;");
        css.append("		FONT-WEIGHT: bold;");
        css.append("		TEXT-ALIGN: center;");
        css.append("		COLOR: gray;");
        css.append("	}");
        css.append("-->");
        css.append("</style>");
        return (css.toString());
    }

}