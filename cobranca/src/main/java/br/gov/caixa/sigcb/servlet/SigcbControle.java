package br.gov.caixa.sigcb.servlet;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.politec.sao.controlStrategy.ControlServlet;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Servlet de controle do sistema SIGCB. Esta classe é uma implementação direta
 * das classes ControlServlet (que provê o controle de estratégias de
 * processamento das requisições http) e de PolitecServlet, que define a
 * interface padrão de servlets para framework Generic Beans Politec.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/01/2003</DD>
 * </DL>
 * 
 * @author Alex Takaoka - atakaoka@sao.politec.com.br
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br adaptacoes em
 *         handleException para obter a estrategia sendo executada/tratada pela
 *         servlet.
 * @author Eduardo A. Morás - emoras@sao.politec.com.br 07/10/2005 - Métodos
 *         para controle dos beans retidos
 */
public class SigcbControle extends ControlServlet {

    public SigcbControle() {
        super();
    }

    /**
     * HashMap com todas as estratégias acionadas pelo menu.
     */
    protected static final String ESTRATEGIAS_MENU = "estrategiasMenu";

    private static final long serialVersionUID = 1833380378865679698L;

    @Override
    protected void initialize(ServletConfig config) throws Exception {
        super.initialize(config);
        // TODO Limpar
        LogUtilSigcb.info(">>> protected void "
                          + config.getServletName()
                          + ".initialize(ServletConfig config)");

        try {

            Map strategyHashMap = Collections.synchronizedMap(new HashMap());

            MenuBean.createInstance(this.getServletContext());
            MenuBean menuBean = MenuBean.getInstance();
            populateStrategyHashMap(strategyHashMap, menuBean);

            this.getServletContext().setAttribute(ESTRATEGIAS_MENU,
                    strategyHashMap);

        } catch (SigcbException e) {
            LogUtilSigcb.error("Problemas na execucao do metodo populateStrategyHashMap.",
                    e);
        }

        LogUtilSigcb.info("<<< protected void "
                          + config.getServletName()
                          + ".initialize(ServletConfig config)");
    }

    /**
     * Mantém a raiz do pacote de estratégias de processamento do sistema.
     * 
     * @see br.com.politec.sao.controlStrategy.ControlServlet#getRootPackageStrategies()
     */
    protected String getRootPackageStrategies() {
        return "br.gov.caixa.sigcb.estrategia";
    }

    /**
     * Mantém a url padrão a ser utilizada em caso de exceções tratadas pela
     * framework Generic Beans Politec.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#getDefaultHTMLErrorPageName()
     */
    protected String getDefaultHTMLErrorPageName() {
        return "sigcb_erro";
    }

    /**
     * Mantém a url padrão a ser utilizada em caso de mensagens ISO-8583
     * tratadas pela framework Generic Beans Politec.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#getDefaultHTMLErrorPageName()
     */
    protected String getDefaultHTMLMessagePageName() {
        return "sigcb_mensagem";
    }

    /**
     * Implementação do método responsável pelo tratamento de erros controlados
     * pela framework Generic Beans Politec.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#handleException(Exception,
     *      HttpServletRequest, HttpServletResponse, String, String)
     */
    protected void handleException(Exception exc,
            HttpServletRequest request,
            HttpServletResponse response,
            String strategy,
            String typeMessage) {

        String messageError = "";

        if (exc.toString().equals(null) || exc.toString().equals(""))
            messageError = "Sistema Indisponível no Momento.";
        else
            messageError = exc.getMessage();

        request.setAttribute("msgError", messageError);

        if (typeMessage.equals("Message")) {
            if (super.cacheContainsStrategy(strategy)) {
                StringBuffer sb = new StringBuffer();

                sb.append("\n<<<MENSAGEM DO MAINFRAME>>>");
                sb.append("\n\tMensagem obtida do mainframe pela estrategia ")
                        .append(strategy)
                        .append(": ")
                        .append(exc.getMessage());
                sb.append("\n\tRedirecionado para página : ")
                        .append(super.getStrategy(strategy)
                                .getCustomizedHTMLMessagePageName());
                sb.append("\n\tException encapsuladora   : ")
                        .append(exc.getClass());
                sb.append("\n\tCausa                     : ")
                        .append(exc.getCause());

                LogUtilSigcb.error(sb.toString(), exc);

                forward(super.getStrategy(strategy)
                        .getCustomizedHTMLMessagePageName(), request, response);
            } else {
                StringBuffer sb = new StringBuffer();

                sb.append("\n<<<EXCEPTION CAPTURADA>>>");
                sb.append("\n\tProblemas com a estrategia ")
                        .append(strategy)
                        .append(": ")
                        .append(exc.getMessage());
                sb.append("\n\tRedirecionado para página : ")
                        .append(getDefaultHTMLMessagePageName());
                sb.append("\n\tException                 : ")
                        .append(exc.getClass());
                sb.append("\n\tCausa                     : ")
                        .append(exc.getCause());

                LogUtilSigcb.error(sb.toString(), exc);

                forward(getDefaultHTMLMessagePageName(), request, response);
            }
        } else {
            StringBuffer sb = new StringBuffer();

            sb.append("\n<<<EXCEPTION CAPTURADA>>>");
            sb.append("\n\tExcecao na estrategia       ")
                    .append(strategy)
                    .append(": ")
                    .append(exc.getMessage());
            sb.append("\n\tRedirecionado para página : ")
                    .append(getDefaultHTMLMessagePageName());
            sb.append("\n\tException                 : ")
                    .append(exc.getClass());
            sb.append("\n\tCausa                     : ")
                    .append(exc.getCause());

            LogUtilSigcb.error(sb.toString(), exc);

            forward(getDefaultHTMLErrorPageName(), request, response);
        }
    }

