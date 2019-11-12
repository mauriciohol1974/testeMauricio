package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag para mostrar Combo de Aceite
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboAceite extends ComboTransacao {

    private String selectedValue = "0";

    /**
     * Filtra os itens para que só sejam exibidos os relativos a tela de Borderô
     */
    private boolean filtroBordero;

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String str) {
        selectedValue = str;
    }

    public ComboAceite() {
        this.setTransacao("BGN6");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    protected void fillOptions(StringBuffer info) {
        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            if (isBranco()) {
                info.append("<option value='-1'");
                if (this.getSelectedValue().equals("-1")) {
                    info.append(" selected");
                }
                info.append("> </option>");
            }

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                // Se for renderezar na tela de Borderô então somente listar COM
                // ACEITE e SEM ACEITE
                if ((!filtroBordero)
                    || (bean.getCodigoString().equals("1") || bean.getCodigoString()
                            .equals("2"))) {
                    info.append("<option value='"
                                + bean.getCodigoString()
                                + "'");
                    if (this.getSelectedValue().equals(""
                                                       + bean.getCodigoString()
                                                               .toString())) {
                        info.append(" selected");
                    }
                    info.append(">" + bean.getDescricao() + "</option>");
                }
            }
        } catch (Exception exc) {
            LogUtilSigcb.error("Erro ComboAceite");
        }
    }

    /**
     * Pega a descricao do codigo passado de uma transacao de combo
     * 
     * @param transacao -
     *            transacao de combo a ser obtida a descricao
     * @param codigo -
     *            codigo do combo cuja descricao eh desejada
     * @return Descricao do codigo pedido, se nao encontrar volta String vazia
     * @throws JspException
     */
    public String getDescricaoAceite(String aceite) throws JspException {
        String descricao = "";

        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                if (aceite.equals(bean.getCodigoString())) {
                    descricao = bean.getDescricao();
                    break;
                }
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboTransacao: Erro getDescricao: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }

        return descricao;
    }

    public void setFiltroBordero(boolean filtroBordero) {
        this.filtroBordero = filtroBordero;
    }
}
