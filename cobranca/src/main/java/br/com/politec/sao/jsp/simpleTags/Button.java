package br.com.politec.sao.jsp.simpleTags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag Lib utilizada para a criação dos botões do padrão intranet CAIXA, baseado
 * em imagens.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Button extends TagSupport {
    /**
     * Base Root da aplicação para inclusão da imagen.
     */
    private String baseRoot = "";

    /**
     * Nome do botão, que também identifica o nome das imagens a serem
     * utilizadas.
     */
    private String name = "";

    /**
     * Ação a ser executada pelo evento onClick do botão.
     */
    private String action = "";

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
    public void setAction(String acao) {
        this.action = acao;
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
    public void setName(String nome) {
        this.name = nome;
    }

    /**
     * Método doStartTag. Imprime o código html correspondente ao botão no
     * padrão intranet CAIXA.
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
     * Método getImg. Gera o código html a ser impresso.
     * 
     * @return String com o código html a ser impresso.
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
     * Método appendOn. Adiciona as ações de mouse as imagens.
     * 
     * @param result,
     *            StringBuffer com o código html para append.
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
     * Método doEndTag. Sem implementação.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        return SKIP_BODY;
    }

    /**
     * Método getBaseRoot. Retorna a raiz do diretório web, onde as imagens
     * serão buscadas dentro do padrão de path adotado para a framework.
     * 
     * @return String
     */
    public String getBaseRoot() {
        return baseRoot;
    }

    /**
     * Método setBaseRoot. Atribui um valor para a raiz a ser utilizada para a
     * busca de imagens.
     * 
     * @param baseRoot
     */
    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }
}