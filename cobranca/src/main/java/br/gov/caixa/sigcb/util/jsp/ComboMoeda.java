package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Moeda
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboMoeda extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("9");
        listDescricoes.add("REAL");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
