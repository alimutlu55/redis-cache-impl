package com.future.redisimplementation.service;

import com.future.redisimplementation.models.CustomerBean;
import com.future.redisimplementation.repository.ICustomerDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UserManagerImp implements UserManager {

    private ICustomerDal customerDal;
    private CacheManager cacheManager;

    @Autowired
    public UserManagerImp(ICustomerDal customerDal, CacheManager cacheManager) {
        this.customerDal = customerDal;
        this.cacheManager = cacheManager;
    }

    @Override
    public CustomerBean save(CustomerBean customerBean) {
        customerBean.setInsertDate(new Date(System.currentTimeMillis()));
        return customerDal.save(customerBean);
    }

    @Override
    public CustomerBean findById(long id) {
        CustomerBean customerBean = (CustomerBean) cacheManager.getValueFromCache(id);
        if(customerBean == null){
            customerBean = customerDal.findById(id).get();
            cacheManager.putToCash(customerBean);
        }
        return customerBean;
    }

    @Override
    public Map<Object,CustomerBean> getAllCustomerFromCache() {
        return cacheManager.getMapAsAll();
    }


}
