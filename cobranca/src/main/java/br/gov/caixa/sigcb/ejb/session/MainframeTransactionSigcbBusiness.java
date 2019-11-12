package br.gov.caixa.sigcb.ejb.session;

import java.rmi.RemoteException;
import java.util.List;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;

public interface MainframeTransactionSigcbBusiness {

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583. >> Este metodo deve ser utilizado para retornos do mainframe
     * onde haja uma parte fixa e dois recordsets. >> O List resultante conter�
     * 3 posicoes: >> 0 - parte fixa: do tipo do objeto bean referenciado >> 1 -
     * recorset 1: tipo BeanList, contendo objetos do tipo do bean referenciado >>
     * 2 - recorset 2: tipo BeanList, contendo objetos do tipo do bean
     * referenciado >> H� necessidade de criacao de atributos "T" e "D" para
     * controle das transacoes
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @return List Lista com objetos de controle de descida e de negocio,
     *         conforme explicacao acima
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public List executeFixDataDoubleRecordsetTransaction(BusinessObject bean,
            String transaction) throws RemoteException, MainframeException;

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583. >> Este metodo deve ser utilizado para retornos do mainframe
     * onde haja dois recordsets (sem parte fixa). >> O list resultante conter�
     * 2 posicoes: >> 0 - recorset 1: tipo BeanList, contendo objetos do tipo do
     * bean referenciado >> 1 - recorset 2: tipo BeanList, contendo objetos do
     * tipo do bean referenciado >> H� necessidade de criacao de atributos "T" e
     * "D" para controle das transacoes
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @return List Lista com objetos de controle de descida e de negocio,
     *         conforme explicacao acima
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public List executeDataDoubleRecordsetTransaction(BusinessObject bean,
            String transaction) throws RemoteException, MainframeException;

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583. >> Este metodo deve ser utilizado para retornos do mainframe
     * onde haja uma parte fixa e um recorset. >> O list resultante conter� 2
     * posicoes: >> 0 - parte fixa: do tipo do objeto bean referenciado >> 1 -
     * recorset: tipo BeanList, contendo objetos do tipo do bean referenciado
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @return List Lista com objetos de controle de descida e de negocio,
     *         conforme explicacao acima
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public List executeFixDataRecordsetTransaction(BusinessObject bean,
            String transaction) throws RemoteException, MainframeException;

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583. >> Este metodo deve ser utilizado para retornos do mainframe
     * onde haja um recordset (sem parte fixa). >> O Beanlist resultante conter�
     * 2 posicoes: >> 0 - recorset: tipo BeanList, contendo objetos do tipo do
     * bean referenciado >> Transacoes que nao utilizam recordset, ou seja
     * retornam apenas um unico objeto, >> devem ser obtidas na posicao 0 do
     * BeanList.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @return BeanList Lista com objetos do tipo passado como par�metro,
     *         preenchidos com os dados da resposta do mainframe.
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public BeanList executeSimpleTransactionQuery(BusinessObject bean,
            String transaction) throws RemoteException, MainframeException;

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583. >> Este metodo deve ser utilizado para Passar dados ao
     * mainframe, sem aguardar retornos. >> Exemplo: Incluir, Alterar, Excluir.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public void executeSimpleTransactionVoid(BusinessObject bean,
            String transaction) throws RemoteException, MainframeException;

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @return BeanList Lista com objetos do tipo passado como par�metro,
     *         preenchidos com os dados da resposta do mainframe.
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public BeanList executeMultiTransactionQuery(BusinessObject bean,
            String transaction,
            String tipoSolicitacao) throws RemoteException, MainframeException;

    /**
     * M�todo simplificado para execu��o de transa��es CICS atrav�s do protocolo
     * ISO8583.
     * 
     * @param bean
     *            BusinessObjetct (bean) que mapeie os dados da transa��o
     *            desejada, ou seja, deve contemplar os dados de subida e
     *            descida da transa��o, ou do conjunto de transa��es.
     * @param transaction
     *            Nome da transa��o a ser executada.
     * @throws RemoteException
     *             Caso ocorra algum erro n�o previsto.
     * @throws WrappingException
     *             Para os erros trat�veis, originalmente enviados pelo
     *             Mainframe atrav�s do bit 120 do pacote ISO8583.
     */
    public void executeMultiTransactionVoid(BusinessObject bean,
            String transaction,
            String tipoSolicitacao) throws RemoteException, MainframeException;

}
