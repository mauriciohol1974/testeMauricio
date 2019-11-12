package br.com.politec.sao.util;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

public class Utils {
    private static final long[] factors = new long[20];

    public static final char ZERO = '0';

    public static final char NINE = '9';
    static {
        for (int i = 0; i < factors.length; i++) {
            factors[i] = pow(10, i);
        }
    }

    public static final boolean hasOnlyDigits(String number) {
        boolean result = !number.equals("");
        for (int i = 0; i < number.length(); i++) {
            if ((number.charAt(i) < ZERO) || (number.charAt(i) > NINE)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static final long pow(long base, int exponent) {
        Assertions.requires(exponent >= 0);
        return (long) Math.pow(base, exponent);
    }

    public static final char[] toCharDigits(long number) {
        return (number < 0)
                ? String.valueOf(number).substring(1).toCharArray()
                : String.valueOf(number).toCharArray();
    }

    public static final char[] toCharDigits(BigInteger number) {
        return number.abs().toString().toCharArray();
    }

    public static final int unit(long number) {
        return number < 0 ? -1 : (number > 0 ? +1 : 0);
    }

    public static final int unit(int number) {
        return number < 0 ? -1 : (number > 0 ? +1 : 0);
    }

    public static final int digitAt(long number, int position) {
        Assertions.requires((position >= 1) && (position <= digits(number)),
                "Invalid digit position! "
                        + position
                        + "not between [1.."
                        + digits(number)
                        + "]!");
        int result = 0;
        long magnitude = pow(10, digits(number) - position);
        result = (int) ((number % (magnitude * 10)) / magnitude);
        Assertions.ensures(result >= 0);
        return result;
    }

    public static final long magnitude(long number) {
        if (number < 0) {
            if (number == Long.MIN_VALUE) {
                return 1000000000000000000L;
            } else {
                number = -number;
            }
        }
        if (number < 10L) {
            return 1;
        } else if (number < 100L) {
            return 10L;
        } else if (number < 1000L) {
            return 100L;
        } else if (number < 10000L) {
            return 1000L;
        } else if (number < 100000L) {
            return 10000L;
        } else if (number < 1000000L) {
            return 100000L;
        } else if (number < 10000000L) {
            return 1000000L;
        } else if (number < 100000000L) {
            return 10000000L;
        } else if (number < 1000000000L) {
            return 100000000L;
        } else if (number < 10000000000L) {
            return 1000000000L;
        } else if (number < 100000000000L) {
            return 10000000000L;
        } else if (number < 1000000000000L) {
            return 100000000000L;
        } else if (number < 10000000000000L) {
            return 1000000000000L;
        } else if (number < 100000000000000L) {
            return 10000000000000L;
        } else if (number < 1000000000000000L) {
            return 100000000000000L;
        } else if (number < 10000000000000000L) {
            return 1000000000000000L;
        } else if (number < 100000000000000000L) {
            return 10000000000000000L;
        } else if (number < 1000000000000000000L) {
            return 100000000000000000L;
        } else {
            return 1000000000000000000L;
        }
    }

    public static final int magnitude(int number) {
        if (number < 0) {
            if (number == Integer.MIN_VALUE) {
                return 1000000000;
            } else {
                number = -number;
            }
        }
        if (number < 10) {
            return 1;
        } else if (number < 100) {
            return 10;
        } else if (number < 1000) {
            return 100;
        } else if (number < 10000) {
            return 1000;
        } else if (number < 100000) {
            return 10000;
        } else if (number < 1000000) {
            return 100000;
        } else if (number < 10000000) {
            return 1000000;
        } else if (number < 100000000) {
            return 10000000;
        } else if (number < 1000000000) {
            return 100000000;
        } else {
            return 1000000000;
        }
    }

    public static final int digits(long number) {
        if (number < 0) {
            if (number == Long.MIN_VALUE) {
                return 19;
            } else {
                number = -number;
            }
        }
        if (number < 10L) {
            return 1;
        } else if (number < 100L) {
            return 2;
        } else if (number < 1000L) {
            return 3;
        } else if (number < 10000L) {
            return 4;
        } else if (number < 100000L) {
            return 5;
        } else if (number < 1000000L) {
            return 6;
        } else if (number < 10000000L) {
            return 7;
        } else if (number < 100000000L) {
            return 8;
        } else if (number < 1000000000L) {
            return 9;
        } else if (number < 10000000000L) {
            return 10;
        } else if (number < 100000000000L) {
            return 11;
        } else if (number < 1000000000000L) {
            return 12;
        } else if (number < 10000000000000L) {
            return 13;
        } else if (number < 100000000000000L) {
            return 14;
        } else if (number < 1000000000000000L) {
            return 15;
        } else if (number < 10000000000000000L) {
            return 16;
        } else if (number < 100000000000000000L) {
            return 17;
        } else if (number < 1000000000000000000L) {
            return 18;
        } else {
            return 19;
        }
    }

    public static final int digits(int number) {
        if (number < 0) {
            if (number == Integer.MIN_VALUE) {
                return 10;
            } else {
                number = -number;
            }
        }
        if (number < 10) {
            return 1;
        } else if (number < 100) {
            return 2;
        } else if (number < 1000) {
            return 3;
        } else if (number < 10000) {
            return 4;
        } else if (number < 100000) {
            return 5;
        } else if (number < 1000000) {
            return 6;
        } else if (number < 10000000) {
            return 7;
        } else if (number < 100000000) {
            return 8;
        } else if (number < 1000000000) {
            return 9;
        } else {
            return 10;
        }
    }

    public static final int digits(short number) {
        if (number < 0) {
            if (number == Short.MIN_VALUE) {
                return 5;
            } else {
                number = (short) -number;
            }
        }
        if (number < 10) {
            return 1;
        } else if (number < 100) {
            return 2;
        } else if (number < 1000) {
            return 3;
        } else if (number < 10000) {
            return 4;
        } else {
            return 5;
        }
    }

    public static final int digits(byte number) {
        if (number < 0) {
            if (number == Byte.MIN_VALUE) {
                return 3;
            } else {
                number = (byte) -number;
            }
        }
        if (number < 10) {
            return 1;
        } else if (number < 100) {
            return 2;
        } else {
            return 3;
        }
    }

    public static final Object duplicateArray(Object source) {
        Assertions.requires(source.getClass().isArray());
        Class componentType = source.getClass().getComponentType();
        int length = Array.getLength(source);
        Object result = Array.newInstance(componentType, length);
        System.arraycopy(source, 0, result, 0, length);
        Assertions.requires(result.getClass().isArray());
        return result;
    }

    public static final void dump(Object obj) {
        if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            dumpIterator(Arrays.asList(array).iterator());
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            dumpIterator(collection.iterator());
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            dumpIterator(map.entrySet().iterator());
        } else if (obj instanceof Iterator) {
            dumpIterator((Iterator) obj);
        } else if (obj instanceof Object) {
            LogUtilSigcb.info(obj.toString());
        }
    }

    public static final void tryGarbageCollection(int miliseconds) {
        sleep(miliseconds);
        for (int i = 0; i < miliseconds; i++) {
            // TODO RETIRADO CONFORME SOLICITACAO SIT.
            // System.gc();
        }
        sleep(miliseconds);
    }

    public static final String getSingleClassName(Class klass) {
        return getSingleClassName(klass.getName());
    }

    public static final String getSingleClassName(String qualifiedName) {
        int lastPackageSeparator = qualifiedName.lastIndexOf('.');
        return qualifiedName.substring(lastPackageSeparator + 1);
    }

    public static final String getPackageName(Class klass) {
        return getPackageName(klass.getName());
    }

    public static final String getPackageName(String qualifiedName) {
        int lastPackageSeparator = qualifiedName.lastIndexOf('.');
        return qualifiedName.substring(0, lastPackageSeparator);
    }

    private static void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
        }
    }

    private static void dumpIterator(Iterator iterator) {
        StringBuilder builder = new StringBuilder();
        builder.iterateOver(iterator);
        LogUtilSigcb.info(builder.getText());
    }

    public static int divideAndRoundUp(double numerator, double denominator) {
        return (int) Math.ceil(numerator / denominator);
    }

    // Para referencia, ver implementacao java.lang.String.trim()
    public static String rtrim(String str) {
        int len = str.length();
        int st = 0;
        char[] val = str.toCharArray();

        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }

        return str.substring(st, len);
    }

}