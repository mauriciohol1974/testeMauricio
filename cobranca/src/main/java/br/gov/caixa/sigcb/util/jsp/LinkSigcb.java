package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <b>Projeto: SIGCB-Intranet-sunone7</b><br>
 * 
 * @author David L. M. Torneiros - p561913 Criado em : 27/06/2007 - 08:37:59
 * @version 1.0.0
 */
public class LinkSigcb extends TagSupport {

    private static final long serialVersionUID = -2411089180157338811L;

    /**
     * Valor a ser mostrado no Link.
     */
    private String value = "";

    /**
     * Ação a ser executada pelo evento onClick do link.
     */
    private String action = "";

    /**
     * Atributo identificando o nivel de acesso do usuario
     */
    private String userGroup = "";

    /**
     * Atributo identificando a acao/funcao do botao quando este possui
     * restricao de acesso, esta informacao deve ser validada quanto a nivel de
     * acesso no arquivo de configuracao do menu. A construcao do nome
     * internalAction a ser pesquisado deve seguir o padrao
     * "menuprincipal"."menusecundario"."menuterciario"."..."."nomedaacao"
     */
    private String internalAction = "";

    @Override
    public int doEndTag() throws JspException {
        this.value = "";
        return SKIP_BODY;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            boolean executaAlert = false;

            if (!getInternalAction().equals("")) {
                if (getUserGroup().equals("")) {
                    throw new SigcbException(new Exception("LinkSigcb doStartTag - eh necessario informar userGroup para a internalAction definida"));
                }
                if (!getMenuBean().hasUserAcessByInternalAction(getInternalAction(),
                        getUserGroup())) {
                    executaAlert = true;
                } else {
                    executaAlert = false;
                }
            }

            StringBuffer button = new StringBuffer();
            button.append("<");
            button.append("a href=\"#\"");
            if (executaAlert) {
                button.append("onclick=\"javascript:alert('Usuário não possui permissão para executar esta ação.');\"");
            } else {
                button.append("onclick=\"" + this.action + "\"");
            }
            button.append(">" + this.value + "</a>");
            this.pageContext.getOut().println(button.toString());
            LogUtilSigcb.info("LINK RENDERIZADO : ");
            LogUtilSigcb.info(button.toString());
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("LinkSigcb doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("LinkSigcb doStartTag() Exception capturada:"
                               + e.toString(), e);
        }
        return EVAL_BODY_INCLUDE;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInternalAction() {
        return internalAction;
    }

    public void setInternalAction(String internalAction) {
        this.internalAction = internalAction;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private MenuBean getMenuBean() throws SigcbException {
        return MenuBean.getInstance();
    }
}