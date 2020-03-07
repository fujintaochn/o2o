package com.hu.o2o.service;

import com.hu.o2o.BaseTest;
import com.hu.o2o.dto.ImageHolder;
import com.hu.o2o.dto.ShopExecution;
import com.hu.o2o.entity.Area;
import com.hu.o2o.entity.PersionInfo;
import com.hu.o2o.entity.Shop;
import com.hu.o2o.entity.ShopCategory;
import com.hu.o2o.enums.ShopStateEnum;
import com.hu.o2o.exceptions.ShopOperationException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;


    @Test
    public void testAddShop() throws FileNotFoundException {
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
        shop.setShopName("一点点testService4");
        shop.setShopDesc("test");
        shop.setShopAddr("testAddr");
        shop.setPhone("testphone");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:/Development/projectRepository/image/yddLogo.jpg");
        InputStream is = new FileInputStream(shopImg);

        ImageHolder imageHolder = new ImageHolder("yddLogo.jpg", is);
        ShopExecution result = shopService.addShop(shop, imageHolder);
        Assert.assertEquals(ShopStateEnum.CHECK.getState(), result.getState());

    }

    @Test
    public void testModifyShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(14L);
        shop.setShopName("测试修改店铺");
        File shopImg = new File("D:/Development/projectRepository/image/HeyTea.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
        ShopExecution result = shopService.modifyShop(shop, imageHolder);
        System.out.println(result.getShop().getShopImg());

    }

    @Test
    public void testGetShopList(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition, 5, 3);
        System.out.println(se.getShopList().size());
        System.out.println(se.getCount());

    }
}
