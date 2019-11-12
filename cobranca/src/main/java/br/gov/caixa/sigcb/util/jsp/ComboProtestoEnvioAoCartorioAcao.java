package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo com valores fixos Envio Ao Cartório - Lista
 * 
 * @author Cristian Souza - Probank/REDEASP02
 * @version release 1.0
 */
public class ComboProtestoEnvioAoCartorioAcao extends ComboFixo {

    public int doStartTag() throws JspException {
        ArrayList listCodigos = new ArrayList();
        ArrayList listDescricoes = new ArrayList();
        
        //Não existe a opção ALTERAR

        listCodigos.add("1");
        listDescricoes.add("CONSULTAR");
        
        listCodigos.add("2");
        listDescricoes.add("INCLUIR");

        this.setListCodigo(listCodigos);
        this.setListDescricao(listDescricoes);

        return super.doStartTag();
    }

}
