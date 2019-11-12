package br.com.politec.sao.jsp.controlTags;

import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização do código HTML correspondente a um campo do tipo texto.
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */

public class TextArea extends Control {
    /**
     * Variável que armazena a quantidade de colunas do campo.
     */
    private int cols = 0;

    /**
     * Variável que armazena a quantidade de linhas do campo.
     */
    private int rows = 0;

    /**
     * Variável que define como será tratada a quebra de linhas no submit. off:
     * Não haverá quebra de linha, e será inserida uma barra de rolagem
     * horizontal. soft: Não haverá quebra de linha no submit, porém é
     * apresentado na tela sem barra de rolagem horizontal hard: Há quebra de
     * linhas no submit e é apresentado na tela sem barra de rolagem horizontal
     */
    private String wrap = "";

    /**
     * Informa o nome do campo para retorno de mensagem de erro.
     */
    private String ID = "";

    /**
     * Método doStartTag. Renderiza a porção inicial do código da tag. Adiciona
     * o controle textarea na página com seus atributos.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            // <textarea name="textAreaVersoBloquetoBlqPadrao" cols="75" rows =
            // "3" wrap="hard" id="Mensagem Verso Bloqueto"
            pageContext.getOut().print("<TEXTAREA NAME='"
                                       + getName()
                                       + "' COLS='"
                                       + getCols()
                                       + "' ROWS='"
                                       + getRows()
                                       + "' WRAP='"
                                       + getWrap()
                                       + "' ID='"
                                       + getID()
                                       + "' STYLE='"
                                       + getStyle()
                                       + "' CLASS='"
                                       + getCLASS()
                                       + "' ONKEYPRESS='"
                                       + getOnKeyPress()
                                       + "' ONBLUR='"
                                       + getOnBlur()
                                       + "' ONFOCUS='"
                                       + getOnFocus()
                                       + "' ONKEYUP='"
                                       + getOnKeyUp()
                                       + "' "
                                       + (getDisabled().equals("true")
                                               ? "disabled"
                                               : "")
                                       + ">"
                                       + getValue()
                                       + "</TEXTAREA>");
        } catch (Exception ex) {
            LogUtilSigcb.error("TextArea: Erro na contrucao da Tag: "
                               + ex.getMessage(), ex);
            throw new Error("Erro na contrucao da Tag TExtArea.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método getCols. Retorna a quantidade de colunas que o campo ocupa na
     * página
     * 
     * @return int
     */
    public int getCols() {
        return cols;
    }

    /**
     * Método setCols. Define as colunas do campo na página.
     * 
     * @param size
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * Método getRows. Retorna a quantidade de linhas visíveis do campo na
     * página.
     * 
     * @return int
     */
    public int getRows() {
        return rows;
    }

    /**
     * Método setRows. Define a quantidade de linhas visíveis do campo na
     * página.
     * 
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Método getWrap. Retorna o tipo de quebra de linha.
     * 
     * @return String
     */
    public String getWrap() {
        return wrap;
    }

    /**
     * Método setWrap. Define o tipo de quebra de linha.
     * 
     * @param wrap
     */
    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    /**
     * Método setID. Define o nome do campo para mensagem de erro.
     * 
     * @param wrap
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * Método getID. Retorna o nome do campo para mensagem de erro.
     * 
     * @return String
     */
    public String getID() {
        return ID;
    }
}