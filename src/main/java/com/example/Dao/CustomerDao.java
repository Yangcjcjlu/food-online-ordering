package com.example.Dao;

import com.example.Model.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by ThinkPad on 2019/1/6.
 */
public interface CustomerDao {


    void insertCustomer(Customer customer);



    List<Customer> selectCustomer(Customer customer);
}