package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

import br.gov.caixa.sigcb.estrategia.dda.DdaReimpBloquetoEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Combo - Tipo Bloqueto DDA
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/01/2010</DD>
 * </DL>
 * 
 * @author glauber.gallego@gmail.com
 */
public class ComboTipoBloquetoDda extends ComboFixo {
	
    public int doStartTag() throws JspException {

    	ArrayList listCodigos = new ArrayList();
    	ArrayList listDescricoes = new ArrayList();
    	
        listCodigos.add("1");
        listDescricoes.add(DdaReimpBloquetoEstrategia.MENSAGEM_TODOS);

        listCodigos.add("2");
        listDescricoes.add(DdaReimpBloquetoEstrategia.MENSAGEM_CAIXACOBREGISTRADO);

        listCodigos.add("3");
        listDescricoes.add(DdaReimpBloquetoEstrategia.MENSAGEM_CAIXAGCBREGISTRADO);

        listCodigos.add("4");
        listDescricoes.add(DdaReimpBloquetoEstrategia.MENSAGEM_CAIXACOBSEMREGISTRO);

        listCodigos.add("5");
        listDescricoes.add(DdaReimpBloquetoEstrategia.MENSAGEM_CAIXAGCBSEMREGISTRO);

        listCodigos.add("6");
        listDescricoes.add(DdaReimpBloquetoEstrategia.MENSAGEM_OUTROS);

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

    public static String getDescricao(String codigo) {
        if ("1".equals(codigo)) {
            return DdaReimpBloquetoEstrategia.MENSAGEM_TODOS;
        } else if ("2".equals(codigo)) {
            return DdaReimpBloquetoEstrategia.MENSAGEM_CAIXACOBREGISTRADO;
        } else if ("3".equals(codigo)) {
            return DdaReimpBloquetoEstrategia.MENSAGEM_CAIXAGCBREGISTRADO;
        } else if ("4".equals(codigo)) {
            return DdaReimpBloquetoEstrategia.MENSAGEM_CAIXACOBSEMREGISTRO;
        } else if ("5".equals(codigo)) {
            return DdaReimpBloquetoEstrategia.MENSAGEM_CAIXAGCBSEMREGISTRO;
        } else if ("6".equals(codigo)) {
            return DdaReimpBloquetoEstrategia.MENSAGEM_OUTROS;
        }
        return "";
    }
}
