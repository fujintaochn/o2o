package com.hu.o2o.dto;

import com.hu.o2o.entity.Shop;
import com.hu.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;
@Data
public class ShopExecution {
    //result
    private int state;
    //status
    private String stateInfo;
    //shop amount
    private int count;
    //操作的shop
    private Shop shop;
    //shop列表
    private List<Shop> shopList;

    public ShopExecution() {

    }
    //操作失败时的构造器
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //操作成功时的构造器
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }
    //操作成功时的构造器 返回列表
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

}
