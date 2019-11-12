package br.com.politec.sao.jsp.controlTags;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tag de renderização de campos que permitam apenas a digitação de campos
 * numéricos.
 * 
 * @author ?????? - ?????@sao.politec.com.br
 * @version release 1.0
 */
public class InputDouble extends InputTypeText {

    public int precision = 3;

    /**
     * Construtor default.
     */
    public InputDouble() {
    }

    /**
     * Renderiza o código da tag.
     * 
     * @return int
     */
    public int doStartTag() {
        try {
            super.doStartTag();
            super.getScriptGenerator().addScript("ValidaDigitacaoNumerico",
                    this.getPath());
        } catch (Exception exc) {
            LogUtilSigcb.error("InputDouble: Erro na contrucao da Tag: "
                               + exc.getMessage(), exc);
            throw new Error("Erro na contrucao da Tag InputDouble.");
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Renderiza o código de controle da tag, para impedir a entrada de dados
     * indesejados durante a digitação.
     * 
     * @return String
     */
    public String getOnKeyPress() {
        return "return validaDigitacaoNumerico(String.fromCharCode(event.charCode || event.keyCode));";
    }

    /**
     * Renderiza o código de controle da tag, para formatar a entrada de dados.
     * 
     * @return String
     */
    public String getOnBlur() {
        return "formataValorDouble(this,"
               + this.getSize()
               + ","
               + this.precision
               + ");"
               + super.getOnBlur();
    }

    /**
     * Retorna o tamanho da mantissa a ser renderizada no campo ( número de
     * casas decimais ) após a vírgula.
     * 
     * @return int número de casas decimais
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * Define o tamanho da mantissa a ser renderizada no campo ( número de casas
     * decimais ) após a vírgula.
     * 
     * @param int
     *            número de casas decimais
     */
    public void setPrecision(int i) {
        precision = i;
    }

}