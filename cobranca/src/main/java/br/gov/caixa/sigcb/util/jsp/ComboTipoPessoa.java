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
public class ComboTipoPessoa extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("FISICA");

        listCodigos.add("2");
        listDescricoes.add("JURIDICA");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
