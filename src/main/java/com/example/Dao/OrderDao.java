package com.example.Dao;


import com.example.Model.Order;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */
public interface OrderDao {

    Order OrderGet(int id);

    List<Order> OrderList();

    void OrderDelete(Order order);

    void OrderInsert(Order order);

    void OrderUpdate(Order order);
}
