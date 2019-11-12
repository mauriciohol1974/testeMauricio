package br.gov.caixa.sigcb.util;

import java.io.PrintStream;
import java.io.PrintWriter;

import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe para tratamento de excessões geradas na aplicação SIGCB. Esta classe
 * pode encapsular uma excessao de origem e colocar a disposição do
 * desenvolvedor uma opção de erro com descrição mais amigável para o usuário
 * final.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/03/2003</DD>
 * </DL>
 * 
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data: 21/06/2004
 */
public class SigcbException extends Exception {

    private final Exception innerException;

    public SigcbException(Exception innerException) {
        Assertions.requires(innerException != null);
        this.innerException = innerException;
    }

    public String getMessage() {
        return this.innerException.getMessage();
    }

    public String getLocalizedMessage() {
        return this.innerException.getLocalizedMessage();
    }

    public String toString() {
        return this.innerException.toString();
    }

    public void printStackTrace() {
        this.innerException.printStackTrace();
    }

    public void printStackTrace(PrintStream stream) {
        this.innerException.printStackTrace(stream);
    }

    public void printStackTrace(PrintWriter writer) {
        this.innerException.printStackTrace(writer);
    }
}