package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Combo Tipo Opcao da
 * tela de Filtro de Liquidacoes Rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboMotivo extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("MOEDA INV�LIDA");

        listCodigos.add("2");
        listDescricoes.add("DIVERG�NCIA NO VALOR RECEBIDO");

        listCodigos.add("3");
        listDescricoes.add("RECEBIMENTO EFETUADO FORA DO PRAZO");

        listCodigos.add("4");
        listDescricoes.add("APRESENTA��O INDEVIDA");

        listCodigos.add("5");
        listDescricoes.add("REGISTRO INCONSITENTE");

        listCodigos.add("6");
        listDescricoes.add("DEVOLU��O DE CHEQUE PELA COMPENSA��O");

        listCodigos.add("7");
        listDescricoes.add("DUPLICIDADE DE MOVIMENTO");

        listCodigos.add("8");
        listDescricoes.add("ERRO OPERACIONAL");

        listCodigos.add("9");
        listDescricoes.add("ESTORNO INDEVIDO");
        
        listCodigos.add("10");
        listDescricoes.add("OUTROS");


        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
