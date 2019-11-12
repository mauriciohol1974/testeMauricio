package br.gov.caixa.sigcb.ejb.session;

import java.io.PrintStream;
import java.io.PrintWriter;

public class MainframeException extends Exception {

    private final Exception innerException;

    public MainframeException(Exception exc) {
        this.innerException = exc;
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
