package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.estrategia.cedente.CedenteAlterarIniciar;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Nao eh um combo, gera um Array javascript Ver comentario do metodo doStartTag
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboRamoAtividade extends ComboTransacao {

    // Nome do array que sera montado pela tag
    private String nomeArray = "naturezasRamos";

    public ComboRamoAtividade() {
        this.setTransacao("BGNA");
    }

    public String getNomeArray() {
        return nomeArray;
    }

    public void setNomeArray(String string) {
        nomeArray = string;
    }

    /**
     * Método doStartTag. Esta tag gera um array para javascript no formato:
     * naturezasRamos[indice] = new Array(codigoNatureza, codigoRamo,
     * descricao);
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     * @throws JspException
     */
    public int doStartTag() throws JspException {
        try {
            ArrayList listaRamos = this.listaRamos();

            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < listaRamos.size(); i++) {
                ComboBean itemRamo = (ComboBean) listaRamos.get(i);
                buffer.append(this.getNomeArray());
                buffer.append("[" + i + "]");
                buffer.append(" = new Array('"
                              + itemRamo.getCodigoTipo()
                              + "', '"
                              + itemRamo.getCodigoTam4()
                              + "', '"
                              + itemRamo.getDescricao()
                              + "');");
                buffer.append("\n");
            }

            pageContext.getOut().print(buffer);

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboRamoAtividade: Erro na construcao da Tag: "
                               + ex.getMessage(),
                    ex);
            throw new JspException(ex.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    public ArrayList listaRamos() throws Exception {
        BeanList comboRamo = this.consultaTransacao(this.getTransacao());
        ArrayList listaRamos = new CedenteAlterarIniciar().convertDataStructure(comboRamo.iterator());
        Collections.sort(listaRamos, new RamoComparator());
        return listaRamos;
    }

    public String getDescricaoRamo(Long natureza, Long ramo)
            throws JspException {
        String descricao = "";

        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                if (natureza.equals(bean.getCodigoTipo())
                    && ramo.equals(bean.getCodigoTam4())) {
                    descricao = bean.getDescricao();
                    break;
                }
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboRamoAtividade: Erro getDescricao: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }

        return descricao;
    }

    // Usado na ordenacao do combo de ramo
    protected class RamoComparator implements Comparator {

        public int compare(Object o1, Object o2) throws NumberFormatException {
            ComboBean bean1 = (ComboBean) o1;
            ComboBean bean2 = (ComboBean) o2;

            Integer valor1 = new Integer(""
                                         + bean1.getCodigoTipo()
                                         + bean1.getCodigoTam4());
            Integer valor2 = new Integer(""
                                         + bean2.getCodigoTipo()
                                         + bean2.getCodigoTam4());

            return valor1.compareTo(valor2);
        }

    }

}
