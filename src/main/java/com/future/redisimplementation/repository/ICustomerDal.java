package com.future.redisimplementation.repository;

import com.future.redisimplementation.models.CustomerBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerDal extends JpaRepository<CustomerBean,Long> {
    @Override
    Optional<CustomerBean> findById(Long aLong);
}
