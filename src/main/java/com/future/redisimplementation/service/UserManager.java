package com.future.redisimplementation.service;

import com.future.redisimplementation.models.CustomerBean;

import java.util.Map;

public interface UserManager {
    CustomerBean save(CustomerBean customerBean);
    CustomerBean findById(long id);
    Map<Object,CustomerBean> getAllCustomerFromCache();
}
