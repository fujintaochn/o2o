package com.hu.o2o.service;

import com.hu.o2o.BaseTest;
import com.hu.o2o.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCategoryServiceTest extends BaseTest {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void testAddProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(10L);
        productCategory.setProductCategoryName("打折促销");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());

        productCategoryService.addProductCategory(productCategory);
    }

    @Test
    public void testQueryProduct() {
        long shopId = 10L;
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList = productCategoryService.queryProductCategory(shopId);
        Assert.assertEquals(4, productCategoryList.size());
    }
}
