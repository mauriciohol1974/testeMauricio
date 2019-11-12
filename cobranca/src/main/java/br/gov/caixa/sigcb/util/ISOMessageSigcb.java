package br.gov.caixa.sigcb.util;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.iso.ISOMessage;
import br.com.politec.sao.iso.ISOPrinter;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.util.StringAppender;
import br.gov.caixa.iso.ISOException;
import br.gov.caixa.iso.ISOField;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.estrategia.Sessao;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para parametrizar o comportamento da framework Politec Beans
 * aos padr�es adotados para o projeto SIGCB. Esta classe tem a respons�bilidade
 * de extender as caracter�sticas de ISOMessage, para montagem de pacotes
 * ISO8583 a partir de objetos de dados (beans).
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/02/2004</DD>
 * </DL>
 * 
 * @author Alex Takaoka - atakaoka@sao.politec.com.br
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 */
public class ISOMessageSigcb extends ISOMessage {
    /**
     * @see br.com.politec.sao.business.Message#Message(String, String[])
     *      Construtor padr�o, delega a constru��o do objeto a super classe.
     */
    public ISOMessageSigcb(String name, String[] fields) {
        super(name, fields);
    }

    /**
     * @see br.com.politec.sao.iso.ISOMessage#getMessages(BusinessObject) M�todo
     *      utilizado para obten��o de um array de mensagens ISO8583 a partir de
     *      um objeto.
     */
    public ISOMsg[] getMessages(BusinessObject bean) throws ISOException {
        return new ISOMsg[] { getMessage(getBit62(bean)) };
    }

    /**
     * M�todo reescrito para altera��o do comportamento da framework Politec
     * Beans em rela��o a montagem do pacote ISO8583. Trabalhando na estrutura
     * de PORTAL CICS, o c�digo da transa��o ser� enviado no bit 63 do pacote,
     * somando 4 bytes, por�m para o projeto SIGCB, ser�o reservados mais 26
     * bytes para utiliza��o futura.
     * 
     * @param bit62
     *            Conte�do do bit62 do pacote.
     * @param index
     *            �ndice da mensagem que est� sendo montada.
     * @param isLastMessage
     *            Indicador para verifica��o de final de rajada.
     * @return ISOMsg Mensagem ISO8583 montada.
     * @throws ISOException
     *             Caso ocorra algum erro na montagem do pacote, n�o previsto.
     */
    private ISOMsg getMessage(String bit62, int index, boolean isLastMessage)
            throws ISOException {
        final ISOMsg result = new ISOMsg();
        result.set(new ISOField(62, bit62));
        //result.set(new ISOField(63, getName() + "                          "));
        
        result.set(new ISOField(63, getName() + "                   "));
        //result.set(new ISOField(63, getName() + "C899837 "));
        result.set(new ISOField(71, getIndexString(index)));
        result.set(new ISOField(72, isLastMessage ? "9999" : "0000"));
        return result;
    }

    /**
     * M�todo privado, utilizado para montagem de um �nico pacote ISO atrav�s de
     * uma String contendo os dados do bit 63.
     * 
     * @param bit63
     *            Conte�do do bit 63.
     * @return ISOMsg Mensagem montada.
     * @throws ISOException
     *             Caso ocorra algum erro na montagem do pacote.
     */
    private ISOMsg getMessage(String bit62) throws ISOException {
        return getMessage(bit62.toUpperCase(), 1, true);
    }

    /**
     * M�todo para obten��o do bit 62 formatado a partir de um objeto de dados.
     * 
     * @param bean
     *            Objeto de dados que ser� utilizado para montagem da String.
     * @return String Conte�do do bit 62m da mensagem ISO8583.
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
     * M�todo simples para gera��o do �ndice do pacote com quatro d�gitos.
     * 
     * @param index
     *            Inteiro que representa o �ndice da mensagem.
     * @return String Formata com quatro d�gitos. Exemplo "0025".
     */
    private String getIndexString(int index) {
        final String result = "000" + String.valueOf(index);
        return result.substring(result.length() - 4);
    }
}