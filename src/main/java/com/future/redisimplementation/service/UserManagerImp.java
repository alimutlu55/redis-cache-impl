package com.future.redisimplementation.service;

import com.future.redisimplementation.models.CustomerBean;
import com.future.redisimplementation.repository.ICustomerDal;
import org.springframework.beans.BeanUtils;
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
    public CustomerBean saveCustomer(CustomerBean customerBean) {
        customerBean.setInsertDate(new Date(System.currentTimeMillis()));
        return customerDal.save(customerBean);
    }

    @Override
    public CustomerBean findByCustomerNumber(long customerNumber) {
        CustomerBean customerBean = (CustomerBean) cacheManager.getValueFromCache(customerNumber);
        if(customerBean == null){
            customerBean = customerDal.findByCustomerNumber(customerNumber).get();
            cacheManager.putToCash(customerBean);
        }
        return customerBean;
    }

    @Override
    public Map<Object,CustomerBean> getAllCustomerFromCache() {
        return cacheManager.getMapAsAll();
    }

    @Override
    public CustomerBean updateCustomer(CustomerBean customerBean) {
        CustomerBean entity = customerDal.findByCustomerNumber(customerBean.getCustomerNumber()).get();
        BeanUtils.copyProperties(customerBean, entity,new String[]{"id","insertDate"});
        cacheManager.putToCash(entity);
        return customerDal.save(entity);
    }


}
