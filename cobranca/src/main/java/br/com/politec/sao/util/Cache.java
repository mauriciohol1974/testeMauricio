package br.com.politec.sao.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cache implements Map {
    private final Map items;

    private final Creation creator;

    public Cache(Creation creator) {
        Assertions.requires(creator != null);
        this.creator = creator;
        this.items = new HashMap();
    }

    public int size() {
        return this.items.size();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.items.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.items.containsValue(value);
    }

    public synchronized Object get(Object key) {
        if (this.items.get(key) == null) {
            this.items.put(key, this.creator.create(key));
        } else if (this.creator.updateIsNeeded(key, this.items.get(key))) {
            this.items.put(key, this.creator.create(key));
        }
        return this.items.get(key);
    }

    public synchronized Object put(Object key, Object value) {
        Object result = this.items.get(key);
        if (this.creator.updateIsNeeded(key, value)) {
            this.items.put(key, this.creator.create(key));
        } else {
            this.items.put(key, value);
        }
        return result;
    }

    public Object remove(Object key) {
        return this.items.remove(key);
    }

    public void putAll(Map other) {
        for (Iterator i = other.keySet().iterator(); i.hasNext();) {
            Object key = i.next();
            put(key, other.get(key));
        }
    }

    public void clear() {
        this.items.clear();
    }

    public Set keySet() {
        return this.items.keySet();
    }

    public Collection values() {
        return this.items.values();
    }

    public Set entrySet() {
        return this.items.entrySet();
    }
}