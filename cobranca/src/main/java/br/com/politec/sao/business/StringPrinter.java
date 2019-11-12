package br.com.politec.sao.business;

import br.com.politec.sao.business.printer.BeanPrinter;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe utilizada para obter em forma de uma <code>String</code> o conte�do
 * de um objeto.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class StringPrinter extends BeanPrinter {
    /**
     * Buffer com os dados armazenados para resposta.
     */
    private final StringBuffer out;

    /**
     * Construtor defualt do objeto.
     */
    public StringPrinter() {
        this.out = new StringBuffer();
    }

    /**
     * M�todo doOnlyOne. Apenas uma propriedade para composi��o.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doOnlyOne(java.lang.Object)
     * @param obj
     *            <code>property_name => property_value</code> concatenado com
     *            os valores do objeto passado como par�metro.
     */
    protected void doOnlyOne(Object obj) {
        final String name = ((Property) obj).getName();
        this.out.append(name);
        this.out.append(" => ");
        this.out.append(getTransientBean().getPropertyValue(name));
    }

    /**
     * M�todo doFirst. Prepara a primeira propriedade.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doFirst(java.lang.Object)
     * @param obj
     *            chamada direta para <code>doOnlyOne</code> com o objeto
     *            passado como par�metro.
     */
    protected void doFirst(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * M�todo doEach. Concatena cada nova propriedade do objeto.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doEach(java.lang.Object)
     * @param obj
     *            Objeto com as propriedades.
     */
    protected void doEach(Object obj) {
        this.out.append(", ");
        doOnlyOne(obj);
    }

    /**
     * M�todo doLast. Concatena a �ltima propriedade do objeto.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doLast(java.lang.Object)
     * @param obj
     *            Objeto com as propriedades.
     */
    protected void doLast(Object obj) {
        doEach(obj);
    }

    /**
     * M�todo doBefore.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doBefore() Antes de come�ar
     *      a concatenar insere caracter <code>{</code> de �nicio.
     */
    protected void doBefore() {
        this.out.append("{");
    }

    /**
     * M�todo doAfter.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doAfter() Depois de
     *      terminar a concatenar insere o caracter <code>}</code> de fim.
     */
    protected void doAfter() {
        this.out.append("}: ");
        this.out.append(getTransientBean().getLayout().getName());
    }

    /**
     * M�todo getText. Retorna o conte�do do buffer interno.
     * 
     * @see br.com.politec.sao.business.printer.BeanPrinter#getText()
     * @return String com o conte�do do buffer interno.
     */
    public String getText() {
        return this.out.toString();
    }
}