package br.com.politec.sao.util;

import java.io.Serializable;

public abstract class ValueObject implements Serializable {
    public ValueObject() {
        super();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj instanceof ValueObject)
                   && getClass().equals(obj.getClass())) {
            return true;
        } else {
            return false;
        }
    }

    protected final boolean equals(Object first, Object second) {
        if (first == second) {
            return true;
        } else if ((first == null) || (second == null)) {
            return false;
        } else {
            return first.equals(second);
        }
    }

    protected final boolean equals(byte first, byte second) {
        return first == second;
    }

    protected final boolean equals(short first, short second) {
        return first == second;
    }

    protected final boolean equals(int first, int second) {
        return first == second;
    }

    protected final boolean equals(long first, long second) {
        return first == second;
    }

    protected final boolean equals(char first, char second) {
        return first == second;
    }

    protected final boolean equals(boolean first, boolean second) {
        return first == second;
    }

    protected final boolean equals(Object[] first, Object[] second) {
        if (first == second) {
            return true;
        } else if ((first == null) || (second == null)) {
            return false;
        } else if (first.length == second.length) {
            return hasEqualItems(first, second);
        } else {
            return false;
        }
    }

    private boolean hasEqualItems(Object[] first, Object[] second) {
        boolean result = true;
        for (int i = 0; i < first.length; i++) {
            if (!equals(first[i], second[i])) {
                result = false;
                break;
            }
        }
        return result;
    }

    protected final boolean equals(float first, float second) {
        if (Float.isNaN(first) && Float.isNaN(second)) {
            return true;
        } else {
            return first == second;
        }
    }

    protected final boolean equals(double first, double second) {
        if (Double.isNaN(first) && Double.isNaN(second)) {
            return true;
        } else {
            return first == second;
        }
    }
}