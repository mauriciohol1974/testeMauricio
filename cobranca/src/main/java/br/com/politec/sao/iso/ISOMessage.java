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
 * Representa uma mensagem ISO na implementação padrão da framework. Encapsula a
 * interface mais complexa de um objeto do tipo ISOMsg, fornecendo uma interface
 * mais simples e adequada ao desenvolvimento baseado na framework. Fornece
 * suporte a criação de mensagens ISO a partir de objetos de negócio suportados
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
     * Método getMessages. Retorna uma lista de mensagens ISO a partir de um
     * único objeto de negócio. Este caso é suportado, porém raro de ocorrer,
     * visto o tamanho máximo do pacote ser de até 999 bytes.
     * 
     * @param bean
     *            Objeto de negócio origem dos dados.
     * @return Lista de mensagens ISO.
     * @throws ISOException
     *             Caso ocorra algum erro durante a criação do pacote ISO.
     */
    public ISOMsg[] getMessages(BusinessObject bean) throws ISOException {
        return new ISOMsg[] { getMessage(getBit62(bean)) };
    }

    /**
     * Método getMessages. Retorna uma lista de mensagens ISO a partir de uma
     * lista de objetos de negócio. Esta lista de mensagens, respeita o limite
     * individual de pacote (999 bytes), sendo que um objeto também não tem seus
     * dados fragmentados em mais de uma mensagen.
     * 
     * @param beans
     *            Lista de beans para composição das mensagens.
     * @return Lista de mensagens ISO.
     * @throws ISOException
     *             Caso ocorra algum erro durante a criação do pacote ISO.
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
     * Método getBits62. Fornece a montagem do bit 62 do pacote ISO, a partir de
     * um objeto de negócio. O bit 62, é o escolhido no padrão de trabalho da
     * framework para trafego de informações do sistema, sempre representadas
     * por objetos de negócio.
     * 
     * @param beans
     *            Lista de beans, para obtenção do array de Strings contendo as
     *            mensagens do bit 62.
     * @return Array de Strings com o conteúdo do bit 62 das mensagens ISO.
     */
    private String[] getBits62(BeanList beans) {
        final ISOBuilder builder = new ISOBuilder(this.fields, beans);
        return builder.getBits62();
    }

    /**
     * Método getMessage. Montagem de uma mensagem ISO a partir da definição de
     * índice e continuação de mensagens. Método interno reposnsavel pela
     * montagem individual dos pacotes, a partir da composição do bit 62, do
     * índice de mensagem e do indicador de última mensagem da rajada.
     * 
     * @param bit62
     *            Estrutura de dados trafegada pelo protocolo.
     * @param index
     *            Índice da mensagem em relação a rajada de dados.
     * @param isLastMessage
     *            Indicador de final de rajada de dados.
     * @return Mensagem ISO composta.
     * @throws ISOException
     *             Caso ocorra algum erro durante a criação do pacote ISO.
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
     * Método getMessage. Montagem de um único pacote ISO. Em caso de trafego de
     * apenas uma mensagem, não caracterizando portanto uma rajada de dados.
     * Este método aciona internamente
     * 
     * @see #getMessage(String, int, boolean), passando como índice fixo 1 e
     *      final de rajada true.
     * @param bit62
     *            String de dados estruturada para transmissão.
     * @return Mensagem ISO composta.
     * @throws ISOException
     *             Caso ocorra algum erro durante a criação do pacote ISO.
     */
    private ISOMsg getMessage(String bit62) throws ISOException {
        return getMessage(bit62, 1, true);
    }

    /**
     * Método getBit62. Retorna a formatação do bit 62 de dados a partir de um
     * objeto de negócios. O bit 62 de dados é estruturado a partir das
     * informações de extensão de dados mantidas pelo objeto de negócios.
     * 
     * @param bean
     *            Objeto de negocios origem dos dados para composição do pacote
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
     * Método getIndexString. Fornece uma forma simples de garantir a quantidade
     * de 4 caracteres aos ínidices de rajada.
     * 
     * @param index
     *            Índice para formatação.
     * @return Exemplo: ínidice 1, retorno <code>"0001"</code>
     */
    private String getIndexString(int index) {
        final String result = "000" + String.valueOf(index);
        return result.substring(result.length() - 4);
    }
}