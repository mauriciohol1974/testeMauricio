package br.com.politec.sao.jsp.controlTags;

import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o do c�digo HTML correspondente a um campo do tipo texto.
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 * @version release 1.0
 */

public class TextArea extends Control {
    /**
     * Vari�vel que armazena a quantidade de colunas do campo.
     */
    private int cols = 0;

    /**
     * Vari�vel que armazena a quantidade de linhas do campo.
     */
    private int rows = 0;

    /**
     * Vari�vel que define como ser� tratada a quebra de linhas no submit. off:
     * N�o haver� quebra de linha, e ser� inserida uma barra de rolagem
     * horizontal. soft: N�o haver� quebra de linha no submit, por�m �
     * apresentado na tela sem barra de rolagem horizontal hard: H� quebra de
     * linhas no submit e � apresentado na tela sem barra de rolagem horizontal
     */
    private String wrap = "";

    /**
     * Informa o nome do campo para retorno de mensagem de erro.
     */
    private String ID = "";

    /**
     * M�todo doStartTag. Renderiza a por��o inicial do c�digo da tag. Adiciona
     * o controle textarea na p�gina com seus atributos.
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
     * M�todo getCols. Retorna a quantidade de colunas que o campo ocupa na
     * p�gina
     * 
     * @return int
     */
    public int getCols() {
        return cols;
    }

    /**
     * M�todo setCols. Define as colunas do campo na p�gina.
     * 
     * @param size
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * M�todo getRows. Retorna a quantidade de linhas vis�veis do campo na
     * p�gina.
     * 
     * @return int
     */
    public int getRows() {
        return rows;
    }

    /**
     * M�todo setRows. Define a quantidade de linhas vis�veis do campo na
     * p�gina.
     * 
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * M�todo getWrap. Retorna o tipo de quebra de linha.
     * 
     * @return String
     */
    public String getWrap() {
        return wrap;
    }

    /**
     * M�todo setWrap. Define o tipo de quebra de linha.
     * 
     * @param wrap
     */
    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    /**
     * M�todo setID. Define o nome do campo para mensagem de erro.
     * 
     * @param wrap
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * M�todo getID. Retorna o nome do campo para mensagem de erro.
     * 
     * @return String
     */
    public String getID() {
        return ID;
    }
}