package com.hu.o2o.dao;

import com.hu.o2o.BaseTest;
import com.hu.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        Assert.assertEquals(2,areaList.size());
    }
}