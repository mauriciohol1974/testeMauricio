package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * @author Vcastaldelli
 * @author Eduardo A. Moras - emoras@sao.politec.com.br - Inclus�o dos Scripts
 *         FormataCpfCnpj e ValidaDvCpfCnpj Created on 31/08/2004 To change the
 *         template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class InputCpfCnpj extends InputTypeText {

    /**
     * Construtor padr�o (sem Parametros)
     */
    public InputCpfCnpj() {
    }

    /**
     * M�todo doStartTag. Renderiza o c�digo da tag. Adiciona os scripts
     * ValidaDigitacaoNumericoInteiro, FormataCPF,FormataCNPJ, ValidaDVCPF e
     * ValidaDVCpfCnpj.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator()
                    .addScript("ValidaDigitacaoNumericoInteiro", this.getPath());
            super.getScriptGenerator().addScript("FormataCPF", this.getPath());
            super.getScriptGenerator().addScript("FormataCNPJ", this.getPath());
            super.getScriptGenerator().addScript("ValidaDVCPF", this.getPath());
            super.getScriptGenerator()
                    .addScript("ValidaDVCNPJ", this.getPath());
            super.getScriptGenerator().addScript("FormataCpfCnpj",
                    this.getPath());
            super.getScriptGenerator().addScript("ValidaDVCpfCnpj",
                    this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputCpfCnpj: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputCpfCnpj.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getSize. Retorna o tamanho do campo na p�gina.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getSize()
     * @return int
     */
    public int getSize() {
        return 22;
    }

    /**
     * M�todo getMaxlength. Retorna a capacidade m�xima do campo, ou seja, o
     * tamanho, em caracteres, do maior texto que pode ser digitado neste campo.
     * 
     * @see br.com.politec.sao.jsp.controlTags.InputTypeText#getMaxlength()
     * @return int
     */
    public int getMaxlength() {
        return 14;
    }

    /**
     * M�todo getOnKeyPress. Renderiza o c�digo de controle da tag, para
     * permitir somente digita��o de n�meros inteiros.
     * 
     * @see br.com.politec.sao.jsp.Control#getOnKeyPress()
     * @return String - Chamada do script ValidaDigitacaoNumericoInteiro.
     */
    public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoNumericoInteiro", this.getPath());
    }

}
