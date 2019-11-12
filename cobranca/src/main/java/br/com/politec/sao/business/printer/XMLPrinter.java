package br.com.politec.sao.business.printer;

import br.com.politec.sao.business.Property;
import electric.xml.Document;
import electric.xml.Element;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que pode obter a definição de um Bean em um arquivo XML, padrão para a
 * geração destes componentes na estrutura da framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class XMLPrinter extends BeanPrinter {
    /**
     * Documento XML, que irá manter a representação do bean.
     */
    private final Document document;

    /**
     * Variável utilizada para manipulação dos <code>nós</code> do arquivo
     * XML.
     */
    private Element current;

    /**
     * Construtor default do objeto. Inicializa as variáveis globais com valores
     * default.
     */
    public XMLPrinter() {
        this.document = new Document();
        this.document.setRoot("Beans");
    }

    /**
     * Método doBefore.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doBefore() Antes de iniciar
     *      a composição da estrutura do bean, este método inicia a definição do
     *      XML.
     */
    protected synchronized void doBefore() {
        this.current = getDocument().getRoot().addElement("Bean");
        this.current.setAttribute("name", getTransientBean().getLayout()
                .getName());
    }

    /**
     * Método doOnlyOne.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doOnlyOne(java.lang.Object)
     *      Para inclusão de apenas um nó de propriedade no arquivo XML.
     * @param obj
     *            Objeto que contém o valor da propriedade.
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
     * Método doFirst.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doFirst(java.lang.Object)
     *      Para inclusão da primeira propriedade do bean no arquivo XML.
     * @param obj
     *            Objeto que contém o valor da propriedade.
     */
    protected void doFirst(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * Método doEach.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doEach(java.lang.Object)
     *      Para inclusão de qualquer propriedade do bean no arquivo XML.
     * @param obj
     *            Objeto que contém o valor da propriedade.
     */
    protected void doEach(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * Método doLast.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doLast(java.lang.Object)
     *      Para inclusão da última propriedade do bean no arquivo XML.
     * @param obj
     *            Objeto que contém o valor da propriedade.
     */
    protected void doLast(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * Método getDocument. Retorna o objeto que contém o arquivo XML formatado
     * com a estrutura do bean.
     * 
     * @return Documento XML.
     */
    public Document getDocument() {
        return this.document;
    }

    /**
     * Método getText.
     * 
     * @see br.com.politec.sao.business.printer.BeanPrinter#getText() Retorna a
     *      representação textual do documento XML.
     * @return Representação textual do documento XML.
     */
    public String getText() {
        return getDocument().toString();
    }
}