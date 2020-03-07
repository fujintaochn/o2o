package com.hu.o2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCategory {
    private Long productCategoryId;
    private Long shopId;
    private String productCategoryName;
    private Integer priority;
    private Date createTime;
}
