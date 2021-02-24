package com.future.redisimplementation.service;

import com.future.redisimplementation.models.CustomerBean;
import com.future.redisimplementation.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class CustomerCacheImpl implements CacheManager {
    public static final String TABLE_CUSTOMER = "TABLE_CUSTOMER";
    public static final String CUSTOMER = "CUSTOMER_";
    private RedisUtil<CustomerBean> redisUtilCustomer;

    @Autowired
    public CustomerCacheImpl(RedisUtil<CustomerBean> redisUtilCustomer) {
        this.redisUtilCustomer = redisUtilCustomer;
    }

    @Override
    public void putToCash(Object object) {
        CustomerBean customerBean = (CustomerBean) object;
        redisUtilCustomer.putMap(TABLE_CUSTOMER,CUSTOMER+customerBean.getId(),customerBean);
        redisUtilCustomer.setExpire(TABLE_CUSTOMER,1, TimeUnit.DAYS);
    }


    public CustomerBean getValueFromCache(Long id) {
        return redisUtilCustomer.getMapAsSingleEntry(TABLE_CUSTOMER,CUSTOMER+id);
    }

    @Override
    public Map<Object, CustomerBean> getMapAsAll() {
        return redisUtilCustomer.getMapAsAll(TABLE_CUSTOMER);
    }

}

