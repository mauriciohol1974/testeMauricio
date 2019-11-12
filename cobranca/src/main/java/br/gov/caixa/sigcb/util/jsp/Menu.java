package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.tagext.TagSupport;

import br.com.politec.sao.jsp.ScriptGenerator;
import br.com.politec.sao.jsp.controlTags.Form;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Paths;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Menu.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class Menu extends TagSupport {
    /**
     * Construtor default.
     */
    public Menu() {
    }

    /**
     * Método doStartTag. Renderiza a porção de código inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            StringBuffer menu = new StringBuffer();

            menu.append("<link rel='stylesheet' type='text/css' href='"
                        + Paths.getRootForStaticContent()
                        + "/css/menu.css'>\n");
            menu.append("<script language='javascript' type='text/javascript' src='"
                        + Paths.getRootForStaticContent()
                        + "/js/b_menu.js'></script>\n");

            menu.append(this.getMenu());

            this.pageContext.getOut().println(menu.toString());
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("Menu doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("Menu doStartTag Exception capturada:"
                               + e.toString(), e);
        }
        return SKIP_BODY;
    }

    /**
     * Método doEndTag. Renderiza a porção de código final da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
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
     * Método getMenu. Retorna o menu do sistema.
     * 
     * @return String: o menu
     */
    private String getMenu() throws SigcbException {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getInitMenu());
        buffer.append(getMenuTree());
        // buffer.append("dumpmenus();\n");
        String menu = buffer.toString();

        return menu;
    }

    /**
     * Método getInitMenu. Retorna o conteudo javascript de Inicializacao do
     * menu.
     * 
     * @return String: script JS de inicializacao e customizacao do menu
     */
    private String getInitMenu() {

        StringBuffer buffer = new StringBuffer();

        // Define variaveis e funcoes para geracao do menu
        /*
         * buffer.append(" var menunum = 0;\n"); buffer.append(" var menus = new
         * Array();\n"); buffer.append(" \n"); buffer.append(" function
         * addmenu(menu){\n"); buffer.append(" menunum++;\n"); buffer.append("
         * menus[menunum] = menu;\n"); buffer.append(" }\n"); buffer.append("
         * function dumpmenus(){\n"); buffer.append(" var _d = document;\n");
         * buffer.append(" var mt='<script language=javascript>';\n");
         * buffer.append(" for(a=1;a<menus.length;a++){\n"); buffer.append("
         * mt+=' menu'+a+'=menus['+a+'];';\n"); buffer.append(" }\n");
         * buffer.append(" mt+='</script>';\n"); buffer.append("
         * _d.write(mt);\n"); buffer.append(" }\n");
         */

        // Define funcoes customizadas de acesso as funcionalidades do menu
        buffer.append("<script>\n");
        buffer.append(" function opensaibamais() {\n");
        buffer.append("		var valorAltura = 450;\n");
        buffer.append("		var valorLargura = 700;\n");
        buffer.append("		var valorTopo = (screen.height - valorAltura) /2;\n");
        buffer.append("		var valorEsquerda = (screen.width - valorLargura) /2;\n");
        buffer.append("		var retorno = window.open(");
        buffer.append("'"
                      + Paths.getRootForStaticContent()
                      + "/jst_menu/index.html?");
        buffer.append("page=" + Paths.getRootForStaticContent());
        buffer.append("/saibamais/' +document."
                      + getFormName()
                      + ".saibamais.value ,");
        buffer.append("'saibamais',");
        buffer.append("'width=' +valorLargura+ ', height=' +valorAltura+ ', top=' +valorTopo+ ', left=' +valorEsquerda+ ', toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=0');\n");
        buffer.append("		retorno.focus();\n");
        buffer.append(" }\n");
        buffer.append(" function opensair() {\n");
        buffer.append(" 	if (confirm('Deseja realmente sair do sistema?')) {\n");
        buffer.append(" 		jaClicou = false;\n");
        buffer.append(" 		frmMenuSubmit('sair.SairFinalizar');\n");
        buffer.append(" 	}\n");
        buffer.append(" }\n");
        buffer.append(" function frmMenuSubmit(estrategia) {\n");
        buffer.append(" 	document."
                      + getFormName()
                      + ".estrategia.value = estrategia;\n");
        buffer.append("		document."
                      + getFormName()
                      + ".fluxo.value = 'normal'\n");
        buffer.append(" 	document." + getFormName() + ".submit();\n");
        buffer.append(" }\n");
        buffer.append("</script>\n");

        // Define variaveis com parametros de comportamento do menu
        /*
         * buffer.append(" var timegap=900; \n"); // The time delay for menus to
         * remain visible buffer.append(" var followspeed=3; \n"); // Follow
         * Scrolling speed buffer.append(" var followrate=2; \n"); // Follow
         * Scrolling Rate buffer.append(" var suboffset_top=0; \n"); // Sub menu
         * offset Top position buffer.append(" var suboffset_left=0; \n"); //
         * Sub menu offset Left position buffer.append(" \n"); // Define os
         * efeitos de mouse do menu. Inibe bug do MSIE 6.0 buffer.append(" var
         * effect = '';\n"); buffer.append("
         * if(navigator.appVersion.indexOf('MSIE 6.0')>0) {\n"); buffer.append("
         * effect =
         * \"Fade(duration=0.2);Alpha(style=0,opacity=88);Shadow(color='#777777',
         * Direction=190, Strength=4)\";\n"); buffer.append(" } else {\n");
         * buffer.append(" effect = \"Shadow(color='#777777', Direction=188,
         * Strength=5)\";\n"); buffer.append(" }\n"); buffer.append(" \n"); //
         * Define estilo do menu buffer.append("var style_custom=[ "); //
         * style_custom is an array of properties. You can have as many property
         * arrays as you need. This means that menus can have their own style.
         * buffer.append(" '#00008b', "); // Mouse Off Font Color
         * buffer.append(" '#E9F2F9', "); // Mouse Off Background Color
         * buffer.append(" '#ffffff', "); // Mouse On Font Color buffer.append("
         * '#6C8BC3', "); // Mouse On Background Color buffer.append("
         * '#CFD8EF', "); // Menu Border Color buffer.append(" 10, "); // Font
         * Size in pixels buffer.append(" 'normal', "); // Font Style (italic or
         * normal) buffer.append(" 'bold', "); // Font Weight (bold or normal)
         * buffer.append(" 'Verdana, Arial', "); // Font Name\n");
         * buffer.append(" 3, "); // Menu Item Padding buffer.append(" '', "); //
         * Sub Menu Image (Leave this blank if not needed) buffer.append(" '',
         * "); // 3D Border & Separator bar buffer.append(" '#add8e6', "); // 3D
         * High Color buffer.append(" '000099', "); // 3D Low Color
         * buffer.append(" '', "); // Current Page Item Font Color (leave this
         * blank to disable) buffer.append(" '', "); // Current Page Item
         * Background Color (leave this blank to disable) buffer.append(" '',
         * "); // Top Bar image (Leave this blank to disable) buffer.append("
         * 'ffffff', "); // Menu Header Font Color (Leave blank if headers are
         * not needed) buffer.append(" '000099', "); // Menu Header Background
         * Color (Leave blank if headers are not needed) buffer.append(" ];\n
         * ");
         */

        return buffer.toString();
    }

    /**
     * Método getMenuTree. Retorna a estrutura do menu.
     * 
     * @return String: menu tree
     */
    public String getMenuTree() throws SigcbException {
        StringBuffer buffer = new StringBuffer();

        // Obtem dados do usuario, definido em AutenticacaoUsuario.
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) pageContext.getSession()
                .getAttribute("usuarioLdap");

        // Obtem estrutura completa do menu
        MenuBean.createInstance(pageContext.getServletContext());
        MenuBean menuBean = MenuBean.getInstance();

        // Preenche o buffer com dados do menuBean, de acordo com o grupo de
        // acesso do usuario
        // fillBufferWithMenuBean(buffer, menuBean, usuarioBean.getNomeGrupo());

        this.criaDivMenuBar(buffer, menuBean, usuarioBean.getNomeGrupo());

        return buffer.toString();
    }

    // /**
    // * Metodo fillBufferWithMenuBean: preenche o StringBuffer com dados do
    // menuBean, de acordo com o nivel de acesso
    // * a estrategia de preenchimento é varrer a a arvore de subItens do bean
    // atraves de preordem (chamada recursiva)
    // * @param buffer: StringBuffer a ser preenchido pelo metodo
    // * @param bean: MenuBean com informacoes de menu e funcoes de acesso
    // * @param acessGroup: nivel de acesso do usuario que esta requisitando o
    // menu
    // */
    // private void fillBufferWithMenuBean(StringBuffer buffer, MenuBean bean,
    // String acessGroup) {
    // buffer.append(getMenuItem(bean, acessGroup));
    // Iterator menuIt = bean.getItens().iterator();
    // while (menuIt.hasNext()) {
    // MenuBean subBean = (MenuBean)menuIt.next();
    // if (subBean.getType().equals("menu"))
    // fillBufferWithMenuBean(buffer, subBean, acessGroup);
    // }
    // }

    /**
     * Método getMenuItem. Retorna o conteudo javascript de um item de menu.
     * 
     * @return String: script de inicializacao e customizacao do menu
     */
    public String getMenuItem(MenuBean bean, String acessGroup) {
        StringBuffer buffer = new StringBuffer();

        if (!bean.hasUserAcessByAcessGroup(acessGroup))
            return buffer.toString();

        // Define configuracoes especificas do menu
        buffer.append(" addmenu(menu=["); // This is the array that contains
                                            // your menu properties and details
        buffer.append(" '" + bean.getName() + "',"); // Menu items Name
        buffer.append("  " + bean.getTop() + ","); // Top
        buffer.append("  " + bean.getLeft() + ","); // left
        buffer.append("  " + bean.getWidth() + ","); // Width
        buffer.append("  1,"); // Border Width
        buffer.append("  " + bean.getScreenPos() + ","); // Screen Position -
                                                            // here you can use
                                                            // 'center;left;right;middle;top;bottom'
        buffer.append(" style_custom,"); // Properties Array - this is set
                                            // higher up, as above
        buffer.append("  " + bean.getVisible() + ","); // Always Visible -
                                                        // allows the menu item
                                                        // to be visible at all
                                                        // time
        buffer.append(" '" + bean.getAlignment() + "',"); // Alignment - sets
                                                            // the menu elements
                                                            // alignment, HTML
                                                            // values are valid
                                                            // here for example:
                                                            // left, right or
                                                            // center
        buffer.append(" effect,"); // Filter - Text variable for setting
                                    // transitional effects on menu activation
        buffer.append("  " + bean.getFollowScroll() + ","); // Follow Scrolling
                                                            // - Tells the menu
                                                            // item to follow
                                                            // the user down the
                                                            // screen
        buffer.append("  " + bean.getHorizontal() + ","); // Horizontal Menu -
                                                            // Tells the menu to
                                                            // be horizontal
                                                            // instead of top to
                                                            // bottom style
        buffer.append(" ,"); // Keep Alive - Keeps the menu visible until the
                                // user moves over another menu or clicks
                                // elsewhere on the page
        buffer.append(" ,"); // Position of sub image
                                // left:center:right:middle:top:bottom
        buffer.append(" ,"); // Show an image on top menu bars indicating a
                                // sub menu exists below
        buffer.append(" ,"); // Reserved for future use
        buffer.append("  1,"); // Open the menu OnClick - leave blank for
                                // OnMouseOver (1=on/0=off)
        buffer.append(" ,"); // Reserved for future use
        buffer.append(" ,"); // Reserved for future use
        buffer.append(" ,"); // Reserved for future use
        buffer.append(" ,\n"); // Reserved for future use

        Iterator itensIt = bean.getItens().iterator();
        while (itensIt.hasNext()) {
            MenuBean itemBean = (MenuBean) itensIt.next();
            if (!itemBean.hasUserAcessByAcessGroup(acessGroup))
                continue;
            buffer.append(" ,'" + itemBean.getText() + "' "); // 'Description
                                                                // Text'
            if (itemBean.getType().equals("strategy"))
                buffer.append(" ,'javascript:frmMenuSubmit(\""
                              + itemBean.getAction()
                              + "\")' "); // 'URL'
            if (itemBean.getType().equals("javascript"))
                buffer.append(" ,'javascript:" + itemBean.getAction() + "()' "); // 'URL'
            if (itemBean.getType().equals("menu"))
                buffer.append(" ,'show-menu=" + itemBean.getName() + "' "); // 'URL'
            buffer.append(" ,'' "); // 'Alternate URL'
            buffer.append(" ,'' "); // 'Status'
            buffer.append(" ,1\n"); // 'Separator Bar'
        }

        buffer.append(" ]);\n");

        return buffer.toString();
    }

    private String criaDivMenuBar(StringBuffer buffer,
            MenuBean beanMenuBar,
            String acessGroup) {

        buffer.append("<div class='menuBar' style='width: 780px;'>\n");

        Iterator itensIt = beanMenuBar.getItens().iterator();
        while (itensIt.hasNext()) {
            MenuBean itemBean = (MenuBean) itensIt.next();
            String menuName = itemBean.getName() + "Menu";

            if (!itemBean.hasUserAcessByAcessGroup(acessGroup))
                continue;

            buffer.append("<a class='menuButton'\n");

            if (itemBean.getType().equals("strategy")) {
                buffer.append("   href='javascript:frmMenuSubmit(\""
                              + itemBean.getAction()
                              + "\")'\n"); // 'URL'
                buffer.append("   onmouseover=\"desativaBotaoMenu(event);\"\n");
            }

            if (itemBean.getType().equals("javascript")) {
                buffer.append("   href='javascript:"
                              + itemBean.getAction()
                              + "()'\n"); // 'URL'
                buffer.append("   onmouseover=\"desativaBotaoMenu(event);\"\n");
            }

            if (itemBean.getType().equals("menu")) {
                buffer.append("   href=''\n");
                buffer.append("   onclick=\"return buttonClick(event, '"
                              + menuName
                              + "');\"\n");
                buffer.append("   onmouseover=\"buttonMouseover(event, '"
                              + menuName
                              + "');\"\n");
            }

            buffer.append(">");

            buffer.append(itemBean.getText());

            buffer.append("</a>\n");
        }

        buffer.append("</div>\n\n");

        itensIt = beanMenuBar.getItens().iterator();
        while (itensIt.hasNext()) {
            MenuBean itemBean = (MenuBean) itensIt.next();
            if (!itemBean.hasUserAcessByAcessGroup(acessGroup))
                continue;

            if (itemBean.getType().equals("menu")) {
                buffer.append(criaDivMenuItem(itemBean, acessGroup));
            }
        }

        return buffer.toString();
    }

    private String criaDivMenuItem(MenuBean bean, String acessGroup) {

        StringBuffer buffer = new StringBuffer();
        String divSubMenus = "";

        String menuName = bean.getName() + "Menu";
        buffer.append("<div id='"
                      + menuName
                      + "' class='menu' onmouseover='menuMouseover(event)'>\n");

        Iterator itensIt = bean.getItens().iterator();
        while (itensIt.hasNext()) {
            MenuBean itemBean = (MenuBean) itensIt.next();
            String itemMenuName = itemBean.getName() + "Menu";

            if (!itemBean.hasUserAcessByAcessGroup(acessGroup))
                continue;

            buffer.append("<a class='menuItem'\n");
            if (itemBean.getType().equals("strategy")) {
                buffer.append("href='javascript:frmMenuSubmit(\""
                              + itemBean.getAction()
                              + "\")'\n"); // 'URL'
            }

            if (itemBean.getType().equals("javascript")) {
                buffer.append("href='javascript:"
                              + itemBean.getAction()
                              + "()'\n"); // 'URL'
            }

            if (itemBean.getType().equals("menu")) {
                buffer.append("   onclick='return false;'\n");
                buffer.append("   onmouseover=\"menuItemMouseover(event, '"
                              + itemMenuName
                              + "');\"\n");
            }
            buffer.append(">");

            buffer.append(itemBean.getText());

            buffer.append("</a>\n");

            buffer.append("<div class='menuItemSep'></div>");

            divSubMenus += criaDivMenuItem(itemBean, acessGroup);
        }

        buffer.append("</div>\n");

        buffer.append(divSubMenus);

        return buffer.toString();
    }

}