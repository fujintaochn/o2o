package com.hu.o2o.dao;

import com.hu.o2o.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
