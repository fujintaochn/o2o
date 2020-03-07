package com.hu.o2o.dao;

import com.hu.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);


    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 查询商铺信息
     * @param shopId
     * @return Shop
     */
    Shop queryByShopId(long shopId);

    /**
     * 分页查询店铺，参数 店铺名（模糊查询），店铺状态， 店铺类别， 区域id， owner
     * @param shopCondition 查询条件
     * @param rowIndex 从第几行数据开始
     * @param pageSize 返回条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex")int rowIndex,
                             @Param("pageSize")int pageSize);

    /**
     * 返回查询结果总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
}
