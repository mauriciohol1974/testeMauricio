package br.gov.caixa.sigcb.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.ISOParser;
import br.com.politec.sao.iso.ISOResult;
import br.com.politec.sao.util.SubstringTokenizer;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.iso.ISOMsg;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Implementação realizada para customização da framework Politec Beans aos
 * padrões adotados no sistema SIGCB. Esta classe tem a responsábilidade de
 * organizar o parsing dos objetos, a partir de uma mensagem ISO8583. A
 * responsábilidade principal desta classe é extender as características de
 * parsing da classe {@link br.com.politec.sao.iso.ISOResult} e aplicar o
 * tratamento de erro manipulado pelo bit 120, da forma estipulada para o
 * projeto SIGCB.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/03/2003</DD>
 * </DL>
 * <DL>
 * <DT><B>Alterada em:</B>
 * <DD>01/02/2004</DD>
 * </DL>
 * 
 * @author Alex Takaoka - atakaoka@sao.politec.com.br
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data: 21/06/2004
 */
public class ISOResultSigcb extends ISOResult {

    private String[] fieldsLayout;

    private ISOResultSigcb thisObjectLayout2;

    private ISOResultSigcb thisObjectLayout3;

    /**
     * @see br.com.politec.sao.business.Result#Result(BusinessObject, String[])
     *      Construtor default, invoca o construtor da classe mão com os
     *      parâmetros.
     */
    public ISOResultSigcb(BusinessObject prototype,
            String[] fields) {
        super(prototype, fields);
        this.fieldsLayout = fields;
    }

    /**
     * @see br.com.politec.sao.business.Result#Result(BusinessObject, String[])
     *      Construtor default, invoca o construtor da classe mãe com os
     *      parâmetros, e cria uma instância do objeto ISOResultSIGCB para
     *      controle de outro objeto.
     */
    public ISOResultSigcb(BusinessObject prototype,
            String[] fields,
            String[] fields2) {
        super(prototype, fields);
        this.fieldsLayout = fields;
        thisObjectLayout2 = new ISOResultSigcb(prototype, fields2);
    }

    /**
     * @see br.com.politec.sao.business.Result#Result(BusinessObject, String[])
     *      Construtor default, invoca o construtor da classe mão com os
     *      parâmetros, e cria uma instância do objeto ISOResultSIGCB para
     *      controle de outro objeto.
     */
    public ISOResultSigcb(BusinessObject prototype,
            String[] fields,
            String[] fields2,
            String[] fields3) {
        super(prototype, fields);
        this.fieldsLayout = fields;
        thisObjectLayout2 = new ISOResultSigcb(prototype, fields2);
        thisObjectLayout3 = new ISOResultSigcb(prototype, fields3);
    }

    /**
     * Método para controlar o parsing dos objetos, a partir das mensagems
     * ISO8583. Pode ser utilizado para fazer o parsing de pacotes sem dados
     * fixos iniciais e um ou mais recordsets.
     * 
     * @param responses
     *            Mensagems com o conteúdo dos beans.
     * @return BeanList Lista de beans obtidos após o parsing.
     * @throws WrappingException
     *             Caso seja reportado pelo mainframe algum erro codificado no
     *             bit 120 da mensagem.
     */
    public BeanList getBeansSigcb(ISOMsg[] responses) throws WrappingException,
            SigcbException {

        final BeanList result = new BeanList(getPrototype().getLayout());
        for (int i = 1; i < responses.length; i++) {
            final ISOMsg message = responses[i];
            checkError(message);
            addMessage(result, message.getString(62).toUpperCase());
        }
        return result;
    }

    /**
     * Método que invoca o parsing do objeto solicitado, e o adiciona na lista
     * de retorno.
     * 
     * @param beans
     *            Lista para manipulação.
     * @param bit62
     *            String correspondente a lista de beans.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     */
    private void addMessage(BeanList beans, String bit62) throws EJBException {
        final SubstringTokenizer tokenizer = new SubstringTokenizer(bit62);
        final int length = getFieldsLength();
        while (tokenizer.hasNext(length)) {
            final String bitISO = tokenizer.getNext(length);
            beans.add(getBean(bitISO));
        }
    }

