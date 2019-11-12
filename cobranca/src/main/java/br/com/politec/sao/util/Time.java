package br.com.politec.sao.util;

import java.io.IOException;

import org.apache.regexp.RE;

/**
 * Esta classe deve ser usada apenas com dados do tipo Time, no formato HH:MM.
 * Não substitui java.util.Date ou java.util.Calendar, mas um modo de gerenciar
 * momentos no tempo não tão específicos (e.g.: hora de abertura de uma loja dia
 * à dia, não o momento em que ela foi aberta num determinado dia). <BR>
 * Valores de tempo válidos vão de 00:00 à 23:59 (1439 minutos).
 * 
 * @author Marcelo Luchesi - mluchesi@sao.politec.com.br
 */
public class Time extends ValueObject implements Appendable, Comparable {
    private static final RE regExp = loadRegExp();

    private final int minutes;

    /**
     * Construtor para Time.
     */
    public Time() {
        this(0);
    }

    public Time(Integer timeInMinutes) {
        this(timeInMinutes.intValue());
    }

    public Time(int timeInMinutes) {
        Assertions.requires(isValid(timeInMinutes), "Time in minutes "
                                                    + timeInMinutes
                                                    + " not in [0 .. 1440[");
        this.minutes = timeInMinutes;
        checkInvariant();
    }

    public Time(int hour,
            int minute) {
        Assertions.requires((hour >= 0) && (hour < 24), "Hour "
                                                        + hour
                                                        + " not in [0 .. 24[");
        Assertions.requires((minute >= 0) && (minute < 60),
                "Minute " + minute + " not in [0 .. 60[");
        this.minutes = (hour * 60) + minute;
        checkInvariant();
    }

    public Time(String value) {
        Assertions.requires(isValid(value),
                "Value [" + value + "] not in format HH:MM or in format MMMM.");
        this.minutes = getTimeInMinutes(value);
        checkInvariant();
    }

    public void checkInvariant() {
        Assertions.invariant(isValid(getTimeInMinutes()));
    }

    public static boolean isValid(String value) {
        if (!regExp.match(value)) {
            return false;
        }
        int timeInMinutes = getTimeInMinutes(value);
        return ((timeInMinutes >= 0) && (timeInMinutes < 1440));
    }

    public static boolean isValid(Integer timeInMinutes) {
        return isValid(timeInMinutes.intValue());
    }

    public static boolean isValid(int timeInMinutes) {
        return (timeInMinutes >= 0) && (timeInMinutes < 1440);
    }

    public void appendTo(Appender out) throws IOException {
        Assertions.requires(out != null);
        out.append(getHour(), 2);
        out.append(":");
        out.append(getMinute(), 2);
    }

    public int compareTo(Object obj) {
        if (super.equals(obj)) {
            Time other = (Time) obj;
            return (this.getTimeInMinutes() - other.getTimeInMinutes());
        } else {
            return +1;
        }
    }

    public int getHour() {
        return (this.minutes / 60);
    }

    public int getMinute() {
        return (this.minutes % 60);
    }

    public int getTimeInMinutes() {
        return this.minutes;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Time other = (Time) obj;
            return (this.getTimeInMinutes() == other.getTimeInMinutes());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) (getTimeInMinutes() ^ getTimeInMinutes() >>> 32);
    }

    public boolean greaterThan(Time other) {
        return (compareTo(other) > 0);
    }

    public boolean lessThan(Time other) {
        return (compareTo(other) < 0);
    }

    public String toString() {
        StringAppender result = new StringAppender();
        try {
            appendTo(result);
        } catch (IOException exc) {
            Assertions.unreacheable();
        }
        return result.getText();
    }

    private static final RE loadRegExp() {
        try {
            return new RE("(^\\d{1,2}:\\d{2}$)|(^\\d{1,4}$)");
        } catch (Exception exc) {
            throw new WrappingException(exc);
        }
    }

    private static int getTimeInMinutes(String value) {
        int timeInMinutes;
        if (value.indexOf(':') == -1) {
            timeInMinutes = Integer.parseInt(value);
        } else {
            String[] parts = StringUtils.splitAt(":", value);
            timeInMinutes = getTimeInMinutes(parts);
        }
        return timeInMinutes;
    }

    private static int getTimeInMinutes(String[] parts) {
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return (hour * 60 + minute);
    }
}