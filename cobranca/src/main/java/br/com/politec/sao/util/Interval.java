package br.com.politec.sao.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Interval implements Serializable, Comparable {
    private static final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private final Date start;

    private final Date end;

    public Interval(Date start,
            Date end) {
        Assertions.requires(start != null);
        Assertions.requires(end != null);
        Assertions.requires(start.before(end));
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }

    public boolean overlaps(Interval other) {
        Assertions.requires(other != null);
        if (getStart().after(other.getEnd())
            || getEnd().before(other.getStart())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean envelops(Interval other) {
        Assertions.requires(other != null);
        return (!getStart().after(other.getStart()) && !getEnd().before(other.getEnd()));
    }

    public Interval union(Interval other) {
        Assertions.requires(other != null);
        Interval result = new Interval(min(getStart(), other.getStart()),
                max(getEnd(), other.getEnd()));
        Assertions.ensures(result.envelops(this) && result.envelops(other));
        return result;
    }

    public Interval intersection(Interval other) {
        Assertions.requires(other != null);
        Date start = max(getStart(), other.getStart());
        Date end = min(getEnd(), other.getEnd());
        Interval result = null;
        if (start.before(end)) {
            result = new Interval(start, end);
        }
        Assertions.ensures(overlaps(other) == (result != null));
        if (result != null) {
            Assertions.ensures(envelops(result) && other.envelops(result));
        }
        return result;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append('[');
        result.append(format.format(getStart()));
        result.append(' ');
        result.append(format.format(getEnd()));
        result.append(']');
        return result.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj instanceof Interval)
                   && getClass().equals(obj.getClass())) {
            Interval other = (Interval) obj;
            return getStart().equals(other.getStart())
                   && getEnd().equals(other.getEnd());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getStart().hashCode() ^ getEnd().hashCode();
    }

    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        } else if ((obj instanceof Interval)
                   && getClass().equals(obj.getClass())) {
            Interval other = (Interval) obj;
            int result = getStart().compareTo(other.getStart());
            if (result == 0) {
                result = getEnd().compareTo(other.getEnd());
            }
            return result;
        } else {
            return +1;
        }
    }

    private static Date min(Date first, Date second) {
        return first.before(second) ? first : second;
    }

    private static Date max(Date first, Date second) {
        return first.after(second) ? first : second;
    }
}