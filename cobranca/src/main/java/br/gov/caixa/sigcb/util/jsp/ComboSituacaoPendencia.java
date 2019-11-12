package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo com valores fixos PV e EN
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 * @version release 1.0
 */
public class ComboSituacaoPendencia extends ComboFixo {

    /**
     * Construtor default.
     */
    public ComboSituacaoPendencia() {
    }

    /**
     * Método doStartTag. Renderiza a porção de código inicial da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("LIBERADAS");

        listCodigos.add("2");
        listDescricoes.add("NAO LIBERADAS");

        listCodigos.add("3");
        listDescricoes.add("TODAS");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();

    }

}
