package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag para mostrar Combo Espécie de Título
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboEspecieTitulo extends ComboTransacao {

    private String selectedValue = "0";

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String str) {
        selectedValue = str;
    }

    // Construtor
    public ComboEspecieTitulo() {
        this.setTransacao("BGN3");
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
                info.append("<option value='" + bean.getCodigo() + "'");
                if (this.getSelectedValue().equals(""
                                                   + bean.getCodigo()
                                                           .toString())) {
                    info.append(" selected");
                }
                info.append(">" + bean.getDescricao() + "</option>");

            }
        } catch (Exception exc) {
            LogUtilSigcb.error("Erro ComboEspecieTitulo");
        }
    }

}
