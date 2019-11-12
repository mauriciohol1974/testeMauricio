package br.com.politec.sao.util;

import java.util.Arrays;
import java.util.Collection;

import org.apache.regexp.RE;
import org.apache.regexp.RESyntaxException;

public class StringUtils {
    private static final String[] hexString = {
                                               "00",
                                               "01",
                                               "02",
                                               "03",
                                               "04",
                                               "05",
                                               "06",
                                               "07",
                                               "08",
                                               "09",
                                               "0A",
                                               "0B",
                                               "0C",
                                               "0D",
                                               "0E",
                                               "0F",
                                               "10",
                                               "11",
                                               "12",
                                               "13",
                                               "14",
                                               "15",
                                               "16",
                                               "17",
                                               "18",
                                               "19",
                                               "1A",
                                               "1B",
                                               "1C",
                                               "1D",
                                               "1E",
                                               "1F" };

    private StringUtils() {
    }

    public static final String[] splitAt(String delimiter, String text) {
        Assertions.requires(delimiter != null);
        Assertions.requires(text != null);
        String[] result = new String[countOf(delimiter, text) + 1];
        int lastIndex = 0;
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            index = text.indexOf(delimiter, lastIndex);
            if (index == -1) {
                result[i] = text.substring(lastIndex);
            } else {
                result[i] = text.substring(lastIndex, index);
                lastIndex = index + delimiter.length();
            }
        }
        return result;
    }

    public static final String quote(String text) {
        return new StringBuffer(text.length() + 2).append("\"")
                .append(text)
                .append("\"")
                .toString();
    }

    public static final int countOf(String piece, String text) {
        Assertions.requires(piece != null);
        Assertions.requires(text != null);
        int result = 0;
        for (int i = -1; (i = text.indexOf(piece, i + 1)) > -1; result++)
            ;
        return result;
    }

    public static final String remove(char c, String text) {
        Assertions.requires(text != null);
        StringBuffer result = new StringBuffer(text.length());
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != c) {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    public static final String join(Object[] array, String joint) {
        Assertions.requires(array != null);
        return join(Arrays.asList(array), joint);
    }

    public static final String join(Collection collection, String joint) {
        Assertions.requires(collection != null);
        StringJoiner joiner = new StringJoiner(joint);
        joiner.iterateOver(collection.iterator());
        return joiner.getText();
    }

    public static final String remove(String part, String text) {
        Assertions.requires(text != null);
        if ((part == null) || part.equals("")) {
            return text;
        } else {
            return join(splitAt(part, text), "");
        }
    }

    public static String times(String text, int times) {
        Assertions.requires(text != null);
        Assertions.requires(times > 0);
        StringBuffer result = new StringBuffer(text.length() * times);
        for (int i = 0; i < times; i++) {
            result.append(text);
        }
        return result.toString();
    }

    public static String[] split(String text, int length) {
        Assertions.requires(text != null);
        Assertions.requires(length > 0);
        int count = ((text.length() % length) > 0)
                ? ((text.length() / length) + 1)
                : (text.length() / length);
        String[] result = new String[count];
        SubstringTokenizer tokenizer = new SubstringTokenizer(text);
        for (int i = 0; i < result.length; i++) {
            int tokenLength = tokenizer.hasNext(length)
                    ? length
                    : tokenizer.getRemaining();
            result[i] = tokenizer.getNext(tokenLength);
        }
        return result;
    }

    public static final String normalized(String text) {
        Assertions.requires(text != null);
        try {
            String result = text.trim();
            RE spaces = new RE("( )+");
            RE endOfLine = new RE("\\r\\n|\\r|\\n");
            result = spaces.subst(result, " ");
            result = endOfLine.subst(result, "\n");
            return result;
        } catch (RESyntaxException exc) {
            throw new WrappingException(exc);
        }
    }

    public static final String normalizedWhiteSpace(String text) {
        Assertions.requires(text != null);
        try {
            RE spaces = new RE("( |\\r|\\n)+");
            return spaces.subst(text.trim(), " ");
        } catch (RESyntaxException exc) {
            throw new WrappingException(exc);
        }
    }

    public static final String normalizedNewLine(String text) {
        Assertions.requires(text != null);
        try {
            RE endOfLine = new RE("\\r\\n|\\r|\\n");
            return endOfLine.subst(text, "\n");
        } catch (RESyntaxException exc) {
            throw new WrappingException(exc);
        }
    }

    public static String escaped(String text) {
        String result = null;
        if (text != null) {
            StringBuffer buffer = new StringBuffer(text.length());
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                switch (c) {
                case '\t':
                    buffer.append("\\t");
                    break;
                case '\n':
                    buffer.append("\\n");
                    break;
                case '\f':
                    buffer.append("\\f");
                    break;
                case '\r':
                    buffer.append("\\r");
                    break;
                case '\\':
                    buffer.append("\\\\");
                    break;
                default:
                    appendEscapedChar(buffer, c);
                }
            }
            result = buffer.toString();
        }
        return result;
    }

    private static void appendEscapedChar(StringBuffer buffer, char c) {
        if (c < 32) {
            buffer.append("\\u00");
            buffer.append(hexString[c]);
        } else {
            buffer.append(c);
        }
    }
}