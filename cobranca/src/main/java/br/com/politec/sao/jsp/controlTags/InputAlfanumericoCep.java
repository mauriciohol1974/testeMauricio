package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderiza��o de campos que permitam apenas a entrada de dados
 * alfanum�ricos, impedindo a digita��o de caracteres especiais. Esta Tag
 * adiciona o script ValidaAlteracaoEndereco() no evento OnChage, para limpar o
 * CEP digitado em caso de altera��o de endere�o. Aten��o, esta tag apenas pode
 * ser utilizada em conjunto com a tag InputCep e com a fun��o de procurar CEP.
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class InputAlfanumericoCep extends InputAlfanumerico {
    /**
     * Construtor default.
     */
    public InputAlfanumericoCep() {
    }

    /**
     * M�todo doStartTag. Renderiza o c�digo da tag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.setOnChange("javascript:validaAlteracaoEndereco()");
            super.doStartTag();
            super.getScriptGenerator().addScript("ValidaAlteracaoEndereco",
                    this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputAlfanumericoCep: Erro na contrucao da Tag: "
                               + exc.getMessage(),
                    exc);
            throw new Error("Erro na contrucao da Tag InputAlfanumericoCep.");
        }
        return EVAL_BODY_INCLUDE;
    }
}