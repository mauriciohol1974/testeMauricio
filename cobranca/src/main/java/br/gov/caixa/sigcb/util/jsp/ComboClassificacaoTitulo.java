package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */
public class ComboClassificacaoTitulo extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("NOSSO NUMERO");

        listCodigos.add("2");
        listDescricoes.add("DATA VENCIMENTO");

        listCodigos.add("3");
        listDescricoes.add("NOME SACADO");

        listCodigos.add("4");
        listDescricoes.add("DATA DE LIQUIDACAO");

        // Remvido por requisição da Jandira
        // listCodigos.add("5");
        // listDescricoes.add("DATA DE ULTIMO COMANDO");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}