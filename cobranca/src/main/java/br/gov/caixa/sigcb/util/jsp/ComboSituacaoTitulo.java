package br.gov.caixa.sigcb.util.jsp;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade do combo de situação
 * do título
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

// Utilizar esta rotina quando o banco estiver funcionando
public class ComboSituacaoTitulo extends ComboTransacao {

    public ComboSituacaoTitulo() {
        this.setTransacao("BGN4");
    }

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }
}

/*
 * public class ComboSituacaoTitulo extends ComboFixo { public int doStartTag() {
 * ArrayList listCodigos = new ArrayList(); ArrayList listDescricoes = new
 * ArrayList(); listCodigos.add("1"); listDescricoes.add("EM ABERTO");
 * listCodigos.add("2"); listDescricoes.add("LIQUIDADO PV");
 * listCodigos.add("3"); listDescricoes.add("LIQUIDADO CARTORIO");
 * listCodigos.add("4"); listDescricoes.add("BAIXA POR ESTORNO");
 * listCodigos.add("5"); listDescricoes.add("BAIXA POR DEVOLUÇÃO");
 * listCodigos.add("6"); listDescricoes.add("BAIXA POR PROTESTO");
 * listCodigos.add("7"); listDescricoes.add("ENVIADO A CARTORIO");
 * listCodigos.add("8"); listDescricoes.add("SUSTADO CARTORIO");
 * listCodigos.add("20"); listDescricoes.add("VENCIDOS"); listCodigos.add("21");
 * listDescricoes.add("VENCIDOS MAIS DE 30 DIAS"); listCodigos.add("99");
 * listDescricoes.add("CONSOLIDADO"); this.setListCodigo(listCodigos);
 * this.setListDescricao(listDescricoes); return super.doStartTag(); } }
 */