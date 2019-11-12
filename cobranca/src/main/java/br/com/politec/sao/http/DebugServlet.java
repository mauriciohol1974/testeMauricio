package br.com.politec.sao.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DebugServlet extends HttpServlet {
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>Request contents:</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("    <table>");
        out.println("      <tr>");
        out.println("        <th>Request Method:</th>");
        out.println("        <td>" + request.getMethod() + "</td>");
        out.println("      </tr>");
        printHTMLOn(out, new RequestParameters(request));
        printHTMLOn(out, new RequestAttributes(request));
        printHTMLOn(out, new SessionAttributes(request.getSession()));
        out.println("    </table>");
        out.println("  </body>");
        out.println("</html>");
    }

    private void printHTMLOn(PrintWriter out, EntrySet entrySet) {
        final Iterator names = entrySet.names();
        if (names.hasNext()) {
            out.println("      <tr>");
            out.println("        <th colSpan='2'>"
                        + entrySet.title()
                        + ":</th>");
            out.println("      </tr>");
            while (names.hasNext()) {
                final String name = (String) names.next();
                out.println("      <tr>");
                out.println("        <th>" + name + "</th>");
                out.println("        <td>" + entrySet.value(name) + "</td>");
                out.println("      </tr>");
            }
        }
    }

    public String getServletInfo() {
        return "Debug Servlet";
    }
}