package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo
 * Solicitacao/Agendamento (Banco de Sacados)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class ComboSolicitacaoAgendamento extends ComboFixo {

    // Adiciona a opção todos no combo
    private boolean todos = false;

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();

        if (isTodos()) {
            listCodigos.add("0");
            listDescricoes.add("TODOS");
        }

        listCodigos.add("6");
        listDescricoes.add("SOLICITACAO");

        listCodigos.add("7");
        listDescricoes.add("AGENDAMENTO");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public void setTodos(boolean todos) {
        this.todos = todos;
    }

    public boolean isTodos() {
        return todos;
    }
}
