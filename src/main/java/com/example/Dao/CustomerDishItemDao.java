package com.example.Dao;

import com.example.Model.CustomerDishItem;
import com.example.Model.DishItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ThinkPad on 2019/4/29.
 */
public interface CustomerDishItemDao {

    void insert(CustomerDishItem dishItem);

    void update(CustomerDishItem dishItem);

    List<DishItem> list(@Param("id") int id);

    CustomerDishItem select(@Param("mid") int mid,@Param("cid") int cid,@Param("did")int did);

    void delete(@Param("id")int id);
}
