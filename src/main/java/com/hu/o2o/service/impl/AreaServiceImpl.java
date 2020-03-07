package com.hu.o2o.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hu.o2o.cache.JedisUtil;
import com.hu.o2o.dao.AreaDao;
import com.hu.o2o.entity.Area;
import com.hu.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Autowired
    private JedisUtil.Keys jedisKeys;

    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String AREALISTKEY = "arealist";

    @Override
    public List<Area> getAreaList() {
        String key = AREALISTKEY;
        List<Area> areaList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if (!jedisKeys.exists(key)) {
            areaList = areaDao.queryArea();
            String jsonString = null;
            try {
                jsonString = objectMapper.writeValueAsString(areaList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisStrings.set(key, jsonString);
        } else {
            String jsonString = jedisStrings.get(key);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
            try {
                areaList = objectMapper.readValue(jsonString, javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return areaList;
    }

}
