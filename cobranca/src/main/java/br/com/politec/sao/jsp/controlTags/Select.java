package br.com.politec.sao.jsp.controlTags;

import java.util.Iterator;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização do código HTML correspondente a um campo do tipo SELECT
 * (Combo ou Lista).
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class Select extends Control {
    /**
     * Armazena o conteúdo que será adicionado no evento onChange do Select.
     */
    private String onChange = "";

    /**
     * Armazena o conteúdo que será informado em cada item do Select.
     */
    private String optionLabel = "";

    /**
     * Armazena o atributo Value de cada item do Select.
     */
    private String optionValue = "";

    /**
     * Armazena os itens que deverão ser selecionados no Select.
     */
    private BeanList selectedList = null;

    /**
     * Armazena os valores de identificação dos itens que deverão ser
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
     * Método doStartTag. Renderiza a porção inicial do código da tag. Adiciona
     * na página o controle Select com seus atributos, eventos e ítens.
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
     * Método fillHeaderSelect. Adiciona o controle Select com seus atributos e
     * eventos na página.
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
     * Método fillOptions. Adiciona na página os itens do Select, também faz o
     * controle dos ítens que precisam ser selecionados no Select.
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
     * Método fillFooter. Insere a tag de fechamento do controle Select.
     * 
     * @param buffer
     */
    private void fillFooter(StringBuffer buffer) {
        buffer.append("</SELECT>");
    }

    /**
     * Método getOnChange. Retorna o conteúdo do evento onChange do controle
     * Select.
     * 
     * @return String
     */
    public String getOnChange() {
        return this.onChange;
    }

    /**
     * Método setOnChange. Define o conteúdo do evento onChange do controle
     * Select.
     * 
     * @param onChange
     */
    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    /**
     * Método getOptionLabel. Retorna o conteúdo que será informado em cada item
     * do controle Select.
     * 
     * @return String
     */
    public String getOptionLabel() {
        return this.optionLabel;
    }

    /**
     * Método setOptionLabel. Define o conteúdo que será informado em cada item
     * do controle Select.
     * 
     * @param optionLabel
     */
    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }

    /**
     * Método getOptionValue. Retorna o conteúdo do atributo Value de cada item
     * do controle Select.
     * 
     * @return String
     */
    public String getOptionValue() {
        return this.optionValue;
    }

    /**
     * Método setOptionValue. Define o conteúdo do atributo Value de cada item
     * do controle Select.
     * 
     * @param idValue
     */
    public void setOptionValue(String idValue) {
        this.optionValue = idValue;
    }

    /**
     * Método getList. Retorna a lista de itens do controle Select.
     * 
     * @return BeanList
     */
    public BeanList getList() {
        return this.list;
    }

    /**
     * Método setList. Define a lista de itens do controle Select.
     * 
     * @param list
     */
    public void setList(BeanList list) {
        this.list = list;
    }

    /**
     * Método isMultiple. Retorna o atributo Multiple do controle Select.
     * 
     * @return boolean
     */
    public boolean isMultiple() {
        return multiple;
    }

    /**
     * Método setMultiple. Define o atributo Multiple do controle Select.
     * 
     * @param multiple
     */
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    /**
     * Método getSelectedList. Retorna lista dos itens selecionados no controle
     * Select.
     * 
     * @return BeanList
     */
    public BeanList getSelectedList() {
        return selectedList;
    }

    /**
     * Método getSelectedListValue. Retorna valores de identificação dos itens
     * selecionados no controle Select.
     * 
     * @return String
     */
    public String getSelectedListValue() {
        return selectedListValue;
    }

    /**
     * Método setSelectedList. Define lista dos itens selecionados no controle
     * Select.
     * 
     * @param selectedList
     */
    public void setSelectedList(BeanList selectedList) {
        this.selectedList = selectedList;
    }

    /**
     * Método setSelectedListValue. Define valores de identificação dos itens
     * selecionados no controle Select.
     * 
     * @param selectedListValue
     */
    public void setSelectedListValue(String selectedListValue) {
        this.selectedListValue = selectedListValue;
    }
}