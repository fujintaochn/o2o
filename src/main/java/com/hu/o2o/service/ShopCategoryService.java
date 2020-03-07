package com.hu.o2o.service;

import com.hu.o2o.entity.Area;
import com.hu.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}