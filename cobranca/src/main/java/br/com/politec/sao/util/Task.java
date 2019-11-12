package br.com.politec.sao.util;

public interface Task {
    public void run() throws Exception;

    public void handleException(Exception exc);
}
