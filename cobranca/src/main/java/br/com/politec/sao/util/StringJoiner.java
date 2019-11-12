package br.com.politec.sao.util;

class StringJoiner extends IterativeProcess {
    protected final StringBuffer text;

    private final String joint;

    public StringJoiner(String joint) {
        this.text = new StringBuffer();
        this.joint = (joint == null) ? "" : joint;
    }

    protected void doBefore() {
        this.text.setLength(0);
    }

    protected void doOnlyOne(Object item) {
        this.text.append(item);
    }

    protected void doFirst(Object item) {
        doOnlyOne(item);
    }

    protected void doEach(Object item) {
        this.text.append(this.joint);
        doOnlyOne(item);
    }

    protected void doLast(Object item) {
        doEach(item);
    }

    protected void doNone() {
    }

    public String getText() {
        return this.text.toString();
    }
}