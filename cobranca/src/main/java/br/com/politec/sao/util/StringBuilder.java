package br.com.politec.sao.util;

public class StringBuilder extends StringJoiner {
    public StringBuilder() {
        super(", ");
    }

    protected void doBefore() {
        super.doBefore();
        this.text.append("{");
    }

    protected void doAfter() {
        this.text.append("}");
        super.doAfter();
    }
}