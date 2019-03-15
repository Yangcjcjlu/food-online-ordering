package com.example.Dao;

import com.example.Model.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */
public interface DishDao {

    Dish DishGet(int id);

    List<Dish> DishList();

    List<Dish> DishList(@Param("mid") int mid);

    void DishDelete(int id);

    void DishUpdate(Dish dish);

    void DishInsert(Dish dish);

    boolean isExist(Dish dish);
}
