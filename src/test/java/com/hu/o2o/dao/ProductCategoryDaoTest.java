package com.hu.o2o.dao;

import com.hu.o2o.BaseTest;
import com.hu.o2o.entity.ProductCategory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@FixMethodOrder
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(10L);
        productCategory.setProductCategoryName("解馋小食");
        productCategory.setPriority(5);
        productCategory.setCreateTime(new Date());

        productCategoryDao.insertProductCategory(productCategory);
    }

    @Test
    public void testQueryProductCategory() {
        long shopId=10L;
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList = productCategoryDao.queryProductCategory(shopId);
        Assert.assertEquals(4, productCategoryList.size());
    }

    @Test
    public void testBatchInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("批量测试0");
        productCategory.setPriority(5);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);

        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("批量测试1");
        productCategory1.setPriority(6);
        productCategory1.setCreateTime(new Date());
        productCategory1.setShopId(1L);
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory1);
        int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        Assert.assertEquals(2, effectNum);
    }

    @Test
    public void testDeleteProductCategory() {
        long shopId = 1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategory(shopId);
        for (ProductCategory pc : productCategoryList) {
            if ("批量测试0".equals(pc.getProductCategoryName()) || "批量测试1".equals(pc.getProductCategoryName())) {
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), pc.getShopId());
                Assert.assertEquals(1, effectedNum);
            }
        }

    }
}
