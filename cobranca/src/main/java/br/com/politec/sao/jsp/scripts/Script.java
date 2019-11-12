package br.com.politec.sao.jsp.scripts;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe abstrata de definição da interface comum de todas as classes de
 * implementação de scripts para as tags.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public abstract class Script {
    /**
     * Método getScript. Retorna o código do script.
     * 
     * @return String
     */
    public abstract String getScript();

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @return String
     */
    public abstract String getOnKeyPress();

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @return String
     */
    public abstract String getOnBlur();

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @return String
     */
    public abstract String getOnFocus();

    /**
     * Método setControlName. Atribui à instância o nome de seu controle.
     * 
     * @param controlName
     */
    public abstract void setControlName(String controlName);
}
