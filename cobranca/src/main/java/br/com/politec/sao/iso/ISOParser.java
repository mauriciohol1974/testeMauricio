package br.com.politec.sao.iso;

import java.util.Iterator;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Parser;
import br.com.politec.sao.util.SubstringTokenizer;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa��o f�sica do parser de objetos de neg�cio a partir de mensagens
 * ISO. Utiliza as defini��es de layout e extens�o mainframe, para a partir de
 * uma String de formato ISO instanciar objetos de neg�cio suportados pela
 * framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOParser extends Parser {
    /**
     * Objeto que representa a extens�o de dados utilizada pelo objeto de
     * neg�cio.
     */
    private final MainframeExtension extension;

    /**
     * Construtor default do objeto.
     * 
     * @param prototype
     *            Objeto de neg�cio do tipo tratado pelo parsing.
     * @param fields
     *            Lista dos campos, contidos na mensagem ISO para parsing.
     */
    public ISOParser(BusinessObject prototype,
            String[] fields) {
        super(prototype, fields);
        this.extension = (MainframeExtension) getPrototype().getExtension("Mainframe");
    }

    /**
     * Construtor secund�rio, baseado apenas no tipo a ser tratado. Neste caso �
     * assumido que todos os campos trafegam na ordem informada no layout.
     * 
     * @param prototype
     *            Objeto de neg�cio do tipo tratado pelo parsing.
     */
    public ISOParser(BusinessObject prototype) {
        this(prototype, getFields(prototype));
    }

    /**
     * M�todo getFieldsLength. Retorna o tamanho total do layout ISO para os
     * atributos do objeto de neg�cio.
     * 
     * @return int
     */
    public int getFieldsLength() {
    	int teste = this.extension.getLength(this.fields);
        return this.extension.getLength(this.fields);
    }

    /**
     * M�todo getBean. Efetua o parsing de uma String contendo uma mensagem ISO,
     * instanciando um objeto de neg�cio.
     * 
     * @param bitISO
     *            String que cont�m os dados para instancia��o do objeto.
     * @return Objeto de neg�cio instanciado.
     */
    public BusinessObject getBean(String bitISO) {
        final BusinessObject result = getPrototype().prototype();
        final SubstringTokenizer tokenizer = new SubstringTokenizer(bitISO);
        for (int i = 0; i < this.fields.length; i++) {
            final String name = this.fields[i];
            final Object value = getValue(tokenizer, name);
            result.setPropertyValue(name, value);
        }
        return result;
    }

    /**
     * M�todo getValue. Obtem da String de dados, uma propriedade tipada,
     * suportada pela framework. Utiliza as informa��es de tipo mantidas pelo
     * layout e pela extens�o mainframe.
     * 
     * @param tokenizer
     *            String contendo o valor.
     * @param name
     *            Nome da propriedade desejada daquele ponto do Token.
     * @return Objeto de propriedade instanciado.
     */
    private Object getValue(SubstringTokenizer tokenizer, String name) {
        final MainframeValue value = getValue(name);
        final String token = tokenizer.getNext(value.getLength());
        return value.convert(token);
    }

    /**
     * M�todo getValue. M�todo simplificado para obten��o de uma propriedade.
     * Utiliza as defini��es da extens�o de dados mantida pelo objeto de
     * neg�cios.
     * 
     * @param name
     *            Nome da propriedade desejada.
     * @return Objeto de propriedade instanciado.
     */
    private MainframeValue getValue(String name) {
        return this.extension.get(name);
    }

    /**
     * M�todo getFields. Retorna a lista de campos constantes do objeto de
     * neg�cio. Esta lista ser� utilzada no parsing, caso o construtor
     * secund�rio tenha sido utilizado.
     * 
     * @param prototype
     *            Objeto de neg�cio a ser tratado.
     * @return Lista com os nomes dos campos a serem tratados.
     */
    private static final String[] getFields(BusinessObject prototype) {
        final MainframeExtension mainframe = (MainframeExtension) prototype.getExtension("Mainframe");
        final String[] result = new String[mainframe.getFieldsCount()];
        int i = 0;
        for (final Iterator iterator = mainframe.properties(); iterator.hasNext(); i++) {
            result[i] = (String) iterator.next();
        }
        return result;
    }
}