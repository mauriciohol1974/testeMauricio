package br.gov.caixa.sigcb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.siico.delegate.SiicoDelegate;
import br.gov.caixa.siico.exception.SiicoException;
import br.gov.caixa.siico.factory.DelegateFactory;
import br.gov.caixa.siico.vo.LocalidadeVO;

public class SIGCBAjaxServlet extends HttpServlet {

    // Este CEP é encontrado no SIICO e retorna todos os campos em branco, dado
    // erro na página
    private static final String CEP_INVALIDO_SIICO = "00000000";

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("consultaLocalidadeSICLI")) {
            consultaLocalidadeSICLI(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void consultaLocalidadeSICLI(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            SiicoDelegate delegate = DelegateFactory.getSiicoDelegate();
            ArrayList list = delegate.getLocalidadePorCEP(request.getParameter("cep"));
            PrintWriter out = response.getWriter();
            response.setContentType("text/xml; charset=ISO-8859-1");
            String xml = "<?xml version='1.0'?>";

            if (list.size() > 0
                && (!request.getParameter("cep").equals(CEP_INVALIDO_SIICO))) {
                LocalidadeVO vo = (LocalidadeVO) list.get(0);
                xml += "<resposta codigo=\"0\" >";
                xml += "<localidade>";
                xml += "<tipologradouro>"
                       + vo.getSG_TPO_LOGRADOURO()
                       + "</tipologradouro>";
                xml += "<endereco>" + vo.getNO_LOGRADOURO() + "</endereco>";
                xml += "<bairro>" + vo.getNO_BAIRRO() + "</bairro>";
                xml += "<municipio>" + vo.getNO_MUNICIPIO() + "</municipio>";
                xml += "<cdMunicipio>"
                       + vo.getNU_MUNICIPIO()
                       + "</cdMunicipio>";
                xml += "<uf>" + vo.getSG_UF() + "</uf>";
                xml += "</localidade>";
                xml += "</resposta>";
            } else {
                xml += "<resposta codigo=\"1\">";
                xml += "<mensagem>073</mensagem>";
                xml += "</resposta>";
            }
            out.write(xml);
            out.close();
            if (LogUtilSigcb.isDebugEnabled()) {
                LogUtilSigcb.debug("Consultando CEP, XML de retorno >>>>");
                LogUtilSigcb.debug(xml);
            }

        } catch (SiicoException ex) {
            LogUtilSigcb.error("Erro ao consultar CEP >>>" + ex.getMessage());
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }
}