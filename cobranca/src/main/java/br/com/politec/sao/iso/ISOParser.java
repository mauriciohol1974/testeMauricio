package br.com.politec.sao.iso;

import java.util.Iterator;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Parser;
import br.com.politec.sao.util.SubstringTokenizer;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementação física do parser de objetos de negócio a partir de mensagens
 * ISO. Utiliza as definições de layout e extensão mainframe, para a partir de
 * uma String de formato ISO instanciar objetos de negócio suportados pela
 * framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOParser extends Parser {
    /**
     * Objeto que representa a extensão de dados utilizada pelo objeto de
     * negócio.
     */
    private final MainframeExtension extension;

    /**
     * Construtor default do objeto.
     * 
     * @param prototype
     *            Objeto de negócio do tipo tratado pelo parsing.
     * @param fields
     *            Lista dos campos, contidos na mensagem ISO para parsing.
     */
    public ISOParser(BusinessObject prototype,
            String[] fields) {
        super(prototype, fields);
        this.extension = (MainframeExtension) getPrototype().getExtension("Mainframe");
    }

    /**
     * Construtor secundário, baseado apenas no tipo a ser tratado. Neste caso é
     * assumido que todos os campos trafegam na ordem informada no layout.
     * 
     * @param prototype
     *            Objeto de negócio do tipo tratado pelo parsing.
     */
    public ISOParser(BusinessObject prototype) {
        this(prototype, getFields(prototype));
    }

    /**
     * Método getFieldsLength. Retorna o tamanho total do layout ISO para os
     * atributos do objeto de negócio.
     * 
     * @return int
     */
    public int getFieldsLength() {
    	int teste = this.extension.getLength(this.fields);
        return this.extension.getLength(this.fields);
    }

    /**
     * Método getBean. Efetua o parsing de uma String contendo uma mensagem ISO,
     * instanciando um objeto de negócio.
     * 
     * @param bitISO
     *            String que contém os dados para instanciação do objeto.
     * @return Objeto de negócio instanciado.
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
     * Método getValue. Obtem da String de dados, uma propriedade tipada,
     * suportada pela framework. Utiliza as informações de tipo mantidas pelo
     * layout e pela extensão mainframe.
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
     * Método getValue. Método simplificado para obtenção de uma propriedade.
     * Utiliza as definições da extensão de dados mantida pelo objeto de
     * negócios.
     * 
     * @param name
     *            Nome da propriedade desejada.
     * @return Objeto de propriedade instanciado.
     */
    private MainframeValue getValue(String name) {
        return this.extension.get(name);
    }

    /**
     * Método getFields. Retorna a lista de campos constantes do objeto de
     * negócio. Esta lista será utilzada no parsing, caso o construtor
     * secundário tenha sido utilizado.
     * 
     * @param prototype
     *            Objeto de negócio a ser tratado.
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