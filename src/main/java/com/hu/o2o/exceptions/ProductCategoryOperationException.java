package com.hu.o2o.exceptions;


public class ProductCategoryOperationException extends RuntimeException {

    private static final long serialVersionUID = 8258313211007840836L;

    public ProductCategoryOperationException(String msg) {
        super(msg);
    }
}
