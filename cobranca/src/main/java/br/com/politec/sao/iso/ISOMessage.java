package br.com.politec.sao.iso;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Message;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.StringAppender;
import br.gov.caixa.iso.ISOException;
import br.gov.caixa.iso.ISOField;
import br.gov.caixa.iso.ISOMsg;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Representa uma mensagem ISO na implementa��o padr�o da framework. Encapsula a
 * interface mais complexa de um objeto do tipo ISOMsg, fornecendo uma interface
 * mais simples e adequada ao desenvolvimento baseado na framework. Fornece
 * suporte a cria��o de mensagens ISO a partir de objetos de neg�cio suportados
 * pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOMessage extends Message {
    /**
     * Construtor default do objeto.
     * 
     * @param name
     *            Nome atribuido ao objeto de mensagem.
     * @param fields
     *            Lista de campos a serem considerados na montagem dos pacotes.
     */
    public ISOMessage(String name,
            String[] fields) {
        super(name, fields);
    }

    /**
     * M�todo getMessages. Retorna uma lista de mensagens ISO a partir de um
     * �nico objeto de neg�cio. Este caso � suportado, por�m raro de ocorrer,
     * visto o tamanho m�ximo do pacote ser de at� 999 bytes.
     * 
     * @param bean
     *            Objeto de neg�cio origem dos dados.
     * @return Lista de mensagens ISO.
     * @throws ISOException
     *             Caso ocorra algum erro durante a cria��o do pacote ISO.
     */
    public ISOMsg[] getMessages(BusinessObject bean) throws ISOException {
        return new ISOMsg[] { getMessage(getBit62(bean)) };
    }

    /**
     * M�todo getMessages. Retorna uma lista de mensagens ISO a partir de uma
     * lista de objetos de neg�cio. Esta lista de mensagens, respeita o limite
     * individual de pacote (999 bytes), sendo que um objeto tamb�m n�o tem seus
     * dados fragmentados em mais de uma mensagen.
     * 
     * @param beans
     *            Lista de beans para composi��o das mensagens.
     * @return Lista de mensagens ISO.
     * @throws ISOException
     *             Caso ocorra algum erro durante a cria��o do pacote ISO.
     */
    public ISOMsg[] getMessages(BeanList beans) throws ISOException {
        final String[] bits = getBits62(beans);
        final ISOMsg[] result = new ISOMsg[bits.length];
        for (int i = 0; i < result.length; i++) {
            final String bit62 = bits[i];
            result[i] = getMessage(bit62, i + 1, i == result.length - 1);
        }
        return result;
    }

    /**
     * M�todo getBits62. Fornece a montagem do bit 62 do pacote ISO, a partir de
     * um objeto de neg�cio. O bit 62, � o escolhido no padr�o de trabalho da
     * framework para trafego de informa��es do sistema, sempre representadas
     * por objetos de neg�cio.
     * 
     * @param beans
     *            Lista de beans, para obten��o do array de Strings contendo as
     *            mensagens do bit 62.
     * @return Array de Strings com o conte�do do bit 62 das mensagens ISO.
     */
    private String[] getBits62(BeanList beans) {
        final ISOBuilder builder = new ISOBuilder(this.fields, beans);
        return builder.getBits62();
    }

    /**
     * M�todo getMessage. Montagem de uma mensagem ISO a partir da defini��o de
     * �ndice e continua��o de mensagens. M�todo interno reposnsavel pela
     * montagem individual dos pacotes, a partir da composi��o do bit 62, do
     * �ndice de mensagem e do indicador de �ltima mensagem da rajada.
     * 
     * @param bit62
     *            Estrutura de dados trafegada pelo protocolo.
     * @param index
     *            �ndice da mensagem em rela��o a rajada de dados.
     * @param isLastMessage
     *            Indicador de final de rajada de dados.
     * @return Mensagem ISO composta.
     * @throws ISOException
     *             Caso ocorra algum erro durante a cria��o do pacote ISO.
     */
    private ISOMsg getMessage(String bit62, int index, boolean isLastMessage)
            throws ISOException {
        final ISOMsg result = new ISOMsg();
        result.set(new ISOField(62, bit62));
        result.set(new ISOField(63, getName()));
        result.set(new ISOField(71, getIndexString(index)));
        result.set(new ISOField(72, isLastMessage ? "9999" : "0000"));
        return result;
    }

    /**
     * M�todo getMessage. Montagem de um �nico pacote ISO. Em caso de trafego de
     * apenas uma mensagem, n�o caracterizando portanto uma rajada de dados.
     * Este m�todo aciona internamente
     * 
     * @see #getMessage(String, int, boolean), passando como �ndice fixo 1 e
     *      final de rajada true.
     * @param bit62
     *            String de dados estruturada para transmiss�o.
     * @return Mensagem ISO composta.
     * @throws ISOException
     *             Caso ocorra algum erro durante a cria��o do pacote ISO.
     */
    private ISOMsg getMessage(String bit62) throws ISOException {
        return getMessage(bit62, 1, true);
    }

    /**
     * M�todo getBit62. Retorna a formata��o do bit 62 de dados a partir de um
     * objeto de neg�cios. O bit 62 de dados � estruturado a partir das
     * informa��es de extens�o de dados mantidas pelo objeto de neg�cios.
     * 
     * @param bean
     *            Objeto de negocios origem dos dados para composi��o do pacote
     *            ISO.
     * @return String com os dados do bit 62 estruturados.
     */
    private String getBit62(BusinessObject bean) {
        final MainframeExtension extension = (MainframeExtension) bean.getExtension("Mainframe");
        if (extension != null) {
            final StringAppender out = new StringAppender();
            final ISOPrinter printer = extension.getPrinter(this.fields);
            printer.printOn(out, bean);
            return out.getText();
        } else {
            return "";
        }
    }

    /**
     * M�todo getIndexString. Fornece uma forma simples de garantir a quantidade
     * de 4 caracteres aos �nidices de rajada.
     * 
     * @param index
     *            �ndice para formata��o.
     * @return Exemplo: �nidice 1, retorno <code>"0001"</code>
     */
    private String getIndexString(int index) {
        final String result = "000" + String.valueOf(index);
        return result.substring(result.length() - 4);
    }
}