package com.future.redisimplementation.service;

import com.future.redisimplementation.models.CustomerBean;

import java.util.Map;

public interface CacheManager <T> {
    void putToCash(T object);
    Object getValueFromCache(Long id);
    Map<Object,Object> getMapAsAll();
}
