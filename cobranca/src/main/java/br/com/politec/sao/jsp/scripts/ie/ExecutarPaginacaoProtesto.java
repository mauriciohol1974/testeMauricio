package br.com.politec.sao.jsp.scripts.ie;

import java.util.StringTokenizer;

import br.com.politec.sao.jsp.scripts.Script;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o javascript para executar paginacao para Browsers Internet
 * Explorer.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class ExecutarPaginacaoProtesto extends Script {
    private String formName = "";

    private String fieldName = "";

    /**
     * Método getScript. Retorna um script que renderiza o javascript para
     * captura da tecla <i>Enter</i> para Browsers Internet Explorer.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaEnter.
     */
    public String getScript() {
        StringBuffer scr = new StringBuffer();
        scr.append("function executarPaginacaoProtesto(valor, pageName){\n");
        scr.append("  document."
                   + formName
                   + "."
                   + fieldName
                   + ".value = valor;\n");
        scr.append("  document." + formName + ".action = pageName + '.jsp';\n");
        scr.append("atualizaAlteracao('checkboxGrupo');\n");
        scr.append("  document." + formName + ".submit();\n");
        scr.append("}\n");
        return scr.toString();
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
    }

    /**
     * Método setControlName. Atribui à instância o nome de seu controle. Sem
     * implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        StringTokenizer tokenizer = new StringTokenizer(controlName, ";");

        switch (tokenizer.countTokens()) {
        case 2:
            this.formName = tokenizer.nextToken();
            this.fieldName = tokenizer.nextToken();
            break;
        case 1:
            this.formName = tokenizer.nextToken();
            LogUtilSigcb.warn("ExecutarPaginacaoProtesto: falta parametro de controle fieldName");
            break;
        case 0:
            LogUtilSigcb.warn("ExecutarPaginacaoProtesto: faltam parametros de controle formName e fieldName");
        }
    }
}
