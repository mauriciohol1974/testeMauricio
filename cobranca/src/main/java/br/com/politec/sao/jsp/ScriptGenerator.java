package br.com.politec.sao.jsp;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe respons�vel pela gera��o de c�digo javascript, para as diferentes
 * tags, definindo qual a implementa��o a ser utilizada de cada script, a partir
 * de sua capacidade de defini��o do browser e sua vers�o, permitindo que as
 * tags sejam desenvolvidas sob um n�vel de abstra��o mais elevado.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br implentacao do
 *         construtor (pageContext, ScriptFactory)
 * @version release 1.3.1
 */
public class ScriptGenerator {
    /**
     * Armazena o contexto da p�gina.
     */
    private PageContext pageContext;

    /**
     * Armazena a identifica��o do Browser.
     */
    private boolean MSIE;

    /**
     * Armazena lista de scripts a serem adicionados na p�gina.
     */
    private Hashtable documentScripts = new Hashtable();

    /**
     * Armazena uma f�brica de scripts de acordo com o tipo do browser.
     */
    private ScriptFactory factory;

    /**
     * Construtor default.
     */
    public ScriptGenerator() {
    }

    /**
     * Construtor especializado, capaz de abstrair o tipo de browser sendo
     * utilizado pelo usu�rio, a partir de seu <i>user-agent</i>.
     * 
     * @param pageContext
     */
    public ScriptGenerator(PageContext pageContext) {
        this.pageContext = pageContext;
        String userAgent = ((HttpServletRequest) this.pageContext.getRequest()).getHeader("User-Agent");
        this.MSIE = (userAgent.indexOf("MSIE") != -1);
        // this.factory = (this.isMSIE()) ? new IEScriptFactory() : null;
        this.factory = new IEScriptFactory();
    }

    /**
     * Construtor especializado, recebe como parametro a fabrica de scripts
     * 
     * @param pageContext
     * @param factory
     * @author Glauber M. Gallego - Data 1/09/2004
     */
    public ScriptGenerator(PageContext pageContext,
            ScriptFactory factory) {
        this(pageContext);
        this.factory = factory;
    }

    /**
     * M�todo isMSIE. Verifica se o browser � uma vers�o do <i>Microsoft
     * Internet Explorer</i> ( MsIE ).
     * 
     * @return boolean
     */
    public boolean isMSIE() {
        return this.MSIE;
    }

    /**
     * M�todo printHeader. Obt�m as informa��es dispon�veis no HTTP Header.
     */
    public void printHeader() {
        Enumeration lista = ((HttpServletRequest) this.pageContext.getRequest()).getHeaderNames();
        LogUtilSigcb.info("-- Informa��es de Header --");
        while (lista.hasMoreElements()) {
            String nameHeader = (String) lista.nextElement();
            LogUtilSigcb.info(nameHeader
                              + " -- "
                              + ((HttpServletRequest) this.pageContext.getRequest()).getHeader(nameHeader));
        }
    }

    /**
     * M�todo printScripts. Renderiza os scripts apropriados.
     * 
     * @throws Exception
     */
    public void printScripts() throws Exception {
        if (!documentScripts.isEmpty()) {
            this.pageContext.getOut().println("<SCRIPT language='JavaScript'>");
            Enumeration printTemp = this.documentScripts.elements();
            while (printTemp.hasMoreElements()) {
                this.pageContext.getOut().println(printTemp.nextElement());
            }
            this.pageContext.getOut().println("</SCRIPT>");
        }
    }

    /**
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getOnKeyPress(String functionName, String controlName) {
        return this.factory.getOnKeyPress(functionName, controlName);
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getOnBlur(String functionName, String controlName) {
        return this.factory.getOnBlur(functionName, controlName);
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public String getOnFocus(String functionName, String controlName) {
        return this.factory.getOnFocus(functionName, controlName);
    }

    /**
     * M�todo addScript. Adiciona na lista interna de scripts o c�digo definido
     * pelos par�metros.
     * 
     * @param functionName
     * @param controlName
     */
    public void addScript(String functionName, String controlName) {
        if (!this.documentScripts.containsKey(functionName)) {
            this.documentScripts.put(functionName,
                    factory.getScript(functionName, controlName));
        }
    }
}