package br.com.politec.sao.util;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Currency implements Comparable, Serializable {
    private static final Map currencies = new TreeMap();

    private final String symbol;

    private final int fractionDigits;

    private final String fractionSeparator;

    private final String groupSeparator;

    private Currency(String symbol,
            int fractionDigits,
            String fractionSeparator,
            String groupSeparator) {
        Assertions.requires(symbol != null);
        Assertions.requires(fractionDigits >= 0);
        Assertions.requires(fractionSeparator != null);
        Assertions.requires(groupSeparator != null);
        this.symbol = symbol;
        this.fractionDigits = fractionDigits;
        this.fractionSeparator = fractionSeparator;
        this.groupSeparator = groupSeparator;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getFractionDigits() {
        return this.fractionDigits;
    }

    public String getGroupSeparator() {
        return this.groupSeparator;
    }

    public String getFractionSeparator() {
        return this.fractionSeparator;
    }

    public String toString() {
        return getSymbol();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj instanceof Currency)
                   && getClass().equals(obj.getClass())) {
            Currency other = (Currency) obj;
            return getSymbol().equals(other.getSymbol());
        } else {
            return false;
        }
    }

    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        } else if ((obj instanceof Currency)
                   && getClass().equals(obj.getClass())) {
            Currency other = (Currency) obj;
            return getSymbol().compareTo(other.getSymbol());
        } else {
            return +1;
        }
    }

    public int hashCode() {
        return getSymbol().hashCode() ^ getFractionDigits();
    }

    public static Currency get(String symbol) {
        Assertions.requires(symbol != null);
        return (Currency) currencies.get(symbol);
    }

    public synchronized static Currency real() {
        return get("R$");
    }

    static {
        currencies.put("R$", new Currency("R$", 2, ",", "."));
        currencies.put("US$", new Currency("US$", 2, ".", ","));
    }
}
