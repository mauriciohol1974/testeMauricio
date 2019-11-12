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
 * comunicação SIROT/CAIXA. Esta classe encapsula a interface da aplicação com
 * as classes do pacote de comunicação SIROTCon , fornecendo um contrato mais
 * simples e aderente aos padrões propostos na framework. Respeitando o modelo
 * MVC2, esta classe implmenta a interface padrão de um SessionBean.
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
     * Construtor default do componente. Solicita a instânciação a sua
     * superclasse.
     */
    public ISOTransaction() {
        super();
    }

    /**
     * Método setSessionContext.
     * 
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     *      Atribui ao componente um contexto no servidor de aplicaçãoes.
     * @param context
     *            Conetexto para associação.
     */
    public void setSessionContext(SessionContext context) {
        this.context = context;
    }

    /**
     * Método getSessionContext. Retorna o contexto do servidor de aplicações
     * associado ao componente.
     * 
     * @return Contexto do servidor de aplicações associado ao componente.
     */
    public SessionContext getSessionContext() {
        return this.context;
    }

    /**
     * Método ejbRemove.
     * 
     * @see javax.ejb.SessionBean#ejbRemove() Sem implementação neste caso.
     * @throws EJBException
     *             Caso o processo propague alguma exceção.
     */
    public void ejbRemove() throws EJBException {
    }

    /**
     * Método ejbActivate.
     * 
     * @see javax.ejb.SessionBean#ejbActivate() Sem implementação neste caso.
     * @throws EJBException
     *             Caso o processo propague alguma exceção.
     */
    public void ejbActivate() throws EJBException {
    }

    /**
     * Método ejbPassivate.
     * 
     * @see javax.ejb.SessionBean#ejbPassivate() Sem implementação neste caso.
     * @throws EJBException
     *             Caso o processo propague alguma exceção.
     */
    public void ejbPassivate() throws EJBException {
    }

    /**
     * Método call. Método utilizado para envio de mensagens sem o retorno de
     * dados. Este método é utilizado para envio de mensagems, sem que haja
     * retorno por parte do mainframe de mensagems contendo bens. Será retornado
     * pelo mainframe apenas a confirmação de execução da requisição.
     * 
     * @param messages
     *            Array de mensagems para envio.
     * @throws EJBException
     *             Caso ocorra algum erro de conectividade, ou o pacote recebido
     *             como resposta reporte algum erro de aplicação.
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
     * Método call. Acionado para enviar pacotes ao mainframe, sendo a resposta
     * será composta de dados relevantes a solicitação. Um exemplo clássico
     * seria uma consulta de informações, com o envio dos dados de filtro de
     * pesquisa e o retorno do resultado desta pesquisa.
     * 
     * @param messages
     *            Array de mensagems para envio.
     * @param result
     *            Parser padrão para montagem da lista de beans de resposta.
     * @return Lista de bens de resposta montada a partir dos pacotes de
     *         resposta.
     * @throws EJBException
     *             Caso ocorra algum erro de conectividade, ou o pacote recebido
     *             como resposta reporte algum erro de aplicação.
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
     * Método getResponse.
     * 
     * @see br.gov.caixa.sirot.transacoes.SIROTTrans#getResponse(br.gov.caixa.iso.ISOMsg[])
     *      Método padrão da interface fornecida pelo SIROTCon, onde os
     *      parâmetros e o retorno pertencem a biblioteca de componentes da
     *      SUMMA Tec.
     * @param messages
     *            Array de mensagens ISO8583 para envio.
     * @return Array de mensagems recebidas pela solicitação.
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
                sb.append("\nTransação SIROT");
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
     * Método addAdditionalInfo. Método que será chamado antes do envio do
     * pacote ao SIROT. Garante ao projetista a possibilidade de adição de dados
     * complementares ao pacote, num ponto centralizado de manutenção.
     * Normalmente é utilizado para incluir informações estáticas como meios de
     * transmissão.
     * 
     * @param message
     *            Menssagem para adição de informações.
     * @throws ISOException
     *             Caso ocorra algum erro na manipulação do pacote ISO8583.
     */
    protected abstract void addAdditionalInfo(ISOMsg message)
            throws ISOException;

    /**
     * Método addAdditionalInfo. Idem ao método anterior, porém com suporte a
     * execução da função em um array de mensagens.
     * 
     * @param messages
     *            Array de mensagens paramanipulação.
     * @throws ISOException
     *             Caso ocorra algum erro na manipulação do pacote ISO8583.
     */
    private void addAdditionalInfo(ISOMsg[] messages) throws ISOException {
        for (int i = 0; i < messages.length; i++) {
            addAdditionalInfo(messages[i]);
        }
    }

    /**
     * Método checkError. Verifica se foi reportado pelo pacote de dados de
     * resposta um erro de aplicação. A implementação atual checa se existe
     * algum dado no bit 120 do pacote, caso haja uma exceção é propagada com o
     * conteúdo do campo.
     * 
     * @param responses
     *            Array de mensagens ISO8583 para verificação.
     * @throws EJBException
     *             Caso algum erro de aplicação tenha sido reportado.
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