package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Modalidade
 * Título (Borderô Online)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboModalidadeTitulo extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("REGISTRADO");

        listCodigos.add("2");
        listDescricoes.add("SEM REGISTRO");

        
        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(Long codigo) {
        if (new Long(1).equals(codigo)) {
            return "REGISTRADO";
        } else if (new Long(2).equals(codigo)) {
            return "SEM REGISTRO";
        } else if (new Long(3).equals(codigo)) {
            return "COBRANCA CAUCIONADA";
        }
        return "";
    }

}
