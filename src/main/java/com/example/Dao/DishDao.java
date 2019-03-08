package com.example.Dao;

import com.example.Model.Dish;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */
public interface DishDao {

    Dish DishGet(int id);

    List<Dish> DishList();

    void DishDelete(int id);

    void DishUpdate(Dish dish);

    void DishInsert(Dish dish);
}
