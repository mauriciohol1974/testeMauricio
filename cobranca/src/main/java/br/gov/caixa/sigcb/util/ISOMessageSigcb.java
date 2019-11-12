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
 * aos padrões adotados para o projeto SIGCB. Esta classe tem a responsábilidade
 * de extender as características de ISOMessage, para montagem de pacotes
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
     *      Construtor padrão, delega a construção do objeto a super classe.
     */
    public ISOMessageSigcb(String name, String[] fields) {
        super(name, fields);
    }

    /**
     * @see br.com.politec.sao.iso.ISOMessage#getMessages(BusinessObject) Método
     *      utilizado para obtenção de um array de mensagens ISO8583 a partir de
     *      um objeto.
     */
    public ISOMsg[] getMessages(BusinessObject bean) throws ISOException {
        return new ISOMsg[] { getMessage(getBit62(bean)) };
    }

    /**
     * Método reescrito para alteração do comportamento da framework Politec
     * Beans em relação a montagem do pacote ISO8583. Trabalhando na estrutura
     * de PORTAL CICS, o código da transação será enviado no bit 63 do pacote,
     * somando 4 bytes, porém para o projeto SIGCB, serão reservados mais 26
     * bytes para utilização futura.
     * 
     * @param bit62
     *            Conteúdo do bit62 do pacote.
     * @param index
     *            Índice da mensagem que está sendo montada.
     * @param isLastMessage
     *            Indicador para verificação de final de rajada.
     * @return ISOMsg Mensagem ISO8583 montada.
     * @throws ISOException
     *             Caso ocorra algum erro na montagem do pacote, não previsto.
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
     * Método privado, utilizado para montagem de um único pacote ISO através de
     * uma String contendo os dados do bit 63.
     * 
     * @param bit63
     *            Conteúdo do bit 63.
     * @return ISOMsg Mensagem montada.
     * @throws ISOException
     *             Caso ocorra algum erro na montagem do pacote.
     */
    private ISOMsg getMessage(String bit62) throws ISOException {
        return getMessage(bit62.toUpperCase(), 1, true);
    }

    /**
     * Método para obtenção do bit 62 formatado a partir de um objeto de dados.
     * 
     * @param bean
     *            Objeto de dados que será utilizado para montagem da String.
     * @return String Conteúdo do bit 62m da mensagem ISO8583.
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
     * Método simples para geração do índice do pacote com quatro dígitos.
     * 
     * @param index
     *            Inteiro que representa o índice da mensagem.
     * @return String Formata com quatro dígitos. Exemplo "0025".
     */
    private String getIndexString(int index) {
        final String result = "000" + String.valueOf(index);
        return result.substring(result.length() - 4);
    }
}