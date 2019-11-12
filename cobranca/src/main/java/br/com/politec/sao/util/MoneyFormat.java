package br.com.politec.sao.util;

import java.io.IOException;

// GMG 16.05.2005: tratamento paliativo para inserir o sinal de negativo para os casos de numeros 
//                 maiores que 999 e inteiros iguais a zero.   

public class MoneyFormat {
    public MoneyFormat() {
        super();
    }

    public void formatOn(Appender out, Money cash) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(cash != null);
        if (cash.digits() > 3) {
            if (cash.isNegative())
                out.append("-");
            appendFormattedIntegerPartOn(out, cash);
        } else {
            if (cash.isNegative() && cash.getIntegerAmount() >= 0)
                out.append("-");
            out.append(cash.getIntegerAmount());
        }
        appendNeededFractionDigitsOn(out, cash);
    }

    private void appendFormattedIntegerPartOn(Appender out, Money cash)
            throws IOException {
        char[] integerDigits = Utils.toCharDigits(cash.toBigDecimal()
                .toBigInteger());
        int i = 0;
        switch (integerDigits.length % 3) {
        case 0:
            out.append(integerDigits[i++]);
            out.append(integerDigits[i++]);
            out.append(integerDigits[i++]);
            break;
        case 1:
            out.append(integerDigits[i++]);
            break;
        case 2:
            out.append(integerDigits[i++]);
            out.append(integerDigits[i++]);
            break;
        default:
            Assertions.unreacheable();
        }
        while (i < integerDigits.length) {
            out.append(cash.getCurrency().getGroupSeparator());
            out.append(integerDigits[i++]);
            out.append(integerDigits[i++]);
            out.append(integerDigits[i++]);
        }
    }

    public void appendNeededFractionDigitsOn(Appender out, Money cash)
            throws IOException {
        if (cash.getCurrency().getFractionDigits() > 0) {
            out.append(cash.getCurrency().getFractionSeparator());
            out.append(cash.getDecimalAmount(), cash.getCurrency()
                    .getFractionDigits());
        }
    }
}