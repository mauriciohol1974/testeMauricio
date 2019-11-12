package br.com.politec.sao.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Pageable implements Serializable {
    public abstract Object get(int index);

    public abstract int size();

    public List getPage(int begin, int end) {
        Assertions.requires(begin <= end, "Invalid range ["
                                          + begin
                                          + ".."
                                          + end
                                          + "]!");
        Assertions.requires((0 <= begin) && (begin < size()),
                "Begin must be between [0.." + size() + "]!");
        int pageEnd = size() < end ? size() : end;
        ArrayList result = new ArrayList(pageEnd - begin);
        for (int i = begin; i < pageEnd; i++) {
            result.add(get(i));
        }
        Assertions.ensures(result.size() == pageEnd - begin,
                "Invalid page size");
        return result;
    }
}