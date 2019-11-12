package br.com.politec.sao.util;

public class PageableArray extends Pageable {
    private final Object[] array;

    public PageableArray(Object[] array) {
        Assertions.requires(array != null, "Null array");
        this.array = array;
    }

    public Object get(int index) {
        Assertions.requires((index >= 0) && (size() > index), "Invalid index");
        return this.array[index];
    }

    public int size() {
        return this.array.length;
    }
}