package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag para mostrar Envio de Bloqueto
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboEnvioBloqueto extends ComboTransacao {

    private String selectedValue = "0";

    // Codigo para filtrar a resposta da transacao
    // default: 3 - Tipo Entrega Bloqueto
    private int codigo = 3;

    /*
     * Indica se o combo será renderizado na situação de Extrato ou não. Caso
     * positivo A opção "Correio" não pode ser exibida
     */
    private boolean extrato;

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String str) {
        selectedValue = str;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int i) {
        codigo = i;
    }

    // Construtor
    public ComboEnvioBloqueto() {
        this.setTransacao("BGN8");
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
                if (bean.getCodigo().equals(new Long(this.getCodigo()))) {
                    if ((!extrato) || (extrato && bean.getCodigoTipo() != 1)) {
                        info.append("<option value='"
                                    + bean.getCodigoTipo()
                                    + "'");
                        if (this.getSelectedValue()
                                .equals("" + bean.getCodigoTipo().longValue())) {
                            info.append(" selected");
                        }
                        info.append(">" + bean.getDescricao() + "</option>");
                    }
                }
            }
        } catch (Exception exc) {
            LogUtilSigcb.error("Erro ComboEnvioBloqueto");
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
    protected String getDescricaoEnvio(Long codigo) throws JspException {
        String descricao = "";

        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                if (bean.getCodigo().equals(new Long(this.getCodigo()))) {
                    if (bean.getCodigoTipo().equals(codigo)) {
                        descricao = bean.getDescricao();
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboEnvioBloqueto: Erro getDescricao: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }

        return descricao;
    }

    public String getDescricaoExtrato(Long codigo) throws JspException {
        this.setCodigo(2); // 2 - Extrato
        return this.getDescricaoEnvio(codigo);
    }

    public String getDescricaoBloqueto(Long codigo) throws JspException {
        this.setCodigo(3); // 3 - Bloqueto
        return this.getDescricaoEnvio(codigo);
    }

    public void setExtrato(boolean extrato) {
        this.extrato = extrato;
    }
}
