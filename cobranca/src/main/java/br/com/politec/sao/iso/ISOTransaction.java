package br.com.politec.sao.iso;

import java.util.Date;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.iso.ISOException;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sirot.transacoes.SIROTTrans;
import br.gov.caixa.util.CEFException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que implmenta uma interface simples para acesso ao ambiente de
 * comunica��o SIROT/CAIXA. Esta classe encapsula a interface da aplica��o com
 * as classes do pacote de comunica��o SIROTCon , fornecendo um contrato mais
 * simples e aderente aos padr�es propostos na framework. Respeitando o modelo
 * MVC2, esta classe implmenta a interface padr�o de um SessionBean.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class ISOTransaction extends SIROTTrans implements SessionBean {

    /**
     * Contexto associado ao componente.
     */
    private SessionContext context = null;

    /**
     * Construtor default do componente. Solicita a inst�ncia��o a sua
     * superclasse.
     */
    public ISOTransaction() {
        super();
    }

    /**
     * M�todo setSessionContext.
     * 
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     *      Atribui ao componente um contexto no servidor de aplica��oes.
     * @param context
     *            Conetexto para associa��o.
     */
    public void setSessionContext(SessionContext context) {
        this.context = context;
    }

    /**
     * M�todo getSessionContext. Retorna o contexto do servidor de aplica��es
     * associado ao componente.
     * 
     * @return Contexto do servidor de aplica��es associado ao componente.
     */
    public SessionContext getSessionContext() {
        return this.context;
    }

    /**
     * M�todo ejbRemove.
     * 
     * @see javax.ejb.SessionBean#ejbRemove() Sem implementa��o neste caso.
     * @throws EJBException
     *             Caso o processo propague alguma exce��o.
     */
    public void ejbRemove() throws EJBException {
    }

    /**
     * M�todo ejbActivate.
     * 
     * @see javax.ejb.SessionBean#ejbActivate() Sem implementa��o neste caso.
     * @throws EJBException
     *             Caso o processo propague alguma exce��o.
     */
    public void ejbActivate() throws EJBException {
    }

    /**
     * M�todo ejbPassivate.
     * 
     * @see javax.ejb.SessionBean#ejbPassivate() Sem implementa��o neste caso.
     * @throws EJBException
     *             Caso o processo propague alguma exce��o.
     */
    public void ejbPassivate() throws EJBException {
    }

    /**
     * M�todo call. M�todo utilizado para envio de mensagens sem o retorno de
     * dados. Este m�todo � utilizado para envio de mensagems, sem que haja
     * retorno por parte do mainframe de mensagems contendo bens. Ser� retornado
     * pelo mainframe apenas a confirma��o de execu��o da requisi��o.
     * 
     * @param messages
     *            Array de mensagems para envio.
     * @throws EJBException
     *             Caso ocorra algum erro de conectividade, ou o pacote recebido
     *             como resposta reporte algum erro de aplica��o.
     */
    public final void call(ISOMsg[] messages) throws EJBException {
        try {
            final ISOMsg[] responses = getResponse(messages);
            checkError(responses);
        } catch (ISOException exc) {
            throw new EJBException(exc);
        } catch (CEFException exc) {
            throw new EJBException(exc);
        }
    }

    /**
     * M�todo call. Acionado para enviar pacotes ao mainframe, sendo a resposta
     * ser� composta de dados relevantes a solicita��o. Um exemplo cl�ssico
     * seria uma consulta de informa��es, com o envio dos dados de filtro de
     * pesquisa e o retorno do resultado desta pesquisa.
     * 
     * @param messages
     *            Array de mensagems para envio.
     * @param result
     *            Parser padr�o para montagem da lista de beans de resposta.
     * @return Lista de bens de resposta montada a partir dos pacotes de
     *         resposta.
     * @throws EJBException
     *             Caso ocorra algum erro de conectividade, ou o pacote recebido
     *             como resposta reporte algum erro de aplica��o.
     */
    public final BeanList call(ISOMsg[] messages, ISOResult result)
            throws EJBException {
        try {
            final ISOMsg[] responses = getResponse(messages);
            return result.getBeans(responses);
        } catch (ISOException exc) {
            throw new EJBException(exc);
        } catch (CEFException exc) {
            throw new EJBException(exc);
        }
    }

    /**
     * M�todo getResponse.
     * 
     * @see br.gov.caixa.sirot.transacoes.SIROTTrans#getResponse(br.gov.caixa.iso.ISOMsg[])
     *      M�todo padr�o da interface fornecida pelo SIROTCon, onde os
     *      par�metros e o retorno pertencem a biblioteca de componentes da
     *      SUMMA Tec.
     * @param messages
     *            Array de mensagens ISO8583 para envio.
     * @return Array de mensagems recebidas pela solicita��o.
     * @throws ISOException
     *             Caso ocorra algum erro no tratamento das mensagems de envio e
     *             resposta.
     * @throws CEFException
     *             Caso ocorra algum erro relativo a conectividade.
     */
    public final ISOMsg[] getResponse(ISOMsg[] messages) throws ISOException,   CEFException {

        addAdditionalInfo(messages);
        StringBuffer sb = new StringBuffer();
        Date inicio = new Date();
        try {
            if (LogUtilSigcb.isInfoEnabled()) {

                sb.append("\n******************************");
                sb.append("\nTransa��o SIROT");
                sb.append("\nInicio: ")
                        .append(Formatador.formatarDataHoraMinSegMili(inicio));
                sb.append("\n\n== Mensagem de Envio ==\n");

                ISOMessageLogger logger = new ISOMessageLogger("outgoing");
                sb.append(logger.geraMensagem(messages));
            }


            ISOMsg mensagem = messages[0];
            
            
            SirotAdaptadorSIGCB acao = new SirotAdaptadorSIGCB();
                        
            final ISOMsg[] result = acao.executaSirot(mensagem);
            
            //final ISOMsg[] result = super.getResponse(messages);

            if (LogUtilSigcb.isInfoEnabled()) {

                sb.append("\n== Mensagem de Retorno ==\n");

                ISOMessageLogger logger = new ISOMessageLogger("incoming");
                sb.append(logger.geraMensagem(result));

            }

            return result;
       
		} catch (Exception e) {
			LogUtilSigcb.error(e.getLocalizedMessage());
			return null;
			
		} finally {
            if (LogUtilSigcb.isInfoEnabled()) {
                Date fim = new Date();
                sb.append("\nFinal:      ")
                        .append(Formatador.formatarDataHoraMinSegMili(fim));
                sb.append("\nTempo Total: ")
                        .append((fim.getTime() - inicio.getTime()) / 1000.0)
                        .append("seg.");
                sb.append("\n******************************");
            }
            LogUtilSigcb.info(sb.toString());
        }
    }

    /**
     * M�todo addAdditionalInfo. M�todo que ser� chamado antes do envio do
     * pacote ao SIROT. Garante ao projetista a possibilidade de adi��o de dados
     * complementares ao pacote, num ponto centralizado de manuten��o.
     * Normalmente � utilizado para incluir informa��es est�ticas como meios de
     * transmiss�o.
     * 
     * @param message
     *            Menssagem para adi��o de informa��es.
     * @throws ISOException
     *             Caso ocorra algum erro na manipula��o do pacote ISO8583.
     */
    protected abstract void addAdditionalInfo(ISOMsg message)
            throws ISOException;

    /**
     * M�todo addAdditionalInfo. Idem ao m�todo anterior, por�m com suporte a
     * execu��o da fun��o em um array de mensagens.
     * 
     * @param messages
     *            Array de mensagens paramanipula��o.
     * @throws ISOException
     *             Caso ocorra algum erro na manipula��o do pacote ISO8583.
     */
    private void addAdditionalInfo(ISOMsg[] messages) throws ISOException {
        for (int i = 0; i < messages.length; i++) {
            addAdditionalInfo(messages[i]);
        }
    }

    /**
     * M�todo checkError. Verifica se foi reportado pelo pacote de dados de
     * resposta um erro de aplica��o. A implementa��o atual checa se existe
     * algum dado no bit 120 do pacote, caso haja uma exce��o � propagada com o
     * conte�do do campo.
     * 
     * @param responses
     *            Array de mensagens ISO8583 para verifica��o.
     * @throws EJBException
     *             Caso algum erro de aplica��o tenha sido reportado.
     */
    private void checkError(ISOMsg[] responses) throws EJBException {
        for (int i = 1; i < responses.length; i++) {
            final ISOMsg message = responses[i];
            if (message.hasField(120)) {
                throw new EJBException(message.getString(120));
            }
        }
    }
}