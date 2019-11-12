package br.gov.caixa.sigcb.util;

import java.io.Serializable;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe que mant�m os paths da aplica��o SIGCB nos servires WEB e de
 * Aplica��es.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data: 21/06/2004
 * @version release 1.0
 */
public abstract class Paths implements Serializable {
    /**
     * Method getRootAppName. Retorna o nome raiz de acesso da aplicacao.
     * 
     * @return String "/NASApp".
     */
    public static String getRootAppName() {
        return ("/cobranca");
    }

    /**
     * Method getSystemName. Retorna o nome (sigla) do sistema.
     * 
     * @return String "sigcb".
     */
    public static String getSystemName() {
        return ("cobranca");
    }

    /**
     * Method getRootForDynamicContent. Retorna o path para qualquer conte�do
     * mantido no servidor de aplica��es. Atualmente o servidor utilizado � o
     * iPlanet.
     * 
     * @return String "/NASApp/sigcb".
     */
    public static String getRootForDynamicContent() {
        // return (getRootAppName() + "/" + getSystemName());
        return (getRootAppName());
    }

    /**
     * Method getRootForStaticContent. Retorna o path para qualquer conte�do
     * mantido no servidor WEB.
     * 
     * @return String "/sigcb".
     */
    public static String getRootForStaticContent() {
        return ("/" + getSystemName() + "static");
    }

    /**
     * Mant�m a raiz do pacote de estrat�gias de processamento do sistema.
     * 
     * @see br.com.politec.sao.controlStrategy.ControlServlet#getRootPackageStrategies()
     */
    public static String getRootPackageTransaction() {
        return "br.gov.caixa.sigcb.transaction";
    }

    /**
     * Method getImagePath. Retorna o path para o conte�do imagem mantido no
     * servidor WEB.
     * 
     * @return String "/sigcb/imagens/diversos".
     */
    public static String getImagePath() {
        return (getRootForStaticContent() + "/imagens/diversos");
    }
}