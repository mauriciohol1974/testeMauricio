package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade XXX FUNCIONALIDADE XXX
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboPeriodicidadeTarifas extends ComboTransacao {

    public ComboPeriodicidadeTarifas() {
        this.setTransacao("BGN2");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    /**
     * Método fillOptions. Adiciona na página os itens do Select, também faz o
     * controle dos ítens que precisam ser selecionados no Select.
     * 
     * @param buffer
     */
    protected void fillOptions(StringBuffer info) throws Exception {
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
                info.append("<option value='" + bean.getCodigoString() + "'");
                if (this.getSelectedValue().equals(bean.getCodigoString())) {
                    info.append(" selected");
                }
                info.append(">" + bean.getDescricao() + "</option>");
            }

        } catch (Exception exc) {
            LogUtilSigcb.error("Erro ComboPeriodicidadeTarifas");
            // exc.printStackTrace();
            throw exc;
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
    public String getDescricao(String codigo) throws JspException {
        String descricao = "";

        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                if (codigo.equals(bean.getCodigoString())) {
                    descricao = bean.getDescricao();
                    break;
                }
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboPeriodicidadeTarifas: Erro getDescricao: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }

        return descricao;
    }

}
