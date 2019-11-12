package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag Lib utilizada para a criação dos botões do padrão SIGCB
 * 
 * @author Glauber Micheloni Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class ButtonSigcb extends TagSupport {
    /**
     * Nome do botão, que também identifica o nome das imagens a serem
     * utilizadas.
     */
    private String name = "";

    /**
     * Valor a ser mostrado no corpo do botão.
     */
    private String value = "";

    /**
     * Ação a ser executada pelo evento onClick do botão.
     */
    private String action = "";

    /**
     * Atributo identificando botao desabilitado ou nao
     */
    private String disabled = "false";

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

    /**
     * Método doStartTag. Imprime o código html correspondente ao botão no
     * padrão intranet CAIXA.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return Controle para o web container.
     */
    public int doStartTag() {
        try {
            this.value = this.value.equals("") ? this.name : this.value;

            LogUtilSigcb.debug(">>>>>INTERNAL ACTION PARA O BOTAO = \""
                               + name
                               + "\" -> "
                               + getInternalAction());

            if (!getInternalAction().equals("")) {
                if (getUserGroup().equals("")) {
                    throw new SigcbException(new Exception("ButtonSigcb doStartTag - eh necessario informar userGroup para a internalAction definida"));
                }
                if (!getMenuBean().hasUserAcessByInternalAction(getInternalAction(),
                        getUserGroup())) {
                    setDisabled("true");
                } else {
                    setDisabled("false");
                }
            }
            LogUtilSigcb.debug(">>>>>PERMISSAO PARA O BOTAO = \""
                               + name
                               + "\" -> "
                               + (getDisabled().equals("true")
                                       ? "false"
                                       : "true"));
            String usuarioGrupo = getUserGroup();
            LogUtilSigcb.debug(">>>>>USERGROUP PARA O BOTAO = \""
                               + name
                               + "\" -> "
                               + usuarioGrupo);

            StringBuffer button = new StringBuffer();
            button.append("<");
            button.append("input type='button' ");
            button.append("name='" + this.name + "' ");
            button.append("value='" + this.value + "' ");
            button.append("class='button' ");
            button.append("onclick='" + this.action + "' ");
            button.append((getDisabled().equals("true") ? "disabled" : ""));
            button.append(">");
            this.pageContext.getOut().println(button.toString());
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("ButtonSigcb doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("ButtonSigcb doStartTag() Exception capturada:"
                               + e.toString(), e);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método doEndTag. Sem implementação.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        this.name = "";
        this.value = "";
        return SKIP_BODY;
    }

    private MenuBean getMenuBean() throws SigcbException {
        return MenuBean.getInstance();
    }

    /**
     * Método getAction. Obtém a ação associada ao botão.
     * 
     * @return java.lang.String com a assinatura do método javaScript associado
     *         ao envento onClick do botão.
     */
    public String getAction() {
        return this.action;
    }

    /**
     * Método setAction. Associa uma ação ao botão.
     * 
     * @param acao,
     *            String com a assinatura do método javaScript que deve ser
     *            associada ao evento onClick do botão.
     */
    public void setAction(String string) {
        this.action = string;
    }

    /**
     * Método getName. Obtém o nome do botão.
     * 
     * @return String com o nome do botão.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método setName. Atribui o nome do botão.
     * 
     * @param nome,
     *            String com o nome do botão.
     */
    public void setName(String string) {
        this.name = string;
    }

    /**
     * Método getValue. Obtém o valor do botão.
     * 
     * @return String com o valor do botão.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Método setValue. Atribui o valor do botão.
     * 
     * @param nome,
     *            String com o valor do botão.
     */
    public void setValue(String string) {
        this.value = string;
    }

    /**
     * Método getDisabled. Obtém o valor desabilitado ou nao do botão.
     * 
     * @return String com a informacao de habilitado.
     */
    public String getDisabled() {
        return this.disabled;
    }

    /**
     * Método setDisabled. Atribui o valor desabilitado ou nao ao botão.
     * 
     * @param nome,
     *            String com o valor true ou false do atributo.
     */
    public void setDisabled(String string) {
        this.disabled = string;
    }

    /**
     * Método getInternalAction. Obtém a informacao da acao/funcao do botao que
     * possui com restricao de acesso.
     * 
     * @return String com a informacao da acao/funcao com restricao de acesso.
     */
    public String getInternalAction() {
        return internalAction;
    }

    /**
     * Método getUserGroup. Obtém a informacao de nivel de acesso da
     * acao/funcao.
     * 
     * @return String com a informacao de nivel de acesso da acao/funcao.
     */
    public String getUserGroup() {
        return userGroup;
    }

    /**
     * Método setInternalAction. Atribui a informacao da acao/funcao do botao
     * que possui com restricao de acesso.
     * 
     * @param String
     *            com a informacao da acao/funcao com restricao de acesso.
     */
    public void setInternalAction(String string) {
        internalAction = string;
    }

    /**
     * Método setUserGroup. Atribui a informacao de nivel de acesso da
     * acao/funcao.
     * 
     * @param String
     *            com a informacao de nivel de acesso da acao/funcao.
     */
    public void setUserGroup(String string) {
        userGroup = string;
    }

}