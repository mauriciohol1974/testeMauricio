package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

public class PaginacaoTag extends TagSupport {

    public static final String PAGINA_ATUAL = "br.gov.caixa.sigcb.util.jsp.PaginacaoTag.PAGINA_ATUAL";

    public static final String PAGINA_TOTAL = "br.gov.caixa.sigcb.util.jsp.PaginacaoTag.PAGINA_TOTAL";

    private String estrategia = null;

    @Override
    public int doStartTag() throws JspException {

        try {

            int paginaAtual = 0;
            try {
                paginaAtual = ((Integer) pageContext.getRequest()
                        .getAttribute(PAGINA_ATUAL));
            } catch (Exception e) {
            }

            int paginaTotal = 0;
            try {
                paginaTotal = ((Integer) pageContext.getRequest()
                        .getAttribute(PAGINA_TOTAL));
            } catch (Exception e) {
            }

            int paginaInicial = (int) (Math.floor((paginaAtual - 1) / 5) * 5) + 1;

            int paginaInicialFinal = (int) (Math.floor((paginaTotal - 1) / 5) * 5) + 1;

            StringBuffer sb = new StringBuffer();
            sb.append("<style type='text/css'>");
            sb.append("<!--");
            sb.append("    A.pagina:link, A.pagina:visited, A.pagina:active, A.pagina:hover {");
            sb.append("        FONT-SIZE: 10pt;");
            sb.append("        FONT-FAMILY: verdana;");
            sb.append("        FONT-STYLE: normal;");
            sb.append("        FONT-WEIGHT: bold;");
            sb.append("        TEXT-DECORATION: none ;");
            sb.append("    }");
            sb.append("    A.pagina:link {");
            sb.append("        COLOR: #0039ba;");
            sb.append("    }");
            sb.append("    A.pagina:visited {");
            sb.append("        COLOR: #6c8bc3;");
            sb.append("    }");
            sb.append("    A.pagina:active {");
            sb.append("        COLOR: #ff6d00;");
            sb.append("    }");
            sb.append("    A.pagina:hover {");
            sb.append("        COLOR: #ff6d00;");
            sb.append("    }");
            sb.append("    TR.pagina{");
            sb.append("        FONT-FAMILY: verdana;");
            sb.append("        FONT-SIZE: 10pt;");
            sb.append("        FONT-WEIGHT: bold;");
            sb.append("        TEXT-ALIGN: center;");
            sb.append("        COLOR: gray;");
            sb.append("    }");
            sb.append("-->");
            sb.append("</style>");
            sb.append("<table border='0' cellspacing='3' cellpadding='0' align='center' valign='middle'>");
            sb.append("  <tr class='pagina' >\n");
            sb.append("    <td nowrap>\n");
            if (paginaInicial > 1) {
                sb.append("<a class=\"pagina\" href=\"javascript:paginar(1)\">&lt&lt</a> ");
                sb.append("<a class=\"pagina\" href=\"javascript:paginar(")
                        .append(paginaInicial - 5)
                        .append(")\">Anterior</a> ");
            } else {
                sb.append("&lt&lt ");
                sb.append("Anterior ");
            }
            for (int i = paginaInicial; (i <= paginaInicial + 4)
                                        && (i <= paginaTotal); i++) {
                if (paginaAtual == i) {
                    sb.append(i).append(" - ");
                } else {
                    sb.append("<a class=\"pagina\" href=\"javascript:paginar(")
                            .append(i)
                            .append(")\">")
                            .append(i)
                            .append("</a> ")
                            .append(" - ");
                }
            }
            if (paginaInicial != paginaInicialFinal) {
                sb.append("<a class=\"pagina\" href=\"javascript:paginar(")
                        .append(paginaInicial + 5)
                        .append(")\">Posterior</a> ");
                sb.append("<a class=\"pagina\" href=\"javascript:paginar(")
                        .append(paginaTotal)
                        .append(")\">&gt&gt</a> ");
            } else {
                sb.append("Posterior ");
                sb.append("&gt&gt ");
            }
            sb.append("    </td>\n");
            sb.append("  </tr>\n");
            sb.append("</table>\n");
            sb.append("\n<input type=\"hidden\" name=\"pagina\" value=\"");
            sb.append(paginaAtual);
            sb.append("\">\n");
            sb.append("<script>\n");
            sb.append("function paginar(valor){\n");
            if (estrategia != null) {
                sb.append("    document.frmMain.estrategia.value = \"")
                        .append(estrategia)
                        .append("\";\n");
            }
            sb.append("    document.frmMain.pagina.value = valor;\n");
            sb.append("    document.frmMain.submit();\n");
            sb.append("  }\n");
            sb.append("</script>\n");

            pageContext.getOut().print(sb.toString());

        } catch (Exception e) {
            LogUtilSigcb.error(e.toString(), e);
        }
        return Tag.SKIP_BODY;
    }

    /**
     * @return Returns the estrategia.
     */
    public String getEstrategia() {
        return estrategia;
    }

    /**
     * @param estrategia
     *            The estrategia to set.
     */
    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }
}
