package com.future.redisimplementation.service;

import com.future.redisimplementation.models.CustomerBean;

import java.util.Map;

public interface UserManager {
    CustomerBean saveCustomer(CustomerBean customerBean);
    CustomerBean findByCustomerNumber(long customerNumber);
    Map<Object,CustomerBean> getAllCustomerFromCache();
    CustomerBean updateCustomer(CustomerBean customerBean);
}