    /**
     * Método para controlar o parsing dos objetos, a partir das mensagems
     * ISO8583. Pode ser utilizado para fazer o parsing de pacotes que contem
     * dados fixos iniciais e logo após apenas um recordset.
     * 
     * @param responses
     *            Mensagems com o conteúdo dos beans.
     * @return List Coleções de BeanList obtidos após o parsing.
     * @throws WrappingException
     *             Caso seja reportado pelo mainframe algum erro codificado no
     *             bit 120 da mensagem.
     */
    public List getBeansFixSigcb(ISOMsg[] responses) throws WrappingException,
            SigcbException {

        final BeanList result = new BeanList(getPrototype().getLayout());
        final BeanList result2 = new BeanList(thisObjectLayout2.getPrototype().getLayout());
        int countPackage;
        for (countPackage = 1; countPackage < (responses.length - 1); countPackage++) {
            final ISOMsg message = responses[countPackage];
            checkError(message);
            addMessageFixRecordset(result2, message.getString(62));
        }
        final ISOMsg lastPackage = responses[countPackage];
        checkError(lastPackage);
        addMessageFix(result, lastPackage.getString(62));
        List listBean = new ArrayList();
        listBean.add(result);
        listBean.add(result2);
        return listBean;
    }

    /**
     * Método que invoca o parsing do objeto solicitado, e o adiciona na lista
     * de retorno.
     * 
     * @param beans
     *            Lista para manipulação.
     * @param bit62
     *            String correspondente a lista de beans.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     */
    private void addMessageFixRecordset(BeanList beans2, String bit62)
            throws EJBException {
        final int lengthRecordset = thisObjectLayout2.getFieldsLength();
        final SubstringTokenizer tokenizerRecordset = new SubstringTokenizer(bit62);
        while (tokenizerRecordset.hasNext(lengthRecordset)) {
            final String bitISO2 = tokenizerRecordset.getNext(lengthRecordset);
            beans2.add(thisObjectLayout2.getBean(bitISO2));
        }
    }

    /**
     * Método para controlar o parsing dos objetos, a partir das mensagems
     * ISO8583. Pode ser utilizado para fazer o parsing de pacotes que contem
     * dados fixos iniciais e logo após apenas um recordset.
     * 
     * @param responses
     *            Mensagems com o conteúdo dos beans.
     * @return List Coleções de BeanList obtidos após o parsing.
     * @throws WrappingException
     *             Caso seja reportado pelo mainframe algum erro codificado no
     *             bit 120 da mensagem.
     */
    public List getBeansFixDoubleRecordsetSigcb(ISOMsg[] responses)
            throws WrappingException, SigcbException {

        final BeanList result = new BeanList(getPrototype().getLayout());
        final BeanList result2 = new BeanList(thisObjectLayout2.getPrototype()
                .getLayout());
        final BeanList result3 = new BeanList(thisObjectLayout3.getPrototype()
                .getLayout());
        int countPackage;
        for (countPackage = 1; countPackage < (responses.length - 1); countPackage++) {
            final ISOMsg message = responses[countPackage];
            checkError(message);
            addMessageFixDoubleRecordset(result2,
                    result3,
                    message.getString(62).toUpperCase());
        }
        final ISOMsg lastPackage = responses[countPackage];
        checkError(lastPackage);
        addMessageFix(result, lastPackage.getString(62).toUpperCase());
        List listBean = new ArrayList();
        listBean.add(result);
        listBean.add(result2);
        listBean.add(result3);
        return listBean;
    }

    /**
     * Método que invoca o parsing do objeto solicitado, e o adiciona na lista
     * de retorno.
     * 
     * @param beans
     *            Lista para manipulação.
     * @param bit62
     *            String correspondente a lista de beans.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     */
    private void addMessageFixDoubleRecordset(BeanList beans2,
            BeanList beans3,
            String bit62) throws EJBException, WrappingException {
        final int lengthRecordset2 = thisObjectLayout2.getFieldsLength();
        final int lengthRecordset3 = thisObjectLayout3.getFieldsLength();
        String dados = new String(bit62);
        String dadosRecordset1 = "";
        String dadosRecordset2 = "";
        int pacoteValido = lengthRecordset2 > lengthRecordset3
                ? lengthRecordset3
                : lengthRecordset2;
        while (pacoteValido < dados.length()) {
            if (dados.startsWith("T")) {
                dadosRecordset1 = dados.substring(1, lengthRecordset2 + 1);
                dados = dados.substring(lengthRecordset2 + 1, dados.length());
                beans2.add(thisObjectLayout2.getBean(dadosRecordset1));
            } else if (dados.startsWith("D")) {
                dadosRecordset2 = dados.substring(1, lengthRecordset3 + 1);
                dados = dados.substring(lengthRecordset3 + 1, dados.length());
                beans3.add(thisObjectLayout3.getBean(dadosRecordset2));
            } else {
                throw new WrappingException(new Exception("Tipo de Dados inválido"));
            }
        }
    }

