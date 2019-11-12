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
public class ComboUf extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("AC");
        listDescricoes.add("AC");
        listCodigos.add("AL");
        listDescricoes.add("AL");
        listCodigos.add("AM");
        listDescricoes.add("AM");
        listCodigos.add("AP");
        listDescricoes.add("AP");
        listCodigos.add("BA");
        listDescricoes.add("BA");
        listCodigos.add("CE");
        listDescricoes.add("CE");
        listCodigos.add("DF");
        listDescricoes.add("DF");
        listCodigos.add("ES");
        listDescricoes.add("ES");
        listCodigos.add("GO");
        listDescricoes.add("GO");
        listCodigos.add("MA");
        listDescricoes.add("MA");
        listCodigos.add("MG");
        listDescricoes.add("MG");
        listCodigos.add("MS");
        listDescricoes.add("MS");
        listCodigos.add("MT");
        listDescricoes.add("MT");
        listCodigos.add("PA");
        listDescricoes.add("PA");
        listCodigos.add("PB");
        listDescricoes.add("PB");
        listCodigos.add("PE");
        listDescricoes.add("PE");
        listCodigos.add("PI");
        listDescricoes.add("PI");
        listCodigos.add("PR");
        listDescricoes.add("PR");
        listCodigos.add("RJ");
        listDescricoes.add("RJ");
        listCodigos.add("RN");
        listDescricoes.add("RN");
        listCodigos.add("RO");
        listDescricoes.add("RO");
        listCodigos.add("RR");
        listDescricoes.add("RR");
        listCodigos.add("RS");
        listDescricoes.add("RS");
        listCodigos.add("SC");
        listDescricoes.add("SC");
        listCodigos.add("SE");
        listDescricoes.add("SE");
        listCodigos.add("SP");
        listDescricoes.add("SP");
        listCodigos.add("TO");
        listDescricoes.add("TO");
        // listDescricoes.addAll(listCodigos);

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}