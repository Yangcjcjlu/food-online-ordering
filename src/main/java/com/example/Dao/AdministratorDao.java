package com.example.Dao;

import com.example.Model.Administrator;
import com.example.Model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ThinkPad on 2019/1/6.--
 */

public interface AdministratorDao {


    void insert(Administrator administrator);
//
//    List<Customer> CustomerList();
//
//    List<Customer> selectCustomer(Customer customer);
//
//    void delete(@Param("id") int id);
//
//    void update(Customer customer);
//
//    Customer get(int id);

    Administrator get(@Param("name") String name);

    boolean isExist(String name);

}