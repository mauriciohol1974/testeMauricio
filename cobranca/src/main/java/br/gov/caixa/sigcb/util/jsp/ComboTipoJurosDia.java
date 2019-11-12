package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag para mostrar Combo Tipo de Juros Dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboTipoJurosDia extends ComboTransacao {

    private String selectedValue = "0";

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String str) {
        selectedValue = str;
    }

    public ComboTipoJurosDia() {
        this.setTransacao("BGN7");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    protected void fillOptions(StringBuffer info) {
        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            if (isBranco()) {
                info.append("<option value='" + this.getBrancoValue() + "'");
                if (this.getSelectedValue().equals(this.getBrancoValue())) {
                    info.append(" selected");
                }
                info.append("> </option>");
            }

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                info.append("<option value='" + bean.getCodigoLong() + "'");
                if (this.getSelectedValue().equals(""
                                                   + bean.getCodigoLong()
                                                           .toString())) {
                    info.append(" selected");
                }
                info.append(">" + bean.getDescricao() + "</option>");

            }
        } catch (Exception exc) {
            LogUtilSigcb.error("Erro ComboTipoJurosDia");
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
    public String getDescricao(Long codigo) throws JspException {
        String descricao = "";

        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                if (codigo.equals(bean.getCodigoLong())) {
                    descricao = bean.getDescricao();
                    break;
                }
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboJurosDia: Erro getDescricao: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }

        return descricao;
    }

}
