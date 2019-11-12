package br.com.politec.sao.jsp.controlTags;

import java.util.Iterator;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o do c�digo HTML correspondente a um campo do tipo SELECT
 * (Combo ou Lista).
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Select extends Control {
    /**
     * Armazena o conte�do que ser� adicionado no evento onChange do Select.
     */
    private String onChange = "";

    /**
     * Armazena o conte�do que ser� informado em cada item do Select.
     */
    private String optionLabel = "";

    /**
     * Armazena o atributo Value de cada item do Select.
     */
    private String optionValue = "";

    /**
     * Armazena os itens que dever�o ser selecionados no Select.
     */
    private BeanList selectedList = null;

    /**
     * Armazena os valores de identifica��o dos itens que dever�o ser
     * selecionados no Select.
     */
    private String selectedListValue = "";

    /**
     * Armazena lista de itens a ser adicionada no Select.
     */
    private BeanList list = null;

    /**
     * Armazena o atributo Multiple do Select.
     */
    private boolean multiple;


    /**
     * M�todo doStartTag. Renderiza a por��o inicial do c�digo da tag. Adiciona
     * na p�gina o controle Select com seus atributos, eventos e �tens.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     * @throws JspException
     */
    public int doStartTag() throws JspException {
        try {
            StringBuffer buffer = new StringBuffer();
            fillHeaderSelect(buffer);
            if (this.getList() != null) {
                fillOptions(buffer);
            }
            pageContext.getOut().print(buffer.toString());
        } catch (Exception ex) {
            LogUtilSigcb.error("Select: Erro na contrucao da Tag: "
                               + ex.getMessage(), ex);
            // throw new Error("Erro na contrucao da Tag Select.");
            throw new JspException(ex.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo fillHeaderSelect. Adiciona o controle Select com seus atributos e
     * eventos na p�gina.
     * 
     * @param buffer
     */
    private void fillHeaderSelect(StringBuffer buffer) {
        buffer.append("<SELECT NAME='"
                      + super.getName()
                      + "'"
                      + " ONBLUR='"
                      + super.getOnBlur()
                      + "'"
                      + " ONCHANGE='"
                      + getOnChange()
                      + "'"
                      + (isMultiple() ? " multiple " : "")
                      + " ONFOCUS='"
                      + super.getOnFocus()
                      + "'"
                      + (getDisabled().equals("true") ? "disabled" : "")
                      + ">");
    }

    /**
     * M�todo fillOptions. Adiciona na p�gina os itens do Select, tamb�m faz o
     * controle dos �tens que precisam ser selecionados no Select.
     * 
     * @param buffer
     */
    private void fillOptions(StringBuffer buffer) {
        BusinessObject item;
        buffer.append("<OPTION VALUE=''> </OPTION>");
        for (Iterator iterator = this.getList().iterator(); iterator.hasNext();) {
            boolean selected = false;
            item = (BusinessObject) iterator.next();
            buffer.append("<OPTION VALUE='"
                          + item.getFormattedValue(this.getOptionValue())
                          + "'");
            if (getSelectedList() != null) {
                for (Iterator valuesIterator = getSelectedList().iterator(); valuesIterator.hasNext();) {
                    BusinessObject selItem = (BusinessObject) valuesIterator.next();
                    String value = selItem.getFormattedValue(getSelectedListValue());
                    if (value.equals(item.getFormattedValue(getOptionValue()))) {
                        selected = true;
                        break;
                    }
                }
            } else {
                selected = super.getValue()
                        .equals(item.getFormattedValue(getOptionValue()));
            }
            buffer.append(selected ? " SELECTED>" : ">");
            buffer.append(item.getFormattedValue(this.getOptionLabel()));
            buffer.append("</OPTION>");
        }
    }

    /**
     * M�todo fillFooter. Insere a tag de fechamento do controle Select.
     * 
     * @param buffer
     */
    private void fillFooter(StringBuffer buffer) {
        buffer.append("</SELECT>");
    }

    /**
     * M�todo getOnChange. Retorna o conte�do do evento onChange do controle
     * Select.
     * 
     * @return String
     */
    public String getOnChange() {
        return this.onChange;
    }

    /**
     * M�todo setOnChange. Define o conte�do do evento onChange do controle
     * Select.
     * 
     * @param onChange
     */
    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    /**
     * M�todo getOptionLabel. Retorna o conte�do que ser� informado em cada item
     * do controle Select.
     * 
     * @return String
     */
    public String getOptionLabel() {
        return this.optionLabel;
    }

    /**
     * M�todo setOptionLabel. Define o conte�do que ser� informado em cada item
     * do controle Select.
     * 
     * @param optionLabel
     */
    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }

    /**
     * M�todo getOptionValue. Retorna o conte�do do atributo Value de cada item
     * do controle Select.
     * 
     * @return String
     */
    public String getOptionValue() {
        return this.optionValue;
    }

    /**
     * M�todo setOptionValue. Define o conte�do do atributo Value de cada item
     * do controle Select.
     * 
     * @param idValue
     */
    public void setOptionValue(String idValue) {
        this.optionValue = idValue;
    }

    /**
     * M�todo getList. Retorna a lista de itens do controle Select.
     * 
     * @return BeanList
     */
    public BeanList getList() {
        return this.list;
    }

    /**
     * M�todo setList. Define a lista de itens do controle Select.
     * 
     * @param list
     */
    public void setList(BeanList list) {
        this.list = list;
    }

    /**
     * M�todo isMultiple. Retorna o atributo Multiple do controle Select.
     * 
     * @return boolean
     */
    public boolean isMultiple() {
        return multiple;
    }

    /**
     * M�todo setMultiple. Define o atributo Multiple do controle Select.
     * 
     * @param multiple
     */
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    /**
     * M�todo getSelectedList. Retorna lista dos itens selecionados no controle
     * Select.
     * 
     * @return BeanList
     */
    public BeanList getSelectedList() {
        return selectedList;
    }

    /**
     * M�todo getSelectedListValue. Retorna valores de identifica��o dos itens
     * selecionados no controle Select.
     * 
     * @return String
     */
    public String getSelectedListValue() {
        return selectedListValue;
    }

    /**
     * M�todo setSelectedList. Define lista dos itens selecionados no controle
     * Select.
     * 
     * @param selectedList
     */
    public void setSelectedList(BeanList selectedList) {
        this.selectedList = selectedList;
    }

    /**
     * M�todo setSelectedListValue. Define valores de identifica��o dos itens
     * selecionados no controle Select.
     * 
     * @param selectedListValue
     */
    public void setSelectedListValue(String selectedListValue) {
        this.selectedListValue = selectedListValue;
    }
}