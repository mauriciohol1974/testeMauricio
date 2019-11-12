package br.com.politec.sao.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class WrappingException extends RuntimeException {
    private final Exception innerException;

    public WrappingException(Exception innerException) {
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