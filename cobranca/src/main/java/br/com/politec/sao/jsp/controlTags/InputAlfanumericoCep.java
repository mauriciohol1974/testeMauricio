package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a entrada de dados
 * alfanuméricos, impedindo a digitação de caracteres especiais. Esta Tag
 * adiciona o script ValidaAlteracaoEndereco() no evento OnChage, para limpar o
 * CEP digitado em caso de alteração de endereço. Atenção, esta tag apenas pode
 * ser utilizada em conjunto com a tag InputCep e com a função de procurar CEP.
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class InputAlfanumericoCep extends InputAlfanumerico {
    /**
     * Construtor default.
     */
    public InputAlfanumericoCep() {
    }

    /**
     * Método doStartTag. Renderiza o código da tag.
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