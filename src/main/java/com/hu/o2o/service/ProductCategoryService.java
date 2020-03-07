package com.hu.o2o.service;

import com.hu.o2o.entity.ProductCategory;
import com.hu.o2o.dto.ProductCategoryExecution;
import com.hu.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    int addProductCategory(ProductCategory productCategory);

    List<ProductCategory> queryProductCategory(long shopId);

    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;


    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException;
}
