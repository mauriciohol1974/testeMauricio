package br.com.politec.sao.util;

import java.io.IOException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Representa um Percentual
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class Percentual extends ValueObject implements Appendable, Comparable {

    private char decimalSeparator = ',';

    private Double valor = new Double(0);

    public Percentual(double valor) {
        this.valor = new Double(valor);
    }

    public Percentual(String valor) {
        if (valor == null || valor.trim().equals("")) {
            this.valor = new Double(0);
        } else {
            this.valor = new Double(valor);
        }
        // LogUtilSigcb.debug("============ CRIANDO PERCENTUAL COM O VALOR : "+
        // valor +" ======================");
    }

    public Double toDouble() {
        return this.valor;
    }

    public double toDoubleValue() {
        return this.valor.doubleValue();
    }

    public String toValorSemPonto() {
        return String.valueOf(this.toDouble().longValue())
               + this.getDecimalAmountString();
    }

    public String toString() {
        if (this.toDouble() == null) {
            return "0,00 %";
        } else {
            return this.toDouble().longValue()
                   + ","
                   + this.getDecimalAmountString()
                   + " %";
        }
    }

    public char getDecimalSeparator() {
        return decimalSeparator;
    }

    public String getDecimalAmountString() {
        String strValor = String.valueOf(this.toDoubleValue());
        String strDecimalAmount = strValor.substring(strValor.indexOf('.') + 1);
        if (strDecimalAmount.length() < 2) {
            strDecimalAmount += "0";
        }
        return strDecimalAmount;
    }

    public void appendTo(Appender out) throws IOException {
        out.append(this.toDouble().longValue());
        out.append(this.getDecimalSeparator());
        out.append(this.getDecimalAmountString());
    }

    public int compareTo(Object obj) {
        Percentual other = (Percentual) obj;
        return this.toDouble().compareTo(other.toDouble());
    }

    public static void main(String[] args) {
        Percentual perc = new Percentual(86400);
        System.out.println(perc);
        /*
         * AL - 30/04/2007 Solicitação SIT em 12/04/2007 - Evitar
         * System.(out|err).print, é recomendado utilizar o sistema de Log.
         */
        // System.out.println(perc.getDecimalAmountString());
    }
}
