package br.com.politec.sao.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author Glauber M. Gallego - Data 31/08/2004 Implementacao do metodo
 *         getPage(int pageNumber)
 */

public class PageHolder2 implements Serializable {
    private final Pageable pageable;

    private int pageNumber = 0;

    private int pageSize = 2000;

    public PageHolder2(Pageable pageable) {
        Assertions.requires(pageable != null, "Null pageable");
        this.pageable = pageable;
    }

    public PageHolder2(Pageable pageable,
            int pageSize) {
        this(pageable);
        setPageSize(pageSize);
    }

    public List getPage() {
        List result = pageable.getPage(getPageFirstIndex(), getPageLastIndex());
        Assertions.ensures(result.size() == getCurrentPageSize());
        return result;
    }

    // GMG: seta o numero da pagina e obtem a pagina
    public List getPage(int pageNumber) {
        setPageNumber(pageNumber);
        return (getPage());
    }

    public int getCurrentPageSize() {
        return getPageLastIndex() - getPageFirstIndex();
    }

    public int getPageFirstIndex() {
        return getPageNumber() * getPageSize();
    }

    public Object getItemAtCurrentPage(int indexAtCurrentPage) {
        Assertions.requires(indexAtCurrentPage >= 0, "Index smaller than zero!");
        Assertions.requires(indexAtCurrentPage < getCurrentPageSize(),
                "Index greater than current page size ["
                        + getCurrentPageSize()
                        + "]");
        return this.pageable.get(getPageFirstIndex() + indexAtCurrentPage);
    }

    public int getPageLastIndex() {
        int result = getPageFirstIndex() + getPageSize();
        if (this.pageable.size() < result) {
            result = pageable.size();
        }
        return result;
    }

    public int getPageCount() {
        int result = (getPageableSize() % getPageSize() == 0)
                ? (getPageableSize() / getPageSize())
                : (getPageableSize() / getPageSize()) + 1;
        Assertions.ensures(result * getPageSize() >= getPageableSize(),
                "Invalid page count");
        return result;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        Assertions.requires(pageNumber >= 0, "Negative page number");
        Assertions.requires(pageNumber < getPageCount(),
                "Page number must be lesser than getPageCount()");
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        Assertions.requires(pageSize > 0, "Page size must be greater than 0");
        this.pageSize = pageSize;
    }

    public int getPageableSize() {
        return this.pageable.size();
    }

    public Pageable getPageable() {
        return pageable;
    }

}