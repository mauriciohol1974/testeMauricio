package br.com.politec.sao.jsp.simpleTags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag Lib utilizada para a cria��o dos bot�es do padr�o intranet CAIXA, baseado
 * em imagens.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Button extends TagSupport {
    /**
     * Base Root da aplica��o para inclus�o da imagen.
     */
    private String baseRoot = "";

    /**
     * Nome do bot�o, que tamb�m identifica o nome das imagens a serem
     * utilizadas.
     */
    private String name = "";

    /**
     * A��o a ser executada pelo evento onClick do bot�o.
     */
    private String action = "";

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
    public void setAction(String acao) {
        this.action = acao;
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
    public void setName(String nome) {
        this.name = nome;
    }

    /**
     * M�todo doStartTag. Imprime o c�digo html correspondente ao bot�o no
     * padr�o intranet CAIXA.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return Controle para o web container.
     */
    public int doStartTag() {
        try {
            this.pageContext.getOut().println(getImg());
        } catch (IOException exc) {
            LogUtilSigcb.error("Button: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag Button");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getImg. Gera o c�digo html a ser impresso.
     * 
     * @return String com o c�digo html a ser impresso.
     */
    private String getImg() {
        StringBuffer result = new StringBuffer();
        result.append("<img ");
        result.append("src=\"" + getBaseRoot() + "/imagens/botoes/")
                .append(getName())
                .append(".gif\" ");
        result.append("name=\"").append(getName()).append("\" ");
        result.append("style=\"cursor:hand\" ");
        appendOn(result, "onMouseOver", "Over.gif");
        appendOn(result, "onMouseOut", ".gif");
        result.append("onClick=\"").append(getAction()).append("\" ");
        result.append("/>");
        return result.toString();
    }

    /**
     * M�todo appendOn. Adiciona as a��es de mouse as imagens.
     * 
     * @param result,
     *            StringBuffer com o c�digo html para append.
     * @param action,
     *            evento de mouse.
     * @param extension,
     *            sufixo da imagem src associado ao evento de mouse.
     */
    private void appendOn(StringBuffer result, String action, String extension) {
        result.append(action)
                .append("=\"this.src='")
                .append(getBaseRoot() + "/imagens/botoes/");
        result.append(getName()).append(extension).append("'\" ");
    }

    /**
     * M�todo doEndTag. Sem implementa��o.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        return SKIP_BODY;
    }

    /**
     * M�todo getBaseRoot. Retorna a raiz do diret�rio web, onde as imagens
     * ser�o buscadas dentro do padr�o de path adotado para a framework.
     * 
     * @return String
     */
    public String getBaseRoot() {
        return baseRoot;
    }

    /**
     * M�todo setBaseRoot. Atribui um valor para a raiz a ser utilizada para a
     * busca de imagens.
     * 
     * @param baseRoot
     */
    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }
}