package br.gov.caixa.sigcb.ejb.session;

import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.ISOTransaction;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.iso.ISOException;
import br.gov.caixa.iso.ISOField;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.ISOMessageSigcb;
import br.gov.caixa.sigcb.util.ISOResultSigcb;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;
import br.gov.caixa.util.CEFException;

@Stateless
public class MainFrameTransactionsSigcbEjb extends ISOTransaction implements
        MainframeTransactionSigcbBusiness {
    /**
     * Layoute de todas as transações do sistema SIGCB intranet.
     */
    private FieldsByTransaction fields = new FieldsByTransaction();

    /**
     * Sem implementação neste caso.
     * 
     * @throws CreateException
     */
    public void ejbCreate() throws CreateException {
        setTimeout(3000);
    }

    /**
     * Método utilizado para envio dos pacotes ISO8583. Encapsula a interface
     * com a estrutura da framework Politec Beans, para tratamento de pacotes, e
     * parsing dos objetos.
     * 
     * @param messages
     *            Array de mensagens para envio.
     * @param result
     *            Parser para montagem dos objetos da lista de resposta.
     * @return BeanList Lista de objetos, (beans) para utilização pelo cliente.
     * @throws EJBException
     *             Caso ocorra algum erro de conexão com o ambiente SIROT, ou
     *             então alguma excessão não esperada.
     * @throws WrappingException
     *             Para os erros tratáveis, originalmente enviados pelo
     *             Mainframe através do bit 120 do pacote ISO8583.
     */
    public final BeanList execute(ISOMsg[] messages, ISOResultSigcb result)
            throws MainframeException {
        try {
            final ISOMsg[] responses = getResponse(messages);
            return result.getBeansSigcb(responses);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    public List executeDataDoubleRecordsetTransaction(BusinessObject bean,
            String transaction) throws MainframeException {
        try {
        	String transacao = transaction.substring(0, 4);
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction, fields.getLayoutFixDataDoubleRecordsetTransaction(transacao  + "-IDA"));
            ISOMsg mensagem[] = parser.getMessages(bean);
            ISOMsg[] responses = getResponse(transacao, mensagem);
            ISOResultSigcb result = new ISOResultSigcb(bean,
                    new String[] { null },
                    fields.getLayoutFixDataDoubleRecordsetTransaction(transacao
                                                                      + "-VOLTA-R1"),
                    fields.getLayoutFixDataDoubleRecordsetTransaction(transacao
                                                                      + "-VOLTA-R2"));
            return result.getBeansDoubleRecordsetSigcb(responses);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    public List executeFixDataDoubleRecordsetTransaction(BusinessObject bean,
            String transaction) throws MainframeException {
        try {
        	String transacao = transaction.substring(0, 4);
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction,
                    fields.getLayoutFixDataDoubleRecordsetTransaction(transacao
                                                                      + "-IDA"));
            ISOMsg mensagem[] = parser.getMessages(bean);
            ISOMsg[] responses = getResponse(transacao, mensagem);
            ISOResultSigcb result = new ISOResultSigcb(bean,
                    fields.getLayoutFixDataDoubleRecordsetTransaction(transacao
                                                                      + "-VOLTA-F"),
                    fields.getLayoutFixDataDoubleRecordsetTransaction(transacao
                                                                      + "-VOLTA-R1"),
                    fields.getLayoutFixDataDoubleRecordsetTransaction(transacao
                                                                      + "-VOLTA-R2"));
            return result.getBeansFixDoubleRecordsetSigcb(responses);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    public final List executeFixDataRecordsetTransaction(BusinessObject bean,
            String transaction) throws MainframeException {
        try {
        	String transacao = transaction.substring(0, 4);
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction, fields.getLayoutFixDataRecordsetTransaction(transacao + "-IDA"));
            ISOMsg mensagem[] = parser.getMessages(bean);
            ISOMsg[] responses = getResponse(transacao, mensagem);
            ISOResultSigcb result = new ISOResultSigcb(bean, fields.getLayoutFixDataRecordsetTransaction(transacao + "-VOLTA-F"), fields.getLayoutFixDataRecordsetTransaction(transacao + "-VOLTA-R"));
            return result.getBeansFixSigcb(responses);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }

    }

    /**
     * Método simplificado para execução de transações CICS através do protocolo
     * ISO8583.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transação
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transação.
     * @param transaction
     *            Nome da transação a ser executada.
     * @return BeanList Lista com objetos do tipo passado como parâmetro,
     *         preenchidos com os dados da resposta do mainframe.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     * @throws SigcbException
     *             Para os erros tratáveis, originalmente enviados pelo
     *             Mainframe através do bit 120 do pacote ISO8583.
     */
    public final BeanList executeMultiTransactionQuery(BusinessObject bean,
            String transaction,
            String tipoSolicitacao) throws MainframeException {
        try {
        	String transacao = transaction.substring(0, 4);
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction,
                    fields.getLayoutMultiTransaction(transacao
                                                     + "-IDA-"
                                                     + tipoSolicitacao));
            ISOMsg mensagem[] = parser.getMessages(bean);
            ISOMsg[] responses = getResponse(transacao, mensagem);
            ISOResultSigcb result = new ISOResultSigcb(bean,
                    fields.getLayoutMultiTransaction(transacao
                                                     + "-VOLTA-"
                                                     + tipoSolicitacao));
            return result.getBeansSigcb(responses);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    /**
     * Método simplificado para execução de transações CICS através do protocolo
     * ISO8583.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transação
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transação, ou do conjunto de transações.
     * @param transaction
     *            Nome da transação a ser executada.
     * @return boolean Indicador de sucesso no processamento.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     * @throws SigcbException
     *             Para os erros tratáveis, originalmente enviados pelo
     *             Mainframe através do bit 120 do pacote ISO8583.
     */
    public final void executeMultiTransactionVoid(BusinessObject bean,
            String transaction,
            String tipoSolicitacao) throws MainframeException {
        try {
        	String transacao = transaction.substring(0, 4);
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction,
                    fields.getLayoutMultiTransaction(transacao
                                                     + "-IDA-"
                                                     + tipoSolicitacao));
            ISOMsg mensagem[] = parser.getMessages(bean);
            ISOMsg[] responses = getResponse(transacao, mensagem);
            checkSuccess(responses[1]);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    /**
     * Método simplificado para execução de transações CICS através do protocolo
     * ISO8583.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transação
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transação.
     * @param transaction
     *            Nome da transação a ser executada.
     * @return BeanList Lista com objetos do tipo passado como parâmetro,
     *         preenchidos com os dados da resposta do mainframe.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     * @throws SigcbException
     *             Para os erros tratáveis, originalmente enviados pelo
     *             Mainframe através do bit 120 do pacote ISO8583.
     */
    public final BeanList executeSimpleTransactionQuery(BusinessObject bean, String transaction) throws MainframeException {

        try {
        	
        	
        	String transacao = transaction.substring(0, 4);
        	
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction,fields.getLayoutSimpleTransaction(transacao + "-IDA"));
            ISOMsg mensagem[] = parser.getMessages(bean);

            ISOMsg[] responses = getResponse(transacao, mensagem);
            ISOResultSigcb result = new ISOResultSigcb(bean, fields.getLayoutSimpleTransaction(transacao + "-VOLTA"));

            BeanList beanList = result.getBeansSigcb(responses);

            return beanList;

        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    /**
     * Método simplificado para execução de transações CICS através do protocolo
     * ISO8583.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transação
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transação, ou do conjunto de transações.
     * @param transaction
     *            Nome da transação a ser executada.
     * @return boolean Indicador de sucesso no processamento.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     * @throws SigcbException
     *             Para os erros tratáveis, originalmente enviados pelo
     *             Mainframe através do bit 120 do pacote ISO8583.
     */
    public final void executeSimpleTransactionVoid(BusinessObject bean,
            String transaction) throws MainframeException {
        try {
        	
        	String transacao = transaction.substring(0, 4);
        	
            ISOMessageSigcb parser = new ISOMessageSigcb(transaction, fields.getLayoutSimpleTransaction(transacao + "-IDA"));
            ISOMsg mensagem[] = parser.getMessages(bean);
            ISOMsg[] responses = getResponse(transacao, mensagem);
            checkSuccess(responses[1]);
        } catch (ISOException exc) {
            throw new MainframeException(exc);
        } catch (CEFException exc) {
            checkForTimeOut(exc, transaction);
            throw new MainframeException(exc);
        } catch (Exception exc) {
            throw new MainframeException(exc);
        }
    }

    /**
     * Método para Log de problemas de TIMEOUT, a fim de acrescentar mais
     * informações ao ocorrido.
     * 
     * @param ex
     *            A Exception do SIROT que encapsula o TIMEOUT
     * @param transaction
     *            A Transação que havia sido solicitada.
     */
    private void checkForTimeOut(Exception ex, String transaction) {
        if (ex.getMessage().startsWith("Timeout")) {
            LogUtilSigcb.error("TIMEOUT NA TRANSACAO = "
                               + transaction
                               + " AS "
                               + Formatador.formatarDataHoraMinSegMili(new Date()));
        }
    }

    /**
     * Verifica a resposta do bit 39 da mensagem. Caso retorne "99", o sistema
     * gerará uma WrappingException buscando a mensagem de erro no Bit 120.
     * 
     * @param message
     *            Mensagem a ser verificada.
     * @throws SigcbException
     *             Caso exista algum erro reportado, é criada e propagada a
     *             excessão.
     */
    private void checkSuccess(ISOMsg message) throws SigcbException {
        if ((message.getString(39) != null)
            && (message.getString(39).equals("10")
                || message.getString(39).equals("98") || message.getString(39)
                    .equals("99"))) {
            throw new SigcbException(new Exception(message.getString(120)));
        }
    }

    /**
     * @see br.com.politec.sao.iso.ISOTransaction#addAdditionalInfo(ISOMsg)
     *      Método utilizado para adição das informações padrão do projeto
     *      SIGCB, nos pacotes ISO8583. Este método é chamado pela framework
     *      Politec Beans antes do envio das mensagens.
     */
    protected void addAdditionalInfo(ISOMsg mensagem) throws ISOException {
        mensagem.set(new ISOField(0, "0205")); // 0 - Informação de Subida
        mensagem.set(new ISOField(3, "640400")); // 3 - Codigo de
        // Processamento SIGCB
        mensagem.set(new ISOField(33, "9683")); // 33 - Rede Transmissora
        // Sistema
        mensagem.set(new ISOField(100, "0104")); // 100 - Rede Transmissora
        // Caixa
        setTimeout(30000);

    }

    protected ISOMsg[] getResponse(String transaction, ISOMsg[] mensagem)
            throws ISOException, CEFException {
        Date inicio = new Date();
        StringBuffer sb = new StringBuffer();
        ISOMsg[] responses = null;

        try {
            sb.append("\n********************************");
            sb.append("\nTransação:                             ")
                    .append(transaction);
            sb.append("\nEnviando Mensagem para o Mainframe    [");
            sb.append(Formatador.formatarDataHoraMinSegMili(new Date()));
            sb.append("] (");
            sb.append((new Date().getTime() - inicio.getTime()) / 1000.0);
            sb.append(" seg.");

            responses = getResponse(mensagem);

        } finally {
            sb.append("\nTransação concluida                   [");
            sb.append(Formatador.formatarDataHoraMinSegMili(new Date()));
            sb.append("] (");
            sb.append((new Date().getTime() - inicio.getTime()) / 1000.0);
            sb.append(" seg.");
            sb.append("\n********************************");
            LogUtilSigcb.info(sb.toString());

        }
        return responses;
    }
}