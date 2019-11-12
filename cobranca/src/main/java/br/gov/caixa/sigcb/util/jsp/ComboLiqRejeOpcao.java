package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo Tipo Opcao da
 * tela de Filtro de Liquidacoes Rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class ComboLiqRejeOpcao extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        listCodigos.add("1");
        listDescricoes.add("PENDENCIAS EM ABERTO");

        listCodigos.add("2");
        listDescricoes.add("PENDENCIAS RECOMANDADAS");

        listCodigos.add("9");
        listDescricoes.add("PENDENCIAS RECOMANDADAS ESPECIAL");

        listCodigos.add("7");
        listDescricoes.add("PENDENCIAS ESTORNADAS");

        listCodigos.add("3");
        listDescricoes.add("PENDENCIAS EXCLUIDAS");

        listCodigos.add("4");
        listDescricoes.add("CONSULTAS RECOMANDOS PROCESSADOS");

        listCodigos.add("10");
        listDescricoes.add("CONSULTAS RECOMANDADAS ESPECIAIS PROCESSADAS");

        listCodigos.add("8");
        listDescricoes.add("CONSULTAS ESTORNOS PROCESSADOS");

        listCodigos.add("5");
        listDescricoes.add("CONSULTAS EXCLUIDAS PROCESSADAS");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