    /**
     * Método para controlar o parsing dos objetos, a partir das mensagems
     * ISO8583. Pode ser utilizado para fazer o parsing de pacotes que contem
     * dados fixos iniciais e logo após apenas um recordset.
     * 
     * @param responses
     *            Mensagems com o conteúdo dos beans.
     * @return List Coleções de BeanList obtidos após o parsing.
     * @throws WrappingException
     *             Caso seja reportado pelo mainframe algum erro codificado no
     *             bit 120 da mensagem.
     */
    public List getBeansDoubleRecordsetSigcb(ISOMsg[] responses)
            throws WrappingException, SigcbException {

        final BeanList result2 = new BeanList(thisObjectLayout2.getPrototype()
                .getLayout());
        final BeanList result3 = new BeanList(thisObjectLayout3.getPrototype()
                .getLayout());
        int countPackage;
        for (countPackage = 1; countPackage < responses.length; countPackage++) {
            final ISOMsg message = responses[countPackage];
            checkError(message);
            addMessageDoubleRecordset(result2, result3, message.getString(62)
                    .toUpperCase());
        }
        List listBean = new ArrayList();
        listBean.add(result2);
        listBean.add(result3);
        return listBean;
    }

    /**
     * Método que invoca o parsing do objeto solicitado, e o adiciona na lista
     * de retorno.
     * 
     * @param beans
     *            Lista para manipulação.
     * @param bit62
     *            String correspondente a lista de beans.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     */
    private void addMessageDoubleRecordset(BeanList beans2,
            BeanList beans3,
            String bit62) throws EJBException, WrappingException {
        final int lengthRecordset2 = thisObjectLayout2.getFieldsLength();
        final int lengthRecordset3 = thisObjectLayout3.getFieldsLength();
        String dados = new String(bit62);
        String dadosRecordset1 = "";
        String dadosRecordset2 = "";
        int pacoteValido = lengthRecordset2 > lengthRecordset3
                ? lengthRecordset3
                : lengthRecordset2;
        while (pacoteValido < dados.length()) {
            if (dados.startsWith("T")) {
                dadosRecordset1 = dados.substring(1, lengthRecordset2 + 1);
                dados = dados.substring(lengthRecordset2 + 1, dados.length());
                beans2.add(thisObjectLayout2.getBean(dadosRecordset1));
            } else if (dados.startsWith("D")) {
                dadosRecordset2 = dados.substring(1, lengthRecordset3 + 1);
                dados = dados.substring(lengthRecordset3 + 1, dados.length());
                beans3.add(thisObjectLayout3.getBean(dadosRecordset2));
            } else {
                throw new WrappingException(new Exception("Tipo de Dados inválido"));
            }
        }
    }

    /**
     * Método que invoca o parsing do objeto solicitado, e o adiciona na lista
     * de retorno.
     * 
     * @param beans
     *            Lista para manipulação.
     * @param bit62
     *            String correspondente a lista de beans.
     * @throws EJBException
     *             Caso ocorra algum erro não previsto.
     */
    private void addMessageFix(BeanList beans, String bit62)
            throws EJBException {
        final SubstringTokenizer tokenizer = new SubstringTokenizer(bit62);
        final int length = getFieldsLength();
        final String bitISO = tokenizer.getNext(length);
        beans.add(getBean(bitISO));
    }

    /**
     * Verifica a resposta do bit 39 da mensagem. Caso retorne "99", o sistema
     * gerará uma SigcbException buscando a mensagem de erro no Bit 120.
     * 
     * @param message
     *            Mensagem a ser verificada.
     * @throws SigcbException
     *             Caso exista algum erro reportado, é criada e propagada a
     *             excessão.
     */
    private void checkError(ISOMsg message) throws SigcbException {
        if ((message.getString(39) != null)
            && (message.getString(39).equals("10")
                || message.getString(39).equals("98") || message.getString(39)
                    .equals("99"))) {
            throw new SigcbException(new Exception(message.getString(120)));
        }
    }

    /**
     * Método que invoca o serviço de parsing individual de objetos.
     * 
     * @param bitISO
     *            String de dados de um único bean.
     * @return BusinessObject Objeto preenchido com os dados da String, passada
     *         como parametro.
     */
    private BusinessObject getBean(String bitISO) {
        return ((ISOParser) getParser()).getBean(bitISO);
    }

    /**
     * Obtem o tamanho da somatória dos campos do objeto.
     * 
     * @return int A soma que sera utilizada no parsing das Strings contendo os
     *         dados dos objetos.
     */
    private int getFieldsLength() {
        return ((ISOParser) getParser()).getFieldsLength();
    }

}