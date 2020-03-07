package com.hu.o2o.service.impl;

import com.hu.o2o.dao.ProductCategoryDao;
import com.hu.o2o.dto.ProductCategoryExecution;
import com.hu.o2o.entity.ProductCategory;
import com.hu.o2o.enums.ProductCategoryStateEnum;
import com.hu.o2o.exceptions.ProductCategoryOperationException;
import com.hu.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    @Transactional
    public int addProductCategory(ProductCategory productCategory) {
        int effectedNum=productCategoryDao.insertProductCategory(productCategory);
        return effectedNum;
    }

    @Override
    public List<ProductCategory> queryProductCategory(long shopId) {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList = productCategoryDao.queryProductCategory(shopId);
        return productCategoryList;
    }



    @Override
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if (productCategoryList != null && productCategoryList.size() > 0) {
            try {
                int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectNum <= 0) {
                    throw new ProductCategoryOperationException("商品类别创建失败");
                } else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }
            } catch (Exception e) {
                throw new ProductCategoryOperationException("batchAddProductCategory error:" + e.getMessage());
            }

        } else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    /**
     * 将商品类别为传入商品类别的商品的类别id置为空，删除该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException {
        //TODO 将商品类别为传入商品类别的商品的类别id置为空
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
        }
    }
}
