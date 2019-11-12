package br.gov.caixa.sigcb.util;

import java.io.Serializable;
import java.util.HashMap;

import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe criada para manter as informações necessárias para o parsing dos
 * pacotes ISO8583 pela framework. O dados são mantidos e organizados por
 * transação, identificando se o layoute é relativo a subida da mensagem
 * "XXXX-IDA", ou a descida da mensagem "XXXX-VOLTA".
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/02/2004</DD>
 * </DL>
 * 
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data: 21/06/2004
 */
public class FieldsByTransaction implements Serializable {

    /**
     * Mantém os dados relativos ao layoute de dados das multi transações.
     */
    public final HashMap listMultiTransaction = new HashMap();

    /**
     * Mantém os dados relativos ao layoute de dados das transações simples.
     */
    public final HashMap listSimpleTransaction = new HashMap();

    /**
     * Mantém os dados relativos ao layoute de dados das transações com
     * Recordset.
     */
    public final HashMap listFixDataRecordsetTransaction = new HashMap();

    /**
     * Mantém os dados relativos ao layoute de dados das transações com 2
     * Recordset.
     */
    public final HashMap listFixDataDoubleRecordsetTransaction = new HashMap();

    /**
     * @see java.lang.Object#Object() Construtor default, que inicializa os
     *      objetos HashMaps com todos os dados necessários sobre os layouts de
     *      transação.
     */
    public FieldsByTransaction() {
    }

    public String[] getLayoutMultiTransaction(String key) {
        if (listMultiTransaction.get(key) == null) {
            setLayout(key);
        }
        return (String[]) listMultiTransaction.get(key);
    }

    public String[] getLayoutSimpleTransaction(String key) {
        if (listSimpleTransaction.get(key) == null) {
            setLayout(key);
        }
        return (String[]) listSimpleTransaction.get(key);
    }

    public String[] getLayoutFixDataRecordsetTransaction(String key) {
        if (listFixDataRecordsetTransaction.get(key) == null) {
            setLayout(key);
        }
        return (String[]) listFixDataRecordsetTransaction.get(key);
    }

    public String[] getLayoutFixDataDoubleRecordsetTransaction(String key) {
        if (listFixDataDoubleRecordsetTransaction.get(key) == null) {
            setLayout(key);
        }
        return (String[]) listFixDataDoubleRecordsetTransaction.get(key);
    }

    public void setLayout(String key) {
        LayoutTransaction layout = (LayoutTransaction) getLayoutFromClass(key.substring(0,
                4));
        layout.setLayout(this);
    }

    public Object getLayoutFromClass(String nameClass) {
        try {
            Class klass = Class.forName(Paths.getRootPackageTransaction()
                                        + "."
                                        + nameClass);
            return klass.newInstance();
        } catch (ClassNotFoundException e) {
            throw new WrappingException(e);
        } catch (InstantiationException e) {
            throw new WrappingException(e);
        } catch (IllegalAccessException e) {
            throw new WrappingException(e);
        }
    }
}