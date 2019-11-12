package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo Combo (Tipo Atividade) usado em Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>03/01/2011</DD>
 * </DL>
 * 
 * autor: Adelaine Rondon - adelaine.rondon@probank.com.br
 */
public class ComboAtividade extends ComboFixo {
    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("SEGURADORA");

        listCodigos.add("2");
        listDescricoes.add("CORRETORA");
        
        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }
}
