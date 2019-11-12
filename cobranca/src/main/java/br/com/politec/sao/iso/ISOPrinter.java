package br.com.politec.sao.iso;

import java.io.IOException;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Fornece suporte a listagem de atributos mantidos numa estrutura de Extensão.
 * Neste caso a extensão abordada é a extensão mainframe.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOPrinter {
    /**
     * Array de campos presentes na estrutura de extensão.
     */
    private final String[] fields;

    /**
     * Construtor default do objeto.
     * 
     * @param fields
     *            Lista de campos constantes da extensão.
     */
    public ISOPrinter(String[] fields) {
        Assertions.requires(fields != null);
        this.fields = (String[]) Utils.duplicateArray(fields);
    }

    /**
     * Método printOn. Bufferiza os dados relativos aos campos mantidos na
     * extensão do objeto de negócio. Estes dados bufferizados podem ser
     * utilizados para logs ou composições de arquivos e mensagens.
     * 
     * @param out
     *            Buffer para acumulo dos dados.
     * @param bean
     *            Objeto de negócio que mantém a extensão mapeada.
     */
    public void printOn(Appender out, BusinessObject bean) {
        final MainframeExtension extension = (MainframeExtension) bean.getExtension("Mainframe");
        try {
            for (int i = 0; i < this.fields.length; i++) {
                final String name = this.fields[i];
                final Object value = bean.getPropertyValue(name);
                extension.get(name).formatOn(out, value);
            }
        } catch (IOException exc) {
            Assertions.unreacheable();
        }
    }
}