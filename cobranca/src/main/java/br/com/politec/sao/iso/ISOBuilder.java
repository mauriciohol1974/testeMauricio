package br.com.politec.sao.iso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.StringAppender;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Fornece as regras de limita��o de tamanho de pacotes e a implementa��o f�sica
 * desta montagem. Garante a montagem das estruturas de dados do bit 62,
 * respeitando os limites vigentes.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOBuilder {
    /**
     * Limitador para o tamanho do bit 62.
     */
    private static final int MAX_BYTES_PER_PACKET = 996;

    /**
     * Lista de campos para composi��o da mensagem do bit 62.
     */
    private final String[] fields;

    /**
     * Lista de beans para composi��o das mensagens relativas aos bits 62.
     */
    private final BeanList beans;

    /**
     * Instancia do buferizador de dados para composi��o das mensagens.
     */
    private final ISOPrinter printer;

    /**
     * Construtor default para o objeto.
     * 
     * @param fields
     *            Lista de campos.
     * @param beans
     *            Lista de objetos de neg�cio.
     */
    public ISOBuilder(String[] fields,
            BeanList beans) {
        Assertions.requires(fields != null);
        Assertions.requires(beans != null);
        this.fields = fields;
        this.beans = beans;
        this.printer = new ISOPrinter(this.fields);
    }

    /**
     * M�todo getBits62. Retorna uma lista de Strings relativas aos bits 62 das
     * mensagens. O retorno � relativo a lista de objetos e campos mantidas
     * internamente e processadas sob demanda do cliente.
     * 
     * @return Lista de Strings contendo as mensagens a serem trafegadas no bit
     *         62.
     */
    public String[] getBits62() {
        final List result = new ArrayList();
        if (this.beans.size() > 0) {
            int remainingBeans = this.beans.size();
            final Iterator iterator = beans.iterator();
            for (int i = packetCount(); i > 0; i--) {
                result.add(getBit62(iterator, beansPerPacket()));
                remainingBeans -= beansPerPacket();
            }
            if (remainingBeans > 0) {
                result.add(getBit62(iterator, remainingBeans));
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    /**
     * M�todo getBit62. M�todo interno para processamento de cada String de
     * mensagem do bit 62. Este m�todo � o responsavel pela montagem individual
     * de sequencia de mensagens, n�o ultrapassando o limite de dados para um
     * �nico pacote.
     * 
     * @param iterator
     *            Lista de objetos de neg�cio, origem dos dados.
     * @param count
     *            Contador de n�mero de m�ximo de objetos por String.
     * @return String formatada no padr�o ISO para o bit 62.
     */
    private String getBit62(Iterator iterator, int count) {
        final StringAppender result = new StringAppender(1000);
        try {
            result.append(count, 3);
            for (int i = 0; (i < count) && iterator.hasNext(); i++) {
                final BusinessObject bean = (BusinessObject) iterator.next();
                this.printer.printOn(result, bean);
            }
        } catch (IOException exc) {
            Assertions.unreacheable();
        }
        return result.getText();
    }

    /**
     * M�todo packetCount. Retorna a quantidade de pacotes, baseando-se no
     * tamanho do layout de cada objeto e no total de objetos.
     * 
     * @return A quantidade de pacotes, baseando-se no tamanho do layout de cada
     *         objeto e no total de objetos.
     */
    private int packetCount() {
        return this.beans.size() / beansPerPacket();
    }

    /**
     * M�todo beansPerPacket. Retorna a quantidade de objetos por pacote de
     * dados.
     * 
     * @return A quantidade de objetos por pacote de dados.
     */
    private int beansPerPacket() {
        return MAX_BYTES_PER_PACKET / length(this.beans.getLayout());
    }

    /**
     * M�todo length. Retorna o tamanho total do layout trabalhado.
     * 
     * @param layout
     *            Layout para obten��o da informa��o.
     * @return O tamanho total do layout trabalhado.
     */
    private int length(Layout layout) {
        final MainframeExtension extension = (MainframeExtension) layout.getExtension("Mainframe");
        return extension.getLength(this.fields);
    }
}