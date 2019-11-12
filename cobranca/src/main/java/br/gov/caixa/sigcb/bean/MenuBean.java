package br.gov.caixa.sigcb.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import br.com.politec.sao.util.ServiceLocator;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;
import electric.xml.Document;
import electric.xml.Element;
import electric.xml.Elements;
import electric.xml.ParseException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente JavaBean utilizado para armazenamento de infomações do menu
 * (padrao Milonic) e restricoes de acesso a funcionalidades. Os itens de um
 * MenuBean sao outros MenuBeans, gerando uma estrutura de dados em arvore.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>06/09/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class MenuBean implements Serializable {

    private static MenuBean menuInstance = null;

    // Itens de configuracao do menu
    // Aplicavel apenas se o item de menu possui sub-itens
    private String name = ""; // Menu items Name

    private int width = 100; // Width

    private String screenPos = ""; // Screen Position - here you can use

    // 'center;left;right;middle;top;bottom'

    private String alignment = "left"; // Alignment - sets the menu elements

    // alignment, HTML values are valid here
    // for example: left, right or center

    private int visible = 0; // Always Visible - allows the menu item to be

    // visible at all time

    private int followScroll = 1; // Follow Scrolling - Tells the menu item to

    // follow the user down the screen

    private int horizontal = 0; // Horizontal Menu - Tells the menu to be

    // horizontal instead of top to bottom style

    private String top = ""; // Top

    private String left = ""; // Left

    private List itens = new ArrayList(); // Subitens do menu (devem ser

    // outros MenuBeans)

    // Itens de configuracao de acao
    private String text = ""; // Descricao - Texto a ser mostrado na tela

    private String type = "menu"; // type - acao a ser executada qdo o menu

    // for selecionado. Pode ser strategy,
    // javascript ou menu

    private String action = ""; // actionCall - nome da estrategia ou funcao

    // javascript a ser chamada

    private List acessGroups = new ArrayList(); // acessGroups - grupos do Ldap

    // que podeam acessar a
    // funcionalidade

    private Map internalAction = new HashMap(); // internalAction - funcoes

    // internas e suas restricoes de
    // acesso (podem ser consultar,
    // incluir, alterar, ...)

    /**
     * Construtor default Nao permite que o Construtor seja invocado diretamente
     */
    private MenuBean() {
    }

    /**
     * Metodo para obter a instancia unica do menuBean. Esta instancia é
     * representada pela raiz da arvore de menu.
     * 
     * @return: Instancia do menuBean
     */
    public synchronized static MenuBean getInstance() throws SigcbException {
        if (menuInstance == null)
            throw new SigcbException(new Exception("MenuBean: Arquivo de Configuração de Menu nao inicializado. "
                                                   + "Antes é necessário utilizar o metodo estático create()."));
        return (menuInstance);
    }

    /**
     * Metodo para configurar a instancia de menu a partir de um servlet
     * context. Uma vez criada a instancia, nao é mais possivel reconfigurá-la.
     * 
     * @param: servletContext
     * @return: Instancia do menuBean
     */
    public synchronized static void createInstance(ServletContext servletContext)
            throws SigcbException {
        menuInstance = getRootMenuBean(servletContext);
    }

    /**
     * Metodo para obter a raiz do menuBean definido apartir de um stream. É
     * utilizado o pattern singleton para reter e obter o ultimo xml parseado.
     * 
     * @param: servletContext
     * @return: Instancia do menuBean
     */
    private static MenuBean getRootMenuBean(ServletContext servletContext)
            throws SigcbException {
        if (menuInstance == null) {
            try {

                ServiceLocator service = ServiceLocator.getInstance();
                String menuFile = (String) service.getString("java:comp/env/configMenu");

                // TODO: Definir uma forma melhor de obter o InputStream do xml,
                // sem passar o servletContext como parametro do metodo.
                InputStream stream = servletContext.getResourceAsStream(menuFile);

                // Parsing do xml e definicao do menuBean
                menuInstance = new MenuBean();
                menuInstance.parse(stream);

                // Fecha o stream
                stream.close();
            } catch (IOException e) {
                LogUtilSigcb.fatal("Menu: Erro ao ler arquivo de configuracao do menu",
                        e);
                throw new SigcbException(new Exception("Erro na geracao do menu"));
            } catch (Exception e) {
                LogUtilSigcb.fatal("Menu: Erro na obtencao dos dados de configuracao do menu",
                        e);
                throw new SigcbException(new Exception("Erro na geracao do menu"));
            }

            // Configuracao root
            menuInstance.setVisible(1);
            menuInstance.setFollowScroll(1);
            menuInstance.setHorizontal(1);
            menuInstance.setTop("0");
            menuInstance.setLeft("0");
            menuInstance.setAlignment("center");
        }
        return menuInstance;
    }

    /**
     * Metodo para parsing do InputStream.
     * 
     * @param: InputStream: arquivo xml de configuracao do menu
     */
    private void parse(InputStream menuStream) throws SigcbException {
        try {
            Document doc = new Document(menuStream);
            Element root = doc.getRoot();
            if (!root.getName().equals("menu-root")) {
                LogUtilSigcb.fatal("Menu: Tag menu-root nao existente no arquivo de configuracao do menu");
                throw new SigcbException(new Exception("Erro na geração do menu"));
            }

            this.parse(root);
            this.addItens(this, root);

        } catch (ParseException e) {
            LogUtilSigcb.fatal("Menu: Erro na construcao do objeto Document", e);
            throw new SigcbException(new Exception("Erro na geracao do menu"));
        } catch (Exception e) {
            LogUtilSigcb.fatal("Menu: Erro ao fazer parsing do menu", e);
            throw new SigcbException(new Exception("Erro na geracao do menu:"
                                                   + e.getMessage()));
        }
    }

    /**
     * Metodo para parsing do elemento xml.
     * 
     * @param: Element (eletricXML)
     */
    private void parse(Element element) throws SigcbException {
        String raw = "";

        name = getAttribute(element, "name", true);

        text = getAttribute(element, "text", true);

        raw = getAttribute(element, "width", false);
        width = (raw == null) ? 100 : Integer.parseInt(raw);

        raw = getAttribute(element, "type", false);
        type = (raw == null) ? "menu" : raw;
        if (!(type.equals("strategy") | type.equals("javascript") | type.equals("menu"))) {
            LogUtilSigcb.info("Menu: Atributo type: "
                              + type
                              + " é invalido. Assumindo type=menu.");
            type = "menu";
        }

        raw = getAttribute(element, "action", false);
        action = (raw == null) ? "" : raw;

        raw = getAttribute(element, "acess-groups", true);
        raw = (raw == null) ? "" : raw;
        acessGroups = new ArrayList();
        StringTokenizer tokenizer = new StringTokenizer(raw, ";");
        while (tokenizer.hasMoreTokens())
            acessGroups.add(tokenizer.nextToken());

        // Obtem internalAction
        Elements internalElements = element.getElements();
        while (internalElements.hasMoreElements()) {
            Element internalElement = internalElements.next();
            if (internalElement.getName().equals("internal-action")) {
                String internalName = getAttribute(internalElement,
                        "name",
                        true);

                List internalAcessGroups = new ArrayList();

                raw = getAttribute(internalElement, "acess-groups", true);
                raw = (raw == null) ? "" : raw;
                tokenizer = new StringTokenizer(raw, ";");
                while (tokenizer.hasMoreTokens()) {
                    internalAcessGroups.add(tokenizer.nextToken());
                }
                internalAction.put(internalName, internalAcessGroups);
            }
        }
    }

    /**
     * Metodo para retornar o atributo presente no XML. o atributo pode tanto
     * ser um elemento ou parametro na tag
     * 
     * @param element:
     *            elemento XML
     * @param name:
     *            nome do atributo a ser pesquisado
     * @param mandatory:
     *            lanca excecao se o atributo for obrigatorio e nao estiver
     *            presente no elemento
     * @return String: o valor do atributo.
     */
    private String getAttribute(Element element, String name, boolean mandatory)
            throws SigcbException {
        String attr = element.getAttributeValue(name);
        if (attr == null) {
            Element newElement = element.getElement(name);
            if (newElement != null)
                attr = newElement.getTextString();
        }
        if (attr == null) {
            if (mandatory) {
                LogUtilSigcb.fatal("Menu: Atributo "
                                   + name
                                   + " nao existente na tag "
                                   + element.getName());
                throw new SigcbException(new Exception("Erro na geração do menu"));
            }
        }
        return attr;
    }

    /**
     * Metodo para preencher o MenuBean atraves do XML informado, é utilizado
     * metodo de varredura na arvore xml em preordem. Os itens adicionados sao
     * novos MenuBeans.
     * 
     * @param: MenuBean e Element (eletricXML)
     */
    private void addItens(MenuBean bean, Element element) throws SigcbException {
        Elements elements = element.getElements();
        while (elements.hasMoreElements()) {
            Element subElement = elements.next();

            if (subElement.getName().equals("menu-item")
                || subElement.getName().equals("menu-root")) {
                MenuBean subBean = new MenuBean();
                subBean.parse(subElement);
                bean.getItens().add(subBean);
                addItens(subBean, subElement);
            }
        }
    }

    /**
     * Verifica se o bean possui determinado nivel de acesso
     * 
     * @param: userGroup a ser verificado no atributo acessGroups
     * @return: boolean se possui ou nao acesso.
     */
    public boolean hasUserAcessByAcessGroup(String userGroup) {
        Iterator groupsIt = this.getAcessGroups().iterator();
        while (groupsIt.hasNext()) {
            String group = (String) groupsIt.next();
            if (group.equals(userGroup)) {
                return (true);
            }
        }
        return (false);
    }

    /**
     * Verifica se determinada acao/funcao interna do bean possui determinado
     * nivel de acesso
     * 
     * @param: String: internalActionNamePackage - nome da acao/funcao interna.
     *         a construcao do nome internalAction a ser pesquisado deve seguir
     *         o padrao
     *         "menuprincipal"."menusecundario"."menuterciario"."..."."nomedaacao"
     * @param: String: userGroup - a ser verificado no acessGroups
     * @return: boolean: se possui ou nao acesso.
     */
    public boolean hasUserAcessByInternalAction(String internalActionNamePackage,
            String userGroup) {
        // Quebra o internalActionNamePackage em um List com os nomes de pacotes
        // ordenados,
        // a ultima posicao do List é o nome da acao/funcao
        List internalActionPackageList = new ArrayList();
        StringTokenizer tokenizer = new StringTokenizer(internalActionNamePackage,
                ".");
        while (tokenizer.hasMoreTokens())
            internalActionPackageList.add(tokenizer.nextToken());

        String internalActionName = (String) internalActionPackageList.get(internalActionPackageList.size() - 1);

        // Pesquisa a arvore de MenuBean até obter o ultimo nó MenhuBean,
        // caso nao encontre algum dos nós, ou o nó nao tiver userGroup, retorna
        // falso
        // (A ultima posicao do internalActionPackage é o nome da acao/funcao
        MenuBean bean = this;
        for (int i = 0; i < internalActionPackageList.size() - 1; i++) {
            bean = MenuBean.getMenuBeanByName(bean,
                    (String) internalActionPackageList.get(i));
            if (bean == null) {
                LogUtilSigcb.error("MenuBean: Configuracao de seguranca incorreto...");
                LogUtilSigcb.error("        : InternalActionPackage em processamento: '"
                                   + internalActionNamePackage
                                   + "'.");
                LogUtilSigcb.error("        : InternalAction a ser processado: '"
                                   + internalActionName
                                   + "'.");
                LogUtilSigcb.error("        : Problema: '"
                                   + (String) internalActionPackageList.get(i)
                                   + "' nao foi encontrado em InternalActionPackage (arquivo de configuracao de menu).");
                LogUtilSigcb.error("        : Verifique a chamada internalAction presente no JSP versus o definido no arquivo de configuracao.");
                return (false);
            }
            if (!bean.hasUserAcessByAcessGroup(userGroup)) {
                LogUtilSigcb.info("MenuBean: Usuario nao possui acesso a este Item de Seguranca ("
                                  + (String) internalActionPackageList.get(i)
                                  + ") neste InternalActionPackage ("
                                  + internalActionNamePackage
                                  + ")");
                return (false);
            }
        }
        // Neste ponto o objeto bean deve conter o ultimo nó possivel da
        // estrutura do menu

        // Verifica se o internalAction informado existe, e se ele possui acesso
        // userGroup
        // caso nao, retorna false.
        Iterator internalActionIt = bean.getInternalAction()
                .keySet()
                .iterator();
        boolean internalActionFound = false;
        for (int i = 0; internalActionIt.hasNext(); i++) {
            String internalActionItem = (String) internalActionIt.next();
            if (internalActionItem.equals(internalActionName)) {
                internalActionFound = true;
                List internalGroupsList = (List) bean.getInternalAction()
                        .get(internalActionItem);
                Iterator internalGroupsIt = internalGroupsList.iterator();
                for (int j = 0; internalGroupsIt.hasNext(); j++) {
                    String internalGroup = (String) internalGroupsIt.next();
                    if (internalGroup.equals(userGroup)) {
                        return (true);
                    }
                }
            }
        }
        if (internalActionFound) {
            LogUtilSigcb.info("MenuBean: Usuario nao possui acesso a este Item de Seguranca ("
                              + internalActionName
                              + ") neste InternalActionPackage ("
                              + internalActionNamePackage
                              + ")");
        } else {
            LogUtilSigcb.error("MenuBean: Configuracao de seguranca incorreto...");
            LogUtilSigcb.error("        : InternalActionPackage em processamento: '"
                               + internalActionNamePackage
                               + "'.");
            LogUtilSigcb.error("		 : InternalAction a ser processado: '"
                               + internalActionName
                               + "'.");
            LogUtilSigcb.error("        : Problema: "
                               + internalActionName
                               + " nao foi encontrado em InternalActionPackage (arquivo de configuracao de menu).");
            LogUtilSigcb.error("		 : Verifique a chamada internalAction presente no JSP X o definido no arquivo de configuracao.");
        }

        return (false);
    }

    /**
     * Obtem a referencia ao primeiro objeto de item de menu cujo nome condiz
     * com name a partir do nó de menu informado
     * 
     * @param initialBean:
     *            nó de menu a partir do qual será realizada a pesquisa em
     *            pré-ordem
     * @param beanName:
     *            nome a ser pesquisado
     * @return MenuBean: nó de menu condizente com name, se nao for encontrado
     *         nó retorna null.
     */
    public static MenuBean getMenuBeanByName(MenuBean initialBean,
            String beanName) {
        Iterator beanIt = initialBean.getItens().iterator();
        while (beanIt.hasNext()) {
            MenuBean itemBean = (MenuBean) beanIt.next();
            if (beanName.equals(itemBean.getName()))
                return (itemBean);
        }
        return (null);
    }

    /**
     * Retorna o conteudo bean de forma legivel.
     * 
     * @return String
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        getStringBeanStructure(buffer, this);
        return (buffer.toString());
    }

    /**
     * Retorna o conteudo do bean de forma legivel.
     * 
     * @return String
     */
    private String getStringBeanStructure(StringBuffer buffer, MenuBean bean) {
        buffer.append("{");
        buffer.append("Name: " + getName() + ";");
        buffer.append("Text: " + getText() + ";");
        buffer.append("Width: " + getWidth() + ";");
        buffer.append("Type: " + getType() + ";");
        buffer.append("Action: " + getAction() + ";");

        Iterator groupsIt = this.getAcessGroups().iterator();
        for (int i = 0; groupsIt.hasNext(); i++) {
            String group = (String) groupsIt.next();
            buffer.append("Group " + i + ": " + group + "; ");
        }

        Iterator internalIt = this.getInternalAction().keySet().iterator();
        for (int i = 0; internalIt.hasNext(); i++) {
            String internal = (String) internalIt.next();
            buffer.append("Internal " + i + ": " + internal + "; ");

            List internalGroupsList = (List) this.getInternalAction()
                    .get(internal);
            Iterator internalGroupsIt = internalGroupsList.iterator();
            for (int j = 0; internalGroupsIt.hasNext(); j++) {
                String internalGroup = (String) internalGroupsIt.next();
                buffer.append("InternalGroup "
                              + j
                              + ": "
                              + internalGroup
                              + "; ");
            }
        }
        buffer.append("}\n");

        return (buffer.toString());
    }

    /**
     * Retorna os grupos de acesso do nó de menu corrente
     * 
     * @return List
     */
    public List getAcessGroups() {
        return acessGroups;
    }

    /**
     * Retorna a acao do nó de menu corrente
     * 
     * @return String
     */
    public String getAction() {
        return action;
    }

    /**
     * Retorna o valor de alinhamento do nó de menu corrente
     * 
     * @return String
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Retorna os Itens imediatamente abaixo na hierarquia de menu
     * 
     * @return List
     */
    public List getItens() {
        return itens;
    }

    /**
     * Retorna o nome do menu
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna a posicao do menu na tela
     * 
     * @return String
     */
    public String getScreenPos() {
        return screenPos;
    }

    /**
     * Retorna o texto do menu
     * 
     * @return String
     */
    public String getText() {
        return text;
    }

    /**
     * Retorna o tipo do menu
     * 
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Retorna o tamanho do menu
     * 
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     * Define os Grupos de acesso do nó de menu corrente
     * 
     * @param list
     */
    public void setAcessGroups(List list) {
        acessGroups = list;
    }

    /**
     * Define a acao do no de menu corrente
     * 
     * @param string
     */
    public void setAction(String string) {
        action = string;
    }

    /**
     * Define o tipo de alinhamento do nó de menu corrente
     * 
     * @param string
     */
    public void setAlignment(String string) {
        alignment = string;
    }

    /**
     * Define os itens ligados ao nó de menu corrente
     * 
     * @param list
     */
    public void setItens(List list) {
        itens = list;
    }

    /**
     * Define o nome do no de menu corrente
     * 
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * Define a posicao na tela do nó de menu corrente
     * 
     * @param string
     */
    public void setScreenPos(String string) {
        screenPos = string;
    }

    /**
     * Define o texto a ser apresentado para o nó de menu corrente
     * 
     * @param string
     */
    public void setText(String string) {
        text = string;
    }

    /**
     * Define o tipo do nó de menu corrente
     * 
     * @param string
     */
    public void setType(String string) {
        type = string;
    }

    /**
     * Define o tamanho do nó de menu corrente
     * 
     * @param i
     */
    public void setWidth(int i) {
        width = i;
    }

    /**
     * Retorna a posicao do nó de menu corrente
     * 
     * @return int
     */
    public int getHorizontal() {
        return horizontal;
    }

    /**
     * Retorna o tipo de visibilidade nó de menu corrente
     * 
     * @return int
     */
    public int getVisible() {
        return visible;
    }

    /**
     * Define a posicao do nó de menu corrente
     * 
     * @param i
     */
    public void setHorizontal(int i) {
        horizontal = i;
    }

    /**
     * Define o tipo de visibilidade do nó de menu corrente
     * 
     * @param i
     */
    public void setVisible(int i) {
        visible = i;
    }

    /**
     * Retorna a posicao do nó de menu corrente
     * 
     * @return String
     */
    public String getLeft() {
        return left;
    }

    /**
     * Retorna a posicao do nó de menu corrente
     * 
     * @return String
     */
    public String getTop() {
        return top;
    }

    /**
     * Define a posicao do nó de menu corrente
     * 
     * @param string
     */
    public void setLeft(String string) {
        left = string;
    }

    /**
     * Define a posicao do nó de menu corrente
     * 
     * @param string
     */
    public void setTop(String string) {
        top = string;
    }

    /**
     * Retorna as acoes de botao (internal action) do no de menu corrente
     * 
     * @return internalAction
     */
    public Map getInternalAction() {
        return internalAction;
    }

    /**
     * Define as acoes de botao (internal action) do no de menu corrente
     * 
     * @param map
     */
    public void setInternalAction(Map map) {
        internalAction = map;
    }

    /**
     * Retorna o tipo de visualizacao do no de menu corrente
     * 
     * @return int
     */
    public int getFollowScroll() {
        return followScroll;
    }

    /**
     * Define o tipo de visualizacao do no de menu corrente
     * 
     * @param i
     */
    public void setFollowScroll(int i) {
        followScroll = i;
    }

}
