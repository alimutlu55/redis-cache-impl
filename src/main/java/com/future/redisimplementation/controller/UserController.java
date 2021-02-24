package com.future.redisimplementation.controller;

import com.future.redisimplementation.models.CustomerBean;
import com.future.redisimplementation.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping("customer")
    public CustomerBean saveCustomer(@RequestBody CustomerBean customerBean){
       return  userManager.save(customerBean);
    }

    @GetMapping("customer/{id}")
    public CustomerBean findById(@PathVariable long id){
        return  userManager.findById(id);
    }

    @GetMapping("customer/cache")
    public Map<Object,CustomerBean> getAllCustomerFromCache(){
        return  userManager.getAllCustomerFromCache();
    }

}
