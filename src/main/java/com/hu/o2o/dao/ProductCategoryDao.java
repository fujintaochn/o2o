package com.hu.o2o.dao;

import com.hu.o2o.entity.ProductCategory;
import com.hu.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {

    /**
     * 插入商品分类信息
     * @param productCategory
     * @return
     */
    int insertProductCategory(ProductCategory productCategory);

    /**
     * 根据shopId查询该店铺中的商品分类信息
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategory(long shopId);

    /**
     * 批量添加商品分类
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除商品分类信息
     * @param productCategoryId
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

}
