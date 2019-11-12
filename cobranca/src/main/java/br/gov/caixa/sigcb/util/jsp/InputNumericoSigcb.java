package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

//import br.com.politec.sao.jsp.controlTags.InputNumerico;
import br.com.politec.sao.jsp.controlTags.InputTypeText;
import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag Lib utilizada para a cria��o de input com valida��o de Grupo de usu�rio
 * 

 */
public class InputNumericoSigcb extends InputTypeText {

	public InputNumericoSigcb() {
    }
    
    /**
     * Nome do input.
     */
    private String name = "";
    
   /**
     * Valor a ser mostrado no corpo do input.
     */
    private String value = "";
    
    /**
     * Atributo identificando o input.
     * 
     */
    private String size = "";
    
    /**
     * Atributo identificando o maxlength.
     * 
     */
    private String maxlength = "";
    
    /**
     * Atributo identificando input desabilitado ou nao
     */
    private String disabled = "false";
    
    /**
     * Atributo identificando input desabilitado ou nao
     */
    //private String onKeyPress = "";

	
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
    
    public int doStartTag() {
        try {
            this.value = this.value.equals("") ? this.name : this.value;
            
            /*try {
            	super.doStarTag();
            	super.getScriptGenerator().addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
        	
        	} catch (Exception exc) {
        		LogUtilSigcb.error("InputNumerico: Erro na contrucao da Tag: " + exc.getMessage(), exc);
        		throw new Error("Erro na contrucao da Tag InputNumerico.");
        	}*/
            
            LogUtilSigcb.debug(">>>>>INTERNAL ACTION PARA O INPUT = \""
                               + name
                               + "\" -> "
                               + getInternalAction());

            if (!getInternalAction().equals("")) {
                if (getUserGroup().equals("")) {
                    throw new SigcbException(new Exception("InputNumericoSigcb doStartTag - eh necessario informar userGroup para a internalAction definida"));
                }
                if (!getMenuBean().hasUserAcessByInternalAction(getInternalAction(),
                        getUserGroup())) {
                    setDisabled("true");
                } else {
                    setDisabled("false");
                }
            }
            LogUtilSigcb.debug(">>>>>PERMISSAO PARA O INPUT = \""
                               + name
                               + "\" -> "
                               + (getDisabled().equals("true")
                                       ? "false"
                                       : "true"));
            String usuarioGrupo = getUserGroup();
            LogUtilSigcb.debug(">>>>>USERGROUP PARA O INPUT = \""
                               + name
                               + "\" -> "
                               + usuarioGrupo);

            StringBuffer button = new StringBuffer();
            button.append("<");
            button.append("input type='inputtext' ");
            button.append("name='" + this.name + "' ");
            button.append("value='" + this.value + "' ");
            button.append("size='" + this.size + "' ");
            button.append("maxlength='" + this.maxlength + "' ");
            //button.append("onKeyPress='" + this.onKeyPress + "' ");
            button.append("onKeyPress='return validaDigitacaoNumericoInteiro(String.fromCharCode(event.charCode || event.keyCode))'");
            button.append("class='inputtext' ");
            //button.append("onclick='" + this.action + "' ");
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
    
    
    private MenuBean getMenuBean() throws SigcbException {
        return MenuBean.getInstance();
    }
    
    
    /**
     * M�todo getName. Obt�m o nome do input.
     * 
     * @return String com o nome do input.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * M�todo setName. Atribui o nome do input.
     * 
     * @param nome,
     *            String com o nome do input.
     */
    public void setName(String string) {
        this.name = string;
    }
    
    /**
     * M�todo getValue. Obt�m o valor do input.
     * 
     * @return String com o valor do input.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * M�todo setValue. Atribui o valor do input.
     * 
     * @param nome,
     *            String com o valor do input.
     */
    public void setValue(String string) {
        this.value = string;
    }
    
    /**
     * M�todo getDisabled. Obt�m o valor desabilitado ou nao do input.
     * 
     * @return String com a informacao de habilitado.
     */
    public String getDisabled() {
        return this.disabled;
    }

    /**
     * M�todo setDisabled. Atribui o valor desabilitado ou nao ao input.
     * 
     * @param nome,
     *            String com o valor true ou false do atributo.
     */
    public void setDisabled(String string) {
        this.disabled = string;
    }
    
    /**
     * M�todo getAction. Obt�m a a��o associada ao bot�o.
     * 
     * @return java.lang.String com a assinatura do m�todo javaScript associado
     *         ao envento onClick do bot�o.
     *
     * public String getAction() {
     *   return this.action;
    }*/

    /**
     * M�todo setAction. Associa uma a��o ao bot�o.
     * 
     * @param acao,
     *            String com a assinatura do m�todo javaScript que deve ser
     *            associada ao evento onClick do bot�o.
     *
     * public void setAction(String string) {
     *   this.action = string;
    }*/
    
    /**
     * M�todo getInternalAction. Obt�m a informacao da acao/funcao do input que
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
     * M�todo setInternalAction. Atribui a informacao da acao/funcao do input
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
    
    /**
     * M�todo getsize. Obt�m o valor do atributo size.
     * 
     * @return String com o valor do atributo size.
     */
    
    public String getsize() {
        return this.size;
    }
    
    /**
     * M�todo setSize. Atribui o valor do atributo size.
     * 
     * @param size,
     *            String com o nome do atributo.
     */
    public void setSize(String string) {
        this.size = string;
    }
    
    /**
     * M�todo getmaxlength. Obt�m o valor do atributo size.
     * 
     * @return String com o valor do atributo size.
     */
    
    public String getmaxlength() {
        return this.maxlength;
    }
    
    /**
     * M�todo setMaxlength. Atribui o valor do atributo Maxlength.
     * 
     * @param size,
     *            String com o nome do atributo.
     */
    public void setMaxlength(String string) {
        this.maxlength = string;
    }
    
    /**
     * M�todo getOnKeyPress. Obt�m o valor da fun��o size.
     * 
     * @return String com o valor da fun��o onKeyPress.
     */
    /*
    public String getOnKeyPress() {
        return this.onKeyPress;
    }
    */
    /**
     * M�todo onKeyPress. Atribui o valor da fun��o onKeyPress.
     * 
     * @param size,
     *            String com o valor do atributo.
     */
    /*public void setOnKeyPress(String string) {
        this.onKeyPress = string;
    }*/
       
    
    /*public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoNumericoInteiro", this.getPath());
    }*/
    
}