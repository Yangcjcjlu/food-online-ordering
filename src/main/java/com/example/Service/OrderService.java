package com.example.Service;

import com.example.Dao.OrderDao;
import com.example.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */

@Service("OrderService")
public class OrderService implements OrderDao {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order OrderGet(int id) {
        return this.orderDao.OrderGet(id);
    }

    @Override
    public List<Order> OrderList() {
        return this.orderDao.OrderList();
    }

    @Override
    public void OrderDelete(Order order) {
        this.orderDao.OrderDelete(order);
    }

    @Override
    public void OrderInsert(Order order) {
        this.orderDao.OrderInsert(order);
    }

    @Override
    public void OrderUpdate(Order order) {
        this.orderDao.OrderUpdate(order);
    }
}
