package br.com.politec.sao.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConstrainedIterator implements Iterator {
    private final Iterator iterator;

    private final Constraint constraint;

    private Object current;

    private boolean currentExists;

    public ConstrainedIterator(Iterator iterator,
            Constraint constraint) {
        Assertions.requires(iterator != null);
        Assertions.requires(constraint != null);
        this.iterator = iterator;
        this.constraint = constraint;
        this.current = null;
        this.currentExists = false;
    }

    public boolean hasNext() {
        if (currentExists()) {
            return true;
        } else {
            moveNext();
            return currentExists();
        }
    }

    private void moveNext() {
        Assertions.requires(!this.currentExists);
        clearCurrent();
        while (this.iterator.hasNext()) {
            this.current = iterator.next();
            if (this.constraint.constrains(this.current)) {
                this.currentExists = true;
                return;
            } else {
                clearCurrent();
            }
        }
    }

    private void clearCurrent() {
        this.current = null;
        this.currentExists = false;
    }

    private boolean currentExists() {
        return currentExists;
    }

    public Object next() {
        if (hasNext()) {
            Object result = this.current;
            clearCurrent();
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        this.iterator.remove();
    }
}