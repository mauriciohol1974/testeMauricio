package br.com.politec.sao.business;

import java.util.TreeSet;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Define uma estrutura de dados vazia. Utilizada para composição de chamadas
 * que não requerem nenhum parâmetro de envio para obtenção de resposta.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Empty extends BusinessObject {
    /**
     * Define o layout do objeto.
     */
    private static final Layout layout = initLayout();

    /**
     * Method initLayout. Inicializa o layout como vazio.
     * 
     * @return Layout Retorna o layout definido como vazio.
     */
    private static Layout initLayout() {
        return new Layout(new TreeSet(), "Empty", "br.com.politec.sao.business");
    }

    /**
     * @see br.com.politec.sao.business.BusinessObject#getLayout()
     */
    public Layout getLayout() {
        return layout;
    }

    /**
     * @see br.com.politec.sao.business.BusinessObject#getApplicationName()
     */
    public String getApplicationName() {
        return "NONE";
    }
}