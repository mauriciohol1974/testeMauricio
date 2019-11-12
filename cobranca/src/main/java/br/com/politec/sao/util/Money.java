package br.com.politec.sao.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Money extends ValueObject implements Appendable, Comparable {
    private static final BigDecimal zero = BigDecimal.valueOf(0);

    private static final int[] cents = new int[] { 1, 10, 100, 1000 };

    private final BigDecimal amount;

    private final Currency currency;

    public Money(double amount,
            Currency currency) {
        Assertions.requires(currency != null);
        this.currency = currency;
        this.amount = new BigDecimal(amount);
    }

    public Money(long amount,
            Currency currency) {
        Assertions.requires(currency != null);
        this.currency = currency;
        this.amount = new BigDecimal(amount);
    }

    public Money(String amount,
            Currency currency) {
        Assertions.requires(currency != null);
        this.currency = currency;
        this.amount = new BigDecimal(amount);
    }

    public Money(String amount,
            int decimalPlaces,
            Currency currency) {
        this(placeDecimalSeparator(amount, decimalPlaces), currency);
    }

    public static Money reais(double amount) {
        return new Money(amount, Currency.real());
    }

    public static Money reais(String amount) {
        return new Money(amount, Currency.real());
    }

    private static String placeDecimalSeparator(String amount, int decimalPlaces) {
        if (amount.indexOf('.') == -1) {
            int commaIndex = amount.length() - decimalPlaces;
            StringBuffer result = new StringBuffer(amount.length() + 1);
            result.append(amount.substring(0, commaIndex));
            result.append('.');
            result.append(amount.substring(commaIndex));
            return result.toString();
        } else {
            return amount;
        }
    }

    public int getCentFactor() {
        return cents[getCurrency().getFractionDigits()];
    }

    public boolean isNegative() {
        return this.amount.compareTo(zero) < 0;
    }

    public long getIntegerAmount() {
        return this.amount.longValue();
    }

    public long getDecimalAmount() {
        BigInteger shifted = this.amount.movePointRight(getCurrency().getFractionDigits())
                .toBigInteger();
        BigInteger multiplied = this.amount.toBigInteger()
                .multiply(new BigInteger("" + getCentFactor()));
        return shifted.subtract(multiplied).longValue()
               * (isNegative() ? -1 : 1);
    }

    public int digits() {
        return Utils.digits(getIntegerAmount());
    }

    public long getAmount() {
        return this.amount.longValue();
    }

    public BigDecimal toBigDecimal() {
        return this.amount;
    }

    public double toDouble() {
        return this.amount.doubleValue();
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public String toString() {
        StringAppender result = new StringAppender();
        try {
            if (isNegative()) {
                result.append("(");
            }
            result.append(getCurrency().getSymbol());
            result.append(" ");
            appendTo(result);
            if (isNegative()) {
                result.append(")");
            }
        } catch (IOException exc) {
            Assertions.unreacheable();
        }
        return result.getText();
    }

    public void appendTo(Appender out) throws IOException {
        Assertions.requires(out != null);
        new MoneyFormat().formatOn(out, this);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Money other = (Money) obj;
            return getCurrency().equals(other.getCurrency())
                   && (getAmount() == other.getAmount());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) (getAmount() ^ getAmount() >>> 32);
    }

    public int compareTo(Object obj) {
        if (super.equals(obj)) {
            Money other = (Money) obj;
            int result = getCurrency().compareTo(other.getCurrency());
            if (result == 0) {
                result = Utils.unit(getAmount() - other.getAmount());
            }
            return result;
        } else {
            return +1;
        }
    }

    public boolean greaterThan(Money other) {
        return (compareTo(other) > 0);
    }

    public boolean lessThan(Money other) {
        return (compareTo(other) < 0);
    }
}