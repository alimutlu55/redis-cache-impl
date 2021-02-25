package com.future.redisimplementation.service;

import java.util.Map;

public interface CacheManager <T> {
    void putToCash(T object);
    Object getValueFromCache(Long customerNumber);
    Map<Object,Object> getMapAsAll();
}
