package com.future.redisimplementation.controller;

import com.future.redisimplementation.models.CustomerBean;
import com.future.redisimplementation.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping("customer")
    public CustomerBean saveCustomer(@RequestBody CustomerBean customerBean){
       return  userManager.saveCustomer(customerBean);
    }

    @GetMapping("customer/{customerNumber}")
    public CustomerBean findById(@PathVariable long customerNumber){
        return  userManager.findByCustomerNumber(customerNumber);
    }

    @GetMapping("customer/cache")
    public Map<Object,CustomerBean> getAllCustomerFromCache(){
        return  userManager.getAllCustomerFromCache();
    }

    @PutMapping("customer")
    public CustomerBean updateCustomer(@RequestBody CustomerBean customerBean){
        return  userManager.updateCustomer(customerBean);
    }
}
