package br.com.politec.sao.business;

import java.io.Serializable;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que define uma extens�o para uma estrutura de dados tratada pela
 * framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Extension implements Serializable {
    /**
     * Method getType. Retorna o tipo de extens�o definida pelo objeto.
     * 
     * @return String Extens�o definida pelo objeto.
     */
    public abstract String getType();
}