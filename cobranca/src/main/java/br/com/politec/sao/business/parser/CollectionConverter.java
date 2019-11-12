package br.com.politec.sao.business.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Converte os atributos de um
 * 
 * @see br.com.politec.sao.business.BusinessObject em uma coleção de objetos,
 *      armazenados em uma estrutura de
 * @see java.util.Collection
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class CollectionConverter {
    /**
     * Construtor default do objeto.
     */
    private CollectionConverter() {
        super();
    }

    /**
     * Método convert. Converte os parâmetros de um bean em uma coleção de
     * objetos.
     * 
     * @param collection
     *            Coleção que irá receber os parâmetros.
     * @param prototype
     *            Bean contendo as propriedades.
     * @return Lista com as propriedades do bean.
     */
    public static List convert(Collection collection, BusinessObject prototype) {
        Assertions.requires(collection != null, "Collection must exist!");
        Assertions.requires(prototype != null, "Prototype must exist!");
        final List result = new ArrayList(collection.size());
        for (final Iterator i = collection.iterator(); i.hasNext();) {
            final BusinessObject item = (BusinessObject) prototype.clone();
            final Object object = i.next();
            item.accept(new GenericObjectParser(object));
            result.add(item);
        }
        return result;
    }
}