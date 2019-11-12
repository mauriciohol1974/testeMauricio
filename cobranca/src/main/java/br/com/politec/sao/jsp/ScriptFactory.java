package br.com.politec.sao.jsp;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe abstrata, definidora da interface padr�o para a implementa��o de
 * classes de gera��o de scripts para os diferentes browsers e tags.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public abstract class ScriptFactory {
    /**
     * Construtor default.
     */
    public ScriptFactory() {
    }

    /**
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public abstract String getOnKeyPress(String functionName, String controlName);

    /**
     * M�todo getScript. Retorna o c�digo a ser renderizado.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public abstract String getScript(String functionName, String controlName);

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public abstract String getOnBlur(String functionName, String controlName);

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>.
     * 
     * @param functionName
     * @param controlName
     * @return String
     */
    public abstract String getOnFocus(String functionName, String controlName);
}
