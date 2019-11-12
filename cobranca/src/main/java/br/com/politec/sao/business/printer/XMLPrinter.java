package br.com.politec.sao.business.printer;

import br.com.politec.sao.business.Property;
import electric.xml.Document;
import electric.xml.Element;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que pode obter a defini��o de um Bean em um arquivo XML, padr�o para a
 * gera��o destes componentes na estrutura da framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class XMLPrinter extends BeanPrinter {
    /**
     * Documento XML, que ir� manter a representa��o do bean.
     */
    private final Document document;

    /**
     * Vari�vel utilizada para manipula��o dos <code>n�s</code> do arquivo
     * XML.
     */
    private Element current;

    /**
     * Construtor default do objeto. Inicializa as vari�veis globais com valores
     * default.
     */
    public XMLPrinter() {
        this.document = new Document();
        this.document.setRoot("Beans");
    }

    /**
     * M�todo doBefore.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doBefore() Antes de iniciar
     *      a composi��o da estrutura do bean, este m�todo inicia a defini��o do
     *      XML.
     */
    protected synchronized void doBefore() {
        this.current = getDocument().getRoot().addElement("Bean");
        this.current.setAttribute("name", getTransientBean().getLayout()
                .getName());
    }

    /**
     * M�todo doOnlyOne.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doOnlyOne(java.lang.Object)
     *      Para inclus�o de apenas um n� de propriedade no arquivo XML.
     * @param obj
     *            Objeto que cont�m o valor da propriedade.
     */
    protected void doOnlyOne(Object obj) {
        final Property property = (Property) obj;
        final String name = property.getName();
        final String value = getTransientBean().getFormattedValue(name);
        if (value != null) {
            final Element bean = this.current.addElement("Property");
            bean.setAttribute("name", name);
            bean.addText(value.trim());
        }
    }

    /**
     * M�todo doFirst.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doFirst(java.lang.Object)
     *      Para inclus�o da primeira propriedade do bean no arquivo XML.
     * @param obj
     *            Objeto que cont�m o valor da propriedade.
     */
    protected void doFirst(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * M�todo doEach.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doEach(java.lang.Object)
     *      Para inclus�o de qualquer propriedade do bean no arquivo XML.
     * @param obj
     *            Objeto que cont�m o valor da propriedade.
     */
    protected void doEach(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * M�todo doLast.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doLast(java.lang.Object)
     *      Para inclus�o da �ltima propriedade do bean no arquivo XML.
     * @param obj
     *            Objeto que cont�m o valor da propriedade.
     */
    protected void doLast(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * M�todo getDocument. Retorna o objeto que cont�m o arquivo XML formatado
     * com a estrutura do bean.
     * 
     * @return Documento XML.
     */
    public Document getDocument() {
        return this.document;
    }

    /**
     * M�todo getText.
     * 
     * @see br.com.politec.sao.business.printer.BeanPrinter#getText() Retorna a
     *      representa��o textual do documento XML.
     * @return Representa��o textual do documento XML.
     */
    public String getText() {
        return getDocument().toString();
    }
}