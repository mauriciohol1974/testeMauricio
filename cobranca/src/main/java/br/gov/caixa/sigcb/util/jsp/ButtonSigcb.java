package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag Lib utilizada para a cria��o dos bot�es do padr�o SIGCB
 * 
 * @author Glauber Micheloni Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class ButtonSigcb extends TagSupport {
    /**
     * Nome do bot�o, que tamb�m identifica o nome das imagens a serem
     * utilizadas.
     */
    private String name = "";

    /**
     * Valor a ser mostrado no corpo do bot�o.
     */
    private String value = "";

    /**
     * A��o a ser executada pelo evento onClick do bot�o.
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
     * M�todo doStartTag. Imprime o c�digo html correspondente ao bot�o no
     * padr�o intranet CAIXA.
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
     * M�todo doEndTag. Sem implementa��o.
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
     * M�todo getAction. Obt�m a a��o associada ao bot�o.
     * 
     * @return java.lang.String com a assinatura do m�todo javaScript associado
     *         ao envento onClick do bot�o.
     */
    public String getAction() {
        return this.action;
    }

    /**
     * M�todo setAction. Associa uma a��o ao bot�o.
     * 
     * @param acao,
     *            String com a assinatura do m�todo javaScript que deve ser
     *            associada ao evento onClick do bot�o.
     */
    public void setAction(String string) {
        this.action = string;
    }

    /**
     * M�todo getName. Obt�m o nome do bot�o.
     * 
     * @return String com o nome do bot�o.
     */
    public String getName() {
        return this.name;
    }

    /**
     * M�todo setName. Atribui o nome do bot�o.
     * 
     * @param nome,
     *            String com o nome do bot�o.
     */
    public void setName(String string) {
        this.name = string;
    }

    /**
     * M�todo getValue. Obt�m o valor do bot�o.
     * 
     * @return String com o valor do bot�o.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * M�todo setValue. Atribui o valor do bot�o.
     * 
     * @param nome,
     *            String com o valor do bot�o.
     */
    public void setValue(String string) {
        this.value = string;
    }

    /**
     * M�todo getDisabled. Obt�m o valor desabilitado ou nao do bot�o.
     * 
     * @return String com a informacao de habilitado.
     */
    public String getDisabled() {
        return this.disabled;
    }

    /**
     * M�todo setDisabled. Atribui o valor desabilitado ou nao ao bot�o.
     * 
     * @param nome,
     *            String com o valor true ou false do atributo.
     */
    public void setDisabled(String string) {
        this.disabled = string;
    }

    /**
     * M�todo getInternalAction. Obt�m a informacao da acao/funcao do botao que
     * possui com restricao de acesso.
     * 
     * @return String com a informacao da acao/funcao com restricao de acesso.
     */
    public String getInternalAction() {
        return internalAction;
    }

    /**
     * M�todo getUserGroup. Obt�m a informacao de nivel de acesso da
     * acao/funcao.
     * 
     * @return String com a informacao de nivel de acesso da acao/funcao.
     */
    public String getUserGroup() {
        return userGroup;
    }

    /**
     * M�todo setInternalAction. Atribui a informacao da acao/funcao do botao
     * que possui com restricao de acesso.
     * 
     * @param String
     *            com a informacao da acao/funcao com restricao de acesso.
     */
    public void setInternalAction(String string) {
        internalAction = string;
    }

    /**
     * M�todo setUserGroup. Atribui a informacao de nivel de acesso da
     * acao/funcao.
     * 
     * @param String
     *            com a informacao de nivel de acesso da acao/funcao.
     */
    public void setUserGroup(String string) {
        userGroup = string;
    }

}