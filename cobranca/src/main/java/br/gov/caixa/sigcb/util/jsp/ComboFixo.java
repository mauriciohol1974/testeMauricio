package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.jsp.controlTags.Select;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Superclasse para Tag de renderização de Combo para valores fixos
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 * @version release 1.1
 */
public abstract class ComboFixo extends Select {

    // valor que comeca selecionado
    private String selectedValue = "";

    // Indica se existe uma primeira opcao em branco
    // O option tem value 0
    private boolean branco = false;

    // Valor da opcao em branco: default -1
    private String brancoValue = "-1";

    private ArrayList listDescricao = new ArrayList();

    private ArrayList listCodigo = new ArrayList();

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String value) {
        selectedValue = value;
    }

    public String getBrancoValue() {
        return brancoValue;
    }

    public void setBrancoValue(String string) {
        brancoValue = string;
    }

    protected ArrayList getListDescricao() {
        return listDescricao;
    }

    protected ArrayList getListCodigo() {
        return listCodigo;
    }

    protected void setListDescricao(ArrayList list) {
        listDescricao = list;
    }

    protected void setListCodigo(ArrayList list) {
        listCodigo = list;
    }

    public boolean isBranco() {
        return branco;
    }

    public void setBranco(boolean b) {
        branco = b;
    }

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
            fillOptions(buffer);
            fillFooter(buffer);
            // LogUtilSigcb.debug(buffer.toString());
            pageContext.getOut().print(buffer.toString());
        } catch (Exception ex) {
            LogUtilSigcb.error("ComboFixo: Erro na contrucao da Tag: "
                               + ex.getMessage(), ex);
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
                      + (isMultiple() ? " multiple " : "")
                      + super.getOnFocus()
                      + "'"
                      + " ONFOCUS='"
                      + getOnFocus()
                      + "' "
                      + (getDisabled().equals("true") ? "disabled" : "")
                      + ">");

        // LogUtilSigcb.debug("------>getDisabled() = " + getDisabled());
    }

    /**
     * Método fillOptions. Adiciona na página os itens do Select, também faz o
     * controle dos ítens que precisam ser selecionados no Select.
     * 
     * @param buffer
     * @throws JspException
     */
    private void fillOptions(StringBuffer info) throws JspException {
        try {
            ArrayList listDescricao = this.getListDescricao();
            ArrayList listCodigo = this.getListCodigo();

            if (isBranco()) {
                info.append("<option value='" + this.getBrancoValue() + "'");
                if (this.getSelectedValue().equals(this.getBrancoValue())) {
                    info.append(" selected");
                }
                info.append("> </option>");
            }

            if (listDescricao.size() == listCodigo.size()) {
                for (int i = 0; i < listDescricao.size(); i++) {
                    String codigo = (String) listCodigo.get(i);
                    String descricao = (String) listDescricao.get(i);

                    info.append("<option value='" + codigo + "'");
                    if (codigo.equals(this.getSelectedValue())) {
                        info.append(" selected");
                    }
                    info.append(">" + descricao + "</option>");
                }
            } else {
                LogUtilSigcb.warn("ARRAYLISTS NAO TEM TAMANHO IGUAL: "
                                  + this.getClass().getName());
            }

        } catch (Exception exc) {
            LogUtilSigcb.error("ComboFixo: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new JspException(exc.getMessage());
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
     * Método doEndTag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        return SKIP_BODY;
    }

}