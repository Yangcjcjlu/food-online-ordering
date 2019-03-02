package com.example.Dao;

import com.example.Model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ThinkPad on 2019/1/6.
 */

public interface CustomerDao {


    void insertCustomer(Customer customer);

    List<Customer> selectCustomer(Customer customer);

    void delete(int id);

    void update(Customer customer);

    Customer get( int id);

    Customer get(@Param("name") String name);

    boolean isExist(String name);

}