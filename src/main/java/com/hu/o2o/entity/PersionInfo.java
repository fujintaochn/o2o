package com.hu.o2o.entity;

import lombok.Data;

import java.util.Date;


@Data
public class PersionInfo {
    private Long userId;

    private String name;

    private String profileImg;

    private String email;

    private String gender;

    private Integer enableStatus;

    private Integer userType;

    private Date createTime;

    private Date lastEditTime;
}
