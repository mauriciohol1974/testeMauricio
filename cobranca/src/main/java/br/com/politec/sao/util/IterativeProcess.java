package br.com.politec.sao.util;

import java.util.Iterator;

public abstract class IterativeProcess {
    public IterativeProcess() {
    }

    public final void iterateOver(Iterator iterator) {
        Assertions.requires(iterator != null);
        doBefore();
        if (iterator.hasNext()) {
            Object item = iterator.next();
            if (iterator.hasNext()) {
                doFirst(item);
                while (iterator.hasNext()) {
                    item = iterator.next();
                    if (iterator.hasNext()) {
                        doEach(item);
                    } else {
                        doLast(item);
                    }
                }
            } else {
                doOnlyOne(item);
            }
        } else {
            doNone();
        }
        doAfter();
    }

    protected void doAfter() {
    }

    protected void doBefore() {
    }

    protected void doOnlyOne(Object item) {
    }

    protected void doFirst(Object item) {
    }

    protected void doEach(Object item) {
    }

    protected void doLast(Object item) {
    }

    protected void doNone() {
    }
}