    /**
     * Mantém os métodos de requisição http suportados pelo sistema. No momento
     * está habilitado somente requisições via POST para o sistema SIGCB.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#accepts(String)
     */
    protected boolean accepts(String metodo) {
        return metodo.equalsIgnoreCase("POST");
    }

    /**
     * Método doAction.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#doAction(String,
     *      HttpServletRequest, HttpServletResponse) Método acionado pela
     *      estrutura de framework ao recebimento de uma chamada para Servlet. A
     *      sequencia de execução do método doAction, é obter a estratégia
     *      identificada através do parâmetro acao e executar o método
     *      processRequest(); Em seguida direcionar a chamada para URL fornecida
     *      pelo objeto de estratégia.
     * @param strategy,
     *            Nome da stratégia a ser utilizada.
     * @param request,
     *            Objeto de request associado a chamada do browser.
     * @param response,
     *            Objeto de response associado a chamada do browser.
     * @throws Exception
     *             Permite a propagação de exceções que serão tratadas pela
     *             estrutura da framework de projeto.
     */
    protected void doAction(String strategy,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Date inicio = new Date();
        
        try {
            if (request.getSession().getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN) == null) {
                strategy = "login.AutenticacaoUsuario";
            }
            if (isStrategyMenu(strategy))
                SigcbEstrategia.removeBean(request);
            super.doAction(strategy, request, response);
        } finally {
            if (LogUtilSigcb.isInfoEnabled()) {

                StringBuffer sb = new StringBuffer();
                sb.append("\n********************************");
                HttpSession session = request.getSession(false);
                if (session != null) {
                    sb.append("\nSessão:     ").append(session.getId());
                } else {
                    sb.append("\nSessão:     <Não encontrada>");
                }
                sb.append("\nEstratégia: ").append(strategy);
                sb.append("\nUsuário:    ");
                InformacoesUsuarioBean usuario = null;
                if (session != null)
                    usuario = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
                if (usuario == null) {
                    sb.append("<<Não encontrado>>");
                } else {
                    sb.append(usuario.getUsername());
                   // SigcbEstrategia.COD_USUARIO = usuario.getUsername().toUpperCase();
                }
                sb.append("\nInicio:     ")
                        .append(Formatador.formatarDataHoraMinSegMili(inicio));
                sb.append("\nParâmetros: ");
                Iterator i = request.getParameterMap().keySet().iterator();
                while (i.hasNext()) {
                    String key = (String) i.next();
                    sb.append("\n\t").append(key).append(":");
                    String[] values = request.getParameterValues(key);
                    for (int j = 0; j < values.length; j++) {
                        String value = values[j];
                        sb.append("\n\t\t[").append(value).append("]");
                    }
                }
                sb.append("\nFim:        ")
                        .append(Formatador.formatarDataHoraMinSegMili(new Date()));
                sb.append("\n********************************");
                LogUtilSigcb.info(sb.toString());
            }
        }
    }

    /* ***********Controle de retenção de atributos************** */
    /**
     * Metodo para verificar se a estrategia requisitada está presente no menu
     * do sistema
     * 
     * @param strategy,
     *            Nome da stratégia a ser utilizada.
     * @return true se a estratégia estiver presente no menu
     */
    private boolean isStrategyMenu(String strategy) {
        Date inicio = new Date();
        Map strategyHashMap = (Map) this.getServletContext()
                .getAttribute(ESTRATEGIAS_MENU);
        try {
            return strategyHashMap.containsKey(strategy);
        } finally {
            Date fim = new Date();
            StringBuffer sb = new StringBuffer();
            sb.append("*** isStrategyMenu(String strategy)")
                    .append(Formatador.formatarDataHoraMinSegMili(inicio))
                    .append(" - ")
                    .append(Formatador.formatarDataHoraMinSegMili(fim))
                    .append(" [")
                    .append(fim.getTime() - inicio.getTime())
                    .append(" ms ]");
            LogUtilSigcb.info(sb.toString());
        }
    }

    /**
     * Obtem os dados do menu e popula o strategyHashMap de acordo com o
     * conteúdo do arquivo sigcb-menu.xml
     * 
     * @param MenuBean
     *            beanMenu
     * @throws SigcbException
     */
    private void populateStrategyHashMap(Map strategyHashMap, MenuBean beanMenu)
            throws SigcbException {

        Iterator itensIt = beanMenu.getItens().iterator();
        while (itensIt.hasNext()) {
            MenuBean itemBean = (MenuBean) itensIt.next();
            if (itemBean.getType().equals("menu"))
                populateStrategyHashMap(strategyHashMap, itemBean);
            else if (itemBean.getType().equals("strategy"))
                strategyHashMap.put(itemBean.getAction(), "");
        }
    }
}