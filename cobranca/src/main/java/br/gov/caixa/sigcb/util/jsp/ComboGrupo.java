package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.AgrupamentoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Grupo -
 * Utilizado em Cedente na Guia Tarifas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboGrupo extends ComboTransacao {

    public int doStartTag() throws JspException {
        this.setTransacao("BGK0");
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
            // Transacao nao esta no cache, nao usa ComboBean
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        	 MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            AgrupamentoBean agrupBean = new AgrupamentoBean();
            agrupBean.setCodigoAgrupamento("");
            BeanList agrupBeanList = handler.executeSimpleTransactionQuery(agrupBean,
                    this.getTransacao());

            if (isBranco()) {
                info.append("<option value='" + this.getBrancoValue() + "'");
                if (this.getSelectedValue().equals(this.getBrancoValue())) {
                    info.append(" selected");
                }
                info.append("> </option>");
            }

            for (int i = 0; i < agrupBeanList.size(); i++) {
                AgrupamentoBean bean = (AgrupamentoBean) agrupBeanList.get(i);
                info.append("<option value='"
                            + bean.getCodigoAgrupamento()
                            + "'");
                if (this.getSelectedValue().equals(bean.getCodigoAgrupamento())) {
                    info.append(" selected");
                }
                info.append(">" + bean.getDescricaoAgrupamento() + "</option>");
            }

        } catch (Exception exc) {
            LogUtilSigcb.error("Erro ComboGrupo");
            // exc.printStackTrace();
            throw exc;
        }
    }

}
