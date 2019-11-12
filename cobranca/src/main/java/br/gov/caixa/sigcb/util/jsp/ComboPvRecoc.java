package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo com valores fixos PV e RSRET
 * 
 * @author Eduardo A.Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ComboPvRecoc extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("PV");

        listCodigos.add("2");
        listDescricoes.add("RSRET");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}