package br.com.politec.sao.iso;

import javax.ejb.EJBException;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Parser;
import br.com.politec.sao.business.Result;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.SubstringTokenizer;
import br.gov.caixa.iso.ISOMsg;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Representa uma resposta de dados encapsulados em pacotes ISO8583 em beans
 * tratados pela framework. O parsing utilza as informações de layout de cada
 * bean, e uma lista de campos que estão sendo trafegados no pacote, utilizando
 * um parsing específico para pacotes ISO8583.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOResult extends Result {
    /**
     * Construtor default do objeto.
     * 
     * @param prototype
     *            Tipo específico de bean que esta sendo trafegado.
     * @param fields
     *            Lista dos campos que estão sendo trafegados.
     */
    public ISOResult(BusinessObject prototype,
            String[] fields) {
        super(prototype, fields);
    }

    /**
     * Método getParser.
     * 
     * @see br.com.politec.sao.business.Result#getParser(br.com.politec.sao.business.BusinessObject,
     *      java.lang.String[]) Retorna uma instancia de parser adequada ao
     *      trabalho de decomposição dos pacotes ISO8583.
     * @param prototype
     *            Objeto do tipo BusinessObject para identificação do tipo
     *            mantido no pacote ISO.
     * @param fields
     *            Lista de campos contidos no pacote ISO.
     * @return Instancia de parser especializada para os objetos de negócio
     *         desejados.
     */
    protected Parser getParser(BusinessObject prototype, String[] fields) {
        return new ISOParser(prototype, fields);
    }

    /**
     * Método getBeans. Retorna uma lista de objetos de negócio a partir de uma
     * lista de mensagens ISO. Cada pacote pode conter um ou mais objetos de
     * negócio.
     * 
     * @param responses
     *            Lista de mensagens de onde irá se obter a lista de objetos de
     *            negócio.
     * @return Lista de objetos de negócio.
     */
    public BeanList getBeans(ISOMsg[] responses) {
        final BeanList result = new BeanList(getPrototype().getLayout());
        for (int i = 0; i < responses.length; i++) {
            final ISOMsg message = responses[i];
            checkErrorBit(message);
            addMessage(result, message.getString(62));
        }
        return result;
    }

    /**
     * Método checkErrorBit. Verificação de erro reportado através do pacote
     * ISO8583. Antes de efetuar o parsing dos objetos, a framework verifica
     * através deste método se existe algum erro reportado no bit 120 de dados.
     * 
     * @param message
     *            Mensagem ISO para verificação de erro reportado.
     */
    public void checkErrorBit(ISOMsg message) {
        if (!message.hasField(62)) {
            throw new RuntimeException(message.getString(120));
        }
    }

    /**
     * Método addMessage. Este método realiza o parsing dos dados recebidos como
     * resposta em uma lista de objetos de negócio.
     * 
     * @param beans
     *            Lista de objetos de negócio que será alimentada com o
     *            resultado do parsing.
     * @param bit62
     *            String de dados formada pela extração do bit 62 de todos os
     *            pacotes.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto durante o parsing dos
     *             objetos.
     */
    private void addMessage(BeanList beans, String bit62) throws EJBException {
        final SubstringTokenizer tokenizer = new SubstringTokenizer(bit62);
        final int recordSetSize = getRecordSetSize(tokenizer);
        final int length = getFieldsLength();
        checkMessageLength(bit62, recordSetSize);

        while (tokenizer.hasNext(length)) {
            final String bitISO = tokenizer.getNext(length);
            beans.add(getBean(bitISO));
        }
    }

    /**
     * Método getRecordSetSize. Verifica e retorna a quantidade de registros,
     * representando objetos de negócio, estão contidos na String de mensagem
     * obtida dos pacotes. * Este recurso depende da definição do mapa de bytes
     * pela equipe de projeto com este recurso habilitado.
     * 
     * @param tokenizer
     *            Facilitador no particionamento dos pacotes.
     * @return Quantidade de recordsets informado no pacote.
     */
    private int getRecordSetSize(SubstringTokenizer tokenizer) {
        int result = 0;
        if (tokenizer.hasNext(3)) {
            result = Integer.parseInt(tokenizer.getNext(3));
        }
        return result;
    }

    /**
     * Método checkMessageLength. Verifica se os dados recebidos estão coerentes
     * com as declarações de layout e quantidade de dados. Serão cruzadas as
     * informações sobre quantidade de registros com o layout de cada registro e
     * o tamanho total dos dados recebidos.
     * 
     * @param bit62
     *            Dados recebidos.
     * @param recordSetSize
     *            Quantidade de registros declarada.
     * @throws EJBException
     *             Caso os dados sejam incompativeis.
     */
    private void checkMessageLength(String bit62, int recordSetSize)
            throws EJBException {
        if ((bit62.length() - 3) != (getFieldsLength() * recordSetSize)) {
            throw new EJBException("Invalid bit62 ["
                                   + bit62
                                   + "]\n for layout ["
                                   + getPrototype().getLayout()
                                   + "]");
        }
    }

    /**
     * Método getBean. Parser individual de cada objeto de negócio a partir de
     * uma String em formato ISO.
     * 
     * @param bitISO
     *            String origem dos dados.
     * @return Objeto de negócio.
     */
    private BusinessObject getBean(String bitISO) {
        return ((ISOParser) getParser()).getBean(bitISO);
    }

    /**
     * Método getFieldsLength. Tamanho total do layout do pacote ISO para o
     * objeto de negócio.
     * 
     * @return Tamanho total do layout.
     */
    private int getFieldsLength() {
        return ((ISOParser) getParser()).getFieldsLength();
    }
}