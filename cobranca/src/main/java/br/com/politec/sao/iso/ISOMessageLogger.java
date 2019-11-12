package br.com.politec.sao.iso;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Date;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Utilitário para formatação de log de mensagens ISO. Utilizado em ambiente de
 * desenvolvimento.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ISOMessageLogger {
    private final StringBuffer out;

    private final String type;

    public ISOMessageLogger(String type) {
        Assertions.requires(type != null);
        this.type = type;
        this.out = new StringBuffer(1024);
    }

    public void printOn(OutputStream stream, ISOMsg[] messages)
            throws IOException {
        printOn(messages);
    }

    public void printOn(ISOMsg[] messages) throws IOException {
        Assertions.requires(messages != null);
        appendMessagesHeader(messages);
        appendMessages(messages);
        appendMessagesFooter();

        StringWriter str = new StringWriter();
        Appender out = new Appender(str);
        writeToStream(out);
        out.close();
        String messageText = str.toString();
        LogUtilSigcb.info(messageText);
        if (LogUtilSigcb.isWarnEnabled()) {
            if (messageText.indexOf("outgoing:message") >= 0) {
                int inicioNomeTransacao = messageText.indexOf("bitNumber='63'>")
                                          + "bitNumber='63'>".length();
                int fimNomeTransacao = inicioNomeTransacao + 4;
                LogUtilSigcb.warn(messageText.substring(inicioNomeTransacao,
                        fimNomeTransacao));
            }
        }
    }

    /**
     * @param messages
     * @throws IOException
     */
    public String geraMensagem(ISOMsg[] messages) {
        Assertions.requires(messages != null);
        appendMessagesHeader(messages);
        appendMessages(messages);
        appendMessagesFooter();
        return out.toString();
    }

    private void appendMessagesHeader(ISOMsg[] messages) {
        out.append("<");
        out.append(type);
        out.append(":messages count='");
        out.append(messages.length);
        out.append("' date='");
        out.append(new Date());
        out.append("'>").append("\r\n");
    }

    private void appendMessages(ISOMsg[] messages) {
        for (int i = 0; i < messages.length; i++) {
            appendMessage(i, messages[i]);
        }
    }

    private void appendMessagesFooter() {
        out.append("</").append(type).append(":messages>").append("\r\n");
    }

    private void appendMessage(int index, ISOMsg message) {
        appendMessageHeader(index);
        if (message != null) {
            appendISOFields(message);
        } else {
            out.append("    NULL").append("\r\n");
        }
        appendMessageFooter();
    }

    private void appendMessageHeader(int index) {
        out.append("    <");
        out.append(type);
        out.append(":message index='");
        out.append(index);
        out.append("'>").append("\r\n");
    }

    private void appendISOFields(ISOMsg message) {
        appendISOField(0, message);
        appendISOField(3, message);
        appendISOField(33, message);
        appendISOField(39, message);
        appendISOField(62, message);
        appendISOField(63, message);
        appendISOField(71, message);
        appendISOField(72, message);
        appendISOField(100, message);
        appendISOField(120, message);
    }

    private void appendMessageFooter() {
        out.append("    </");
        out.append(type);
        out.append(":message>").append("\r\n");
    }

    private void appendISOField(int isoField, ISOMsg message) {
        if (message.hasField(isoField)) {
            out.append("        <iso:field bitNumber='");
            out.append(isoField);
            out.append("'>");
            if (isoField==63){
            	out.append(message.getString(isoField));
            }else{
            	out.append(message.getString(isoField));
            }
            
            out.append("</iso:field>").append("\r\n");
        }
    }

    private void writeToStream(OutputStream stream) throws IOException {
        stream.write(this.out.toString().getBytes());
        stream.flush();
        this.out.setLength(0);
    }
}