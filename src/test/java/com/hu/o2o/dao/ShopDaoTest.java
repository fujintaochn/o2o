package com.hu.o2o.dao;

import com.hu.o2o.BaseTest;
import com.hu.o2o.entity.Area;
import com.hu.o2o.entity.PersionInfo;
import com.hu.o2o.entity.Shop;
import com.hu.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersionInfo owner = new PersionInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("一点点test");
        shop.setShopDesc("test");
        shop.setShopAddr("testAddr");
        shop.setPhone("testphone");
        shop.setShopImg("testImg");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();

        shop.setShopId(1L);
        shop.setLastEditTime(new Date());
        shop.setShopDesc("test_updateTest");
        shop.setShopAddr("testAddr_updateTest");

        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testQueryByShopId() {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getArea().getAreaName());
    }

    @Test
    public void testQueryShopListAndCount(){
        Shop shopCondition=new Shop();
        PersionInfo owner=new PersionInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表大小：" + shopList.size());
        System.out.println(count);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        shopCondition.setShopCategory(shopCategory);
        shopList = shopDao.queryShopList(shopCondition, 0, 5);
        count = shopDao.queryShopCount(shopCondition);
        System.out.println(shopList.size());
        System.out.println(count);

    }
}