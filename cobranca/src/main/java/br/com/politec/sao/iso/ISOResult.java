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
 * tratados pela framework. O parsing utilza as informa��es de layout de cada
 * bean, e uma lista de campos que est�o sendo trafegados no pacote, utilizando
 * um parsing espec�fico para pacotes ISO8583.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOResult extends Result {
    /**
     * Construtor default do objeto.
     * 
     * @param prototype
     *            Tipo espec�fico de bean que esta sendo trafegado.
     * @param fields
     *            Lista dos campos que est�o sendo trafegados.
     */
    public ISOResult(BusinessObject prototype,
            String[] fields) {
        super(prototype, fields);
    }

    /**
     * M�todo getParser.
     * 
     * @see br.com.politec.sao.business.Result#getParser(br.com.politec.sao.business.BusinessObject,
     *      java.lang.String[]) Retorna uma instancia de parser adequada ao
     *      trabalho de decomposi��o dos pacotes ISO8583.
     * @param prototype
     *            Objeto do tipo BusinessObject para identifica��o do tipo
     *            mantido no pacote ISO.
     * @param fields
     *            Lista de campos contidos no pacote ISO.
     * @return Instancia de parser especializada para os objetos de neg�cio
     *         desejados.
     */
    protected Parser getParser(BusinessObject prototype, String[] fields) {
        return new ISOParser(prototype, fields);
    }

    /**
     * M�todo getBeans. Retorna uma lista de objetos de neg�cio a partir de uma
     * lista de mensagens ISO. Cada pacote pode conter um ou mais objetos de
     * neg�cio.
     * 
     * @param responses
     *            Lista de mensagens de onde ir� se obter a lista de objetos de
     *            neg�cio.
     * @return Lista de objetos de neg�cio.
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
     * M�todo checkErrorBit. Verifica��o de erro reportado atrav�s do pacote
     * ISO8583. Antes de efetuar o parsing dos objetos, a framework verifica
     * atrav�s deste m�todo se existe algum erro reportado no bit 120 de dados.
     * 
     * @param message
     *            Mensagem ISO para verifica��o de erro reportado.
     */
    public void checkErrorBit(ISOMsg message) {
        if (!message.hasField(62)) {
            throw new RuntimeException(message.getString(120));
        }
    }

    /**
     * M�todo addMessage. Este m�todo realiza o parsing dos dados recebidos como
     * resposta em uma lista de objetos de neg�cio.
     * 
     * @param beans
     *            Lista de objetos de neg�cio que ser� alimentada com o
     *            resultado do parsing.
     * @param bit62
     *            String de dados formada pela extra��o do bit 62 de todos os
     *            pacotes.
     * @throws EJBException
     *             Caso ocorra algum erro n�o previsto durante o parsing dos
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
     * M�todo getRecordSetSize. Verifica e retorna a quantidade de registros,
     * representando objetos de neg�cio, est�o contidos na String de mensagem
     * obtida dos pacotes. * Este recurso depende da defini��o do mapa de bytes
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
     * M�todo checkMessageLength. Verifica se os dados recebidos est�o coerentes
     * com as declara��es de layout e quantidade de dados. Ser�o cruzadas as
     * informa��es sobre quantidade de registros com o layout de cada registro e
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
     * M�todo getBean. Parser individual de cada objeto de neg�cio a partir de
     * uma String em formato ISO.
     * 
     * @param bitISO
     *            String origem dos dados.
     * @return Objeto de neg�cio.
     */
    private BusinessObject getBean(String bitISO) {
        return ((ISOParser) getParser()).getBean(bitISO);
    }

    /**
     * M�todo getFieldsLength. Tamanho total do layout do pacote ISO para o
     * objeto de neg�cio.
     * 
     * @return Tamanho total do layout.
     */
    private int getFieldsLength() {
        return ((ISOParser) getParser()).getFieldsLength();
    }
}