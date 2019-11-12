package br.com.politec.sao.util;

import java.util.Enumeration;
import java.util.Iterator;

public class Enumerator implements Enumeration {
    private final Iterator iterator;

    public Enumerator(Iterator iterator) {
        Assertions.requires(iterator != null);
        this.iterator = iterator;
    }

    public boolean hasMoreElements() {
        return this.iterator.hasNext();
    }

    public Object nextElement() {
        return this.iterator.next();
    }
}
