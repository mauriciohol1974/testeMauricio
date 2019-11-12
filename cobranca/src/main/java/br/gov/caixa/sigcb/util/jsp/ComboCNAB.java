package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo CNAB - Usado PV
 * Cobrador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/04/2005</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboCNAB extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("CNAB400");

        listCodigos.add("2");
        listDescricoes.add("CNAB600");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(Long codigo) {
        if (new Long(1).equals(codigo)) {
            return "CNAB400";
        } else if (new Long(2).equals(codigo)) {
            return "CNAB600";
        }
        return "";
    }

}
