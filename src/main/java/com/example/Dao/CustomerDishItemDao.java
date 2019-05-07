package com.example.Dao;

import com.example.Model.CustomerDishItem;
import com.example.Model.DishItem;

/**
 * Created by ThinkPad on 2019/4/29.
 */
public interface CustomerDishItemDao {

    void insert(CustomerDishItem dishItem);

    void update(CustomerDishItem dishItem);
}
