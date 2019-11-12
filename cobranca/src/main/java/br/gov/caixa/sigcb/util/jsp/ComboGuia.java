package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Guia (Consulta
 * Historico de Cedentes)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboGuia extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("GERAL");

        listCodigos.add("2");
        listDescricoes.add("FLOAT");

        listCodigos.add("3");
        listDescricoes.add("CONTAS");

        listCodigos.add("4");
        listDescricoes.add("CEDENTE ELETRONICO");

        listCodigos.add("5");
        listDescricoes.add("BLOQUETOS");

        listCodigos.add("6");
        listDescricoes.add("MENSAGENS");

        listCodigos.add("7");
        listDescricoes.add("TARIFAS");
        
        listCodigos.add("8");
        listDescricoes.add("PARÂMETROS");

        listCodigos.add("9");
        listDescricoes.add("TODAS");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
