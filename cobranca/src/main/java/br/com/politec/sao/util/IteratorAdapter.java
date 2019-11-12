package br.com.politec.sao.util;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdapter implements Iterator {
    private final Enumeration enumeration;

    public IteratorAdapter(Enumeration enumeration) {
        Assertions.requires(enumeration != null);
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    public Object next() {
        return this.enumeration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
