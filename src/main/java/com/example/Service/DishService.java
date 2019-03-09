package com.example.Service;

import com.example.Dao.DishDao;
import com.example.Model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */
@Service("DishService")
public class DishService implements DishDao {

    @Autowired
    private DishDao dishDao;

    @Override
    public Dish DishGet(int id) {
        return this.dishDao.DishGet(id);
    }

    @Override
    public List<Dish> DishList() {
        return this.dishDao.DishList();
    }

    @Override
    public void DishDelete(int id) {
        this.dishDao.DishDelete(id);
    }

    @Override
    public void DishUpdate(Dish dish) {
        this.dishDao.DishUpdate(dish);
    }

    @Override
    public void DishInsert(Dish dish) {
        this.dishDao.DishInsert(dish);
    }

    @Override
    public boolean isExist(Dish dish) {
        if(this.dishDao.DishGet(dish.getId())!=null){
            return true;
        }
        return false;
    }
}
