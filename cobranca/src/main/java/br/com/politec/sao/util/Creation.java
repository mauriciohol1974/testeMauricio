package br.com.politec.sao.util;

public interface Creation {
    public Object create(Object key);

    public boolean updateIsNeeded(Object key, Object value);
}
