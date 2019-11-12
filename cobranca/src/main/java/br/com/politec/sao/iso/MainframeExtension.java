package br.com.politec.sao.iso;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.com.politec.sao.business.Extension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.DoubleValue;
import br.com.politec.sao.iso.values.IntegerValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Extens�o de layout definida para o formato de dados trafegado atrav�s de
 * pacotes ISO8583. Define caracter�sticas de parsing de objetos para os
 * formatos aceitos e tratados pelo ambiente CICS, atrav�s do protocolo de
 * comunica��o tratado pelo sistema legado SIROT.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class MainframeExtension extends Extension {
    /**
     * Campos para parsing.
     */
    private final Map fields;

    /**
     * Construtor default do objeto.
     */
    public MainframeExtension() {
        this.fields = new HashMap();
    }

    /**
     * M�todo getType.
     * 
     * @see br.com.politec.sao.business.Extension#getType() Retorna um nome para
     *      identificar o tipo de extens�o que est� sendo tratada.
     * @return <code>"Mainframe"</code>
     */
    public String getType() {
        return "Mainframe";
    }

    /**
     * M�todo properties. Retorna a lista de propriedades a ser convertida em
     * tipos.
     * 
     * @return Lista de propriedades a ser convertida em tipos.
     */
    public Iterator properties() {
        return this.fields.keySet().iterator();
    }

    /**
     * M�todo put. Adiciona um atributo a lista de atributos do tipo mainframe.
     * 
     * @param propertyName
     *            Nome da propriedade a ser adicionada.
     * @param value
     *            Valor da propriedade a ser adicionada.
     */
    public void put(String propertyName, MainframeValue value) {
        this.fields.put(propertyName, value);
    }

    /**
     * M�todo get. Obtem o tipo correto de atributo instanciado a partir do nome
     * que identifica o valor na lista de atributos.
     * 
     * @param propertyName
     *            Identificador do atributo na lista.
     * @return Objeto do tipo correspondente instanciado.
     */
    public MainframeValue get(String propertyName) {
        return (MainframeValue) this.fields.get(propertyName);
    }

    /**
     * M�todo getLength. Retorna o tamanho total do pacote ISO8583 composto
     * pelos atributos da lista.
     * 
     * @param fields
     *            Lista de atributos passada como par�metro para calculo do
     *            tamanho.
     * @return Tamanho calculado da lista de atributos.
     */
    public int getLength(String[] fields) {
        int result = 0;
        for (int i = 0; i < fields.length; i++) {
            result += get(fields[i]).getLength();
        }
        return result;
    }

    /**
     * M�todo getFieldsCount. Contagem de campos da lista de atributos.
     * 
     * @return Quantidade de campos da lista.
     */
    public int getFieldsCount() {
        return this.fields.size();
    }

    /**
     * M�todo getLength. Retorna o tamanho total da lista de campos. O tamanho
     * calculado se refere ao layout de pacote ISO8583, SIROT CAIXA.
     * 
     * @return Tamanho total calculado.
     */
    public int getLength() {
        int result = 0;
        for (final Iterator i = properties(); i.hasNext();) {
            final String name = (String) i.next();
            result += get(name).getLength();
        }
        return result;
    }

    /**
     * M�todo getPrinter. Forma a string ISO8583 correspondente a lista de
     * campos.
     * 
     * @param fields
     *            Lista de campos para composi��o da String ISO8583.
     * @return String no formato ISO8583 desejado.
     */
    public ISOPrinter getPrinter(String[] fields) {
        return new ISOPrinter(fields);
    }

    /**
     * M�todo getValue. Retorna um tipo valido de atributo a partir dos
     * parametros. Instancia um dos formatos suportados pela framework, a partir
     * da String que fornece a representa��o de dados.
     * 
     * @param name
     *            Nome do tipo desejado.
     * @param format
     *            Valor para cria��o do tipo.
     * @return Tipo instanciado.
     */
    public MainframeValue getValue(String name, String format) {
        MainframeValue result = null;
        if (name.equals("String")) {
            result = new StringValue(format);
        } else if (name.equals("Integer")) {
            result = new IntegerValue(format);
        } else if (name.equals("Double")) {
            result = new DoubleValue(format);
        } else if (name.equals("Date")) {
            result = new DateValue(format);
        } else if (name.equals("Long")) {
            result = new LongValue(format);
        } else if (name.equals("Money")) {
            result = new MoneyValue(format);
        } else if (name.equals("Percentual")) {
            result = new PercentualValue(format);
        }
        return result;
    }
}