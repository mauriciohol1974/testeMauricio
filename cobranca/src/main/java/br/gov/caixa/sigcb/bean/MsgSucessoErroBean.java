package br.gov.caixa.sigcb.bean;

import java.io.Serializable;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente JavaBean utilizado para ancapsular o armazenamento de dados para
 * controle dentro de uma funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>25/08/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class MsgSucessoErroBean implements Serializable {

    /**
     * Variável que armazena o nome da estrategia a ser chamada em caso tela de
     * sucesso
     */
    private String strategySucessReturn;

    /**
     * Variável que armazena o nome da estrategia a ser chamada em caso tela de
     * erro
     */
    private String strategyErrorReturn;

    /**
     * Variavel que identifica o titulo de uma pagina de erro ou de sucesso
     */
    private String titlePage;

    /**
     * Variavel que identifica a mensagem de erro a ser demonstrada na tela
     */
    private String msgError;

    /**
     * Variavel que identifica a mensagem de sucesso a ser demonstrada na tela
     */
    private String msgSucess;

    public MsgSucessoErroBean() {
        // Configuração Padrão
        this.strategySucessReturn = "login.PaginaPrincipal";
        this.strategyErrorReturn = "login.PaginaPrincipal";
        this.titlePage = "Título da página não definido";
        this.msgError = "Descrição de erro não disponível";
        this.msgSucess = "Operação Realizada com Sucesso!";
    }

    /**
     * @return msgError
     */
    public String getMsgError() {
        return msgError;
    }

    /**
     * @return msgSucess
     */
    public String getMsgSucess() {
        return msgSucess;
    }

    /**
     * @return strategySucessReturn
     */
    public String getStrategySucessReturn() {
        return strategySucessReturn;
    }

    /**
     * @return titlePage
     */
    public String getTitlePage() {
        return titlePage;
    }

    /**
     * @param string
     */
    public void setMsgError(String string) {
        msgError = string;
    }

    /**
     * @param string
     */
    public void setMsgSucess(String string) {
        msgSucess = string;
    }

    /**
     * @param string
     */
    public void setStrategySucessReturn(String string) {
        strategySucessReturn = string;
    }

    /**
     * @param string
     */
    public void setTitlePage(String string) {
        titlePage = string;
    }

    /**
     * @return strategyErrorReturn
     */
    public String getStrategyErrorReturn() {
        return strategyErrorReturn;
    }

    /**
     * @param string
     */
    public void setStrategyErrorReturn(String string) {
        strategyErrorReturn = string;
    }

}