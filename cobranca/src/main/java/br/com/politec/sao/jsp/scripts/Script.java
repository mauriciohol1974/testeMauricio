package br.com.politec.sao.jsp.scripts;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe abstrata de defini��o da interface comum de todas as classes de
 * implementa��o de scripts para as tags.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public abstract class Script {
    /**
     * M�todo getScript. Retorna o c�digo do script.
     * 
     * @return String
     */
    public abstract String getScript();

    /**
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @return String
     */
    public abstract String getOnKeyPress();

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @return String
     */
    public abstract String getOnBlur();

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @return String
     */
    public abstract String getOnFocus();

    /**
     * M�todo setControlName. Atribui � inst�ncia o nome de seu controle.
     * 
     * @param controlName
     */
    public abstract void setControlName(String controlName);
}
