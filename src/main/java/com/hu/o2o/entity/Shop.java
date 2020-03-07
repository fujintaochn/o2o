package com.hu.o2o.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Shop {
    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private Integer enableStatus;
    private String advice;
    private Area area;
    private PersionInfo owner;
    private ShopCategory shopCategory;
}
