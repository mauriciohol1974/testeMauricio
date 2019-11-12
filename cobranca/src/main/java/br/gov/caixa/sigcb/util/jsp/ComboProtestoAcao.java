package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo com valores fixos Serviços de titulo
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @version release 1.0
 */
public class ComboProtestoAcao extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("ENVIO AO CARTORIO");

        listCodigos.add("2");
        listDescricoes.add("SUSTACAO DE PROTESTO");

        listCodigos.add("3");
        listDescricoes.add("ESTORNO ENVIO/SUSTACAO");

        listCodigos.add("4");
        listDescricoes.add("DEBITO CUSTAS CARTORARIAS - POS COMANDO");
        
        //Novo item com código 19
        listCodigos.add("19");
        listDescricoes.add("DEBITO CUSTAS/DESPESAS CARTORARIAS - PROTESTO CENTRALIZADO");

        listCodigos.add("5");
        listDescricoes.add("IMPRESSAO DE 2. VIA ORDEM DE PROTESTO");

        listCodigos.add("6");
        listDescricoes.add("SUSPENDER ENVIO AO CARTORIO");

        listCodigos.add("7");
        listDescricoes.add("INCLUIR TITULO NA REMESSA");

        listCodigos.add("8");
        listDescricoes.add("BAIXA POR PROTESTO");

        listCodigos.add("9");
        listDescricoes.add("LIQUIDADO EM CARTORIO");

        listCodigos.add("10");
        listDescricoes.add("LIQUIDADO EM CARTORIO CONDICIONAL");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
