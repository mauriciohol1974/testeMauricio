package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;


public class ComboServicoTarifa extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("TARIFA MANUAL");

        listCodigos.add("2");
        listDescricoes.add("REINSTALA��O DE APLICATIVO PONTA CLIENTE");
        

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }
    //Retirar esse c�digo
    /*public static String getDescricao(Long codigo) {
        if (new Long(1).equals(codigo)) {
            return "TARIFA MANUAL";
        } else if (new Long(2).equals(codigo)) {
            return "REINSTALA��O DE APLICATIVO PONTA CLIENTE";
        } 
        return "";
    }*/

}
